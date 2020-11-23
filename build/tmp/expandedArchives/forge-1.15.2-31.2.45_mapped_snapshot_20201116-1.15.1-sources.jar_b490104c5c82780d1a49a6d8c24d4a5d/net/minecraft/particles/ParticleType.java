package net.minecraft.particles;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ParticleType<T extends IParticleData> extends net.minecraftforge.registries.ForgeRegistryEntry<ParticleType<?>> {
   private final boolean alwaysShow;
   private final IParticleData.IDeserializer<T> deserializer;

   public ParticleType(boolean alwaysShowIn, IParticleData.IDeserializer<T> deserializerIn) {
      this.alwaysShow = alwaysShowIn;
      this.deserializer = deserializerIn;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean getAlwaysShow() {
      return this.alwaysShow;
   }

   public IParticleData.IDeserializer<T> getDeserializer() {
      return this.deserializer;
   }
}