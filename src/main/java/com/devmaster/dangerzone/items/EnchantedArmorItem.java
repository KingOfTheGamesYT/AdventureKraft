package com.devmaster.dangerzone.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

import static com.devmaster.dangerzone.init.Items.*;
import static net.minecraft.enchantment.Enchantments.*;

public class EnchantedArmorItem extends ArmorItem {

	public EnchantedArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
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
				//region ultimate armor
				if(stack.getItem() == ULTIMATE_HELMET) {
					stack.addEnchantment(PROTECTION, 3);
					stack.addEnchantment(FIRE_PROTECTION, 1);
					stack.addEnchantment(BLAST_PROTECTION, 1);
					stack.addEnchantment(PROJECTILE_PROTECTION, 1);
					stack.addEnchantment(RESPIRATION, 3);
					stack.addEnchantment(AQUA_AFFINITY, 1);
				}
				if(stack.getItem() == ULTIMATE_CHESTPLATE || stack.getItem() == ULTIMATE_LEGGINGS) {
					stack.addEnchantment(PROTECTION, 3);
					stack.addEnchantment(FIRE_PROTECTION, 1);
					stack.addEnchantment(BLAST_PROTECTION, 1);
					stack.addEnchantment(PROJECTILE_PROTECTION, 1);
				}
				if(stack.getItem() == ULTIMATE_BOOTS) {
					stack.addEnchantment(PROTECTION, 3);
					stack.addEnchantment(FIRE_PROTECTION, 1);
					stack.addEnchantment(BLAST_PROTECTION, 1);
					stack.addEnchantment(PROJECTILE_PROTECTION, 1);
					stack.addEnchantment(FEATHER_FALLING, 4);
					stack.addEnchantment(DEPTH_STRIDER, 3);
				}
				//endregion
				//region lapis armor
				if(stack.getItem() == LAPIS_HELMET) {
					stack.addEnchantment(PROTECTION, 1);
					stack.addEnchantment(RESPIRATION, 1);
					stack.addEnchantment(AQUA_AFFINITY, 1);
				}
				if(stack.getItem() == LAPIS_CHESTPLATE || stack.getItem() == LAPIS_LEGGINGS) {
					stack.addEnchantment(PROTECTION, 1);
				}
				if(stack.getItem() == LAPIS_BOOTS) {
					stack.addEnchantment(PROTECTION, 1);
					stack.addEnchantment(FEATHER_FALLING, 1);
					stack.addEnchantment(DEPTH_STRIDER, 1);
				}
				//endregion
				//region lava armor
				if(stack.getItem() == LAVA_HELMET || stack.getItem() == LAVA_CHESTPLATE || stack.getItem() == LAVA_LEGGINGS || stack.getItem() == LAVA_BOOTS) {
					stack.addEnchantment(FIRE_PROTECTION, 4);
				}
				//endregion

			}
		}
	}

}
