package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClimberPathNavigator extends GroundPathNavigator {
   /** Current path navigation target */
   private BlockPos targetPosition;

   public ClimberPathNavigator(MobEntity entityLivingIn, World worldIn) {
      super(entityLivingIn, worldIn);
   }

   /**
    * Returns path to given BlockPos
    *  
    * @param accuracyIn distance in which a path point counts as target-reaching
    */
   public Path getPathToPos(BlockPos pos, int accuracyIn) {
      this.targetPosition = pos;
      return super.getPathToPos(pos, accuracyIn);
   }

   /**
    * Returns the path to the given EntityLiving. Args : entity
    *  
    * @param distance The distance to stop from the entity being pathed to
    */
   public Path getPathToEntity(Entity entityIn, int distance) {
      this.targetPosition = new BlockPos(entityIn);
      return super.getPathToEntity(entityIn, distance);
   }

   /**
    * Try to find and set a path to EntityLiving. Returns true if successful. Args : entity, speed
    */
   public boolean tryMoveToEntityLiving(Entity entityIn, double speedIn) {
      Path path = this.getPathToEntity(entityIn, 0);
      if (path != null) {
         return this.setPath(path, speedIn);
      } else {
         this.targetPosition = new BlockPos(entityIn);
         this.speed = speedIn;
         return true;
      }
   }

   public void tick() {
      if (!this.noPath()) {
         super.tick();
      } else {
         if (this.targetPosition != null) {
            if (!this.targetPosition.withinDistance(this.entity.getPositionVec(), (double)this.entity.getWidth()) && (!(this.entity.getPosY() > (double)this.targetPosition.getY()) || !(new BlockPos((double)this.targetPosition.getX(), this.entity.getPosY(), (double)this.targetPosition.getZ())).withinDistance(this.entity.getPositionVec(), (double)this.entity.getWidth()))) {
               this.entity.getMoveHelper().setMoveTo((double)this.targetPosition.getX(), (double)this.targetPosition.getY(), (double)this.targetPosition.getZ(), this.speed);
            } else {
               this.targetPosition = null;
            }
         }

      }
   }
}
