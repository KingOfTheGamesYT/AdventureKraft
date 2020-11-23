package net.minecraft.client.audio;

import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeeFlightSound extends BeeSound {
   public BeeFlightSound(BeeEntity entityIn) {
      super(entityIn, SoundEvents.ENTITY_BEE_LOOP, SoundCategory.NEUTRAL);
   }

   protected TickableSound getNextSound() {
      return new BeeAngrySound(this.beeInstance);
   }

   protected boolean shouldSwitchSound() {
      return this.beeInstance.isAngry();
   }
}
