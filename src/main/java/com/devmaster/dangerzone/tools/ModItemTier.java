package com.devmaster.dangerzone.tools;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    AMETHYST(4, 2000, 11.0F, 0.0F, 70, () -> {
        return Ingredient.fromItems(RegistryHandler.AMETHYST.get());
    }),

    CAKE(1, 1, 1.0F, 0.0F, 1, () -> {
        return Ingredient.fromItems(Items.CAKE);
    }),

    FIRE_CAKE(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(Items.CAKE);
    }),

    TITANIUM_CAKE(0, 120, 2.0F, 0.0F, 45, () -> {
        return Ingredient.fromItems(RegistryHandler.TITANIUM_Hardened_CAKE.get());
    }),

    EMERALD(3, 1300, 10.0F, 0.0F, 70, () -> {
        return Ingredient.fromItems(Items.EMERALD.getItem());
    }),

    SAPPHIRE(4, 1400, 10.0F, 0.0F, 83, () -> {
        return Ingredient.fromItems(RegistryHandler.SAPPHIRE.get());
    }),

    POPPY(3, 1300, 10.0F, 0.0F, 70, () -> {
        return Ingredient.fromItems(Items.POPPY.getItem());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
