package com.teamolympus.dangerzone.blocks;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.block.BlockCake;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PizzaBlock extends BlockCake {

    public PizzaBlock(String name) {
        this.setBlockName(name);
        this.setBlockTextureName(DangerZone.MODID_PREFIX + name);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeCloth);
        this.disableStats();
    }


    static final float yInitPos = 0.125f;
    float magic2 = 0.1f;

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, int x, int y, int z)
    {
        int l = worldIn.getBlockMetadata(x, y, z);
        float minZ = 0.0625F;
        float minX = (float)(1 + l * 2) / 16.0F;
       // float maxY = 0.5F;
        float maxY = yInitPos;
        this.setBlockBounds(minX, 0.0F, minZ, 1.0F - minZ, maxY, 1.0F - minZ);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    @Override
    public void setBlockBoundsForItemRender()
    {
        float zPos = 0.0625F;
        float yPos = this.yInitPos;
        this.setBlockBounds(zPos, 0.0F, zPos, 1.0F - zPos, yPos, 1.0F - zPos);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        int l = worldIn.getBlockMetadata(x, y, z);
        float zPos = 0.0625F;
        float xPos = (float)(1 + l * 2) / 16.0F;
       // float yPos = 0.5F;
        float yPos = this.yInitPos;
        return AxisAlignedBB.getBoundingBox((double)((float)x + xPos), (double)y, (double)((float)z + zPos), (double)((float)(x + 1) - zPos), (double)((float)y + yPos - zPos), (double)((float)(z + 1) - zPos));
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z)
    {
        int l = worldIn.getBlockMetadata(x, y, z);
        float zPos = 0.0625F;
        float xPos = (float)(1 + l * 2) / 16.0F;
       // float yPos = 0.5F;
        float yPos = this.yInitPos;
        return AxisAlignedBB.getBoundingBox((double)((float)x + xPos), (double)y, (double)((float)z + zPos), (double)((float)(x + 1) - zPos), (double)((float)y + yPos), (double)((float)(z + 1) - zPos));
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        this.onEat(world, x, y, z, player);
    }

    private void onEat(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_)
    {
        if (p_150036_5_.canEat(false))
        {
            p_150036_5_.getFoodStats().addStats(DZConfig.pizzaFoodLevels, DZConfig.pizzaSatLevels);
            int l = p_150036_1_.getBlockMetadata(p_150036_2_, p_150036_3_, p_150036_4_) + 1;

            if (l >= 6)
            {
                p_150036_1_.setBlockToAir(p_150036_2_, p_150036_3_, p_150036_4_);
            }
            else
            {
                p_150036_1_.setBlockMetadataWithNotify(p_150036_2_, p_150036_3_, p_150036_4_, l, 2);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, int x, int y, int z)
    {
        return RegistryHandler.pizzaItem;
    }

}
