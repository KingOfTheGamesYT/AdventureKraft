package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public class AttackDamageEffect extends Effect {
   protected final double bonusPerLevel;

   protected AttackDamageEffect(EffectType type, int liquidColorIn, double bonusPerLevelIn) {
      super(type, liquidColorIn);
      this.bonusPerLevel = bonusPerLevelIn;
   }

   public double getAttributeModifierAmount(int amplifier, AttributeModifier modifier) {
      return this.bonusPerLevel * (double)(amplifier + 1);
   }
}
