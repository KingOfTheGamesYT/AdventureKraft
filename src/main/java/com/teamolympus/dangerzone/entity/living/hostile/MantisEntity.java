package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import com.teamolympus.dangerzone.misc.DropHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class MantisEntity extends EntityMob {

    private ChunkCoordinates spawnPosition;
    private int lastPosZ;
    private int lastPosX;
    private int stuckTicks;

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
            .setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.319);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(120D);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    public boolean canEntityBeSeen(Entity entity)
    {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ), Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ)) == null;
    }

    @Override
    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.isInWater())
        {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
        }
        else if (this.handleLavaMovement())
        {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        else
        {
            float f2 = 0.91F;

            if (this.onGround)
            {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
            }

            float f3 = 0.16277136F / (f2 * f2 * f2);
            this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;

            if (this.onGround)
            {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    //TODO: Hook it up to the actual pathfinder to make it alot smarter.
    //TODO: BORROW FROM isCourseTraversable() IN entityGhast to hopefully fully prevent  mob from getting stuck.
    protected void updateEntityActionState()
    {
        super.updateEntityActionState();
        if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1))
        {
            this.spawnPosition = null;
        }


        // Prevent Mob from getting stuck On Flight
        if (this.lastPosX == (int)this.posX && this.lastPosZ == (int)this.posZ)
        {
            ++stuckTicks;
            if (stuckTicks > 60)
            {
               updatePosStuck();
            }
        } else {
            this.lastPosX = (int) this.posX;
            this.lastPosZ = (int) this.posZ;
            stuckTicks = 0;
        }

        if (this.spawnPosition == null || this.rand.nextInt(300) == 0 || this.spawnPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F)
        {
            this.spawnPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}

        if (this.getEntityToAttack() != null && this.canEntityBeSeen(this.getEntityToAttack()))
        {
            spawnPosition.set((int) getEntityToAttack().posX, (int) getEntityToAttack().posY + 1, (int) getEntityToAttack().posZ);
        } else if (this.findEntityInBoundingBox() != null) {
            spawnPosition.set((int)findEntityInBoundingBox().posX, (int) findEntityInBoundingBox().posY + 1, (int) findEntityInBoundingBox().posZ);
        }

        double d0 = (double)this.spawnPosition.posX + 0.5D - this.posX;
        double d1 = (double)this.spawnPosition.posY + 0.1D - this.posY;
        double d2 = (double)this.spawnPosition.posZ + 0.5D - this.posZ;


        this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
        this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
        float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 1.0F;
        this.rotationYaw += f1;


        if (this.worldObj.rand.nextInt(100) == 0)
        {
            this.heal(1);
        }
    }

    protected void updatePosStuck()
    {
            int x = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(9) + 4D);
            int y = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(6) - 3.0D);
            int z = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(9) + 4D);

            if (this.spawnPosition != null)
            {
                this.spawnPosition.set(x,y,z);
                setPathToEntity(this.worldObj.getEntityPathToXYZ(this, x, y, z, 10.0F, true, false, false, true));
            }

    }

    @Override
    protected void attackEntity(Entity mob, float dist)
    {
        if (this.attackTime <= 0 && dist < 4.0F && mob.boundingBox.maxY > this.boundingBox.minY && mob.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(mob);
        }

        if (spawnPosition != null)
        {
            spawnPosition.set((int) mob.posX, (int) mob.posY, (int) mob.posZ);
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
    public boolean getCanSpawnHere()
    {
      Entity mantis =  this.worldObj.findNearestEntityWithinAABB(MantisEntity.class, this.boundingBox.expand(32.0, 16.0, 32.0), this);
      boolean mantisIsNear = mantis == null;
      return this.posY > 50 && mantisIsNear && super.getCanSpawnHere();
    }

    @Override
    protected Item getDropItem()
    {
        return Item.getItemFromBlock(Blocks.yellow_flower);
    }

    @Override
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        super.dropFewItems(hitByPlayer, lootingLevel);
        DropHelper.dropItemMultipleNonStackable(this, RegistryHandler.mantisClaw,2);
        DropHelper.dropItem(this, Items.item_frame, 1);
        DropHelper.dropItem(this, Items.gold_nugget, 2+ this.rand.nextInt(10));

        //TODO: ADD TITANIUM AND URANIUM NUGGET
    }


    // Borrowed from EntityPigZombie.java
    @SuppressWarnings("unchecked")
    public Entity findEntityInBoundingBox() {
        List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 8.0D, 16.0D));

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

}
