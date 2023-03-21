package com.devmaster.dangerzone.init;


import com.devmaster.dangerzone.DangerZone;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import javax.annotation.Nullable;

import static com.devmaster.dangerzone.init.Items.*;

public class MaterialStats {


	public enum ToolTier implements IItemTier {
		COARSE_AMETHYST_TIER(11f, 11f, 2000, 4, 19, COARSE_AMETHYST),
		RUBY_TIER(16f, 11f, 1500, 5, 21, RUBY),
		ULTIMATE_TIER(36f, 18f, 3000, 10, 30, null),
		PINK_TOURMALINE_TIER(7f, 10f, 1100, 4, 17, PINK_TOURMALINE),
		TIGER_EYE_TIER(8f, 12f, 1600, 4, 22, TIGER_EYE),
		LAPIS_TIER(2f, 6f, 250, 2, 14, Items.LAPIS_LAZULI),

		MANTIS_CLAW_TIER(6f, 0f, 2000, 3, 1, null),
		SCORPION_TAIL_TIER(6f, 0f, 2000, 3, 1, null),
		ZANGETSU_TIER(496, 15f, 9000, 3, 1, null);




		private float attackDamage, efficiency;
		private int durability, harvestLevel, enchantability;
		private Item repairItem;

		ToolTier(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, @Nullable Item repairItem) {
			this.attackDamage = attackDamage;
			this.efficiency = efficiency;
			this.durability = durability;
			this.harvestLevel = harvestLevel;
			this.enchantability = enchantability;
			this.repairItem = repairItem;
		}


		@Override
		public int getMaxUses() {
			return durability;
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
			return Ingredient.fromItems(repairItem);
		}
	}

	public enum ArmorMaterials implements IArmorMaterial {
		//Chestplate durability = 16 * durability
		COARSE_AMETHYST_ARMOR("coarse_amethyst", 44, new int[]{4, 7, 8, 4}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f, COARSE_AMETHYST),
		RUBY_ARMOR("ruby", 57, new int[]{6, 8, 9, 6}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, RUBY),
		LAPIS_ARMOR("lapis", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f, Items.LAPIS_LAZULI),
		LAVA_ARMOR("lava", 57, new int[]{6,8,9,6}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, LAVA_CRYSTAL),
		ULTIMATE_ARMOR("ultimate", 75, new int[]{7, 9, 10, 7}, 100, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0f, TITANIUM_INGOT),
		PINK_TOURMALINE_ARMOR("pink_tourmaline", 33, new int[]{2,5,7,3}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, PINK_TOURMALINE),
		TIGER_EYE_ARMOR("tiger_eye", 44, new int[]{4,7,8,4}, 55, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5f, TIGER_EYE);


		private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
		private String name;
		private SoundEvent equipSound;
		private int durability, enchantability;
		private Item repairItem;
		private int[] damageRedutionAmount; //{boots, leggings, chestplate, helmet}
		private float toughness;

		ArmorMaterials(String name, int durability, int[] damageReductionAmount, int enchantability, SoundEvent equipSound, float toughness, Item repairItem) {
			this.name = name;
			this.durability = durability;
			this.damageRedutionAmount = damageReductionAmount;
			this.enchantability = enchantability;
			this.repairItem = repairItem;
			this.equipSound = equipSound;
			this.toughness = toughness;
		}


		@Override
		public int getDurability(EquipmentSlotType equipmentSlotType) {
			return max_damage_array[equipmentSlotType.getIndex()] * durability;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
			return damageRedutionAmount[equipmentSlotType.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return equipSound;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(repairItem);
		}

		@Override
		public String getName() {
			return DangerZone.MODID + ":" + name;
		}

		@Override
		public float getToughness() {
			return toughness;
		}
	}
}
