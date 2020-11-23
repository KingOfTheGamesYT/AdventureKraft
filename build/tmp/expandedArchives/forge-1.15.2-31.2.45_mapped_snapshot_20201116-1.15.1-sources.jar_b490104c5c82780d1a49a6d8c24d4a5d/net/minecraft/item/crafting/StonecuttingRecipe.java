package net.minecraft.item.crafting;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class StonecuttingRecipe extends SingleItemRecipe {
   public StonecuttingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn) {
      super(IRecipeType.STONECUTTING, IRecipeSerializer.STONECUTTING, idIn, groupIn, ingredientIn, resultIn);
   }

   /**
    * Used to check if a recipe matches current crafting inventory
    */
   public boolean matches(IInventory inv, World worldIn) {
      return this.ingredient.test(inv.getStackInSlot(0));
   }

   public ItemStack getIcon() {
      return new ItemStack(Blocks.STONECUTTER);
   }
}
