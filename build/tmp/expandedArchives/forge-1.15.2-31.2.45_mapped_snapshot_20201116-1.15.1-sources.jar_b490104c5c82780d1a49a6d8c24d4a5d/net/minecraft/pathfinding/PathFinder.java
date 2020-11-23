package net.minecraft.pathfinding;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Region;

public class PathFinder {
   private final PathHeap path = new PathHeap();
   private final Set<PathPoint> closedSet = Sets.newHashSet();
   private final PathPoint[] pathOptions = new PathPoint[32];
   private final int searchDepth;
   private final NodeProcessor nodeProcessor;

   public PathFinder(NodeProcessor nodeProcessorIn, int searchDepthIn) {
      this.nodeProcessor = nodeProcessorIn;
      this.searchDepth = searchDepthIn;
   }

   /**
    * finds a path to one of the specified positions and post-processes it or returns null if no path could be found
    * within given accuracy
    *  
    * @param regionIn the region in which a path should be found
    * @param mob the entity
    * @param targetPositions a set of poitions which the entity pathes to
    * @param accuracy distance in which a path point counts as target-reaching
    */
   @Nullable
   public Path getNewPath(Region regionIn, MobEntity mob, Set<BlockPos> targetPositions, float maxRange, int accuracy, float searchDepthMultiplier) {
      this.path.clearPath();
      this.nodeProcessor.setup(regionIn, mob);
      PathPoint pathpoint = this.nodeProcessor.getStart();
      Map<FlaggedPathPoint, BlockPos> map = targetPositions.stream().collect(Collectors.toMap((p_224782_1_) -> {
         return this.nodeProcessor.openFlaggedPathPoint((double)p_224782_1_.getX(), (double)p_224782_1_.getY(), (double)p_224782_1_.getZ());
      }, Function.identity()));
      Path path = this.generatePath(pathpoint, map, maxRange, accuracy, searchDepthMultiplier);
      this.nodeProcessor.postProcess();
      return path;
   }

   /**
    * generates a path from start to one of the targets or returns null if no path could be generated
    *  
    * @param accuracy distance in which a path point counts as target-reaching
    */
   @Nullable
   private Path generatePath(PathPoint start, Map<FlaggedPathPoint, BlockPos> targetPosMap, float maxRange, int accuracy, float searchDepthMultiplier) {
      Set<FlaggedPathPoint> set = targetPosMap.keySet();
      start.totalPathDistance = 0.0F;
      start.distanceToNext = this.calculateNearest(start, set);
      start.distanceToTarget = start.distanceToNext;
      this.path.clearPath();
      this.closedSet.clear();
      this.path.addPoint(start);
      int i = 0;
      int j = (int)((float)this.searchDepth * searchDepthMultiplier);

      while(!this.path.isPathEmpty()) {
         ++i;
         if (i >= j) {
            break;
         }

         PathPoint pathpoint = this.path.dequeue();
         pathpoint.visited = true;
         set.stream().filter((p_224781_2_) -> {
            return pathpoint.manhattanDistanceTo(p_224781_2_) <= (float)accuracy;
         }).forEach(FlaggedPathPoint::flag);
         if (set.stream().anyMatch(FlaggedPathPoint::isFlagged)) {
            break;
         }

         if (!(pathpoint.distanceTo(start) >= maxRange)) {
            int k = this.nodeProcessor.calculatePathOptions(this.pathOptions, pathpoint);

            for(int l = 0; l < k; ++l) {
               PathPoint pathpoint1 = this.pathOptions[l];
               float f = pathpoint.distanceTo(pathpoint1);
               pathpoint1.pathLength = pathpoint.pathLength + f;
               float f1 = pathpoint.totalPathDistance + f + pathpoint1.costMalus;
               if (pathpoint1.pathLength < maxRange && (!pathpoint1.isAssigned() || f1 < pathpoint1.totalPathDistance)) {
                  pathpoint1.previous = pathpoint;
                  pathpoint1.totalPathDistance = f1;
                  pathpoint1.distanceToNext = this.calculateNearest(pathpoint1, set) * 1.5F;
                  if (pathpoint1.isAssigned()) {
                     this.path.changeDistance(pathpoint1, pathpoint1.totalPathDistance + pathpoint1.distanceToNext);
                  } else {
                     pathpoint1.distanceToTarget = pathpoint1.totalPathDistance + pathpoint1.distanceToNext;
                     this.path.addPoint(pathpoint1);
                  }
               }
            }
         }
      }

      Stream<Path> stream;
      if (set.stream().anyMatch(FlaggedPathPoint::isFlagged)) {
         stream = set.stream().filter(FlaggedPathPoint::isFlagged).map((p_224778_2_) -> {
            return this.unfoldPathPoint(p_224778_2_.getNearest(), targetPosMap.get(p_224778_2_), true);
         }).sorted(Comparator.comparingInt(Path::getCurrentPathLength));
      } else {
         stream = set.stream().map((p_224777_2_) -> {
            return this.unfoldPathPoint(p_224777_2_.getNearest(), targetPosMap.get(p_224777_2_), false);
         }).sorted(Comparator.comparingDouble(Path::getManhattanLength).thenComparingInt(Path::getCurrentPathLength));
      }

      Optional<Path> optional = stream.findFirst();
      if (!optional.isPresent()) {
         return null;
      } else {
         Path path = optional.get();
         return path;
      }
   }

   /**
    * goes through the set, eventually updates the distance and nearest to 'fromPos' and returns the minimal (euclidean)
    * distance
    */
   private float calculateNearest(PathPoint fromPos, Set<FlaggedPathPoint> targets) {
      float f = Float.MAX_VALUE;

      for(FlaggedPathPoint flaggedpathpoint : targets) {
         float f1 = fromPos.distanceTo(flaggedpathpoint);
         flaggedpathpoint.updatePredecessor(f1, fromPos);
         f = Math.min(f1, f);
      }

      return f;
   }

   /**
    * converts a recursive path point structure into a path
    */
   private Path unfoldPathPoint(PathPoint pathPointIn, BlockPos targetPos, boolean reachesTarget) {
      List<PathPoint> list = Lists.newArrayList();
      PathPoint pathpoint = pathPointIn;
      list.add(0, pathPointIn);

      while(pathpoint.previous != null) {
         pathpoint = pathpoint.previous;
         list.add(0, pathpoint);
      }

      return new Path(list, targetPos, reachesTarget);
   }
}
