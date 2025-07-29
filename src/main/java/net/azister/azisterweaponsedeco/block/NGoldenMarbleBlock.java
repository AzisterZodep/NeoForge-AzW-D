
package net.azister.azisterweaponsedeco.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.material.MapColor;

public class NGoldenMarbleBlock extends Block {
	public NGoldenMarbleBlock() {
		super(BlockBehaviour.Properties.of()
				.mapColor(MapColor.COLOR_GRAY)
				.instrument(NoteBlockInstrument.BASEDRUM)
				.sound(SoundType.STONE)
				.strength(4f, 8f)
				.requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
