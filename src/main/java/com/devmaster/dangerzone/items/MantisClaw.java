package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;


public class MantisClaw extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.MANTIS_CLAW_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.MANTIS_CLAW_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.MANTIS_CLAW_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.MANTIS_CLAW_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return null;
        }
    };

    public MantisClaw() {
        super(iItemTier, (Integer)DZConfig.MANTIS_CLAW_DAMAGE.get(), -(Integer) DZConfig.MANTIS_CLAW_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.WEAPONS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.MANTIS_CLAW_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        if (target != null && attacker != null && !attacker.world.isRemote) {
            target.heal(-2.0F);
            attacker.heal(2.0F);

        }
        return true;
    }



    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "You killed a Mantis. This is your reward! Not only does it do a respectable amount of damage, but with every hit it sucks half a heart out of its victim... and gives it to you!" + "\u00A72"));
    }

}

