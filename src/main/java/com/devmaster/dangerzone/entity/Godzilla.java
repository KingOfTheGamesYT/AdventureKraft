package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;


public class Godzilla extends MonsterEntity implements IRangedAttackMob{
    public boolean collided = false;
    public boolean crush = false;
    private int jumped = 0;
    private int attackTimer = 0;


    public Godzilla(final EntityType<? extends Godzilla> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 3999;
        this.isImmuneToFire();

    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.collideWithNearbyEntities();
        if (!this.onGround) {
            return;
        }
        AxisAlignedBB axisalignedbb = this.getBoundingBox().expand(0.2D, -0.5, 0.2D);

        for (BlockPos blockpos : BlockPos.getAllInBoxMutable(MathHelper.floor(axisalignedbb.minX), MathHelper.floor(axisalignedbb.minY), MathHelper.floor(axisalignedbb.minZ), MathHelper.floor(axisalignedbb.maxX), MathHelper.floor(axisalignedbb.maxY), MathHelper.floor(axisalignedbb.maxZ))) {
            BlockState state = this.world.getBlockState(new BlockPos(blockpos));
            boolean drops = true;

            if (world.getBlockState(blockpos).isIn(DangerZone.GODZILLA_DESTROYABLE)) {
                // Break the block and drop the items
                state.getBlock().canDropFromExplosion(state, world, new BlockPos(blockpos), null);
                this.world.destroyBlock(blockpos, drops, this);
            }

            if (!this.world.isRemote) {
                if (this.jumped <= 0 && this.getAttackTarget() != null && this.getDistanceSq(this.getAttackTarget()) < 25.0) {
                    this.setJumping(true);
                    double jumpDistance = 2.0;
                    double jumpHeight = 1.0;
                    double horizontalSpeed = Math.sqrt(jumpDistance * jumpDistance / (2 * jumpHeight * 9.81));
                    Vector3d motion = this.getMotion().normalize().scale(horizontalSpeed).add(0, jumpHeight, 0);
                    this.setMotion(motion);
                    this.jumped = 40 + this.rand.nextInt(20);
                } else {
                    this.setJumping(false);
                }

                this.jumped--;
            }
        }
}


    public void onCollideWithPlayer(PlayerEntity entityIn) {
            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), this.func_225512_er_());
    }

    protected float func_225512_er_() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 5000)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.31D)
                .createMutableAttribute(Attributes.ARMOR, 7.5)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 100)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 120);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5,new RandomWalkingGoal(this, 1.0));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 50F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, StampyLongNose.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, NotBreeBree.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, RedRoseWarrior.class, true));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 20, 3.0F));

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

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distance) {
        World world = this.getEntityWorld();
        Vector3d targetPosition = this.getAttackTarget().getEyePosition(1.0f);
        Vector3d shootingPosition = this.getEyePosition(1.0f);
        Vector3d shootingDirection = targetPosition.subtract(shootingPosition).normalize().mul(1.5, 1.5, 1.5);
        BetterFireball betterFireball = new BetterFireball(world, this);
        EntityType<LightningBoltEntity> lightningBolt = (EntityType.LIGHTNING_BOLT);
        if (!this.world.isRemote) {
            if (world.getRandom().nextFloat() < 0.5f) { // 50% chance to summon lightning
                lightningBolt.getBoundingBoxWithSizeApplied(targetPosition.x, targetPosition.y, targetPosition.z);
                world.addEntity(new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world));
            }
            if (world.getRandom().nextFloat() < 0.5f) { // 50% chance to do fireball attack
                betterFireball.setPosition(shootingPosition.x, shootingPosition.y, shootingPosition.z);
                betterFireball.setVelocity(shootingDirection.x, shootingDirection.y, shootingDirection.z);
                world.addEntity(betterFireball);
            }
        }
    }
}
