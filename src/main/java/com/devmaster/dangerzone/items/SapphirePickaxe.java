package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class SapphirePickaxe extends PickaxeItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.SAPPHIRE_PICKAXE_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.SAPPHIRE_PICKAXE_EFFICIENCY.get();

        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.SAPPHIRE_PICKAXE_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.SAPPHIRE_PICKAXE_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(RegistryHandler.SAPPHIRE.get());
        }
    };

    public SapphirePickaxe() {
        super(iItemTier, (Integer)DZConfig.SAPPHIRE_PICKAXE_DAMAGE.get(), (Integer) DZConfig.SAPPHIRE_PICKAXE_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.TOOLS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)DZConfig.SAPPHIRE_PICKAXE_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A79" + "The pickaxe from Madagascar" + "\u00A79"));
    }
}
