package net.minecraft.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

public abstract class FlowersFeature<U extends IFeatureConfig> extends Feature<U> {
   public FlowersFeature(Function<Dynamic<?>, ? extends U> deserializer) {
      super(deserializer);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, U config) {
      BlockState blockstate = this.getFlowerToPlace(rand, pos, config);
      int i = 0;

      for(int j = 0; j < this.getFlowerCount(config); ++j) {
         BlockPos blockpos = this.getNearbyPos(rand, pos, config);
         if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getMaxHeight() - 1 && blockstate.isValidPosition(worldIn, blockpos) && this.isValidPosition(worldIn, blockpos, config)) {
            worldIn.setBlockState(blockpos, blockstate, 2);
            ++i;
         }
      }

      return i > 0;
   }

   public abstract boolean isValidPosition(IWorld worldIn, BlockPos pos, U config);

   public abstract int getFlowerCount(U config);

   public abstract BlockPos getNearbyPos(Random rand, BlockPos pos, U config);

   public abstract BlockState getFlowerToPlace(Random rand, BlockPos pos, U confgi);
}