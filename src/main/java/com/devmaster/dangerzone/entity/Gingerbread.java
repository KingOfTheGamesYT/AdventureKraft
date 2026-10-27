package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Gingerbread extends CreatureEntity {

    public Gingerbread(final EntityType<? extends Gingerbread> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 25;
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 35)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 24)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 10)
                .createMutableAttribute(Attributes.ARMOR, 8);
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
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, BaseYoutuber.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHit) {
        super.dropSpecialItems(source, looting, recentlyHit);
        ITag<Item> sweetsTag = DangerZone.SWEETS;

        if (sweetsTag == null || sweetsTag.getAllElements().isEmpty()) {
            return;
        }

        List<Item> sweets = new java.util.ArrayList<>(sweetsTag.getAllElements());

        int dropCount = 1;

        if (looting > 0) {
            dropCount += this.rand.nextInt(looting + 1);
        }

        for (int i = 0; i < dropCount; i++) {
            Item randomDonut = sweets.get(this.rand.nextInt(sweets.size()));
            this.entityDropItem(new ItemStack(randomDonut, 1));
        }
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_SAND_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_SAND_BREAK;
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

