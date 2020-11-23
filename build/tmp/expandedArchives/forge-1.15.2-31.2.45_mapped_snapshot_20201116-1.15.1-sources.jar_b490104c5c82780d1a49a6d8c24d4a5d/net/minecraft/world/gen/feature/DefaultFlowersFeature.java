package net.minecraft.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class DefaultFlowersFeature extends FlowersFeature<BlockClusterFeatureConfig> {
   public DefaultFlowersFeature(Function<Dynamic<?>, ? extends BlockClusterFeatureConfig> p_i49889_1_) {
      super(p_i49889_1_);
   }

   public boolean isValidPosition(IWorld worldIn, BlockPos pos, BlockClusterFeatureConfig config) {
      return !config.blacklist.contains(worldIn.getBlockState(pos));
   }

   public int getFlowerCount(BlockClusterFeatureConfig config) {
      return config.tryCount;
   }

   public BlockPos getNearbyPos(Random rand, BlockPos pos, BlockClusterFeatureConfig config) {
      return pos.add(rand.nextInt(config.xSpread) - rand.nextInt(config.xSpread), rand.nextInt(config.ySpread) - rand.nextInt(config.ySpread), rand.nextInt(config.zSpread) - rand.nextInt(config.zSpread));
   }

   public BlockState getFlowerToPlace(Random rand, BlockPos pos, BlockClusterFeatureConfig confgi) {
      return confgi.stateProvider.getBlockState(rand, pos);
   }
}
