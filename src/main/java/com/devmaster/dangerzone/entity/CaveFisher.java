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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Stream;

public class CaveFisher extends CreatureEntity {

    public CaveFisher(final EntityType<? extends CaveFisher> entity, final World worldIn) {
        super(entity, worldIn);
        this.experienceValue = 19;
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10)
                .createMutableAttribute(Attributes.ARMOR, 1)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35F)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, BaseYoutuber.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, RedRoseWarrior.class, true));
    }

    public static boolean canSpawn(EntityType<CaveFisher> type, IWorld world, SpawnReason reason, BlockPos pos, Random random) {

        if (pos.getY() > 60) return false;

        if (world.canSeeSky(pos)) return false;

        if (world.getLightFor(LightType.BLOCK, pos) > 7) return false;

        if (!world.getBlockState(pos.down()).isOpaqueCube(world, pos.down())) return false;

        if (!world.getBlockState(pos).isAir(world, pos)) return false;

        return true;
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
    protected boolean isDespawnPeaceful() {
        return true;
    }
}