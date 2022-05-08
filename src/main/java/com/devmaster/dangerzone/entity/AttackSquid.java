package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.entity.goals.IntervalRangedAttackGoal;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.brain.task.SwimTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;


public class AttackSquid extends CreatureEntity implements IRangedAttackMob {
    private static final int MAX_BEND_TIME = 66;
    private static final DataParameter<Byte> STATE = EntityDataManager.createKey(AttackSquid.class, DataSerializers.BYTE);
    private static final byte STILL = (byte)0;
    private static final byte BENDING_CLIENT = 9;
    private static final byte BENDING = (byte)2;

    public AttackSquid(final EntityType<? extends AttackSquid> type, final World worldIn) {
        super(type, worldIn);
        experienceValue = 15;
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }
    public void travel(Vector3d travelVector) {
        if (this.isServerWorld() && this.isInWater()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.9D));
            if (this.getAttackTarget() == null) {
                this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }

    }
    
    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 15)
                .createMutableAttribute(Attributes.ARMOR, 2.5)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 10)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 8)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
    }

    @Override
    public void registerData() {
        super.registerData();
        this.getDataManager().register(STATE, Byte.valueOf(STILL));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this,0.35,1));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this,0.35,1));
        this.goalSelector.addGoal(2, new AttackSquid.WaterBending(this, MAX_BEND_TIME, 3, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, StampyLongNose.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, NotBreeBree.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, RedRoseWarrior.class, true));
    }

    public void setAttackSquidState(final byte state) { this.getDataManager().set(STATE, Byte.valueOf(state)); }
    public boolean isNoneState() { return getAttackSquidState() == STILL; }
    public byte getAttackSquidState() { return this.getDataManager().get(STATE).byteValue(); }
    public void setBendingAttack(final boolean smash) { setAttackSquidState(smash ? BENDING : STILL); }


    class WaterBending extends IntervalRangedAttackGoal {

        protected WaterBending(final IRangedAttackMob entityIn, final int duration, final int count, final int maxCooldownIn) {
            super(entityIn, duration, count, maxCooldownIn);
        }
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && AttackSquid.this.isNoneState();
        }

        @Override
        public void startExecuting() {
            super.startExecuting();
            AttackSquid.this.setBendingAttack(true);
            AttackSquid.this.getEntityWorld().setEntityState(AttackSquid.this, BENDING_CLIENT);
            AttackSquid.this.playSound(SoundEvents.BLOCK_WATER_AMBIENT, 1.0F, 1.2F);
        }

        @Override
        public void resetTask() {
            super.resetTask();
            AttackSquid.this.setBendingAttack(false);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
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

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if(!world.isRemote()) {
            WaterProjectile waterbending = WaterProjectile.create(world, this);
            world.addEntity(waterbending);
        }
        this.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.2F, 1.0F);

    }
}
