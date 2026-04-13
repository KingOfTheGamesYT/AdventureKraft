package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RedRockEntity extends RockEntity{
    public RedRockEntity(World world) {
        super(world);
    }


    public RedRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }


    public RedRockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.entityHit instanceof EntityLiving)
        {
            EntityLiving entityLiving = (EntityLiving) movingObjectPosition.entityHit;
            entityLiving.setFire(20);
        }

        if (!this.worldObj.isRemote)
        {
            this.dropBlockAsItem(this.worldObj, (int) this.posX,(int) this.posY,(int) this.posZ, new ItemStack(RegistryHandler.redRock));
        }
        this.setDead();

    }
}
