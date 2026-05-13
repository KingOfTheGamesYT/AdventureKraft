package com.teamolympus.dangerzone.misc;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DropHelper {

    public static EntityItem dropItemMultipleNonStackable(EntityLiving ent, Item item, int amm, int randomPos) {
        for (int i = 0; i < amm; i++) {
            dropItem(ent, item, 1, randomPos);
        }
        return null;
    }

    public static EntityItem dropItem(EntityLiving ent, Item item, int amm, int randomPos)
    {
        return dropItemItemStack(ent, item, amm, randomPos);
    }

    public static EntityItem dropItemItemStack(EntityLiving ent, Item item, int amm, int randomPos)
    {
        return entityDropItem(ent, new ItemStack(item, amm, 0), randomPos);
    }

    public static EntityItem entityDropItem(EntityLiving ent, ItemStack itemStack, int randomPos)
    {
        if (itemStack.stackSize != 0 && itemStack.getItem() != null)
        {
            EntityItem entityitem = new EntityItem(ent.worldObj, ent.posX + generateRandomPos(ent, randomPos), ent.posY + generateRandomPos(ent, randomPos), ent.posZ + generateRandomPos(ent, randomPos), itemStack);
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

    private static int generateRandomPos(EntityLiving ent, int randomPos) {
        return ent.getRNG().nextInt(randomPos) - ent.getRNG().nextInt(randomPos);
    }


     class Drops {
        Item item;
        int amm;
        int randPos;
    }

    // TODO: MAKE DROPS NOT HARDCODED, read file a file.
    public static void dropLootFromFile(EntityLiving ent, String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            Drops item = (Drops) in.readObject();
            dropItemItemStack(ent, item.item, item.amm, item.randPos);
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



}
