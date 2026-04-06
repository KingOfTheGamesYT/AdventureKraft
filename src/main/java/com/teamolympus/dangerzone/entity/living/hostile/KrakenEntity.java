package com.teamolympus.dangerzone.entity.living.hostile;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class KrakenEntity extends EntityMob {

    public KrakenEntity(World world) {
        super(world);
    }

    public void onUpdate() {
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
}
