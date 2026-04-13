package com.teamolympus.dangerzone.entity.rocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class RockEntity extends EntityThrowable {


    // needed forfor MC
    public RockEntity(World world) {
        super(world);
    }


    public RockEntity(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }



    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition)
    {
    }


    public RockEntity(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
    }


    protected void dropBlockAsItem(World worldIn, int x, int y, int z, ItemStack itemIn) {




        if (!worldIn.isRemote && worldIn.getGameRules()
            .getGameRuleBooleanValue("doTileDrops") && !worldIn.restoringBlockSnapshots) // do not drop items while
                                                                                         // restoring blockstates,
                                                                                         // prevents item dupe
        {
            float f = 0.7F;
            double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(worldIn, (double) x + d0, (double) y + d1, (double) z + d2, itemIn);
            entityitem.delayBeforeCanPickup = 10;
            worldIn.spawnEntityInWorld(entityitem);
        }
    }

}
