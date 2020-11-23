package net.minecraft.client.audio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.sound.sampled.AudioFormat;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.openal.AL10;

@OnlyIn(Dist.CLIENT)
public class SoundSource {
   private static final Logger LOGGER = LogManager.getLogger();
   private final int id;
   private final AtomicBoolean playing = new AtomicBoolean(true);
   private int field_216443_d = 16384;
   @Nullable
   private IAudioStream field_216444_e;

   @Nullable
   static SoundSource allocateNewSource() {
      int[] aint = new int[1];
      AL10.alGenSources(aint);
      return ALUtils.checkALError("Allocate new source") ? null : new SoundSource(aint[0]);
   }

   private SoundSource(int p_i51178_1_) {
      this.id = p_i51178_1_;
   }

   public void close() {
      if (this.playing.compareAndSet(true, false)) {
         AL10.alSourceStop(this.id);
         ALUtils.checkALError("Stop");
         if (this.field_216444_e != null) {
            try {
               this.field_216444_e.close();
            } catch (IOException ioexception) {
               LOGGER.error("Failed to close audio stream", (Throwable)ioexception);
            }

            this.removeProcessedBuffers();
            this.field_216444_e = null;
         }

         AL10.alDeleteSources(new int[]{this.id});
         ALUtils.checkALError("Cleanup");
      }

   }

   public void play() {
      AL10.alSourcePlay(this.id);
   }

   private int getState() {
      return !this.playing.get() ? 4116 : AL10.alGetSourcei(this.id, 4112);
   }

   public void pause() {
      if (this.getState() == 4114) {
         AL10.alSourcePause(this.id);
      }

   }

   public void resume() {
      if (this.getState() == 4115) {
         AL10.alSourcePlay(this.id);
      }

   }

   public void stop() {
      if (this.playing.get()) {
         AL10.alSourceStop(this.id);
         ALUtils.checkALError("Stop");
      }

   }

   public boolean isStopped() {
      return this.getState() == 4116;
   }

   public void updateSource(Vec3d p_216420_1_) {
      AL10.alSourcefv(this.id, 4100, new float[]{(float)p_216420_1_.x, (float)p_216420_1_.y, (float)p_216420_1_.z});
   }

   public void setPitch(float p_216422_1_) {
      AL10.alSourcef(this.id, 4099, p_216422_1_);
   }

   public void setLooping(boolean p_216425_1_) {
      AL10.alSourcei(this.id, 4103, p_216425_1_ ? 1 : 0);
   }

   public void setGain(float p_216430_1_) {
      AL10.alSourcef(this.id, 4106, p_216430_1_);
   }

   public void setNoAttenuation() {
      AL10.alSourcei(this.id, 53248, 0);
   }

   public void setLinearAttenuation(float p_216423_1_) {
      AL10.alSourcei(this.id, 53248, 53251);
      AL10.alSourcef(this.id, 4131, p_216423_1_);
      AL10.alSourcef(this.id, 4129, 1.0F);
      AL10.alSourcef(this.id, 4128, 0.0F);
   }

   public void setRelative(boolean p_216432_1_) {
      AL10.alSourcei(this.id, 514, p_216432_1_ ? 1 : 0);
   }

   public void func_216429_a(AudioStreamBuffer p_216429_1_) {
      p_216429_1_.getBuffer().ifPresent((p_216431_1_) -> {
         AL10.alSourcei(this.id, 4105, p_216431_1_);
      });
   }

   public void func_216433_a(IAudioStream p_216433_1_) {
      this.field_216444_e = p_216433_1_;
      AudioFormat audioformat = p_216433_1_.getAudioFormat();
      this.field_216443_d = func_216417_a(audioformat, 1);
      this.func_216421_a(4);
   }

   private static int func_216417_a(AudioFormat p_216417_0_, int p_216417_1_) {
      return (int)((float)(p_216417_1_ * p_216417_0_.getSampleSizeInBits()) / 8.0F * (float)p_216417_0_.getChannels() * p_216417_0_.getSampleRate());
   }

   private void func_216421_a(int p_216421_1_) {
      if (this.field_216444_e != null) {
         try {
            for(int i = 0; i < p_216421_1_; ++i) {
               ByteBuffer bytebuffer = this.field_216444_e.func_216455_a(this.field_216443_d);
               if (bytebuffer != null) {
                  (new AudioStreamBuffer(bytebuffer, this.field_216444_e.getAudioFormat())).getUntrackedBuffer().ifPresent((p_216424_1_) -> {
                     AL10.alSourceQueueBuffers(this.id, new int[]{p_216424_1_});
                  });
               }
            }
         } catch (IOException ioexception) {
            LOGGER.error("Failed to read from audio stream", (Throwable)ioexception);
         }
      }

   }

   public void tick() {
      if (this.field_216444_e != null) {
         int i = this.removeProcessedBuffers();
         this.func_216421_a(i);
      }

   }

   private int removeProcessedBuffers() {
      int i = AL10.alGetSourcei(this.id, 4118);
      if (i > 0) {
         int[] aint = new int[i];
         AL10.alSourceUnqueueBuffers(this.id, aint);
         ALUtils.checkALError("Unqueue buffers");
         AL10.alDeleteBuffers(aint);
         ALUtils.checkALError("Remove processed buffers");
      }

      return i;
   }
}
