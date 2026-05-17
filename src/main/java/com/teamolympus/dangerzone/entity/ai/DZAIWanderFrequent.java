package com.teamolympus.dangerzone.entity.ai;

import com.teamolympus.dangerzone.entity.ai.base.DZAIWanderFrequentBase;
import net.minecraft.entity.EntityCreature;

public class DZAIWanderFrequent extends DZAIWanderFrequentBase {

    public DZAIWanderFrequent(EntityCreature mob, double speed, int xzSearch) {
        super(mob, speed, xzSearch, 30);
    }

    public DZAIWanderFrequent(EntityCreature mob, double speed) {
        super(mob, speed, 10, 90);
    }
}
