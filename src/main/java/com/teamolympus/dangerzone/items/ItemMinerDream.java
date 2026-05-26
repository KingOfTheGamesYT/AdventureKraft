package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.items.base.BaseAKItem;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.TranslationHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import com.teamolympus.dangerzone.world.BaseWorldHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;


public class ItemMinerDream extends BaseAKItem {

    public ItemMinerDream(String name) {
        super(name);
        this.setMaxStackSize(16);
        this.setTextureName(DangerZone.SPECIAL_PREFIX + name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            itemStackIn.stackSize--;
        }

        player.worldObj.playSoundAtEntity(player, "random.explode", 1.0f, 1.5f);

        if (!worldIn.isRemote) {
            final int facingPos = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

            final int SOUTH = 0;
            final int WEST = 1;
            final int NORTH = 2;
            final int EAST = 3;

            final int playerX = (int) player.posX;
            final int playerY = (int) player.posY;
            final int playerZ = (int) player.posZ;

            int newX = playerX;
            int newY = playerY;
            int newZ = playerZ;

            for (int x = -5; x <= 5; x++) {
                for (int y = 0; y <= 5; y++) {
                    for (int z = 0; z <= 50; z++) {
                        switch (facingPos) {
                            case SOUTH:
                                newX = playerX + x;
                                newY = playerY + y;
                                newZ = playerZ + z;
                                break;
                            case NORTH:
                                newX = playerX - x;
                                newY = playerY + y;
                                newZ = playerZ - z;
                                break;
                            case EAST:
                                newX = playerX + z;
                                newY = playerY + y;
                                newZ = playerZ + x;
                                break;
                            case WEST:
                                newX = playerX - z;
                                newY = playerY + y;
                                newZ = playerZ - x;
                                break;
                        }

                        int topPosX = newX;
                        int topPosY = newY + 1;
                        int topPosZ = newZ;

                        Block block = BaseWorldHelper.fasterGetBlock(worldIn, topPosX, topPosY, topPosZ);
                        if (topPosY <= 14 &&
                                block == Blocks.air
                                || block == Blocks.lava
                                || block == Blocks.flowing_lava
                                || block == Blocks.water
                                || block == Blocks.flowing_water) {
                            BaseWorldHelper.setBlockFastNormalPars(worldIn, topPosX, topPosY, topPosZ, Blocks.cobblestone, 0, 2);
                        }

                        if (isValidBreakableBlock(worldIn, newX, newY, newZ)) {
                            BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.air, 0, 3);
                            if (x == 0 && y == 0 && z % 5 == 0 && BaseWorldHelper.fastIsAirBlock(worldIn, newX, newY, newZ)) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, RegistryHandler.extremeTorch, 5, 2);
                            }
                        }

                    }

                }

            }

        }
        return itemStackIn;
    }

    // I am so sorry.....
    private boolean isValidBreakableBlock(World worldIn, int newX, int newY, int newZ) {

        Block block = BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ);

     if (BaseWorldHelper.fastIsAirBlock(worldIn, newX, newY, newZ)) {
           return false;
       }

      final String[] array = DZConfig.finalMinerDreamList;
       final int arrLen = array.length;

       String n = Block.blockRegistry.getNameForObject(block);

        for (int i = 0; i < arrLen; i++)
        {
            if (Objects.equals(n, array[i])) {
                return true;
            }
        }
        return false;



     /**   for (int i = 0; i < arrLen; i++) {
            boolean list1 = strBlock.contains(array[i]);
            boolean list2 = unlocalizedName.contains(array[i]);

            if (list1 || list2) {
                return true;
            }
        }**/


      /**  return
                        block == Blocks.dirt
                        || block == Blocks.stone
                        || block== Blocks.grass
                        || block == Blocks.sand
                        || block == Blocks.sandstone
                        || block == Blocks.water
                        || block == Blocks.flowing_water
                        || block == Blocks.gravel
                        || block == Blocks.netherrack
                        || block == Blocks.end_stone
                        || block == Blocks.lava
                        || block == Blocks.flowing_lava;
       **/

    }


    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean b) {
        super.addInformation(stack, player, tooltip, b);
        for (byte i = 1; i <= 10; i++) {
            tooltip.add(EnumChatFormatting.DARK_GREEN + TranslationHelper.translate("MinerDreamDesc" + i));
        }
    }



}