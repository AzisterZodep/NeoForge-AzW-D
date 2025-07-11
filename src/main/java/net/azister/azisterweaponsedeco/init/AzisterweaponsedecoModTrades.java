
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.azister.azisterweaponsedeco.init;

import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@EventBusSubscriber
public class AzisterweaponsedecoModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(
				new ItemStack(Items.EMERALD, 2),
				new ItemStack(Items.GOLD_INGOT, 5),
				new ItemStack(AzisterweaponsedecoModBlocks.N_GOLDEN_MARBLE.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(5)
					.add(new BasicItemListing(
							new ItemStack(AzisterweaponsedecoModBlocks.N_GOLDEN_MARBLE_P.get(), 8),
							new ItemStack(Blocks.EMERALD_BLOCK),
							new ItemStack(AzisterweaponsedecoModBlocks.N_HELL_MARBLE.get()), 10, 5, 0.05f));
			event.getTrades().get(5)
					.add(new BasicItemListing(
							new ItemStack(AzisterweaponsedecoModBlocks.N_HELL_MARBLE.get(), 8),
							new ItemStack(Blocks.EMERALD_BLOCK),
							new ItemStack(AzisterweaponsedecoModBlocks.N_JADE.get()), 10, 5, 0.05f));
		}
	}
}
