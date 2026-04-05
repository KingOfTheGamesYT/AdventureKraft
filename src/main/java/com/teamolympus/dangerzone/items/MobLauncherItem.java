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

            double d0 = (double) ((float) entity.posX + 0.5F) + (double) (player.worldObj.rand.nextFloat() - 0.5F) * 0.2D;
            double d1 = (double) ((float) entity.posY + 0.7F) + (double) (player.worldObj.rand.nextFloat() - 0.5F) * 0.5D;
            double d2 = (double) ((float) entity.posZ + 0.5F) + (double) (player.worldObj.rand.nextFloat() - 0.5F) * 0.2D;
            double velY =0.699999988079071D;

            double d3 = 0.2199999988079071D;
            double d4 = 0.27000001072883606D;

             for (byte i = 0; i < 6; i++)
             {
                spawnParticle(player, "reddust", d0 - d4, d1 + d3, d2, 0.0D, velY, 0.0D);
                spawnParticle(player, "smoke", d0 - d4, d1 + d3, d2, 0.0D, velY, 0.0D);
                spawnParticle(player, "explode", d0 - d4, d1 + d3, d2, 0.0D, velY, 0.0D);
             }
            player.worldObj.playSoundAtEntity(player, "fireworks.launch", 2.0F, 1.5F);

            EntityLiving entityLiving = (EntityLiving) entity;

            entityLiving.motionY += 4.5D;
            entityLiving.isAirBorne = true;

            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

            return true;
        }

        return false;
    }

    private void spawnParticle(EntityPlayer player, String particleName, double x, double y, double z, double velocityX,
        double velocityY, double velocityZ)
    {
        player.worldObj.spawnParticle(particleName, x, y, z, velocityX, velocityY, velocityZ);
    }
}
