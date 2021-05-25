/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyEntityAIFollowOwner
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityTameable thePet;
/*     */   private EntityLivingBase theOwner;
/*     */   World theWorld;
/*     */   private float followSpeed;
/*     */   private PathNavigate petPathfinder;
/*     */   private int timeToRecalcPath;
/*     */   float maxDist;
/*     */   float minDist;
/*     */   private boolean oldWaterCost;
/*     */   
/*     */   public MyEntityAIFollowOwner(EntityTameable par1EntityTameable, float par2, float par3, float par4) {
/*  30 */     this.thePet = par1EntityTameable;
/*  31 */     this.theWorld = par1EntityTameable.worldObj;
/*  32 */     this.followSpeed = par2;
/*  33 */     this.petPathfinder = par1EntityTameable.getNavigator();
/*  34 */     this.minDist = par4;
/*  35 */     this.maxDist = par3;
/*  36 */     setMutexBits(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldExecute() {
/*  44 */     EntityLivingBase var1 = this.thePet.getOwner();
/*     */     
/*  46 */     if (var1 == null)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     this.theOwner = var1;
/*     */     
/*  52 */     if (this.thePet.isSitting())
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     if (this.thePet instanceof Girlfriend && 
/*  57 */       OreSpawnMain.valentines_day != 0) {
/*  58 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  63 */     if (this.thePet != null && (
/*  64 */       this.thePet.posY < 60.0D || !this.thePet.worldObj.isDaytime()) && 
/*  65 */       this.thePet.getDistanceSqToEntity((Entity)var1) > (this.maxDist / 2.0F * this.maxDist / 2.0F))
/*     */     {
/*  67 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (this.thePet.getDistanceSqToEntity((Entity)var1) < (this.maxDist * this.maxDist))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  86 */     if (this.thePet.isSitting()) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (this.petPathfinder.noPath()) {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (this.thePet != null && 
/*  95 */       this.thePet instanceof EntityTameable) {
/*  96 */       EntityTameable gf = this.thePet;
/*  97 */       EntityLivingBase var1 = gf.getOwner();
/*  98 */       if (var1 != null && 
/*  99 */         (int)gf.posZ == (int)var1.posZ && 
/* 100 */         (int)gf.posX == (int)var1.posX && 
/* 101 */         (int)gf.posY < (int)var1.posY + 2 && 
/* 102 */         (int)gf.posY > (int)var1.posY - 2) {
/* 103 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     return (this.thePet.getDistanceSqToEntity((Entity)this.theOwner) > (this.minDist * this.minDist));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 120 */     this.timeToRecalcPath = 0;
/* 121 */     this.oldWaterCost = this.thePet.getNavigator().getAvoidsWater();
/* 122 */     this.thePet.getNavigator().setAvoidsWater(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 130 */     this.theOwner = null;
/* 131 */     this.petPathfinder.clearPathEntity();
/* 132 */     this.thePet.getNavigator().setAvoidsWater(this.oldWaterCost);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTask() {
/* 140 */     this.thePet.getLookHelper().setLookPositionWithEntity((Entity)this.theOwner, 10.0F, this.thePet.getVerticalFaceSpeed());
/*     */     
/* 142 */     if (!this.thePet.isSitting())
/*     */     {
/* 144 */       if (--this.timeToRecalcPath <= 0) {
/*     */         
/* 146 */         this.timeToRecalcPath = 10;
/*     */         
/* 148 */         if (!this.petPathfinder.tryMoveToEntityLiving((Entity)this.theOwner, this.followSpeed))
/*     */         {
/* 150 */           if (this.thePet.getDistanceSqToEntity((Entity)this.theOwner) >= 144.0D) {
/*     */             
/* 152 */             int var1 = MathHelper.floor_double(this.theOwner.posX) - 2;
/* 153 */             int var2 = MathHelper.floor_double(this.theOwner.posZ) - 2;
/* 154 */             int var3 = MathHelper.floor_double(this.theOwner.boundingBox.minY);
/*     */             
/* 156 */             for (int var4 = 0; var4 <= 4; var4++) {
/*     */               
/* 158 */               for (int var5 = 0; var5 <= 4; var5++) {
/*     */                 
/* 160 */                 if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && World.doesBlockHaveSolidTopSurface((IBlockAccess)this.theWorld, var1 + var4, var3 - 1, var2 + var5) && !this.theWorld.getBlock(var1 + var4, var3, var2 + var5).isNormalCube() && !this.theWorld.getBlock(var1 + var4, var3 + 1, var2 + var5).isNormalCube()) {
/*     */                   
/* 162 */                   this.thePet.setLocationAndAngles(((var1 + var4) + 0.5F), var3, ((var2 + var5) + 0.5F), this.thePet.rotationYaw, this.thePet.rotationPitch);
/* 163 */                   this.petPathfinder.clearPathEntity();
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAIFollowOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */