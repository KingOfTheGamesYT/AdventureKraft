package net.Akio.CraftZone.Main.Entities;

import net.Akio.CraftZone.Main.CraftZone;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRock  extends EntityThrowable {
    private int rock_type = 0;
    private int myage = 0;
    private float my_rotation = 0.0F;

    public EntityRock(World par1World) {
        super(par1World);
    }

    public EntityRock(World par1World, int par2) {
        super(par1World);
    }

    public EntityRock(World par1World, EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    public EntityRock(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
        this.rock_type = par3;
    }

    public EntityRock(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
    }

    public int getRockType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setRockType(int par1) {
        if (this.worldObj != null) {
            if (!this.worldObj.isRemote) {
                this.rock_type = par1;
                this.dataWatcher.updateObject(20, par1);
            }
        }
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (!this.isDead) {
            if (!this.worldObj.isRemote) {
                if (par1MovingObjectPosition.entityHit != null && this.getThrower() != null) {
                    Entity e = par1MovingObjectPosition.entityHit;
                    double ks;
                    double inair;
                    float f3;
                    if (this.rock_type == 1 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 2.0F);
                        ks = 0.1D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                    }

                    if (this.rock_type == 2 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 5.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                    }

                    if (this.rock_type == 3 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 5.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        e.setFire(20);
                    }

                    if (this.rock_type == 4 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 5.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 5 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 10.0F);
                        ks = 0.1D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 6 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 20.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 7 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 40.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                    }

                    if (this.rock_type == 8 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 40.0F);
                        ks = 0.5D;
                        inair = 0.055D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        this.worldObj.newExplosion((Entity)null, e.posX, e.posY + 0.25D, e.posZ, 2.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    }

                    if (this.rock_type == 9 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 150.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        e.setFire(50);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 10 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 150.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
                        }

                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 11 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 150.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 0));
                        }

                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                        }
                    }

                    if (this.rock_type == 12 && e != this.getThrower()) {
                        e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)this.getThrower()), 250.0F);
                        ks = 0.2D;
                        inair = 0.025D;
                        f3 = (float)Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                        if (e.isDead) {
                            inair *= 2.0D;
                        }

                        e.addVelocity(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                        if (e instanceof EntityLivingBase) {
                            ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                        }

                        this.worldObj.newExplosion((Entity)null, e.posX, e.posY + 0.25D, e.posZ, 5.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
                    }
                } else if (this.rock_type != 0) {
                    int played = 0;
                    int x = par1MovingObjectPosition.blockX;
                    int y = par1MovingObjectPosition.blockY;
                    int z = par1MovingObjectPosition.blockZ;

                    for(int i = -1; i <= 1; ++i) {
                        for(int j = -1; j <= 1; ++j) {
                            for(int k = -1; k <= 1; ++k) {
                                Block bid = this.worldObj.getBlock(x + i, y + j, z + k);
                                if (bid == Blocks.glass || bid == Blocks.glass_pane || bid == Blocks.glass) {
                                    if (!this.worldObj.isRemote) {
                                        this.worldObj.setBlock(x + i, y + j, z + k, Blocks.air);
                                    }

                                    if (played == 0) {
                                        this.worldObj.playSoundEffect((double)x, (double)y, (double)z, "dangerzone:glassdead", 1.0F, 1.0F);
                                        ++played;
                                    }
                                }
                            }
                        }
                    }

                    if (!this.worldObj.isRemote) {
                        if (this.rock_type == 1) {
                            this.dropItem(CraftZone.small_rock, 1);
                        }


                        if (this.rock_type == 3) {
                            this.dropItem(CraftZone.flame_rock, 1);
                        }

                        if (this.rock_type == 4) {
                            this.dropItem(CraftZone.poison_rock, 1);
                        }

                        if (this.rock_type == 8) {
                            this.dropItem(CraftZone.explosive_rock, 1);
                        }

                    }
                }

                this.setDead();
            }
        }
    }

    public void onUpdate() {
        int x = (int)this.posX;
        int y = (int)this.posY;
        int z = (int)this.posZ;
        super.onUpdate();
        this.my_rotation += 30.0F;
        this.my_rotation %= 360.0F;
        this.rotationPitch = this.prevRotationPitch = this.my_rotation;
        ++this.myage;
        if (this.myage > 1000) {
            this.setDead();
        }

        if (this.worldObj.isRemote) {
            this.rock_type = this.getRockType();
        } else {
            this.setRockType(this.rock_type);
        }

        Block bid = this.worldObj.getBlock(x, y, z);
        if (bid == Blocks.water && this.motionY < -0.15000000596046448D && this.motionY > -0.550000011920929D && (float)(this.motionX * this.motionX + this.motionZ * this.motionZ) > 0.5F) {
            this.motionY = -(this.motionY * 3.0D / 4.0D);
            this.motionX = this.motionX * 3.0D / 4.0D;
            this.motionZ = this.motionZ * 3.0D / 4.0D;
        }

    }
}
