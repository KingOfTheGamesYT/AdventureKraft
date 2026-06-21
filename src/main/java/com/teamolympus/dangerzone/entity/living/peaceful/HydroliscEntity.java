package com.teamolympus.dangerzone.entity.living.peaceful;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.World;

public class HydroliscEntity extends EntityTameable {
    public HydroliscEntity(World p_i1604_1_) {
        super(p_i1604_1_);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return null;
    }
}
