package com.devmaster.dangerzone.init;


import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nullable;

import static net.minecraftforge.common.ForgeConfigSpec.*;

public class DangerZoneConfig {

//	public BooleanValue play_Nice;

	public IntValue bridgeLength;
	public IntValue stairHeight;

	//region Egg ore
	public BooleanValue shouldEggOresGenerate;

	public BooleanValue batOre;
	public BooleanValue blazeOre;
	public BooleanValue cavespiderOre;
	public BooleanValue chickenOre;
	public BooleanValue cowOre;
	public BooleanValue creeperOre;
	public BooleanValue dolphinOre;
	public BooleanValue donkeyOre;
	public BooleanValue drownedOre;
	public BooleanValue elderGuardianOre;
	public BooleanValue enderDragonOre;
	public BooleanValue endermanOre;
	public BooleanValue evokerOre;
	public BooleanValue guardianOre;
	public BooleanValue horseOre;
	public BooleanValue huskOre;
	public BooleanValue ironGolemOre;
	public BooleanValue llamaOre;
	public BooleanValue magmacubeOre;
	public BooleanValue mooshroomOre;
	public BooleanValue ocelotOre;
	public BooleanValue pandabearOre;
	public BooleanValue parrotOre;
	public BooleanValue phantomOre;
	public BooleanValue pigOre;
	public BooleanValue polarbearOre;
	public BooleanValue rabbitOre;
	public BooleanValue sheepOre;
	public BooleanValue skeletonOre;
	public BooleanValue slimeOre;
	public BooleanValue snowGolemOre;
	public BooleanValue spiderOre;
	public BooleanValue squidOre;
	public BooleanValue strayOre;
	public BooleanValue turtleOre;
	public BooleanValue villagerOre;
	public BooleanValue vindicatorOre;
	public BooleanValue witchOre;
	public BooleanValue witherOre;
	public BooleanValue witherSkeletonOre;
	public BooleanValue wolfOre;
	public BooleanValue zombieOre;
	public BooleanValue zombiePigmanOre;
	public BooleanValue catOre;
	public BooleanValue endermiteOre;
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

		stairHeight = builder.comment("The length and height of the Instant Stair items").translation("config.dangerzone.prop.stairheight.desc").defineInRange("stairHeight", 32, 0, 128);

		builder.pop();

		builder.comment("World gen").push("world_gen");

		shouldEggOresGenerate = builder.comment("Should Petrified Spawn Eggs generate")
		.translation("config.dangerzone.prop.egg_ores.desc")
		.define("ShouldEggOresGenerate", true);

		builder.pop();

		builder.push("egg_ore_world_gen");

		batOre = addOreConfig(builder, "Bat");
		blazeOre = addOreConfig(builder, "Blaze");
		cavespiderOre = addOreConfig(builder, "Cave", "Spider");
		chickenOre = addOreConfig(builder, "Chicken");
		cowOre = addOreConfig(builder, "Cow");
		creeperOre = addOreConfig(builder, "Creeper");
		dolphinOre = addOreConfig(builder, "Dolphin");
		donkeyOre = addOreConfig(builder, "Donkey");
		drownedOre = addOreConfig(builder, "Drowned");
		elderGuardianOre = addOreConfig(builder, "Elder", "Guardian");
		enderDragonOre = addOreConfig(builder, "Ender", "Dragon");
		endermanOre = addOreConfig(builder, "Enderman");
		evokerOre = addOreConfig(builder, "Evoker");
		guardianOre = addOreConfig(builder, "Guardian");
		horseOre = addOreConfig(builder, "Horse");
		huskOre = addOreConfig(builder, "Husk");
		ironGolemOre = addOreConfig(builder, "Iron", "Golem");
		llamaOre = addOreConfig(builder, "Llama");
		magmacubeOre = addOreConfig(builder, "Magma", "Cube");
		mooshroomOre = addOreConfig(builder, "Mooshroom");
		ocelotOre = addOreConfig(builder, "Ocelot");
		pandabearOre = addOreConfig(builder, "Panda", "Bear");
		parrotOre = addOreConfig(builder, "Parrot");
		phantomOre = addOreConfig(builder, "Phantom");
		pigOre = addOreConfig(builder, "Pig");
		polarbearOre = addOreConfig(builder, "Polar", "Bear");
		rabbitOre = addOreConfig(builder, "Rabbit");
		sheepOre = addOreConfig(builder, "Sheep");
		skeletonOre = addOreConfig(builder, "Skeleton");
		slimeOre = addOreConfig(builder, "Slime");
		snowGolemOre = addOreConfig(builder, "Snow", "Golem");
		spiderOre = addOreConfig(builder, "Spider");
		squidOre = addOreConfig(builder, "Squid");
		strayOre = addOreConfig(builder, "Stray");
		turtleOre = addOreConfig(builder, "Turtle");
		villagerOre = addOreConfig(builder, "Villager");
		vindicatorOre = addOreConfig(builder, "Vindicator");
		witchOre = addOreConfig(builder, "Witch");
		witherOre = addOreConfig(builder, "Wither");
		witherSkeletonOre = addOreConfig(builder, "Wither", "Skeleton");
		wolfOre = addOreConfig(builder, "Wolf");
		zombieOre = addOreConfig(builder, "Zombie");
		zombiePigmanOre = addOreConfig(builder, "Zombie", "Pigman");
		catOre = addOreConfig(builder, "Cat");
		endermiteOre = addOreConfig(builder, "Endermite");
		foxOre = addOreConfig(builder, "Fox");
		ghastOre = addOreConfig(builder, "Ghast");
		pillagerOre = addOreConfig(builder, "Pillager");
		ravagerOre = addOreConfig(builder, "Ravager");
		shulkerOre = addOreConfig(builder, "Shulker");

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
