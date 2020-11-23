package net.minecraft.util.math.shapes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class EntitySelectionContext implements ISelectionContext {
   protected static final ISelectionContext DUMMY = new EntitySelectionContext(false, -Double.MAX_VALUE, Items.AIR) {
      public boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_) {
         return p_216378_3_;
      }
   };
   private final boolean sneaking;
   private final double posY;
   private final Item item;

   protected EntitySelectionContext(boolean sneaking, double posYIn, Item itemIn) {
      this(null, sneaking, posYIn, itemIn);
   }

   protected EntitySelectionContext(@javax.annotation.Nullable Entity entityIn, boolean sneaking, double posYIn, Item itemIn) {
      this.entity = entityIn;
      this.sneaking = sneaking;
      this.posY = posYIn;
      this.item = itemIn;
   }

   @Deprecated
   protected EntitySelectionContext(Entity entityIn) {
      this(entityIn, entityIn.isDescending(), entityIn.getPosY(), entityIn instanceof LivingEntity ? ((LivingEntity)entityIn).getHeldItemMainhand().getItem() : Items.AIR);
   }

   public boolean hasItem(Item itemIn) {
      return this.item == itemIn;
   }

   public boolean getPosY() {
      return this.sneaking;
   }

   public boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_) {
      return this.posY > (double)pos.getY() + shape.getEnd(Direction.Axis.Y) - (double)1.0E-5F;
   }

   private final @javax.annotation.Nullable Entity entity;

   @Override
   public @javax.annotation.Nullable Entity getEntity() {
      return entity;
   }
}