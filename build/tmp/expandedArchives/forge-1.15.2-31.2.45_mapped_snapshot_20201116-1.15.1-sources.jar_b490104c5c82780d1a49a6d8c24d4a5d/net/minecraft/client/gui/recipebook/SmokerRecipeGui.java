package net.minecraft.client.gui.recipebook;

import java.util.Set;
import net.minecraft.item.Item;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SmokerRecipeGui extends AbstractRecipeBookGui {
   protected boolean func_212962_b() {
      return this.recipeBook.isSmokerFilteringCraftable();
   }

   protected void func_212959_a(boolean p_212959_1_) {
      this.recipeBook.setSmokerFilteringCraftable(p_212959_1_);
   }

   protected boolean func_212963_d() {
      return this.recipeBook.isSmokerGuiOpen();
   }

   protected void func_212957_c(boolean p_212957_1_) {
      this.recipeBook.setSmokerGuiOpen(p_212957_1_);
   }

   protected String func_212960_g() {
      return "gui.recipebook.toggleRecipes.smokable";
   }

   protected Set<Item> func_212958_h() {
      return AbstractFurnaceTileEntity.getBurnTimes().keySet();
   }
}
