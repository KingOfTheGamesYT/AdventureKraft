package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.configs.DZConfig;
import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class Hammy extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) DZConfig.HAMMY_DURABILITY.get();
        }

        public float getEfficiency() {
            return (Integer) DZConfig.HAMMY_EFFICIENCY.get();
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) DZConfig.HAMMY_HARVEST_LEVEL.get();
        }

        public int getEnchantability() {
            return (Integer) DZConfig.HAMMY_ENCHANTABILITY.get();
        }

        public Ingredient getRepairMaterial() {
            return null;
        }
    };

    public Hammy() {
        super(iItemTier, (Integer)DZConfig.HAMMY_DAMAGE.get(), (Integer) DZConfig.HAMMY_ATTACK_SPEED.get(), (new Properties()).group(DangerZone.WIP));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker, World world, PlayerEntity player) {
        stack.damageItem((Integer)DZConfig.HAMMY_HIT_COST.get(), attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        World world = entity.world;
        if (!world.isRemote && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            createExplosion(world, player);
        }
        return super.onEntitySwing(stack, entity);
    }
    private void createExplosion(World world, LivingEntity entity) {
        double x = entity.getPosX();
        double y = entity.getPosY();
        double z = entity.getPosZ();
        float explosionStrength = 2.0f; // Adjust this value to change the explosion power.

        world.createExplosion(null, x, y, z, explosionStrength, true, net.minecraft.world.Explosion.Mode.DESTROY);
        setBlocksOnFire(world, x, y, z, 3); // Set blocks on fire within a radius of 3 blocks.
    }

    private void setBlocksOnFire(World world, double x, double y, double z, int radius) {
        for (int i = (int) x - radius; i <= x + radius; i++) {
            for (int j = (int) y - radius; j <= y + radius; j++) {
                for (int k = (int) z - radius; k <= z + radius; k++) {
                    if (world.getBlockState(new BlockPos(i, j, k)).isAir()) {
                        world.setBlockState(new BlockPos(i, j, k), Blocks.FIRE.getDefaultState());
                    }
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A76" + "Ever hear the phrase A hammer can solve any problem? Well now you know why. And this hammer is big enough to solve almost any problem you run into." + "\u00A76"));
    }
}
