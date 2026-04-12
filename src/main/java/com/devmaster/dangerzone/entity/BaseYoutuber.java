package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;

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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BaseYoutuber extends CreatureEntity {

    private static final DataParameter<Integer> TECHNOBLADE_VARIANT = EntityDataManager.createKey(BaseYoutuber.class, DataSerializers.VARINT);

    public BaseYoutuber(EntityType<? extends BaseYoutuber> type, World world) {
        super(type, world);
        this.experienceValue = 250;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(TECHNOBLADE_VARIANT, 0);
    }

    //Choose the Youtuber
    private boolean isAntVenom() {
        return this.getType() == RegistryHandler.ANTVENOM.get();
    }

    private boolean isTewtiy() {
        return this.getType() == RegistryHandler.TEWTIY.get();
    }

    private boolean isAlexiCraft() {
        return this.getType() == RegistryHandler.ALEXICRAFT.get();
    }

    private boolean isTechnoblade() {
        return this.getType() == RegistryHandler.TECHNOBLADE.get();
    }

    private boolean isAphmau() {
        return this.getType() == RegistryHandler.APHMAU.get();
    }

    private boolean isBabyAngel() {
        return this.getType() == RegistryHandler.BABYANGEL.get();
    }

    private boolean isBabyDuck() {
        return this.getType() == RegistryHandler.BABYDUCK.get();
    }

    private boolean isBabyLeah() {
        return this.getType() == RegistryHandler.BABYLEAH.get();
    }

    private boolean isBabyMax() {
        return this.getType() == RegistryHandler.BABYMAX.get();
    }

    private boolean isBajanCanadian() {
        return this.getType() == RegistryHandler.BAJANCANADIAN.get();
    }

    private boolean isCaptainSparklez() {
        return this.getType() == RegistryHandler.CAPTAINSPARKELZ.get();
    }

    private boolean isNotBreeBree() {
        return this.getType() == RegistryHandler.NOTBREEBREE.get();
    }

    private boolean isStampyLongNose() {
        return this.getType() == RegistryHandler.STAMPYLONGNOSE.get();
    }

    private boolean isRoboTechnoblade() {
        return this.getType() == RegistryHandler.ROBO_TECHNOBLADE.get();
    }

    public int getTechnobladeVariant() {
        return MathHelper.clamp(this.dataManager.get(TECHNOBLADE_VARIANT), 0, 14);
    }

    public void setTechnobladeVariant(int variant) {
        this.dataManager.set(TECHNOBLADE_VARIANT, variant);
    }

    private void applyName() {
        if (!this.hasCustomName()) {
            if (isAntVenom()) {
                this.setCustomName(new StringTextComponent("AntVenom"));
            }
            else if (isTewtiy()) {
                this.setCustomName(new StringTextComponent("Tewtiy"));
            }
            else if (isAlexiCraft()) {
                this.setCustomName(new StringTextComponent("AlexiCraft"));
            }
            else if (isTechnoblade()) {
                this.setCustomName(new StringTextComponent("Technoblade"));
            }
            else if (isNotBreeBree()) {
                this.setCustomName(new StringTextComponent("NotBreeBree"));
            }
            else if (isBabyAngel()) {
                this.setCustomName(new StringTextComponent("BabyAngel"));
            }
            else if (isBabyDuck()) {
                this.setCustomName(new StringTextComponent("BabyDuck"));
            }
            else if (isBabyLeah()) {
                this.setCustomName(new StringTextComponent("BabyLeah"));
            }
            else if (isBabyMax()) {
                this.setCustomName(new StringTextComponent("BabyMax"));
            }
            else if (isBajanCanadian()) {
                this.setCustomName(new StringTextComponent("BajanCanadian"));
            }
            else if (isAphmau()) {
                this.setCustomName(new StringTextComponent("Aphmau"));
            }
            else if (isStampyLongNose()) {
                this.setCustomName(new StringTextComponent("StampyLongNose"));
            }
            else if (isCaptainSparklez()) {
                this.setCustomName(new StringTextComponent("CaptainSparklez"));
            }
            else if (isRoboTechnoblade()) {
                this.setCustomName(new StringTextComponent("Technoblade"));
            }
        }
    }

    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D)
                .createMutableAttribute(Attributes.ARMOR, 3.5F);
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance diff, SpawnReason spawn, @Nullable ILivingEntityData spawndata, @Nullable CompoundNBT comnbt) {

        if (isTechnoblade()) {
            int variant = this.rand.nextInt(15);
            setTechnobladeVariant(variant);
        }

        applyName();

        return super.onInitialSpawn(world, diff, spawn, spawndata, comnbt);
    }

    //Save the varient on re-load
    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);

        if (isTechnoblade()) {
            nbt.putInt("TechVariant", this.getTechnobladeVariant());
        }
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);

        if (isTechnoblade() && nbt.contains("TechVariant")) {
            this.setTechnobladeVariant(nbt.getInt("TechVariant"));
        }
        applyName();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 7.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseYoutuber.class, true));
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

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    public boolean canAttack(LivingEntity entity) {
        if (entity instanceof BaseYoutuber) {
            return entity.getType() != this.getType();
        }
        return super.canAttack(entity);
    }
}