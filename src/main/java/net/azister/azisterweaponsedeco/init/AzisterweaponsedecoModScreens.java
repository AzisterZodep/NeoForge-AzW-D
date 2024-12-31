
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.azister.azisterweaponsedeco.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.azister.azisterweaponsedeco.client.gui.CrucherScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AzisterweaponsedecoModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(AzisterweaponsedecoModMenus.CRUCHER.get(), CrucherScreen::new);
	}
}
