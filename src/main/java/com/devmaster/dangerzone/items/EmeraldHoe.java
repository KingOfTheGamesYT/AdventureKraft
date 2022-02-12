package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;


public class EmeraldHoe extends HoeItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.EMERALD_HOE_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.EMERALD_HOE_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.EMERALD_HOE_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.EMERALD_HOE_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.EMERALD.getItem());
        }
    };

    public EmeraldHoe() {
        super(iItemTier, (Integer)DZConfig.EMERALD_HOE_DAMAGE.get(), (Integer) DZConfig.EMERALD_HOE_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.TOOLS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.EMERALD_HOE_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "Show those greedy villagers how to farm" + "\u00A72"));
    }

}

