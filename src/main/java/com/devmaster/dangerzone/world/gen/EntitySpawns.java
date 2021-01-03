package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.DZConfig;
import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.entity.StampyLongNose;
import com.devmaster.dangerzone.entity.Tewtiy;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
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

        //List<MobSpawnInfo.Spawners> spawner = event.getSpawns().getSpawner(EntityClassification.CREATURE);
        //List<Biome.SpawnListEntry> creatures = b.getSpawns(EntityClassification.CREATURE);
        
        //if (event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.PLAINS) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), tewitySpawnWeight, 2, 4));
            
        //}
        //if (event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.PLAINS) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), stampylongnoseSpawnWeight , 2, 4));
             //}
            //testing
            System.out.println("tewtiySpawnWeight:" + DZConfig.misc.tewtiySpawnWeight.get());
            System.out.println("stampylongnoseSpawnWeight:" + DZConfig.misc.stampylongnoseSpawnWeight.get());
    }
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        List<MobSpawnInfo.Spawners> spawns = 
            event.getSpawns().getSpawner(EntityClassification.MONSTER);

        // Remove existing Enderman spawn information
        spawns.removeIf(e -> e.type == EntityType.ENDERMAN);

        // Make Enderman spawns more frequent and add Blaze spawns in all biomes
        spawns.add(new MobSpawnInfo.Spawners(EntityType.BLAZE, 200, 1, 4));
        spawns.add(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 200, 1, 4));
        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), 200, 1, 4));
        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), 200, 1, 4));
    }
    	
}