package net.minecraft.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BannerPatternItem extends Item {
   private final BannerPattern pattern;

   public BannerPatternItem(BannerPattern patternIn, Item.Properties builder) {
      super(builder);
      this.pattern = patternIn;
   }

   public BannerPattern getBannerPattern() {
      return this.pattern;
   }

   /**
    * allows items to add custom lines of information to the mouseover description
    */
   @OnlyIn(Dist.CLIENT)
   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      tooltip.add(this.getPatternDescription().applyTextStyle(TextFormatting.GRAY));
   }

   @OnlyIn(Dist.CLIENT)
   public ITextComponent getPatternDescription() {
      return new TranslationTextComponent(this.getTranslationKey() + ".desc");
   }
}
