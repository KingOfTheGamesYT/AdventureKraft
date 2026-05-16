package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.misc.DropHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class ThrownRockEntity extends EntityThrowable {

    public ThrownRockEntity(World world) {
        super(world);
    }



    Item dropItem;
    public ThrownRockEntity(World world, EntityLivingBase entityLivingBase, Item item) {
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
            DropHelper.dropBlockAsItem(this.worldObj, (int) this.posX,(int) this.posY,(int) this.posZ, new ItemStack(dropItem));
        }

        this.setDead();
    }


    public ThrownRockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }

}
