package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class LapisBoots extends ArmorItem {
    private static IArmorMaterial iArmorMaterial = new IArmorMaterial() {

        public int getDurability(EquipmentSlotType slotIn) {
            return (Integer) DZConfig.LAPIS_BOOTS_DURABILITY.get();
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return (Integer) DZConfig.LAPIS_BOOTS_ARMOR.get();
        }

        @Override
        public int getEnchantability() {
            return (Integer) DZConfig.LAPIS_BOOTS_ENCHANTABILITY.get();
        }

        @Override
        public SoundEvent getSoundEvent() {
            return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.LAPIS_LAZULI);

        }

        @Override
        public String getName() {
            return DangerZone.MOD_ID + ":lapis";
        }

        @Override
        public float getToughness() {
            return (Integer) DZConfig.LAPIS_BOOTS_TOUGHNESS.get();
        }

        @Override
        public float getKnockbackResistance() {
            return (Integer) DZConfig.LAPIS_BOOTS_KNOCK_BACK_RESISTANCE.get();
        }

    };

    public LapisBoots() {
        super(iArmorMaterial, (EquipmentSlotType.FEET), (new Properties()).group(DangerZone.ARMOR));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean HitByEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.LAPIS_BOOTS_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof MobEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
            tooltip.add(new StringTextComponent("\u00A79" + "Great for dancing in." + "\u00A79"));
        }
    }
