package net.minecraft.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FireworkStarItem extends Item {
   public FireworkStarItem(Item.Properties builder) {
      super(builder);
   }

   /**
    * allows items to add custom lines of information to the mouseover description
    */
   @OnlyIn(Dist.CLIENT)
   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      CompoundNBT compoundnbt = stack.getChildTag("Explosion");
      if (compoundnbt != null) {
         func_195967_a(compoundnbt, tooltip);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public static void func_195967_a(CompoundNBT compound, List<ITextComponent> tooltip) {
      FireworkRocketItem.Shape fireworkrocketitem$shape = FireworkRocketItem.Shape.get(compound.getByte("Type"));
      tooltip.add((new TranslationTextComponent("item.minecraft.firework_star.shape." + fireworkrocketitem$shape.getShapeName())).applyTextStyle(TextFormatting.GRAY));
      int[] aint = compound.getIntArray("Colors");
      if (aint.length > 0) {
         tooltip.add(func_200298_a((new StringTextComponent("")).applyTextStyle(TextFormatting.GRAY), aint));
      }

      int[] aint1 = compound.getIntArray("FadeColors");
      if (aint1.length > 0) {
         tooltip.add(func_200298_a((new TranslationTextComponent("item.minecraft.firework_star.fade_to")).appendText(" ").applyTextStyle(TextFormatting.GRAY), aint1));
      }

      if (compound.getBoolean("Trail")) {
         tooltip.add((new TranslationTextComponent("item.minecraft.firework_star.trail")).applyTextStyle(TextFormatting.GRAY));
      }

      if (compound.getBoolean("Flicker")) {
         tooltip.add((new TranslationTextComponent("item.minecraft.firework_star.flicker")).applyTextStyle(TextFormatting.GRAY));
      }

   }

   @OnlyIn(Dist.CLIENT)
   private static ITextComponent func_200298_a(ITextComponent p_200298_0_, int[] p_200298_1_) {
      for(int i = 0; i < p_200298_1_.length; ++i) {
         if (i > 0) {
            p_200298_0_.appendText(", ");
         }

         p_200298_0_.appendSibling(func_200297_a(p_200298_1_[i]));
      }

      return p_200298_0_;
   }

   @OnlyIn(Dist.CLIENT)
   private static ITextComponent func_200297_a(int p_200297_0_) {
      DyeColor dyecolor = DyeColor.byFireworkColor(p_200297_0_);
      return dyecolor == null ? new TranslationTextComponent("item.minecraft.firework_star.custom_color") : new TranslationTextComponent("item.minecraft.firework_star." + dyecolor.getTranslationKey());
   }
}
