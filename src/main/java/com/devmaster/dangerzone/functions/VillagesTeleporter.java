package com.devmaster.dangerzone.functions;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PortalInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tags.BlockTags;
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

public class VillagesTeleporter implements ITeleporter {
    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        PortalInfo pos;

        pos = placeInWorld(destWorld, entity, entity.getPosition(), entity instanceof PlayerEntity);
        pos = moveToSafeCoords(destWorld, entity, pos != null ? new BlockPos(pos.pos) : entity.getPosition());

        return pos;
    }

    public VillagesTeleporter() {
    }

    @Nullable
    private PortalInfo placeInWorld(ServerWorld destWorld, Entity entity, BlockPos pos, boolean isPlayer) {
        boolean isToOverworld = destWorld.getDimensionKey() == World.OVERWORLD;
        boolean isFromVillages = entity.world.getDimensionKey() == RegistryHandler.VILLAGES && isToOverworld;
        BlockPos blockpos = destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, destWorld.getSpawnPoint());
        if (!isFromVillages) {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            for (int y = 255; y >= 1; y--) {
                blockpos$mutable.add(blockpos.getX(), y, blockpos.getZ());
                if (!destWorld.getBlockState(blockpos$mutable).isAir()) {
                    blockpos = blockpos$mutable;
                    break;
                }
            }
        }

        float angle = entity.chunkCoordX;

        if (isPlayer && entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
            BlockPos respawnPos = serverPlayer.getPosition();
            float respawnAngle = serverPlayer.getHeight();
            Optional<Vector3d> optional;
            if (serverPlayer != null && respawnPos != null) {
                optional = PlayerEntity.func_242374_a(destWorld, respawnPos, respawnAngle, false, false);
            } else {
                optional = Optional.empty();
            }

            if (optional.isPresent()) {
                BlockState blockstate = destWorld.getBlockState(respawnPos);
                boolean blockIsRespawnAnchor = blockstate.equals(Blocks.RESPAWN_ANCHOR);
                Vector3d vector3d = optional.get();
                float f1;
                if (!blockstate.equals(BlockTags.BEDS) && !blockIsRespawnAnchor) {
                    f1 = respawnAngle;
                } else {
                    Vector3d vector3d1 = Vector3d.copyCenteredHorizontally(respawnPos).subtract(vector3d).normalize();
                    f1 = (float) MathHelper.wrapDegrees(MathHelper.atan2(vector3d1.z, vector3d1.x) * (double) (180F / (float) Math.PI) - 90.0D);
                }
                angle = f1;
                blockpos = new BlockPos(vector3d.x, vector3d.y, vector3d.z);
            }
        }
        return new PortalInfo(new Vector3d((double) blockpos.getX() + 0.5D, (double) blockpos.getY(), (double) blockpos.getZ() + 0.5D), entity.getMotion(), angle, entity.chunkCoordX);
    }

    private PortalInfo moveToSafeCoords(ServerWorld world, Entity entity, BlockPos pos) {
        boolean toVillages = world.getDimensionKey() == RegistryHandler.VILLAGES;

        if (toVillages) {
            if (!world.getFluidState(pos).isEmpty()) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
            }
            return makePortalInfo(entity, pos.getX(), pos.getY() + 70, pos.getZ());
        }
        return makePortalInfo(entity, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (!(entity instanceof PlayerEntity)) {
            throw new IllegalArgumentException("This teleporter can only teleport players");
        }
        entity.fallDistance = 0;
        return repositionEntity.apply(false); //Must be false or we fall on vanilla
    }

    private PortalInfo makePortalInfo(Entity entity, double x, double y, double z) {
        return makePortalInfo(entity, new Vector3d(x, y, z));
    }

    private PortalInfo makePortalInfo(Entity entity, Vector3d pos) {
        return new PortalInfo(pos, Vector3d.ZERO, entity.rotationYaw, entity.chunkCoordX);
    }
}