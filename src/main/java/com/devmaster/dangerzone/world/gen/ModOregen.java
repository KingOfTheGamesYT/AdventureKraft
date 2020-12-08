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

    public static ConfiguredFeature<?, ?> AMETHYST_ORE;
    public static ConfiguredFeature<?, ?> SALT_ORE;

    public static void addConfigFeatures(RegistryEvent.Register<Feature<?>> event){
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        AMETHYST_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.AMETHYST_ORE_BLOCK.get().getDefaultState(),6))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 25))
                        .square()
                        .func_242731_b/* repeat */(2));

        SALT_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.SALT_ORE_BLOCK.get().getDefaultState(),12))
        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(50, 0, 128))
                .square()
                .func_242731_b/* repeat */(5));

        Registry.register(registry, new ResourceLocation("amethyst_ore_block"), AMETHYST_ORE);
        Registry.register(registry, new ResourceLocation("salt_ore_block"), SALT_ORE);
    }

    public static void handleWorldGen(BiomeLoadingEvent event){
        RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getCategory() == Biome.Category.NETHER
                || event.getCategory() == Biome.Category.THEEND
                || BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID)) return;
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, AMETHYST_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SALT_ORE);
    }

}