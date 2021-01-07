package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.misc.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID)
public class EntitySpawns {
    private static int tewitySpawnWeight = 1;
    private static int stampylongnoseSpawnWeight = 1;

    @SubscribeEvent
    public static void onBiomeLoaded(BiomeLoadingEvent event) {


        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), tewitySpawnWeight, 1, 1));

        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), stampylongnoseSpawnWeight , 1, 1));


        System.out.println("tewtiySpawnWeight:" + DZConfig.misc.tewtiySpawnWeight.get());
        System.out.println("stampylongnoseSpawnWeight:" + DZConfig.misc.stampylongnoseSpawnWeight.get());
    }


}