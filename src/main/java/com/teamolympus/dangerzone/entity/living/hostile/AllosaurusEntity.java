package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.client.render.AllosaurusRender;
import com.teamolympus.dangerzone.entity.ai.DZAIWanderFrequent;
import com.teamolympus.dangerzone.misc.DZLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AllosaurusEntity extends EntityMob implements IBossDisplayData {

    private int randomTextureSelector;

    public AllosaurusEntity(World world) {
        super(world);
        this.setSize(1.5f, 1.5f);
        this.experienceValue = 199;
        randomTextureSelector = rand.nextInt(AllosaurusRender.TEXTURES.length);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new DZAIWanderFrequent(this, 1.0D, 16));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
    }

    public int getRandomTextureSelector() {
        return randomTextureSelector;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (entity instanceof EntityLivingBase) {

            double angleX = this.posX - entity.posX;
            double angleZ = this.posZ - entity.posZ;

            double velX = this.motionX + this.motionZ + entity.motionX + entity.motionX;
            double velZ = this.motionZ + this.motionZ + entity.motionZ + entity.motionX;

            double sqr = MathHelper.sqrt_double(velX + velZ);

            double value = Math.atan2(angleX, angleZ);

            entity.addVelocity(Math.cos(value) * 1.2f + sqr, 2.1f, Math.sin(value) * 1.2f + sqr);

            return super.attackEntityAsMob(entity);
        }
        return super.attackEntityAsMob(entity);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.31);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(400D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange)
            .setBaseValue(180D);
    }

    @Override
    protected boolean isAIEnabled()
    {
        return true;
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
    public int getTotalArmorValue()
    {
        return 3;
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Variant", this.randomTextureSelector);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        this.randomTextureSelector = tagCompund.getInteger("Variant");
    }
}
