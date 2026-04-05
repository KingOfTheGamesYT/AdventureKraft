package com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityTameable;

public class BodyguardAILightExplosives extends EntityAITarget {
    EntityTameable theDefendingTameable;
    EntityLivingBase theOwnerAttacker;

    public BodyguardAILightExplosives(EntityTameable p_i1667_1_)
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


        super.startExecuting();
    }
}
