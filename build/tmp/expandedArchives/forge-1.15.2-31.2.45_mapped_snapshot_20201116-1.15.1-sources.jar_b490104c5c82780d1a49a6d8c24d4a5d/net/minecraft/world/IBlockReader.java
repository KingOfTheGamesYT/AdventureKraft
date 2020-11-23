package net.minecraft.world;

import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;

public interface IBlockReader {
   @Nullable
   TileEntity getTileEntity(BlockPos pos);

   BlockState getBlockState(BlockPos pos);

   IFluidState getFluidState(BlockPos pos);

   default int getLightValue(BlockPos pos) {
      return this.getBlockState(pos).getLightValue(this, pos);
   }

   default int getMaxLightLevel() {
      return 15;
   }

   default int getHeight() {
      return 256;
   }

   default BlockRayTraceResult rayTraceBlocks(RayTraceContext context) {
      return doRayTrace(context, (p_217297_1_, p_217297_2_) -> {
         BlockState blockstate = this.getBlockState(p_217297_2_);
         IFluidState ifluidstate = this.getFluidState(p_217297_2_);
         Vec3d vec3d = p_217297_1_.getStartVec();
         Vec3d vec3d1 = p_217297_1_.getEndVec();
         VoxelShape voxelshape = p_217297_1_.getBlockShape(blockstate, this, p_217297_2_);
         BlockRayTraceResult blockraytraceresult = this.rayTraceBlocks(vec3d, vec3d1, p_217297_2_, voxelshape, blockstate);
         VoxelShape voxelshape1 = p_217297_1_.getFluidShape(ifluidstate, this, p_217297_2_);
         BlockRayTraceResult blockraytraceresult1 = voxelshape1.rayTrace(vec3d, vec3d1, p_217297_2_);
         double d0 = blockraytraceresult == null ? Double.MAX_VALUE : p_217297_1_.getStartVec().squareDistanceTo(blockraytraceresult.getHitVec());
         double d1 = blockraytraceresult1 == null ? Double.MAX_VALUE : p_217297_1_.getStartVec().squareDistanceTo(blockraytraceresult1.getHitVec());
         return d0 <= d1 ? blockraytraceresult : blockraytraceresult1;
      }, (p_217302_0_) -> {
         Vec3d vec3d = p_217302_0_.getStartVec().subtract(p_217302_0_.getEndVec());
         return BlockRayTraceResult.createMiss(p_217302_0_.getEndVec(), Direction.getFacingFromVector(vec3d.x, vec3d.y, vec3d.z), new BlockPos(p_217302_0_.getEndVec()));
      });
   }

   @Nullable
   default BlockRayTraceResult rayTraceBlocks(Vec3d startVec, Vec3d endVec, BlockPos pos, VoxelShape shape, BlockState state) {
      BlockRayTraceResult blockraytraceresult = shape.rayTrace(startVec, endVec, pos);
      if (blockraytraceresult != null) {
         BlockRayTraceResult blockraytraceresult1 = state.getRaytraceShape(this, pos).rayTrace(startVec, endVec, pos);
         if (blockraytraceresult1 != null && blockraytraceresult1.getHitVec().subtract(startVec).lengthSquared() < blockraytraceresult.getHitVec().subtract(startVec).lengthSquared()) {
            return blockraytraceresult.withFace(blockraytraceresult1.getFace());
         }
      }

      return blockraytraceresult;
   }

   static <T> T doRayTrace(RayTraceContext context, BiFunction<RayTraceContext, BlockPos, T> rayTracer, Function<RayTraceContext, T> missFactory) {
      Vec3d vec3d = context.getStartVec();
      Vec3d vec3d1 = context.getEndVec();
      if (vec3d.equals(vec3d1)) {
         return missFactory.apply(context);
      } else {
         double d0 = MathHelper.lerp(-1.0E-7D, vec3d1.x, vec3d.x);
         double d1 = MathHelper.lerp(-1.0E-7D, vec3d1.y, vec3d.y);
         double d2 = MathHelper.lerp(-1.0E-7D, vec3d1.z, vec3d.z);
         double d3 = MathHelper.lerp(-1.0E-7D, vec3d.x, vec3d1.x);
         double d4 = MathHelper.lerp(-1.0E-7D, vec3d.y, vec3d1.y);
         double d5 = MathHelper.lerp(-1.0E-7D, vec3d.z, vec3d1.z);
         int i = MathHelper.floor(d3);
         int j = MathHelper.floor(d4);
         int k = MathHelper.floor(d5);
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(i, j, k);
         T t = rayTracer.apply(context, blockpos$mutable);
         if (t != null) {
            return t;
         } else {
            double d6 = d0 - d3;
            double d7 = d1 - d4;
            double d8 = d2 - d5;
            int l = MathHelper.signum(d6);
            int i1 = MathHelper.signum(d7);
            int j1 = MathHelper.signum(d8);
            double d9 = l == 0 ? Double.MAX_VALUE : (double)l / d6;
            double d10 = i1 == 0 ? Double.MAX_VALUE : (double)i1 / d7;
            double d11 = j1 == 0 ? Double.MAX_VALUE : (double)j1 / d8;
            double d12 = d9 * (l > 0 ? 1.0D - MathHelper.frac(d3) : MathHelper.frac(d3));
            double d13 = d10 * (i1 > 0 ? 1.0D - MathHelper.frac(d4) : MathHelper.frac(d4));
            double d14 = d11 * (j1 > 0 ? 1.0D - MathHelper.frac(d5) : MathHelper.frac(d5));

            while(d12 <= 1.0D || d13 <= 1.0D || d14 <= 1.0D) {
               if (d12 < d13) {
                  if (d12 < d14) {
                     i += l;
                     d12 += d9;
                  } else {
                     k += j1;
                     d14 += d11;
                  }
               } else if (d13 < d14) {
                  j += i1;
                  d13 += d10;
               } else {
                  k += j1;
                  d14 += d11;
               }

               T t1 = rayTracer.apply(context, blockpos$mutable.setPos(i, j, k));
               if (t1 != null) {
                  return t1;
               }
            }

            return missFactory.apply(context);
         }
      }
   }
}