package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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


public class EmeraldPickaxe extends PickaxeItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.EMERALD_PICKAXE_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.EMERALD_PICKAXE_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.EMERALD_PICKAXE_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.EMERALD_PICKAXE_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.EMERALD.getItem());
        }
    };

    public EmeraldPickaxe() {
        super(iItemTier, (Integer)DZConfig.EMERALD_PICKAXE_DAMAGE.get(), (Integer) DZConfig.EMERALD_PICKAXE_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.TOOLS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.EMERALD_PICKAXE_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "Now you know why those greedy villagers love these green gems so much" + "\u00A72"));
    }

}

