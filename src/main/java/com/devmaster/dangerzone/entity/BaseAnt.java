package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BaseAnt extends CreatureEntity {
    private List<BlockState> eatenBlocks = new ArrayList<>();
    private int eatTimer = 0;
    private final int EAT_RANGE = 5;
    private static final DataParameter<Integer> RED_ANT_VARIANT = EntityDataManager.createKey(BaseAnt.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> RAINBOW_ANT_VARIANT = EntityDataManager.createKey(BaseAnt.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> TERMITE_VARIANT = EntityDataManager.createKey(BaseAnt.class, DataSerializers.VARINT);

    public BaseAnt(EntityType<? extends BaseAnt> type, World world) {
        super(type, world);
        this.ignoreFrustumCheck = true;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.experienceValue = 1;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(RAINBOW_ANT_VARIANT, 0);
        this.dataManager.register(RED_ANT_VARIANT, 0);
        this.dataManager.register(TERMITE_VARIANT, 0);
    }

    public int getRedAntVariant() {
        return MathHelper.clamp(this.dataManager.get(RED_ANT_VARIANT), 1, 2);
    }

    public void setRedAntVariant(int variant) {
        this.dataManager.set(RED_ANT_VARIANT, variant);
    }

    public int getRainbowAntVariant() {
        return MathHelper.clamp(this.dataManager.get(RAINBOW_ANT_VARIANT), 1, 2);
    }

    public void setRainbowAntVariant(int variant) {
        this.dataManager.set(RAINBOW_ANT_VARIANT, variant);
    }

    protected boolean isRedAnt() {
        return this.getType() == RegistryHandler.RED_ANT.get();
    }

    protected boolean isTermite() {
        return this.getType() == RegistryHandler.TERMITE.get();
    }

    protected boolean isRainbowAnt() {
        return this.getType() == RegistryHandler.RAINBOWANT.get();
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance diff, SpawnReason spawn, @Nullable ILivingEntityData spawndata, @Nullable CompoundNBT comnbt) {

        if (isRedAnt()) {
            int variant = this.rand.nextInt(2)+1;
            setRedAntVariant(variant);
        }
        if (isRainbowAnt()) {
            int variant = this.rand.nextInt(2)+1;
            setRainbowAntVariant(variant);
        }

        return super.onInitialSpawn(world, diff, spawn, spawndata, comnbt);
    }

    //Save the varient on re-load
    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);

        if (isRedAnt()) {
            nbt.putInt("RedAntVariant", this.getRedAntVariant());
        }
        if (isRainbowAnt()) {
            nbt.putInt("RainbowAntVariant", this.getRainbowAntVariant());
        }
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);

        if (isRedAnt() && nbt.contains("RedAntVariant")) {
            this.setRedAntVariant(nbt.getInt("RedAntVariant"));
        }
        if (isRainbowAnt() && nbt.contains("RainbowAntVariant")) {
            this.setRainbowAntVariant(nbt.getInt("RainbowAntVariant"));
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.15D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));

        if (isRedAnt()) {
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        }
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
                .createMutableAttribute(Attributes.ARMOR, 0.5)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0.15)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 10);
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (isTermite()) {
            termiteTick();
        }
        dieInWater();
    }

    @Override
    protected void dropInventory() {
        super.dropInventory();

        //Drop all the eaten blocks
        for (BlockState blockState : this.eatenBlocks) {
            List<ItemStack> drops = Block.getDrops(blockState, (ServerWorld) this.world, getPosition(), null, this, ItemStack.EMPTY);

            for (ItemStack stack : drops) {
                if (!stack.isEmpty()) {
                    this.entityDropItem(stack);
                }
            }
        }
    }

    protected void termiteTick() {
        if (!this.world.isRemote && this.isAlive()) {

            eatTimer++;

            if (eatTimer >= 20) {
                eatTimer = 0;

                BlockPos pos = findWoodBlockInRange();
                if (pos != null) {
                    BlockState state = world.getBlockState(pos);
                    eatenBlocks.add(state);

                    world.removeBlock(pos, false);
                    world.setBlockState(pos, Blocks.DIRT.getDefaultState());
                }
            }
        }
    }

    private BlockPos findWoodBlockInRange() {
        BlockPos termitePos = this.getPosition();

        //Iterate over the nearby positions within the specified range
        for (BlockPos pos : BlockPos.getAllInBoxMutable(
                termitePos.add(-EAT_RANGE, -EAT_RANGE, -EAT_RANGE),
                termitePos.add(EAT_RANGE, EAT_RANGE, EAT_RANGE)
        )) {
            BlockState blockState = this.world.getBlockState(pos);

            //Check if the block is eatable
            if (blockState.isIn(DangerZone.TERMITE_FOOD)) {
                return pos;
            }
        }
        return null; //No edible block found within range
    }

    protected void dieInWater() {
        if (this.isAlive() && this.isInWaterRainOrBubbleColumn()) {
            this.setAir(0);
            this.attackEntityFrom(DamageSource.DROWN, Float.MAX_VALUE);
        }
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
    protected boolean isDespawnPeaceful() {
        return false;
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }
}