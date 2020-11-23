package net.minecraft.pathfinding;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FlaggedPathPoint extends PathPoint {
   private float shortestDistance = Float.MAX_VALUE;
   private PathPoint nearest;
   private boolean flag;

   public FlaggedPathPoint(PathPoint pathPointIn) {
      super(pathPointIn.x, pathPointIn.y, pathPointIn.z);
   }

   @OnlyIn(Dist.CLIENT)
   public FlaggedPathPoint(int xIn, int yIn, int zIn) {
      super(xIn, yIn, zIn);
   }

   /**
    * sets pathPointIn as nearest if distanceIn is smaller than 'this.shortestDistance'
    */
   public void updatePredecessor(float distanceIn, PathPoint pathPointIn) {
      if (distanceIn < this.shortestDistance) {
         this.shortestDistance = distanceIn;
         this.nearest = pathPointIn;
      }

   }

   public PathPoint getNearest() {
      return this.nearest;
   }

   /**
    * sets the flag to true
    */
   public void flag() {
      this.flag = true;
   }

   public boolean isFlagged() {
      return this.flag;
   }

   @OnlyIn(Dist.CLIENT)
   public static FlaggedPathPoint deserializeFromBuffer(PacketBuffer bufferIn) {
      FlaggedPathPoint flaggedpathpoint = new FlaggedPathPoint(bufferIn.readInt(), bufferIn.readInt(), bufferIn.readInt());
      flaggedpathpoint.pathLength = bufferIn.readFloat();
      flaggedpathpoint.costMalus = bufferIn.readFloat();
      flaggedpathpoint.visited = bufferIn.readBoolean();
      flaggedpathpoint.nodeType = PathNodeType.values()[bufferIn.readInt()];
      flaggedpathpoint.distanceToTarget = bufferIn.readFloat();
      return flaggedpathpoint;
   }
}
