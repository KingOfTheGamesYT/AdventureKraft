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
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;


public class MinerDreamItem extends BaseAKItem {

    public static final int MINER_DREAM_FLAG = DZConfig.minerDreamFlag;


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
                    newY = playerY + y;
                    for (int z = 0; z <= 50; z++) {
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


                        if (!(y == 5)) {
                            final Block blockBox = BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ);
                            if (newY <= 14 &&
                                    blockBox == Blocks.air ||
                                    blockBox == Blocks.lava
                                    || blockBox == Blocks.flowing_lava
                                    || blockBox == Blocks.water
                                    || blockBox == Blocks.flowing_water
                                    || blockBox == Blocks.gravel
                                    || blockBox == Blocks.sand) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.cobblestone, 0, MINER_DREAM_FLAG);
                            } else if (isValidBreakableBlock(blockBox)) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.air, 0, MINER_DREAM_FLAG);
                                if (x == 0 && y == 0 && z % 5 == 0) {
                                    BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, RegistryHandler.extremeTorch, 5, MINER_DREAM_FLAG);
                                }

                            }
                        } else {
                            int topPosY = newY + 1;
                            final Block topBlock = BaseWorldHelper.fasterGetBlock(worldIn, newX, topPosY, newZ);

                            if (topPosY <= 14 &&
                                    topBlock == Blocks.air ||
                                    topBlock == Blocks.lava
                                    || topBlock == Blocks.flowing_lava
                                    || topBlock == Blocks.water
                                    || topBlock == Blocks.flowing_water
                                    || topBlock == Blocks.gravel
                                    || topBlock == Blocks.sand) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPosY, newZ, Blocks.cobblestone, 0, MINER_DREAM_FLAG);
                            } else {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, topPosY, newZ, Blocks.air, 0, MINER_DREAM_FLAG);
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

        final String blockName = Block.blockRegistry.getNameForObject(block);

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