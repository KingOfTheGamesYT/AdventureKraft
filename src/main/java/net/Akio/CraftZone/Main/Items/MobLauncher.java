package net.Akio.CraftZone.Main.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MobLauncher extends Item {
    public MobLauncher(int i) {
        setCreativeTab(CreativeTabs.tabRedstone);
        setMaxDamage(1);

    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof Entity) {
            for(int var3 = 0; var3 < 6; ++var3) {
                float f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                float f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
                float f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("smoke", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0D, (double)(f2 / 4.0F), 0.0D);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("explode", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0D, (double)(f2 / 4.0F), 0.0D);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle("reddust", (double)((float)entity.posX + f1), (double)((float)entity.posY + f2), (double)((float)entity.posZ + f3), 0.0D, (double)(f2 / 4.0F), 0.0D);
            }

            player.worldObj.playSoundAtEntity(player, "fireworks.launch", 2.0F, 1.2F);
            EntityLiving e = (EntityLiving)entity;
            e.addVelocity(0.0D, 4.5D, 0.0D);
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }

            return true;
        } else {
            return false;
        }
    }
}
