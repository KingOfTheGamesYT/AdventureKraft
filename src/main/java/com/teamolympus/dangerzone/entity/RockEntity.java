package com.teamolympus.dangerzone.entity;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.enums.EnumRockTypes;

public class RockEntity extends EntityThrowable {

    public EnumRockTypes rockTypes;

    // needed forfor MC
    public RockEntity(World world) {
        super(world);
    }

    public RockEntity(World world, EnumRockTypes types) {
        super(world);
        this.rockTypes = types;
    }

    public RockEntity(World world, EntityLivingBase entityLivingBase, EnumRockTypes types) {
        super(world, entityLivingBase);
        this.rockTypes = types;
    }

    public RockEntity(World world, double posX, double posY, double posZ, EnumRockTypes types) {
        super(world, posX, posY, posZ);
        this.rockTypes = types;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.entityHit instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase) movingObjectPosition.entityHit;
            switch (rockTypes) {
                case EXPLOSIVE_ROCK:
                    this.worldObj.createExplosion(getThrower(), this.posX, this.posY, this.posZ, 1.0f, false);
                    break;
                case RED_ROCK:
                    entity.setFire(20);
                    break;
                case SMALL_ROCK:
                    entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2);
                    break;
                case GREEN_ROCK:
                    entity.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
                    break;
                default:
                    break;
            }

            // movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
            // (float)b0);
        }

        if (!this.worldObj.isRemote) {
            switch (rockTypes) {
                case EXPLOSIVE_ROCK:
                    this.dropBlockAsItem(
                        this.worldObj,
                        (int) this.posX,
                        (int) this.posY,
                        (int) this.posZ,
                        new ItemStack(RegistryHandler.explosiveRock));
                    break;
                case RED_ROCK:
                    this.dropBlockAsItem(
                        this.worldObj,
                        (int) this.posX,
                        (int) this.posY,
                        (int) this.posZ,
                        new ItemStack(RegistryHandler.redRock));
                    break;
                case SMALL_ROCK:
                    this.dropBlockAsItem(
                        this.worldObj,
                        (int) this.posX,
                        (int) this.posY,
                        (int) this.posZ,
                        new ItemStack(RegistryHandler.smallRock));
                    break;
                case GREEN_ROCK:
                    this.dropBlockAsItem(
                        this.worldObj,
                        (int) this.posX,
                        (int) this.posY,
                        (int) this.posZ,
                        new ItemStack(RegistryHandler.greenRock));
                    break;
            }
            this.setDead();
        }
    }

    protected void dropBlockAsItem(World worldIn, int x, int y, int z, ItemStack itemIn) {
        if (!worldIn.isRemote && worldIn.getGameRules()
            .getGameRuleBooleanValue("doTileDrops") && !worldIn.restoringBlockSnapshots) // do not drop items while
                                                                                         // restoring blockstates,
                                                                                         // prevents item dupe
        {
            /**
             * if (captureDrops.get())
             * {
             * capturedDrops.get().add(itemIn);
             * return;
             * }
             **/
            float f = 0.7F;
            double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(worldIn, (double) x + d0, (double) y + d1, (double) z + d2, itemIn);
            entityitem.delayBeforeCanPickup = 10;
            worldIn.spawnEntityInWorld(entityitem);
        }
    }

}
