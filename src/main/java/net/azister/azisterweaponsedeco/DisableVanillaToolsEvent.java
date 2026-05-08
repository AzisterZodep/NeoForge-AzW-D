package net.azister.azisterweaponsedeco;

import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

// O modid deve ser o mesmo que está no seu neoforge.mods.toml
@EventBusSubscriber(modid = "azisterweaponsedeco")
public class DisableVanillaToolsEvent {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        ItemStack stack = event.getEntity().getMainHandItem();

        if (stack.getItem() instanceof TieredItem tieredItem) {
            // Desabilita ferramentas de Madeira (WOOD) e Pedra (STONE)
            if (tieredItem.getTier() == Tiers.WOOD || tieredItem.getTier() == Tiers.STONE) {
                event.setNewSpeed(0f);
            }
        }
    }

    @SubscribeEvent
    public static void onDamage(LivingIncomingDamageEvent event) {
        if (event.getSource().getDirectEntity() instanceof net.minecraft.world.entity.player.Player player) {
            ItemStack stack = player.getMainHandItem();

            if (stack.getItem() instanceof TieredItem tieredItem) {
                if (tieredItem.getTier() == Tiers.WOOD || tieredItem.getTier() == Tiers.STONE) {
                    // No NeoForge, você pode reduzir o dano ou cancelar o evento
                    event.setAmount(0.5f);
                }
            }
        }
    }
    @SubscribeEvent
    public static void onHarvestCheck(PlayerEvent.HarvestCheck event) {
        ItemStack stack = event.getEntity().getMainHandItem();

        // Verifica se o jogador está usando a SUA picareta de Flint
        if (stack.is(AzisterweaponsedecoModItems.FLINT_PICKAXE.get())) {
            Block block = event.getTargetBlock().getBlock();

            // Se o bloco for Minério de Cobre ou Cobre de Ardósia, permite o drop
            if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) {
                event.setCanHarvest(true);
            }
        }
    }

    // Adicione também este para a velocidade não ser lenta no cobre
    @SubscribeEvent
    public static void onFlintSpeed(PlayerEvent.BreakSpeed event) {
        ItemStack stack = event.getEntity().getMainHandItem();
        if (stack.is(AzisterweaponsedecoModItems.FLINT_PICKAXE.get())) {
            Block block = event.getState().getBlock();
            if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) {
                // Define uma velocidade aceitável para o cobre
                event.setNewSpeed(2.0f);
            }
        }
    }
    @SubscribeEvent
    public static void onWoodMining(PlayerEvent.BreakSpeed event) {
        // No BreakSpeed, o correto é .getState()
        if (event.getState().is(BlockTags.LOGS)) {
            ItemStack stack = event.getEntity().getMainHandItem();

            if (!(stack.getItem() instanceof AxeItem)) {
                event.setNewSpeed(0.05f);
            }
        }
    }

    @SubscribeEvent
    public static void onWoodHarvest(PlayerEvent.HarvestCheck event) {
        // No HarvestCheck, o correto é .getTargetBlock()
        if (event.getTargetBlock().is(BlockTags.LOGS)) {
            ItemStack stack = event.getEntity().getMainHandItem();

            if (!(stack.getItem() instanceof AxeItem)) {
                event.setCanHarvest(false);
            }
        }
    }
}