package net.minecraft.pathfinding;

import com.google.common.collect.Sets;
import java.util.EnumSet;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Region;

public class WalkNodeProcessor extends NodeProcessor {
   protected float avoidsWater;

   /**
    * clears the point map and sets world and entity
    */
   public void setup(Region worldIn, MobEntity mobEntityIn) {
      super.setup(worldIn, mobEntityIn);
      this.avoidsWater = mobEntityIn.getPathPriority(PathNodeType.WATER);
   }

   /**
    * This method is called when all nodes have been processed and PathEntity is created.
    * {@link net.minecraft.world.pathfinder.WalkNodeProcessor WalkNodeProcessor} uses this to change its field {@link
    * net.minecraft.world.pathfinder.WalkNodeProcessor#avoidsWater avoidsWater}
    */
   public void postProcess() {
      this.entity.setPathPriority(PathNodeType.WATER, this.avoidsWater);
      super.postProcess();
   }

   public PathPoint getStart() {
      int i;
      if (this.getCanSwim() && this.entity.isInWater()) {
         i = MathHelper.floor(this.entity.getPosY());
         BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(this.entity.getPosX(), (double)i, this.entity.getPosZ());

         for(BlockState blockstate = this.blockaccess.getBlockState(blockpos$mutable); blockstate.getBlock() == Blocks.WATER || blockstate.getFluidState() == Fluids.WATER.getStillFluidState(false); blockstate = this.blockaccess.getBlockState(blockpos$mutable)) {
            ++i;
            blockpos$mutable.setPos(this.entity.getPosX(), (double)i, this.entity.getPosZ());
         }

         --i;
      } else if (this.entity.onGround) {
         i = MathHelper.floor(this.entity.getPosY() + 0.5D);
      } else {
         BlockPos blockpos;
         for(blockpos = new BlockPos(this.entity); (this.blockaccess.getBlockState(blockpos).isAir() || this.blockaccess.getBlockState(blockpos).allowsMovement(this.blockaccess, blockpos, PathType.LAND)) && blockpos.getY() > 0; blockpos = blockpos.down()) {
            ;
         }

         i = blockpos.up().getY();
      }

      BlockPos blockpos2 = new BlockPos(this.entity);
      PathNodeType pathnodetype1 = this.getPathNodeType(this.entity, blockpos2.getX(), i, blockpos2.getZ());
      if (this.entity.getPathPriority(pathnodetype1) < 0.0F) {
         Set<BlockPos> set = Sets.newHashSet();
         set.add(new BlockPos(this.entity.getBoundingBox().minX, (double)i, this.entity.getBoundingBox().minZ));
         set.add(new BlockPos(this.entity.getBoundingBox().minX, (double)i, this.entity.getBoundingBox().maxZ));
         set.add(new BlockPos(this.entity.getBoundingBox().maxX, (double)i, this.entity.getBoundingBox().minZ));
         set.add(new BlockPos(this.entity.getBoundingBox().maxX, (double)i, this.entity.getBoundingBox().maxZ));

         for(BlockPos blockpos1 : set) {
            PathNodeType pathnodetype = this.getPathNodeType(this.entity, blockpos1);
            if (this.entity.getPathPriority(pathnodetype) >= 0.0F) {
               return this.openPoint(blockpos1.getX(), blockpos1.getY(), blockpos1.getZ());
            }
         }
      }

      return this.openPoint(blockpos2.getX(), i, blockpos2.getZ());
   }

   /**
    * opens a flagged path point at the specified coordinates and returns it
    */
   public FlaggedPathPoint openFlaggedPathPoint(double x, double y, double z) {
      return new FlaggedPathPoint(this.openPoint(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z)));
   }

   public int calculatePathOptions(PathPoint[] pathOptions, PathPoint fromPoint) {
      int i = 0;
      int j = 0;
      PathNodeType pathnodetype = this.getPathNodeType(this.entity, fromPoint.x, fromPoint.y + 1, fromPoint.z);
      if (this.entity.getPathPriority(pathnodetype) >= 0.0F) {
         PathNodeType pathnodetype1 = this.getPathNodeType(this.entity, fromPoint.x, fromPoint.y, fromPoint.z);
         if (pathnodetype1 == PathNodeType.STICKY_HONEY) {
            j = 0;
         } else {
            j = MathHelper.floor(Math.max(1.0F, this.entity.stepHeight));
         }
      }

      double d0 = getGroundY(this.blockaccess, new BlockPos(fromPoint.x, fromPoint.y, fromPoint.z));
      PathPoint pathpoint = this.getSafePoint(fromPoint.x, fromPoint.y, fromPoint.z + 1, j, d0, Direction.SOUTH);
      if (pathpoint != null && !pathpoint.visited && pathpoint.costMalus >= 0.0F) {
         pathOptions[i++] = pathpoint;
      }

      PathPoint pathpoint1 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z, j, d0, Direction.WEST);
      if (pathpoint1 != null && !pathpoint1.visited && pathpoint1.costMalus >= 0.0F) {
         pathOptions[i++] = pathpoint1;
      }

      PathPoint pathpoint2 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z, j, d0, Direction.EAST);
      if (pathpoint2 != null && !pathpoint2.visited && pathpoint2.costMalus >= 0.0F) {
         pathOptions[i++] = pathpoint2;
      }

      PathPoint pathpoint3 = this.getSafePoint(fromPoint.x, fromPoint.y, fromPoint.z - 1, j, d0, Direction.NORTH);
      if (pathpoint3 != null && !pathpoint3.visited && pathpoint3.costMalus >= 0.0F) {
         pathOptions[i++] = pathpoint3;
      }

      PathPoint pathpoint4 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z - 1, j, d0, Direction.NORTH);
      if (this.shouldConsiderCorner(fromPoint, pathpoint1, pathpoint3, pathpoint4)) {
         pathOptions[i++] = pathpoint4;
      }

      PathPoint pathpoint5 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z - 1, j, d0, Direction.NORTH);
      if (this.shouldConsiderCorner(fromPoint, pathpoint2, pathpoint3, pathpoint5)) {
         pathOptions[i++] = pathpoint5;
      }

      PathPoint pathpoint6 = this.getSafePoint(fromPoint.x - 1, fromPoint.y, fromPoint.z + 1, j, d0, Direction.SOUTH);
      if (this.shouldConsiderCorner(fromPoint, pathpoint1, pathpoint, pathpoint6)) {
         pathOptions[i++] = pathpoint6;
      }

      PathPoint pathpoint7 = this.getSafePoint(fromPoint.x + 1, fromPoint.y, fromPoint.z + 1, j, d0, Direction.SOUTH);
      if (this.shouldConsiderCorner(fromPoint, pathpoint2, pathpoint, pathpoint7)) {
         pathOptions[i++] = pathpoint7;
      }

      return i;
   }

   /**
    * whether a corner path point should count as a path option
    *  
    * @param cornerPoint The path point adjcacent to adjacentPoint1 and adjacentPoint2. Must have a positive costMalus
    * in order to count.
    */
   private boolean shouldConsiderCorner(PathPoint referencePoint, @Nullable PathPoint adjacentPoint1, @Nullable PathPoint adjacentPoint2, @Nullable PathPoint cornerPoint) {
      if (cornerPoint != null && adjacentPoint2 != null && adjacentPoint1 != null) {
         if (cornerPoint.visited) {
            return false;
         } else if (adjacentPoint2.y <= referencePoint.y && adjacentPoint1.y <= referencePoint.y) {
            return cornerPoint.costMalus >= 0.0F && (adjacentPoint2.y < referencePoint.y || adjacentPoint2.costMalus >= 0.0F) && (adjacentPoint1.y < referencePoint.y || adjacentPoint1.costMalus >= 0.0F);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static double getGroundY(IBlockReader p_197682_0_, BlockPos pos) {
      BlockPos blockpos = pos.down();
      VoxelShape voxelshape = p_197682_0_.getBlockState(blockpos).getCollisionShape(p_197682_0_, blockpos);
      return (double)blockpos.getY() + (voxelshape.isEmpty() ? 0.0D : voxelshape.getEnd(Direction.Axis.Y));
   }

   /**
    * Returns a point that the entity can safely move to
    */
   @Nullable
   private PathPoint getSafePoint(int x, int y, int z, int stepHeight, double groundYIn, Direction facing) {
      PathPoint pathpoint = null;
      BlockPos blockpos = new BlockPos(x, y, z);
      double d0 = getGroundY(this.blockaccess, blockpos);
      if (d0 - groundYIn > 1.125D) {
         return null;
      } else {
         PathNodeType pathnodetype = this.getPathNodeType(this.entity, x, y, z);
         float f = this.entity.getPathPriority(pathnodetype);
         double d1 = (double)this.entity.getWidth() / 2.0D;
         if (f >= 0.0F) {
            pathpoint = this.openPoint(x, y, z);
            pathpoint.nodeType = pathnodetype;
            pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
         }

         if (pathnodetype == PathNodeType.WALKABLE) {
            return pathpoint;
         } else {
            if ((pathpoint == null || pathpoint.costMalus < 0.0F) && stepHeight > 0 && pathnodetype != PathNodeType.FENCE && pathnodetype != PathNodeType.TRAPDOOR) {
               pathpoint = this.getSafePoint(x, y + 1, z, stepHeight - 1, groundYIn, facing);
               if (pathpoint != null && (pathpoint.nodeType == PathNodeType.OPEN || pathpoint.nodeType == PathNodeType.WALKABLE) && this.entity.getWidth() < 1.0F) {
                  double d2 = (double)(x - facing.getXOffset()) + 0.5D;
                  double d3 = (double)(z - facing.getZOffset()) + 0.5D;
                  AxisAlignedBB axisalignedbb = new AxisAlignedBB(d2 - d1, getGroundY(this.blockaccess, new BlockPos(d2, (double)(y + 1), d3)) + 0.001D, d3 - d1, d2 + d1, (double)this.entity.getHeight() + getGroundY(this.blockaccess, new BlockPos(pathpoint.x, pathpoint.y, pathpoint.z)) - 0.002D, d3 + d1);
                  if (!this.blockaccess.hasNoCollisions(this.entity, axisalignedbb)) {
                     pathpoint = null;
                  }
               }
            }

            if (pathnodetype == PathNodeType.WATER && !this.getCanSwim()) {
               if (this.getPathNodeType(this.entity, x, y - 1, z) != PathNodeType.WATER) {
                  return pathpoint;
               }

               while(y > 0) {
                  --y;
                  pathnodetype = this.getPathNodeType(this.entity, x, y, z);
                  if (pathnodetype != PathNodeType.WATER) {
                     return pathpoint;
                  }

                  pathpoint = this.openPoint(x, y, z);
                  pathpoint.nodeType = pathnodetype;
                  pathpoint.costMalus = Math.max(pathpoint.costMalus, this.entity.getPathPriority(pathnodetype));
               }
            }

            if (pathnodetype == PathNodeType.OPEN) {
               AxisAlignedBB axisalignedbb1 = new AxisAlignedBB((double)x - d1 + 0.5D, (double)y + 0.001D, (double)z - d1 + 0.5D, (double)x + d1 + 0.5D, (double)((float)y + this.entity.getHeight()), (double)z + d1 + 0.5D);
               if (!this.blockaccess.hasNoCollisions(this.entity, axisalignedbb1)) {
                  return null;
               }

               if (this.entity.getWidth() >= 1.0F) {
                  PathNodeType pathnodetype1 = this.getPathNodeType(this.entity, x, y - 1, z);
                  if (pathnodetype1 == PathNodeType.BLOCKED) {
                     pathpoint = this.openPoint(x, y, z);
                     pathpoint.nodeType = PathNodeType.WALKABLE;
                     pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                     return pathpoint;
                  }
               }

               int i = 0;
               int j = y;

               while(pathnodetype == PathNodeType.OPEN) {
                  --y;
                  if (y < 0) {
                     PathPoint pathpoint2 = this.openPoint(x, j, z);
                     pathpoint2.nodeType = PathNodeType.BLOCKED;
                     pathpoint2.costMalus = -1.0F;
                     return pathpoint2;
                  }

                  PathPoint pathpoint1 = this.openPoint(x, y, z);
                  if (i++ >= this.entity.getMaxFallHeight()) {
                     pathpoint1.nodeType = PathNodeType.BLOCKED;
                     pathpoint1.costMalus = -1.0F;
                     return pathpoint1;
                  }

                  pathnodetype = this.getPathNodeType(this.entity, x, y, z);
                  f = this.entity.getPathPriority(pathnodetype);
                  if (pathnodetype != PathNodeType.OPEN && f >= 0.0F) {
                     pathpoint = pathpoint1;
                     pathpoint1.nodeType = pathnodetype;
                     pathpoint1.costMalus = Math.max(pathpoint1.costMalus, f);
                     break;
                  }

                  if (f < 0.0F) {
                     pathpoint1.nodeType = PathNodeType.BLOCKED;
                     pathpoint1.costMalus = -1.0F;
                     return pathpoint1;
                  }
               }
            }

            return pathpoint;
         }
      }
   }

   public PathNodeType getPathNodeType(IBlockReader blockaccessIn, int x, int y, int z, MobEntity entitylivingIn, int xSize, int ySize, int zSize, boolean canBreakDoorsIn, boolean canEnterDoorsIn) {
      EnumSet<PathNodeType> enumset = EnumSet.noneOf(PathNodeType.class);
      PathNodeType pathnodetype = PathNodeType.BLOCKED;
      double d0 = (double)entitylivingIn.getWidth() / 2.0D;
      BlockPos blockpos = new BlockPos(entitylivingIn);
      pathnodetype = this.getPathNodeType(blockaccessIn, x, y, z, xSize, ySize, zSize, canBreakDoorsIn, canEnterDoorsIn, enumset, pathnodetype, blockpos);
      if (enumset.contains(PathNodeType.FENCE)) {
         return PathNodeType.FENCE;
      } else {
         PathNodeType pathnodetype1 = PathNodeType.BLOCKED;

         for(PathNodeType pathnodetype2 : enumset) {
            if (entitylivingIn.getPathPriority(pathnodetype2) < 0.0F) {
               return pathnodetype2;
            }

            if (entitylivingIn.getPathPriority(pathnodetype2) >= entitylivingIn.getPathPriority(pathnodetype1)) {
               pathnodetype1 = pathnodetype2;
            }
         }

         return pathnodetype == PathNodeType.OPEN && entitylivingIn.getPathPriority(pathnodetype1) == 0.0F ? PathNodeType.OPEN : pathnodetype1;
      }
   }

   public PathNodeType getPathNodeType(IBlockReader worldIn, int x, int y, int z, int xSize, int ySize, int zSize, boolean canOpenDoorsIn, boolean canEnterDoorsIn, EnumSet<PathNodeType> nodeTypeEnum, PathNodeType nodeType, BlockPos pos) {
      for(int i = 0; i < xSize; ++i) {
         for(int j = 0; j < ySize; ++j) {
            for(int k = 0; k < zSize; ++k) {
               int l = i + x;
               int i1 = j + y;
               int j1 = k + z;
               PathNodeType pathnodetype = this.getPathNodeType(worldIn, l, i1, j1);
               pathnodetype = this.getSpecificPathNodeType(worldIn, canOpenDoorsIn, canEnterDoorsIn, pos, pathnodetype);
               if (i == 0 && j == 0 && k == 0) {
                  nodeType = pathnodetype;
               }

               nodeTypeEnum.add(pathnodetype);
            }
         }
      }

      return nodeType;
   }

   /**
    * returns the exact path node type according to abilities and settings
    */
   protected PathNodeType getSpecificPathNodeType(IBlockReader worldIn, boolean canOpenDoorsIn, boolean canEnterDoorsIn, BlockPos pos, PathNodeType nodeType) {
      if (nodeType == PathNodeType.DOOR_WOOD_CLOSED && canOpenDoorsIn && canEnterDoorsIn) {
         nodeType = PathNodeType.WALKABLE;
      }

      if (nodeType == PathNodeType.DOOR_OPEN && !canEnterDoorsIn) {
         nodeType = PathNodeType.BLOCKED;
      }

      if (nodeType == PathNodeType.RAIL && !(worldIn.getBlockState(pos).getBlock() instanceof AbstractRailBlock) && !(worldIn.getBlockState(pos.down()).getBlock() instanceof AbstractRailBlock)) {
         nodeType = PathNodeType.FENCE;
      }

      if (nodeType == PathNodeType.LEAVES) {
         nodeType = PathNodeType.BLOCKED;
      }

      return nodeType;
   }

   private PathNodeType getPathNodeType(MobEntity entitylivingIn, BlockPos pos) {
      return this.getPathNodeType(entitylivingIn, pos.getX(), pos.getY(), pos.getZ());
   }

   private PathNodeType getPathNodeType(MobEntity entitylivingIn, int x, int y, int z) {
      return this.getPathNodeType(this.blockaccess, x, y, z, entitylivingIn, this.entitySizeX, this.entitySizeY, this.entitySizeZ, this.getCanOpenDoors(), this.getCanEnterDoors());
   }

   public PathNodeType getPathNodeType(IBlockReader blockaccessIn, int x, int y, int z) {
      return getLocalizedPathNodeType(blockaccessIn, x, y, z);
   }

   /**
    * gets the path node type at a specific position taking the surrounding blocks into account (e.g. lava below)
    */
   public static PathNodeType getLocalizedPathNodeType(IBlockReader worldIn, int x, int y, int z) {
      PathNodeType pathnodetype = getPathNodeTypeRaw(worldIn, x, y, z);
      if (pathnodetype == PathNodeType.OPEN && y >= 1) {
         Block block = worldIn.getBlockState(new BlockPos(x, y - 1, z)).getBlock();
         PathNodeType pathnodetype1 = getPathNodeTypeRaw(worldIn, x, y - 1, z);
         pathnodetype = pathnodetype1 != PathNodeType.WALKABLE && pathnodetype1 != PathNodeType.OPEN && pathnodetype1 != PathNodeType.WATER && pathnodetype1 != PathNodeType.LAVA ? PathNodeType.WALKABLE : PathNodeType.OPEN;
         if (pathnodetype1 == PathNodeType.DAMAGE_FIRE || block == Blocks.MAGMA_BLOCK || block == Blocks.CAMPFIRE) {
            pathnodetype = PathNodeType.DAMAGE_FIRE;
         }

         if (pathnodetype1 == PathNodeType.DAMAGE_CACTUS) {
            pathnodetype = PathNodeType.DAMAGE_CACTUS;
         }

         if (pathnodetype1 == PathNodeType.DAMAGE_OTHER) {
            pathnodetype = PathNodeType.DAMAGE_OTHER;
         }

         if (pathnodetype1 == PathNodeType.STICKY_HONEY) {
            pathnodetype = PathNodeType.STICKY_HONEY;
         }
      }

      if (pathnodetype == PathNodeType.WALKABLE) {
         pathnodetype = checkNeighborBlocks(worldIn, x, y, z, pathnodetype);
      }

      return pathnodetype;
   }

   /**
    * checks the neighbor blocks for damage node types and if encounters one, returns the corresponding danger node
    * type, otherwise nodeTypeIn
    */
   public static PathNodeType checkNeighborBlocks(IBlockReader worldIn, int blockaccessIn, int x, int y, PathNodeType z) {
      try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
         for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
               for(int k = -1; k <= 1; ++k) {
                  if (i != 0 || k != 0) {
                     PathNodeType type = getPathNodeTypeRaw(worldIn, blockaccessIn + i, x + j, y + k).getDanger();
                     if (type != null)
                        z = type;
                  }
               }
            }
         }
      }

      return z;
   }

   protected static PathNodeType getPathNodeTypeRaw(IBlockReader worldIn, int blockaccessIn, int x, int y) {
      BlockPos blockpos = new BlockPos(blockaccessIn, x, y);
      BlockState blockstate = worldIn.getBlockState(blockpos);
      PathNodeType type = blockstate.getAiPathNodeType(worldIn, blockpos);
      if (type != null) return type;
      Block block = blockstate.getBlock();
      Material material = blockstate.getMaterial();
      if (blockstate.isAir(worldIn, blockpos)) {
         return PathNodeType.OPEN;
      } else if (!block.isIn(BlockTags.TRAPDOORS) && block != Blocks.LILY_PAD) {
         if (block == Blocks.FIRE) {
            return PathNodeType.DAMAGE_FIRE;
         } else if (block == Blocks.CACTUS) {
            return PathNodeType.DAMAGE_CACTUS;
         } else if (block == Blocks.SWEET_BERRY_BUSH) {
            return PathNodeType.DAMAGE_OTHER;
         } else if (block == Blocks.HONEY_BLOCK) {
            return PathNodeType.STICKY_HONEY;
         } else if (block == Blocks.COCOA) {
            return PathNodeType.COCOA;
         } else if (block instanceof DoorBlock && material == Material.WOOD && !blockstate.get(DoorBlock.OPEN)) {
            return PathNodeType.DOOR_WOOD_CLOSED;
         } else if (block instanceof DoorBlock && material == Material.IRON && !blockstate.get(DoorBlock.OPEN)) {
            return PathNodeType.DOOR_IRON_CLOSED;
         } else if (block instanceof DoorBlock && blockstate.get(DoorBlock.OPEN)) {
            return PathNodeType.DOOR_OPEN;
         } else if (block instanceof AbstractRailBlock) {
            return PathNodeType.RAIL;
         } else if (block instanceof LeavesBlock) {
            return PathNodeType.LEAVES;
         } else if (!block.isIn(BlockTags.FENCES) && !block.isIn(BlockTags.WALLS) && (!(block instanceof FenceGateBlock) || blockstate.get(FenceGateBlock.OPEN))) {
            IFluidState ifluidstate = worldIn.getFluidState(blockpos);
            if (ifluidstate.isTagged(FluidTags.WATER)) {
               return PathNodeType.WATER;
            } else if (ifluidstate.isTagged(FluidTags.LAVA)) {
               return PathNodeType.LAVA;
            } else {
               return blockstate.allowsMovement(worldIn, blockpos, PathType.LAND) ? PathNodeType.OPEN : PathNodeType.BLOCKED;
            }
         } else {
            return PathNodeType.FENCE;
         }
      } else {
         return PathNodeType.TRAPDOOR;
      }
   }
}