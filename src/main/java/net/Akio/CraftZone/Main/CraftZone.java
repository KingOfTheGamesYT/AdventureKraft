package net.Akio.CraftZone.Main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.Akio.CraftZone.Main.Blocks.BlockMobOre;
import net.Akio.CraftZone.Main.Blocks.CreeperRepellent;
import net.Akio.CraftZone.Main.Blocks.ExtremeTorch;
import net.Akio.CraftZone.Main.Blocks.KrakenRepellent;
import net.Akio.CraftZone.Main.Foods.*;
import net.Akio.CraftZone.Main.Items.CZSpawnEgg;
import net.Akio.CraftZone.Main.Items.Critter_Cage;
import net.Akio.CraftZone.Main.Items.MinersDream;
import net.Akio.CraftZone.Main.Items.Rock;
import net.Akio.CraftZone.Main.Materials.Salt;
import net.Akio.CraftZone.Main.Tools.*;

import net.Akio.CraftZone.Main.world.gen.Oregen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;
import java.util.Random;

@Mod(modid = CraftZone.MOD_ID, version = CraftZone.MC_VERSION)

public class CraftZone {

	public static final String MOD_AUTHOR = "RedRoseWarrior1";
	public static final String MOD_CODER = "Akio, RedRoseWarrior1";
    public static final String MOD_ID = "DangerZone";
    public static final String MC_VERSION = "1.7.10";
    public static final double MOD_VERSION = 1.0;
    
    public static final Item.ToolMaterial AmethystMaterials = EnumHelper.addToolMaterial("AmethystMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldMaterials = EnumHelper.addToolMaterial("EmeraldMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldPickaxe = EnumHelper.addToolMaterial("EmeraldPickaxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial RubyMaterials = EnumHelper.addToolMaterial("RubyMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial RubyAxe = EnumHelper.addToolMaterial("RubyAxe", 5, 1500, 11F, 16F, 70);
    public static final Item.ToolMaterial AmethystAxe = EnumHelper.addToolMaterial("AmethystAxe", 5, 1500, 11F, 11F, 70);
    public static final Item.ToolMaterial UltimatePick = EnumHelper.addToolMaterial("UltimatePick", 5, 1500, 11F, 36F, 70);
    public static final Item.ToolMaterial RubyPick = EnumHelper.addToolMaterial("RubyPick`", 5, 1500, 11F, 16F, 70);
	public static final Item.ToolMaterial CrystalWood = EnumHelper.addToolMaterial("CrystalWood", 2, 300, 3, 2, 15);
	public static final Item.ToolMaterial Crystal = EnumHelper.addToolMaterial("Crystal", 3, 800, 6, 5, 45);
	public static final Item.ToolMaterial MantisClaw = EnumHelper.addToolMaterial("MantisClaw", 2, 192, 5.0F, 11F, 12);

	//Ores
    public static boolean oreGenCow;
	public static int oreSizeCow;
	public static int oreRarityCow;
	public static int oreMaxHeightCow;
	public static boolean oreGenVillager;
	public static int oreSizeVillager;
	public static int oreRarityVillager;
	public static int oreMaxHeightVillager;
	public static boolean oreGenChicken;
	public static int oreSizeChicken;
	public static int oreRarityChicken;
	public static int oreMaxHeightChicken;
	public static boolean oreGenCreeper;
	public static int oreSizeCreeper;
	public static int oreRarityCreeper;
	public static int oreMaxHeightCreeper;
	public static boolean oreGenCaveSpider;
	public static int oreSizeCaveSpider;
	public static int oreRarityCaveSpider;
	public static int oreMaxHeightCaveSpider;
	public static boolean oreGenSlime;
	public static int oreSizeSlime;
	public static int oreRaritySlime;
	public static int oreMaxHeightSlime;
	public static boolean oreGenSquid;
	public static int oreSizeSquid;
	public static int oreRaritySquid;
	public static int oreMaxHeightSquid;
	public static boolean oreGenPig;
	public static int oreSizePig;
	public static int oreRarityPig;
	public static int oreMaxHeightPig;
	public static boolean oreGenWolf;
	public static int oreSizeWolf;
	public static int oreRarityWolf;
	public static int oreMaxHeightWolf;
	public static boolean oreGenIronGolem;
	public static int oreSizeIronGolem;
	public static int oreRarityIronGolem;
	public static int oreMaxHeightIronGolem;
	public static Random Rand = new Random(151L);
    public static Item ruby_pickaxe;
    public static Item ultimate_pickaxe;
    public static Item critter_cage;
    public static Item salt;
	public static Item crystal_wood_axe;
	public static Item crystal_pickaxe;
	public static Item big_hammer;
	public static Item peacock_feather;
	public static Item vortex_eye;
	public static Item kraken_tooth;
	public static Item pink_tourmaline_ingot;
    public static Block ruby_block;
    public static Block Dried_cow;
    public static Block Dried_Villager;
	public static Block Dried_Creeper;
	public static Block Dried_pig;
	public static Block Dried_cave_spider;
	public static Block Dried_chicken;
	public static Block Dried_Squid;
	public static Block Dried_Slime;
	public static Block Dried_Wolf;
	public static Block apple_tree_leaves;
	public static Block Dried_Iron_Golem;
	public static Item crystal_shards;
	public static Item cheese;
    public static Item butter;
    public static Item butter_candy;
	public static Item ruby_axe;
    public static Item amethyst_pickaxe;
    public static Item amethyst_axe;
    public static Item emerald_hoe;
    public static Item emerald_pickaxe;
    public static Item fire_fish;
    public static Item uby;
    public static Item amethyst;
	public static Item raw_crab;
	public static Item crabby_patty;
	public static Item salad;
	public static Item spark_fish;
	public static Item pizza;
	public static Item raw_corn_dog;
	public static Item red_ant_robot_kit;
	public static Item wrench;
	public static Item crystal_axe;
	public static Item mantis_claw;
	public static Item flame_rock;
	public static Item explosive_rock;
	public static Item poison_rock;
	public static Item small_rock;
	public static Item godzilla_scale;
	public static Item zangesu;
	public static Item katter_killer_jaw;
	public static Item miners_dream;
	public static Item blue_fish;
	public static Block Dried_Snow_Golem;
	public static Item Snow_Golem_Spawn_Egg;
	public static Item Iron_Golem_Spawn_Egg;
	public static boolean oreGenSnowGolem;
	public static int oreSizeSnowGolem;
	public static int oreRaritySnowGolem;
	public static int oreMaxHeightSnowGolem;
	public static Block Dried_Girl;
	public static int oreSizeGirl;
	public static int oreRarityGirl;
	public static int oreMaxHeightGirl;
	public static boolean OreGenGirl;
	public static Block Extreme_Torch;
	public static Block Kraken_Repellent;
	public static Block Creeper_Repellent;
	public static Item Girl_Spawn_Egg;


	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(new File("config/DangerZone/DZConfig.cfg"));

		oreGenCow = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeCow = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityCow = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightCow = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");


		oreGenIronGolem= config.getBoolean("Generation", "0.0: Petrified Iron Golem Ore", true, "");
		oreSizeIronGolem = config.getInt("Chunk Size", "0.0: Petrified Iron Golem Ore", 3, 1, 100, "");
		oreRarityIronGolem = config.getInt("Gen Rate", "0.0: Petrified Iron Golem Ore", 3, 1, 100, "");
		oreMaxHeightIronGolem = config.getInt("Max Height", "0.0: Petrified Iron Golem Ore", 125, 1, 255, "");

		oreGenPig = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizePig = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityPig = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightPig = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenChicken = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeChicken = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityChicken = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightChicken = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenCreeper = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeCreeper = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityCreeper = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightCreeper = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenSlime = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeSlime = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRaritySlime = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightSlime = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenSquid = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeSquid = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRaritySquid = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightSquid = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenWolf = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeWolf = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityWolf = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightWolf = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenCaveSpider = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeCaveSpider = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityCaveSpider = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightCaveSpider = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		OreGenGirl = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeGirl = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityGirl = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightGirl = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenVillager = config.getBoolean("Generation", "0.0: Petrified Villager Ore", true, "");
		oreSizeVillager = config.getInt("Chunk Size", "0.0: Petrified Villager Ore", 8, 1, 100, "");
		oreRarityVillager = config.getInt("Gen Rate", "0.0: Petrified Villager Ore", 3, 1, 100, "");
		oreMaxHeightVillager = config.getInt("Max Height", "0.0: Petrified Villager Ore", 125, 1, 255, "");

		oreGenSnowGolem = config.getBoolean("Generation", "0.0: Petrified Snow Golem Ore", true, "");
		oreSizeSnowGolem = config.getInt("Chunk Size", "0.0: Petrified Snow Golem Ore", 8, 1, 100, "");
		oreRaritySnowGolem = config.getInt("Gen Rate", "0.0: Petrified Snow Golem Ore", 3, 1, 100, "");
		oreMaxHeightSnowGolem = config.getInt("Max Height", "0.0: Petrified Snow Golem Ore", 125, 1, 255, "");

		//	uby = new Ruby().setUnlocalizedName("Ruby").setTextureName("dangerzone:ruby");
    //	GameRegistry.registerItem(uby, uby.getUnlocalizedName().substring(5));
    	
    //	ruby_block = new Ruby_Block(0).setBlockName("Ruby_Block").setBlockTextureName("dangerzone:blockruby");
    	//GameRegistry.registerBlock(ruby_block, ruby_block.getUnlocalizedName().substring(5));
    	
    	Dried_cow = new BlockMobOre(1).setBlockName("Petrified_Cow_ore").setBlockTextureName("dangerzone:Ore_Cow");
    	GameRegistry.registerBlock(Dried_cow, Dried_cow.getUnlocalizedName().substring(5));

		Extreme_Torch = new ExtremeTorch(1).setBlockName("Extreme_Torch").setBlockTextureName("dangerzone:Extreme_Torch");
		GameRegistry.registerBlock(Extreme_Torch, Extreme_Torch.getUnlocalizedName().substring(5));

		Kraken_Repellent = new KrakenRepellent(1).setBlockName("Kraken_Repellent").setBlockTextureName("dangerzone:Kraken_Repellent");
		GameRegistry.registerBlock(Kraken_Repellent, Kraken_Repellent.getUnlocalizedName().substring(5));

		Creeper_Repellent = new CreeperRepellent(1).setBlockName("Creeper_Repellent").setBlockTextureName("dangerzone:Creeper_Repellent");
		GameRegistry.registerBlock(Creeper_Repellent, Creeper_Repellent.getUnlocalizedName().substring(5));

		Dried_Snow_Golem = new BlockMobOre(1).setBlockName("Petrified_Snow_Golem_ore").setBlockTextureName("dangerzone:Ore_Snow_Golem");
		GameRegistry.registerBlock(Dried_Snow_Golem, Dried_Snow_Golem.getUnlocalizedName().substring(5));

		Dried_Iron_Golem = new BlockMobOre(1).setBlockName("Petrified_Iron_Golem_ore").setBlockTextureName("dangerzone:Ore_Iron_Golem");
		GameRegistry.registerBlock(Dried_Iron_Golem, Dried_Iron_Golem.getUnlocalizedName().substring(5));

		Dried_Villager = new BlockMobOre(1).setBlockName("Petrified_Villager_Ore").setBlockTextureName("dangerzone:Ore_Villager");
    	GameRegistry.registerBlock(Dried_Villager, Dried_Villager.getUnlocalizedName().substring(5));

		Dried_chicken = new BlockMobOre(1).setBlockName("Petrified_Chicken_ore").setBlockTextureName("dangerzone:Ore_Chicken");
		GameRegistry.registerBlock(Dried_chicken, Dried_chicken.getUnlocalizedName().substring(5));

		Dried_cave_spider = new BlockMobOre(1).setBlockName("Petrified_Cave_Spider_ore").setBlockTextureName("dangerzone:Ore_Cave_Spider");
		GameRegistry.registerBlock(Dried_cave_spider, Dried_cave_spider.getUnlocalizedName().substring(5));

		Dried_Creeper = new BlockMobOre(1).setBlockName("Petrified_Creeper_ore").setBlockTextureName("dangerzone:Ore_Creeper");
		GameRegistry.registerBlock(Dried_Creeper, Dried_Creeper.getUnlocalizedName().substring(5));

		Dried_Slime = new BlockMobOre(1).setBlockName("Petrified_Slime_ore").setBlockTextureName("dangerzone:Ore_Slime");
		GameRegistry.registerBlock(Dried_Slime, Dried_Slime.getUnlocalizedName().substring(5));

		Dried_Squid = new BlockMobOre(1).setBlockName("Petrified_Squid_ore").setBlockTextureName("dangerzone:Ore_Squid");
		GameRegistry.registerBlock(Dried_Squid, Dried_Squid.getUnlocalizedName().substring(5));

		Dried_pig = new BlockMobOre(1).setBlockName("Petrified_Pig_ore").setBlockTextureName("dangerzone:Ore_Pig");
		GameRegistry.registerBlock(Dried_pig, Dried_pig.getUnlocalizedName().substring(5));

		Dried_Wolf = new BlockMobOre(1).setBlockName("Petrified_Wolf_ore").setBlockTextureName("dangerzone:Ore_Wolf");
		GameRegistry.registerBlock(Dried_Wolf, Dried_Wolf.getUnlocalizedName().substring(5));

		Dried_Girl = new BlockMobOre(1).setBlockName("Petrified_Girl_ore").setBlockTextureName("dangerzone:Ore_Girl");
		GameRegistry.registerBlock(Dried_Girl, Dried_Girl.getUnlocalizedName().substring(5));

		//	amethyst = new Amethyst().setUnlocalizedName("Amethyst").setTextureName("dangerzone:amethyst");
    //	GameRegistry.registerItem(amethyst, amethyst.getUnlocalizedName().substring(5));
    	
    	fire_fish = new Fire_Fish(10, 8, 0.60F, true).setUnlocalizedName("Fire_Fish").setTextureName("dangerzone:fire_fish");
    	GameRegistry.registerItem(fire_fish, fire_fish.getUnlocalizedName().substring(5));

		spark_fish = new SparkFish(10, 1, 0.2F, true).setUnlocalizedName("Spark_Fish").setTextureName("dangerzone:raw_spark_fish");
		GameRegistry.registerItem(spark_fish, spark_fish.getUnlocalizedName().substring(5));
    	
    	butter_candy = new Butter_Candy(10, 4, 0.5f, true).setUnlocalizedName("Butter_Candy").setTextureName("dangerzone:butter_candy");
    	GameRegistry.registerItem(butter_candy, butter_candy.getUnlocalizedName().substring(5));
    	
    	butter = new Butter(10, 1, 0.5f, true).setUnlocalizedName("Butter").setTextureName("dangerzone:butter");
    	GameRegistry.registerItem(butter, butter.getUnlocalizedName().substring(5));
    	
    	cheese = new Cheese(10, 4, 0.5F, true).setUnlocalizedName("Cheese").setTextureName("dangerzone:cheese");
    	GameRegistry.registerItem(cheese, cheese.getUnlocalizedName().substring(5));

		raw_corn_dog = new Cheese(10, 4, 0.6F, true).setUnlocalizedName("Raw_Corn_Dog").setTextureName("dangerzone:raw_corn_dog");
		GameRegistry.registerItem(raw_corn_dog, raw_corn_dog.getUnlocalizedName().substring(5));

		raw_crab = new Cheese(10, 4, 0.25F, true).setUnlocalizedName("Raw_Crab").setTextureName("dangerzone:raw_crab");
		GameRegistry.registerItem(raw_crab, raw_crab.getUnlocalizedName().substring(5));

		Snow_Golem_Spawn_Egg = (new CZSpawnEgg(10, 194)).setUnlocalizedName("Snow_Golem_Spawn_Egg").setTextureName("dangerzone:snow_golem_spawn_egg");
		GameRegistry.registerItem(Snow_Golem_Spawn_Egg, Snow_Golem_Spawn_Egg.getUnlocalizedName().substring(5));

		Girl_Spawn_Egg = (new CZSpawnEgg(10, 194)).setUnlocalizedName("Girl_Spawn_Egg").setTextureName("dangerzone:girl_spawn_egg");
		GameRegistry.registerItem(Girl_Spawn_Egg, Girl_Spawn_Egg.getUnlocalizedName().substring(5));

		Iron_Golem_Spawn_Egg = (new CZSpawnEgg(10, 195)).setUnlocalizedName("Iron_Golem_Spawn_Egg").setTextureName("dangerzone:iron_golem_spawn_egg");
		GameRegistry.registerItem(Iron_Golem_Spawn_Egg, Iron_Golem_Spawn_Egg.getUnlocalizedName().substring(5));

		//emerald_pickaxe = new Emerald_Pickaxe(EmeraldPickaxe).setUnlocalizedName("Emerald_Pickaxe").setTextureName("dangerzone:emerald_pickaxe");
    	//GameRegistry.registerItem(emerald_pickaxe, emerald_pickaxe.getUnlocalizedName().substring(5));
    	
    	emerald_hoe = new Emerald_Hoe(EmeraldMaterials).setUnlocalizedName("Emerald_Hoe").setTextureName("dangerzone:emerald_hoe");
    	GameRegistry.registerItem(emerald_hoe, emerald_hoe.getUnlocalizedName().substring(5));

		big_hammer = new Big_Hammer(AmethystAxe).setUnlocalizedName("Big_Hammer").setTextureName("dangerzone:big_hammer");
		GameRegistry.registerItem(big_hammer, big_hammer.getUnlocalizedName().substring(5));

		mantis_claw = new MantisClaw(MantisClaw).setUnlocalizedName("Mantis_Claw").setTextureName("dangerzone:mantis_claw");
		GameRegistry.registerItem(mantis_claw, mantis_claw.getUnlocalizedName().substring(5));

		//amethyst_pickaxe = new Amethyst_Pickaxe(AmethystMaterials).setUnlocalizedName("Amethyst_Pickaxe").setTextureName("dangerzone:amethyst_pickaxe");
    //	GameRegistry.registerItem(amethyst_pickaxe, amethyst_pickaxe.getUnlocalizedName().substring(5));

    	amethyst_axe = new Amethyst_Axe(AmethystAxe).setUnlocalizedName("Amethyst_Axe").setTextureName("dangerzone:amethyst_axe");
    	GameRegistry.registerItem(amethyst_axe, amethyst_axe.getUnlocalizedName().substring(5));

		pizza = new Critter_Cage().setUnlocalizedName("Pizza").setTextureName("dangerzone:pizza");
		GameRegistry.registerItem(pizza, pizza.getUnlocalizedName().substring(5));

		godzilla_scale = new Critter_Cage().setUnlocalizedName("Godzilla_Scale").setTextureName("dangerzone:godzilla_scale");
		GameRegistry.registerItem(godzilla_scale, godzilla_scale.getUnlocalizedName().substring(5));

		zangesu = new Critter_Cage().setUnlocalizedName("Zangesu_Guard").setTextureName("dangerzone:zangesu_guard");
		GameRegistry.registerItem(zangesu, zangesu.getUnlocalizedName().substring(5));

		peacock_feather = new Critter_Cage().setUnlocalizedName("Peacock_Feather").setTextureName("dangerzone:peacock_feather");
		GameRegistry.registerItem(peacock_feather, peacock_feather.getUnlocalizedName().substring(5));

		kraken_tooth = new Critter_Cage().setUnlocalizedName("Kraken_Tooth").setTextureName("dangerzone:kraken_tooth");
		GameRegistry.registerItem(kraken_tooth, kraken_tooth.getUnlocalizedName().substring(5));

		pink_tourmaline_ingot = new Critter_Cage().setUnlocalizedName("Pink_Tourmaline_Ingot").setTextureName("dangerzone:pink_tourmaline_ingot");
		GameRegistry.registerItem(pink_tourmaline_ingot, pink_tourmaline_ingot.getUnlocalizedName().substring(5));

		vortex_eye = new Critter_Cage().setUnlocalizedName("Vortex_Eye").setTextureName("dangerzone:vortex_eye");
		GameRegistry.registerItem(vortex_eye, vortex_eye.getUnlocalizedName().substring(5));

		katter_killer_jaw = new Critter_Cage().setUnlocalizedName("Katter_Killer_Jaw").setTextureName("dangerzone:katter_killer_jaw");
		GameRegistry.registerItem(katter_killer_jaw, katter_killer_jaw.getUnlocalizedName().substring(5));

		miners_dream = new MinersDream(3).setUnlocalizedName("Miners_Dream").setTextureName("dangerzone:miners_dream");
		GameRegistry.registerItem(miners_dream, miners_dream.getUnlocalizedName().substring(5));

		crystal_shards = new Critter_Cage().setUnlocalizedName("Crystal_Shards").setTextureName("dangerzone:crystal_shards");
		GameRegistry.registerItem(crystal_shards, crystal_shards.getUnlocalizedName().substring(5));

		flame_rock = new Rock(3).setUnlocalizedName("Flame_Rock").setTextureName("dangerzone:flame_rock");
		GameRegistry.registerItem(flame_rock, flame_rock.getUnlocalizedName().substring(5));

		explosive_rock = new Rock(3).setUnlocalizedName("Explosive_Rock").setTextureName("dangerzone:explosive_rock");
		GameRegistry.registerItem(explosive_rock, explosive_rock.getUnlocalizedName().substring(5));

		poison_rock = new Rock(3).setUnlocalizedName("Poison_Rock").setTextureName("dangerzone:poison_rock");
		GameRegistry.registerItem(poison_rock, poison_rock.getUnlocalizedName().substring(5));

		small_rock = new Rock(3).setUnlocalizedName("Small_Rock").setTextureName("dangerzone:small_rock");
		GameRegistry.registerItem(small_rock, small_rock.getUnlocalizedName().substring(5));

		red_ant_robot_kit = new Critter_Cage().setUnlocalizedName("Ant_Robot_Kit").setTextureName("dangerzone:red_ant_robot_kit");
		GameRegistry.registerItem(red_ant_robot_kit, red_ant_robot_kit.getUnlocalizedName().substring(5));

		wrench = new Critter_Cage().setUnlocalizedName("Wrench").setTextureName("dangerzone:wrench");
		GameRegistry.registerItem(wrench, wrench.getUnlocalizedName().substring(5));

		ruby_axe = new Ruby_Axe(RubyAxe).setUnlocalizedName("Ruby_Axe").setTextureName("dangerzone:ruby_axe");
    	GameRegistry.registerItem(ruby_axe, ruby_axe.getUnlocalizedName().substring(5));

		crystal_axe = new Ruby_Axe(Crystal).setUnlocalizedName("Crystal_Axe").setTextureName("dangerzone:crystal_axe");
		GameRegistry.registerItem(crystal_axe, crystal_axe.getUnlocalizedName().substring(5));

		crystal_wood_axe = new Crystal_Wood_Axe(CrystalWood).setUnlocalizedName("Crystal_Wood_Axe").setTextureName("dangerzone:crystal_wood_axe");
		GameRegistry.registerItem(crystal_wood_axe, crystal_wood_axe.getUnlocalizedName().substring(5));

		crystal_pickaxe = new Crystal_Pickaxe(Crystal).setUnlocalizedName("Crystal_Pickaxe").setTextureName("dangerzone:crystal_pickaxe");
		GameRegistry.registerItem(crystal_pickaxe, crystal_pickaxe.getUnlocalizedName().substring(5));

		salt = new Salt().setUnlocalizedName("Salt").setTextureName("dangerzone:salt");
		GameRegistry.registerItem(salt, salt.getUnlocalizedName().substring(5));
    	
    //	critter_cage = new Critter_Cage().setUnlocalizedName("Critter_Cage").setTextureName("dangerzone:critter_cage");
    //	GameRegistry.registerItem(critter_cage, critter_cage.getUnlocalizedName().substring(5));
    	
    	ultimate_pickaxe = new Ultimate_Pickaxe(UltimatePick).setUnlocalizedName("Ultimate_Pickaxe").setTextureName("dangerzone:ultimate_pickaxe");
    	GameRegistry.registerItem(ultimate_pickaxe, ultimate_pickaxe.getUnlocalizedName().substring(5));
    	
    	//ruby_pickaxe = new Ruby_Pickaxe(RubyPick).setUnlocalizedName("Ruby_Pickaxe").setTextureName("dangerzone:rubypickaxe");
    	//GameRegistry.registerItem(ruby_pickaxe, ruby_pickaxe.getUnlocalizedName().substring(5));

		crabby_patty = new Cheese(10, 16, 2.35F, true).setUnlocalizedName("Crabby_Patty").setTextureName("dangerzone:crabby_patty");
		GameRegistry.registerItem(crabby_patty, crabby_patty.getUnlocalizedName().substring(5));

		salad = new Cheese(10, 10, 0.955F, true).setUnlocalizedName("Salad").setTextureName("dangerzone:salad");
		GameRegistry.registerItem(salad, salad.getUnlocalizedName().substring(5));

		GameRegistry.registerWorldGenerator(new Oregen(), 0);

		blue_fish = new Cheese(10, 4, 0.4F, true).setUnlocalizedName("Blue_Fish").setTextureName("dangerzone:blue_fish");
		GameRegistry.registerItem(blue_fish, blue_fish.getUnlocalizedName().substring(5));
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    //	GameRegistry.addRecipe(new ItemStack(ruby_axe), new Object[]{"RR ", "RS ", " S ", 'R', CraftZone.uby, 'S', Items.stick});
    	
 //   	GameRegistry.addRecipe(new ItemStack(emerald_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', Blocks.emerald_block, 'S', Items.stick});
    	
   // 	GameRegistry.addRecipe(new ItemStack(ruby_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', CraftZone.uby, 'S', Items.stick});

	  GameRegistry.addShapelessRecipe(new ItemStack(cheese, 2), new Object[] {new ItemStack(Items.milk_bucket,4), new ItemStack(Items.milk_bucket, 4), new ItemStack(Items.milk_bucket,4), new ItemStack(Items.milk_bucket,4) });

    	GameRegistry.addRecipe(new ItemStack(emerald_hoe), new Object[]{"DD ", " S ", " S ", 'D', Blocks.emerald_block, 'S', Items.stick});

    	GameRegistry.addRecipe(new ItemStack(wrench), new Object[]{"D D", " D ", " D ", 'D', Items.iron_ingot});

    	//GameRegistry.addRecipe(new ItemStack(uby, 9), new Object[]{"U", 'U', ruby_block});
    	
    //	GameRegistry.addRecipe(new ItemStack(ruby_block), new Object[] {"DDD", "DDD", "DDD", 'D', CraftZone.uby});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 92), new Object[] {new ItemStack(CraftZone.Dried_cow), new ItemStack( Items.water_bucket)});

    	GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 194), new Object[] {new ItemStack(CraftZone.Dried_Snow_Golem), new ItemStack( Items.water_bucket)});

    	GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 195), new Object[] {new ItemStack(CraftZone.Dried_Iron_Golem), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 120), new Object[] {new ItemStack(CraftZone.Dried_Villager), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 93), new Object[] {new ItemStack(CraftZone.Dried_chicken), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 50), new Object[] {new ItemStack(CraftZone.Dried_Creeper), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 59), new Object[] {new ItemStack(CraftZone.Dried_cave_spider), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 55), new Object[] {new ItemStack(CraftZone.Dried_Slime), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 94), new Object[] {new ItemStack(CraftZone.Dried_Squid), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 90), new Object[] {new ItemStack(CraftZone.Dried_pig), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 95), new Object[] {new ItemStack(CraftZone.Dried_Wolf), new ItemStack( Items.water_bucket)});

		GameRegistry.addShapelessRecipe(new ItemStack(CraftZone.Girl_Spawn_Egg), new Object[] {new ItemStack(CraftZone.Dried_Girl), new ItemStack( Items.water_bucket)});

		//GameRegistry.addShapelessRecipe(new ItemStack(butter_candy, 4), new Object[]{"B", "U", 'B', CraftZone.butter, 'U', Items.sugar});
		GameRegistry.addShapelessRecipe(new ItemStack(butter_candy,4), new Object[] {new ItemStack(CraftZone.butter,1), new ItemStack(Items.sugar )});
	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
   
}
