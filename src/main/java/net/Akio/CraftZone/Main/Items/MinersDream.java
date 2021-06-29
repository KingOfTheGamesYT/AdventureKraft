package net.Akio.CraftZone.Main.Items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MinersDream extends Item {
    public MinersDream(int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
        int deltax = 0;
        int deltaz = 0;
        int dirx = 0;
        int dirz = 0;
        int height = 5;
        int width = 5;
        int length = 64;
        int torches = 5;
        int solid_count = 0;
        if (cposx < 0) {
            dirx = -1;
        }

        if (cposz < 0) {
            dirz = -1;
        }

        int pposx = (int)(Player.posX + 0.99D * (double)dirx);
        int pposy = (int)Player.posY;
        int pposz = (int)(Player.posZ + 0.99D * (double)dirz);
        if (cposx - pposx != 0 && cposz - pposz != 0) {
            return false;
        } else {
            int x = cposx;
            int y = pposy;
            int z = cposz;
            if (cposx - pposx < 0) {
                deltax = -1;
            }

            if (cposx - pposx > 0) {
                deltax = 1;
            }

            if (cposz - pposz < 0) {
                deltaz = -1;
            }

            if (cposz - pposz > 0) {
                deltaz = 1;
            }

            if (deltax == 0 && deltaz == 0) {
                return false;
            } else if (deltax != 0 && deltaz != 0) {
                return false;
            } else {
                Player.worldObj.playSoundAtEntity(Player, "random.explode", 1.0F, 1.5F);
                if (world.isRemote) {
                    return true;
                } else {
                    int k;
                    Block bid;
                    for(int i = 0; i < height; ++i) {
                        for(k = 0; k < length; ++k) {

                            int j;
                            for(j = -width; j <= width; ++j) {
                                bid = world.getBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax);
                                if (bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.flowing_water || bid == Blocks.water || bid == Blocks.flowing_lava || bid == Blocks.lava || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == Blocks.grass || bid == Blocks.cobblestone || bid == Blocks.sandstone || bid == Blocks.sand) {
                                    world.setBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                                }

                                if (i == height - 1) {
                                    bid = world.getBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax);
                                    if (bid != Blocks.air) {
                                        ++solid_count;
                                    }

                                    if (bid == Blocks.lava || bid == Blocks.gravel || bid == Blocks.sand || bid == Blocks.flowing_water || bid == Blocks.water || bid == Blocks.flowing_lava) {
                                         {
                                            world.setBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax, Blocks.cobblestone, 0, 2);
                                        }
                                    }
                                }
                            }

                            if (i == height - 1 && solid_count == 0) {
                                for(j = -width; j <= width; ++j) {
                                    world.setBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                                }
                            }
                        }
                    }

                    for(k = 0; k < length; k += torches) {
                        bid = world.getBlock(x + k * deltax, y - 1, z + k * deltaz);
                        if ((bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == Blocks.bedrock) && world.isAirBlock(x + k * deltax, y, z + k * deltaz)) {
                            world.setBlock(x + k * deltax, y, z + k * deltaz, Blocks.torch, 0, 2);
                        }

                    }

                    if (!Player.capabilities.isCreativeMode) {
                        --par1ItemStack.stackSize;
                    }

                    return true;
                }
            }
        }
    }
}
