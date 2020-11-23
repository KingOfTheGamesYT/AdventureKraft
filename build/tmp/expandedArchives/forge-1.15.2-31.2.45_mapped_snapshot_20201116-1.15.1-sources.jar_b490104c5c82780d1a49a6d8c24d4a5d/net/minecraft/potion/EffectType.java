package net.minecraft.potion;

import net.minecraft.util.text.TextFormatting;

public enum EffectType {
   BENEFICIAL(TextFormatting.BLUE),
   HARMFUL(TextFormatting.RED),
   NEUTRAL(TextFormatting.BLUE);

   private final TextFormatting color;

   private EffectType(TextFormatting colorIn) {
      this.color = colorIn;
   }

   public TextFormatting getColor() {
      return this.color;
   }
}
