
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.azister.azisterweaponsedeco.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.azister.azisterweaponsedeco.world.inventory.CrucherMenu;
import net.azister.azisterweaponsedeco.AzisterweaponsedecoMod;

public class AzisterweaponsedecoModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, AzisterweaponsedecoMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<CrucherMenu>> CRUCHER = REGISTRY.register("crucher", () -> IMenuTypeExtension.create(CrucherMenu::new));
}
