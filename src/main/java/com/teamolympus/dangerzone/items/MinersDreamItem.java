package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.items.base.BaseAKItem;
import com.teamolympus.dangerzone.misc.DZLogger;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.TranslationHelper;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import com.teamolympus.dangerzone.world.BaseWorldHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;


public class MinersDreamItem extends BaseAKItem {

    public static int MINER_DREAM_FLAG = DZConfig.minerDreamFlag;
    public static int MINER_FLAG_COOBLESTONE_TOP = DZConfig.minerDreamFlag;
    public static int MINER_FLAG_COOBLESTONE_BOTTOM = DZConfig.minerDreamFlag;
    public static int MINER_FLAG_AIR_REPLACE = DZConfig.minerDreamFlag;
    public static int MINER_FLAG_TORCH = DZConfig.minerDreamFlag;

    public static int Y_START_SEARCH = 0;
    public static int Y_SEARCH = 5;
    public static int Z_START_SEARCH = 0;
    public static int Z_SEARCH = 50;
    public static int X_START_SEARCH = -5;
    public static int X_END_SEARCH = 5;

    public MinersDreamItem(String name) {
        super(name);
        this.setMaxStackSize(16);
        this.setTextureName(DangerZone.SPECIAL_PREFIX + name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            itemStackIn.stackSize--;
        }

        player.worldObj.playSoundAtEntity(player, "random.explode", 4.0f, 2.5f);

        if (!worldIn.isRemote) {
            final int facingPos = MathHelper.floor_float((player.rotationYaw * 4.0F / 360.0F) + 0.5F) & 3;

            final int SOUTH = 0;
            final int WEST = 1;
            final int NORTH = 2;
            final int EAST = 3;

            final int playerX = MathHelper.floor_double(player.posX);
            final int playerY = MathHelper.floor_double(player.posY);
            final int playerZ = MathHelper.floor_double(player.posZ);

            final int topPozY = playerY + Y_SEARCH + 1;
            final int leftPosX = playerX - X_START_SEARCH - 1;
            final int rightPosX = playerX + X_END_SEARCH + 1;

            int newX = playerX;
            int newY = playerY;
            int newZ = playerZ;


        /**    for (int x = X_START_SEARCH; x <= X_END_SEARCH; x++) {
                for (int y = Y_START_SEARCH; y <= Y_SEARCH; y++) {
                    newY = playerY + y;
                    for (int z = Z_START_SEARCH; z <= Z_SEARCH; z++) {
                        switch (facingPos) {
                            case SOUTH:
                              newX = playerX + x;
                              newZ = playerZ + z;
                              break;
                            case NORTH:
                               newX = playerX - x;
                               newZ = playerZ - z;
                                break;
                            case EAST:
                               newX = playerX + z;
                               newZ = playerZ + x;
                               break;
                            case WEST:
                                newX = playerX - z;
                                newZ = playerZ - x;
                                break;
                        }

                        // our top block
                        final Block topBlock = BaseWorldHelper.fasterGetBlock(worldIn, newX, topPozY, newZ);
                        onAfterGetTopBlock(itemStackIn, worldIn, player, topBlock);
                        final Block leftBlock = BaseWorldHelper.fasterGetBlock(worldIn, leftPosX, newY, newZ);
                        onAfterGetLeftBlock(itemStackIn, worldIn, player, leftBlock);
                        final Block rightBlock = BaseWorldHelper.fasterGetBlock(worldIn, rightPosX, newY, newZ);
                        onAfterGetRightBlock(itemStackIn, worldIn, player, rightBlock);

                        if (isValidToReplaceWithCobble(topPozY, topBlock)) {
                            onTopReplaceWithCoobleHook(itemStackIn, worldIn,player, topBlock, newX, topPozY, newZ);
                        }

                        if (isValidToReplaceWithCobble(newY, leftBlock)) {
                            onTopReplaceWithCoobleHook(itemStackIn, worldIn,player, leftBlock, leftPosX, newY, newZ);
                        }

                        if (isValidToReplaceWithCobble(newY, rightBlock)) {
                            onTopReplaceWithCoobleHook(itemStackIn, worldIn,player, rightBlock, rightPosX, newY, newZ);
                        }

                        // everything else
                        final Block boxBlock = BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ);

                        onAfterGetBoxBlock(itemStackIn, worldIn, player, topBlock);

                        if (isValidToReplaceWithCobble(newY, boxBlock)) {
                            onBottomReplaceWithCoobleHook(itemStackIn, worldIn, player, boxBlock, newX, newY, newZ);
                        } else if (isValidBreakableBlock(boxBlock)) {
                            onValidBreakableBlock(itemStackIn, worldIn, player, boxBlock, newX, newY, newZ);
                            if (x == 0 && y == 0 && z % 5 == 0) {
                                onTorchPlace(itemStackIn, worldIn, player, boxBlock, newX, newY, newZ);
                            }
                        }

                        if (boxBlock instanceof BlockTorch || boxBlock instanceof IGrowable) {
                        boxBlock.onNeighborBlockChange(worldIn, newX, newY, newZ, boxBlock);
                        }

                    }

                }

            }
            **/

        }
        return itemStackIn;
    }

    public boolean isValidToReplaceWithCobble(int height, Block block) {
        return height <= 14 &&
                block == Blocks.air ||
                block == Blocks.lava ||
                block == Blocks.flowing_lava ||
                block == Blocks.water ||
                block == Blocks.flowing_water ||
                block == Blocks.gravel ||
                block == Blocks.sand;
    }


    public boolean isValidBreakableBlock(Block block) {

        if (block.getMaterial() == Material.air) {
            return false;
        }

        final String blockName = Block.blockRegistry.getNameForObject(block);

        final Set<String> list = DZConfig.bannedBlockListAPI;

        return list.contains(blockName);

    }

    public void onTopReplaceWithCoobleHook(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block, int newX, int topPozY, int newZ) {
        BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPozY, newZ, Blocks.cobblestone, 0, MINER_FLAG_COOBLESTONE_TOP);
    }


    public void onBottomReplaceWithCoobleHook(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block, int newX, int topPozY, int newZ) {
        BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPozY, newZ, Blocks.cobblestone, 0, MINER_FLAG_COOBLESTONE_BOTTOM);
    }

    public void onValidBreakableBlock(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block, int newX, int topPozY, int newZ) {
        BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPozY, newZ, Blocks.air, 0, MINER_FLAG_AIR_REPLACE);
    }


    public void onTorchPlace(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block, int newX, int topPozY, int newZ) {
        BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPozY, newZ, RegistryHandler.extremeTorch, 5, MINER_FLAG_TORCH);
    }


    public void onAfterGetTopBlock(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block) {

    }

    public void onAfterGetLeftBlock(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block) {

    }

    public void onAfterGetRightBlock(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block) {

    }

    public void onAfterGetBoxBlock(ItemStack itemStackIn, World worldIn, EntityPlayer player, Block block) {

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