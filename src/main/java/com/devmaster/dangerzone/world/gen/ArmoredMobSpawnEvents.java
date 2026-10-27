package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.entity.Entity;

public class ArmoredMobSpawnEvents {

    private static final float EQUIP_CHANCE = 0.05F;
    private static final float SLOT_CHANCE = 0.30F;
    private static final float ENCHANTMENT_CHANCE = 0.50F;

    private static final Enchantment[] HELMET_ENCHANTMENTS = {
            Enchantments.AQUA_AFFINITY,
            Enchantments.BLAST_PROTECTION,
            Enchantments.BINDING_CURSE,
            Enchantments.VANISHING_CURSE,
            Enchantments.FIRE_PROTECTION,
            Enchantments.MENDING,
            Enchantments.PROJECTILE_PROTECTION,
            Enchantments.PROTECTION,
            Enchantments.RESPIRATION,
            Enchantments.THORNS,
            Enchantments.UNBREAKING
    };

    private static final Enchantment[] BODY_ENCHANTMENTS = {
            Enchantments.BLAST_PROTECTION,
            Enchantments.BINDING_CURSE,
            Enchantments.VANISHING_CURSE,
            Enchantments.FIRE_PROTECTION,
            Enchantments.PROTECTION,
            Enchantments.MENDING,
            Enchantments.PROJECTILE_PROTECTION,
            Enchantments.THORNS,
            Enchantments.UNBREAKING
    };

    private static final Enchantment[] BOOT_ENCHANTMENTS = {
            Enchantments.BLAST_PROTECTION,
            Enchantments.BINDING_CURSE,
            Enchantments.VANISHING_CURSE,
            Enchantments.DEPTH_STRIDER,
            Enchantments.FEATHER_FALLING,
            Enchantments.FIRE_PROTECTION,
            Enchantments.FROST_WALKER,
            Enchantments.MENDING,
            Enchantments.PROJECTILE_PROTECTION,
            Enchantments.PROTECTION,
            Enchantments.SOUL_SPEED,
            Enchantments.THORNS,
            Enchantments.UNBREAKING
    };

    private static final Enchantment[] SWORD_ENCHANTMENTS = {
            Enchantments.BANE_OF_ARTHROPODS,
            Enchantments.VANISHING_CURSE,
            Enchantments.FIRE_ASPECT,
            Enchantments.KNOCKBACK,
            Enchantments.LOOTING,
            Enchantments.MENDING,
            Enchantments.SHARPNESS,
            Enchantments.SMITE,
            Enchantments.SWEEPING,
            Enchantments.UNBREAKING
    };

    private static final Item[] HELMETS = {
            RegistryHandler.CATS_EYE_HELMET.get(),
            RegistryHandler.COARSE_AMETHYST_HELMET.get(),
            RegistryHandler.COPPER_HELMET.get(),
            RegistryHandler.COTTON_CANDY_HELMET.get(),
            RegistryHandler.EMERALD_HELMET.get(),
            RegistryHandler.LAPIS_HELMET.get(),
            RegistryHandler.QUEEN_GHIDORAH_SCALE_HELMET.get(),
            RegistryHandler.SAPPHIRE_HELMET.get()
    };

    private static final Item[] CHESTPLATES = {
            RegistryHandler.CATS_EYE_CHESTPLATE.get(),
            RegistryHandler.COARSE_AMETHYST_CHESTPLATE.get(),
            RegistryHandler.COPPER_CHESTPLATE.get(),
            RegistryHandler.COTTON_CANDY_CHESTPLATE.get(),
            RegistryHandler.EMERALD_CHESTPLATE.get(),
            RegistryHandler.LAPIS_CHESTPLATE.get(),
            RegistryHandler.QUEEN_GHIDORAH_SCALE_CHESTPLATE.get(),
            RegistryHandler.SAPPHIRE_CHESTPLATE.get()
    };

    private static final Item[] LEGGINGS = {
            RegistryHandler.CATS_EYE_LEGGINGS.get(),
            RegistryHandler.COARSE_AMETHYST_LEGGINGS.get(),
            RegistryHandler.COPPER_LEGGINGS.get(),
            RegistryHandler.COTTON_CANDY_LEGGINGS.get(),
            RegistryHandler.EMERALD_LEGGINGS.get(),
            RegistryHandler.LAPIS_LEGGINGS.get(),
            RegistryHandler.QUEEN_GHIDORAH_SCALE_LEGGINGS.get(),
            RegistryHandler.SAPPHIRE_LEGGINGS.get()
    };

    private static final Item[] BOOTS = {
            RegistryHandler.CATS_EYE_BOOTS.get(),
            RegistryHandler.COARSE_AMETHYST_BOOTS.get(),
            RegistryHandler.COPPER_BOOTS.get(),
            RegistryHandler.COTTON_CANDY_BOOTS.get(),
            RegistryHandler.EMERALD_BOOTS.get(),
            RegistryHandler.LAPIS_BOOTS.get(),
            RegistryHandler.SAPPHIRE_BOOTS.get()
    };

    private static final Item[] SWORDS = {
            RegistryHandler.CAKE_SWORD.get(),
            RegistryHandler.COARSE_AMETHYST_SWORD.get(),
            RegistryHandler.EMERALD_SWORD.get(),
            RegistryHandler.FIRE_CAKE_SWORD.get(),
            RegistryHandler.MANTIS_CLAW.get(),
            RegistryHandler.POPPY_SWORD.get(),
            RegistryHandler.QUEEN_GHIDORAH_SCALE_BATTLE_AXE.get(),
            RegistryHandler.SAPPHIRE_SWORD.get(),
            RegistryHandler.TITANIUM_CAKE_SWORD.get()
    };

    @SubscribeEvent
    public static void spawnMonster(EntityJoinWorldEvent event) {
        if (event.getWorld().isRemote()) {
            return;
        }

        Entity entity = event.getEntity();

        if (!(entity instanceof ZombieEntity)) {
            return;
        }

        ZombieEntity zombie = (ZombieEntity) entity;

        if (zombie.getPersistentData().getBoolean("armored_mob_processed")) {
            return;
        }

        zombie.getPersistentData().putBoolean("armored_mob_processed", true);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        if (random.nextFloat() >= EQUIP_CHANCE) {
            return;
        }

        equipRandomArmor(zombie, HELMETS, EquipmentSlotType.HEAD, HELMET_ENCHANTMENTS, random);
        equipRandomArmor(zombie, CHESTPLATES, EquipmentSlotType.CHEST, BODY_ENCHANTMENTS, random);
        equipRandomArmor(zombie, LEGGINGS, EquipmentSlotType.LEGS, BODY_ENCHANTMENTS, random);
        equipRandomArmor(zombie, BOOTS, EquipmentSlotType.FEET, BOOT_ENCHANTMENTS, random);

        if (random.nextFloat() < SLOT_CHANCE) {
            Item weapon = SWORDS[random.nextInt(SWORDS.length)];
            ItemStack stack = new ItemStack(weapon);

            if (random.nextFloat() < ENCHANTMENT_CHANCE) {
                Enchantment enchantment = SWORD_ENCHANTMENTS[random.nextInt(SWORD_ENCHANTMENTS.length)];

                int level = random.nextInt(enchantment.getMaxLevel()) + 1;

                stack.addEnchantment(enchantment, level);
            }

            zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack);
        }
    }

    private static void equipRandomArmor(ZombieEntity zombie, Item[] armorPool, EquipmentSlotType slot, Enchantment[] enchantments, ThreadLocalRandom random)
    {
        if (random.nextFloat() >= SLOT_CHANCE) {
            return;
        }

        Item item = armorPool[random.nextInt(armorPool.length)];
        ItemStack stack = new ItemStack(item);

        if (random.nextFloat() < ENCHANTMENT_CHANCE) {
            Enchantment enchantment = enchantments[random.nextInt(enchantments.length)];

            int level = random.nextInt(enchantment.getMaxLevel()) + 1;
            stack.addEnchantment(enchantment, level);
        }
        zombie.setItemStackToSlot(slot, stack);
    }
}