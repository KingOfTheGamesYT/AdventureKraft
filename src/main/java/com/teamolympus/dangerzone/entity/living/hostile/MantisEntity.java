package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import com.teamolympus.dangerzone.misc.BoundingBoxHelper;
import com.teamolympus.dangerzone.misc.DZLogger;
import com.teamolympus.dangerzone.misc.DropHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class MantisEntity extends EntityMob {

    private ChunkCoordinates attackerPosition;
    private int lastPosZ;
    private int lastPosX;
    private int stuckTicks;
    Vec3 vec;
    private final double EXPAND_Z = 16.0D;
    private final double EXPAND_Y = 8.0D;
    private final double EXPAND_X = EXPAND_Z;

    public MantisEntity(World world) {
        super(world);
        this.setSize(2.5F, 3.25F);
        this.experienceValue = 100;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .setBaseValue(DZConfig.mantisAttackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(DZConfig.mantisSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(DZConfig.mantisMaxHp);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
        if (this.isInWater() && rand.nextInt(20) == 0) {
            this.attackEntityFrom(DamageSource.drown, this.rand.nextInt((int) DZConfig.mantisAttackDamage));
        }
    }


    @Override
    //TODO: Hook it up to the actual pathfinder to make it alot smarter.
    protected void updateEntityActionState()
    {
        this.fleeingTick = 0;
        super.updateEntityActionState();
        this.fleeingTick = 0;

        if (this.attackerPosition == null) {
            this.attackerPosition = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
         //   this.attackerPosition = null;
        }

                                                                                                                                                                                                                            // 9.4
                                                                                                                                                                                                                           // 2.1 // 4.0 // 7.9 // 6.1
        if (
        (!this.worldObj.isAirBlock(this.attackerPosition.posX, this.attackerPosition.posY, this.attackerPosition.posZ)
                || this.attackerPosition.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1F)
        ) {
            attackerPosition.set((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
        }


      //  if (this.attackerPosition == null || this.rand.nextInt(300) == 0 || this.attackerPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F)
    //    {
         //   this.attackerPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
    //    }

        if (this.getEntityToAttack() != null && this.canEntityBeSeen(this.getEntityToAttack()))
        {
            if (pathToEntity != null)
            {
                vec = pathToEntity.getPosition(this.getEntityToAttack());
                attackerPosition.set((int) vec.xCoord, (int) vec.yCoord + 1, (int) vec.zCoord);
                DZLogger.LOGGER.error("test BUT DIFF");
            } else {
                attackerPosition.set((int) getEntityToAttack().posX, (int) getEntityToAttack().posY + 1, (int) getEntityToAttack().posZ);
            }
        } else if (this.findEntityInBoundingBox() != null) {
            if (pathToEntity != null) {
                vec = pathToEntity.getPosition(this.findEntityInBoundingBox());
                attackerPosition.set((int) vec.xCoord, (int) vec.yCoord + 1, (int) vec.zCoord);
                DZLogger.LOGGER.error("test");
            } else {
                attackerPosition.set((int)findEntityInBoundingBox().posX, (int) findEntityInBoundingBox().posY + 1, (int) findEntityInBoundingBox().posZ);
            }
        }

        // Prevent Mob from getting stuck On Flight
        if (this.lastPosX == (int)this.posX && this.lastPosZ == (int)this.posZ)
        {
            ++stuckTicks;
           if (stuckTicks > 60)
            {
                vec = null;
                pathToEntity = null;
                updatePosStuck();
                pathToEntity = null;
                vec = null;
            }
        } else {
            this.lastPosX = (int) this.posX;
            this.lastPosZ = (int) this.posZ;
            stuckTicks = 0;
        }


        double d0 = (double)this.attackerPosition.posX + 0.5D - this.posX;
        double d1 = (double)this.attackerPosition.posY + 0.1D - this.posY;
        double d2 = (double)this.attackerPosition.posZ + 0.5D - this.posZ;


        this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
        this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
        float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 1.0F;
        this.rotationYaw += f1;



        if (this.worldObj.rand.nextInt(100) == 0) {
            this.heal(1);
        }
    }

    protected void updatePosStuck() {
        int x = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(9) + 4D);
        int y = MathHelper.floor_double(this.posY + 3 + (double)this.rand.nextInt(6) - 3.0D);
        int z = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(9) + 4D);
        this.attackerPosition.set(x, y, z);
    }

    @Override
    protected void updateWanderPath() {}


    @Override
    protected void attackEntity(Entity mob, float dist)
    {
        if (this.attackTime <= 0 && dist < 3.0F && mob.boundingBox.maxY > this.boundingBox.minY && mob.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(mob);
        }

        if (pathToEntity != null) {
            this.entityToAttack = mob;
            this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, 16.0F, true, false, false, true);
        } else {
            if (attackerPosition != null) {
                this.entityToAttack = mob;
                attackerPosition.set((int) mob.posX, (int) mob.posY + 1, (int) mob.posZ);
            }

        }

    }

    @Override
    protected void fall(float distance) {}

    @Override
    protected void updateFallState(double distanceFallenThisTick, boolean isOnGround) {}

    @Override
    protected void collideWithEntity(Entity p_82167_1_) {}

    @Override
    protected void collideWithNearbyEntities() {}

    @Override
    public boolean canBePushed()
    {
        return true;
    }

    @Override
    protected boolean isValidLightLevel()
    {
        return this.worldObj.isDaytime();
    }

    @Override
    public boolean getCanSpawnHere() {
        Entity mantis =  this.worldObj.findNearestEntityWithinAABB(MantisEntity.class, this.boundingBox.expand(32.0, 16.0, 32.0), this);
        boolean mantisIsNear = mantis == null;
        return this.posY > 50 && mantisIsNear && super.getCanSpawnHere();
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.yellow_flower);
    }

    @Override
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
        super.dropFewItems(hitByPlayer, lootingLevel);
        DropHelper.dropItemMultipleNonStackable(this, RegistryHandler.mantisClaw,2,5);
        DropHelper.dropItem(this, Items.item_frame, 1,5);
        DropHelper.dropItem(this, Items.gold_nugget, 2+ this.rand.nextInt(10),5);
        DropHelper.dropItem(this, Items.diamond, 2 + this.rand.nextInt(3),5);

        //TODO: ADD TITANIUM AND URANIUM NUGGET
    }


    public Entity findEntityInBoundingBox() {
        return BoundingBoxHelper.findEntityInBoundingBox(this, EXPAND_X,EXPAND_Y,EXPAND_Z);
    }

}