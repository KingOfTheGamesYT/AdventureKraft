package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class EmeraldLeggings extends ArmorItem {
    private static IArmorMaterial iArmorMaterial = new IArmorMaterial() {

        public int getDurability(EquipmentSlotType slotIn) {
            return (Integer) DZConfig.EMERALD_LEGGINGS_DURABILITY.get();
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return (Integer) DZConfig.EMERALD_LEGGINGS_ARMOR.get();
        }

        @Override
        public int getEnchantability() {
            return (Integer) DZConfig.EMERALD_LEGGINGS_ENCHANTABILITY.get();
        }

        @Override
        public SoundEvent getSoundEvent() {
            return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.EMERALD);

        }

        @Override
        public String getName() {
            return DangerZone.MOD_ID + ":emerald";
        }

        @Override
        public float getToughness() {
            return (Integer) DZConfig.EMERALD_LEGGINGS_TOUGHNESS.get();
        }

        @Override
        public float getKnockbackResistance() {
            return (Integer) DZConfig.EMERALD_LEGGINGS_KNOCK_BACK_RESISTANCE.get();
        }

    };

    public EmeraldLeggings() {
        super(iArmorMaterial, (EquipmentSlotType.LEGS), (new Properties()).group(DangerZone.ARMOR));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean HitByEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.EMERALD_LEGGINGS_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof MobEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A72" + "Show those greedy villagers how to walk" + "\u00A72"));
    }
}
