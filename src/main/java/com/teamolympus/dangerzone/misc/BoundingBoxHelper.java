package com.teamolympus.dangerzone.misc;

import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class BoundingBoxHelper {

    @SuppressWarnings("unchecked")
    public static Entity findEntityInBoundingBox(Entity mobEntity, double expandX, double expandY, double expandZ) {
        List<Entity> list = mobEntity.worldObj.getEntitiesWithinAABBExcludingEntity(mobEntity, mobEntity.boundingBox.expand(expandX, expandY, expandZ));

        for (Entity entity : list) {
            if (entity instanceof IAdventureKraftAttackableMobs) {
                IAdventureKraftAttackableMobs attackableMob = ((IAdventureKraftAttackableMobs) entity);

                if (attackableMob.entityAttackInstance() != null) {
                    return attackableMob.entityAttackInstance();
                }

            }

            if (entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode) {
                return entity;
            }


        }
        return null;
    }
}
