package net.minecraft.pathfinding;

import javax.annotation.Nullable;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Region;

public class WalkAndSwimNodeProcessor extends WalkNodeProcessor {
   private float field_203247_k;
   private float field_203248_l;

   /**
    * clears the point map and sets world and entity
    */
   public void setup(Region worldIn, MobEntity mobEntityIn) {
      super.setup(worldIn, mobEntityIn);
      mobEntityIn.setPathPriority(PathNodeType.WATER, 0.0F);
      this.field_203247_k = mobEntityIn.getPathPriority(PathNodeType.WALKABLE);
      mobEntityIn.setPathPriority(PathNodeType.WALKABLE, 6.0F);
      this.field_203248_l = mobEntityIn.getPathPriority(PathNodeType.WATER_BORDER);
      mobEntityIn.setPathPriority(PathNodeType.WATER_BORDER, 4.0F);
   }

   /**
    * This method is called when all nodes have been processed and PathEntity is created.
    * {@link net.minecraft.world.pathfinder.WalkNodeProcessor WalkNodeProcessor} uses this to change its field {@link
    * net.minecraft.world.pathfinder.WalkNodeProcessor#avoidsWater avoidsWater}
    */
   public void postProcess() {
      this.entity.setPathPriority(PathNodeType.WALKABLE, this.field_203247_k);
      this.entity.setPathPriority(PathNodeType.WATER_BORDER, this.field_203248_l);
      super.postProcess();
   }

   public PathPoint getStart() {
      return this.openPoint(MathHelper.floor(this.entity.getBoundingBox().minX), MathHelper.floor(this.entity.getBoundingBox().minY + 0.5D), MathHelper.floor(this.entity.getBoundingBox().minZ));
   }

   /**
    * opens a flagged path point at the specified coordinates and returns it
    */
   public FlaggedPathPoint openFlaggedPathPoint(double x, double y, double z) {
      return new FlaggedPathPoint(this.openPoint(MathHelper.floor(x), MathHelper.floor(y + 0.5D), MathHelper.floor(z)));
   }

   public int calculatePathOptions(PathPoint[] pathOptions, PathPoint fromPoint) {
      int i = 0;
      int j = 1;
      BlockPos blockpos = new BlockPos(fromPoint.x, fromPoint.y, fromPoint.z);
      double d0 = this.getFeetY(blockpos);
      PathPoint pathpoint = this.getSafePoint(fromPoint.x, fromPoint.y, fromPoint.z + 1, 1, d0);
      PathPoint pathpoint1 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z, 1, d0);
      PathPoint pathpoint2 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z, 1, d0);
      PathPoint pathpoint3 = this.getSafePoint(fromPoint.x, fromPoint.y, fromPoint.z - 1, 1, d0);
      PathPoint pathpoint4 = this.getSafePoint(fromPoint.x, fromPoint.y + 1, fromPoint.z, 0, d0);
      PathPoint pathpoint5 = this.getSafePoint(fromPoint.x, fromPoint.y - 1, fromPoint.z, 1, d0);
      if (pathpoint != null && !pathpoint.visited) {
         pathOptions[i++] = pathpoint;
      }

      if (pathpoint1 != null && !pathpoint1.visited) {
         pathOptions[i++] = pathpoint1;
      }

      if (pathpoint2 != null && !pathpoint2.visited) {
         pathOptions[i++] = pathpoint2;
      }

      if (pathpoint3 != null && !pathpoint3.visited) {
         pathOptions[i++] = pathpoint3;
      }

      if (pathpoint4 != null && !pathpoint4.visited) {
         pathOptions[i++] = pathpoint4;
      }

      if (pathpoint5 != null && !pathpoint5.visited) {
         pathOptions[i++] = pathpoint5;
      }

      boolean flag = pathpoint3 == null || pathpoint3.nodeType == PathNodeType.OPEN || pathpoint3.costMalus != 0.0F;
      boolean flag1 = pathpoint == null || pathpoint.nodeType == PathNodeType.OPEN || pathpoint.costMalus != 0.0F;
      boolean flag2 = pathpoint2 == null || pathpoint2.nodeType == PathNodeType.OPEN || pathpoint2.costMalus != 0.0F;
      boolean flag3 = pathpoint1 == null || pathpoint1.nodeType == PathNodeType.OPEN || pathpoint1.costMalus != 0.0F;
      if (flag && flag3) {
         PathPoint pathpoint6 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z - 1, 1, d0);
         if (pathpoint6 != null && !pathpoint6.visited) {
            pathOptions[i++] = pathpoint6;
         }
      }

      if (flag && flag2) {
         PathPoint pathpoint7 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z - 1, 1, d0);
         if (pathpoint7 != null && !pathpoint7.visited) {
            pathOptions[i++] = pathpoint7;
         }
      }

      if (flag1 && flag3) {
         PathPoint pathpoint8 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z + 1, 1, d0);
         if (pathpoint8 != null && !pathpoint8.visited) {
            pathOptions[i++] = pathpoint8;
         }
      }

      if (flag1 && flag2) {
         PathPoint pathpoint9 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z + 1, 1, d0);
         if (pathpoint9 != null && !pathpoint9.visited) {
            pathOptions[i++] = pathpoint9;
         }
      }

      return i;
   }

   /**
    * returns the exact Y coordinate of pos taking block shapes into account
    */
   private double getFeetY(BlockPos pos) {
      if (!this.entity.isInWater()) {
         BlockPos blockpos = pos.down();
         VoxelShape voxelshape = this.blockaccess.getBlockState(blockpos).getCollisionShape(this.blockaccess, blockpos);
         return (double)blockpos.getY() + (voxelshape.isEmpty() ? 0.0D : voxelshape.getEnd(Direction.Axis.Y));
      } else {
         return (double)pos.getY() + 0.5D;
      }
   }

   /**
    * returns a path point which the entity can move to
    */
   @Nullable
   private PathPoint getSafePoint(int x, int y, int z, int upwardsIterations, double adjacentFeetY) {
      PathPoint pathpoint = null;
      BlockPos blockpos = new BlockPos(x, y, z);
      double d0 = this.getFeetY(blockpos);
      if (d0 - adjacentFeetY > 1.125D) {
         return null;
      } else {
         PathNodeType pathnodetype = this.getPathNodeType(this.blockaccess, x, y, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
         float f = this.entity.getPathPriority(pathnodetype);
         double d1 = (double)this.entity.getWidth() / 2.0D;
         if (f >= 0.0F) {
            pathpoint = this.openPoint(x, y, z);
            pathpoint.nodeType = pathnodetype;
            pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
         }

         if (pathnodetype != PathNodeType.WATER && pathnodetype != PathNodeType.WALKABLE) {
            if (pathpoint == null && upwardsIterations > 0 && pathnodetype != PathNodeType.FENCE && pathnodetype != PathNodeType.TRAPDOOR) {
               pathpoint = this.getSafePoint(x, y + 1, z, upwardsIterations - 1, adjacentFeetY);
            }

            if (pathnodetype == PathNodeType.OPEN) {
               AxisAlignedBB axisalignedbb = new AxisAlignedBB((double)x - d1 + 0.5D, (double)y + 0.001D, (double)z - d1 + 0.5D, (double)x + d1 + 0.5D, (double)((float)y + this.entity.getHeight()), (double)z + d1 + 0.5D);
               if (!this.entity.world.hasNoCollisions(this.entity, axisalignedbb)) {
                  return null;
               }

               PathNodeType pathnodetype1 = this.getPathNodeType(this.blockaccess, x, y - 1, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
               if (pathnodetype1 == PathNodeType.BLOCKED) {
                  pathpoint = this.openPoint(x, y, z);
                  pathpoint.nodeType = PathNodeType.WALKABLE;
                  pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                  return pathpoint;
               }

               if (pathnodetype1 == PathNodeType.WATER) {
                  pathpoint = this.openPoint(x, y, z);
                  pathpoint.nodeType = PathNodeType.WATER;
                  pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                  return pathpoint;
               }

               int i = 0;

               while(y > 0 && pathnodetype == PathNodeType.OPEN) {
                  --y;
                  if (i++ >= this.entity.getMaxFallHeight()) {
                     return null;
                  }

                  pathnodetype = this.getPathNodeType(this.blockaccess, x, y, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
                  f = this.entity.getPathPriority(pathnodetype);
                  if (pathnodetype != PathNodeType.OPEN && f >= 0.0F) {
                     pathpoint = this.openPoint(x, y, z);
                     pathpoint.nodeType = pathnodetype;
                     pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                     break;
                  }

                  if (f < 0.0F) {
                     return null;
                  }
               }
            }

            return pathpoint;
         } else {
            if (y < this.entity.world.getSeaLevel() - 10 && pathpoint != null) {
               ++pathpoint.costMalus;
            }

            return pathpoint;
         }
      }
   }

   /**
    * returns the exact path node type according to abilities and settings
    */
   protected PathNodeType getSpecificPathNodeType(IBlockReader worldIn, boolean canOpenDoorsIn, boolean canEnterDoorsIn, BlockPos pos, PathNodeType nodeType) {
      if (nodeType == PathNodeType.RAIL && !(worldIn.getBlockState(pos).getBlock() instanceof AbstractRailBlock) && !(worldIn.getBlockState(pos.down()).getBlock() instanceof AbstractRailBlock)) {
         nodeType = PathNodeType.FENCE;
      }

      if (nodeType == PathNodeType.DOOR_OPEN || nodeType == PathNodeType.DOOR_WOOD_CLOSED || nodeType == PathNodeType.DOOR_IRON_CLOSED) {
         nodeType = PathNodeType.BLOCKED;
      }

      if (nodeType == PathNodeType.LEAVES) {
         nodeType = PathNodeType.BLOCKED;
      }

      return nodeType;
   }

   public PathNodeType getPathNodeType(IBlockReader blockaccessIn, int x, int y, int z) {
      PathNodeType pathnodetype = getPathNodeTypeRaw(blockaccessIn, x, y, z);
      if (pathnodetype == PathNodeType.WATER) {
         for(Direction direction : Direction.values()) {
            PathNodeType pathnodetype2 = getPathNodeTypeRaw(blockaccessIn, x + direction.getXOffset(), y + direction.getYOffset(), z + direction.getZOffset());
            if (pathnodetype2 == PathNodeType.BLOCKED) {
               return PathNodeType.WATER_BORDER;
            }
         }

         return PathNodeType.WATER;
      } else {
         if (pathnodetype == PathNodeType.OPEN && y >= 1) {
            Block block = blockaccessIn.getBlockState(new BlockPos(x, y - 1, z)).getBlock();
            PathNodeType pathnodetype1 = getPathNodeTypeRaw(blockaccessIn, x, y - 1, z);
            if (pathnodetype1 != PathNodeType.WALKABLE && pathnodetype1 != PathNodeType.OPEN && pathnodetype1 != PathNodeType.LAVA) {
               pathnodetype = PathNodeType.WALKABLE;
            } else {
               pathnodetype = PathNodeType.OPEN;
            }

            if (pathnodetype1 == PathNodeType.DAMAGE_FIRE || block == Blocks.MAGMA_BLOCK || block == Blocks.CAMPFIRE) {
               pathnodetype = PathNodeType.DAMAGE_FIRE;
            }

            if (pathnodetype1 == PathNodeType.DAMAGE_CACTUS) {
               pathnodetype = PathNodeType.DAMAGE_CACTUS;
            }

            if (pathnodetype1 == PathNodeType.DAMAGE_OTHER) {
               pathnodetype = PathNodeType.DAMAGE_OTHER;
            }
         }

         if (pathnodetype == PathNodeType.WALKABLE) {
            pathnodetype = checkNeighborBlocks(blockaccessIn, x, y, z, pathnodetype);
         }

         return pathnodetype;
      }
   }
}
