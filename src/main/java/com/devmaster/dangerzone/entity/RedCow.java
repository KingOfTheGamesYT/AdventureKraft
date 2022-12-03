package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class RedCow extends CowEntity {
    public RedCow(final EntityType<? extends RedCow> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 45;

    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.ARMOR, 1)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 150)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));

    }

    public RedCow createChild(ServerWorld world, AgeableEntity mate) {
        return RegistryHandler.RED_COW.get().create(world);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == RegistryHandler.CRYSTAL_APPLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
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

    }
