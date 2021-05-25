/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IRangedAttackMob;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*      */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*      */ import net.minecraft.entity.ai.EntityAIPanic;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.EntityCreeper;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Girlfriend
/*      */   extends EntityTameable
/*      */   implements IRangedAttackMob
/*      */ {
/*   50 */   public int which_girl = 0;
/*   51 */   public int which_wet_girl = 0;
/*   52 */   public int wet_count = 0;
/*   53 */   private int auto_heal = 200;
/*   54 */   private int force_sync = 50;
/*   55 */   private int fight_sound_ticker = 0;
/*   56 */   private int taunt_sound_ticker = 0;
/*   57 */   private int had_target = 0;
/*   58 */   private int voice = 0;
/*   59 */   private int is_princess = 0;
/*   60 */   public MyEntityAIDance Dance = null;
/*   61 */   private float moveSpeed = 0.3F;
/*   62 */   private int voice_enable = 1;
/*   63 */   public int passenger = 0;
/*   64 */   public int feelingBetter = 0;
/*   65 */   private static final ResourceLocation DryTexture0 = new ResourceLocation("orespawn", "girlfriend0.png");
/*   66 */   private static final ResourceLocation DryTexture1 = new ResourceLocation("orespawn", "girlfriend1.png");
/*   67 */   private static final ResourceLocation DryTexture2 = new ResourceLocation("orespawn", "girlfriend2.png");
/*   68 */   private static final ResourceLocation DryTexture3 = new ResourceLocation("orespawn", "girlfriend3.png");
/*   69 */   private static final ResourceLocation DryTexture4 = new ResourceLocation("orespawn", "girlfriend4.png");
/*   70 */   private static final ResourceLocation DryTexture5 = new ResourceLocation("orespawn", "girlfriend5.png");
/*   71 */   private static final ResourceLocation DryTexture6 = new ResourceLocation("orespawn", "girlfriend6.png");
/*   72 */   private static final ResourceLocation DryTexture7 = new ResourceLocation("orespawn", "girlfriend7.png");
/*   73 */   private static final ResourceLocation DryTexture8 = new ResourceLocation("orespawn", "girlfriend8.png");
/*   74 */   private static final ResourceLocation DryTexture9 = new ResourceLocation("orespawn", "girlfriend9.png");
/*   75 */   private static final ResourceLocation DryTexture10 = new ResourceLocation("orespawn", "girlfriend10.png");
/*   76 */   private static final ResourceLocation DryTexture11 = new ResourceLocation("orespawn", "girlfriend11.png");
/*   77 */   private static final ResourceLocation DryTexture12 = new ResourceLocation("orespawn", "girlfriend12.png");
/*   78 */   private static final ResourceLocation DryTexture13 = new ResourceLocation("orespawn", "girlfriend13.png");
/*   79 */   private static final ResourceLocation DryTexture14 = new ResourceLocation("orespawn", "girlfriend14.png");
/*   80 */   private static final ResourceLocation DryTexture15 = new ResourceLocation("orespawn", "girlfriend15.png");
/*   81 */   private static final ResourceLocation DryTexture16 = new ResourceLocation("orespawn", "girlfriend16.png");
/*   82 */   private static final ResourceLocation DryTexture17 = new ResourceLocation("orespawn", "girlfriend17.png");
/*   83 */   private static final ResourceLocation DryTexture18 = new ResourceLocation("orespawn", "girlfriend18.png");
/*   84 */   private static final ResourceLocation DryTexture19 = new ResourceLocation("orespawn", "girlfriend19.png");
/*   85 */   private static final ResourceLocation DryTexture20 = new ResourceLocation("orespawn", "girlfriend20.png");
/*   86 */   private static final ResourceLocation DryTexture21 = new ResourceLocation("orespawn", "girlfriend21.png");
/*   87 */   private static final ResourceLocation DryTexture22 = new ResourceLocation("orespawn", "girlfriend22.png");
/*   88 */   private static final ResourceLocation DryTexture23 = new ResourceLocation("orespawn", "girlfriend23.png");
/*   89 */   private static final ResourceLocation DryTexture24 = new ResourceLocation("orespawn", "girlfriend24.png");
/*   90 */   private static final ResourceLocation DryTexture25 = new ResourceLocation("orespawn", "girlfriend25.png");
/*   91 */   private static final ResourceLocation DryTexture26 = new ResourceLocation("orespawn", "girlfriend26.png");
/*   92 */   private static final ResourceLocation DryTexture27 = new ResourceLocation("orespawn", "girlfriend27.png");
/*   93 */   private static final ResourceLocation DryTexture28 = new ResourceLocation("orespawn", "girlfriend28.png");
/*   94 */   private static final ResourceLocation DryTexture29 = new ResourceLocation("orespawn", "girlfriend29.png");
/*   95 */   private static final ResourceLocation DryTexture30 = new ResourceLocation("orespawn", "girlfriend30.png");
/*   96 */   private static final ResourceLocation DryTexture31 = new ResourceLocation("orespawn", "girlfriend31.png");
/*   97 */   private static final ResourceLocation DryTexture32 = new ResourceLocation("orespawn", "girlfriend32.png");
/*   98 */   private static final ResourceLocation DryTexture33 = new ResourceLocation("orespawn", "girlfriend33.png");
/*   99 */   private static final ResourceLocation DryTexture34 = new ResourceLocation("orespawn", "girlfriend34.png");
/*  100 */   private static final ResourceLocation DryTexture35 = new ResourceLocation("orespawn", "girlfriend35.png");
/*  101 */   private static final ResourceLocation DryTexture36 = new ResourceLocation("orespawn", "girlfriend36.png");
/*  102 */   private static final ResourceLocation DryTexture37 = new ResourceLocation("orespawn", "girlfriend37.png");
/*  103 */   private static final ResourceLocation DryTexture38 = new ResourceLocation("orespawn", "girlfriend38.png");
/*  104 */   private static final ResourceLocation DryTexture39 = new ResourceLocation("orespawn", "girlfriend39.png");
/*  105 */   private static final ResourceLocation DryTexture40 = new ResourceLocation("orespawn", "girlfriend40.png");
/*  106 */   private static final ResourceLocation ValentineTexture = new ResourceLocation("orespawn", "girlfriendv.png");
/*      */   
/*  108 */   private static final ResourceLocation WetTexture0 = new ResourceLocation("orespawn", "bikini0.png");
/*  109 */   private static final ResourceLocation WetTexture1 = new ResourceLocation("orespawn", "bikini1.png");
/*  110 */   private static final ResourceLocation WetTexture2 = new ResourceLocation("orespawn", "bikini2.png");
/*  111 */   private static final ResourceLocation WetTexture3 = new ResourceLocation("orespawn", "bikini3.png");
/*  112 */   private static final ResourceLocation WetTexture4 = new ResourceLocation("orespawn", "bikini4.png");
/*  113 */   private static final ResourceLocation WetTexture5 = new ResourceLocation("orespawn", "bikini5.png");
/*  114 */   private static final ResourceLocation WetTexture6 = new ResourceLocation("orespawn", "bikini6.png");
/*  115 */   private static final ResourceLocation WetTexture7 = new ResourceLocation("orespawn", "bikini7.png");
/*  116 */   private static final ResourceLocation WetTexture8 = new ResourceLocation("orespawn", "bikini8.png");
/*  117 */   private static final ResourceLocation WetTexture9 = new ResourceLocation("orespawn", "bikini9.png");
/*  118 */   private static final ResourceLocation WetTexture10 = new ResourceLocation("orespawn", "bikini10.png");
/*  119 */   private static final ResourceLocation WetTexture11 = new ResourceLocation("orespawn", "bikini11.png");
/*  120 */   private static final ResourceLocation WetTexture12 = new ResourceLocation("orespawn", "bikini12.png");
/*  121 */   private static final ResourceLocation WetTexture13 = new ResourceLocation("orespawn", "bikini13.png");
/*  122 */   private static final ResourceLocation WetTexture14 = new ResourceLocation("orespawn", "bikini14.png");
/*  123 */   private static final ResourceLocation WetTexture15 = new ResourceLocation("orespawn", "bikini15.png");
/*  124 */   private static final ResourceLocation WetTexture16 = new ResourceLocation("orespawn", "bikini16.png");
/*  125 */   private static final ResourceLocation WetTexture17 = new ResourceLocation("orespawn", "bikini17.png");
/*      */   
/*  127 */   private static final ResourceLocation PrincessTexture1 = new ResourceLocation("orespawn", "FrogPrincess.png");
/*  128 */   private static final ResourceLocation PrincessTexture2 = new ResourceLocation("orespawn", "FrogPrincess2.png");
/*      */ 
/*      */   
/*      */   public Girlfriend(World par1World) {
/*  132 */     super(par1World);
/*      */     
/*  134 */     this.which_girl = this.rand.nextInt(41);
/*  135 */     this.which_wet_girl = this.rand.nextInt(18);
/*  136 */     this.voice = this.rand.nextInt(10);
/*  137 */     setSize(0.5F, 1.6F);
/*  138 */     if (OreSpawnMain.valentines_day != 0) setSize(2.5F, 8.0F); 
/*  139 */     this.isImmuneToFire = true;
/*  140 */     this.fireResistance = 100;
/*      */ 
/*      */     
/*  143 */     getNavigator().setAvoidsWater(false);
/*  144 */     setSitting(false);
/*  145 */     this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.4F, 12.0F, 1.5F));
/*  146 */     this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Item.getItemFromBlock((Block)Blocks.red_flower), false));
/*  147 */     this.Dance = new MyEntityAIDance(this);
/*  148 */     this.tasks.addTask(3, this.Dance);
/*  149 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
/*  150 */     this.tasks.addTask(5, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  151 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  152 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  153 */     this.tasks.addTask(8, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*  154 */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  155 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
/*  156 */     this.tasks.addTask(11, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*  157 */     this.targetTasks.addTask(1, new MyValentineTarget((EntityLiving)this, EntityPlayer.class, 16.0F, 0, true, true));
/*  158 */     this.targetTasks.addTask(2, new MyValentineTarget((EntityLiving)this, Boyfriend.class, 16.0F, 0, true, true));
/*      */     
/*  160 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(2, new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityCreeper.class, 20.0F, 0, true, true, IMob.mobSelector));
/*      */     
/*  162 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(3, new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityLiving.class, 15.0F, 0, true, true, IMob.mobSelector));
/*      */     
/*  164 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(4, new MyEntityAIJealousy(this, Girlfriend.class, 6.0F, 5, true)); 
/*  165 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(5, new MyEntityAIJealousy(this, Girlfriend.class, 3.0F, 15, true));
/*      */ 
/*      */     
/*  168 */     this.experienceValue = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  173 */     super.entityInit();
/*      */     
/*  175 */     this.which_girl = this.rand.nextInt(41);
/*  176 */     this.dataWatcher.addObject(20, Integer.valueOf(this.which_girl));
/*  177 */     this.wet_count = 0;
/*  178 */     this.which_wet_girl = this.rand.nextInt(18);
/*  179 */     this.dataWatcher.addObject(22, Integer.valueOf(this.which_wet_girl));
/*  180 */     this.voice = this.rand.nextInt(10);
/*  181 */     this.dataWatcher.addObject(21, Integer.valueOf(this.voice));
/*  182 */     this.dataWatcher.addObject(23, Integer.valueOf(this.voice_enable));
/*  183 */     this.dataWatcher.addObject(24, Integer.valueOf(this.is_princess));
/*  184 */     this.dataWatcher.addObject(25, Integer.valueOf(this.feelingBetter));
/*  185 */     this.auto_heal = 200;
/*  186 */     this.force_sync = 50;
/*  187 */     this.fight_sound_ticker = 0;
/*  188 */     this.taunt_sound_ticker = 0;
/*  189 */     this.had_target = 0;
/*  190 */     setSitting(false);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  195 */     super.applyEntityAttributes();
/*  196 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  197 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  198 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  199 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  205 */     int i = 0;
/*  206 */     ItemStack[] aitemstack = getLastActiveItems();
/*  207 */     int j = aitemstack.length;
/*      */     
/*  209 */     for (int k = 0; k < j; k++) {
/*      */       
/*  211 */       ItemStack itemstack = aitemstack[k];
/*      */       
/*  213 */       if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
/*      */         
/*  215 */         int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
/*  216 */         i += l;
/*      */       } 
/*      */     } 
/*  219 */     if (i < 8) i = 8; 
/*  220 */     if (i > 23) i = 23; 
/*  221 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  229 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  230 */     super.onUpdate();
/*  231 */     this.passenger = 0;
/*  232 */     if (isTamed() && !isSitting()) {
/*  233 */       EntityLivingBase entityLivingBase = getOwner();
/*  234 */       if (entityLivingBase != null && entityLivingBase instanceof EntityPlayer) {
/*  235 */         EntityPlayer p = (EntityPlayer)entityLivingBase;
/*  236 */         Entity r = ((Entity)entityLivingBase).ridingEntity;
/*  237 */         if (r != null && 
/*  238 */           r instanceof Elevator) {
/*      */ 
/*      */           
/*  241 */           float f = -0.45F;
/*  242 */           setPosition(r.posX - f * Math.sin(Math.toRadians(r.rotationYaw)), r.posY, r.posZ + f * Math.cos(Math.toRadians(r.rotationYaw)));
/*      */ 
/*      */           
/*  245 */           this.rotationYaw = r.rotationYaw;
/*  246 */           this.rotationPitch = r.rotationPitch;
/*      */           
/*  248 */           this.limbSwing = this.limbSwingAmount = 0.0F;
/*  249 */           this.fallDistance = 0.0F;
/*  250 */           this.passenger = 1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  264 */     super.writeEntityToNBT(par1NBTTagCompound);
/*  265 */     par1NBTTagCompound.setInteger("GirlType", getTameSkin());
/*  266 */     par1NBTTagCompound.setInteger("WetGirlType", getWetTameSkin());
/*  267 */     par1NBTTagCompound.setInteger("GirlVoice", this.dataWatcher.getWatchableObjectInt(21));
/*  268 */     par1NBTTagCompound.setInteger("GirlVoiceEnable", this.dataWatcher.getWatchableObjectInt(23));
/*  269 */     par1NBTTagCompound.setInteger("IsPrincess", this.dataWatcher.getWatchableObjectInt(24));
/*  270 */     par1NBTTagCompound.setInteger("feelingBetter", this.dataWatcher.getWatchableObjectInt(25));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  279 */     super.readEntityFromNBT(par1NBTTagCompound);
/*  280 */     this.which_girl = par1NBTTagCompound.getInteger("GirlType");
/*  281 */     setTameSkin(this.which_girl);
/*  282 */     this.which_wet_girl = par1NBTTagCompound.getInteger("WetGirlType");
/*  283 */     setWetTameSkin(this.which_wet_girl);
/*  284 */     this.voice = par1NBTTagCompound.getInteger("GirlVoice");
/*  285 */     this.dataWatcher.updateObject(21, Integer.valueOf(this.voice));
/*  286 */     this.voice_enable = par1NBTTagCompound.getInteger("GirlVoiceEnable");
/*  287 */     this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  288 */     this.is_princess = par1NBTTagCompound.getInteger("IsPrincess");
/*  289 */     this.dataWatcher.updateObject(24, Integer.valueOf(this.is_princess));
/*  290 */     this.feelingBetter = par1NBTTagCompound.getInteger("feelingBetter");
/*  291 */     this.dataWatcher.updateObject(25, Integer.valueOf(this.feelingBetter));
/*  292 */     if (OreSpawnMain.valentines_day != 0 && this.feelingBetter != 0) setSize(0.5F, 1.6F);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  300 */     super.updateAITick();
/*      */     
/*  302 */     ItemStack stack = getCurrentEquippedItem();
/*  303 */     EntityLivingBase entityLivingBase = getAttackTarget();
/*  304 */     if (OreSpawnMain.PlayNicely != 0) entityLivingBase = null; 
/*  305 */     if (this.worldObj.rand.nextInt(100) == 1) setRevengeTarget(null); 
/*  306 */     if (this.worldObj.rand.nextInt(200) == 1) setAttackTarget(null);
/*      */     
/*  308 */     if (stack != null && !isSitting())
/*      */     {
/*  310 */       if (entityLivingBase != null) {
/*      */         
/*  312 */         if (entityLivingBase instanceof EntityLivingBase)
/*      */         {
/*  314 */           if (getHeldItem() != null)
/*      */           {
/*  316 */             if (getDistanceToEntity((Entity)entityLivingBase) < 4.0F || (stack.getItem() == OreSpawnMain.MyBertha && getDistanceToEntity((Entity)entityLivingBase) < 10.0F)) {
/*      */               
/*  318 */               this.attackTime--;
/*  319 */               if (this.attackTime <= 0)
/*      */               {
/*  321 */                 this.attackTime = 25;
/*      */                 
/*  323 */                 swingItem();
/*      */                 
/*  325 */                 attackTargetEntityWithCurrentItem((Entity)entityLivingBase);
/*  326 */                 this.fight_sound_ticker--;
/*  327 */                 if (this.fight_sound_ticker <= 0) {
/*      */                   
/*  329 */                   if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:o_fight", 0.5F, getSoundPitch()); 
/*  330 */                   this.fight_sound_ticker = 3;
/*      */                 } 
/*  332 */                 this.had_target = 1;
/*      */               }
/*      */             
/*  335 */             } else if (getDistanceToEntity((Entity)entityLivingBase) < 7.0F && stack.getItem() != OreSpawnMain.MyUltimateBow) {
/*      */               
/*  337 */               this.taunt_sound_ticker--;
/*  338 */               if (this.taunt_sound_ticker <= 0) {
/*      */                 
/*  340 */                 if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:o_taunt", 0.5F, getSoundPitch()); 
/*  341 */                 this.taunt_sound_ticker = 300;
/*      */               } 
/*      */               
/*  344 */               getNavigator().tryMoveToEntityLiving((Entity)entityLivingBase, 1.25D);
/*      */             } 
/*      */           }
/*      */         }
/*      */       } else {
/*      */         
/*  350 */         this.fight_sound_ticker = 0;
/*  351 */         this.attackTime = 0;
/*  352 */         if (this.had_target != 0) {
/*  353 */           this.had_target = 0;
/*  354 */           if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:o_woohoo", 0.4F, getSoundPitch());
/*      */         
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void setPrincess(int par1) {
/*  362 */     this.is_princess = par1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResourceLocation getTexture() {
/*  370 */     if (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0) return ValentineTexture; 
/*  371 */     if (this.wet_count <= 0) {
/*      */       
/*  373 */       int txture = getTameSkin();
/*      */       
/*  375 */       if (this.is_princess == 1) return PrincessTexture1; 
/*  376 */       if (this.is_princess == 2) return PrincessTexture2;
/*      */       
/*  378 */       if (txture == 0) return DryTexture0; 
/*  379 */       if (txture == 1) return DryTexture1; 
/*  380 */       if (txture == 2) return DryTexture2; 
/*  381 */       if (txture == 3) return DryTexture3; 
/*  382 */       if (txture == 4) return DryTexture4; 
/*  383 */       if (txture == 5) return DryTexture5; 
/*  384 */       if (txture == 6) return DryTexture6; 
/*  385 */       if (txture == 7) return DryTexture7; 
/*  386 */       if (txture == 8) return DryTexture8; 
/*  387 */       if (txture == 9) return DryTexture9; 
/*  388 */       if (txture == 10) return DryTexture10; 
/*  389 */       if (txture == 11) return DryTexture11; 
/*  390 */       if (txture == 12) return DryTexture12; 
/*  391 */       if (txture == 13) return DryTexture13; 
/*  392 */       if (txture == 14) return DryTexture14; 
/*  393 */       if (txture == 15) return DryTexture15; 
/*  394 */       if (txture == 16) return DryTexture16; 
/*  395 */       if (txture == 17) return DryTexture17; 
/*  396 */       if (txture == 18) return DryTexture18; 
/*  397 */       if (txture == 19) return DryTexture19; 
/*  398 */       if (txture == 20) return DryTexture20; 
/*  399 */       if (txture == 21) return DryTexture21; 
/*  400 */       if (txture == 22) return DryTexture22; 
/*  401 */       if (txture == 23) return DryTexture23; 
/*  402 */       if (txture == 24) return DryTexture24; 
/*  403 */       if (txture == 25) return DryTexture25; 
/*  404 */       if (txture == 26) return DryTexture26; 
/*  405 */       if (txture == 27) return DryTexture27; 
/*  406 */       if (txture == 28) return DryTexture28; 
/*  407 */       if (txture == 29) return DryTexture29; 
/*  408 */       if (txture == 30) return DryTexture30; 
/*  409 */       if (txture == 31) return DryTexture31; 
/*  410 */       if (txture == 32) return DryTexture32; 
/*  411 */       if (txture == 33) return DryTexture33; 
/*  412 */       if (txture == 34) return DryTexture34; 
/*  413 */       if (txture == 35) return DryTexture35; 
/*  414 */       if (txture == 36) return DryTexture36; 
/*  415 */       if (txture == 37) return DryTexture37; 
/*  416 */       if (txture == 38) return DryTexture38; 
/*  417 */       if (txture == 39) return DryTexture39; 
/*  418 */       if (txture == 40) return DryTexture40;
/*      */     
/*      */     } else {
/*  421 */       int temp = getWetTameSkin();
/*      */       
/*  423 */       if (temp == 0) return WetTexture0; 
/*  424 */       if (temp == 1) return WetTexture1; 
/*  425 */       if (temp == 2) return WetTexture2; 
/*  426 */       if (temp == 3) return WetTexture3; 
/*  427 */       if (temp == 4) return WetTexture4; 
/*  428 */       if (temp == 5) return WetTexture5; 
/*  429 */       if (temp == 6) return WetTexture6; 
/*  430 */       if (temp == 7) return WetTexture7; 
/*  431 */       if (temp == 8) return WetTexture8; 
/*  432 */       if (temp == 9) return WetTexture9; 
/*  433 */       if (temp == 10) return WetTexture10; 
/*  434 */       if (temp == 11) return WetTexture11; 
/*  435 */       if (temp == 12) return WetTexture12; 
/*  436 */       if (temp == 13) return WetTexture13; 
/*  437 */       if (temp == 14) return WetTexture14; 
/*  438 */       if (temp == 15) return WetTexture15; 
/*  439 */       if (temp == 16) return WetTexture16; 
/*  440 */       if (temp == 17) return WetTexture17;
/*      */     
/*      */     } 
/*  443 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTameSkin() {
/*  449 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */   
/*      */   public int getVoice() {
/*  453 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTameSkin(int par1) {
/*  458 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*  459 */     this.which_girl = par1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getWetTameSkin() {
/*  464 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWetTameSkin(int par1) {
/*  469 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*  470 */     this.which_wet_girl = par1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  478 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  484 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {
/*  490 */     float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*      */     
/*  492 */     if (i > 0.0F) {
/*      */       
/*  494 */       if (i > 3.0F) {
/*      */         
/*  496 */         playSound("damage.fallbig", 1.0F, 1.0F);
/*  497 */         i = 3.0F;
/*      */       }
/*      */       else {
/*      */         
/*  501 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*      */       } 
/*      */       
/*  504 */       attackEntityFrom(DamageSource.fall, i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  511 */     if (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0) return 800; 
/*  512 */     return 80;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  521 */     updateArmSwingProgress();
/*      */     
/*  523 */     super.onLivingUpdate();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  529 */     if (isInWater() || handleLavaMovement()) {
/*  530 */       this.wet_count = 500;
/*      */     }
/*  532 */     else if (this.wet_count > 0) {
/*  533 */       this.wet_count--;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  540 */     this.auto_heal--;
/*  541 */     if (this.auto_heal <= 0) {
/*  542 */       if (mygetMaxHealth() > getGirlfriendHealth())
/*      */       {
/*  544 */         heal(1.0F);
/*      */       }
/*      */       
/*  547 */       this.auto_heal = 100;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  555 */     this.force_sync--;
/*  556 */     if (this.force_sync <= 0) {
/*  557 */       this.force_sync = 20;
/*  558 */       if (!this.worldObj.isRemote) {
/*      */         
/*  560 */         this.dataWatcher.updateObject(21, Integer.valueOf(this.voice));
/*  561 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  562 */         this.dataWatcher.updateObject(24, Integer.valueOf(this.is_princess));
/*  563 */         this.dataWatcher.updateObject(25, Integer.valueOf(this.feelingBetter));
/*  564 */         setSitting(isSitting());
/*      */       } else {
/*      */         
/*  567 */         this.voice = getVoice();
/*  568 */         this.voice_enable = this.dataWatcher.getWatchableObjectInt(23);
/*  569 */         int nowfeeling = this.dataWatcher.getWatchableObjectInt(25);
/*  570 */         if (nowfeeling != this.feelingBetter && nowfeeling != 0) {
/*  571 */           this.feelingBetter = nowfeeling;
/*  572 */           setSize(0.5F, 1.6F);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getGirlfriendHealth() {
/*  591 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  599 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */ 
/*      */     
/*  602 */     if (var2 != null)
/*      */     {
/*  604 */       if (var2.stackSize <= 0) {
/*      */         
/*  606 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  607 */         var2 = null;
/*      */       } 
/*      */     }
/*      */     
/*  611 */     if (var2 != null && (var2.getItem() == Item.getItemFromBlock((Block)Blocks.red_flower) || var2.getItem() == Item.getItemFromBlock(OreSpawnMain.CrystalFlowerRedBlock)) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/*  613 */       if (!isTamed()) {
/*      */         
/*  615 */         if (!this.worldObj.isRemote)
/*      */         {
/*  617 */           if (this.rand.nextInt(3) == 0)
/*      */           {
/*  619 */             setTamed(true);
/*  620 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  621 */             playTameEffect(true);
/*  622 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/*  623 */             heal(mygetMaxHealth() - getHealth());
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  628 */             playTameEffect(false);
/*  629 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*  634 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/*  636 */         if (this.worldObj.isRemote) {
/*  637 */           playTameEffect(true);
/*  638 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  641 */         if (mygetMaxHealth() > getHealth()) {
/*  642 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/*      */       } 
/*      */       
/*  646 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  648 */         var2.stackSize--;
/*  649 */         if (var2.stackSize <= 0)
/*      */         {
/*  651 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  654 */       return true;
/*      */     } 
/*  656 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  659 */       if (!this.worldObj.isRemote) {
/*      */         
/*  661 */         setTamed(false);
/*  662 */         func_152115_b("");
/*  663 */         playTameEffect(false);
/*  664 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */       } 
/*      */       
/*  667 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  669 */         var2.stackSize--;
/*  670 */         if (var2.stackSize <= 0)
/*      */         {
/*  672 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  675 */       return true;
/*      */     } 
/*      */     
/*  678 */     if (isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyRuby && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  681 */       if (!this.worldObj.isRemote) {
/*      */         
/*  683 */         this.voice_enable = 0;
/*  684 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  685 */         playTameEffect(true);
/*  686 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */       } 
/*      */       
/*  689 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  691 */         var2.stackSize--;
/*  692 */         if (var2.stackSize <= 0)
/*      */         {
/*  694 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  697 */       return true;
/*      */     } 
/*  699 */     if (isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyAmethyst && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  702 */       if (!this.worldObj.isRemote) {
/*      */         
/*  704 */         this.voice_enable = 1;
/*  705 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  706 */         playTameEffect(true);
/*  707 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */       } 
/*      */       
/*  710 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  712 */         var2.stackSize--;
/*  713 */         if (var2.stackSize <= 0)
/*      */         {
/*  715 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  718 */       return true;
/*      */     } 
/*  720 */     if (isTamed() && var2 != null && (var2.getItem() == Item.getItemFromBlock((Block)Blocks.yellow_flower) || var2.getItem() == Item.getItemFromBlock(OreSpawnMain.CrystalFlowerYellowBlock)) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  723 */       if (!this.worldObj.isRemote)
/*      */       {
/*  725 */         if (this.wet_count > 0 || isInWater() || handleLavaMovement()) {
/*  726 */           this.which_wet_girl++;
/*  727 */           if (this.which_wet_girl > 17) this.which_wet_girl = 0; 
/*  728 */           setWetTameSkin(this.which_wet_girl);
/*  729 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*  730 */           if (isInWater() || handleLavaMovement()) {
/*  731 */             this.wet_count = 500;
/*      */           }
/*      */         } else {
/*  734 */           this.which_girl++;
/*  735 */           if (this.which_girl > 40) this.which_girl = 0; 
/*  736 */           setTameSkin(this.which_girl);
/*  737 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */       }
/*      */       
/*  741 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  743 */         var2.stackSize--;
/*  744 */         if (var2.stackSize <= 0)
/*      */         {
/*  746 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  749 */       return true;
/*  750 */     }  if (isTamed() && var2 != null && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */ 
/*      */       
/*  753 */       if (var2.getItem() instanceof ItemFood) {
/*      */         
/*  755 */         if (!this.worldObj.isRemote) {
/*      */ 
/*      */           
/*  758 */           ItemFood var3 = (ItemFood)var2.getItem();
/*      */           
/*  760 */           if (mygetMaxHealth() > getHealth())
/*      */           {
/*  762 */             heal((var3.getHealAmount(var2) * 5));
/*      */           }
/*      */           
/*  765 */           playTameEffect(true);
/*  766 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  769 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/*  771 */           var2.stackSize--;
/*  772 */           if (var2.stackSize <= 0)
/*      */           {
/*  774 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/*      */       } else {
/*  778 */         if (!this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */           
/*  782 */           playTameEffect(true);
/*  783 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  786 */         ItemStack var3 = getCurrentEquippedItem();
/*  787 */         setCurrentItemOrArmor(0, var2);
/*  788 */         if (var2.getItem() == Items.diamond) {
/*  789 */           setSitting(true);
/*      */         } else {
/*  791 */           setSitting(false);
/*      */         } 
/*      */         
/*  794 */         if (var3 != null) {
/*  795 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
/*      */         } else {
/*      */           
/*  798 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  799 */           Item itm = var2.getItem();
/*  800 */           if (itm instanceof ItemOreSpawnArmor) {
/*  801 */             if (itm == OreSpawnMain.CrystalPinkHelmet || itm == OreSpawnMain.TigersEyeHelmet) {
/*  802 */               ItemStack v4 = getEquipmentInSlot(4);
/*  803 */               setCurrentItemOrArmor(4, var2);
/*  804 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  806 */             if (itm == OreSpawnMain.CrystalPinkBody || itm == OreSpawnMain.TigersEyeBody) {
/*  807 */               ItemStack v4 = getEquipmentInSlot(3);
/*  808 */               setCurrentItemOrArmor(3, var2);
/*  809 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  811 */             if (itm == OreSpawnMain.CrystalPinkLegs || itm == OreSpawnMain.TigersEyeLegs) {
/*  812 */               ItemStack v4 = getEquipmentInSlot(2);
/*  813 */               setCurrentItemOrArmor(2, var2);
/*  814 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  816 */             if (itm == OreSpawnMain.CrystalPinkBoots || itm == OreSpawnMain.TigersEyeBoots) {
/*  817 */               ItemStack v4 = getEquipmentInSlot(1);
/*  818 */               setCurrentItemOrArmor(1, var2);
/*  819 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  825 */       return true;
/*      */     } 
/*  827 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/*  829 */       setSitting(false);
/*  830 */       setTamed(true);
/*  831 */       func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  832 */       playTameEffect(true);
/*  833 */       this.worldObj.setEntityState((Entity)this, (byte)7);
/*  834 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  836 */         var2.stackSize--;
/*  837 */         if (var2.stackSize <= 0)
/*      */         {
/*  839 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  842 */       return true;
/*  843 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  845 */       setCustomNameTag(var2.getDisplayName());
/*  846 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  848 */         var2.stackSize--;
/*  849 */         if (var2.stackSize <= 0)
/*      */         {
/*  851 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  854 */       return true;
/*      */     } 
/*  856 */     if (isTamed() && var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  859 */       ItemStack var3 = getEquipmentInSlot(0);
/*  860 */       int it = 0;
/*  861 */       if (var3 == null) {
/*  862 */         it++;
/*  863 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  865 */       if (var3 == null) {
/*  866 */         it++;
/*  867 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  869 */       if (var3 == null) {
/*  870 */         it++;
/*  871 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  873 */       if (var3 == null) {
/*  874 */         it++;
/*  875 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  877 */       if (var3 != null) {
/*  878 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
/*  879 */         setCurrentItemOrArmor(it, null);
/*  880 */         setSitting(false);
/*  881 */         if (!this.worldObj.isRemote)
/*      */         {
/*  883 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */         }
/*      */       }
/*  886 */       else if (!this.worldObj.isRemote) {
/*      */         
/*  888 */         setSitting(false);
/*  889 */         playTameEffect(true);
/*  890 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  891 */         String healthMessage = new String();
/*  892 */         healthMessage = String.format("I have %d health. Thank you for asking! xoxo", new Object[] { Integer.valueOf(getGirlfriendHealth()) });
/*      */ 
/*      */         
/*  895 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*      */       
/*  898 */       return true;
/*      */     } 
/*      */     
/*  901 */     return super.interact(par1EntityPlayer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  909 */     return (par1ItemStack != null && par1ItemStack.getItem() == Item.getItemFromBlock((Block)Blocks.red_flower));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  917 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  925 */     if (isSitting() || this.voice_enable == 0)
/*      */     {
/*  927 */       return null;
/*      */     }
/*  929 */     if (this.Dance.is_dancing != 0) return null;
/*      */     
/*  931 */     if (this.rand.nextInt(11) == 1) {
/*      */       
/*  933 */       EntityLivingBase entityLivingBase = getAttackTarget();
/*  934 */       if (entityLivingBase != null) {
/*  935 */         return null;
/*      */       }
/*      */       
/*  938 */       if (isInWater() || handleLavaMovement()) {
/*  939 */         return "orespawn:o_water";
/*      */       }
/*      */       
/*  942 */       if (this.rand.nextInt(4) != 0) {
/*      */         
/*  944 */         if (this.posY < 60.0D) {
/*  945 */           return null;
/*      */         }
/*      */         
/*  948 */         if (this.worldObj.isThundering()) {
/*  949 */           return "orespawn:o_thunder";
/*      */         }
/*      */         
/*  952 */         if (this.worldObj.isRaining()) {
/*  953 */           return "orespawn:o_rain";
/*      */         }
/*      */         
/*  956 */         if (!this.worldObj.isDaytime() && 
/*  957 */           this.worldObj.canBlockSeeTheSky((int)this.posX, (int)this.posY, (int)this.posZ)) {
/*  958 */           if (this.worldObj.rand.nextInt(3) == 0) return "orespawn:o_dark"; 
/*  959 */           return null;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  964 */       if (isTamed()) {
/*      */         
/*  966 */         if (mygetMaxHealth() > getHealth() || (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0)) {
/*  967 */           return "orespawn:o_hurt";
/*      */         }
/*  969 */         return "orespawn:o_happy";
/*      */       } 
/*  971 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  975 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  984 */     if (this.voice_enable == 0)
/*      */     {
/*  986 */       return null;
/*      */     }
/*  988 */     return "orespawn:o_ow";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  996 */     return isTamed() ? "orespawn:o_death_girlfriend" : "orespawn:o_death_single";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/* 1004 */     return 0.3F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/* 1012 */     return Item.getItemFromBlock((Block)Blocks.red_flower);
/*      */   }
/*      */ 
/*      */   
/*      */   private void dropItemRand(Item index, int par1) {
/* 1017 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*      */     
/* 1019 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/* 1027 */     int var3 = 0;
/*      */     
/* 1029 */     if (isTamed()) {
/*      */       
/* 1031 */       var3 = this.rand.nextInt(5);
/* 1032 */       var3 += 2;
/* 1033 */       for (int i = 0; i < var3; i++)
/*      */       {
/* 1035 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1040 */     Item v6 = OreSpawnMain.MyItemShoes;
/* 1041 */     Item v7 = OreSpawnMain.MyItemShoes_1;
/* 1042 */     Item v8 = OreSpawnMain.MyItemShoes_2;
/* 1043 */     Item v9 = OreSpawnMain.MyItemShoes_3;
/*      */     
/* 1045 */     var3 = this.rand.nextInt(16);
/* 1046 */     var3 += 4; int var4;
/* 1047 */     for (var4 = 0; var4 < var3; var4++)
/*      */     {
/* 1049 */       dropItem(v6, 1);
/*      */     }
/*      */     
/* 1052 */     var3 = this.rand.nextInt(16);
/* 1053 */     var3 += 4;
/* 1054 */     for (var4 = 0; var4 < var3; var4++)
/*      */     {
/* 1056 */       dropItem(v7, 1);
/*      */     }
/*      */     
/* 1059 */     var3 = this.rand.nextInt(16);
/* 1060 */     var3 += 4;
/* 1061 */     for (var4 = 0; var4 < var3; var4++)
/*      */     {
/* 1063 */       dropItem(v8, 1);
/*      */     }
/*      */     
/* 1066 */     var3 = this.rand.nextInt(16);
/* 1067 */     var3 += 4;
/* 1068 */     for (var4 = 0; var4 < var3; var4++)
/*      */     {
/* 1070 */       dropItem(v9, 1);
/*      */     }
/*      */ 
/*      */     
/* 1074 */     if (isTamed()) {
/*      */       
/* 1076 */       ItemStack var5 = getCurrentEquippedItem();
/* 1077 */       if (var5 != null && 
/* 1078 */         var5.stackSize > 0) {
/* 1079 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1082 */       var5 = getEquipmentInSlot(1);
/* 1083 */       if (var5 != null && 
/* 1084 */         var5.stackSize > 0) {
/* 1085 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1088 */       var5 = getEquipmentInSlot(2);
/* 1089 */       if (var5 != null && 
/* 1090 */         var5.stackSize > 0) {
/* 1091 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1094 */       var5 = getEquipmentInSlot(3);
/* 1095 */       if (var5 != null && 
/* 1096 */         var5.stackSize > 0) {
/* 1097 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1100 */       var5 = getEquipmentInSlot(4);
/* 1101 */       if (var5 != null && 
/* 1102 */         var5.stackSize > 0) {
/* 1103 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving) {
/* 1113 */     ItemStack it = null;
/* 1114 */     if (this.isSwingInProgress) {
/*      */       return;
/*      */     }
/*      */     
/* 1118 */     it = getCurrentEquippedItem();
/* 1119 */     if (it != null && it.getItem() == OreSpawnMain.MyUltimateBow) {
/*      */       
/* 1121 */       EntityArrow var8 = new UltimateArrow(this.worldObj, (EntityLiving)this, par1EntityLiving, 2.0F, 10.0F);
/*      */ 
/*      */       
/* 1124 */       if (this.worldObj.rand.nextInt(4) == 1) var8.setIsCritical(true);
/*      */       
/* 1126 */       int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, it);
/* 1127 */       if (var10 > 0)
/*      */       {
/* 1129 */         var8.setKnockbackStrength(var10);
/*      */       }
/*      */       
/* 1132 */       if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, it) > 0)
/*      */       {
/* 1134 */         var8.setFire(100);
/*      */       }
/*      */       
/* 1137 */       it.damageItem(1, (EntityLivingBase)this);
/* 1138 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (this.worldObj.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/*      */       
/* 1140 */       var8.canBePickedUp = 2;
/*      */       
/* 1142 */       this.worldObj.spawnEntityInWorld((Entity)var8);
/*      */     } else {
/*      */       
/* 1145 */       Shoes var2 = new Shoes(this.worldObj, (EntityLivingBase)this, 2 + this.rand.nextInt(4));
/* 1146 */       double var3 = par1EntityLiving.posX - this.posX;
/* 1147 */       double var5 = par1EntityLiving.posY + par1EntityLiving.getEyeHeight() - 1.1D - var2.posY;
/* 1148 */       double var7 = par1EntityLiving.posZ - this.posZ;
/* 1149 */       float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1150 */       var2.setThrowableHeading(var3, var5 + var9, var7, 1.8F, 4.0F);
/* 1151 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1152 */       this.worldObj.spawnEntityInWorld((Entity)var2);
/*      */     } 
/* 1154 */     swingItem();
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack getCurrentEquippedItem() {
/* 1159 */     return getEquipmentInSlot(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackTargetEntityWithCurrentItem(Entity par1Entity) {
/* 1167 */     ItemStack stack = getCurrentEquippedItem();
/*      */ 
/*      */     
/* 1170 */     if (stack != null) {
/*      */       
/* 1172 */       float var2 = 0.0F;
/*      */       
/* 1174 */       if (isPotionActive(Potion.damageBoost))
/*      */       {
/* 1176 */         var2 += (3 << getActivePotionEffect(Potion.damageBoost).getAmplifier());
/*      */       }
/*      */       
/* 1179 */       if (isPotionActive(Potion.weakness))
/*      */       {
/* 1181 */         var2 -= (2 << getActivePotionEffect(Potion.weakness).getAmplifier());
/*      */       }
/*      */       
/* 1184 */       int var3 = 0;
/* 1185 */       float var4 = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
/*      */       
/* 1187 */       if (par1Entity instanceof EntityLiving) {
/*      */         
/* 1189 */         var4 += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/* 1190 */         var3 += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*      */       } 
/*      */       
/* 1193 */       if (isSprinting())
/*      */       {
/* 1195 */         var3++;
/*      */       }
/*      */       
/* 1198 */       if (var2 > 0.0F || var4 > 0.0F) {
/*      */         
/* 1200 */         boolean var5 = (this.fallDistance > 0.0F && !this.onGround && !isOnLadder() && !isInWater() && !handleLavaMovement() && !isPotionActive(Potion.blindness) && this.ridingEntity == null && par1Entity instanceof EntityLiving);
/*      */         
/* 1202 */         if (var5)
/*      */         {
/* 1204 */           var2 += this.rand.nextInt((int)var2 / 2 + 2);
/*      */         }
/*      */         
/* 1207 */         var2 += var4;
/* 1208 */         boolean var6 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*      */         
/* 1210 */         if (var6)
/*      */         {
/* 1212 */           if (var3 > 0) {
/*      */             
/* 1214 */             par1Entity.addVelocity((-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * var3 * 0.5F), 0.1D, (MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * var3 * 0.5F));
/* 1215 */             this.motionX *= 0.6D;
/* 1216 */             this.motionZ *= 0.6D;
/* 1217 */             setSprinting(false);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1223 */         ItemStack var7 = getCurrentEquippedItem();
/*      */ 
/*      */         
/* 1226 */         if (par1Entity instanceof EntityLiving) {
/*      */ 
/*      */           
/* 1229 */           int var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var7);
/*      */           
/* 1231 */           if (var8 > 0 && var6)
/*      */           {
/* 1233 */             par1Entity.setFire(var8 * 4);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/* 1249 */     return (this.voice - 5) * 0.02F + 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/* 1255 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackEntityWithRangedAttack(EntityLivingBase entityliving, float f) {
/* 1261 */     attackEntityWithRangedAttack(entityliving);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 1269 */     boolean ret = false;
/* 1270 */     float p2 = par2;
/* 1271 */     if (p2 > 10.0F) p2 = 10.0F; 
/* 1272 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 1273 */       if (par1DamageSource.getDamageType().equals("inWall") && 
/* 1274 */         OreSpawnMain.valentines_day != 0) {
/* 1275 */         return ret;
/*      */       }
/*      */       
/* 1278 */       if (OreSpawnMain.valentines_day != 0 && !this.worldObj.isRemote && this.feelingBetter == 0) {
/* 1279 */         Entity e = par1DamageSource.getEntity();
/* 1280 */         if (e != null && e instanceof EntityPlayer) {
/* 1281 */           EntityPlayer eb = (EntityPlayer)e;
/* 1282 */           ItemStack ist = eb.getCurrentEquippedItem();
/* 1283 */           if (ist != null) {
/* 1284 */             Item it = ist.getItem();
/* 1285 */             if (it == OreSpawnMain.MyRoseSword) {
/* 1286 */               if (this.worldObj.rand.nextInt(4) == 1) {
/* 1287 */                 this.feelingBetter = 1;
/* 1288 */                 setAttackTarget(null);
/* 1289 */                 setSize(0.5F, 1.6F);
/* 1290 */                 getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 1291 */                 int morelove = this.worldObj.rand.nextInt(10);
/* 1292 */                 for (int i = 0; i < 10 + morelove; i++) {
/* 1293 */                   dropItemRand(OreSpawnMain.MyLove, 1);
/*      */                 }
/*      */               } else {
/* 1296 */                 dropItemRand(OreSpawnMain.MyLove, 1);
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1303 */       ret = super.attackEntityFrom(par1DamageSource, p2);
/*      */     } 
/*      */     
/* 1306 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/* 1315 */     for (int k = -3; k < 3; k++) {
/*      */       
/* 1317 */       for (int j = -3; j < 3; j++) {
/*      */         
/* 1319 */         for (int i = 0; i < 5; i++) {
/*      */           
/* 1321 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 1322 */           if (bid == Blocks.mob_spawner) {
/* 1323 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 1324 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 1325 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 1326 */             if (s != null && 
/* 1327 */               s.equals("Girlfriend")) {
/* 1328 */               return true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1336 */     return super.getCanSpawnHere();
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Girlfriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */