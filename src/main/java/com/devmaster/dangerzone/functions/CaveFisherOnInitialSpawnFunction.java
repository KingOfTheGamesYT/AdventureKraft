package com.devmaster.dangerzone.functions;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

public class CaveFisherOnInitialSpawnFunction {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onEntitySpawned(EntityJoinWorldEvent event) {
            Entity entity = event.getEntity();
            double i = entity.getPosX();
            double j = entity.getPosY();
            double k = entity.getPosZ();
            World world = event.getWorld();
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("event", event);
            executeProcedure(dependencies);
            }
        }

        public static boolean executeProcedure(Map<String, Object> dependencies) {
            if (dependencies.get("world") == null) {
                if (!dependencies.containsKey("world"))
                    DangerZone.LOGGER.warn("Failed to load dependency world for procedure CaveRoamerOnInitialEntitySpawn!");
                return false;
            }
            if (dependencies.get("x") == null) {
                if (!dependencies.containsKey("x"))
                    DangerZone.LOGGER.warn("Failed to load dependency x for procedure CaveRoamerOnInitialEntitySpawn!");
                return false;
            }
            if (dependencies.get("y") == null) {
                if (!dependencies.containsKey("y"))
                    DangerZone.LOGGER.warn("Failed to load dependency y for procedure CaveRoamerOnInitialEntitySpawn!");
                return false;
            }
            if (dependencies.get("z") == null) {
                if (!dependencies.containsKey("z"))
                    DangerZone.LOGGER.warn("Failed to load dependency z for procedure CaveRoamerOnInitialEntitySpawn!");
                return false;
            }
            if (dependencies.get("entity") == null) {
                if (!dependencies.containsKey("entity"))
                    DangerZone.LOGGER.warn("Failed to load dependency entity for procedure CaveRoamerOnInitialEntitySpawn!");
                return false;
            }
            IWorld world = (IWorld) dependencies.get("world");
            double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
            double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
            double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
            Entity entity = (Entity) dependencies.get("entity");
            return entity.getHeight() == entity.getPosX() + entity.getPosY() + entity.getPosZ()
                    && entity.getPosX() + entity.getPosY() + entity.getPosZ() < 64
                    && world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getLightValue() < 3
                    && (world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY() - 1), (int) (entity.getPosZ()))))
                    .getBlock() == Blocks.STONE
                    && (world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()))))
                    .getBlock() == Blocks.CAVE_AIR;
    }
}

