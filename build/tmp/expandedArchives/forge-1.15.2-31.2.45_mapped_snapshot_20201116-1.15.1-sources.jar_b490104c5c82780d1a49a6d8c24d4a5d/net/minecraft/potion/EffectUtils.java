package net.minecraft.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class EffectUtils {
   @OnlyIn(Dist.CLIENT)
   public static String getPotionDurationString(EffectInstance effect, float durationFactor) {
      if (effect.getIsPotionDurationMax()) {
         return "**:**";
      } else {
         int i = MathHelper.floor((float)effect.getDuration() * durationFactor);
         return StringUtils.ticksToElapsedTime(i);
      }
   }

   public static boolean hasMiningSpeedup(LivingEntity entityIn) {
      return entityIn.isPotionActive(Effects.HASTE) || entityIn.isPotionActive(Effects.CONDUIT_POWER);
   }

   public static int getMiningSpeedup(LivingEntity entityIn) {
      int i = 0;
      int j = 0;
      if (entityIn.isPotionActive(Effects.HASTE)) {
         i = entityIn.getActivePotionEffect(Effects.HASTE).getAmplifier();
      }

      if (entityIn.isPotionActive(Effects.CONDUIT_POWER)) {
         j = entityIn.getActivePotionEffect(Effects.CONDUIT_POWER).getAmplifier();
      }

      return Math.max(i, j);
   }

   public static boolean canBreatheUnderwater(LivingEntity entityIn) {
      return entityIn.isPotionActive(Effects.WATER_BREATHING) || entityIn.isPotionActive(Effects.CONDUIT_POWER);
   }
}
