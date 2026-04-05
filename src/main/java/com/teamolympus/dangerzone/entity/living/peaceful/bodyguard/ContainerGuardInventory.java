package com.teamolympus.dangerzone.entity.living.peaceful.bodyguard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGuardInventory extends Container {

    private IInventory inventory;
    private BodyguardEntity bodyguardEntity;

    public ContainerGuardInventory(IInventory playerInv, final IInventory mobInv, final BodyguardEntity bodyguardEntity)
    {
        this.inventory = mobInv;
        this.bodyguardEntity = bodyguardEntity;
        byte b0 = 3;
        mobInv.openInventory();
        int i = (b0 - 4) * 18;
        this.addSlotToContainer(new Slot(mobInv, 0, 8, 18)
        {
            /**
             * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
             */
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                return super.isItemValid(p_75214_1_) /**&& p_75214_1_.getItem() == Items.saddle**/ && !this.getHasStack();
            }
        });
        this.addSlotToContainer(new Slot(mobInv, 1, 8, 36)
        {
            /**
             * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
             */
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                return true;
               // return super.isItemValid(p_75214_1_) && bodyguardEntity.func_110259_cr() && BodyguardEntity.func_146085_a(p_75214_1_.getItem());
            }
            @SideOnly(Side.CLIENT)
            public boolean func_111238_b()
            {
                return true;
               // return bodyguardEntity.func_110259_cr();
            }
        });
        int j;
        int k;

        if (bodyguardEntity.isTamed())
        {
            for (j = 0; j < b0; ++j)
            {
                for (k = 0; k < 5; ++k)
                {
                    this.addSlotToContainer(new Slot(mobInv, 2 + k + j * 5, 80 + k * 18, 18 + j * 18));
                }
            }
        }

        for (j = 0; j < 3; ++j)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));
            }
        }

        for (j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 160 + i));
        }
    }

    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.inventory.isUseableByPlayer(p_75145_1_) && this.bodyguardEntity.isEntityAlive() && this.bodyguardEntity.getDistanceToEntity(p_75145_1_) < 8.0F;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < this.inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (this.getSlot(1).isItemValid(itemstack1) && !this.getSlot(1).getHasStack())
            {
                if (!this.mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (this.getSlot(0).isItemValid(itemstack1))
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (this.inventory.getSizeInventory() <= 2 || !this.mergeItemStack(itemstack1, 2, this.inventory.getSizeInventory(), false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.inventory.closeInventory();
    }
}
