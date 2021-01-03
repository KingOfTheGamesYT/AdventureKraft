package com.devmaster.dangerzone.util;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.armor.*;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.entity.StampyLongNose;
import com.devmaster.dangerzone.entity.Tewtiy;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.tools.EmeraldPickaxe;
import com.devmaster.dangerzone.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
                    () -> EntityType.Builder.<Tewtiy>create(Tewtiy::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "stampylongnose").toString()));
							
	
    //EntitySpawnPlacementRegistry.register(TEWTIY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Tewtiy::canTewtiySpawn);
    //EntitySpawnPlacementRegistry.register(STAMPYLONGNOSE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StampyLongNose::canStampyLongNoseSpawn);

    
    //Items
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", Amethyst::new);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);

    public static final RegistryObject<FireFish> FIRE_FISH = ITEMS.register("fire_fish", FireFish::new);

    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", Sapphire::new);

    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);

    public static final RegistryObject<MinersDreamItem> MINERS_DREAM = ITEMS.register("miners_dream", MinersDreamItem::new);

    public static final RegistryObject<CritterCage> CRITTER_CAGE = ITEMS.register("critter_cage", CritterCage::new);

    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", Wrench::new);

    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);

    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);

    public static final RegistryObject<ButterCandy> BUTTER_CANDY = ITEMS.register("butter_candy", ButterCandy::new);


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

    public static final RegistryObject<Item> COMPRESSED_POPPY_BLOCK_ITEM = ITEMS.register("compressed_poppy_block", () -> new BlockItemBase(COMPRESSED_POPPY_BLOCK.get()));

    public static final RegistryObject<Item> STICKY_BLOCK_ITEM = ITEMS.register("sticky_block", () -> new BlockItemBase(STICKY_BLOCK.get()));

    public static final RegistryObject<Item> DARK_BROWN_BLOCK_ITEM = ITEMS.register("dark_brown_block", () -> new BlockItemBase(DARK_BROWN_BLOCK.get()));

    public static final RegistryObject<Item> DARK_ORANGE_BLOCK_ITEM = ITEMS.register("dark_orange_block", () -> new BlockItemBase(DARK_ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> ORANGE_BLOCK_ITEM = ITEMS.register("orange_block", () -> new BlockItemBase(ORANGE_BLOCK.get()));

}