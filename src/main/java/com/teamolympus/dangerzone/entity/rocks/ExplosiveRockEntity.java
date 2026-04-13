package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ExplosiveRockEntity extends RockEntity{
    public ExplosiveRockEntity(World world) {
        super(world);
    }

    public ExplosiveRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public ExplosiveRockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.entityHit instanceof EntityLiving)
        {
            EntityLiving entityLiving = (EntityLiving) movingObjectPosition.entityHit;
            this.worldObj.createExplosion(getThrower(), this.posX, this.posY, this.posZ, 1.0f, true);
        }

        if (!this.worldObj.isRemote)
        {
            this.dropBlockAsItem(this.worldObj, (int) this.posX,(int) this.posY,(int) this.posZ, new ItemStack(RegistryHandler.explosiveRock));
        }

        this.setDead();
    }
}
