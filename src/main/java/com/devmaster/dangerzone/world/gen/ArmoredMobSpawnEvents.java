package com.devmaster.dangerzone.world.gen;

import java.util.Random;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ArmoredMobSpawnEvents {
    public static Enchantment[] helmetEnchant;
    public static Enchantment[] chest_legsEnchant;
    public static Enchantment[] bootEnchant;
    public static Enchantment[] swordEnchant;
    public static Item[] swordList;
    public static Item[][] armorSet;

    public ArmoredMobSpawnEvents() {
    }

    @SubscribeEvent
    public static void spawnMonster(EntityJoinWorldEvent event) {
        Random random = new Random();
        float chance = random.nextFloat();
        if (event.getWorld().getDifficulty() == Difficulty.HARD) {
            if (chance < 0.05F) {
                zombie(event);
            }
        }

        if (event.getWorld().getDifficulty() == Difficulty.NORMAL) {
            if (chance < 0.05F) {
                zombie(event);
            }
        }

        if (event.getWorld().getDifficulty() == Difficulty.EASY) {
            if (chance < 0.05F) {
                zombie(event);
            }
        }

    }

    public static void zombie(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof ZombieEntity) {
            ZombieEntity zombie = (ZombieEntity)event.getEntity();
            Random random = new Random();
            ItemStack test = new ItemStack(RegistryHandler.CZ_LOIN_COIN.get());
            test.addEnchantment(helmetEnchant[1], 1);
            int armorSelect = random.nextInt(armorSet.length);
            int helmetEnchantSelect = random.nextInt(helmetEnchant.length);
            int chest_legsEnchantSelect = random.nextInt(chest_legsEnchant.length);
            int bootEnchantSelect = random.nextInt(bootEnchant.length);
            int swordSelect = random.nextInt(swordList.length);
            boolean addItem = random.nextBoolean();
            boolean addEnchant;
            ItemStack stack;
            if (addItem) {
                addEnchant = random.nextBoolean();
                if (addEnchant) {
                    stack = new ItemStack(armorSet[armorSelect][0]);
                    stack.addEnchantment(helmetEnchant[helmetEnchantSelect], random.nextInt(helmetEnchant[helmetEnchantSelect].getMaxLevel()));
                    zombie.setItemStackToSlot(EquipmentSlotType.HEAD, stack);
                } else if (!addEnchant) {
                    zombie.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(armorSet[armorSelect][0]));
                }
            }

            addItem = random.nextBoolean();
            if (addItem) {
                addEnchant = random.nextBoolean();
                if (addEnchant) {
                    stack = new ItemStack(armorSet[armorSelect][1]);
                    stack.addEnchantment(chest_legsEnchant[chest_legsEnchantSelect], random.nextInt(chest_legsEnchant[chest_legsEnchantSelect].getMaxLevel()));
                    zombie.setItemStackToSlot(EquipmentSlotType.CHEST, stack);
                } else if (!addEnchant) {
                    zombie.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(armorSet[armorSelect][1]));
                }
            }

            addItem = random.nextBoolean();
            if (addItem) {
                addEnchant = random.nextBoolean();
                if (addEnchant) {
                    stack = new ItemStack(armorSet[armorSelect][2]);
                    stack.addEnchantment(chest_legsEnchant[chest_legsEnchantSelect], random.nextInt(chest_legsEnchant[chest_legsEnchantSelect].getMaxLevel()));
                    zombie.setItemStackToSlot(EquipmentSlotType.LEGS, stack);
                } else if (!addEnchant) {
                    zombie.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(armorSet[armorSelect][2]));
                }
            }

            addItem = random.nextBoolean();
            if (addItem) {
                addEnchant = random.nextBoolean();
                if (addEnchant) {
                    stack = new ItemStack(armorSet[armorSelect][3]);
                    stack.addEnchantment(bootEnchant[bootEnchantSelect], random.nextInt(bootEnchant[bootEnchantSelect].getMaxLevel()));
                    zombie.setItemStackToSlot(EquipmentSlotType.FEET, stack);
                } else if (!addEnchant) {
                    zombie.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(armorSet[armorSelect][3]));
                }
            }

            addItem = random.nextBoolean();
            if (addItem) {
                addEnchant = random.nextBoolean();
                if (addEnchant) {
                    stack = new ItemStack(swordList[swordSelect]);
                    EnchantmentHelper.addRandomEnchantment(random, stack, 0, false);
                    zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack);
                } else if (!addItem) {
                    zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(swordList[swordSelect]));
                }
            }
        }

    }

    static {
        helmetEnchant = new Enchantment[]{Enchantments.AQUA_AFFINITY, Enchantments.BINDING_CURSE, Enchantments.BLAST_PROTECTION, Enchantments.VANISHING_CURSE, Enchantments.FIRE_PROTECTION, Enchantments.MENDING, Enchantments.PROJECTILE_PROTECTION, Enchantments.PROTECTION, Enchantments.RESPIRATION, Enchantments.THORNS, Enchantments.UNBREAKING};
        chest_legsEnchant = new Enchantment[]{Enchantments.BLAST_PROTECTION, Enchantments.PROTECTION, Enchantments.BINDING_CURSE, Enchantments.VANISHING_CURSE, Enchantments.FIRE_PROTECTION, Enchantments.MENDING, Enchantments.PROJECTILE_PROTECTION, Enchantments.THORNS, Enchantments.UNBREAKING};
        bootEnchant = new Enchantment[]{Enchantments.BLAST_PROTECTION, Enchantments.VANISHING_CURSE, Enchantments.BINDING_CURSE, Enchantments.DEPTH_STRIDER, Enchantments.FROST_WALKER, Enchantments.FEATHER_FALLING, Enchantments.FIRE_PROTECTION, Enchantments.MENDING, Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.SOUL_SPEED, Enchantments.THORNS, Enchantments.UNBREAKING};
        swordEnchant = new Enchantment[]{Enchantments.BANE_OF_ARTHROPODS, Enchantments.VANISHING_CURSE, Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK, Enchantments.LOOTING, Enchantments.SMITE, Enchantments.MENDING, Enchantments.SHARPNESS, Enchantments.SWEEPING, Enchantments.UNBREAKING};
        swordList = new Item[]{RegistryHandler.POPPY_SWORD.get(), RegistryHandler.COARSE_AMETHYST_SWORD.get(), RegistryHandler.CAKE_SWORD.get(), RegistryHandler.EMERALD_SWORD.get(), RegistryHandler.SAPPHIRE_SWORD.get(), RegistryHandler.QUEEN_GHIDORAH_SCALE_BATTLE_AXE.get(), RegistryHandler.MANTIS_CLAW.get(), RegistryHandler.FIRE_CAKE_SWORD.get()};
        armorSet = new Item[][]{{RegistryHandler.CATS_EYE_HELMET.get(), RegistryHandler.CATS_EYE_CHESTPLATE.get(), RegistryHandler.CATS_EYE_LEGGINGS.get(), RegistryHandler.CATS_EYE_BOOTS.get()}, {RegistryHandler.COARSE_AMETHYST_HELMET.get(), RegistryHandler.COARSE_AMETHYST_CHESTPLATE.get(), RegistryHandler.COARSE_AMETHYST_LEGGINGS.get(), RegistryHandler.COARSE_AMETHYST_BOOTS.get()}, {RegistryHandler.COPPER_HELMET.get(), RegistryHandler.COPPER_CHESTPLATE.get(), RegistryHandler.COPPER_LEGGINGS.get(), RegistryHandler.COPPER_BOOTS.get()}, {RegistryHandler.EMERALD_HELMET.get(), RegistryHandler.EMERALD_CHESTPLATE.get(), RegistryHandler.EMERALD_LEGGINGS.get(), RegistryHandler.EMERALD_BOOTS.get()}, {RegistryHandler.LAPIS_HELMET.get(), RegistryHandler.LAPIS_CHESTPLATE.get(), RegistryHandler.LAPIS_LEGGINGS.get(), RegistryHandler.LAPIS_BOOTS.get()}, {RegistryHandler.SAPPHIRE_HELMET.get(), RegistryHandler.SAPPHIRE_CHESTPLATE.get(), RegistryHandler.SAPPHIRE_LEGGINGS.get(), RegistryHandler.SAPPHIRE_BOOTS.get()}};
    }
}
