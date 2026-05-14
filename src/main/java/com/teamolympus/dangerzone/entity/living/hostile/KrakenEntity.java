package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import com.teamolympus.dangerzone.misc.DZLogger;
import com.teamolympus.dangerzone.misc.DropHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import com.teamolympus.dangerzone.world.BaseWorldHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
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

public class KrakenEntity extends EntityMob implements IBossDisplayData {

    private ChunkCoordinates attackerPosition;
    private int lastPosZ;
    private int lastPosX;
    private int stuckTicks;
    Vec3 vec;
    int immuneTime = 30;
    public int reinforcementsTimer = 3600;
    private boolean reinforcements = false;
    private static final byte REINFORCEMENT_AMM = 10;
    private Entity attackedEntity = null;

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
        if (this.attackTime <= 0 && dist < 20.0F) {
            this.attackTime = 20;
            this.attackEntityAsMob(mob);
            attackedEntity = mob;
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

        final int ePosZ = (int) this.posZ;
        final int ePosX = (int) this.posX;
        final int ePosY = (int) this.posY;

        if (this.worldObj.rand.nextInt(400) == 0) {
            EntityLightningBolt bolt = new EntityLightningBolt(this.worldObj, ePosX + randomOffset(), ePosY + randomOffsetY(), ePosZ + randomOffset());
            this.worldObj.addWeatherEffect(bolt);
        }


        if (this.attackerPosition != null && (!this.worldObj.isAirBlock(this.attackerPosition.posX, this.attackerPosition.posY, this.attackerPosition.posZ) || this.attackerPosition.posY < 1)) {
            this.attackerPosition = null;
        }


        if (this.attackerPosition == null) {
            this.attackerPosition = new ChunkCoordinates(ePosX, ePosY, ePosZ);
        }

        if (
                (!this.worldObj.isAirBlock(this.attackerPosition.posX, this.attackerPosition.posY, this.attackerPosition.posZ)
                        || this.attackerPosition.getDistanceSquared(ePosX, ePosY, ePosZ) < 9.1F)) {



         /**   int groundDist;
            for (groundDist = 0; groundDist < 31; groundDist++) {
                if (!BaseWorldHelper.fastIsAirBlock(worldObj, (int) this.posX, (int) this.posY - groundDist, (int) this.posZ)) {
                    DZLogger.LOGGER.error("YOOOOO");
                    break;
                } else {
                    DZLogger.LOGGER.error("Test");
                }
                DZLogger.LOGGER.error("COUNTER  " + groundDist);
            }
          **/

            attackerPosition.set
            (
                    ePosX + this.rand.nextInt(6) + this.rand.nextInt(12),
                  //  (int)this.posY + this.rand.nextInt(10) - 2,
                //   (int)this.posY + this.rand.nextInt(10) - 4,
                 //   (int)this.posY + this.rand.nextInt(6) - 1,
                 //  (int)this.posY + this.rand.nextInt(6) - 2,
                 //   (int)this.posY + this.rand.nextInt(9) - 4,
                //  (int)this.posY + groundDist /2 - groundDist + this.rand.nextInt(10) - 7,
                   // (int)this.posY + this.rand.nextInt(10) - 7,,
                    ePosY + this.rand.nextInt(9) - 6,
                    ePosZ + this.rand.nextInt(6) + this.rand.nextInt(12)
            );

            for (int groundDist = 0; groundDist < 31; groundDist++) {
                if (!BaseWorldHelper.fastIsAirBlock(worldObj, ePosX, ePosY - groundDist, ePosZ)) {
                    attackerPosition.posY += groundDist;
                    DZLogger.LOGGER.error("YOOOOO");
                    break;
                    }
            }



            // we are prob to high up

        /**    for (int i = 15; i < 20; i++)
            {
                if (BaseWorldHelper.fastIsAirBlock(worldObj, (int) this.posX, (int) this.posY - i, (int) this.posZ))
                {
                    DZLogger.LOGGER.error("TOO HIGH, LOWERING");
                    attackerPosition.posY -= i;
                    break;
                }
            }
         **/


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
                krakenEntity.posZ = ePosZ + this.worldObj.rand.nextInt(10)  - this.worldObj.rand.nextInt(10);
                krakenEntity.posX = ePosX + this.worldObj.rand.nextInt(12) + this.worldObj.rand.nextInt(5);
                krakenEntity.posY = ePosY + this.worldObj.rand.nextInt(10) - this.worldObj.rand.nextInt(10);

                this.worldObj.spawnEntityInWorld(krakenEntity);

            }
        }

        if (attackedEntity != null)
        {
            this.attackedEntity.motionY = this.motionY;
            this.attackedEntity.motionZ = this.motionZ;
            this.attackedEntity.motionX = this.motionX;
        }

        // Prevent Mob from getting stuck On Flight
        if (this.lastPosX == ePosX && this.lastPosZ == ePosZ) {
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
            this.lastPosX = ePosX;
            this.lastPosZ = ePosZ;
            stuckTicks = 0;
        }


        double d0 = (double)this.attackerPosition.posX + 0.3D - ePosX;
        double d1 = (double)this.attackerPosition.posY + 0.1D - ePosY;
        double d2 = (double)this.attackerPosition.posZ + 0.3D - ePosZ;


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
