package com.devmaster.dangerzone.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

import static com.devmaster.dangerzone.init.Items.*;
import static net.minecraft.enchantment.Enchantments.*;

public class EnchantedSwordItem extends SwordItem {
	public EnchantedSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		CompoundNBT nbt;
		if(stack.hasTag()) {
			nbt = stack.getTag();
		}else {
			nbt = new CompoundNBT();
		}


		if(!nbt.contains("added")) {

			if(stack.getEnchantmentTagList().isEmpty()) {
				nbt.putBoolean("added", true);
				if(stack.getItem() == BATTLE_AXE) {
					stack.addEnchantment(LOOTING, 3);
					stack.addEnchantment(UNBREAKING, 3);
				}
				if(stack.getItem() == QUEEN_BATTLE_AXE) {
					stack.addEnchantment(SHARPNESS, 5);
					stack.addEnchantment(SMITE, 5);
					stack.addEnchantment(BANE_OF_ARTHROPODS, 5);
					stack.addEnchantment(KNOCKBACK, 3);
					stack.addEnchantment(LOOTING, 3);
					stack.addEnchantment(UNBREAKING, 3);
					stack.addEnchantment(FIRE_ASPECT, 2);
					stack.addEnchantment(SWEEPING, 3);
				}
				if(stack.getItem() == ULTIMATE_SWORD) {
					stack.addEnchantment(SHARPNESS, 5);
					stack.addEnchantment(SMITE, 5);
					stack.addEnchantment(BANE_OF_ARTHROPODS, 5);
					stack.addEnchantment(KNOCKBACK, 3);
					stack.addEnchantment(LOOTING, 3);
					stack.addEnchantment(UNBREAKING, 3);
					stack.addEnchantment(FIRE_ASPECT, 2);
					stack.addEnchantment(SWEEPING, 3);
				}
				if(stack.getItem() == ZANGETSU) {
					stack.addEnchantment(KNOCKBACK, 2);
					stack.addEnchantment(FIRE_ASPECT, 2);
				}
				if(stack.getItem() == LAPIS_SWORD) {
					stack.addEnchantment(SHARPNESS, 1);
				}
			}
		}
	}
}
