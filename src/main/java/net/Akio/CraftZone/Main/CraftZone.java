package net.Akio.CraftZone.Main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.Akio.CraftZone.Main.Blocks.BlockMobOre;
import net.Akio.CraftZone.Main.Blocks.Pizza;
import net.Akio.CraftZone.Main.Blocks.Ruby_Block;
import net.Akio.CraftZone.Main.Foods.*;
import net.Akio.CraftZone.Main.Items.Critter_Cage;
import net.Akio.CraftZone.Main.Materials.Amethyst;
import net.Akio.CraftZone.Main.Materials.Ruby;
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

@Mod(modid = CraftZone.MOD_ID, version = CraftZone.MC_VERSION)

public class CraftZone {

	public static final String MOD_AUTHOR = "Katara";
	public static final String MOD_CODER = "Akio";
    public static final String MOD_ID = "DangerZone";
    public static final String MC_VERSION = "1.7.10";
    public static final double MOD_VERSION = 1.0;
    
    public static final Item.ToolMaterial AmethystMaterials = EnumHelper.addToolMaterial("AmethystMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldMaterials = EnumHelper.addToolMaterial("EmeraldMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial EmeraldPickaxe = EnumHelper.addToolMaterial("EmeraldPickaxe", 3, 1300, 10F, 6F, 75);
    public static final Item.ToolMaterial RubyMaterials = EnumHelper.addToolMaterial("RubyMaterials", 2, 192, 5.0F, 1.5F, 12);
    public static final Item.ToolMaterial RubyAxe = EnumHelper.addToolMaterial("RubyAxe", 5, 1500, 11F, 16F, 70);
    public static final Item.ToolMaterial AmethystAxe = EnumHelper.addToolMaterial("AmethystAxe", 5, 1500, 11F, 10F, 70);
    public static final Item.ToolMaterial UltimatePick = EnumHelper.addToolMaterial("UltimatePick", 5, 1500, 11F, 36F, 70);
    public static final Item.ToolMaterial RubyPick = EnumHelper.addToolMaterial("RubyPick`", 5, 1500, 11F, 16F, 70);
	public static final Item.ToolMaterial CrystalWood = EnumHelper.addToolMaterial("CrystalWood", 2, 300, 3, 2, 15);

	//Ores
    public static boolean oreGenCow;
	public static int oreSizeCow;
	public static int oreRarityCow;
	public static int oreMaxHeightCow;
	public static boolean oreGenVillager;
	public static int oreSizeVillager;
	public static int oreRarityVillager;
	public static int oreMaxHeightVillager;

    public static Item ruby_pickaxe;
    public static Item ultimate_pickaxe;
    public static Item critter_cage;
    public static Item salt;
	public static Item crystal_wood_axe;

    public static Block ruby_block;
    public static Block Dried_cow;
    public static Block Dried_Villager;

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




	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(new File("config/DangerZone/DZConfig.cfg"));

		oreGenCow = config.getBoolean("Generation", "0.0: Petrified Cow Ore", true, "");
		oreSizeCow = config.getInt("Chunk Size", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreRarityCow = config.getInt("Gen Rate", "0.0: Petrified Cow Ore", 3, 1, 100, "");
		oreMaxHeightCow = config.getInt("Max Height", "0.0: Petrified Cow Ore", 125, 1, 255, "");

		oreGenVillager = config.getBoolean("Generation", "0.0: Petrified Villager Ore", true, "");
		oreSizeVillager = config.getInt("Chunk Size", "0.0: Petrified Villager Ore", 8, 1, 100, "");
		oreRarityVillager = config.getInt("Gen Rate", "0.0: Petrified Villager Ore", 3, 1, 100, "");
		oreMaxHeightVillager = config.getInt("Max Height", "0.0: Petrified Villager Ore", 125, 1, 255, "");

    //	uby = new Ruby().setUnlocalizedName("Ruby").setTextureName("dangerzone:ruby");
    //	GameRegistry.registerItem(uby, uby.getUnlocalizedName().substring(5));
    	
    //	ruby_block = new Ruby_Block(0).setBlockName("Ruby_Block").setBlockTextureName("dangerzone:blockruby");
    	//GameRegistry.registerBlock(ruby_block, ruby_block.getUnlocalizedName().substring(5));
    	
    	Dried_cow = new BlockMobOre(1).setBlockName("Petrified_Cow_ore").setBlockTextureName("dangerzone:Ore_Cow");
    	GameRegistry.registerBlock(Dried_cow, Dried_cow.getUnlocalizedName().substring(5));
    	
    	Dried_Villager = new BlockMobOre(1).setBlockName("Petrified_Villager_Ore").setBlockTextureName("dangerzone:Ore_Villager");
    	GameRegistry.registerBlock(Dried_Villager, Dried_Villager.getUnlocalizedName().substring(5));
    	
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


    	//emerald_pickaxe = new Emerald_Pickaxe(EmeraldPickaxe).setUnlocalizedName("Emerald_Pickaxe").setTextureName("dangerzone:emerald_pickaxe");
    	//GameRegistry.registerItem(emerald_pickaxe, emerald_pickaxe.getUnlocalizedName().substring(5));
    	
    	emerald_hoe = new Emerald_Hoe(EmeraldMaterials).setUnlocalizedName("Emerald_Hoe").setTextureName("dangerzone:emerald_hoe");
    	GameRegistry.registerItem(emerald_hoe, emerald_hoe.getUnlocalizedName().substring(5));

    	//amethyst_pickaxe = new Amethyst_Pickaxe(AmethystMaterials).setUnlocalizedName("Amethyst_Pickaxe").setTextureName("dangerzone:amethyst_pickaxe");
    //	GameRegistry.registerItem(amethyst_pickaxe, amethyst_pickaxe.getUnlocalizedName().substring(5));

    	amethyst_axe = new Amethyst_Axe(AmethystAxe).setUnlocalizedName("Amethyst_Axe").setTextureName("dangerzone:amethyst_axe");
    	GameRegistry.registerItem(amethyst_axe, amethyst_axe.getUnlocalizedName().substring(5));

		pizza = new Critter_Cage().setUnlocalizedName("Pizza").setTextureName("dangerzone:pizza");
		GameRegistry.registerItem(pizza, pizza.getUnlocalizedName().substring(5));

		red_ant_robot_kit = new Critter_Cage().setUnlocalizedName("Ant_Robot_Kit").setTextureName("dangerzone:red_ant_robot_kit");
		GameRegistry.registerItem(red_ant_robot_kit, red_ant_robot_kit.getUnlocalizedName().substring(5));

    	ruby_axe = new Ruby_Axe(RubyAxe).setUnlocalizedName("Ruby_Axe").setTextureName("dangerzone:ruby_axe");
    	GameRegistry.registerItem(ruby_axe, ruby_axe.getUnlocalizedName().substring(5));

		crystal_wood_axe = new Crystal_Wood_Axe(CrystalWood).setUnlocalizedName("Crystal_Wood_Axe").setTextureName("dangerzone:crystal_wood_axe");
		GameRegistry.registerItem(crystal_wood_axe, crystal_wood_axe.getUnlocalizedName().substring(5));

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

    }
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    //	GameRegistry.addRecipe(new ItemStack(ruby_axe), new Object[]{"RR ", "RS ", " S ", 'R', CraftZone.uby, 'S', Items.stick});
    	
 //   	GameRegistry.addRecipe(new ItemStack(emerald_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', Blocks.emerald_block, 'S', Items.stick});
    	
   // 	GameRegistry.addRecipe(new ItemStack(ruby_pickaxe), new Object[]{"DDD", " S ", " S ", 'D', CraftZone.uby, 'S', Items.stick});

    	GameRegistry.addRecipe(new ItemStack(emerald_hoe), new Object[]{"DD ", " S ", " S ", 'D', Blocks.emerald_block, 'S', Items.stick});

    	//GameRegistry.addRecipe(new ItemStack(uby, 9), new Object[]{"U", 'U', ruby_block});
    	
    //	GameRegistry.addRecipe(new ItemStack(ruby_block), new Object[] {"DDD", "DDD", "DDD", 'D', CraftZone.uby});
    	
    	GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 92), new Object[] {"D", "W", 'D', CraftZone.Dried_cow, 'W', Items.water_bucket});
    	
    	GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 120), new Object[] {"D", "W", 'D', CraftZone.Dried_Villager, 'W', Items.water_bucket});

		//GameRegistry.addShapelessRecipe(new ItemStack(butter_candy, 4), new Object[]{"B", "U", 'B', CraftZone.butter, 'U', Items.sugar});
		GameRegistry.addShapelessRecipe(new ItemStack(butter_candy,4), new Object[] {new ItemStack(CraftZone.butter,1), new ItemStack(Items.sugar )});
	}
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
   
}
