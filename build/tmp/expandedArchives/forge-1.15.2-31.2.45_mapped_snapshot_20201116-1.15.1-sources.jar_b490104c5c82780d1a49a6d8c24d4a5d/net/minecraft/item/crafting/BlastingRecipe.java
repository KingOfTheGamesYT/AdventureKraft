package net.minecraft.item.crafting;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BlastingRecipe extends AbstractCookingRecipe {
   public BlastingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
      super(IRecipeType.BLASTING, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
   }

   public ItemStack getIcon() {
      return new ItemStack(Blocks.BLAST_FURNACE);
   }

   public IRecipeSerializer<?> getSerializer() {
      return IRecipeSerializer.BLASTING;
   }
}
