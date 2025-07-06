package net.azister.azisterweaponsedeco.block;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class DecoOreR extends RotatedPillarBlock {
	public DecoOreR() {
		super(Properties.of()
				.mapColor(MapColor.COLOR_GRAY)
				.strength(0.5F, 3.0F)
				.sound(SoundType.STONE)
		);
	}
}
