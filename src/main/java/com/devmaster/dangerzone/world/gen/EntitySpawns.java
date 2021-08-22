package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.misc.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID)
public class EntitySpawns {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void addSpawn(BiomeLoadingEvent event) {
        if (event.getName() != null) {
            Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
            if (biome != null) {
                RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, event.getName());
                List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.NotBreeBreeinclude.get()));
                List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.NotBreeBreeexclude.get()));
                List<BiomeDictionary.Type> StampyLongNoseincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.StampyLongNoseinclude.get()));
                List<BiomeDictionary.Type> StampyLongNoseexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.StampyLongNoseexclude.get()));
                List<BiomeDictionary.Type> TewityincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.Tewityinclude.get()));
                List<BiomeDictionary.Type> TewityexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.Tewityexclude.get()));
                List<BiomeDictionary.Type> EntincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.Entinclude.get()));
                List<BiomeDictionary.Type> EntexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.SPAWN.Entexclude.get()));

                if (!includeList.isEmpty()) {
                    Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biomeKey);
                    if (biomeTypes.stream().noneMatch(excludeList::contains) && biomeTypes.stream().anyMatch(includeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.NOTBREEBREE.get(), DZConfig.SPAWN.NotBreeBreeweight.get(), DZConfig.SPAWN.NotBreeBreemin.get(), DZConfig.SPAWN.NotBreeBreemax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(StampyLongNoseexcludeList::contains) && biomeTypes.stream().anyMatch(StampyLongNoseincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), DZConfig.SPAWN.StampyLongNoseweight.get(), DZConfig.SPAWN.StampyLongNosemin.get(), DZConfig.SPAWN.StampyLongNosemax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(TewityexcludeList::contains) && biomeTypes.stream().anyMatch(TewityincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), DZConfig.SPAWN.Tewityweight.get(), DZConfig.SPAWN.Tewitymin.get(), DZConfig.SPAWN.Tewitymax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(excludeList::contains) && biomeTypes.stream().anyMatch(includeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.ENT.get(), DZConfig.SPAWN.Entweight.get(), DZConfig.SPAWN.Entmin.get(), DZConfig.SPAWN.Entmax.get()));
                    }
                } else {
                    throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
                }
            }
        }
    }
}