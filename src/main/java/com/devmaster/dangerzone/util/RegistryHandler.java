package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.armor.*;
import com.devmaster.dangerzone.blocks.*;
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

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerZone.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DangerZone.MOD_ID);


    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    //Items
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", Amethyst::new);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);
    public static final RegistryObject<FireFish> FIRE_FISH = ITEMS.register("fire_fish", FireFish::new);
    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", Sapphire::new);
    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);

    //Tools
    public static final RegistryObject<PickaxeItem> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () ->
            new PickaxeItem(ModItemTier.AMETHYST, 12, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () ->
            new SwordItem(ModItemTier.AMETHYST, 14, -2.4F,new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<AxeItem> AMETHYST_AXE = ITEMS.register("amethyst_axe", () ->
            new AxeItem(ModItemTier.AMETHYST, 13, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<ShovelItem> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () ->
            new ShovelItem(ModItemTier.AMETHYST, 11, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<HoeItem> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () ->
            new HoeItem(ModItemTier.AMETHYST, 0, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<AxeItem> EMERALD_AXE = ITEMS.register("emerald_axe", () ->
            new AxeItem(ModItemTier.EMERALD, 8, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () ->
            new EmeraldPickaxe(ModItemTier.EMERALD, 7, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () ->
            new PickaxeItem(ModItemTier.SAPPHIRE, 16, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () ->
            new SwordItem(ModItemTier.SAPPHIRE, 18, -2.4F,new Item.Properties().group(DangerZone.WEAPONS)));

    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () ->
            new AxeItem(ModItemTier.SAPPHIRE, 17, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () ->
            new ShovelItem(ModItemTier.SAPPHIRE, 15, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () ->
            new HoeItem(ModItemTier.SAPPHIRE, -1, -2.4F,new Item.Properties().group(DangerZone.TOOLS)));

    //Armor
    public static final RegistryObject<ArmorItem>  AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () ->
            new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<ArmorItem>  SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () ->
            new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisHelmet>  LAPIS_HELMET = ITEMS.register("lapis_helmet", () ->
            new LapisHelmet(ModArmorMaterial.LAPIS, EquipmentSlotType.HEAD, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisChestplate>  LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", () ->
            new LapisChestplate(ModArmorMaterial.LAPIS, EquipmentSlotType.CHEST, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisLeggings>  LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", () ->
            new LapisLeggings(ModArmorMaterial.LAPIS, EquipmentSlotType.LEGS, new Item.Properties().group(DangerZone.ARMOR)));

    public static final RegistryObject<LapisBoots>  LAPIS_BOOTS = ITEMS.register("lapis_boots", () ->
            new LapisBoots(ModArmorMaterial.LAPIS, EquipmentSlotType.FEET, new Item.Properties().group(DangerZone.ARMOR)));

    //Blocks
    public static final RegistryObject<Block> AMETHYST_ORE_BLOCK = BLOCKS.register("amethyst_ore_block", AmethystOreBlock::new);
    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", AmethystBlock::new);
    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);
    public static final RegistryObject<Block> EYE_OF_ENDER_BLOCK = BLOCKS.register("eye_of_ender_block", EyeOfEnderBlock::new);
    public static final RegistryObject<Block> ENDER_PEARL_BLOCK = BLOCKS.register("ender_pearl_block", EnderPearlBlock::new);

    //Block Items
public static final RegistryObject<Item> AMETHYST_ORE_BLOCK_ITEM = ITEMS.register("amethyst_ore_block", () -> new BlockItemBase(AMETHYST_ORE_BLOCK.get()));
    public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItemBase(AMETHYST_BLOCK.get()));
    public static final RegistryObject<Item> SALT_ORE_BLOCK_ITEM = ITEMS.register("salt_ore_block", () -> new BlockItemBase(SALT_ORE_BLOCK.get()));
    public static final RegistryObject<Item> SAPPHIRE_ORE_BLOCK_ITEM = ITEMS.register("sapphire_ore_block", () -> new BlockItemBase(SAPPHIRE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));
    public static final RegistryObject<Item> EYE_OF_ENDER_BLOCK_ITEM = ITEMS.register("eye_of_ender_block", () -> new BlockItemBase(EYE_OF_ENDER_BLOCK.get()));
    public static final RegistryObject<Item> ENDER_PEARL_BLOCK_ITEM = ITEMS.register("ender_pearl_block", () -> new BlockItemBase(ENDER_PEARL_BLOCK.get()));

}
