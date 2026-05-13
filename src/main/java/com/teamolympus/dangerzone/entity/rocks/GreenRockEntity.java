package com.teamolympus.dangerzone.entity.rocks;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class GreenRockEntity extends RockEntity{
    public GreenRockEntity(World world) {
        super(world);
    }

    public GreenRockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase, RegistryHandler.greenRock);
    }

    @Override
    public void hitEntityHook(MovingObjectPosition movingObjectPosition)
    {
        EntityLiving entityLiving = (EntityLiving) movingObjectPosition.entityHit;
        entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
    }

}
