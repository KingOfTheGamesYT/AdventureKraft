package net.minecraft.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class ConfiguredCarver<WC extends ICarverConfig> {
   public final WorldCarver<WC> carver;
   public final WC config;

   public ConfiguredCarver(WorldCarver<WC> carverIn, WC configIn) {
      this.carver = carverIn;
      this.config = configIn;
   }

   public boolean shouldCarve(Random rand, int chunkX, int chunkZ) {
      return this.carver.shouldCarve(rand, chunkX, chunkZ, this.config);
   }

   /**
    * Creates a region used by the carver.
    *  
    * @param chunkXOffset Returns the x chunk coordinate for each of the surrounding chunks in a 16 x 16 square.
    * Multiply this by 16 to get the real x coordinate.
    */
   public boolean carveRegion(IChunk chunkIn, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet carvingMask) {
      return this.carver.carveRegion(chunkIn, biomePos, rand, seaLevel, chunkXOffset, chunkZOffset, chunkX, chunkZ, carvingMask, this.config);
   }
}
