package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.entity.living.IAdventureKraftAttackableMobs;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class MantisEntity extends EntityMob {

    private ChunkCoordinates spawnPosition;
    private int lastPosZ;
    private int lastPosX;

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
    protected void updateEntityActionState()
    {
        super.updateEntityActionState();
        if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1))
        {
            this.spawnPosition = null;
        }


        if (this.spawnPosition == null || this.rand.nextInt(300) == 0 || this.spawnPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F)
        {
            this.spawnPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}


        if (this.getEntityToAttack() != null && this.canEntityBeSeen(this.getEntityToAttack()))
        {
            spawnPosition.set((int) getEntityToAttack().posX, (int) getEntityToAttack().posY + 1, (int) getEntityToAttack().posZ);
        } else if (this.findEntityInBoundingBox() != null) {
            spawnPosition.set((int) findEntityInBoundingBox().posX, (int) findEntityInBoundingBox().posY + 1, (int) findEntityInBoundingBox().posZ);
        }


        double d0 = (double)this.spawnPosition.posX + 0.5D - this.posX;
        double d1 = (double)this.spawnPosition.posY + 0.1D - this.posY;
        double d2 = (double)this.spawnPosition.posZ + 0.5D - this.posZ;


        this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
        this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
        float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 0.5F;
        this.rotationYaw += f1;


        if (this.worldObj.rand.nextInt(100) == 0) {
            this.heal(1);
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
    public boolean getCanSpawnHere()
    {
      Entity mantis =  this.worldObj.findNearestEntityWithinAABB(MantisEntity.class, this.boundingBox.expand(32.0, 16.0, 32.0), this);
      boolean mantisIsNear = mantis == null;

      /**  for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {

                }

            }



        }
       **/

        return this.posY > 50 && mantisIsNear && super.getCanSpawnHere();
    }

    public boolean isAttacking()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setAttackState(boolean state)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (state)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, b0);
    }


    // Borrowed from EntityPigZombie.java
    public Entity findEntityInBoundingBox() {
        List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 8.0D, 16.0D));

        for (Entity entity : list) {
        //    Entity entity1 = entity;

            if (entity instanceof IAdventureKraftAttackableMobs) {
                IAdventureKraftAttackableMobs attackableMob = ((IAdventureKraftAttackableMobs) entity);

                if (attackableMob.entityAttackInstance() != null) {
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
