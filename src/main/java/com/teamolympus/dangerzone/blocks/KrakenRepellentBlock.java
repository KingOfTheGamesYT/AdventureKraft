package com.teamolympus.dangerzone.blocks;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class KrakenRepellentBlock extends BlockTorch {

    public KrakenRepellentBlock(String name)
    {
        this.setTickRandomly(true);
        this.setCreativeTab(DangerZone.BLOCKS);
        this.setLightLevel(0.8F);
        this.setBlockName(name);
        this.setBlockTextureName(DangerZone.MODID_PREFIX + name);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World p_149738_1_)
    {
        return 10;
    }


    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        super.updateTick(world, x,y,z,random);
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
        findEntityInBoundingBox(world, x, y,z);
    }


    // Borrowed from TileEntityBeaconBlock.java
    public void findEntityInBoundingBox(World world, int x, int y, int z) {
        AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(x - 20, y - 10, z - 20, x + 20, y + 10, z + 10);
        List list = world.getEntitiesWithinAABB(EntityLiving.class, axisalignedbb);

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = (Entity)list.get(i);

            if (entity1 instanceof EntityLiving)
            {
                double posX = entity1.posX - x;
                double posY = entity1.posY - y;
                double posZ = entity1.posZ - z;

                double motionPosX = entity1.motionX;
                double motionPosY = entity1.motionY;
                double motionPosZ = entity1.motionZ;

                double suareRootBlock = x * x + y * y * z * z;

                double squareRootPos = posX * posX + posZ * posZ + posY * posY * motionPosX * motionPosX * motionPosY * motionPosY *motionPosZ * motionPosZ;

                double s = Math.sqrt(squareRootPos);
                double s2 = Math.sqrt(suareRootBlock);

                double newSquareRootPos = s * s2;

                double finalSqaureRoot = Math.sqrt(newSquareRootPos);

                entity1.motionX += finalSqaureRoot * Math.atan(finalSqaureRoot);
                entity1.motionY += finalSqaureRoot * Math.cos(finalSqaureRoot);
                entity1.motionZ += finalSqaureRoot * Math.atan(finalSqaureRoot);


            }
        }

    }


}
