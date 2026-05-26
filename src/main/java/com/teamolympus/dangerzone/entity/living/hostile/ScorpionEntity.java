package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.entity.ai.DZAIWanderFrequent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ScorpionEntity extends EntityMob {

    private final double EXPAND_Z = 8.0D;
    private final double EXPAND_Y = 3.0D;
    private final double EXPAND_X = EXPAND_Z;

    public ScorpionEntity(World worldIn) {
        super(worldIn);
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(5, new DZAIWanderFrequent(this, 1.0D, 14));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        setSize(0.85F, 0.55F);
        this.experienceValue = 10;
        this.fireResistance = 100;
        this.isImmuneToFire = false;
    }


    @Override
    protected void updateAITick() {
        super.updateAITick();

        EntityLivingBase attackEntity = this.getAttackTarget();

        if (attackEntity != null) {
            if (getDistanceSqToEntity(attackEntity) > 9.0D) {
                getNavigator().tryMoveToEntityLiving(attackEntity, 1.2D);
            }
        }

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .setBaseValue(4);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.2f);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.followRange)
                .setBaseValue(8.0D);
    }

    @Override
    protected boolean isAIEnabled() {
       return true;

    }

    @Override
    protected Item getDropItem() {
        int random = this.worldObj.rand.nextInt(10);
        switch (random) {
            case 0:
                return Items.gold_nugget;
            case 1:
                return Items.diamond;
            case 2:
                return Items.emerald;
            default:
                return null;
        }
    }


}
