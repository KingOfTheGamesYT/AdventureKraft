package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SmallRockEntity extends RockEntity{
    public SmallRockEntity(World world) {
        super(world);
    }

    @Override
    public void hitEntityHook(MovingObjectPosition movingObjectPosition)
    {
        EntityLiving entityLiving = (EntityLiving) movingObjectPosition.entityHit;
        entityLiving.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2);
    }

    public SmallRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase, RegistryHandler.smallRock);
    }


    public SmallRockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        super.onImpact(movingObjectPosition);

    }
}
