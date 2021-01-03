package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.DZConfig;
import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID)
public class EntitySpawns {
    private static int tewitySpawnWeight = 105;
    private static int stampylongnoseSpawnWeight = 100;

    @SubscribeEvent
    public static void onBiomeLoaded(BiomeLoadingEvent event) {


        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), tewitySpawnWeight, 1, 1));

        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), stampylongnoseSpawnWeight , 1, 1));


        System.out.println("tewtiySpawnWeight:" + DZConfig.misc.tewtiySpawnWeight.get());
        System.out.println("stampylongnoseSpawnWeight:" + DZConfig.misc.stampylongnoseSpawnWeight.get());
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        List<MobSpawnInfo.Spawners> spawns =
                event.getSpawns().getSpawner(EntityClassification.MONSTER);

        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), 1, 1, 256));
        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), 1, 1, 256));
    }

}