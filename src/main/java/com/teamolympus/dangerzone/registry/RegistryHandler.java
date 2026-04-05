package com.teamolympus.dangerzone.registry;

import com.teamolympus.dangerzone.blocks.KrakenRepellentBlock;
import com.teamolympus.dangerzone.blocks.base.BaseAkPetrifiedBlock;
import com.teamolympus.dangerzone.items.base.*;
import com.teamolympus.dangerzone.items.base.tools.BaseAKAxe;
import com.teamolympus.dangerzone.items.base.tools.BaseAKHoe;
import com.teamolympus.dangerzone.items.base.tools.BaseAKSword;
import com.teamolympus.dangerzone.blocks.ExtremeTorchBlock;
import com.teamolympus.dangerzone.blocks.PizzaBlock;
import com.teamolympus.dangerzone.enums.EnumRockTypes;
import com.teamolympus.dangerzone.items.*;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.entity.RockEntity;
import com.teamolympus.dangerzone.entity.living.hostile.AllosaurusEntity;
import com.teamolympus.dangerzone.entity.living.hostile.MantisEntity;
import com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.BodyguardEntity;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class RegistryHandler {

    public static final Item.ToolMaterial emeraldHoeMaterials =
    registerHoe("emerald", 7, 5000, 10f, 5.0F, 75);

    public static final Item.ToolMaterial emeraldAxeMaterials =
    registerAxe("emerald", 7, 5600, 10f, 16.0F, 75);

    public static final Item.ToolMaterial emeraldShovelMaterials =
    registerShovel("emerald", 20, 5600, 10f, 10.0F, 75);

    public static final Item.ToolMaterial emeraldPicMaterials =
    registerPickaxe("emerald", 24, 5000, 10f, 16.0F, 75);

    public static final Item.ToolMaterial bigHammerMaterials =
    registerSword("bigHammer", 4, 1600, 70f, 24f, 70);

    public static final Item.ToolMaterial crystalAxeWoodMaterial =
    registerAxe("CrystalWood", 2, 300, 3f, 2f, 15);

    public static final Item.ToolMaterial rubyAxeMaterials =
    registerAxe("Ruby", 21, 13000, 11F, 25F, 85);

    public static final Item.ToolMaterial ultimatePicMaterials =
    registerPickaxe("Ultimate", 36, 25000, 15f, 80F, 100);

    public static final Item.ToolMaterial mantisClawMaterials =
    registerSword("MantisClaw", 4, 800, 10f, 14f, 75);

    public static final Item.ToolMaterial experienceSwordMaterials =
    registerSword("experience", 3, 1250, 10f, 22f, 75);

    public static final Item.ToolMaterial coarseAmethystAxeMaterials =
    registerAxe("amethyst", 28, 8200, 11f,20f, 70);

    public static void initPre()
    {
        addMobs();
        addBlocks();
        addItems();
    }

    public static void init()
    {
        addRecipe();
    }


    public static Block 
		petrifiedCow, petrifiedPig, pertifiedCreeper, petrifiedWolf, petrifiedCaveSpider,
        petrifiedSquid, petrifiedIronGolem, petrifiedSnowGolem, petrifiedChicken, petrifiedVillager, 
		petrifiedPigman, petrifiedSilverfish, petrifiedMooshroom, petrifiedAllo;

    public static Block extremeTorch, krakenTorch;

    public static Block pizzaFoodBlock;

    public static void addBlocks() 
	{

		// PETRIFIED START
        petrifiedCow = new BaseAkPetrifiedBlock("petrified_cow");
        registerPetrifiedBlockByClass(petrifiedCow, "Cow", EntityCow.class);

        petrifiedPig = new BaseAkPetrifiedBlock("petrified_pig");
        registerPetrifiedBlockByClass(petrifiedPig, "Pig", EntityPig.class);

        pertifiedCreeper = new BaseAkPetrifiedBlock("petrified_creeper");
        registerPetrifiedBlockByClass(pertifiedCreeper, "Creeper", EntityCreeper.class);

        petrifiedWolf = new BaseAkPetrifiedBlock("petrified_wolf");
        registerPetrifiedBlockByClass(petrifiedWolf, "Wolf", EntityWolf.class);

        petrifiedCaveSpider = new BaseAkPetrifiedBlock("petrified_cave_spider");
        registerPetrifiedBlockByClass(petrifiedCaveSpider, "CaveSpider", EntityCaveSpider.class);

        petrifiedSquid = new BaseAkPetrifiedBlock("petrified_squid");
        registerPetrifiedBlockByClass(petrifiedSquid, "Squid", EntitySquid.class);

        petrifiedIronGolem = new BaseAkPetrifiedBlock("petrified_iron_golem");
        registerPetrifiedBlockByClass(petrifiedIronGolem, "IronGolem", EntityIronGolem.class);

        petrifiedSnowGolem = new BaseAkPetrifiedBlock("petrified_snow_golem");
        registerPetrifiedBlockByClass(petrifiedSnowGolem, "SnowGolem", EntitySnowman.class);

        petrifiedChicken = new BaseAkPetrifiedBlock("petrified_chicken");
        registerPetrifiedBlockByClass(petrifiedChicken, "Chicken", EntityChicken.class);

        petrifiedVillager = new BaseAkPetrifiedBlock("petrified_villager");
        registerPetrifiedBlockByClass(petrifiedVillager, "Villager", EntityVillager.class);

        petrifiedPigman = new BaseAkPetrifiedBlock("petrified_pigman");
        registerPetrifiedBlockByClass(petrifiedPigman, "Pigman", EntityPigZombie.class);

        petrifiedSilverfish = new BaseAkPetrifiedBlock("petrified_silverfish");
        registerPetrifiedBlockByClass(petrifiedSilverfish, "SilverFish", EntitySilverfish.class);

        petrifiedMooshroom = new BaseAkPetrifiedBlock("petrified_mooshroom");
        registerPetrifiedBlockByClass(petrifiedMooshroom, "Mooshroom", EntityMooshroom.class);

        petrifiedAllo = new BaseAkPetrifiedBlock("petrified_allosaurus");
        registerPetrifiedAKBlock(petrifiedAllo, "petrified allosaurus", alloSpawnEgg);
		
		// Petrified END

        extremeTorch = new ExtremeTorchBlock("extreme_torch");
        registerBlock(extremeTorch, "Extreme Torch");

        pizzaFoodBlock = new PizzaBlock("pizza");
        registerBlock(pizzaFoodBlock, "pizza");

        krakenTorch = new KrakenRepellentBlock("kraken_repellent");
        registerBlock(krakenTorch, "Kraken Repellent");
    }


    private static void addMobs() 
	{
		// PEACEFUL
        registerEntity(BodyguardEntity.class, "bodyguard", 64, 1, true);
		
		
		// NON-LIVING
		
        registerEntity(RockEntity.class, "rock", 64, 1, true);
		
		
		// HOSTILE
        registerEntity(MantisEntity.class, "mantis", 64, 1, true);
        registerEntity(AllosaurusEntity.class, "allosaurus", 64, 1, true);
    }

    public static Item ruby, rubyAxe;
	
    public static Item 
		appleSeed, popcornFood, rawcornDog, butterFood, butterCandy, cheeseFood,
	saladFood, crabbyPatty, rawCrab, pizzaItem, salt;

    public static Item mobLauncher;

    public static Item emeraldHoe;

    public static Item bigHammer;

    public static Item crystalWoodAxe;

    public static Item coarseAmethystAxe;

    public static Item godzillaScale;

    public static Item ultimatePickaxe;

    public static Item mantisClaw;

    public static Item redRock, greenRock, explosiveRock, smallRock;

    public static Item minerDream;

    public static Item crystalStick;

    public static Item experienceSword;

    public static Item alloSpawnEgg,mantisSpawnEgg, bodyGuardSpawnegg, robotAntKit;

    public static Item katterKillerJaw;

    public static Item peacockFeather;

    public static Item pinkCrystal;

    public static Item vortexEye;

    public static Item krakenTooth;

    public static Item zangesuGuard;

    public static Item wrench;

    private static void addItems()
    {
        ruby = new BaseAKMaterials("ruby");
        registerItem(ruby, "ruby");

        appleSeed = new BaseAKItem("apple_seed");
        registerItem(appleSeed, "Apple seed");

        popcornFood = new BaseAKFood("popcorn", 8, 0, false).setUseDuration(8)
            .addInfo("PopcornDesc", EnumChatFormatting.WHITE)
            .setAlwaysEdible();
        registerItem(popcornFood, "popcorn");

        butterFood = new BaseAKFood("butter", 1, 0.5f, false)
            .addInfo("ButterDesc", EnumChatFormatting.YELLOW)
            .setUseDuration(32);
        registerItem(butterFood, "butter");

        butterCandy = new BaseAKFood("butter_candy", 4, 0.5f, true)
             .addInfo("ButterCandyDesc", EnumChatFormatting.YELLOW)
            .setUseDuration(32)
            .addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 0))
            .addPotionEffect(new PotionEffect(Potion.jump.id, 200, 0))
            .setAlwaysEdible();
        registerItem(butterCandy, "butter_candy");

        cheeseFood = new BaseAKFood("cheese", 4, 0.5f, false)
            .addInfo("CheeseDesc", EnumChatFormatting.DARK_GRAY)
            .setUseDuration(32);
        registerItem(cheeseFood, "cheese");

        saladFood = new BaseAKFood("salad", 10, 10, true)
                .setUseDuration(32);
        registerItem(saladFood, "Salad");

        crabbyPatty = new BaseAKFood("crabby_patty", 16, 2.35f, true);
        registerItem(crabbyPatty, "Crabby Patty");

        rawcornDog = new BaseAKFood("raw_corn_dog", 4, 0.6f, true);
        registerItem(rawcornDog, "Raw Corn Dog");

        rawCrab = new BaseAKFood("raw_crab", 4, 0.25f, true);
        registerItem(rawCrab, "Raw Crab");

        mobLauncher = new MobLauncherItem("mob_launcher");
        registerItem(mobLauncher, "Mob Launcher");

        emeraldHoe = new BaseAKHoe("emerald_hoe", emeraldHoeMaterials)
         .addInfo("EmeraldHoeDesc", EnumChatFormatting.DARK_GREEN);
        registerItem(emeraldHoe, "Emerald Hoe");

        bigHammer = new BaseAKSword("big_hammer", bigHammerMaterials);
        registerItem(bigHammer, "Big Hammer");

        crystalWoodAxe = new BaseAKAxe("crystal_wood_axe", crystalAxeWoodMaterial);
        registerItem(crystalWoodAxe, "crystal Wood Axe");

        coarseAmethystAxe = new BaseAKAxe("coarse_amethyst_axe", coarseAmethystAxeMaterials);
        registerItem(coarseAmethystAxe, "Coarse Amethyst Axe");

        rubyAxe = new BaseAKAxe("ruby_axe", rubyAxeMaterials);
        registerItem(rubyAxe, "Ruby Axe");

        ultimatePickaxe = new UltimatePickaxeItem("ultimate_pickaxe", ultimatePicMaterials);
        registerItem(ultimatePickaxe, "Ultimate Pickaxe");

        mantisClaw = new MantisClawItem("mantis_claw", mantisClawMaterials);
        registerItem(mantisClaw, "Mantis Claws");

        redRock = new RockItem("RedRock", EnumRockTypes.RED_ROCK);
        registerItem(redRock, "Red Rock");

        greenRock = new RockItem("GreenRock", EnumRockTypes.GREEN_ROCK);
        registerItem(greenRock, "Green Rock");

        explosiveRock = new RockItem("ExplosiveRock", EnumRockTypes.EXPLOSIVE_ROCK);
        registerItem(explosiveRock, "Explosive Rocks");

        smallRock = new RockItem("SmallRock", EnumRockTypes.SMALL_ROCK);
        registerItem(smallRock, "Small Rock");

        minerDream = new ItemMinerDream("miners_dream");
        registerItem(minerDream, "Miner's Dream");

        crystalStick = new BaseAKMaterials("crystal_stick");
        registerItem(crystalStick, "Crystal Stick");

        experienceSword = new ExperienceSwordItem("experience_sword", experienceSwordMaterials);
        registerItem(experienceSword, "Experience Sword");

        godzillaScale = new BaseAKMaterials("godzilla_scale");
        registerItem(godzillaScale, "Godzilla Scale");

        katterKillerJaw = new BaseAKMaterials("KatterkillerJaw");
        registerItem(katterKillerJaw, "Katter Killer Jaw");

       bodyGuardSpawnegg = new BaseItemAKSpawnEgg("bodyguard");
        registerItem(bodyGuardSpawnegg, "Bodyguard Spawn Egg");

        mantisSpawnEgg = new BaseItemAKSpawnEgg("mantis");
        registerItem(mantisSpawnEgg, "Mantis Spawn Egg");

       alloSpawnEgg = new BaseItemAKSpawnEgg("allosaurus");
        registerItem(alloSpawnEgg, "Allosaurus Spawn Egg");

        peacockFeather = new BaseAKMaterials("peacock_feather");
        registerItem(peacockFeather, "Peacock Feather");

        pinkCrystal = new BaseAKMaterials("pink_crystal");
        registerItem(pinkCrystal, "Pink Crystal");

        vortexEye = new BaseAKMaterials("vortex_eye");
        registerItem(vortexEye, "Vortex Eye");

        krakenTooth = new BaseAKMaterials("krakentooth");
        registerItem(krakenTooth, "KrakenTooth");

        salt = new BaseAKItem("salt");
        registerItem(salt, "Salt");

        zangesuGuard = new BaseAKMaterials("zanGuard");
        registerItem(zangesuGuard, "Zangesu Guard");

        wrench = new WrenchItem("wrench");
        registerItem(wrench, "Wrench");

        pizzaItem = new PizzaBlockItem("pizza", RegistryHandler.pizzaFoodBlock);
        registerItem(pizzaItem, "Pizza");

        robotAntKit = new BaseItemAKSpawnEgg("robot_ant_kit");
        registerItem(robotAntKit, "Robot Ant Kit");


        // test = new BaseAKFood("test", 3,3,true).addMultInfoString("f").addMultInfoString("dfd");
        // registerItem(test, "Test");

        // bltSandwitch = new BaseAKFood("blt", 800, 20, 2);
        // registerItem(bltSandwitch, "Blt");

        // rawBaconFood = new RawBaconFoodItem("rawBacon", 32, 16, 1);
        // registerItem(rawBaconFood, "Raw Beacon");

        // rubySword = new BaseAKSword("rubySword", null);
        // registerItem(rubySword, "RubySword");

    }

    private static void addRecipe() {
        addShapedSpecific(
            new ItemStack(RegistryHandler.mobLauncher, 4),
            new Object[] { "RPS", 'R', Items.redstone, 'P', Items.paper, 'S', Items.stick });
        addShapedSpecific(
            new ItemStack(RegistryHandler.emeraldHoe, 1),
            new Object[] { "## ", " / ", " / ", '#', Blocks.emerald_block, '/', Items.stick });

        addShapeless(
            new ItemStack(RegistryHandler.cheeseFood, 2),
            new Object[] { Items.milk_bucket, Items.milk_bucket, Items.milk_bucket, Items.milk_bucket });

        addShapeless(new ItemStack(RegistryHandler.butterCandy, 4), new Object[] { RegistryHandler.butterFood, Items.sugar });

        addShapedSpecific(new ItemStack(Blocks.web, 1), new Object[] { "WWW", "W W", "WWW", 'W', Blocks.web });

        addShapeless(
            new ItemStack(RegistryHandler.extremeTorch, 4),
            new Object[] { Items.redstone, Items.coal, Items.stick });

        addShapeless(new ItemStack(RegistryHandler.extremeTorch, 1), new Object[] { Items.redstone, Blocks.torch });

        addShapedSpecific(
            new ItemStack(RegistryHandler.minerDream, 1),
            new Object[] { "RRR", "CCC", "GGG", 'R', Blocks.redstone_block, 'C', Blocks.cactus, 'G', Items.gunpowder });

        addShapedSpecific(new ItemStack(RegistryHandler.wrench, 1),
                new Object[]{"I I", " I ", " I ", 'I', Items.iron_ingot}
                );

    }

    private static void addShapedSpecific(ItemStack output, Object... pars) {
        GameRegistry.addShapedRecipe(output, pars);
    }

    public static int classFossilID(Class clazz) {
       String stringClass = EntityList.classToStringMapping.get(clazz).toString();
        return (int) EntityList.stringToIDMapping.get(stringClass);
    }

    private static int stringFossilID(String name) {
        return (int) EntityList.stringToIDMapping.get(name);
    }

    private static void addShapeless(ItemStack output, Object... pars) {
        GameRegistry.addShapelessRecipe(output, pars);
    }

    public static void addFossilByClass(Class<? extends Entity> clazz, Block block) {
        addShapeless(
            new ItemStack(Items.spawn_egg, 1, classFossilID(clazz)),
            new Object[] { new ItemStack(Items.water_bucket, 1), new ItemStack(block, 1) });
    }

    public static void addAKFossilByItem(Item item, Block block) {
        addShapeless(
                new ItemStack(item),
                new Object[] { new ItemStack(Items.water_bucket, 1), new ItemStack(block, 1) });
    }

    public static void addFossilByName(String name, Block block) {
        addShapeless(
            new ItemStack(Items.spawn_egg, 1, stringFossilID(name)),
            new Object[] { new ItemStack(Items.water_bucket, 1), new ItemStack(block, 1) });
    }

    private static void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.registerBlock(block, name);
    }

    public static void registerPetrifiedBlockByClass(Block block, String name, Class<? extends Entity> clazz) {
        registerBlock(block, "Petrified " + name);
        addFossilByClass(clazz, block);
    }

    public static void registerPetrifiedAKBlock(Block block, String name, Item retnitm){
        registerBlock(block, "Petrified " + name);
        addAKFossilByItem(retnitm, block);
    }

    public static void registerPetrifiedBlockByName(Block block, String name, String entName) {
        registerBlock(block, name);
        addFossilByName(entName, block);
    }

    private static Item.ToolMaterial registerHoe(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return  EnumHelper.addToolMaterial(name + DangerZone.MODID + "Hoe", harvestLevel, maxUses, efficiency, damage, enchantability);
    }

    private static Item.ToolMaterial registerAxe(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return  EnumHelper.addToolMaterial(name + DangerZone.MODID + "AxeMaterial", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
    }

    private static Item.ToolMaterial registerShovel(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return  EnumHelper.addToolMaterial(name + DangerZone.MODID + "ShovelMaterial", harvestLevel, maxUses, efficiency, damage, enchantability);
    }

    private static Item.ToolMaterial registerPickaxe(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return  EnumHelper.addToolMaterial(name + DangerZone.MODID + "PickaxeMaterial", harvestLevel, maxUses, efficiency, damage - 2, enchantability);
    }

    private static Item.ToolMaterial registerSword(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
        return  EnumHelper.addToolMaterial(name + DangerZone.MODID + "SwordMaterial", harvestLevel, maxUses, efficiency, damage - 4, enchantability);
    }

    private static int id = 1;
    private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange,
                                       int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(
            entityClass,
            entityName,
            id++,
            DangerZone.INSTANCE,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates);
    }

}
