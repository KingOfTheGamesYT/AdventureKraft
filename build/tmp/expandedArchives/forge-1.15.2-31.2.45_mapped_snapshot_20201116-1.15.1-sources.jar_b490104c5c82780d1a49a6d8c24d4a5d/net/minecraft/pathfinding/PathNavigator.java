package net.minecraft.pathfinding;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Region;
import net.minecraft.world.World;

public abstract class PathNavigator {
   protected final MobEntity entity;
   protected final World world;
   @Nullable
   protected Path currentPath;
   protected double speed;
   private final IAttributeInstance followRangeAttribute;
   protected int totalTicks;
   protected int ticksAtLastPos;
   protected Vec3d lastPosCheck = Vec3d.ZERO;
   protected Vec3d timeoutCachedNode = Vec3d.ZERO;
   protected long timeoutTimer;
   protected long lastTimeoutCheck;
   protected double timeoutLimit;
   protected float maxDistanceToWaypoint = 0.5F;
   protected boolean tryUpdatePath;
   protected long lastTimeUpdated;
   protected NodeProcessor nodeProcessor;
   private BlockPos targetPos;
   /** distance in which a path point counts as target-reaching */
   private int accuracy;
   private float searchDepthMultiplier = 1.0F;
   private final PathFinder pathFinder;

   public PathNavigator(MobEntity entityIn, World worldIn) {
      this.entity = entityIn;
      this.world = worldIn;
      this.followRangeAttribute = entityIn.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
      int i = MathHelper.floor(this.followRangeAttribute.getValue() * 16.0D);
      this.pathFinder = this.getPathFinder(i);
   }

   public void resetRangeMultiplier() {
      this.searchDepthMultiplier = 1.0F;
   }

   public void setRangeMultiplier(float multiplierIn) {
      this.searchDepthMultiplier = multiplierIn;
   }

   public BlockPos getTargetPos() {
      return this.targetPos;
   }

   protected abstract PathFinder getPathFinder(int searchDepth);

   /**
    * Sets the speed
    */
   public void setSpeed(double speedIn) {
      this.speed = speedIn;
   }

   /**
    * Returns true if path can be changed by {@link net.minecraft.pathfinding.PathNavigate#onUpdateNavigation()
    * onUpdateNavigation()}
    */
   public boolean canUpdatePathOnTimeout() {
      return this.tryUpdatePath;
   }

   public void updatePath() {
      if (this.world.getGameTime() - this.lastTimeUpdated > 20L) {
         if (this.targetPos != null) {
            this.currentPath = null;
            this.currentPath = this.getPathToPos(this.targetPos, this.accuracy);
            this.lastTimeUpdated = this.world.getGameTime();
            this.tryUpdatePath = false;
         }
      } else {
         this.tryUpdatePath = true;
      }

   }

   @Nullable
   public final Path getPathToPos(double x, double y, double z, int accuracyIn) {
      return this.getPathToPos(new BlockPos(x, y, z), accuracyIn);
   }

   /**
    * returns a path to one of the elements of the stream or null
    *  
    * @param targets a stream of possible targets
    * @param accuracyIn distance in which a path point counts as target-reaching
    */
   @Nullable
   public Path getPathTo(Stream<BlockPos> targets, int accuracyIn) {
      return this.getPathTo(targets.collect(Collectors.toSet()), 8, false, accuracyIn);
   }

   /**
    * Returns path to given BlockPos
    *  
    * @param accuracyIn distance in which a path point counts as target-reaching
    */
   @Nullable
   public Path getPathToPos(BlockPos pos, int accuracyIn) {
      return this.getPathTo(ImmutableSet.of(pos), 8, false, accuracyIn);
   }

   /**
    * Returns the path to the given EntityLiving. Args : entity
    *  
    * @param distance The distance to stop from the entity being pathed to
    */
   @Nullable
   public Path getPathToEntity(Entity entityIn, int distance) {
      return this.getPathTo(ImmutableSet.of(new BlockPos(entityIn)), 16, true, distance);
   }

   /**
    * returns a path to one of the given targets or null
    *  
    * @param targets one or more targets to pathfind to (+/- accuracyIn)
    * @param aditionalRegionSize how much bigger the cubic region 'radius' is than the follow range attribute
    * @param shiftRegionCenterUp shift the center of the cubic search region up by one block
    * @param accuracyIn distance in which a path point counts as target-reaching
    */
   @Nullable
   protected Path getPathTo(Set<BlockPos> targets, int aditionalRegionSize, boolean shiftRegionCenterUp, int accuracyIn) {
      if (targets.isEmpty()) {
         return null;
      } else if (this.entity.getPosY() < 0.0D) {
         return null;
      } else if (!this.canNavigate()) {
         return null;
      } else if (this.currentPath != null && !this.currentPath.isFinished() && targets.contains(this.targetPos)) {
         return this.currentPath;
      } else {
         this.world.getProfiler().startSection("pathfind");
         float f = (float)this.followRangeAttribute.getValue();
         BlockPos blockpos = shiftRegionCenterUp ? (new BlockPos(this.entity)).up() : new BlockPos(this.entity);
         int i = (int)(f + (float)aditionalRegionSize);
         Region region = new Region(this.world, blockpos.add(-i, -i, -i), blockpos.add(i, i, i));
         Path path = this.pathFinder.getNewPath(region, this.entity, targets, f, accuracyIn, this.searchDepthMultiplier);
         this.world.getProfiler().endSection();
         if (path != null && path.getTarget() != null) {
            this.targetPos = path.getTarget();
            this.accuracy = accuracyIn;
         }

         return path;
      }
   }

   /**
    * Try to find and set a path to XYZ. Returns true if successful. Args : x, y, z, speed
    */
   public boolean tryMoveToXYZ(double x, double y, double z, double speedIn) {
      return this.setPath(this.getPathToPos(x, y, z, 1), speedIn);
   }

   /**
    * Try to find and set a path to EntityLiving. Returns true if successful. Args : entity, speed
    */
   public boolean tryMoveToEntityLiving(Entity entityIn, double speedIn) {
      Path path = this.getPathToEntity(entityIn, 1);
      return path != null && this.setPath(path, speedIn);
   }

   /**
    * Sets a new path. If it's diferent from the old path. Checks to adjust path for sun avoiding, and stores start
    * coords. Args : path, speed
    */
   public boolean setPath(@Nullable Path pathentityIn, double speedIn) {
      if (pathentityIn == null) {
         this.currentPath = null;
         return false;
      } else {
         if (!pathentityIn.isSamePath(this.currentPath)) {
            this.currentPath = pathentityIn;
         }

         if (this.noPath()) {
            return false;
         } else {
            this.trimPath();
            if (this.currentPath.getCurrentPathLength() <= 0) {
               return false;
            } else {
               this.speed = speedIn;
               Vec3d vec3d = this.getEntityPosition();
               this.ticksAtLastPos = this.totalTicks;
               this.lastPosCheck = vec3d;
               return true;
            }
         }
      }
   }

   /**
    * gets the actively used PathEntity
    */
   @Nullable
   public Path getPath() {
      return this.currentPath;
   }

   public void tick() {
      ++this.totalTicks;
      if (this.tryUpdatePath) {
         this.updatePath();
      }

      if (!this.noPath()) {
         if (this.canNavigate()) {
            this.pathFollow();
         } else if (this.currentPath != null && this.currentPath.getCurrentPathIndex() < this.currentPath.getCurrentPathLength()) {
            Vec3d vec3d = this.getEntityPosition();
            Vec3d vec3d1 = this.currentPath.getVectorFromIndex(this.entity, this.currentPath.getCurrentPathIndex());
            if (vec3d.y > vec3d1.y && !this.entity.onGround && MathHelper.floor(vec3d.x) == MathHelper.floor(vec3d1.x) && MathHelper.floor(vec3d.z) == MathHelper.floor(vec3d1.z)) {
               this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
            }
         }

         DebugPacketSender.sendPath(this.world, this.entity, this.currentPath, this.maxDistanceToWaypoint);
         if (!this.noPath()) {
            Vec3d vec3d2 = this.currentPath.getPosition(this.entity);
            BlockPos blockpos = new BlockPos(vec3d2);
            this.entity.getMoveHelper().setMoveTo(vec3d2.x, this.world.getBlockState(blockpos.down()).isAir() ? vec3d2.y : WalkNodeProcessor.getGroundY(this.world, blockpos), vec3d2.z, this.speed);
         }
      }
   }

   protected void pathFollow() {
      Vec3d vec3d = this.getEntityPosition();
      this.maxDistanceToWaypoint = this.entity.getWidth() > 0.75F ? this.entity.getWidth() / 2.0F : 0.75F - this.entity.getWidth() / 2.0F;
      Vec3d vec3d1 = this.currentPath.getCurrentPos();
      // Forge: fix MC-94054
      if (Math.abs(this.entity.getPosX() - (vec3d1.x + ((int)(this.entity.getWidth() + 1) / 2D))) < (double)this.maxDistanceToWaypoint && Math.abs(this.entity.getPosZ() - (vec3d1.z + ((int)(this.entity.getWidth() + 1) / 2D))) < (double)this.maxDistanceToWaypoint && Math.abs(this.entity.getPosY() - vec3d1.y) < 1.0D) {
         this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
      }

      this.checkForStuck(vec3d);
   }

   /**
    * Checks if entity haven't been moved when last checked and if so, clears current {@link
    * net.minecraft.pathfinding.PathEntity}
    */
   protected void checkForStuck(Vec3d positionVec3) {
      if (this.totalTicks - this.ticksAtLastPos > 100) {
         if (positionVec3.squareDistanceTo(this.lastPosCheck) < 2.25D) {
            this.clearPath();
         }

         this.ticksAtLastPos = this.totalTicks;
         this.lastPosCheck = positionVec3;
      }

      if (this.currentPath != null && !this.currentPath.isFinished()) {
         Vec3d vec3d = this.currentPath.getCurrentPos();
         if (vec3d.equals(this.timeoutCachedNode)) {
            this.timeoutTimer += Util.milliTime() - this.lastTimeoutCheck;
         } else {
            this.timeoutCachedNode = vec3d;
            double d0 = positionVec3.distanceTo(this.timeoutCachedNode);
            this.timeoutLimit = this.entity.getAIMoveSpeed() > 0.0F ? d0 / (double)this.entity.getAIMoveSpeed() * 1000.0D : 0.0D;
         }

         if (this.timeoutLimit > 0.0D && (double)this.timeoutTimer > this.timeoutLimit * 3.0D) {
            this.timeoutCachedNode = Vec3d.ZERO;
            this.timeoutTimer = 0L;
            this.timeoutLimit = 0.0D;
            this.clearPath();
         }

         this.lastTimeoutCheck = Util.milliTime();
      }

   }

   /**
    * If null path or reached the end
    */
   public boolean noPath() {
      return this.currentPath == null || this.currentPath.isFinished();
   }

   public boolean hasActivePath() {
      return !this.noPath();
   }

   /**
    * sets active PathEntity to null
    */
   public void clearPath() {
      this.currentPath = null;
   }

   protected abstract Vec3d getEntityPosition();

   /**
    * If on ground or swimming and can swim
    */
   protected abstract boolean canNavigate();

   /**
    * Returns true if the entity is in water or lava, false otherwise
    */
   protected boolean isInLiquid() {
      return this.entity.isInWaterOrBubbleColumn() || this.entity.isInLava();
   }

   /**
    * Trims path data from the end to the first sun covered block
    */
   protected void trimPath() {
      if (this.currentPath != null) {
         for(int i = 0; i < this.currentPath.getCurrentPathLength(); ++i) {
            PathPoint pathpoint = this.currentPath.getPathPointFromIndex(i);
            PathPoint pathpoint1 = i + 1 < this.currentPath.getCurrentPathLength() ? this.currentPath.getPathPointFromIndex(i + 1) : null;
            BlockState blockstate = this.world.getBlockState(new BlockPos(pathpoint.x, pathpoint.y, pathpoint.z));
            Block block = blockstate.getBlock();
            if (block == Blocks.CAULDRON) {
               this.currentPath.setPoint(i, pathpoint.cloneMove(pathpoint.x, pathpoint.y + 1, pathpoint.z));
               if (pathpoint1 != null && pathpoint.y >= pathpoint1.y) {
                  this.currentPath.setPoint(i + 1, pathpoint1.cloneMove(pathpoint1.x, pathpoint.y + 1, pathpoint1.z));
               }
            }
         }

      }
   }

   /**
    * Checks if the specified entity can safely walk to the specified location.
    */
   protected abstract boolean isDirectPathBetweenPoints(Vec3d posVec31, Vec3d posVec32, int sizeX, int sizeY, int sizeZ);

   public boolean canEntityStandOnPos(BlockPos pos) {
      BlockPos blockpos = pos.down();
      return this.world.getBlockState(blockpos).isOpaqueCube(this.world, blockpos);
   }

   public NodeProcessor getNodeProcessor() {
      return this.nodeProcessor;
   }

   public void setCanSwim(boolean canSwim) {
      this.nodeProcessor.setCanSwim(canSwim);
   }

   public boolean getCanSwim() {
      return this.nodeProcessor.getCanSwim();
   }

   public void func_220970_c(BlockPos p_220970_1_) {
      if (this.currentPath != null && !this.currentPath.isFinished() && this.currentPath.getCurrentPathLength() != 0) {
         PathPoint pathpoint = this.currentPath.getFinalPathPoint();
         Vec3d vec3d = new Vec3d(((double)pathpoint.x + this.entity.getPosX()) / 2.0D, ((double)pathpoint.y + this.entity.getPosY()) / 2.0D, ((double)pathpoint.z + this.entity.getPosZ()) / 2.0D);
         if (p_220970_1_.withinDistance(vec3d, (double)(this.currentPath.getCurrentPathLength() - this.currentPath.getCurrentPathIndex()))) {
            this.updatePath();
         }

      }
   }
}