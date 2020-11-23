package net.minecraft.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;

public class HealthBoostEffect extends Effect {
   public HealthBoostEffect(EffectType type, int liquidColorIn) {
      super(type, liquidColorIn);
   }

   public void removeAttributesModifiersFromEntity(LivingEntity entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
      super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
      if (entityLivingBaseIn.getHealth() > entityLivingBaseIn.getMaxHealth()) {
         entityLivingBaseIn.setHealth(entityLivingBaseIn.getMaxHealth());
      }

   }
}
