package com.teamolympus.dangerzone.entity.rocks;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class RockEntity extends EntityThrowable {

    public RockEntity(World world) {
        super(world);
    }



    Item dropItem;
    public RockEntity(World world, EntityLivingBase entityLivingBase, Item item) {
        super(world, entityLivingBase);
        this.dropItem = item;
    }


    public abstract void hitEntityHook(MovingObjectPosition movingObjectPosition);

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition)
    {
        if (movingObjectPosition.entityHit instanceof EntityLiving)
        {
            hitEntityHook(movingObjectPosition);
        }

        if (!this.worldObj.isRemote)
        {
            this.dropBlockAsItem(this.worldObj, (int) this.posX,(int) this.posY,(int) this.posZ, new ItemStack(dropItem));
        }

        this.setDead();
    }


    public RockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }


    protected void dropBlockAsItem(World worldIn, int x, int y, int z, ItemStack itemIn) {




        if (!worldIn.isRemote && worldIn.getGameRules()
            .getGameRuleBooleanValue("doTileDrops") && !worldIn.restoringBlockSnapshots) {
            float f = 0.7F;
            double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(worldIn, (double) x + d0, (double) y + d1, (double) z + d2, itemIn);
            entityitem.delayBeforeCanPickup = 10;
            worldIn.spawnEntityInWorld(entityitem);
        }
    }

}
