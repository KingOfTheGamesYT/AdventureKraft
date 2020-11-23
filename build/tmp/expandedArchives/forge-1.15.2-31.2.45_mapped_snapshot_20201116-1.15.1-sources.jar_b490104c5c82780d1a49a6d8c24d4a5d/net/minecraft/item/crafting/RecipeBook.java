package net.minecraft.item.crafting;

import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.inventory.container.BlastFurnaceContainer;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.SmokerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RecipeBook {
   protected final Set<ResourceLocation> recipes = Sets.newHashSet();
   protected final Set<ResourceLocation> newRecipes = Sets.newHashSet();
   protected boolean isGuiOpen;
   protected boolean isFilteringCraftable;
   protected boolean isFurnaceGuiOpen;
   protected boolean isFurnaceFilteringCraftable;
   protected boolean isBlastFurnaceGuiOpen;
   protected boolean isBlastFurnaceFilteringCraftable;
   protected boolean isSmokerGuiOpen;
   protected boolean isSmokerFilteringCraftable;

   public void copyFrom(RecipeBook that) {
      this.recipes.clear();
      this.newRecipes.clear();
      this.recipes.addAll(that.recipes);
      this.newRecipes.addAll(that.newRecipes);
   }

   public void unlock(IRecipe<?> recipe) {
      if (!recipe.isDynamic()) {
         this.unlock(recipe.getId());
      }

   }

   protected void unlock(ResourceLocation resourceLocationIn) {
      this.recipes.add(resourceLocationIn);
   }

   public boolean isUnlocked(@Nullable IRecipe<?> recipe) {
      return recipe == null ? false : this.recipes.contains(recipe.getId());
   }

   public boolean func_226144_b_(ResourceLocation p_226144_1_) {
      return this.recipes.contains(p_226144_1_);
   }

   @OnlyIn(Dist.CLIENT)
   public void lock(IRecipe<?> recipe) {
      this.lock(recipe.getId());
   }

   protected void lock(ResourceLocation resourceLocationIn) {
      this.recipes.remove(resourceLocationIn);
      this.newRecipes.remove(resourceLocationIn);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isNew(IRecipe<?> recipe) {
      return this.newRecipes.contains(recipe.getId());
   }

   public void markSeen(IRecipe<?> recipe) {
      this.newRecipes.remove(recipe.getId());
   }

   public void markNew(IRecipe<?> recipe) {
      this.markNew(recipe.getId());
   }

   protected void markNew(ResourceLocation resourceLocationIn) {
      this.newRecipes.add(resourceLocationIn);
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isGuiOpen() {
      return this.isGuiOpen;
   }

   public void setGuiOpen(boolean open) {
      this.isGuiOpen = open;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFilteringCraftable(RecipeBookContainer<?> recipeBookContainerIn) {
      if (recipeBookContainerIn instanceof FurnaceContainer) {
         return this.isFurnaceFilteringCraftable;
      } else if (recipeBookContainerIn instanceof BlastFurnaceContainer) {
         return this.isBlastFurnaceFilteringCraftable;
      } else {
         return recipeBookContainerIn instanceof SmokerContainer ? this.isSmokerFilteringCraftable : this.isFilteringCraftable;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFilteringCraftable() {
      return this.isFilteringCraftable;
   }

   public void setFilteringCraftable(boolean shouldFilter) {
      this.isFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFurnaceGuiOpen() {
      return this.isFurnaceGuiOpen;
   }

   public void setFurnaceGuiOpen(boolean isOpen) {
      this.isFurnaceGuiOpen = isOpen;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFurnaceFilteringCraftable() {
      return this.isFurnaceFilteringCraftable;
   }

   public void setFurnaceFilteringCraftable(boolean shouldFilter) {
      this.isFurnaceFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isBlastFurnaceGuiOpen() {
      return this.isBlastFurnaceGuiOpen;
   }

   public void setBlastFurnaceGuiOpen(boolean shouldFilter) {
      this.isBlastFurnaceGuiOpen = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isBlastFurnaceFilteringCraftable() {
      return this.isBlastFurnaceFilteringCraftable;
   }

   public void setBlastFurnaceFilteringCraftable(boolean shouldFilter) {
      this.isBlastFurnaceFilteringCraftable = shouldFilter;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isSmokerGuiOpen() {
      return this.isSmokerGuiOpen;
   }

   public void setSmokerGuiOpen(boolean isOpen) {
      this.isSmokerGuiOpen = isOpen;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isSmokerFilteringCraftable() {
      return this.isSmokerFilteringCraftable;
   }

   public void setSmokerFilteringCraftable(boolean shouldFilter) {
      this.isSmokerFilteringCraftable = shouldFilter;
   }
}
