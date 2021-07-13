package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.items.SpawnEggItem;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.armor.*;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.items.EmeraldPickaxe;
import com.devmaster.dangerzone.tools.ModArmorMaterial;
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
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<NotBreeBree>> NOTBREEBREE = ENTITIES
            .register("notbreebree",
                    () -> EntityType.Builder.<NotBreeBree>create(NotBreeBree::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "notbreebree").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
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

    //Items
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", Amethyst::new);

    public static final RegistryObject<Item> TITANIUM_Hardened_CAKE = ITEMS.register("titanium_hardened_cake", TitaniumHardenedCake::new);

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", TitaniumNugget::new);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", TitaniumIngot::new);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);

    public static final RegistryObject<FireFish> FIRE_FISH = ITEMS.register("fire_fish", FireFish::new);

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

    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", MermaidSpawnEgg::new);

    public static final RegistryObject<Item> FIRE_FISH_SPAWN_EGG = ITEMS.register("fire_fish_spawn_egg", FireFishSpawnEgg::new);

    public static final RegistryObject<SpawnEggItem> REDROSEWARRIOR_SPAWN_EGG = ITEMS.register("redrosewarrior_spawn_egg", () -> new SpawnEggItem(RegistryHandler.REDROSEWARRIOR, new Item.Properties().group(DangerZone.TAB)));


    //Tools
    public static final RegistryObject<PickaxeItem> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () ->
            new PickaxeItem(ModItemTier.AMETHYST, 12, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () ->
            new SwordItem(ModItemTier.AMETHYST, 14, -2.4F, new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<AxeItem> AMETHYST_AXE = ITEMS.register("amethyst_axe", () ->
            new AxeItem(ModItemTier.AMETHYST, 13, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<ShovelItem> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () ->
            new ShovelItem(ModItemTier.AMETHYST, 11, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<HoeItem> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () ->
            new HoeItem(ModItemTier.AMETHYST, 0, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<AxeItem> EMERALD_AXE = ITEMS.register("emerald_axe", () ->
            new AxeItem(ModItemTier.EMERALD, 8, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () ->
            new EmeraldPickaxe(ModItemTier.EMERALD, 7, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<HoeItem> EMERALD_HOE = ITEMS.register("emerald_hoe", () ->
            new HoeItem(ModItemTier.EMERALD, 0, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<ShovelItem> Emerald_SHOVEL = ITEMS.register("emerald_shovel", () ->
            new ShovelItem(ModItemTier.EMERALD, 6, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> EMERALD_SWORD = ITEMS.register("emerald_sword", () ->
            new SwordItem(ModItemTier.EMERALD, 9, -2.4F, new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () ->
            new PickaxeItem(ModItemTier.SAPPHIRE, 16, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () ->
            new SwordItem(ModItemTier.SAPPHIRE, 18, -2.4F, new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () ->
            new AxeItem(ModItemTier.SAPPHIRE, 17, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () ->
            new ShovelItem(ModItemTier.SAPPHIRE, 15, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () ->
            new HoeItem(ModItemTier.SAPPHIRE, -1, -2.4F, new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> POPPY_SWORD = ITEMS.register("poppy_sword", () ->
            new SwordItem(ModItemTier.EMERALD, 4, -2.4F, new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<SwordItem> CAKE_SWORD = ITEMS.register("cake_sword", () ->
            new SwordItem(ModItemTier.CAKE, 0, -2.4F, new Item.Properties().group(DangerZone.WEAPONS)));

    //Armor
    public static final RegistryObject<ArmorItem> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", () ->
            new LapisHelmet(ModArmorMaterial.LAPIS, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", () ->
            new LapisChestplate(ModArmorMaterial.LAPIS, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", () ->
            new LapisLeggings(ModArmorMaterial.LAPIS, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", () ->
            new LapisBoots(ModArmorMaterial.LAPIS, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> EMERALD_HELMET = ITEMS.register("emerald_helmet", () ->
            new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () ->
            new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () ->
            new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem> EMERALD_BOOTS = ITEMS.register("emerald_boots", () ->
            new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    //Blocks
    public static final RegistryObject<Block> AMETHYST_ORE_BLOCK = BLOCKS.register("amethyst_ore_block", AmethystOreBlock::new);

    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);

    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", AmethystBlock::new);

    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);

    public static final RegistryObject<Block> EYE_OF_ENDER_BLOCK = BLOCKS.register("eye_of_ender_block", EyeOfEnderBlock::new);

    public static final RegistryObject<Block> ENDER_PEARL_BLOCK = BLOCKS.register("ender_pearl_block", EnderPearlBlock::new);

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

    //Petrified animals blocks
    public static final RegistryObject<Block> REDROSEWARRIOR_EGG_ORE = BLOCKS.register("redrosewarrior_egg_ore", BlockMobOre::new);
    public static final RegistryObject<Block> MUTANT_ZOMBIE_EGG_ORE = BLOCKS.register("mutant_zombie_egg_ore", BlockMobOre::new);


    //Block Items
    public static final RegistryObject<Item> AMETHYST_ORE_BLOCK_ITEM = ITEMS.register("amethyst_ore_block", () -> new BlockItemBase(AMETHYST_ORE_BLOCK.get()));

    public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItemBase(AMETHYST_BLOCK.get()));

    public static final RegistryObject<Item> SALT_ORE_BLOCK_ITEM = ITEMS.register("salt_ore_block", () -> new BlockItemBase(SALT_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_ORE_BLOCK_ITEM = ITEMS.register("sapphire_ore_block", () -> new BlockItemBase(SAPPHIRE_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));

    public static final RegistryObject<Item> EYE_OF_ENDER_BLOCK_ITEM = ITEMS.register("eye_of_ender_block", () -> new BlockItemBase(EYE_OF_ENDER_BLOCK.get()));

    public static final RegistryObject<Item> ENDER_PEARL_BLOCK_ITEM = ITEMS.register("ender_pearl_block", () -> new BlockItemBase(ENDER_PEARL_BLOCK.get()));

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

    //Petrified animals items
    public static final RegistryObject<Item> REDROSEWARRIOR_EGG_ORE_ITEM = ITEMS.register("redrosewarrior_egg_ore", () -> new BlockItemMobOre(REDROSEWARRIOR_EGG_ORE.get()));
    public static final RegistryObject<Item> Mutant_Zombie_EGG_ORE_ITEM = ITEMS.register("mutant_zombie_egg_ore", () -> new BlockItemMobOre(MUTANT_ZOMBIE_EGG_ORE.get()));



    //Dimensions
    public static final RegistryKey<World> VILLAGES = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "dimension/villages"));
}