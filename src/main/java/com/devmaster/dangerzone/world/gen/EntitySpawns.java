package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
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
                List<BiomeDictionary.Type> RedCowincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RedCowinclude.get()));
                List<BiomeDictionary.Type> RedCowexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RedCowexclude.get()));
                List<BiomeDictionary.Type> AlexiCraftincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.AlexiCraftinclude.get()));
                List<BiomeDictionary.Type> AlexiCraftexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.AlexiCraftexclude.get()));
                List<BiomeDictionary.Type> AntVenomincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.AntVenominclude.get()));
                List<BiomeDictionary.Type> AntVenomexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.AntVenomexclude.get()));
                List<BiomeDictionary.Type> AphmauincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Aphmauinclude.get()));
                List<BiomeDictionary.Type> AphmauexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Aphmauexclude.get()));
                List<BiomeDictionary.Type> BabyAngelincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyAngelinclude.get()));
                List<BiomeDictionary.Type> BabyAngelexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyAngelexclude.get()));
                List<BiomeDictionary.Type> BabyDuckincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyDuckinclude.get()));
                List<BiomeDictionary.Type> BabyDuckexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyDuckexclude.get()));
                List<BiomeDictionary.Type> BabyLeahincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyLeahinclude.get()));
                List<BiomeDictionary.Type> BabyLeahexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyLeahexclude.get()));
                List<BiomeDictionary.Type> BabyMaxincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyMaxinclude.get()));
                List<BiomeDictionary.Type> BabyMaxexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BabyMaxexclude.get()));
                List<BiomeDictionary.Type> BajanCanadianincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BajanCanadianinclude.get()));
                List<BiomeDictionary.Type> BajanCanadianexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.BajanCanadianexclude.get()));
                List<BiomeDictionary.Type> CaptainSparkelzincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.CaptainSparkelzinclude.get()));
                List<BiomeDictionary.Type> CaptainSparkelzexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.CaptainSparkelzexclude.get()));
                List<BiomeDictionary.Type> RedAntincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RedAntinclude.get()));
                List<BiomeDictionary.Type> RedAntexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.RedAntexclude.get()));
                List<BiomeDictionary.Type> TermiteincludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Termiteinclude.get()));
                List<BiomeDictionary.Type> TermiteexcludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(DZConfig.Termiteexclude.get()));

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
                    if (biomeTypes.stream().noneMatch(RedCowexcludeList::contains) && biomeTypes.stream().anyMatch(RedCowincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.RED_COW.get(), DZConfig.RedCowweight.get(), DZConfig.RedCowmin.get(), DZConfig.RedCowmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(AlexiCraftexcludeList::contains) && biomeTypes.stream().anyMatch(AlexiCraftincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.ALEXICRAFT.get(), DZConfig.AlexiCraftweight.get(), DZConfig.AlexiCraftmin.get(), DZConfig.AlexiCraftmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(AntVenomexcludeList::contains) && biomeTypes.stream().anyMatch(AntVenomincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.ANTVENOM.get(), DZConfig.AntVenomweight.get(), DZConfig.AntVenommin.get(), DZConfig.AntVenommax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(AntVenomexcludeList::contains) && biomeTypes.stream().anyMatch(AntVenomincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.APHMAU.get(), DZConfig.AntVenomweight.get(), DZConfig.AntVenommin.get(), DZConfig.Aphmaumax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BabyAngelexcludeList::contains) && biomeTypes.stream().anyMatch(BabyAngelincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.BABYANGEL.get(), DZConfig.BabyAngelweight.get(), DZConfig.BabyAngelmin.get(), DZConfig.BabyAngelmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BabyDuckexcludeList::contains) && biomeTypes.stream().anyMatch(BabyDuckincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.BABYDUCK.get(), DZConfig.BabyDuckweight.get(), DZConfig.BabyDuckymin.get(), DZConfig.BabyDuckmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BabyLeahexcludeList::contains) && biomeTypes.stream().anyMatch(BabyLeahincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.BABYLEAH.get(), DZConfig.BabyLeahweight.get(), DZConfig.BabyLeahymin.get(), DZConfig.BabyLeahmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BabyMaxexcludeList::contains) && biomeTypes.stream().anyMatch(BabyMaxincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.BABYMAX.get(), DZConfig.BabyMaxweight.get(), DZConfig.BabyMaxmin.get(), DZConfig.BabyMaxmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(BajanCanadianexcludeList::contains) && biomeTypes.stream().anyMatch(BajanCanadianincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.BAJANCANADIAN.get(), DZConfig.BajanCanadianweight.get(), DZConfig.BajanCanadianymin.get(), DZConfig.BajanCanadianmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(CaptainSparkelzexcludeList::contains) && biomeTypes.stream().anyMatch(CaptainSparkelzincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(RegistryHandler.CAPTAINSPARKELZ.get(), DZConfig.CaptainSparkelzweight.get(), DZConfig.CaptainSparkelzymin.get(), DZConfig.CaptainSparkelzmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(RedAntexcludeList::contains) && biomeTypes.stream().anyMatch(RedAntincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(RegistryHandler.RED_ANT.get(), DZConfig.RedAntweight.get(), DZConfig.RedAntmin.get(), DZConfig.RedAntmax.get()));
                    }
                    if (biomeTypes.stream().noneMatch(TermiteexcludeList::contains) && biomeTypes.stream().anyMatch(TermiteincludeList::contains)) {
                        event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(RegistryHandler.TERMITE.get(), DZConfig.Termiteweight.get(), DZConfig.Technoblademin.get(), DZConfig.Termitemax.get()));
                    }

                } else {
                    throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
                }
            }
        }
    }
    public static void registerSpawnPlacements() {
        EntitySpawnPlacementRegistry.register(RegistryHandler.BUTTERFLY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RegistryHandler.RAINBOWANT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RegistryHandler.ATTACK_SQUID.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(RegistryHandler.BIRD.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }
}