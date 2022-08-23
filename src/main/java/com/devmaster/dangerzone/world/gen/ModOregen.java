package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOregen {
    public static ConfiguredFeature<?, ?> ABYSSAL_ORE;
    public static ConfiguredFeature<?, ?> ALUMINIUM_ORE;
    public static ConfiguredFeature<?, ?> BUTTERFLY_ORE;
    public static ConfiguredFeature<?, ?> COARSE_AMETHYST_ORE;
    public static ConfiguredFeature<?, ?> CATS_EYE_ORE;
    public static ConfiguredFeature<?, ?> LEATHER_BLOCK;
    public static ConfiguredFeature<?, ?> MUTANT_ZOMBIE_ORE;
    public static ConfiguredFeature<?, ?> REDROSEWARRIOR_ORE;
    public static ConfiguredFeature<?, ?> STAMPYLONGNOSE_ORE;
    public static ConfiguredFeature<?, ?> TEWTIY_ORE;
    public static ConfiguredFeature<?, ?> PLAY_BUTTON_ORE;
    public static ConfiguredFeature<?, ?> SALT_ORE;
    public static ConfiguredFeature<?, ?> SAPPHIRE_ORE;
    public static ConfiguredFeature<?, ?> TITANIUM_ORE;

    public static void addConfigFeatures(RegistryEvent.Register<Feature<?>> event){

        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        ALUMINIUM_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ALUMINIUM_ORE_BLOCK.get().getDefaultState(),9))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 59))
                        .square()
                        .chance/* repeat */(5));

        ABYSSAL_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ABYSSAL_ORE_BLOCK.get().getDefaultState(),18))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(16, 0, 128))
                        .square()
                        .chance/* repeat */(16));

        COARSE_AMETHYST_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.COARSE_AMETHYST_ORE_BLOCK.get().getDefaultState(),6))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 25))
                        .square()
                        .chance/* repeat */(2));

        LEATHER_BLOCK = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.LEATHER_BLOCK.get().getDefaultState(),4))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(4));

        BUTTERFLY_ORE = Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.BUTTERFLY_EGG_ORE.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(3));

        MUTANT_ZOMBIE_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.MUTANT_ZOMBIE_EGG_ORE.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(3));

        PLAY_BUTTON_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.PLAY_BUTTON_ORE_BLOCK.get().getDefaultState(),8))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 14))
                        .square()
                        .chance/* repeat */(16));

        REDROSEWARRIOR_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.REDROSEWARRIOR_EGG_ORE.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(3));

        STAMPYLONGNOSE_ORE = Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.STAMPYLONGNOSE_EGG_ORE.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(3));

        TEWTIY_ORE = Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.TEWTIY_EGG_ORE.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(3));

        SALT_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.SALT_ORE_BLOCK.get().getDefaultState(),12))
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(50, 0, 128))
                .square()
                .chance/* repeat */(5));

       SAPPHIRE_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.SAPPHIRE_ORE_BLOCK.get().getDefaultState(),6))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 25))
                        .square()
                        .chance/* repeat */(2));

        TITANIUM_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.TITANIUM_ORE_BLOCK.get().getDefaultState(),4))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 20))
                        .square()
                        .chance/* repeat */(3));

        CATS_EYE_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.CATS_EYE_ORE.get().getDefaultState(),7))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(1, 0, 48))
                        .square()
                        .chance/* repeat */(5));

        Registry.register(registry, new ResourceLocation("aluminium_ore_block"), ALUMINIUM_ORE);
        Registry.register(registry, new ResourceLocation("abyssal_ore_block"), ABYSSAL_ORE);
        Registry.register(registry, new ResourceLocation("butterfly_egg_ore"), BUTTERFLY_ORE);
        Registry.register(registry, new ResourceLocation("coarse_amethyst_ore_block"), COARSE_AMETHYST_ORE);
        Registry.register(registry, new ResourceLocation("cats_eye_ore"), CATS_EYE_ORE);
        Registry.register(registry, new ResourceLocation("leather_block"), LEATHER_BLOCK);
        Registry.register(registry, new ResourceLocation("mutant_zombie_egg_ore"), MUTANT_ZOMBIE_ORE);
        Registry.register(registry, new ResourceLocation("play_button_ore_block"), PLAY_BUTTON_ORE);
        Registry.register(registry, new ResourceLocation("redrosewarrior_egg_ore"), REDROSEWARRIOR_ORE);
        Registry.register(registry, new ResourceLocation("petrified_stampylongnose_ore"), STAMPYLONGNOSE_ORE);
        Registry.register(registry, new ResourceLocation("petrified_tewtiy_ore"), TEWTIY_ORE);
        Registry.register(registry, new ResourceLocation("salt_ore_block"), SALT_ORE);
        Registry.register(registry, new ResourceLocation("sapphire_ore_block"), SAPPHIRE_ORE);
        Registry.register(registry, new ResourceLocation("titanium_ore_block"), TITANIUM_ORE);
    }

    public static void handleWorldGen(BiomeLoadingEvent event){
        RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getCategory() == Biome.Category.NETHER
                || event.getCategory() == Biome.Category.THEEND
                || BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID)) return;
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ALUMINIUM_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ABYSSAL_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, BUTTERFLY_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, COARSE_AMETHYST_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, CATS_EYE_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, LEATHER_BLOCK);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MUTANT_ZOMBIE_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PLAY_BUTTON_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, REDROSEWARRIOR_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, STAMPYLONGNOSE_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TEWTIY_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SALT_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SAPPHIRE_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TITANIUM_ORE);
    }

}