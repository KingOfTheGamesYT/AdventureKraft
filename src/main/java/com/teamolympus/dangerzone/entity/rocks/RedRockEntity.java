package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RedRockEntity extends ThrownRockEntity {
    public RedRockEntity(World world) {
        super(world);
    }

    @Override
    public void hitEntityHook(MovingObjectPosition movingObjectPosition) {
        EntityLiving entityLiving = (EntityLiving) movingObjectPosition.entityHit;
        entityLiving.setFire(20);
    }


    public RedRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase, RegistryHandler.redRock);
    }
}
