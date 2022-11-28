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


public class TitaniumCakeSword extends SwordItem {

    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.TITANIUM_CAKE_SWORD_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.TITANIUM_CAKE_SWORD_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.TITANIUM_CAKE_SWORD_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.TITANIUM_CAKE_SWORD_ENCHANTABILITY.get();

        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(RegistryHandler.TITANIUM_CAKE.get());
        }
    };

    public TitaniumCakeSword() {
        super(iItemTier, (Integer) DZConfig.TITANIUM_CAKE_SWORD_DAMAGE.get(), (Integer) DZConfig.TITANIUM_CAKE_SWORD_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.WEAPONS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.TITANIUM_CAKE_SWORD_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A7b" + "Thank you for 3k downloads" + "\u00A7b"));
        int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT,1);
        }
    }

}

