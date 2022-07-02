package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.configs.DZConfig;
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
                List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.NotBreeBreeinclude.get()));
                List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.NotBreeBreeexclude.get()));
                List<BiomeDictionary.Type> StampyLongNoseincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.StampyLongNoseinclude.get()));
                List<BiomeDictionary.Type> StampyLongNoseexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.StampyLongNoseexclude.get()));
                List<BiomeDictionary.Type> TewityincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Tewityinclude.get()));
                List<BiomeDictionary.Type> TewityexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Tewityexclude.get()));
                List<BiomeDictionary.Type> TechnobladeincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Technobladeinclude.get()));
                List<BiomeDictionary.Type> TechnobladeexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Technobladeexclude.get()));
                List<BiomeDictionary.Type> EntincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Entinclude.get()));
                List<BiomeDictionary.Type> EntexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Entexclude.get()));
                List<BiomeDictionary.Type> RainbowAntincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RainbowAntinclude.get()));
                List<BiomeDictionary.Type> RainbowAntexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RainbowAntexclude.get()));
                List<BiomeDictionary.Type> ButterflyincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Butterflyinclude.get()));
                List<BiomeDictionary.Type> ButterflyexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Butterflyexclude.get()));
                List<BiomeDictionary.Type> BirdincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Birdinclude.get()));
                List<BiomeDictionary.Type> BirdexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Birdexclude.get()));
                if (!includeList.isEmpty()) {
                    Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biomeKey);
                    if (biomeTypes.stream().noneMatch(excludeList::contains) && biomeTypes.stream().anyMatch(includeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.NOTBREEBREE.get(), DZConfig.NotBreeBreeweight.get(), DZConfig.NotBreeBreemin.get(), DZConfig.NotBreeBreemax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(StampyLongNoseexcludeList::contains) && biomeTypes.stream().anyMatch(StampyLongNoseincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.STAMPYLONGNOSE.get(), DZConfig.StampyLongNoseweight.get(), DZConfig.StampyLongNosemin.get(), DZConfig.StampyLongNosemax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(TechnobladeexcludeList::contains) && biomeTypes.stream().anyMatch(TechnobladeincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TECHNOBLADE.get(), DZConfig.Technobladeweight.get(), DZConfig.Technoblademin.get(), DZConfig.Technoblademax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(TewityexcludeList::contains) && biomeTypes.stream().anyMatch(TewityincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.TEWTIY.get(), DZConfig.Tewityweight.get(), DZConfig.Tewitymin.get(), DZConfig.Tewitymax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(EntexcludeList::contains) && biomeTypes.stream().anyMatch(EntincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.ENT.get(), DZConfig.Entweight.get(), DZConfig.Entmin.get(), DZConfig.Entmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(RainbowAntexcludeList::contains) && biomeTypes.stream().anyMatch(RainbowAntincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(RegistryHandler.RAINBOWANT.get(), DZConfig.RainbowAntweight.get(), DZConfig.RainbowAntmin.get(), DZConfig.RainbowAntmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(ButterflyexcludeList::contains) && biomeTypes.stream().anyMatch(ButterflyincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(RegistryHandler.BUTTERFLY.get(), DZConfig.Butterflyweight.get(), DZConfig.Butterflymin.get(), DZConfig.Butterflymax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BirdexcludeList::contains) && biomeTypes.stream().anyMatch(BirdincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(RegistryHandler.BIRD.get(), DZConfig.Birdweight.get(), DZConfig.Birdmin.get(), DZConfig.Birdmax.get()));
                    }

                } else {
                    throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
                }
            }
        }
    }
}