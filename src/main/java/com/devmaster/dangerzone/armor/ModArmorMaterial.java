package com.devmaster.dangerzone.armor;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    AMETHYST(DangerZone.MOD_ID + ":amethyst", 100, new int[] { 4, 7, 8, 3 }, 40,
             SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {return Ingredient.fromItems(RegistryHandler.AMETHYST.get());}),

    SAPPHIRE(DangerZone.MOD_ID + ":sapphire", 90, new int[] { 3, 7, 8, 3 }, 40,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {return Ingredient.fromItems(RegistryHandler.SAPPHIRE.get());});

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[]damageReductionArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

ModArmorMaterial(String name, int maxDamageFactor, int[]damageReductionArray, int enchantability,
                 SoundEvent soundEvent, Float toughness, Supplier<Ingredient> repairMaterial) {
this.name = name;
this.maxDamageFactor = maxDamageFactor;
this.damageReductionArray = damageReductionArray;
this.enchantability = enchantability;
this.soundEvent = soundEvent;
this.toughness = toughness;
this.repairMaterial = repairMaterial;
}

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
@OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
