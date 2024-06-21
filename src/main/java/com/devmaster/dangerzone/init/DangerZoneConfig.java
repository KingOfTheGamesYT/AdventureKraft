package com.devmaster.dangerzone.init;


import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nullable;

import static net.minecraftforge.common.ForgeConfigSpec.*;

public class DangerZoneConfig {

//	public BooleanValue play_Nice;

	public IntValue bridgeLength;
	public IntValue stairHeight;
	public IntValue stairDepth;


	//region Egg ore
	public BooleanValue shouldEggOresGenerate;

	public BooleanValue batOre;
	public BooleanValue blazeOre;
	public BooleanValue catOre;
	public BooleanValue cavespiderOre;
	public BooleanValue chickenOre;
	public BooleanValue codOre;
	public BooleanValue cowOre;
	public BooleanValue creeperOre;
	public BooleanValue dolphinOre;
	public BooleanValue donkeyOre;
	public BooleanValue drownedOre;
	public BooleanValue elderGuardianOre;
	public BooleanValue enderDragonOre;
	public BooleanValue endermanOre;
	public BooleanValue endermiteOre;
	public BooleanValue evokerOre;
	public BooleanValue guardianOre;
	public BooleanValue horseOre;
	public BooleanValue huskOre;
	public BooleanValue ironGolemOre;
	public BooleanValue llamaOre;
	public BooleanValue magmacubeOre;
	public BooleanValue mooshroomOre;
	public BooleanValue muleOre;
	public BooleanValue ocelotOre;
	public BooleanValue pandabearOre;
	public BooleanValue parrotOre;
	public BooleanValue phantomOre;
	public BooleanValue pigOre;
	public BooleanValue polarbearOre;
	public BooleanValue pufferfishOre;
	public BooleanValue rabbitOre;
	public BooleanValue salmonOre;
	public BooleanValue sheepOre;
	public BooleanValue silverfishOre;
	public BooleanValue skeletonOre;
	public BooleanValue skeletonHorseOre;
	public BooleanValue slimeOre;
	public BooleanValue snowGolemOre;
	public BooleanValue spiderOre;
	public BooleanValue squidOre;
	public BooleanValue strayOre;
	public BooleanValue turtleOre;
	public BooleanValue traderLlamaOre;
	public BooleanValue tropicalFishOre;
	public BooleanValue vexOre;
	public BooleanValue villagerOre;
	public BooleanValue vindicatorOre;
	public BooleanValue wanderingTraderOre;
	public BooleanValue witchOre;
	public BooleanValue witherOre;
	public BooleanValue witherSkeletonOre;
	public BooleanValue wolfOre;
	public BooleanValue zombieOre;
	public BooleanValue zombieHorseOre;
	public BooleanValue zombiePigmanOre;
	public BooleanValue zombieVillagerOre;
	public BooleanValue foxOre;
	public BooleanValue ghastOre;
	public BooleanValue pillagerOre;
	public BooleanValue ravagerOre;
	public BooleanValue shulkerOre;
	//endregion


	public DangerZoneConfig(Builder builder) {
		builder.comment("General settings").push("general");

	//	play_Nice = builder.comment("Disables some of the attacks from bosses").comment("config.dangerzone.prop.play_nice.desc").define("play_nice", false);

		bridgeLength = builder.comment("The length of the Instant Bridge Item").translation("config.dangerzone.prop.bridgelength.desc").defineInRange("bridgeLength", 32, 0, 128);

		stairHeight = builder.comment("The height of the Instant Stairs down item").translation("config.dangerzone.prop.stairheight.desc").defineInRange("stairHeight", 32, 0, 128);
		stairDepth = builder.comment("The Depth of the Instant Stair down item").translation("config.dangerzone.prop.stairdepth.desc").defineInRange("stairDepth", 32, 0, 128);


		builder.pop();

		builder.comment("World gen").push("world_gen");

		shouldEggOresGenerate = builder.comment("Should Petrified Spawn Eggs generate")
		.translation("config.dangerzone.prop.egg_ores.desc")
		.define("ShouldEggOresGenerate", true);

		builder.pop();

		builder.push("egg_ore_world_gen");

		batOre = addOreConfig(builder, "Bat");

		blazeOre = addOreConfig(builder, "Blaze");

		catOre = addOreConfig(builder, "Cat");

		cavespiderOre = addOreConfig(builder, "Cave", "Spider");

		chickenOre = addOreConfig(builder, "Chicken");

		codOre = addOreConfig(builder, "Cod");

		cowOre = addOreConfig(builder, "Cow");

		creeperOre = addOreConfig(builder, "Creeper");

		dolphinOre = addOreConfig(builder, "Dolphin");

		donkeyOre = addOreConfig(builder, "Donkey");

		drownedOre = addOreConfig(builder, "Drowned");

		elderGuardianOre = addOreConfig(builder, "Elder", "Guardian");

		enderDragonOre = addOreConfig(builder, "Ender", "Dragon");

		endermanOre = addOreConfig(builder, "Enderman");

		endermiteOre = addOreConfig(builder, "Endermite");

		evokerOre = addOreConfig(builder, "Evoker");

		foxOre = addOreConfig(builder, "Fox");

		ghastOre = addOreConfig(builder, "Ghast");

		guardianOre = addOreConfig(builder, "Guardian");

		horseOre = addOreConfig(builder, "Horse");

		huskOre = addOreConfig(builder, "Husk");

		ironGolemOre = addOreConfig(builder, "Iron", "Golem");

		llamaOre = addOreConfig(builder, "Llama");

		magmacubeOre = addOreConfig(builder, "Magma", "Cube");

		mooshroomOre = addOreConfig(builder, "Mooshroom");

		muleOre = addOreConfig(builder, "Mule");

		ocelotOre = addOreConfig(builder, "Ocelot");

		pandabearOre = addOreConfig(builder, "Panda", "Bear");

		parrotOre = addOreConfig(builder, "Parrot");

		phantomOre = addOreConfig(builder, "Phantom");

		pigOre = addOreConfig(builder, "Pig");

		pillagerOre = addOreConfig(builder, "Pillager");

		polarbearOre = addOreConfig(builder, "Polar", "Bear");

		pufferfishOre = addOreConfig(builder, "Pufferfish");

		rabbitOre = addOreConfig(builder, "Rabbit");

		ravagerOre = addOreConfig(builder, "Ravager");

		salmonOre = addOreConfig(builder, "Salmon");

		sheepOre = addOreConfig(builder, "Sheep");

		shulkerOre = addOreConfig(builder, "Shulker");

		silverfishOre = addOreConfig(builder, "Silverfish");

		skeletonOre = addOreConfig(builder, "Skeleton");

		skeletonHorseOre = addOreConfig(builder, "Skeleton", "Horse");

		slimeOre = addOreConfig(builder, "Slime");

		snowGolemOre = addOreConfig(builder, "Snow", "Golem");

		spiderOre = addOreConfig(builder, "Spider");

		squidOre = addOreConfig(builder, "Squid");

		strayOre = addOreConfig(builder, "Stray");

		turtleOre = addOreConfig(builder, "Turtle");

		traderLlamaOre = addOreConfig(builder, "Trader", "Llama");

		tropicalFishOre = addOreConfig(builder, "Tropical", "Fish");

		vexOre = addOreConfig(builder, "Vex");

		villagerOre = addOreConfig(builder, "Villager");

		vindicatorOre = addOreConfig(builder, "Vindicator");

		wanderingTraderOre = addOreConfig(builder, "Wandering", "Trader");

		witchOre = addOreConfig(builder, "Witch");

		witherOre = addOreConfig(builder, "Wither");

		witherSkeletonOre = addOreConfig(builder, "Wither", "Skeleton");

		wolfOre = addOreConfig(builder, "Wolf");

		zombieOre = addOreConfig(builder, "Zombie");

		zombieHorseOre = addOreConfig(builder, "Zombie", "Horse");

		zombiePigmanOre = addOreConfig(builder, "Zombie", "Pigman");

		zombieVillagerOre = addOreConfig(builder, "Zombie", "Villager");

		builder.pop();

	}

	private BooleanValue addOreConfig(ForgeConfigSpec.Builder builder, String name) {
		return builder.comment("Should Petrified " + name + " Spawn Egg generate.")
				.translation("config.dangerzone.prop." + name.toLowerCase() + ".desc")
				.define(name.toLowerCase() + "Ore", true);
	}

	private BooleanValue addOreConfig(ForgeConfigSpec.Builder builder, String name, String name2) {
		return builder.comment("Should Petrified " + name + " " + name2 + " Spawn Egg generate.")
				.translation("config.dangerzone.prop." + name.toLowerCase() + "_" + name2.toLowerCase() + ".desc")
				.define(name.toLowerCase() + name2 + "Ore", true);
	}

}
