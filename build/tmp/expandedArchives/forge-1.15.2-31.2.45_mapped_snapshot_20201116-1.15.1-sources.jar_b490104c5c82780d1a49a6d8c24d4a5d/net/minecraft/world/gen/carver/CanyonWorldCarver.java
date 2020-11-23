package net.minecraft.world.gen.carver;

import com.mojang.datafixers.Dynamic;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class CanyonWorldCarver extends WorldCarver<ProbabilityConfig> {
   private final float[] heightWidthStrechFactor = new float[1024];

   public CanyonWorldCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49930_1_) {
      super(p_i49930_1_, 256);
   }

   public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
      return rand.nextFloat() <= config.probability;
   }

   /**
    * Creates a region used by the carver.
    *  
    * @param biomePos Returns the biome for a given block position.
    * @param seaLevel Returns the sea level value assigned to the chunk generator.
    * @param chunkXOffset Returns the x chunk coordinate for each of the surrounding chunks in a 16 x 16 square.
    * Multiply this by 16 to get the real x coordinate.
    * @param chunkZOffset Returns the z chunk coordinate for each of the surrounding chunks in a 16 x 16 square.
    * Multiply this by 16 to get the real z coordinate.
    * @param chunkX Returns the x chunk coordinate for this chunk. Multiply this by 16 to get the real x coordinate.
    * @param chunkZ Returns the z chunk coordinate for this chunk. Multiply this by 16 to get the real z coordinate.
    * @param carvingMask Tracks which blocks are carved.
    */
   public boolean carveRegion(IChunk chunkIn, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet carvingMask, ProbabilityConfig configIn) {
      int i = (this.getRandomNumber() * 2 - 1) * 16;
      double d0 = (double)(chunkXOffset * 16 + rand.nextInt(16));
      double d1 = (double)(rand.nextInt(rand.nextInt(40) + 8) + 20);
      double d2 = (double)(chunkZOffset * 16 + rand.nextInt(16));
      float f = rand.nextFloat() * ((float)Math.PI * 2F);
      float f1 = (rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
      double d3 = 3.0D;
      float f2 = (rand.nextFloat() * 2.0F + rand.nextFloat()) * 2.0F;
      int j = i - rand.nextInt(i / 4);
      int k = 0;
      this.carveRegion(chunkIn, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f2, f, f1, 0, j, 3.0D, carvingMask);
      return true;
   }

   private void carveRegion(IChunk chunkIn, Function<BlockPos, Biome> biomeAccess, long seed, int seaLevel, int mainChunkZ, int p_227204_7_, double p_227204_8_, double p_227204_10_, double p_227204_12_, float p_227204_14_, float p_227204_15_, float p_227204_16_, int p_227204_17_, int p_227204_18_, double p_227204_19_, BitSet p_227204_21_) {
      Random random = new Random(seed);
      float f = 1.0F;

      for(int i = 0; i < 256; ++i) {
         if (i == 0 || random.nextInt(3) == 0) {
            f = 1.0F + random.nextFloat() * random.nextFloat();
         }

         this.heightWidthStrechFactor[i] = f * f;
      }

      float f4 = 0.0F;
      float f1 = 0.0F;

      for(int j = p_227204_17_; j < p_227204_18_; ++j) {
         double d0 = 1.5D + (double)(MathHelper.sin((float)j * (float)Math.PI / (float)p_227204_18_) * p_227204_14_);
         double d1 = d0 * p_227204_19_;
         d0 = d0 * ((double)random.nextFloat() * 0.25D + 0.75D);
         d1 = d1 * ((double)random.nextFloat() * 0.25D + 0.75D);
         float f2 = MathHelper.cos(p_227204_16_);
         float f3 = MathHelper.sin(p_227204_16_);
         p_227204_8_ += (double)(MathHelper.cos(p_227204_15_) * f2);
         p_227204_10_ += (double)f3;
         p_227204_12_ += (double)(MathHelper.sin(p_227204_15_) * f2);
         p_227204_16_ = p_227204_16_ * 0.7F;
         p_227204_16_ = p_227204_16_ + f1 * 0.05F;
         p_227204_15_ += f4 * 0.05F;
         f1 = f1 * 0.8F;
         f4 = f4 * 0.5F;
         f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
         f4 = f4 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
         if (random.nextInt(4) != 0) {
            if (!this.isInRange(mainChunkZ, p_227204_7_, p_227204_8_, p_227204_12_, j, p_227204_18_, p_227204_14_)) {
               return;
            }

            this.func_227208_a_(chunkIn, biomeAccess, seed, seaLevel, mainChunkZ, p_227204_7_, p_227204_8_, p_227204_10_, p_227204_12_, d0, d1, p_227204_21_);
         }
      }

   }

   protected boolean func_222708_a(double x, double y, double z, int actualY) {
      return (x * x + z * z) * (double)this.heightWidthStrechFactor[actualY - 1] + y * y / 6.0D >= 1.0D;
   }
}
