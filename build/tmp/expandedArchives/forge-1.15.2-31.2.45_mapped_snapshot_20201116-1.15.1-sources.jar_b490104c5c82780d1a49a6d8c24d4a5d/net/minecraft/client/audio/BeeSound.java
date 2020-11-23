package net.minecraft.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class BeeSound extends TickableSound {
   protected final BeeEntity beeInstance;
   private boolean hasSwitchedSound;

   public BeeSound(BeeEntity entityIn, SoundEvent eventIn, SoundCategory categoryIn) {
      super(eventIn, categoryIn);
      this.beeInstance = entityIn;
      this.x = (float)entityIn.getPosX();
      this.y = (float)entityIn.getPosY();
      this.z = (float)entityIn.getPosZ();
      this.repeat = true;
      this.repeatDelay = 0;
      this.volume = 0.0F;
   }

   public void tick() {
      boolean flag = this.shouldSwitchSound();
      if (flag && !this.donePlaying) {
         Minecraft.getInstance().getSoundHandler().playOnNextTick(this.getNextSound());
         this.hasSwitchedSound = true;
      }

      if (!this.beeInstance.removed && !this.hasSwitchedSound) {
         this.x = (float)this.beeInstance.getPosX();
         this.y = (float)this.beeInstance.getPosY();
         this.z = (float)this.beeInstance.getPosZ();
         float f = MathHelper.sqrt(Entity.horizontalMag(this.beeInstance.getMotion()));
         if ((double)f >= 0.01D) {
            this.pitch = MathHelper.lerp(MathHelper.clamp(f, this.getMinPitch(), this.getMaxPitch()), this.getMinPitch(), this.getMaxPitch());
            this.volume = MathHelper.lerp(MathHelper.clamp(f, 0.0F, 0.5F), 0.0F, 1.2F);
         } else {
            this.pitch = 0.0F;
            this.volume = 0.0F;
         }

      } else {
         this.donePlaying = true;
      }
   }

   private float getMinPitch() {
      return this.beeInstance.isChild() ? 1.1F : 0.7F;
   }

   private float getMaxPitch() {
      return this.beeInstance.isChild() ? 1.5F : 1.1F;
   }

   public boolean canBeSilent() {
      return true;
   }

   protected abstract TickableSound getNextSound();

   protected abstract boolean shouldSwitchSound();
}
