package com.teamolympus.dangerzone.entity.ai.base;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public abstract class DZAIWanderFrequentBase extends EntityAIBase {

    private final EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private final double speed;
    private final int xzSearch;
    private final int randFactor;

    public DZAIWanderFrequentBase(EntityCreature mob, double speed, int xzSearch, int randFactor)
    {
        this.entity = mob;
        this.speed = speed;
        this.xzSearch = xzSearch;
        this.randFactor = randFactor;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.getRNG().nextInt(randFactor) != 0)
        {
            return false;
        }
        else
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, xzSearch, 7);

            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.xPosition = vec3.xCoord;
                this.yPosition = vec3.yCoord;
                this.zPosition = vec3.zCoord;
                return true;
            }
        }
    }


    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting()
    {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

}
