package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.client.render.AllosaurusRender;
import com.teamolympus.dangerzone.entity.ai.DZAIWanderFrequent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
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


    public AllosaurusEntity(World world) {
        super(world);
        this.setSize(1.5f, 1.5f);
        this.experienceValue = 199;
    }

    static final int TEXTURE = 22;
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(TEXTURE, (byte)1);
    }

    public int getRandomTextureSelector()
    {
        return this.dataWatcher.getWatchableObjectByte(TEXTURE);
    }

    public void setTexture(int text)
    {
        this.dataWatcher.updateObject(TEXTURE, (byte)text);
    }

    @Override
    protected void updateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        this.setTexture(rand.nextInt(AllosaurusRender.TEXTURES.length));
        return super.onSpawnWithEgg(data);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
            final  double angleX = this.posX - entity.posX;
            final double angleZ = this.posZ - entity.posZ;

            final double value = Math.atan2(angleX, angleZ);

            double throwFactor = 0;
            if (rand.nextInt(25) == 0) {
                throwFactor = 0.25D;
            }

            final double finalVX = Math.cos(value) * 1.2D ;
            final double finalVZ = Math.sin(value) * 1.2D;

            double airValue = 0.1D;
            if (entity.isDead || entity instanceof EntityPlayer)
            {
                airValue += 2.1D;
            }
            entity.addVelocity(finalVX + throwFactor, airValue, finalVZ + throwFactor);

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
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setInteger("Variant",  this.getRandomTextureSelector());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.setTexture(tag.getInteger("Variant"));
    }

}
