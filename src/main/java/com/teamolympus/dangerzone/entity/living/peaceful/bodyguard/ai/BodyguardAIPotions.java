package com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.util.MathHelper;

public class BodyguardAIPotions extends EntityAITarget {
    EntityTameable theDefendingTameable;
    EntityLivingBase theOwnerAttacker;

    public BodyguardAIPotions(EntityTameable p_i1667_1_)
    {
        super(p_i1667_1_, false);
        this.theDefendingTameable = p_i1667_1_;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute()
    {
        if (!this.theDefendingTameable.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.theDefendingTameable.getOwner();

            if (entitylivingbase == null)
            {
                return false;
            }
            else
            {
                return entitylivingbase.getHealth() <= 4 || this.theDefendingTameable.getHealth() <= 4;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        EntityLivingBase owner = this.theDefendingTameable.getOwner();
        EntityTameable bodyguard = this.theDefendingTameable;

        if (owner.getHealth() <= 4 && bodyguard.getDistanceSqToEntity(owner) <= 16)
        {
            EntityPotion entitypotion = new EntityPotion(bodyguard.worldObj, bodyguard, 32732);
            entitypotion.rotationPitch -= -20.0F;
            double d0 = owner.posX + owner.motionX - bodyguard.posX;
            double d1 = owner.posY + (double)owner.getEyeHeight() - 1.100000023841858D - bodyguard.posY;
            double d2 = owner.posZ + owner.motionZ - bodyguard.posZ;
            float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

            entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2F), d2, 0.75F, 8.0F);
            owner.worldObj.spawnEntityInWorld(entitypotion);

        } else if (bodyguard.getHealth() <= 4)
        {
            EntityPotion entitypotion = new EntityPotion(bodyguard.worldObj, bodyguard, 32732);
            entitypotion.posX = bodyguard.posX;
            entitypotion.posY = bodyguard.posY;
            entitypotion.posZ = bodyguard.posZ;
         //   entitypotion.setThrowableHeading(d0, d1 + (double)(f1 * 0.2F), d2, 0.75F, 8.0F);
            owner.worldObj.spawnEntityInWorld(entitypotion);

        }


        super.startExecuting();
    }
}
