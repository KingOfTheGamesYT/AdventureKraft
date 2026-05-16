package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ExplosiveRockEntity extends ThrownRockEntity {
    public ExplosiveRockEntity(World world) {
        super(world);
    }

    @Override
    public void hitEntityHook(MovingObjectPosition movingObjectPosition) {
        this.worldObj.newExplosion(getThrower(), this.posX, this.posY, this.posZ, 1.0f, true,true);
    }

    public ExplosiveRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase, RegistryHandler.explosiveRock);
    }

}
