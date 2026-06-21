package com.teamolympus.dangerzone.entity.ai;

import net.minecraft.entity.EntityCreature;
import com.teamolympus.dangerzone.entity.ai.base.DZAIAttackOnCollideBase;

public class DZAIAttackOnCollide extends DZAIAttackOnCollideBase {
    public DZAIAttackOnCollide(EntityCreature attacker, Class clazzTarget, double speedTowardsTarget, boolean remembers) {
        super(attacker, clazzTarget, speedTowardsTarget, remembers);
    }

    public DZAIAttackOnCollide(EntityCreature attacker, double speedTowardsTarget, boolean remembers) {
        super(attacker, speedTowardsTarget, remembers);
    }
}
