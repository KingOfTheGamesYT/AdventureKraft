package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.items.SpawnEggItem;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.items.EmeraldPickaxe;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DangerZone.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DangerZone.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerZone.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DangerZone.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Armor
    public static final RegistryObject<CatsEyeBoots> CATS_EYE_BOOTS = ITEMS.register("cats_eye_boots", CatsEyeBoots::new);

    public static final RegistryObject<CatsEyeChestplate> CATS_EYE_CHESTPLATE = ITEMS.register("cats_eye_chestplate", CatsEyeChestplate::new);

    public static final RegistryObject<CatsEyeHelmet> CATS_EYE_HELMET = ITEMS.register("cats_eye_helmet", CatsEyeHelmet::new);

    public static final RegistryObject<CatsEyeLeggings> CATS_EYE_LEGGINGS = ITEMS.register("cats_eye_leggings", CatsEyeLeggings::new);

    public static final RegistryObject<CoarseAmethystBoots> COARSE_AMETHYST_BOOTS = ITEMS.register("coarse_amethyst_boots", CoarseAmethystBoots::new);

    public static final RegistryObject<CoarseAmethystChestplate> COARSE_AMETHYST_CHESTPLATE = ITEMS.register("coarse_amethyst_chestplate", CoarseAmethystChestplate::new);

    public static final RegistryObject<CoarseAmethystHelmet> COARSE_AMETHYST_HELMET = ITEMS.register("coarse_amethyst_helmet", CoarseAmethystHelmet::new);

    public static final RegistryObject<CoarseAmethystLeggings> COARSE_AMETHYST_LEGGINGS = ITEMS.register("coarse_amethyst_leggings", CoarseAmethystLeggings::new);

    public static final RegistryObject<CopperBoots> COPPER_BOOTS = ITEMS.register("copper_boots", CopperBoots::new);

    public static final RegistryObject<CopperChestplate> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", CopperChestplate::new);

    public static final RegistryObject<CopperHelmet> COPPER_HELMET = ITEMS.register("copper_helmet", CopperHelmet::new);

    public static final RegistryObject<CopperLeggings> COPPER_LEGGINGS = ITEMS.register("copper_leggings", CopperLeggings::new);

    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", EmeraldBoots::new);

    public static final RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", EmeraldChestplate::new);

    public static final RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", EmeraldHelmet::new);

    public static final RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", EmeraldLeggings::new);

    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", LapisBoots::new);

    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", LapisChestplate::new);

    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", LapisHelmet::new);

    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",  LapisLeggings::new);

    public static final RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", SapphireBoots::new);

    public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", SapphireChestplate::new);

    public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", SapphireHelmet::new);

    public static final RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", SapphireLeggings::new);

    //Blocks
    public static final RegistryObject<Block> ABYSSAL_ORE_BLOCK = BLOCKS.register("abyssal_ore_block", AbyssalOreBlock::new);

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block", AluminiumBlock::new);

    public static final RegistryObject<Block> ALUMINIUM_ORE_BLOCK = BLOCKS.register("aluminium_ore_block", AluminiumOreBlock::new);

    public static final RegistryObject<Block> APPLE_LEAVES = BLOCKS.register("apple_leaves", AppleLeaves::new);

    public static final RegistryObject<Block> APPLE_LOG = BLOCKS.register("apple_log", AppleLog::new);

    public static final RegistryObject<Block> BLOODSTONE_BLOCK = BLOCKS.register("bloodstone_block", BloodStoneBlock::new);

    public static final RegistryObject<Block> BROWN_BLOCK = BLOCKS.register("brown_block", BrownBlock::new);

    public static final RegistryObject<Block> CATS_EYE_BLOCK = BLOCKS.register("cats_eye_block", CatsEyeBlock::new);

    public static final RegistryObject<Block> COARSE_AMETHYST_BLOCK = BLOCKS.register("coarse_amethyst_block", CoarseAmethystBlock::new);

    public static final RegistryObject<Block> COARSE_AMETHYST_ORE_BLOCK = BLOCKS.register("coarse_amethyst_ore_block", CoarseAmethystOreBlock::new);

    public static final RegistryObject<Block> COMPRESSED_POPPY_BLOCK = BLOCKS.register("compressed_poppy_block", CompressedPoppyBlock::new);

    public static final RegistryObject<Block> CRYSTAL_GRASS = BLOCKS.register("crystal_grass", CrystalGrass::new);

    public static final RegistryObject<Block> DARK_BROWN_BLOCK = BLOCKS.register("dark_brown_block", DarkBrownBlock::new);

    public static final RegistryObject<Block> DARK_ORANGE_BLOCK = BLOCKS.register("dark_orange_block", DarkOrangeBlock::new);

    public static final RegistryObject<Block> KYANITE = BLOCKS.register("kyanite", Kyanite::new);

    public static final RegistryObject<Block> LEATHER_BLOCK = BLOCKS.register("leather_block", LeatherBlock::new);

    public static final RegistryObject<Block> ORANGE_BLOCK = BLOCKS.register("orange_block", OrangeBlock::new);

    public static final RegistryObject<Block> PLAY_BUTTON_ORE_BLOCK = BLOCKS.register("play_button_ore_block", PlayButtonOreBlock::new);

    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);

    public static final RegistryObject<Block> STICKY_BLOCK = BLOCKS.register("sticky_block", StickyBlock::new);

    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", TitaniumBlock::new);

    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);

    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);

    //Block Items
    public static final RegistryObject<Item> ABYSSAL_ORE_BLOCK_ITEM = ITEMS.register("abyssal_ore_block", () -> new BlockItemBase(ABYSSAL_ORE_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINIUM_BLOCK_ITEM = ITEMS.register("aluminium_block", () -> new BlockItemBase(ALUMINIUM_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINIUM_ORE_BLOCK_ITEM = ITEMS.register("aluminium_ore_block", () -> new WIPBlockItemBase(ALUMINIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> APPLE_LOG_ITEM = ITEMS.register("apple_log", () -> new WIPBlockItemBase(APPLE_LOG.get()));

    public static final RegistryObject<Item> APPLE_LEAVES_ITEM = ITEMS.register("apple_leaves", () -> new WIPBlockItemBase(APPLE_LEAVES.get()));

    public static final RegistryObject<Item> BLOODSTONE_BLOCK_ITEM = ITEMS.register("bloodstone_block", () -> new WIPBlockItemBase(BLOODSTONE_BLOCK.get()));
    
    public static final RegistryObject<Item> BROWN_BLOCK_ITEM = ITEMS.register("brown_block", () -> new BlockItemBase(BROWN_BLOCK.get()));

    public static final RegistryObject<Item> CATS_EYE_BLOCK_ITEM = ITEMS.register("cats_eye_block", () -> new WIPBlockItemBase(CATS_EYE_BLOCK.get()));

    public static final RegistryObject<Item> COARSE_AMETHYST_BLOCK_ITEM = ITEMS.register("coarse_amethyst_block", () -> new BlockItemBase(COARSE_AMETHYST_BLOCK.get()));

    public static final RegistryObject<Item> COARSE_AMETHYST_ORE_BLOCK_ITEM = ITEMS.register("coarse_amethyst_ore_block", () -> new BlockItemBase(COARSE_AMETHYST_ORE_BLOCK.get()));

    public static final RegistryObject<Item> COMPRESSED_POPPY_BLOCK_ITEM = ITEMS.register("compressed_poppy_block", () -> new BlockItemBase(COMPRESSED_POPPY_BLOCK.get()));

    public static final RegistryObject<Item> CRYSTAL_GRASS_ITEM = ITEMS.register("crystal_grass", () -> new WIPBlockItemBase(CRYSTAL_GRASS.get()));

    public static final RegistryObject<Item> DARK_BROWN_BLOCK_ITEM = ITEMS.register("dark_brown_block", () -> new BlockItemBase(DARK_BROWN_BLOCK.get()));

    public static final RegistryObject<Item> DARK_ORANGE_BLOCK_ITEM = ITEMS.register("dark_orange_block", () -> new BlockItemBase(DARK_ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> KYANITE_BLOCK_ITEM = ITEMS.register("kyanite", () -> new WIPBlockItemBase(KYANITE.get()));

    public static final RegistryObject<Item> LEATHER_BLOCK_ITEM = ITEMS.register("leather_block", () -> new BlockItemBase(LEATHER_BLOCK.get()));

    public static final RegistryObject<Item> ORANGE_BLOCK_ITEM = ITEMS.register("orange_block", () -> new BlockItemBase(ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> PLAY_BUTTON_ORE_BLOCK_ITEM = ITEMS.register("play_button_ore_block", () -> new BlockItemBase(PLAY_BUTTON_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SALT_ORE_BLOCK_ITEM = ITEMS.register("salt_ore_block", () -> new BlockItemBase(SALT_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_ORE_BLOCK_ITEM = ITEMS.register("sapphire_ore_block", () -> new BlockItemBase(SAPPHIRE_ORE_BLOCK.get()));

    public static final RegistryObject<Item> STICKY_BLOCK_ITEM = ITEMS.register("sticky_block", () -> new BlockItemBase(STICKY_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_BLOCK_ITEM = ITEMS.register("titanium_block", () -> new WIPBlockItemBase(TITANIUM_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_ORE_BLOCK_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block", () -> new WIPBlockItemBase(URANIUM_BLOCK.get()));

    //Dimensions
    public static final RegistryKey<World> VILLAGES = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "villages"));

    //Entities
    public static final RegistryObject<EntityType<Allosaurus>> ALLOSAURUS = ENTITIES
            .register("allosaurus",
                    () -> EntityType.Builder.<Allosaurus>create(Allosaurus::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "allosaurus").toString()));

    public static final RegistryObject<EntityType<AttackSquid>> ATTACK_SQUID = ENTITIES
            .register("attack_squid",
                    () -> EntityType.Builder.<AttackSquid>create(AttackSquid::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "attack_squid").toString()));

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES
            .register("butterfly",
                    () -> EntityType.Builder.<Butterfly>create(Butterfly::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "butterfly").toString()));

    public static final RegistryObject<EntityType<CaveFisher>> CAVE_FISHER = ENTITIES
            .register("cave_fisher",
                    () -> EntityType.Builder.<CaveFisher>create(CaveFisher::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "cave_fisher").toString()));

    public static final RegistryObject<EntityType<Ent>> ENT = ENTITIES
            .register("ent",
                    () -> EntityType.Builder.<Ent>create(Ent::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "ent").toString()));

    public static final RegistryObject<EntityType<Hydrolisc>> HYDROLISC = ENTITIES
            .register("hydrolisc",
                    () -> EntityType.Builder.<Hydrolisc>create(Hydrolisc::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "hydrolisc").toString()));

    public static final RegistryObject<EntityType<NotBreeBree>> NOTBREEBREE = ENTITIES
            .register("notbreebree",
                    () -> EntityType.Builder.<NotBreeBree>create(NotBreeBree::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "notbreebree").toString()));

    public static final RegistryObject<EntityType<RainbowAnt>> RAINBOWANT = ENTITIES
            .register("rainbow_ant",
                    () -> EntityType.Builder.<RainbowAnt>create(RainbowAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "rainbow_ant").toString()));

    public static final RegistryObject<EntityType<RedRoseWarrior>> REDROSEWARRIOR = ENTITIES
            .register("redrosewarrior",
                    () -> EntityType.Builder.<RedRoseWarrior>create(RedRoseWarrior::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "redrosewarrior").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "stampylongnose").toString()));

    public static final RegistryObject<EntityType<Tewtiy>> TEWTIY = ENTITIES
            .register("tewtiy",
                    () -> EntityType.Builder.<Tewtiy>create(Tewtiy::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<WaterProjectile>> WATER_PROJECTILE = ENTITIES
            .register("water_projectile",
                    () -> EntityType.Builder.<WaterProjectile>create(WaterProjectile::new, EntityClassification.MISC)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "water_projectile").toString()));

    //Items
    public static final RegistryObject<Item> ALUMINIUM = ITEMS.register("aluminium_ingot", AluminiumIngot::new);

    public static final RegistryObject<AppleSeed> APPLE_SEED = ITEMS.register("apple_seed", AppleSeed::new);

    public static final RegistryObject<Item> BLOODSTONE = ITEMS.register("bloodstone", BloodStone::new);

    public static final RegistryObject<BLT> BLT = ITEMS.register("blt", BLT::new);

    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);

    public static final RegistryObject<ButterCandy> BUTTER_CANDY = ITEMS.register("butter_candy", ButterCandy::new);

    public static final RegistryObject<CandyCane> CANDY_CANE = ITEMS.register("candy_cane", CandyCane::new);

    public static final RegistryObject<Item> CATS_EYE = ITEMS.register("cats_eye", CatsEye::new);

    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);

    public static final RegistryObject<Item> COARSE_AMETHYST = ITEMS.register("coarse_amethyst", CoarseAmethyst::new);

    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);

    public static final RegistryObject<Item> COPPER_LUMP = ITEMS.register("copper_lump", CopperLump::new);

    public static final RegistryObject<CritterCage> CRITTER_CAGE = ITEMS.register("critter_cage", CritterCage::new);

    public static final RegistryObject<CZLoinCoin> CZ_LOIN_COIN = ITEMS.register("cz_loin_coin", CZLoinCoin::new);

    public static final RegistryObject<DeadRainbowAnt> DEAD_RAINBOW_ANT = ITEMS.register("dead_rainbow_ant", DeadRainbowAnt::new);

    public static final RegistryObject<MinersDreamItem> MINERS_DREAM = ITEMS.register("miners_dream", MinersDreamItem::new);

    public static final RegistryObject<RainbowAntAbdomen> RAINBOW_ANT_ABDOMEN = ITEMS.register("rainbow_ant_abdomen", RainbowAntAbdomen::new);

    public static final RegistryObject<RainbowAntEye> RAINBOW_ANT_EYE = ITEMS.register("rainbow_ant_eye", RainbowAntEye::new);

    public static final RegistryObject<RainbowAntLeg> RAINBOW_ANT_LEG = ITEMS.register("rainbow_ant_leg", RainbowAntLeg::new);

    public static final RegistryObject<RainbowAntToken> RAINBOW_ANT_TOKEN = ITEMS.register("rainbow_ant_token", RainbowAntToken::new);

    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", Sapphire::new);

    public static final RegistryObject<Item> TITANIUM_HARDENED_CAKE = ITEMS.register("titanium_hardened_cake", TitaniumHardenedCake::new);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", TitaniumIngot::new);

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", TitaniumNugget::new);

    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", Wrench::new);

    //Petrified Mob blocks
    public static final RegistryObject<Block> MUTANT_ZOMBIE_EGG_ORE = BLOCKS.register("mutant_zombie_egg_ore", BlockMobOre::new);
    public static final RegistryObject<Block> REDROSEWARRIOR_EGG_ORE = BLOCKS.register("redrosewarrior_egg_ore", BlockMobOre::new);

    //Petrified Mob items
    public static final RegistryObject<Item> REDROSEWARRIOR_EGG_ORE_ITEM = ITEMS.register("redrosewarrior_egg_ore", () -> new BlockItemMobOre(REDROSEWARRIOR_EGG_ORE.get()));
    public static final RegistryObject<Item> Mutant_Zombie_EGG_ORE_ITEM = ITEMS.register("mutant_zombie_egg_ore", () -> new BlockItemMobOre(MUTANT_ZOMBIE_EGG_ORE.get()));

    //Spawn Eggs
    public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = ITEMS.register("allosaurus_spawn_egg", () -> new SpawnEggItem(RegistryHandler.ALLOSAURUS, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEggItem> ATTACK_SQUID_SPAWN_EGG = ITEMS.register("attack_squid_spawn_egg", () -> new SpawnEggItem(RegistryHandler.ATTACK_SQUID, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> BEAVER_SPAWN_EGG = ITEMS.register("beaver_spawn_egg", BeaverSpawnEgg::new);

    public static final RegistryObject<Item> BIRD_SPAWN_EGG = ITEMS.register("bird_spawn_egg", BirdSpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> ENT_SPAWN_EGG = ITEMS.register("ent_spawn_egg", () -> new SpawnEggItem(RegistryHandler.ENT, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> FIRE_FISH_SPAWN_EGG = ITEMS.register("fire_fish_spawn_egg", FireFishSpawnEgg::new);

    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", MermaidSpawnEgg::new);

    public static final RegistryObject<Item> MOLDY_SPAWN_EGG = ITEMS.register("moldy_spawn_egg", MoldySpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> NOTBREEBREE_SPAWN_EGG = ITEMS.register("notbreebree_spawn_egg", () -> new SpawnEggItem(RegistryHandler.NOTBREEBREE, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> RED_COW_SPAWN_EGG = ITEMS.register("red_cow_spawn_egg", RedCowSpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> REDROSEWARRIOR_SPAWN_EGG = ITEMS.register("redrosewarrior_spawn_egg", () -> new SpawnEggItem(RegistryHandler.REDROSEWARRIOR, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> ROBO_BOMB_SPAWN_EGG = ITEMS.register("robo-bomb_spawn_egg", RoboBombSpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> STAMPYLONGNOSE_SPAWN_EGG = ITEMS.register("stampylongnose_spawn_egg", () -> new SpawnEggItem(RegistryHandler.STAMPYLONGNOSE, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEggItem> TEWTIY_SPAWN_EGG = ITEMS.register("tewtiy_spawn_egg", () -> new SpawnEggItem(RegistryHandler.TEWTIY, new Item.Properties().group(DangerZone.TAB)));

    //Tools
    public static final RegistryObject<CoarseAmethystAxe> COARSE_AMETHYST_AXE = ITEMS.register("coarse_amethyst_axe", CoarseAmethystAxe::new);

    public static final RegistryObject<CoarseAmethystHoe> COARSE_AMETHYST_HOE = ITEMS.register("coarse_amethyst_hoe", CoarseAmethystHoe::new);

    public static final RegistryObject<CoarseAmethystPickaxe> COARSE_AMETHYST_PICKAXE = ITEMS.register("coarse_amethyst_pickaxe", CoarseAmethystPickaxe::new);

    public static final RegistryObject<CoarseAmethystShovel> COARSE_AMETHYST_SHOVEL = ITEMS.register("coarse_amethyst_shovel", CoarseAmethystShovel::new);

    public static final RegistryObject<CoarseAmethystSword> COARSE_AMETHYST_SWORD = ITEMS.register("coarse_amethyst_sword", CoarseAmethystSword::new);

    public static final RegistryObject<CakeSword> CAKE_SWORD = ITEMS.register("cake_sword", CakeSword::new);

    public static final RegistryObject<EmeraldAxe> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);

    public static final RegistryObject<EmeraldHoe> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);

    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);

    public static final RegistryObject<EmeraldShovel> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);

    public static final RegistryObject<EmeraldSword> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);

    public static final RegistryObject<PoppySword> POPPY_SWORD = ITEMS.register("poppy_sword", PoppySword::new);

    public static final RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", SapphireAxe::new);

    public static final RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", SapphireHoe::new);

    public static final RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", SapphirePickaxe::new);

    public static final RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", SapphireShovel::new);

    public static final RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", SapphireSword::new);

    //SOUNDS
    public static final RegistryObject<SoundEvent> AMOXICILLIN_AMBIENT = SOUNDS.register("amoxcillin_ambient", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "amoxcillin_ambient")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_BREAK = SOUNDS.register("leather_block_break", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_break")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_STEP = SOUNDS.register("leather_block_step", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_step")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_PLACE = SOUNDS.register("leather_block_place", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_place")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_HIT = SOUNDS.register("leather_block_hit", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID, "leather_block_hit")));
    public static final RegistryObject<SoundEvent> STAMPYLONGNOSE_AMBIENT = SOUNDS.register("stampylivingsound", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "stampylivingsound")));}
