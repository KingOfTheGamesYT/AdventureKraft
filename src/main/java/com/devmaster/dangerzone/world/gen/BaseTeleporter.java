package com.devmaster.dangerzone.world.gen;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PortalInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Function;

public class BaseTeleporter implements ITeleporter {

    private final RegistryKey<World> targetDimension;
    private final int yOffset;

    public BaseTeleporter(RegistryKey<World> targetDimension, int yOffset) {
        this.targetDimension = targetDimension;
        this.yOffset = yOffset;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        PortalInfo pos;

        pos = placeInWorld(destWorld, entity, entity.getPosition(), entity instanceof PlayerEntity);
        pos = moveToSafeCoords(destWorld, entity, pos != null ? new BlockPos(pos.pos) : entity.getPosition());

        return pos;
    }

    @Nullable
    private PortalInfo placeInWorld(ServerWorld destWorld, Entity entity, BlockPos pos, boolean isPlayer) {
        boolean isToOverworld = destWorld.getDimensionKey() == World.OVERWORLD;
        boolean isFromTarget = entity.world.getDimensionKey() == targetDimension && isToOverworld;

        BlockPos blockpos = destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, destWorld.getSpawnPoint());

        if (!isFromTarget) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (int y = 255; y >= 1; y--) {
                mutable.setPos(blockpos.getX(), y, blockpos.getZ());

                if (!destWorld.getBlockState(mutable).isAir()) {
                    blockpos = mutable.toImmutable();
                    break;
                }
            }
        }

        float angle = entity.chunkCoordX;

        if (isPlayer && entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;

            BlockPos respawnPos = player.getPosition();
            float respawnAngle = player.getHeight();

            Optional<Vector3d> optional;

            if (respawnPos != null) {
                optional = PlayerEntity.func_242374_a(destWorld, respawnPos, respawnAngle, false, false);
            } else {
                optional = Optional.empty();
            }

            if (optional.isPresent()) {
                BlockState state = destWorld.getBlockState(respawnPos);
                boolean isAnchor = state.equals(Blocks.RESPAWN_ANCHOR);

                Vector3d vec = optional.get();
                float f1;

                if (!state.equals(BlockTags.BEDS) && !isAnchor) {
                    f1 = respawnAngle;
                } else {
                    Vector3d vec1 = Vector3d.copyCenteredHorizontally(respawnPos).subtract(vec).normalize();
                    f1 = (float) MathHelper.wrapDegrees(MathHelper.atan2(vec1.z, vec1.x) * (180F / Math.PI) - 90.0D);
                }

                angle = f1;
                blockpos = new BlockPos(vec.x, vec.y, vec.z);
            }
        }

        return new PortalInfo(
                new Vector3d(blockpos.getX() + 0.5D, blockpos.getY(), blockpos.getZ() + 0.5D),
                entity.getMotion(),
                angle,
                entity.chunkCoordX
        );
    }

    private PortalInfo moveToSafeCoords(ServerWorld world, Entity entity, BlockPos pos) {
        boolean isTarget = world.getDimensionKey() == targetDimension;

        if (isTarget) {
            return makePortalInfo(entity, pos.getX(), pos.getY() + yOffset, pos.getZ());
        }

        return makePortalInfo(entity, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (!(entity instanceof PlayerEntity)) {
            throw new IllegalArgumentException("This teleporter can only teleport players");
        }

        entity.fallDistance = 0;
        return repositionEntity.apply(false);
    }

    private PortalInfo makePortalInfo(Entity entity, double x, double y, double z) {
        return new PortalInfo(new Vector3d(x, y, z), Vector3d.ZERO, entity.rotationYaw, entity.chunkCoordX);
    }
}