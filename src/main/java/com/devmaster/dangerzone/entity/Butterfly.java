package com.devmaster.dangerzone.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Butterfly extends CreatureEntity {
    private static final DataParameter<Byte> FLYING = EntityDataManager.createKey(Butterfly.class, DataSerializers.BYTE);
    private static final EntityPredicate field_213813_c = (new EntityPredicate()).setDistance(4.0D).allowFriendlyFire();
    private BlockPos spawnPosition;
    private static final DataParameter<Integer> BUTTERFLY_VARIANT;

    public Butterfly(final EntityType<? extends Butterfly> type, final World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.moveController = new FlyingMovementController(this, 20, true);

    }

    static {
        BUTTERFLY_VARIANT = EntityDataManager.createKey(Butterfly.class, DataSerializers.VARINT);
    }

    static class ButterflyData extends AgeableEntity.AgeableData {
        public final int variant;

        private ButterflyData(int x) {
            super(false);
            this.variant = x;
        }
    }

    public int getButterflyVariant() {
        return MathHelper.clamp((Integer)this.dataManager.get(BUTTERFLY_VARIANT), 0, 4);
    }

    public void setButterflyVariant(int variant) {
        this.dataManager.set(BUTTERFLY_VARIANT, variant);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(BUTTERFLY_VARIANT, 0);
        this.dataManager.register(FLYING, (byte)0);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setButterflyVariant(compound.getInt("Variant"));
        this.dataManager.set(FLYING, compound.getByte("ButterflyFlags"));

    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.10000000149011612D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.10000000149011612D)
                .createMutableAttribute(Attributes.ARMOR, 0.5);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));

    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance diff, SpawnReason spawn, @Nullable ILivingEntityData spawndata, @Nullable CompoundNBT comnbt) {
        int x;
        if (spawndata instanceof Butterfly.ButterflyData) {
            x = ((Butterfly.ButterflyData)spawndata).variant;
        } else {
            x = this.rand.nextInt(4);
            spawndata = new Butterfly.ButterflyData(x);
        }

        this.setButterflyVariant(x);
        return super.onInitialSpawn(world, diff, spawn, (ILivingEntityData)spawndata, comnbt);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
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

    protected boolean canTriggerWalking() {
        return false;
    }



    public boolean getIsButterflyHanging() {
        return (this.dataManager.get(FLYING) & 1) != 0;
    }

    public void setIsButterflyHanging(boolean isHanging) {
        byte b0 = this.dataManager.get(FLYING);
        if (isHanging) {
            this.dataManager.set(FLYING, (byte)(b0 | 1));
        } else {
            this.dataManager.set(FLYING, (byte)(b0 & -2));
        }

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        if (this.getIsButterflyHanging()) {
            this.setMotion(Vector3d.ZERO);
            this.setRawPosition(this.getPosX(), (double) MathHelper.floor(this.getPosY()) + 1.0D - (double)this.getHeight(), this.getPosZ());
        } else {
            this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
        }

    }

    protected void updateAITasks() {
        super.updateAITasks();
        BlockPos blockpos = this.getPosition();
        BlockPos blockpos1 = blockpos.up();
        if (this.getIsButterflyHanging()) {
            boolean flag = this.isSilent();
            if (this.world.getBlockState(blockpos1).isNormalCube(this.world, blockpos)) {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }

                if (this.world.getClosestPlayer(field_213813_c, this) != null) {
                    this.setIsButterflyHanging(false);
                    if (!flag) {
                        this.world.playEvent((PlayerEntity)null, 1025, blockpos, 0);
                    }
                }
            } else {
                this.setIsButterflyHanging(false);
                if (!flag) {
                    this.world.playEvent((PlayerEntity)null, 1025, blockpos, 0);
                }
            }
        } else {
            if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
                this.spawnPosition = null;
            }

            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.withinDistance(this.getPositionVec(), 2.0D)) {
                this.spawnPosition = new BlockPos(this.getPosX() + (double)this.rand.nextInt(7) - (double)this.rand.nextInt(7), this.getPosY() + (double)this.rand.nextInt(6) - 2.0D, this.getPosZ() + (double)this.rand.nextInt(7) - (double)this.rand.nextInt(7));
            }

            double d2 = (double)this.spawnPosition.getX() + 0.5D - this.getPosX();
            double d0 = (double)this.spawnPosition.getY() + 0.1D - this.getPosY();
            double d1 = (double)this.spawnPosition.getZ() + 0.5D - this.getPosZ();
            Vector3d vector3d = this.getMotion();
            Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double)0.1F, (Math.signum(d0) * (double)0.7F - vector3d.y) * (double)0.1F, (Math.signum(d1) * 0.5D - vector3d.z) * (double)0.1F);
            this.setMotion(vector3d1);
            float f = (float)(MathHelper.atan2(vector3d1.z, vector3d1.x) * (double)(180F / (float)Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
            this.moveForward = 0.5F;
            this.rotationYaw += f1;
            if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube(this.world, blockpos1)) {
                this.setIsButterflyHanging(true);
            }
        }

    }


    public void writeAdditional(CompoundNBT comnbt) {
        super.writeAdditional(comnbt);
        comnbt.putInt("Variant", this.getButterflyVariant());

        }

    }

