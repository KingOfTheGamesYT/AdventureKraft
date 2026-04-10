package com.teamolympus.dangerzone.entity.living.hostile;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.misc.DropHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class KrakenEntity extends EntityMob {

    private ChunkCoordinates attackerPosition;

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
    public boolean canEntityBeSeen(Entity entity)
    {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ), Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ)) == null;
    }

    @Override
    public boolean attackEntityFrom(DamageSource ds, float damage)
    {
        this.hurtResistantTime = DZConfig.krakenHurtTimer;
        return super.attackEntityFrom(ds, damage);
    }

    @Override
    public boolean attackEntityAsMob(Entity mob)
    {
        if (pathToEntity != null) {
            this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, 16.0F, true, false, false, true);
        } else{
            if (attackerPosition != null) {
                attackerPosition.set((int) mob.posX, (int) mob.posY + 1, (int) mob.posZ);
            }

        }
        return super.attackEntityAsMob(mob);

    }

    @Override
    protected void attackEntity(Entity mob, float dist)
    {
        super.attackEntity(mob, dist);
        if (pathToEntity != null) {
            this.pathToEntity = this.worldObj.getPathEntityToEntity(this, this.entityToAttack, 16.0F, true, false, false, true);
        } else{
            if (attackerPosition != null) {
                attackerPosition.set((int) mob.posX, (int) mob.posY + 1, (int) mob.posZ);
            }

        }


    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.ticksExisted % 100 == 0 && !this.worldObj.isRemote)
        {
            WorldInfo worldInfo = worldObj.getWorldInfo();
            worldInfo.setRaining(true);
            worldInfo.setThundering(true);
            worldInfo.setRainTime(900);
            worldInfo.setThunderTime(900);
        }
    }

Item[] lootableList = new Item[]
{
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




    @Override
    protected void updateEntityActionState()
    {
        super.updateEntityActionState();
        if (this.worldObj.rand.nextInt(400) == 0)
        {
            EntityLightningBolt bolt = new EntityLightningBolt(this.worldObj, this.posX + randomOffset(), this.posY + randomOffsetY(), this.posZ + randomOffset());
            this.worldObj.addWeatherEffect(bolt);
        }

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




















}
