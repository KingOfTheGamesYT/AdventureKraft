package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class QueenGhidorahScaleBattleAxe extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
          return (Integer) DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_DURABILITY.get();
        }

        public float getEfficiency() {
            return DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(RegistryHandler.TITANIUM_INGOT.get());
        }
    };

    public QueenGhidorahScaleBattleAxe() {
        super(iItemTier, DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_DAMAGE.get(), DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.WEAPONS));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem( DZConfig.QUEEN_GHIDORAH_SCALE_BATTLE_AXE_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A75" + "Who ever messes with you shall be erased for good" + "\u00A75"));
    }
}
