package com.devmaster.dangerzone.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ArmourTier implements IArmorMaterial
{
	protected String resourcename;
	protected int durability, armor, enchantability;
	protected float toughness, knockback;
	protected Ingredient repairitem;
	protected boolean ismetal;

	public ArmourTier(String resourcename, int dura, int armor, int enchantability, float toughness, float knockbackresist, boolean ismetal, Item... repairitem)
	{
		this.resourcename = resourcename;
		this.durability = dura;
		this.armor = armor;
		this.enchantability = enchantability;
		this.toughness = toughness;
		this.knockback = knockbackresist;
		this.repairitem = Ingredient.fromItems(repairitem);
		this.ismetal = ismetal;
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		switch (slot)
		{
			case CHEST:
				return (int) (durability);
			case FEET:
				return durability;
			case HEAD:
				return (int) (durability);
			case LEGS:
				return (int) (durability);
			default:
				return 0;
		}
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
	switch (slot)
		{
			case CHEST:
				return (int) (armor);
			case FEET:
				return armor;
			case HEAD:
				return (int) (armor);
			case LEGS:
				return (int) (armor);
			default:
				return 0;
		}
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
	return ismetal ? SoundEvents.ITEM_ARMOR_EQUIP_IRON : SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairitem;
	}

	@Override
	public String getName()
	{
		return resourcename;
	}

	@Override
	public float getToughness()
	{
		return toughness;
	}

	@Override
	public float getKnockbackResistance()
	{
		return knockback;
	}
}