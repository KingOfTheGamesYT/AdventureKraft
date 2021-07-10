package net.Akio.CraftZone.Main.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class KrakenRepellent extends BlockTorch {
    public KrakenRepellent(int par1) {
        setCreativeTab(CreativeTabs.tabRedstone);
        setLightLevel(0.8F);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        double var7 = (double)((float)par2 + 0.5F);
        double var9 = (double)((float)par3 + 0.7F);
        double var11 = (double)((float)par4 + 0.5F);
        double var13 = 0.413D;
        double var15 = 0.271D;
        if (var6 == 1) {
            par1World.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 2) {
            par1World.spawnParticle("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 3) {
            par1World.spawnParticle("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 4) {
            par1World.spawnParticle("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
        } else {
            par1World.spawnParticle("smoke", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("reddust", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
        }

    }

    public int tickRate(World par1World) {
        return 10;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            this.findSomethingToRepell(par1World, par2, par3, par4);
            par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));
        }

    }

    public void onBlockAdded(World world, int x, int y, int z) {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block blockId) {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    private void findSomethingToRepell(World par1World, int par2, int par3, int par4) {
        AxisAlignedBB bb = AxisAlignedBB.getBoundingBox((double)par2 - 20.0D, (double)par3 - 10.0D, (double)par4 - 20.0D, (double)par2 + 20.0D, (double)par3 + 40.0D, (double)par4 + 20.0D);
        List var5 = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Iterator var2 = var5.iterator();
        EntityLivingBase var3 = null;

        while(var2.hasNext()) {
            var3 = (EntityLivingBase)var2.next();
            double d1;
            double d2;
            double d3;
            double f;
            double d;
         /*   if (var3 != null && var3 instanceof Kraken) {
                d1 = var3.posX - (double)par2;
                d2 = var3.posY - 15.0D - (double)par3;
                d3 = var3.posZ - (double)par4;
                f = d1 * d1 + d2 * d2 + d3 * d3;
                f = Math.sqrt(f);
                f = 20.0D - f;
                if (f > 20.0D) {
                    f = 20.0D;
                }

                if (f < 0.0D) {
                    f = 0.0D;
                }

                f *= 0.4D;
                d = (double)((float)Math.atan2(var3.posX - (double)par2, var3.posZ - (double)par4));
                var3.motionX += f * Math.sin(d);
                var3.motionZ += f * Math.cos(d);
            }
*/

        }

    }


}
