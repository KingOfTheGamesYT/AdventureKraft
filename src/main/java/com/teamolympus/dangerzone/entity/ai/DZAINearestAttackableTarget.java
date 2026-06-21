package com.teamolympus.dangerzone.entity.ai;

import com.teamolympus.dangerzone.entity.ai.base.DZAINearestAttackableTargetBase;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;

public class DZAINearestAttackableTarget extends DZAINearestAttackableTargetBase {
    public DZAINearestAttackableTarget(EntityCreature p_i1663_1_, Class p_i1663_2_, int p_i1663_3_, boolean p_i1663_4_) {
        super(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_);
    }

    public DZAINearestAttackableTarget(EntityCreature p_i1664_1_, Class p_i1664_2_, int p_i1664_3_, boolean p_i1664_4_, boolean p_i1664_5_) {
        super(p_i1664_1_, p_i1664_2_, p_i1664_3_, p_i1664_4_, p_i1664_5_);
    }

    public DZAINearestAttackableTarget(EntityCreature p_i1665_1_, Class p_i1665_2_, int p_i1665_3_, boolean p_i1665_4_, boolean p_i1665_5_, IEntitySelector p_i1665_6_) {
        super(p_i1665_1_, p_i1665_2_, p_i1665_3_, p_i1665_4_, p_i1665_5_, p_i1665_6_);
    }
}
