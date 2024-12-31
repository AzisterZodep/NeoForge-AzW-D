package net.azister.azisterweaponsedeco.procedures;

import net.minecraft.world.entity.Entity;

import net.azister.azisterweaponsedeco.network.AzisterweaponsedecoModVariables;

public class StarPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			AzisterweaponsedecoModVariables.PlayerVariables _vars = entity.getData(AzisterweaponsedecoModVariables.PLAYER_VARIABLES);
			_vars.PlayerTipe = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
