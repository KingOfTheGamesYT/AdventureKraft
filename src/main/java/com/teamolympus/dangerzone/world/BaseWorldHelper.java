package com.teamolympus.dangerzone.world;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class BaseWorldHelper {


    public static boolean fastIsAirBlock(World world, int x, int y, int z)
    {
        Block block = fasterGetBlock(world, x, y, z);
        return block.getMaterial() == Material.air;
    }

    // why was the non metadata one surrounded in try catches???
    public static Block fasterGetBlock(World world, int p_147439_1_, int p_147439_2_, int p_147439_3_)
    {
        //  Chunk chunk = null;
        Chunk chunk = world.getChunkFromChunkCoords(p_147439_1_ >> 4, p_147439_3_ >> 4);
        return fastChunkgetBlock(chunk,p_147439_1_ & 15, p_147439_2_, p_147439_3_ & 15 );
        //   return chunk.getBlock(p_147439_1_ & 15, p_147439_2_, p_147439_3_ & 15);
    }

    public static void setBlockFastNormalPars(World world, int x, int y, int z, Block blockIn, int metadataIn, int flags)
    {
        Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
        Block block1 = null;
        net.minecraftforge.common.util.BlockSnapshot blockSnapshot = null;

        if ((flags & 1) != 0)
        {
            //  block1 = chunk.getBlock(x & 15, y, z & 15);
            block1 = fastChunkgetBlock(chunk, x & 15, y, z & 15);
        }

        if (world.captureBlockSnapshots && !world.isRemote)
        {
            blockSnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(world, x, y, z, flags);
            world.capturedBlockSnapshots.add(blockSnapshot);
        }

       boolean flag = setFastChunk3(chunk, x & 15, y, z & 15, blockIn, metadataIn);

      //  boolean flag = chunk.func_150807_a(x & 15, y, z & 15, blockIn, metadataIn);

        if (!flag && blockSnapshot != null)
        {
            world.capturedBlockSnapshots.remove(blockSnapshot);
            blockSnapshot = null;
        }

        // relight the blocks and stuff!
        world.func_147451_t(x, y, z);


        if (flag && blockSnapshot == null) // Don't notify clients or update physics while capturing blockstates
        {
            world.markAndNotifyBlock(x, y, z, chunk, block1, blockIn, flags);
        }
    }

    public static boolean setFastChunk3(Chunk chunk, int p_150807_1_, int p_150807_2_, int p_150807_3_, Block p_150807_4_, int p_150807_5_)
    {
        //  int i1 = p_150807_3_ << 4 | p_150807_1_;

             Block block1 = chunk.getBlock(p_150807_1_, p_150807_2_, p_150807_3_);
            int k1 = chunk.getBlockMetadata(p_150807_1_, p_150807_2_, p_150807_3_);

        ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[p_150807_2_ >> 4];

        if (extendedblockstorage == null)
        {
            if (p_150807_4_ == Blocks.air)
            {
                return false;
            }
            extendedblockstorage = chunk.getBlockStorageArray()[p_150807_2_ >> 4] = new ExtendedBlockStorage(p_150807_2_ >> 4 << 4, !chunk.worldObj.provider.hasNoSky);
        }

           int l1 = chunk.xPosition * 16 + p_150807_1_;
            int i2 = chunk.zPosition * 16 + p_150807_3_;

            if (!chunk.worldObj.isRemote)
            {
              block1.onBlockPreDestroy(chunk.worldObj, l1, p_150807_2_, i2, k1);
          }

        extendedblockstorage.func_150818_a(p_150807_1_, p_150807_2_ & 15, p_150807_3_, p_150807_4_);
        extendedblockstorage.setExtBlockMetadata(p_150807_1_, p_150807_2_ & 15, p_150807_3_, p_150807_5_); // This line duplicates the one below, so breakBlock fires with valid worldstate

        if (chunk.worldObj.isRemote)
        {
            p_150807_4_.onBlockAdded(chunk.worldObj, l1, p_150807_2_, i2);
        }

        chunk.isModified = true;
        return true;
    }

    private static Block fastChunkgetBlock(Chunk chunk, final int p_150810_1_, final int p_150810_2_, final int p_150810_3_)
    {
        Block block = Blocks.air;

        if (p_150810_2_ >> 4 < chunk.getBlockStorageArray().length)
        {
            ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[p_150810_2_ >> 4];

            if (extendedblockstorage != null)
            {
                block = extendedblockstorage.getBlockByExtId(p_150810_1_, p_150810_2_ & 15, p_150810_3_);
            }
        }

        return block;
    }



    public static void setBlockFastest(World world, int x, int y, int z, Block block, int meta)
    {
        Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
        setFastBlockChunk(chunk, x & 15, y, z & 15, block, meta);
    }

    /**
     * updates our chunk with the lighting data, we need to pass a block as a par.
     */
    private static void manuallyUpdateChunk(World world, int x, int y, int z, Block blockIn, int metadataIn)
    {
        world.func_147451_t(x,y,z); // relight
        Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
        chunk.func_150807_a(x & 15, y, z & 15, blockIn, metadataIn); // relight
    }

    public static boolean manuallyUpdateChunk2(World world, int x, int y, int z, Block blockIn, int metadataIn, int flags)
    {

        Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
        Block block1 = null;
        net.minecraftforge.common.util.BlockSnapshot blockSnapshot = null;

        if ((flags & 1) != 0)
        {
            block1 = chunk.getBlock(x & 15, y, z & 15);
        }

        if (world.captureBlockSnapshots && !world.isRemote)
        {
            blockSnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(world, x, y, z, flags);
            world.capturedBlockSnapshots.add(blockSnapshot);
        }

        boolean flag = chunk.func_150807_a(x & 15, y, z & 15, blockIn, metadataIn);

        if (!flag && blockSnapshot != null)
        {
            world.capturedBlockSnapshots.remove(blockSnapshot);
            blockSnapshot = null;
        }

        world.func_147451_t(x, y, z);

        if (flag && blockSnapshot == null) // Don't notify clients or update physics while capturing blockstates
        {
            // Modularize client and physic updates
            world.markAndNotifyBlock(x, y, z, chunk, block1, blockIn, flags);
        }

        return flag;

    }



    private static boolean setFastBlockChunk(Chunk chunk, int xPos, int yPos, int zPos, Block block, int meta)
    {
        ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[yPos >> 4];

        if (extendedblockstorage == null)
        {
            if (block == Blocks.air)
            {
                return false;
            }

            extendedblockstorage = chunk.getBlockStorageArray()[yPos >> 4] = new ExtendedBlockStorage(yPos >> 4 << 4, !chunk.worldObj.provider.hasNoSky);

            extendedblockstorage.func_150818_a(xPos, yPos & 15, zPos, block);
            extendedblockstorage.setExtBlockMetadata(xPos, yPos & 15, zPos, meta); // This line duplicates the one below, so breakBlock fires with valid worldstate
            return true;
        }


        return true;
    }




}