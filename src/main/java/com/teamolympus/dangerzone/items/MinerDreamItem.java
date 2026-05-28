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
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;


public class MinerDreamItem extends BaseAKItem {

    public MinerDreamItem(String name) {
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

                        final Block topBlock = BaseWorldHelper.fasterGetBlock(worldIn, topPosX, topPosY, topPosZ);


                        if (topPosY <= 14 &&
                                topBlock == Blocks.air
                                || topBlock == Blocks.lava
                                || topBlock == Blocks.flowing_lava
                                || topBlock == Blocks.water
                                || topBlock == Blocks.flowing_water
                                || topBlock == Blocks.gravel
                                || topBlock == Blocks.sand) {
                            BaseWorldHelper.setBlockFastNormalPars(worldIn, topPosX, topPosY, topPosZ, Blocks.cobblestone, 0, 2);
                        }

                        if (topBlock.canPlaceBlockAt(worldIn, topPosX, topPosY,topPosZ)) {
                            BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.air, 0, 3);
                        }


                        final Block blockBox = BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ);

                        if (isValidBreakableBlock(blockBox)) { // if our block is deemed breakable, replace with air and place torches every 5 blocks.
                            BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.air, 0, 2);
                            if (x == 0 && y == 0 && z % 5 == 0) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, RegistryHandler.extremeTorch, 5, 2);
                            }
                        }

                    }

                }

            }

        }
        return itemStackIn;
    }

    private boolean isValidBreakableBlock(Block block) {

     if (block.getMaterial() == Material.air) {
           return false;
       }

       final String[] blockListArray = DZConfig.finalMinerDreamList;
       final int arrLen = blockListArray.length;

       String blockName = Block.blockRegistry.getNameForObject(block);

        for (int i = 0; i < arrLen; ++i) {
            if (blockName.equals(blockListArray[i])) {
                return true;
            }
        }
        return false;

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