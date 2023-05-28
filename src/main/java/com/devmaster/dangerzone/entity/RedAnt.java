package com.devmaster.dangerzone.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;


public class RedAnt extends CreatureEntity {

    public RedAnt(final EntityType<? extends RedAnt> type, final World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.experienceValue = 1;
    }


    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
                .createMutableAttribute(Attributes.ARMOR, 0.5)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0.25)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 10);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2,new RandomWalkingGoal(this, 0.15D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

    }


    public void livingTick() {
        super.livingTick();
        this.dieInWater();
    }

    protected void dieInWater() {
        if (this.isAlive()) {
            if (this.isInWaterRainOrBubbleColumn()) {
                this.setAir(0);
                this.damageEntity(DamageSource.DROWN, Integer.MAX_VALUE);
            }
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    @Override
    protected float getSoundPitch() {
        return 0.7F + rand.nextFloat() * 0.2F;
    }


    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return true;
    }

    @Override
    protected boolean isDespawnPeaceful() {
        return true;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }


}
