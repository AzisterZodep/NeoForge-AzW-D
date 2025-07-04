package net.azister.azisterweaponsedeco.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DecoOre extends Block {
	public DecoOre() {
		super(BlockBehaviour.Properties.of()
				.mapColor(MapColor.COLOR_GRAY)
				.strength(0.5F, 3.0F)
				.sound(SoundType.STONE)
		);
	}
}
