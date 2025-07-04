package net.azister.azisterweaponsedeco.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModItems;
import net.azister.azisterweaponsedeco.init.AzisterweaponsedecoModBlocks;

import java.util.function.Supplier;
import java.util.Map;

public class CrushItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null) return;
		if (getSlotAmount(entity, 0) > 0 && CheckCrushItemProcedure.execute(entity)) {
			ItemStack slot4Item = getSlotItem(entity, 4);
			ItemStack slot0Item = getSlotItem(entity, 0);
			if (slot4Item.getItem() == Blocks.LANTERN.asItem()) {
				handleLanternRecipes(entity, slot0Item);
			} else if(slot4Item.getItem() == Blocks.STONE.asItem()) {
				handleOresRecipes(entity, slot0Item);
			} else {
				handleSpecialCases(entity, slot0Item);
			}
			removeSlotItem(entity, 0, 1);
		}
	}
	private static void handleOresRecipes(Entity entity, ItemStack slot0Item) {
		switch (slot0Item.getItem().toString()) {
			case "minecraft:raw_iron":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.DECO_IRON_ORE.get()));
				break;
			case "minecraft:raw_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.DECO_COPPER_ORE.get()));
				break;
			case "minecraft:coal":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.DECO_COAL_ORE.get()));
				break;
		}
		removeSlotItem(entity, 4, 1);
	}
	private static void handleLanternRecipes(Entity entity, ItemStack slot0Item) {
		switch (slot0Item.getItem().toString()) {
			case "minecraft:polished_andesite":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_ANDE_LAMP.get()));
				break;
			case "minecraft:smooth_sandstone":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_AREIA_LAMP.get()));
				break;
			case "minecraft:smooth_red_sandstone":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_AREIAV_LAMP.get()));
				break;
			case "minecraft:mud_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_BARRO_LAMP.get()));
				break;
			case "minecraft:waxed_copper_block":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBRE_LAMP.get()));
				break;
			case "minecraft:waxed_exposed_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBRE1_LAMP.get()));
				break;
			case "minecraft:waxed_weathered_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBRE2_LAMP.get()));
				break;
			case "minecraft:waxed_oxidized_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBRE3_LAMP.get()));
				break;
			case "minecraft:waxed_cut_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBREC_LAMP.get()));
				break;
			case "minecraft:waxed_exposed_cut_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBREC1_LAMP.get()));
				break;
			case "minecraft:waxed_weathered_cut_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBREC2_LAMP.get()));
				break;
			case "minecraft:waxed_oxidized_cut_copper":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_COBREC3_LAMP.get()));
				break;
			case "minecraft:polished_blackstone_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_DARK_LAMP.get()));
				break;
			case "minecraft:polished_blackstone":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_DARKP_LAMP.get()));
				break;
			case "minecraft:deepslate_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_DEEP_LAMP.get()));
				break;
			case "minecraft:polished_diorite":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_DIOR_LAMP.get()));
				break;
			case "minecraft:dark_prismarine":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_DPRISM_LAMP.get()));
				break;
			case "minecraft:purpur_block":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_END_P_LAMP.get()));
				break;
			case "azisterweaponsedeco:n_golden_marble_p":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_GOLDEN_MARBLE_LAMP.get()));
				break;
			case "minecraft:polished_granite":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_GRAN_LAMP.get()));
				break;
			case "minecraft:end_stone_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_END_LAMP.get()));
				break;
			case "azisterweaponsedeco:n_hell_marble":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_N_HELL_MARBLE_LAMP.get()));
				break;
			case "minecraft:stone_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_PEDRA_LAMP.get()));
				break;
			case "minecraft:prismarine_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_PRISM_LAMP.get()));
				break;
			case "minecraft:quartz_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_QUARTZ_LAMP.get()));
				break;
			case "minecraft:bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_TIJOLO_LAMP.get()));
				break;
			case "minecraft:tuff_bricks":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModBlocks.BEIRA_TUFO_LAMP.get()));
				break;
		}

		removeSlotItem(entity, 4, 1);
	}

	private static void handleSpecialCases(Entity entity, ItemStack slot0Item) {
		switch (slot0Item.getItem().toString()) {
			case "azisterweaponsedeco:n_golden_marble":
				setOutputSlot(entity, 1, new ItemStack(Items.GOLD_NUGGET));
				setOutputSlot(entity, 2, new ItemStack(Items.QUARTZ));
				setOutputSlot(entity, 3, new ItemStack(Items.GRAY_DYE));
				break;
			case "azisterweaponsedeco:n_hell_marble":
				setOutputSlot(entity, 1, new ItemStack(Items.IRON_NUGGET));
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DEEPSLATE_SHARD.get()));
				setOutputSlot(entity, 3, new ItemStack(Items.MAGENTA_DYE));
				break;
			case "minecraft:yellow_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LAMAR.get()));
				break;
			case "minecraft:blue_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LAZUL.get()));
				break;
			case "minecraft:light_blue_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LAZULZIN.get()));
				break;
			case "minecraft:white_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LBRANCO.get()));
				break;
			case "minecraft:cyan_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LCIAN.get()));
				break;
			case "minecraft:gray_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LCINZA.get()));
				break;
			case "minecraft:light_gray_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LCINZINHA.get()));
				break;
			case "minecraft:orange_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LLARAN.get()));
				break;
			case "minecraft:lime_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LLIMA.get()));
				break;
			case "minecraft:magenta_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LMAGEN.get()));
				break;
			case "minecraft:brown_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LMARR.get()));
				break;
			case "minecraft:black_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LPRETO.get()));
				break;
			case "minecraft:pink_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LROSA.get()));
				break;
			case "minecraft:purple_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LROXO.get()));
				break;
			case "minecraft:green_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LVERD.get()));
				break;
			case "minecraft:red_wool":
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.DRYWALL_LVERM.get()));
				break;
			case "minecraft:nether_star":
				setOutputSlot(entity, 1, new ItemStack(AzisterweaponsedecoModItems.ESENCIA_MORTAL.get()));
				setOutputSlot(entity, 2, new ItemStack(AzisterweaponsedecoModItems.STAR.get()));
				break;
			case "minecraft:ancient_debris":
				setOutputSlot(entity, 1, new ItemStack(Items.NETHERITE_SCRAP, 2));
				setOutputSlot(entity, 2, new ItemStack(Items.GOLD_NUGGET));
				setOutputSlot(entity, 3, new ItemStack(Items.IRON_NUGGET));
				break;
		}
	}

	private static int getSlotAmount(Entity entity, int slotId) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
			ItemStack stack = ((Slot) slots.get(slotId)).getItem();
			return stack != null ? stack.getCount() : 0;
		}
		return 0;
	}

	private static ItemStack getSlotItem(Entity entity, int slotId) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
			return ((Slot) slots.get(slotId)).getItem();
		}
		return ItemStack.EMPTY;
	}

	private static void setOutputSlot(Entity entity, int slotId, ItemStack stack) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
			stack.setCount(1);
			((Slot) slots.get(slotId)).set(stack);
			player.containerMenu.broadcastChanges();
		}
	}

	private static void removeSlotItem(Entity entity, int slotId, int count) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
			((Slot) slots.get(slotId)).remove(count);
			player.containerMenu.broadcastChanges();
		}
	}
}
