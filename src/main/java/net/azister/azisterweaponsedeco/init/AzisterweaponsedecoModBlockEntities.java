
package net.azister.azisterweaponsedeco.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.azister.azisterweaponsedeco.block.entity.CrusherblockBlockEntity;
import net.azister.azisterweaponsedeco.AzisterweaponsedecoMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AzisterweaponsedecoModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AzisterweaponsedecoMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CRUSHERBLOCK = register("crusherblock", AzisterweaponsedecoModBlocks.CRUSHERBLOCK, CrusherblockBlockEntity::new);


	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRUSHERBLOCK.get(), (blockEntity, side) -> ((CrusherblockBlockEntity) blockEntity).getItemHandler());
	}
}
