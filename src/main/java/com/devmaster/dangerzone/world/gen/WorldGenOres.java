package com.devmaster.dangerzone.world.gen;


import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import static net.minecraft.world.gen.GenerationStage.Decoration.*;
import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.*;

@Mod.EventBusSubscriber(modid = DangerZone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenOres {

	//static DangerZoneConfig config;

	//private static final int eggVeinSize = 3;
	//private static final int maxEggVeins = 3;
	//private static final int maxEggHeight = 128;


	//private static final int amethystVeinSize = 6;
	//private static final CountRangeConfig rubyConfig = new CountRangeConfig(3, 5, 5, 20);
//	private static final int rubyVeinSize = 4;
	//private static final CountRangeConfig titaniumConfig = new CountRangeConfig(1, 5, 5, 15);
	//private static final int titaniumVeinSize = 3;
//	private static final CountRangeConfig uraniumConfig = new CountRangeConfig(1, 5, 5, 15);
	//private static final int uraniumVeinSize = 3;

	//private static final int pinkTourmalineVeinSize = 5;
//	private static final CountRangeConfig pinkTourmalineConfig = new CountRangeConfig(3, 10,10, 128);

	//private static final int tigerEyeVeinSize = 3;
	//private static final CountRangeConfig tigerEyeConfig = new CountRangeConfig(2, 10,10, 128);


	//public static void setupOreGen() {
		//config = DangerZone.config;

	//	for(Biome biome : ForgeRegistries.BIOMES.getValues()) {
		//	if(biome.getCategory() == Biome.Category.THEEND) {
				//END ores
		//		continue;
		//	}

			//if(biome.getCategory() == Biome.Category.NETHER) {
			//	addOre(biome, NETHERRACK, PINK_TOURMALINE_ORE, pinkTourmalineVeinSize, pinkTourmalineConfig);
			//	addOre(biome, NETHERRACK, TIGER_EYE_ORE, tigerEyeVeinSize, tigerEyeConfig);
		//		continue;
		//	}


		//	addOre(biome, NATURAL_STONE, RUBY_ORE, rubyVeinSize, rubyConfig);
			//addOre(biome, NATURAL_STONE, TITANIUM_ORE, titaniumVeinSize, titaniumConfig);
		//	addOre(biome, NATURAL_STONE, URANIUM_ORE, uraniumVeinSize, uraniumConfig);

			//region Mob Ore spawn
			//if(config.shouldEggOresGenerate.get()) {
				//addMobOres(biome, BAT_EGG_ORE, config.batOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, BLAZE_EGG_ORE, config.blazeOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, CAVE_SPIDER_EGG_ORE, config.cavespiderOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, CHICKEN_EGG_ORE, config.chickenOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, COW_EGG_ORE, config.cowOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, CREEPER_EGG_ORE, config.creeperOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, DOLPHIN_EGG_ORE, config.dolphinOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, DONKEY_EGG_ORE, config.donkeyOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, DROWNED_EGG_ORE, config.drownedOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ELDER_GUARDIAN_EGG_ORE, config.elderGuardianOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ENDER_DRAGON_EGG_ORE, config.enderDragonOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ENDERMAN_EGG_ORE, config.endermanOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, EVOKER_EGG_ORE, config.evokerOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, GUARDIAN_EGG_ORE, config.guardianOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, HORSE_EGG_ORE, config.horseOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, HUSK_EGG_ORE, config.huskOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, IRON_GOLEM_EGG_ORE, config.ironGolemOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, LLAMA_EGG_ORE, config.llamaOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, MAGMA_CUBE_EGG_ORE, config.magmacubeOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, MOOSHROOM_EGG_ORE, config.mooshroomOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, OCELOT_EGG_ORE, config.ocelotOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, PANDA_EGG_ORE, config.pandabearOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, PARROT_EGG_ORE, config.parrotOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, PHANTOM_EGG_ORE, config.phantomOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, PIG_EGG_ORE, config.pigOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, POLAR_BEAR_EGG_ORE, config.polarbearOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, RABBIT_EGG_ORE, config.rabbitOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SHEEP_EGG_ORE, config.sheepOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
				//addMobOres(biome, SKELETON_EGG_ORE, config.skeletonOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SLIME_EGG_ORE, config.slimeOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SNOW_GOLEM_EGG_ORE, config.snowGolemOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SPIDER_EGG_ORE, config.spiderOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SQUID_EGG_ORE, config.squidOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, STRAY_EGG_ORE, config.strayOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, TURTLE_EGG_ORE, config.turtleOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, VILLAGER_EGG_ORE, config.villagerOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, VINDICATOR_EGG_ORE, config.vindicatorOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, WITCH_EGG_ORE, config.witchOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, WITHER_EGG_ORE, config.witherOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, WITHER_SKELETON_EGG_ORE, config.witherSkeletonOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, WOLF_EGG_ORE, config.wolfOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ZOMBIE_EGG_ORE, config.zombieOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ZOMBIE_PIGMAN_EGG_ORE, config.zombiePigmanOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, CAT_EGG_ORE, config.catOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, ENDERMITE_EGG_ORE, config.endermiteOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, FOX_EGG_ORE, config.foxOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, GHAST_EGG_ORE, config.ghastOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, PILLAGER_EGG_ORE, config.pillagerOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, RAVAGER_EGG_ORE, config.ravagerOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);
			//	addMobOres(biome, SHULKER_EGG_ORE, config.shulkerOre.get(), eggVeinSize, maxEggVeins, maxEggHeight);

				//endregion
			//}
	//	}

	//}


	//private static void addMobOres(Biome biome, Block block, boolean enabled, int size, int count, int maxHeight) {
	//	if(enabled) {
	//		biome.addFeature(UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(NATURAL_STONE, block.getDefaultState(), size)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(count, 0, 0, maxHeight))));
	//	}
	//}

	@SubscribeEvent
	public static void generateOres(FMLLoadCompleteEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES) {
			genOre(biome,2,0,0,25,OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.AMETHYST_ORE_BLOCK.getBlock().getDefaultState(),6);

		}
	}
	private static void genOre(Biome biome, int count, int topOffset, int bottomOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
		CountRangeConfig range = new CountRangeConfig(count, topOffset, bottomOffset, max);
		OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
		ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
	}
}