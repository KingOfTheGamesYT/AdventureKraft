package com.devmaster.dangerzone.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class EasterBunny extends RabbitEntity {

    public EasterBunny(final EntityType<? extends EasterBunny> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 2;
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D)
                .createMutableAttribute(Attributes.ARMOR, 3.5F);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 7.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3,new RandomWalkingGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));

    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_RABBIT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_RABBIT_DEATH;
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


    public int eggTime = this.rand.nextInt(450) + 450;

    @Override
    public void livingTick() {
        super.livingTick();

        if (!this.world.isRemote && isAlive() && --this.eggTime <= 0) {
            playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            entityDropItem(randomEgg());
            this.eggTime = this.rand.nextInt(450) + 450;
        }
        }

    public ItemStack randomEgg() {
        List<Item> itemList = new ArrayList<>(ForgeRegistries.ITEMS.getValues());
        itemList.removeIf(item -> !((ResourceLocation) Objects.<ResourceLocation>requireNonNull(item.getRegistryName())).getPath().contains("_spawn_egg"));
        Item randomItem = itemList.get(this.rand.nextInt(itemList.size()));
        return randomItem.getDefaultInstance();
    }

}


