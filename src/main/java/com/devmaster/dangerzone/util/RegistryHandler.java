package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.items.SpawnEggItem;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.items.EmeraldPickaxe;
import com.devmaster.dangerzone.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerZone.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DangerZone.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DangerZone.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Entities
    public static final RegistryObject<EntityType<Tewtiy>> TEWTIY = ENTITIES
            .register("tewtiy",
                    () -> EntityType.Builder.<Tewtiy>create(Tewtiy::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<NotBreeBree>> NOTBREEBREE = ENTITIES
            .register("notbreebree",
                    () -> EntityType.Builder.<NotBreeBree>create(NotBreeBree::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "notbreebree").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "stampylongnose").toString()));

    public static final RegistryObject<EntityType<RedRoseWarrior>> REDROSEWARRIOR = ENTITIES
            .register("redrosewarrior",
                    () -> EntityType.Builder.<RedRoseWarrior>create(RedRoseWarrior::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "redrosewarrior").toString()));

    public static final RegistryObject<EntityType<RainbowAnt>> RAINBOWANT = ENTITIES
            .register("rainbow_ant",
                    () -> EntityType.Builder.<RainbowAnt>create(RainbowAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "rainbow_ant").toString()));

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES
            .register("butterfly",
                    () -> EntityType.Builder.<Butterfly>create(Butterfly::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "butterfly").toString()));


    public static final RegistryObject<EntityType<Ent>> ENT = ENTITIES
            .register("ent",
                    () -> EntityType.Builder.<Ent>create(Ent::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "ent").toString()));

    public static final RegistryObject<EntityType<WaterProjectile>> WATER_PROJECTILE = ENTITIES
            .register("water_projectile",
                    () -> EntityType.Builder.<WaterProjectile>create(WaterProjectile::new, EntityClassification.MISC)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "water_projectile").toString()));

    //Items
    public static final RegistryObject<Item> COARSE_AMETHYST = ITEMS.register("coarse_amethyst", CoarseAmethyst::new);

    public static final RegistryObject<Item> CATS_EYE = ITEMS.register("cats_eye", CatsEye::new);

    public static final RegistryObject<Item> COPPER_LUMP = ITEMS.register("copper_lump", CopperLump::new);

    public static final RegistryObject<Item> TITANIUM_Hardened_CAKE = ITEMS.register("titanium_hardened_cake", TitaniumHardenedCake::new);

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", TitaniumNugget::new);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", TitaniumIngot::new);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);


    public static final RegistryObject<CandyCane> CANDY_CANE = ITEMS.register("candy_cane", CandyCane::new);

    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", Sapphire::new);

    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);

    public static final RegistryObject<MinersDreamItem> MINERS_DREAM = ITEMS.register("miners_dream", MinersDreamItem::new);

    public static final RegistryObject<CritterCage> CRITTER_CAGE = ITEMS.register("critter_cage", CritterCage::new);

    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", Wrench::new);

    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);

    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);

    public static final RegistryObject<ButterCandy> BUTTER_CANDY = ITEMS.register("butter_candy", ButterCandy::new);

    public static final RegistryObject<DeadRainbowAnt> DEAD_RAINBOW_ANT = ITEMS.register("dead_rainbow_ant", DeadRainbowAnt::new);

    public static final RegistryObject<RainbowAntToken> RAINBOW_ANT_TOKEN = ITEMS.register("rainbow_ant_token", RainbowAntToken::new);

    //Spawn Eggs
    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", MermaidSpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> REDROSEWARRIOR_SPAWN_EGG = ITEMS.register("redrosewarrior_spawn_egg", () -> new SpawnEggItem(RegistryHandler.REDROSEWARRIOR, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> MOLDY_SPAWN_EGG = ITEMS.register("moldy_spawn_egg", MoldySpawnEgg::new);


    //Tools
    public static final RegistryObject<CoarseAmethystPickaxe> COARSE_AMETHYST_PICKAXE = ITEMS.register("coarse_amethyst_pickaxe", CoarseAmethystPickaxe::new);

    public static final RegistryObject<CoarseAmethystSword> COARSE_AMETHYST_SWORD = ITEMS.register("coarse_amethyst_sword", CoarseAmethystSword::new);

    public static final RegistryObject<CoarseAmethystAxe> COARSE_AMETHYST_AXE = ITEMS.register("coarse_amethyst_axe", CoarseAmethystAxe::new);

    public static final RegistryObject<CoarseAmethystShovel> COARSE_AMETHYST_SHOVEL = ITEMS.register("coarse_amethyst_shovel", CoarseAmethystShovel::new);

    public static final RegistryObject<CoarseAmethystHoe> COARSE_AMETHYST_HOE = ITEMS.register("coarse_amethyst_hoe", CoarseAmethystHoe::new);

    public static final RegistryObject<EmeraldAxe> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);

    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);

    public static final RegistryObject<EmeraldHoe> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);

    public static final RegistryObject<EmeraldShovel> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);

    public static final RegistryObject<EmeraldSword> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);

    public static final RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", SapphirePickaxe::new);

    public static final RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", SapphireSword::new);

    public static final RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", SapphireAxe::new);

    public static final RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", SapphireShovel::new);

    public static final RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", SapphireHoe::new);

    public static final RegistryObject<CakeSword> CAKE_SWORD = ITEMS.register("cake_sword", CakeSword::new);

    public static final RegistryObject<PoppySword> POPPY_SWORD = ITEMS.register("poppy_sword", PoppySword::new);

    //Armor
    public static final RegistryObject<CoarseAmethystHelmet> COARSE_AMETHYST_HELMET = ITEMS.register("coarse_amethyst_helmet", CoarseAmethystHelmet::new);

    public static final RegistryObject<CoarseAmethystChestplate> COARSE_AMETHYST_CHESTPLATE = ITEMS.register("coarse_amethyst_chestplate", CoarseAmethystChestplate::new);

    public static final RegistryObject<CoarseAmethystLeggings> COARSE_AMETHYST_LEGGINGS = ITEMS.register("coarse_amethyst_leggings", CoarseAmethystLeggings::new);

    public static final RegistryObject<CoarseAmethystBoots> COARSE_AMETHYST_BOOTS = ITEMS.register("coarse_amethyst_boots", CoarseAmethystBoots::new);

    public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", SapphireHelmet::new);

    public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", SapphireChestplate::new);

    public static final RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", SapphireLeggings::new);

    public static final RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", SapphireBoots::new);

    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", LapisHelmet::new);

    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", LapisChestplate::new);

    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",  LapisLeggings::new);

    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", LapisBoots::new);

    public static final RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", EmeraldHelmet::new);

    public static final RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", EmeraldChestplate::new);

    public static final RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", EmeraldLeggings::new);

    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", EmeraldBoots::new);

    public static final RegistryObject<CopperHelmet> COPPER_HELMET = ITEMS.register("copper_helmet", CopperHelmet::new);

    public static final RegistryObject<CopperChestplate> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", CopperChestplate::new);

    public static final RegistryObject<CopperLeggings> COPPER_LEGGINGS = ITEMS.register("copper_leggings", CopperLeggings::new);

    public static final RegistryObject<CopperBoots> COPPER_BOOTS = ITEMS.register("copper_boots", CopperBoots::new);

    public static final RegistryObject<CatsEyeHelmet> CATS_EYE_HELMET = ITEMS.register("cats_eye_helmet", CatsEyeHelmet::new);

    public static final RegistryObject<CatsEyeChestplate> CATS_EYE_CHESTPLATE = ITEMS.register("cats_eye_chestplate", CatsEyeChestplate::new);

    public static final RegistryObject<CatsEyeLeggings> CATS_EYE_LEGGINGS = ITEMS.register("cats_eye_leggings", CatsEyeLeggings::new);

    public static final RegistryObject<CatsEyeBoots> CATS_EYE_BOOTS = ITEMS.register("cats_eye_boots", CatsEyeBoots::new);

    //Blocks
    public static final RegistryObject<Block> COARSE_AMETHYST_ORE_BLOCK = BLOCKS.register("coarse_amethyst_ore_block", CoarseAmethystOreBlock::new);

    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);

    public static final RegistryObject<Block> COARSE_AMETHYST_BLOCK = BLOCKS.register("coarse_amethyst_block", CoarseAmethystBlock::new);

    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);

    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);

    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", TitaniumBlock::new);

    public static final RegistryObject<Block> COMPRESSED_POPPY_BLOCK = BLOCKS.register("compressed_poppy_block", CompressedPoppyBlock::new);

    public static final RegistryObject<Block> STICKY_BLOCK = BLOCKS.register("sticky_block", StickyBlock::new);

    public static final RegistryObject<Block> DARK_BROWN_BLOCK = BLOCKS.register("dark_brown_block", DarkBrownBlock::new);

    public static final RegistryObject<Block> DARK_ORANGE_BLOCK = BLOCKS.register("dark_orange_block", DarkOrangeBlock::new);

    public static final RegistryObject<Block> ORANGE_BLOCK = BLOCKS.register("orange_block", OrangeBlock::new);

    public static final RegistryObject<Block> BROWN_BLOCK = BLOCKS.register("brown_block", BrownBlock::new);

    public static final RegistryObject<Block> KYANITE = BLOCKS.register("kyanite", Kyanite::new);

    public static final RegistryObject<Block> CRYSTAL_GRASS = BLOCKS.register("crystal_grass", CrystalGrass::new);

    public static final RegistryObject<Block> CATS_EYE_BLOCK = BLOCKS.register("cats_eye_block", CatsEyeBlock::new);

    public static final RegistryObject<Block> ALUMINIUM_ORE_BLOCK = BLOCKS.register("aluminium_ore_block", AluminiumOreBlock::new);

    //Petrified animals blocks
    public static final RegistryObject<Block> REDROSEWARRIOR_EGG_ORE = BLOCKS.register("redrosewarrior_egg_ore", BlockMobOre::new);
    public static final RegistryObject<Block> MUTANT_ZOMBIE_EGG_ORE = BLOCKS.register("mutant_zombie_egg_ore", BlockMobOre::new);


    //Block Items
    public static final RegistryObject<Item> COARSE_AMETHYST_ORE_BLOCK_ITEM = ITEMS.register("coarse_amethyst_ore_block", () -> new BlockItemBase(COARSE_AMETHYST_ORE_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINIUM_ORE_BLOCK_ITEM = ITEMS.register("aluminium_ore_block", () -> new BlockItemBase(ALUMINIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> COARSE_AMETHYST_BLOCK_ITEM = ITEMS.register("coarse_amethyst_block", () -> new BlockItemBase(COARSE_AMETHYST_BLOCK.get()));

    public static final RegistryObject<Item> SALT_ORE_BLOCK_ITEM = ITEMS.register("salt_ore_block", () -> new BlockItemBase(SALT_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_ORE_BLOCK_ITEM = ITEMS.register("sapphire_ore_block", () -> new BlockItemBase(SAPPHIRE_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));

    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block", () -> new BlockItemBase(URANIUM_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_BLOCK_ITEM = ITEMS.register("titanium_block", () -> new BlockItemBase(TITANIUM_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_ORE_BLOCK_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> COMPRESSED_POPPY_BLOCK_ITEM = ITEMS.register("compressed_poppy_block", () -> new BlockItemBase(COMPRESSED_POPPY_BLOCK.get()));

    public static final RegistryObject<Item> STICKY_BLOCK_ITEM = ITEMS.register("sticky_block", () -> new BlockItemBase(STICKY_BLOCK.get()));

    public static final RegistryObject<Item> DARK_BROWN_BLOCK_ITEM = ITEMS.register("dark_brown_block", () -> new BlockItemBase(DARK_BROWN_BLOCK.get()));

    public static final RegistryObject<Item> DARK_ORANGE_BLOCK_ITEM = ITEMS.register("dark_orange_block", () -> new BlockItemBase(DARK_ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> ORANGE_BLOCK_ITEM = ITEMS.register("orange_block", () -> new BlockItemBase(ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> BROWN_BLOCK_ITEM = ITEMS.register("brown_block", () -> new BlockItemBase(BROWN_BLOCK.get()));

    public static final RegistryObject<Item> KYANITE_BLOCK_ITEM = ITEMS.register("kyanite", () -> new BlockItemBase(KYANITE.get()));

    public static final RegistryObject<Item> CRYSTAL_GRASS_ITEM = ITEMS.register("crystal_grass", () -> new BlockItemBase(CRYSTAL_GRASS.get()));

    public static final RegistryObject<Item> CATS_EYE_BLOCK_ITEM = ITEMS.register("cats_eye_block", () -> new BlockItemBase(CATS_EYE_BLOCK.get()));

    //Petrified animals items
    public static final RegistryObject<Item> REDROSEWARRIOR_EGG_ORE_ITEM = ITEMS.register("redrosewarrior_egg_ore", () -> new BlockItemMobOre(REDROSEWARRIOR_EGG_ORE.get()));
    public static final RegistryObject<Item> Mutant_Zombie_EGG_ORE_ITEM = ITEMS.register("mutant_zombie_egg_ore", () -> new BlockItemMobOre(MUTANT_ZOMBIE_EGG_ORE.get()));



    //Dimensions
    public static final RegistryKey<World> VILLAGES = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "villages"));}
