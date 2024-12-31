package net.azister.azisterweaponsedeco.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.azister.azisterweaponsedeco.network.AzisterweaponsedecoModVariables;

public class AzisterDreamLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getData(AzisterweaponsedecoModVariables.PLAYER_VARIABLES).PlayerTipe != 1) {
			if (sourceentity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 3));
		} else {
			if (sourceentity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1));
		}
		if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 5) {
			if (sourceentity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.DAMAGE_BOOST)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 150, 4));
			} else {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1));
			}
		}
	}
}
