package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.entity.goals.IntervalRangedAttackGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;


public class RedRoseWarrior extends CreatureEntity implements IRangedAttackMob{
    private static final int MAX_BEND_TIME = 66;
    private static final DataParameter<Byte> STATE = EntityDataManager.createKey(RedRoseWarrior.class, DataSerializers.BYTE);
    private static final String KEY_STATE = "RRWState";
    private static final byte STILL = (byte)0;
    private static final byte BENDING = (byte)2;
    private static final byte BENDING_CLIENT = 9;

    public RedRoseWarrior(final EntityType<? extends RedRoseWarrior> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 10;
    }

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(getType().getName().copyRaw().appendSibling(getDisplayName()), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

    @Override
    public void livingTick() {
        super.livingTick();


        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        this.bossInfo.setVisible(true);

    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setRRWState(compound.getByte(KEY_STATE));
        if (hasCustomName())
            bossInfo.setName(getType().getName().copyRaw().appendSibling(getDisplayName()));
    }

    @Override
    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);

        bossInfo.setName(getType().getName().copyRaw().appendSibling(getDisplayName()));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 800)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 18)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 18);
    }

    @Override
    public void registerData() {
        super.registerData();
        this.getDataManager().register(STATE, Byte.valueOf(STILL));
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2, new RedRoseWarrior.WaterBending(this, MAX_BEND_TIME, 3, 6));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, StampyLongNose.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, NotBreeBree.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PhantomEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GhastEntity.class, true));
    }
    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte(KEY_STATE, this.getrrwstate());
    }

    public void setRRWState(final byte state) { this.getDataManager().set(STATE, Byte.valueOf(state)); }
    public byte getrrwstate() { return this.getDataManager().get(STATE).byteValue(); }
    public boolean isNoneState() { return getrrwstate() == STILL; }
    public boolean isBendingAttack() { return getrrwstate() == BENDING; }
    public void setBendingAttack(final boolean smash) { setRRWState(smash ? BENDING : STILL); }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        switch(id) {
            case BENDING_CLIENT:

                break;
            default:
                super.handleStatusUpdate(id);
                break;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
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
        return false;
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        if(!world.isRemote()) {
            WaterProjectile waterbending = WaterProjectile.create(world, this);
            world.addEntity(waterbending);
        }
        this.playSound(SoundEvents.ENTITY_BOAT_PADDLE_WATER, 1.2F, 1.0F);
    }

    class WaterBending extends IntervalRangedAttackGoal {

        protected WaterBending(final IRangedAttackMob entityIn, final int duration, final int count, final int maxCooldownIn) {
            super(entityIn, duration, count, maxCooldownIn);
        }

        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && RedRoseWarrior.this.isNoneState();
        }

        @Override
        public void startExecuting() {
            super.startExecuting();
            RedRoseWarrior.this.setBendingAttack(true);
            RedRoseWarrior.this.getEntityWorld().setEntityState(RedRoseWarrior.this, BENDING_CLIENT);
            RedRoseWarrior.this.playSound(SoundEvents.BLOCK_WATER_AMBIENT, 1.0F, 1.2F);
        }

        @Override
        public void resetTask() {
            super.resetTask();
            RedRoseWarrior.this.setBendingAttack(false);
        }
    }

    @Override
    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
    }
