
package net.azister.azisterweaponsedeco.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.azister.azisterweaponsedeco.entity.AlphyEnergyEntity;
import net.azister.azisterweaponsedeco.AzisterweaponsedecoMod;

public class AzisterweaponsedecoModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, AzisterweaponsedecoMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<AlphyEnergyEntity>> ALPHY_ENERGY = register("alphy_energy",
			EntityType.Builder.<AlphyEnergyEntity>of(AlphyEnergyEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
