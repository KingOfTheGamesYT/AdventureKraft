/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ public class MyEntityAIWanderALot
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature entity;
/*    */   private double xPosition;
/*    */   private double yPosition;
/*    */   private double zPosition;
/*    */   private double speed;
/* 18 */   private int xzRange = 10;
/* 19 */   private int busy = 0;
/*    */ 
/*    */   
/*    */   public MyEntityAIWanderALot(EntityCreature par1EntityCreature, int par1, double par2) {
/* 23 */     this.entity = par1EntityCreature;
/* 24 */     this.xzRange = par1;
/* 25 */     this.speed = par2;
/* 26 */     setMutexBits(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBusy(int i) {
/* 31 */     this.busy = i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 40 */     if (this.busy != 0) return false;
/*    */     
/* 42 */     if (this.entity.worldObj.rand.nextInt(30) != 0)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting())
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     Vec3 var1 = RandomPositionGenerator.findRandomTarget(this.entity, this.xzRange, 7);
/*    */     
/* 54 */     if (var1 == null)
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 61 */     this.xPosition = var1.xCoord;
/* 62 */     this.yPosition = var1.yCoord;
/* 63 */     this.zPosition = var1.zCoord;
/* 64 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean continueExecuting() {
/* 74 */     return !this.entity.getNavigator().noPath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 82 */     this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAIWanderALot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */