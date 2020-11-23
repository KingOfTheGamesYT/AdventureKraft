package net.minecraft.pathfinding;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Region;

public abstract class NodeProcessor {
   protected Region blockaccess;
   protected MobEntity entity;
   protected final Int2ObjectMap<PathPoint> pointMap = new Int2ObjectOpenHashMap<>();
   protected int entitySizeX;
   protected int entitySizeY;
   protected int entitySizeZ;
   protected boolean canEnterDoors;
   protected boolean canOpenDoors;
   protected boolean canSwim;

   /**
    * clears the point map and sets world and entity
    */
   public void setup(Region worldIn, MobEntity mobEntityIn) {
      this.blockaccess = worldIn;
      this.entity = mobEntityIn;
      this.pointMap.clear();
      this.entitySizeX = MathHelper.floor(mobEntityIn.getWidth() + 1.0F);
      this.entitySizeY = MathHelper.floor(mobEntityIn.getHeight() + 1.0F);
      this.entitySizeZ = MathHelper.floor(mobEntityIn.getWidth() + 1.0F);
   }

   /**
    * This method is called when all nodes have been processed and PathEntity is created.
    * {@link net.minecraft.world.pathfinder.WalkNodeProcessor WalkNodeProcessor} uses this to change its field {@link
    * net.minecraft.world.pathfinder.WalkNodeProcessor#avoidsWater avoidsWater}
    */
   public void postProcess() {
      this.blockaccess = null;
      this.entity = null;
   }

   /**
    * Returns a mapped point or creates and adds one
    */
   protected PathPoint openPoint(int x, int y, int z) {
      return this.pointMap.computeIfAbsent(PathPoint.makeHash(x, y, z), (p_215743_3_) -> {
         return new PathPoint(x, y, z);
      });
   }

   public abstract PathPoint getStart();

   /**
    * opens a flagged path point at the specified coordinates and returns it
    */
   public abstract FlaggedPathPoint openFlaggedPathPoint(double x, double y, double z);

   public abstract int calculatePathOptions(PathPoint[] pathOptions, PathPoint fromPoint);

   public abstract PathNodeType getPathNodeType(IBlockReader blockaccessIn, int x, int y, int z, MobEntity entitylivingIn, int xSize, int ySize, int zSize, boolean canBreakDoorsIn, boolean canEnterDoorsIn);

   public abstract PathNodeType getPathNodeType(IBlockReader blockaccessIn, int x, int y, int z);

   public void setCanEnterDoors(boolean canEnterDoorsIn) {
      this.canEnterDoors = canEnterDoorsIn;
   }

   public void setCanOpenDoors(boolean canOpenDoorsIn) {
      this.canOpenDoors = canOpenDoorsIn;
   }

   public void setCanSwim(boolean canSwimIn) {
      this.canSwim = canSwimIn;
   }

   public boolean getCanEnterDoors() {
      return this.canEnterDoors;
   }

   public boolean getCanOpenDoors() {
      return this.canOpenDoors;
   }

   public boolean getCanSwim() {
      return this.canSwim;
   }
}
