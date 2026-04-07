package com.devmaster.dangerzone.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class ModdedTier implements IItemTier
{
	private int uses = 0, harvestlevel = 2, enchantability = 0, efficiency = 0;
	private float swingspeed = 1, damage = 0;
	private ItemStack repairitem;

	public ModdedTier(int uses, float damage, int efficiency, float swingspeed)
	{
		this.uses = uses;
		this.damage = damage;
		this.efficiency = efficiency;
		this.swingspeed = swingspeed;
	}

	public ModdedTier level(int level)
	{
		this.harvestlevel = level;
		return this;
	}

	public ModdedTier enchanting(int i)
	{
		this.enchantability = i;
		return this;
	}

	public ModdedTier material(Item item)
	{
		repairitem = new ItemStack(item);
		return this;
	}

	@Override
	public int getMaxUses() {
		return uses;
	}

	public float getAttackSpeed() {
		return swingspeed;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		return damage;
	}

	@Override
	public int getHarvestLevel() {
		return harvestlevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromStacks(repairitem);
	}
}