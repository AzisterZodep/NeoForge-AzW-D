package net.azister.azisterweaponsedeco.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StepsBlock extends Block implements SimpleWaterloggedBlock {
	public static final EnumProperty<StepOrientation> ORIENTATION = EnumProperty.create("orientation", StepOrientation.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public StepsBlock() {
		super(BlockBehaviour.Properties.of()
				.mapColor(MapColor.COLOR_GRAY)
				.instrument(NoteBlockInstrument.BASEDRUM)
				.sound(SoundType.STONE)
				.strength(1f, 4f)
				.noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(ORIENTATION, StepOrientation.DOWN_NORTH)
				.setValue(WATERLOGGED, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ORIENTATION, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean water = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		Direction clicked = context.getClickedFace();
		Direction horizontal = context.getHorizontalDirection();

		StepOrientation orientation;

		if (clicked == Direction.UP) {
			orientation = switch (horizontal) {
				case NORTH -> StepOrientation.UP_NORTH;
				case SOUTH -> StepOrientation.UP_SOUTH;
				case EAST -> StepOrientation.UP_EAST;
				case WEST -> StepOrientation.UP_WEST;
				default -> StepOrientation.UP_NORTH;
			};
		} else {
			orientation = switch (horizontal) {
				case NORTH -> StepOrientation.DOWN_NORTH;
				case SOUTH -> StepOrientation.DOWN_SOUTH;
				case EAST -> StepOrientation.DOWN_EAST;
				case WEST -> StepOrientation.DOWN_WEST;
				default -> StepOrientation.DOWN_NORTH;
			};
		}

		return this.defaultBlockState()
				.setValue(ORIENTATION, orientation)
				.setValue(WATERLOGGED, water);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(ORIENTATION)) {
			case UP_NORTH -> box(0, 0, 8, 16, 8, 16);
			case UP_SOUTH -> box(0, 0, 0, 16, 8, 8);
			case UP_EAST  -> box(0, 0, 0, 8, 8, 16);
			case UP_WEST  -> box(8, 0, 0, 16, 8, 16);
			case DOWN_NORTH   -> box(0, 8, 8, 16, 16, 16);
			case DOWN_SOUTH   -> box(0, 8, 0, 16, 16, 8);
			case DOWN_EAST    -> box(0, 8, 0, 8, 16, 16);
			case DOWN_WEST    -> box(8, 8, 0, 16, 16, 16);
		};
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	// Enum interno para representar as 8 orientações
	public enum StepOrientation implements StringRepresentable {
		DOWN_NORTH, DOWN_SOUTH, DOWN_EAST, DOWN_WEST,
		UP_NORTH, UP_SOUTH, UP_EAST, UP_WEST;

		@Override
		public String getSerializedName() {
			return name().toLowerCase();
		}
	}
}