package com.devmaster.dangerzone.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.Random;


public class Allosaurus extends CreatureEntity {
    private static final DataParameter<Integer> ALLOSAURUS_VARIANT;

    public Allosaurus(final EntityType<? extends Allosaurus> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 199;

    }

    static {
        ALLOSAURUS_VARIANT = EntityDataManager.createKey(Allosaurus.class, DataSerializers.VARINT);
    }

    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

    @Override
    public void livingTick() {
        super.livingTick();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        this.bossInfo.setVisible(true);
    }

    static class AllosaurusData extends AgeableEntity.AgeableData {
        public final int variant;

        private AllosaurusData(int x) {
            super(false);
            this.variant = x;
        }
    }

    public int getAllosaurusVariant() {
        return MathHelper.clamp((Integer)this.dataManager.get(ALLOSAURUS_VARIANT), 0, 4);
    }

    public void setAllosaurusVariant(int variant) {
        this.dataManager.set(ALLOSAURUS_VARIANT, variant);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(ALLOSAURUS_VARIANT, 0);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setAllosaurusVariant(compound.getInt("Variant"));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 200)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.31D)
                .createMutableAttribute(Attributes.ARMOR, 2.5)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 180)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 30);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, StampyLongNose.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, NotBreeBree.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, RedRoseWarrior.class, true));
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance diff, SpawnReason spawn, @Nullable ILivingEntityData spawndata, @Nullable CompoundNBT comnbt) {
        int x;
        if (spawndata instanceof Allosaurus.AllosaurusData) {
            x = ((Allosaurus.AllosaurusData)spawndata).variant;
        } else {
            x = this.rand.nextInt(4);
            spawndata = new Allosaurus.AllosaurusData(x);
        }

        this.setAllosaurusVariant(x);
        return super.onInitialSpawn(world, diff, spawn, (ILivingEntityData)spawndata, comnbt);
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

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }
    
    @Override
    protected boolean isDespawnPeaceful() {
        return true;
    }

    public void writeAdditional(CompoundNBT comnbt) {
        super.writeAdditional(comnbt);
        comnbt.putInt("Variant", this.getAllosaurusVariant());
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
