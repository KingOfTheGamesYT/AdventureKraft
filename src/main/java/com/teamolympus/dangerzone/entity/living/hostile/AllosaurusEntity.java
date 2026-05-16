package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.client.render.AllosaurusRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class AllosaurusEntity extends EntityMob implements IBossDisplayData {

    private final int randomTextureSelector;

    public AllosaurusEntity(World world) {
        super(world);
        this.setSize(1.5f, 1.5f);
        this.experienceValue = 199;
        randomTextureSelector = rand.nextInt(AllosaurusRender.TEXTURES.length);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public int getRandomTextureSelector() {
        return randomTextureSelector;
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
        tagCompund.getInteger("Variant");
    }
}
