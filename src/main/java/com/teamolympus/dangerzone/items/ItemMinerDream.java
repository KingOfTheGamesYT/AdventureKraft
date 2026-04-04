package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import com.teamolympus.dangerzone.world.BaseWorldHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.items.base.BaseAKItem;
import com.teamolympus.dangerzone.config.DZConfig;

import java.util.List;

public class ItemMinerDream extends BaseAKItem {


    public ItemMinerDream(String name) {
        super(name);
        this.setMaxStackSize(16);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.SPECIAL_PREFIX + name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            itemStackIn.stackSize--;
        }
        player.worldObj.playSoundAtEntity(player, "random.explode", 1.0f, 1.5f);

        if (!worldIn.isRemote) {
            // cached values
            final int facingPos = MathHelper.floor_double((player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

            final int SOUTH = 0;
            final int WEST = 1;
            final int NORTH = 2;
            final int EAST = 3;

            final int playerX = (int) player.posX;
            final int playerY = (int) player.posY;
            final int playerZ = (int) player.posZ;

           // constantly changing values
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


                        boolean replaceWithCobblestoneConditionMet
                                =
                                newY + 1 <= 15 &&
                                BaseWorldHelper.fasterGetBlock(worldIn, newX, newY + 1 + 1, newZ) == Blocks.air
                                || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY + 1, newZ) == Blocks.lava
                                || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY + 1, newZ) == Blocks.flowing_lava
                                || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY + 1, newZ) == Blocks.water
                                || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY + 1, newZ) == Blocks.flowing_water;

                        if (replaceWithCobblestoneConditionMet)
                        {
                            // do not suffocate the player.
                        //    if (playerY != newY) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY + 1, newZ, Blocks.cobblestone, 0, 2);
                        //    }
                        }

                        if (isValidBreakableBlock(worldIn, newX, newY, newZ)) {

                            // don't replace back air blocks
                            if (!BaseWorldHelper.fastIsAirBlock(worldIn, newX, newY, newZ)) {
                                BaseWorldHelper.setBlockFastNormalPars(worldIn, newX, newY, newZ, Blocks.air, 0, 3);
                            }

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


    public boolean isValidBreakableBlock(World worldIn, int newX, int newY, int newZ) {
        // short circuit if we are an air block, don't execute the rest of the list lol...
       if (BaseWorldHelper.fastIsAirBlock(worldIn, newX, newY, newZ)) {
            return false;
        }

    /**      final int arrSize = DZConfig.bannedBlocksStrings.length;
           for (int i = 0; i < arrSize; ++i) {
               if (BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ).toString().contains(DZConfig.bannedBlocksStrings[i])) {
                   return true;
               }
       }
     **/


       return
           BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.grass||
            BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.dirt
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.stone
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.sand
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.gravel
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.snow
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.sandstone
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.flowing_water
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.water
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.lava
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.flowing_water
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.netherrack
           || BaseWorldHelper.fasterGetBlock(worldIn, newX, newY, newZ) == Blocks.end_stone

           ;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean b) {
        tooltip.add("You've gotta try it! Make one.");
       tooltip.add("Now. Take it underground,");
      tooltip.add("tap it on a block in front of you at your feet,");
        tooltip.add("and be amazed! Indeed. It removes blocks from");
        tooltip.add("a large area,");
        tooltip.add("leaving only the ores behind, instantly.");
       tooltip.add("It even lights the place up with torches.");
        tooltip.add("All you need to do is run amok with your");
        tooltip.add("pickaxe and reap the rewards!");
    }

}
