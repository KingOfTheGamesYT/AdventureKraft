package com.devmaster.dangerzone.blocks;

import lombok.val;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.ticks.ScheduledTick;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VerticalSlabBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, VerticalSlabType.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TYPE, WATERLOGGED);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return pState.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        val blockpos = context.getClickedPos();
        val blockstate = context.getLevel().getBlockState(blockpos);

        if (blockstate.getBlock() == this) {
            return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);
        }

        val fluid = context.getLevel().getFluidState(blockpos);
        val blockState = defaultBlockState().setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        val direction = getDirectionForPlacement(context);
        val type = VerticalSlabType.fromDirection(direction);

        return blockState.setValue(TYPE, type);
    }

    private Direction getDirectionForPlacement(BlockPlaceContext context) {
        val face = context.getClickedFace();
        val blockPos = context.getClickedPos();

        if (face.getAxis() != Direction.Axis.Y) return face;

        val vec3 = context.getClickLocation()
                .subtract(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ())).subtract(0.5, 0, 0.5);
        val angle = Math.atan2(vec3.x, vec3.z) * -180.0 / Math.PI;
        return Direction.fromYRot(angle).getOpposite();
    }

    @Override
    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        val slabType = pState.getValue(TYPE);
        return slabType != VerticalSlabType.DOUBLE && pUseContext.getItemInHand().getItem() == this.asItem() && pUseContext.replacingClickedOnBlock()
                && (pUseContext.getClickedFace() == slabType.direction && this.getDirectionForPlacement(pUseContext) == slabType.direction);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Objects.requireNonNull(pState.getValue(TYPE).shape, "Missing shape for " + pState.getValue(TYPE));
    }

    @Override
    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        return pState.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(pLevel, pPos, pState, pFluidState);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return pState.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(pLevel, pPos, pState, pFluid);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.getFluidTicks().schedule(new ScheduledTick<>(Fluids.WATER, pPos, Fluids.WATER.getTickDelay(pLevel), 0L));
        }

        return pState;
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return pType == PathComputationType.WATER && pLevel.getFluidState(pPos).is(FluidTags.WATER);
    }

    public enum VerticalSlabType implements StringRepresentable {
        NORTH(Direction.NORTH),
        SOUTH(Direction.SOUTH),
        WEST(Direction.WEST),
        EAST(Direction.EAST),
        DOUBLE(null);

        private final String name;
        @Nullable
        public final VoxelShape shape;
        public final Direction direction;

        VerticalSlabType(@Nullable Direction direction) {
            this.direction = direction;
            this.name = direction == null ? "double" : direction.getSerializedName();
            if (direction == null) {
                this.shape = Shapes.block();
            } else {
                boolean isNegativeAxis = direction.getAxisDirection() == Direction.AxisDirection.NEGATIVE;
                double min = isNegativeAxis ? 8 : 0;
                double max = isNegativeAxis ? 16 : 8;
                this.shape = direction.getAxis() == Direction.Axis.X ? Block.box(min, 0, 0, max, 16, 16)
                        : Block.box(0, 0, min, 16, 16, max);
            }
        }

        public static @Nullable VerticalSlabType fromDirection(Direction direction) {
            for (VerticalSlabType type : VerticalSlabType.values()) {
                if (type.direction != null && direction == type.direction) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }
}
