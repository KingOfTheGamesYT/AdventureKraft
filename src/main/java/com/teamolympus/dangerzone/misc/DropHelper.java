package com.teamolympus.dangerzone.misc;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.io.*;


public class DropHelper {

    public static EntityItem dropItemMultipleNonStackable(EntityLiving ent, Item item, int amm, int randomPos) {
        for (int i = 0; i < amm; i++) {
            dropItem(ent, item, 1, randomPos);
        }
        return null;
    }

    public static EntityItem dropItem(EntityLiving ent, Item item, int amm, int randomPos) {
        return dropItemItemStack(ent, item, amm, randomPos);
    }

    public static EntityItem dropItemItemStack(EntityLiving ent, Item item, int amm, int randomPos) {
        return entityDropItem(ent, new ItemStack(item, amm, 0), randomPos);
    }

    public static EntityItem entityDropItem(EntityLiving ent, ItemStack itemStack, int randomPos) {
        if (itemStack.stackSize != 0 && itemStack.getItem() != null) {
            EntityItem entityitem = new EntityItem(ent.worldObj, ent.posX + generateRandomPos(ent, randomPos), ent.posY + generateRandomPos(ent, randomPos), ent.posZ + generateRandomPos(ent, randomPos), itemStack);
            entityitem.delayBeforeCanPickup = 10;
            if (ent.captureDrops) {
                ent.capturedDrops.add(entityitem);
            } else {
                ent.worldObj.spawnEntityInWorld(entityitem);
            }
            return entityitem;
        } else {
            return null;
        }
    }

    private static int generateRandomPos(EntityLiving ent, int randomPos) {
        return ent.getRNG().nextInt(randomPos) - ent.getRNG().nextInt(randomPos);
    }

    public static void dropBlockAsItem(World worldIn, int x, int y, int z, ItemStack itemIn) {

        if (!worldIn.isRemote && worldIn.getGameRules()
                .getGameRuleBooleanValue("doTileDrops") && !worldIn.restoringBlockSnapshots) {
            float f = 0.7F;
            double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(worldIn, (double) x + d0, (double) y + d1, (double) z + d2, itemIn);
            entityitem.delayBeforeCanPickup = 10;
            worldIn.spawnEntityInWorld(entityitem);
        }
    }


   /**  static class Drops {
        Item item;
        int amm;
        int randPos;
        public Drops(Item item, int amm, int randPos) {
            this.item = item;
            this.amm = amm;
            this.randPos = randPos;
        }
    }
    **/

    // TODO: MAKE DROPS NOT HARDCODED, read file a file.
/**    public static void dropLootFromFile(EntityLiving ent, String filename) {
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
**/

  /**  public static void test() {
        try (Writer writer = new FileWriter("AKDrops.json")) {
            Drops drop = new Drops(RegistryHandler.redRock, 6,6);
            Gson gson = new GsonBuilder().create();
            gson.toJson(drop, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test2(EntityLiving ent) {
        try {
            DZLogger.LOGGER.fatal("TEST SHOULD WORK");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Drops deserializedUser = gson.fromJson(new FileReader("AKDrops.json"), Drops.class);
        //    dropItem(ent, deserializedUser.item, deserializedUser.amm, deserializedUser.randPos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
**/


}
