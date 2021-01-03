package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.DZConfig;
import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID)
public class EntitySpawns {
    @SubscribeEvent
    public static void onBiomeLoaded(BiomeLoadingEvent event) {

        List<MobSpawnInfo.Spawners> spawner = event.getSpawns().getSpawner(EntityClassification.CREATURE);

        if (event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.PLAINS) {
            spawner.add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), DZConfig.misc.tewtiySpawnWeight.get(), 2, 4));
        }
        if (event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.PLAINS) {
            spawner.add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), DZConfig.misc.stampylongnoseSpawnWeight.get(), 2, 4));
        }
    }
}