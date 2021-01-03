package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Random;

public class StampyLongNose extends MonsterEntity {

    private Object SPAWN_ON_THE_GROUND;
    private SpawnReason reason;
    private BlockPos pos;
    private IPlacementPredicate x;

    public StampyLongNose(final EntityType<? extends StampyLongNose> type, final World worldIn) {
        super(type, worldIn);
    }

    public void init(FMLCommonSetupEvent event) {

        EntitySpawnPlacementRegistry.register(RegistryHandler.STAMPYLONGNOSE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MonsterEntity::canMonsterSpawn);
    }
    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D)
                .createMutableAttribute(Attributes.ARMOR, 3.5F);

    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, true));


    }

    public static <T extends MobEntity> boolean canStampyLongNoseSpawn(EntityType<StampyLongNose> entityType, IServerWorld iServerWorld, SpawnReason reason, BlockPos pos, Random random) {
        return reason == SpawnReason.SPAWNER || !iServerWorld.canSeeSky(pos) && pos.getY() <= 64 && canMonsterSpawnInLight(entityType, iServerWorld, reason, pos, random);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) { this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F); }


    @Override
    protected SoundEvent getAmbientSound() {
        return rand.nextFloat() < 0.18F ? SoundEvents.ENTITY_WITCH_HURT : SoundEvents.ENTITY_PARROT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return rand.nextFloat() < 0.09F ? SoundEvents.ENTITY_WITCH_HURT : SoundEvents.ENTITY_PARROT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
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
        return false;
    }

    @Override
    protected boolean isDespawnPeaceful() {
        return true;
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 250;
    }
}


