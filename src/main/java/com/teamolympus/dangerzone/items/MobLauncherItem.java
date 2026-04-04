package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.teamolympus.dangerzone.items.base.BaseAKItem;

public class MobLauncherItem extends BaseAKItem {

    public MobLauncherItem(String name) {
        super(name);
        this.setTextureName(DangerZone.TOOL_MISC_PREFIX + name);
        this.setMaxDamage(1);
        this.setCreativeTab(CreativeTabs.tabRedstone);

    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        if (entity instanceof EntityLiving) {

            // for (int i = 0; i < 6; i++) {

            // }

            // TODO: ADD PARTICLES
            EntityLiving entityLiving = (EntityLiving) entity;
            // entityLiving.motionY = 1;
            entityLiving.addVelocity(0.0D, 4.5D, 0.0D);

            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

        }

        return false;
    }

    private void spawnParticle(EntityPlayer player, String particleName, double x, double y, double z, double velocityX,
        double velocityY, double velocityZ) {
        player.worldObj.spawnParticle(particleName, x, y, z, velocityX, velocityY, velocityZ);
    }
}
