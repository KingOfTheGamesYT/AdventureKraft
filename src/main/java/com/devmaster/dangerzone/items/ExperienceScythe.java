package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ExperienceScythe extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.EXPERIENCE_SCYTHE_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.EXPERIENCE_SCYTHE_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.EXPERIENCE_SCYTHE_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.EXPERIENCE_SCYTHE_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.AIR);

        }
    };

    public ExperienceScythe() {
        super(iItemTier, (Integer)DZConfig.EXPERIENCE_SCYTHE_DAMAGE.get(), (Integer) DZConfig.EXPERIENCE_SCYTHE_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.WIP));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker, World world, PlayerEntity player) {

        stack.damageItem((Integer)DZConfig.EXPERIENCE_SCYTHE_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
        }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A71" + "Wow those mobs had bottles of enchanting?" + "\u00A71"));
    }
}
