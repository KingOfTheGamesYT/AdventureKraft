package net.minecraft.block;

import java.util.Random;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

public abstract class SpreadableSnowyDirtBlock extends SnowyDirtBlock {
   protected SpreadableSnowyDirtBlock(Block.Properties builder) {
      super(builder);
   }

   private static boolean func_220257_b(BlockState state, IWorldReader worldReader, BlockPos pos) {
      BlockPos blockpos = pos.up();
      BlockState blockstate = worldReader.getBlockState(blockpos);
      if (blockstate.getBlock() == Blocks.SNOW && blockstate.get(SnowBlock.LAYERS) == 1) {
         return true;
      } else {
         int i = LightEngine.func_215613_a(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
         return i < worldReader.getMaxLightLevel();
      }
   }

   private static boolean func_220256_c(BlockState state, IWorldReader worldReader, BlockPos pos) {
      BlockPos blockpos = pos.up();
      return func_220257_b(state, worldReader, pos) && !worldReader.getFluidState(blockpos).isTagged(FluidTags.WATER);
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      if (!func_220257_b(state, worldIn, pos)) {
         if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
         worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
      } else {
         if (worldIn.getLight(pos.up()) >= 9) {
            BlockState blockstate = this.getDefaultState();

            for(int i = 0; i < 4; ++i) {
               BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
               if (worldIn.getBlockState(blockpos).getBlock() == Blocks.DIRT && func_220256_c(blockstate, worldIn, blockpos)) {
                  worldIn.setBlockState(blockpos, blockstate.with(SNOWY, Boolean.valueOf(worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.SNOW)));
               }
            }
         }

      }
   }
}