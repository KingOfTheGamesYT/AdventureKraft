package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class VerticalSlabBlock extends Block implements IWaterLoggable {
	public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public VerticalSlabBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(TYPE, VerticalSlabType.NORTH).with(WATERLOGGED, false));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(TYPE, WATERLOGGED);
	}

	@Override
	public boolean isTransparent(BlockState state) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return state.get(TYPE).shape;
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		BlockState blockstate = context.getWorld().getBlockState(blockpos);
		if(blockstate.getBlock() == this)
			return blockstate.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, false);

		FluidState fluid = context.getWorld().getFluidState(blockpos);
		BlockState blockState = getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
		Direction direction = getDirectionForPlacement(context);
		VerticalSlabType type = VerticalSlabType.fromDirection(direction);

		return blockState.with(TYPE, type);
	}

	private Direction getDirectionForPlacement(BlockItemUseContext context) {
		Direction face = context.getFace();
		BlockPos pos = context.getPos();
		if (face.getAxis() != Direction.Axis.Y) return face;
		Vector3d vec = context.getHitVec().subtract(new Vector3d(pos.getX(), pos.getY(), pos.getZ())).subtract(0.5, 0, 0.5);
		double angle = Math.atan2(vec.x, vec.z) * -180.0 / Math.PI;
		return Direction.fromAngle(angle).getOpposite();}

	@Override
	public boolean isReplaceable(BlockState state, @Nonnull BlockItemUseContext context) {
		VerticalSlabType slabtype = state.get(TYPE);
		return slabtype != VerticalSlabType.DOUBLE && context.getItem().getItem() == this.asItem() && context.replacingClickedOnBlock() && (context.getFace() == slabtype.direction && this.getDirectionForPlacement(context) == slabtype.direction);
	}

	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}

	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return state;
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return type == PathType.WATER && worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
	}

	public static enum VerticalSlabType implements IStringSerializable {
		NORTH(Direction.NORTH),
		SOUTH(Direction.SOUTH),
		WEST(Direction.WEST),
		EAST(Direction.EAST),
		DOUBLE(null);

		private final String name;
		@Nullable
		public final Direction direction;
		public final VoxelShape shape;

		VerticalSlabType(@Nullable Direction direction) {
			this.direction = direction;
			this.name = direction == null ? "double" : direction.getString();
			if (direction == null) {
				this.shape = VoxelShapes.fullCube();
			} else {
				boolean isNegativeAxis = direction.getAxisDirection() == Direction.AxisDirection.NEGATIVE;
				double min = isNegativeAxis ? 8 : 0;
				double max = isNegativeAxis ? 16 : 8;
				this.shape = direction.getAxis() == Direction.Axis.X ? Block.makeCuboidShape(min, 0, 0, max, 16, 16) : Block.makeCuboidShape(0, 0, min, 16, 16, max);
			}
		}

		public static VerticalSlabType fromDirection(Direction direction) {
			for (VerticalSlabType type : VerticalSlabType.values()) {
				if (type.direction != null && direction == type.direction) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public String getString() {
			return this.name;
		}
	}
}