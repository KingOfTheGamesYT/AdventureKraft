package com.teamolympus.dangerzone.blocks;

import java.util.Random;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExtremeTorchBlock extends BlockTorch {

    public ExtremeTorchBlock(String name) {
        this.setTickRandomly(true);
        this.setCreativeTab(DangerZone.BLOCKS);
        this.setLightLevel(1.0F);
        this.setBlockName(name);
        this.setBlockTextureName(DangerZone.MODID_PREFIX + name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    // why does vanilla's not using switch cases???
    public void randomDisplayTick(World worldIn, int x, int y, int z, Random random) {
        int metadata = worldIn.getBlockMetadata(x, y, z);
        double d0 = (double) ((float) x + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
        double d1 = (double) ((float) y + 0.7F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
        double d2 = (double) ((float) z + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        switch (metadata) {
            case 1:
                worldIn.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                break;
            case 2:
                worldIn.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                break;
            case 3:
                worldIn.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
                break;
            case 4:
                worldIn.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                break;
            default:
                worldIn.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
                break;
        }

    }
}
