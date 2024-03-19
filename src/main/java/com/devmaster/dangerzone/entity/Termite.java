package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class Termite extends AnimalEntity {
    private List<BlockState> eatenBlocks;
    private int eatTimer;
    private final int EAT_RANGE = 5; // Adjust the range as needed



    public Termite(final EntityType<? extends Termite> type, final World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.experienceValue = 1;
        this.eatenBlocks = new ArrayList<>();

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
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.15D));

    }


    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return null;
    }


        @Override
        public void livingTick() {
            super.livingTick();
            if (!this.world.isRemote && !this.isChild() && this.isAlive()) {
                // Increment the eat timer
                this.eatTimer++;

                // Check if the eat timer has reached the desired duration (in ticks)
                if (this.eatTimer >= 20) {
                    // Reset the eat timer
                    this.eatTimer = 0;

                    // Find a nearby wood block within the specified range
                    BlockPos targetPos = findWoodBlockInRange();
                    if (targetPos != null) {
                        BlockState blockState = this.world.getBlockState(targetPos);

                        // Store the eaten block state
                        this.eatenBlocks.add(blockState);

                        // Remove the wood block from the world
                        this.world.removeBlock(targetPos, false);

                        // Replace with dirt block
                        this.world.setBlockState(targetPos, Blocks.DIRT.getDefaultState());
                    }
                }
            }
        this.dieInWater();
    }

    protected void dieInWater() {
        if (this.isAlive()) {
            if (this.isInWaterRainOrBubbleColumn()) {
                this.setAir(0);
                this.damageEntity(DamageSource.DROWN, Integer.MAX_VALUE);
            }
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
        return false;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }


    @Override
    protected void dropInventory() {
        super.dropInventory();

        // Drop all the eaten blocks
        for (BlockState blockState : this.eatenBlocks) {
            Block block = blockState.getBlock();
            List<ItemStack> drops = Block.getDrops(blockState, (ServerWorld) this.world, getPosition(), null, this, ItemStack.EMPTY);

            // Drop each item stack
            for (ItemStack stack : drops) {
                if (!stack.isEmpty()) {
                    this.entityDropItem(stack);
                }
            }
        }
    }

    private BlockPos findWoodBlockInRange() {
        BlockPos termitePos = this.getPosition();

        // Iterate over the nearby positions within the specified range
        for (BlockPos pos : BlockPos.getAllInBoxMutable(
                termitePos.add(-EAT_RANGE, -EAT_RANGE, -EAT_RANGE),
                termitePos.add(EAT_RANGE, EAT_RANGE, EAT_RANGE)
        )) {
            BlockState blockState = this.world.getBlockState(pos);

            // Check if the block is eatable wood
            if (blockState.isIn(DangerZone.TERMITE_FOOD)) {
                return pos;
            }
        }

        return null; // No wood block found within range
    }

}
