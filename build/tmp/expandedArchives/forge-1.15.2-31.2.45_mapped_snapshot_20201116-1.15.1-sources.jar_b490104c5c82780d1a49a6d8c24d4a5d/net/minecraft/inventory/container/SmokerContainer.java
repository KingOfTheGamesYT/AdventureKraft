package net.minecraft.inventory.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class SmokerContainer extends AbstractFurnaceContainer {
   public SmokerContainer(int id, PlayerInventory playerInventoryIn) {
      super(ContainerType.SMOKER, IRecipeType.SMOKING, id, playerInventoryIn);
   }

   public SmokerContainer(int id, PlayerInventory playerInventoryIn, IInventory inventoryIn, IIntArray p_i50062_4_) {
      super(ContainerType.SMOKER, IRecipeType.SMOKING, id, playerInventoryIn, inventoryIn, p_i50062_4_);
   }
}
