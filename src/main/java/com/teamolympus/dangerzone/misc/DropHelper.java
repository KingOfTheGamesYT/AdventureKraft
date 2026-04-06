package com.teamolympus.dangerzone.misc;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DropHelper {

    public static EntityItem dropItemMultipleNonStackable(EntityLiving ent, Item item, int amm) {
        for (int i = 0; i < amm; i++) {
            dropItem(ent, item, 1);
        }
        return null;
    }

    public static EntityItem dropItem(EntityLiving ent, Item item, int amm)
    {
        return dropItemItemStack(ent, item, amm);
    }

    public static EntityItem dropItemItemStack(EntityLiving ent, Item item, int amm)
    {
        return entityDropItem(ent, new ItemStack(item, amm, 0));
    }

    public static EntityItem entityDropItem(EntityLiving ent, ItemStack itemStack)
    {
        if (itemStack.stackSize != 0 && itemStack.getItem() != null)
        {
            EntityItem entityitem = new EntityItem(ent.worldObj, ent.posX + generateRandomPos(ent), ent.posY + generateRandomPos(ent), ent.posZ + generateRandomPos(ent), itemStack);
            entityitem.delayBeforeCanPickup = 10;
            if (ent.captureDrops)
            {
                ent.capturedDrops.add(entityitem);
            }
            else
            {
                ent.worldObj.spawnEntityInWorld(entityitem);
            }
            return entityitem;
        }
        else
        {
            return null;
        }
    }

    private static int generateRandomPos(EntityLiving ent) {
        return ent.getRNG().nextInt(5) - ent.getRNG().nextInt(5);
    }

}
