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

public class CaveWorldCarver extends WorldCarver<ProbabilityConfig> {
   public CaveWorldCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> configIn, int maxHeightIn) {
      super(configIn, maxHeightIn);
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
      int j = rand.nextInt(rand.nextInt(rand.nextInt(this.func_222724_a()) + 1) + 1);

      for(int k = 0; k < j; ++k) {
         double d0 = (double)(chunkXOffset * 16 + rand.nextInt(16));
         double d1 = (double)this.generateCaveStartY(rand);
         double d2 = (double)(chunkZOffset * 16 + rand.nextInt(16));
         int l = 1;
         if (rand.nextInt(4) == 0) {
            double d3 = 0.5D;
            float f1 = 1.0F + rand.nextFloat() * 6.0F;
            this.func_227205_a_(chunkIn, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f1, 0.5D, carvingMask);
            l += rand.nextInt(4);
         }

         for(int k1 = 0; k1 < l; ++k1) {
            float f = rand.nextFloat() * ((float)Math.PI * 2F);
            float f3 = (rand.nextFloat() - 0.5F) / 4.0F;
            float f2 = this.generateCaveRadius(rand);
            int i1 = i - rand.nextInt(i / 4);
            int j1 = 0;
            this.func_227206_a_(chunkIn, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f2, f, f3, 0, i1, this.func_222725_b(), carvingMask);
         }
      }

      return true;
   }

   protected int func_222724_a() {
      return 15;
   }

   protected float generateCaveRadius(Random rand) {
      float f = rand.nextFloat() * 2.0F + rand.nextFloat();
      if (rand.nextInt(10) == 0) {
         f *= rand.nextFloat() * rand.nextFloat() * 3.0F + 1.0F;
      }

      return f;
   }

   protected double func_222725_b() {
      return 1.0D;
   }

   protected int generateCaveStartY(Random rand) {
      return rand.nextInt(rand.nextInt(120) + 8);
   }

   protected void func_227205_a_(IChunk p_227205_1_, Function<BlockPos, Biome> p_227205_2_, long p_227205_3_, int seaLevel, int chunkX, int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, float p_227205_14_, double p_227205_15_, BitSet carvingMask) {
      double d0 = 1.5D + (double)(MathHelper.sin(((float)Math.PI / 2F)) * p_227205_14_);
      double d1 = d0 * p_227205_15_;
      this.func_227208_a_(p_227205_1_, p_227205_2_, p_227205_3_, seaLevel, chunkX, chunkZ, randOffsetXCoord + 1.0D, startY, randOffsetZCoord, d0, d1, carvingMask);
   }

   protected void func_227206_a_(IChunk chunkIn, Function<BlockPos, Biome> biomePos, long seed, int seaLevel, int chunkX, int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, float caveRadius, float pitch, float p_227206_16_, int p_227206_17_, int p_227206_18_, double p_227206_19_, BitSet p_227206_21_) {
      Random random = new Random(seed);
      int i = random.nextInt(p_227206_18_ / 2) + p_227206_18_ / 4;
      boolean flag = random.nextInt(6) == 0;
      float f = 0.0F;
      float f1 = 0.0F;

      for(int j = p_227206_17_; j < p_227206_18_; ++j) {
         double d0 = 1.5D + (double)(MathHelper.sin((float)Math.PI * (float)j / (float)p_227206_18_) * caveRadius);
         double d1 = d0 * p_227206_19_;
         float f2 = MathHelper.cos(p_227206_16_);
         randOffsetXCoord += (double)(MathHelper.cos(pitch) * f2);
         startY += (double)MathHelper.sin(p_227206_16_);
         randOffsetZCoord += (double)(MathHelper.sin(pitch) * f2);
         p_227206_16_ = p_227206_16_ * (flag ? 0.92F : 0.7F);
         p_227206_16_ = p_227206_16_ + f1 * 0.1F;
         pitch += f * 0.1F;
         f1 = f1 * 0.9F;
         f = f * 0.75F;
         f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
         f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
         if (j == i && caveRadius > 1.0F) {
            this.func_227206_a_(chunkIn, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * 0.5F + 0.5F, pitch - ((float)Math.PI / 2F), p_227206_16_ / 3.0F, j, p_227206_18_, 1.0D, p_227206_21_);
            this.func_227206_a_(chunkIn, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * 0.5F + 0.5F, pitch + ((float)Math.PI / 2F), p_227206_16_ / 3.0F, j, p_227206_18_, 1.0D, p_227206_21_);
            return;
         }

         if (random.nextInt(4) != 0) {
            if (!this.isInRange(chunkX, chunkZ, randOffsetXCoord, randOffsetZCoord, j, p_227206_18_, caveRadius)) {
               return;
            }

            this.func_227208_a_(chunkIn, biomePos, seed, seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, d0, d1, p_227206_21_);
         }
      }

   }

   protected boolean func_222708_a(double x, double y, double z, int actualY) {
      return y <= -0.7D || x * x + y * y + z * z >= 1.0D;
   }
}
