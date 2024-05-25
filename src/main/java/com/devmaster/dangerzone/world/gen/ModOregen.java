package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.util.RegistryHandler;
import static com.devmaster.dangerzone.world.gen.ModOregen.OreType.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;


public class ModOregen {

        public static void handleWorldGen(final BiomeLoadingEvent event) {
            spawnOreInSpecificBiome(Biomes.MOUNTAINS, TERMITE_TROLL_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(ALUMINIUM_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(ABYSSAL_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(COARSE_AETHYST_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(LEATHER_BLOCK, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(BUTTERFLY_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(MUTANT_ZOMBIE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(PLAY_BUTTON_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(RAINBOW_ANT_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(REDROSEWARRIOR_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(MAGMA_CUBE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(STAMPYLONGNOSE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(TEWTIY_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(ZOMBIE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(SALT_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(SAPPHIRE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(TITANIUM_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(CATS_EYE_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(GODZILLA_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(GUARDIAN_ORE, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(TERMITE_ORE, event, Dimension.OVERWORLD.toString());
        }

        private static OreFeatureConfig getOverworldFeatureConfig(OreType ore) {
            return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
        }

        private static OreFeatureConfig getNetherFeatureConfig(OreType ore) {
            return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
        }

        private static OreFeatureConfig getEndFeatureConfig(OreType ore) {
            return new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
        }

        // Currently only supports vanilla Dimensions
        private static ConfiguredFeature<?, ?> makeOreFeature(OreType ore, String dimensionToSpawnIn) {
            OreFeatureConfig oreFeatureConfig = null;

            if (dimensionToSpawnIn.equals(Dimension.OVERWORLD.toString())) {
                oreFeatureConfig = getOverworldFeatureConfig(ore);
            } else if (dimensionToSpawnIn.equals(Dimension.THE_NETHER.toString())) {
                oreFeatureConfig = getNetherFeatureConfig(ore);
            } else if (dimensionToSpawnIn.equals(Dimension.THE_END.toString())) {
                oreFeatureConfig = getEndFeatureConfig(ore);
            }

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            return registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
        }

        private static void spawnOreInOverworldInGivenBiomes(OreType ore, final BiomeLoadingEvent event, Biome... biomesToSpawnIn) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

            if (Arrays.stream(biomesToSpawnIn).anyMatch(b -> b.getRegistryName().equals(event.getName()))) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
            }
        }


        private static void spawnOreInSpecificModBiome(Biome biomeToSpawnIn, OreType currentOreType,
                                                       final BiomeLoadingEvent event, String dimension) {
            if (event.getName().toString().contains(biomeToSpawnIn.getRegistryName().toString())) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
            }
        }

        private static void spawnOreInSpecificBiome(RegistryKey<Biome> biomeToSpawnIn, OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
            if (event.getName().toString().contains(biomeToSpawnIn.getLocation().toString())) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
            }
        }

        private static void spawnOreInAllBiomes(OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    makeOreFeature(currentOreType, dimension));
        }

        private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement) {
            return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                    Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(configuredPlacement)
                            .square()
                            .count(ore.getVeinsPerChunk()));
        }
public enum OreType {
    ALUMINIUM_ORE(Lazy.of(RegistryHandler.ALUMINIUM_ORE_BLOCK), 9, 0, 59, 5),
    ABYSSAL_ORE(Lazy.of(RegistryHandler.ABYSSAL_ORE_BLOCK), 18, 16, 128, 16),
    COARSE_AETHYST_ORE(Lazy.of(RegistryHandler.COARSE_AMETHYST_ORE_BLOCK), 6, 0, 25, 2),
    LEATHER_BLOCK(Lazy.of(RegistryHandler.LEATHER_BLOCK), 4, 0, 128, 4),
    BUTTERFLY_ORE(Lazy.of(RegistryHandler.BUTTERFLY_EGG_ORE), 3, 0, 128, 3),
    MUTANT_ZOMBIE_ORE(Lazy.of(RegistryHandler.MUTANT_ZOMBIE_EGG_ORE), 3, 0, 128, 3),
    PLAY_BUTTON_ORE(Lazy.of(RegistryHandler.PLAY_BUTTON_ORE_BLOCK), 8, 0, 14, 16),
    RAINBOW_ANT_ORE(Lazy.of(RegistryHandler.RAINBOW_ANT_EGG_ORE), 3, 0, 128, 3),
    REDROSEWARRIOR_ORE(Lazy.of(RegistryHandler.REDROSEWARRIOR_EGG_ORE), 3, 0, 128, 3),
    MAGMA_CUBE_ORE(Lazy.of(RegistryHandler.MAGMA_CUBE_EGG_ORE), 3, 0, 128, 3),
    STAMPYLONGNOSE_ORE(Lazy.of(RegistryHandler.STAMPYLONGNOSE_EGG_ORE), 3, 0, 128, 3),
    TEWTIY_ORE(Lazy.of(RegistryHandler.TEWTIY_EGG_ORE), 3, 0, 128, 3),
    ZOMBIE_ORE(Lazy.of(RegistryHandler.ZOMBIE_EGG_ORE), 3, 0, 128, 3),
    SALT_ORE(Lazy.of(RegistryHandler.SALT_ORE_BLOCK), 12, 50, 128, 5),
    SAPPHIRE_ORE(Lazy.of(RegistryHandler.SAPPHIRE_ORE_BLOCK), 6, 0, 25, 2),
    TITANIUM_ORE(Lazy.of(RegistryHandler.TITANIUM_ORE_BLOCK), 4, 0, 20, 3),
    CATS_EYE_ORE(Lazy.of(RegistryHandler.CATS_EYE_ORE), 7, 1, 48, 5),
    GODZILLA_ORE(Lazy.of(RegistryHandler.GODZILLA_EGG_ORE), 3, 0, 128, 3),
    GUARDIAN_ORE(Lazy.of(RegistryHandler.GUARDIAN_EGG_ORE), 3, 0, 128, 3),
    TERMITE_ORE(Lazy.of(RegistryHandler.TERMITE_EGG_ORE), 3, 0, 128, 3),
    TERMITE_TROLL_ORE(Lazy.of(RegistryHandler.TERMITE_TROLL_ORE), 1, 4, 32, 3);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunk;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
    }

    public int getVeinsPerChunk() {
        return veinsPerChunk;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
}