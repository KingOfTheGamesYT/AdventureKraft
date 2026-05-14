package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import com.teamolympus.dangerzone.misc.DZLogger;
import com.teamolympus.dangerzone.misc.DropHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;


import java.util.List;

public class KrakenEntity extends EntityMob {

    private ChunkCoordinates attackerPosition;
    private int lastPosZ;
    private int lastPosX;
    private int stuckTicks;
    Vec3 vec;
    int immuneTime = 30;
    public int reinforcementsTimer = 3600;
    private boolean reinforcements = false;
    private static final byte REINFORCEMENT_AMM = 10;
    private static final int GROUND_CHECK = 31;

    public KrakenEntity(World world) {
        super(world);
        this.setSize(4.0f, 15.0f);
        this.isImmuneToFire = true;
        this.fireResistance = 120;
        this.experienceValue = 500;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue(0.319);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(120D);
    }



    @Override
    public boolean attackEntityFrom(DamageSource ds, float damage) {
        if (immuneTime < 0) {
            immuneTime = 100;
            return super.attackEntityFrom(ds, damage);
        }
        return false;
    }


    @Override
    protected void attackEntity(Entity mob, float dist)
    {
        if (this.attackTime <= 0 && dist < 12.0F) {
            this.attackTime = 20;
            this.attackEntityAsMob(mob);
        }
        if (pathToEntity != null) {
            this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, 16.0F, true, false, false, true);
        } else {
            if (attackerPosition != null) {
                attackerPosition.set((int) mob.posX, (int) mob.posY + 1, (int) mob.posZ);
            }
        }

    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        immuneTime--;

        if (this.attackerPosition == null) {
            this.attackerPosition = new ChunkCoordinates((int)this.posX, (int)this.posY - 10, (int)this.posZ);
        }

        if (this.posZ < this.attackerPosition.posY) {
            this.motionY *= 0.74894930;
        } else {
            this.motionY *= 0.568533;
        }

        if (this.ticksExisted % 100 == 0 && !this.worldObj.isRemote) {
            WorldInfo worldInfo = worldObj.getWorldInfo();
            worldInfo.setRaining(true);
            worldInfo.setThundering(true);
            worldInfo.setRainTime(900);
            worldInfo.setThunderTime(900);
        }
    }

    @Override
    protected void updateEntityActionState()
    {
        this.fleeingTick = 0;
        super.updateEntityActionState();
        this.fleeingTick = 0;
        reinforcementsTimer--;

        if (this.worldObj.rand.nextInt(400) == 0) {
            EntityLightningBolt bolt = new EntityLightningBolt(this.worldObj, this.posX + randomOffset(), this.posY + randomOffsetY(), this.posZ + randomOffset());
            this.worldObj.addWeatherEffect(bolt);
        }


        if (this.attackerPosition != null && (!this.worldObj.isAirBlock(this.attackerPosition.posX, this.attackerPosition.posY, this.attackerPosition.posZ) || this.attackerPosition.posY < 1)) {
            this.attackerPosition = null;
        }


        if (this.attackerPosition == null) {
            this.attackerPosition = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }

        if (
                (!this.worldObj.isAirBlock(this.attackerPosition.posX, this.attackerPosition.posY, this.attackerPosition.posZ)
                        || this.attackerPosition.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 9.1F)) {
            int groundDist;
            for (groundDist = 0; groundDist < GROUND_CHECK; groundDist++) {
                if (this.worldObj.getBlock((int) this.posX, (int) this.posY - groundDist, (int) this.posZ) != Blocks.air) {
                //    this.attackerPosition.posZ -= groundDist;
                    break;
                }

            }

         //   int ground = 20;
        //    int ground2 = ground - groundDist;
        //    DZLogger.LOGGER.error("GROUND DIST "+ground2);
          //  DZLogger.LOGGER.error("POZY "+attackerPosition.posY);
            attackerPosition.set
            (
                    (int)this.posX + this.rand.nextInt(6) - this.rand.nextInt(12),
                    (int)this.posY + this.rand.nextInt(9) - 6,
                    (int)this.posZ + this.rand.nextInt(6) - this.rand.nextInt(12)
            );


        }

        if (this.getEntityToAttack() != null && this.canEntityBeSeen(this.getEntityToAttack())) {
            if (pathToEntity != null) {
                vec = pathToEntity.getPosition(this.getEntityToAttack());
                attackerPosition.set((int) vec.xCoord, (int) vec.yCoord + 15, (int) vec.zCoord);
            } else {
                attackerPosition.set((int) getEntityToAttack().posX, (int) getEntityToAttack().posY + 15, (int) getEntityToAttack().posZ);
            }
        } else if (this.findEntityInBoundingBox() != null) {
            if (pathToEntity != null) {
                vec = pathToEntity.getPosition(this.getEntityToAttack());
                attackerPosition.set((int) vec.xCoord, (int) vec.yCoord + 15, (int) vec.zCoord);
            } else {
                attackerPosition.set((int)findEntityInBoundingBox().posX, (int) findEntityInBoundingBox().posY + 15, (int) findEntityInBoundingBox().posZ);
            }
        }


        if (this.reinforcementsTimer < 0 && this.getHealth() < (this.getMaxHealth() / 4) && !this.reinforcements) {
            this.reinforcements = true;
            for (int i = 0; i < REINFORCEMENT_AMM; i++) {
                KrakenEntity krakenEntity = new KrakenEntity(this.worldObj);
                krakenEntity.posZ = this.posZ + this.worldObj.rand.nextInt(10)  - this.worldObj.rand.nextInt(10);
                krakenEntity.posX = this.posX + this.worldObj.rand.nextInt(12) + this.worldObj.rand.nextInt(5);
                krakenEntity.posY = this.posY + this.worldObj.rand.nextInt(10) - this.worldObj.rand.nextInt(10);

                this.worldObj.spawnEntityInWorld(krakenEntity);

            }
        }

        // Prevent Mob from getting stuck On Flight
        if (this.lastPosX == (int)this.posX && this.lastPosZ == (int)this.posZ) {
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


        double d0 = (double)this.attackerPosition.posX + 0.3D - this.posX;
        double d1 = (double)this.attackerPosition.posY + 0.1D - this.posY;
        double d2 = (double)this.attackerPosition.posZ + 0.3D - this.posZ;


        this.motionX += (Math.signum(d0) * 0.45D - this.motionX) * 0.15D;
        this.motionY += (Math.signum(d1) * 0.709D - this.motionY) * 0.202;
        this.motionZ += (Math.signum(d2) * 0.45D - this.motionZ) * 0.15D;
        float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 0.4F;
        this.rotationYaw += f1;

    }
    @Override
    protected void updateWanderPath()
    {
    }

Item[] lootableList = new Item[]{
        Items.diamond,
        Item.getItemFromBlock(Blocks.diamond_block),
        Items.iron_ingot
    };

    @Override
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        super.dropFewItems(hitByPlayer, lootingLevel);
        DropHelper.dropItem(this, RegistryHandler.krakenTooth, 1, 8);
        DropHelper.dropItem(this, Items.item_frame, 1,8);
        DropHelper.dropItem(this, Items.dye, 120 + this.rand.nextInt(160),8);
    }


    protected void updatePosStuck()
    {
        int x = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(9) + 4D);
        int y = MathHelper.floor_double(this.posY + 3 + (double)this.rand.nextInt(6) - 3.0D);
        int z = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(9) + 4D);

        this.attackerPosition.set(x,y,z);
    }

    private int randomOffset() {
        return this.worldObj.rand.nextInt(8) - this.worldObj.rand.nextInt(8);
    }

    private int randomOffsetY() {
        return this.worldObj.rand.nextInt(16) - this.worldObj.rand.nextInt(16);
    }


    @Override
    protected void fall(float distance) {}

    @Override
    protected void updateFallState(double distanceFallenThisTick, boolean isOnGround) {}

    @SuppressWarnings("unchecked")
    public Entity findEntityInBoundingBox() {
        List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(25.0D, 40.0D, 25.0D));

        for (Entity entity : list) {
            if (entity instanceof IAdventureKraftAttackableMobs)
            {
                IAdventureKraftAttackableMobs attackableMob = ((IAdventureKraftAttackableMobs) entity);

                if (attackableMob.entityAttackInstance() != null)
                {
                    return attackableMob.entityAttackInstance();
                }

            }

            if (entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode) {
                return entity;
            }


        }
        return null;
    }


    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        tag.setInteger("Immune", this.immuneTime);
        tag.setBoolean("Reinforcements", this.reinforcements);
        tag.setInteger("Timer", this.reinforcementsTimer);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        this.immuneTime = tag.getInteger("Immune");
        this.reinforcements = tag.getBoolean("Reinforcements");
        this.reinforcementsTimer = tag.getInteger("Timer");
    }


}
