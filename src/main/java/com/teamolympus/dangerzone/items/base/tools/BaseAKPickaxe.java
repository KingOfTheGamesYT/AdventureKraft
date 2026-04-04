package com.teamolympus.dangerzone.items.base.tools;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BaseAKPickaxe extends ItemPickaxe {

    public BaseAKPickaxe(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }

    protected void dropBlockAsItem(World worldIn, int x, int y, int z, ItemStack itemIn) {
        if (!worldIn.isRemote && worldIn.getGameRules()
            .getGameRuleBooleanValue("doTileDrops") && !worldIn.restoringBlockSnapshots) // do not drop items while
                                                                                         // restoring blockstates,
                                                                                         // prevents item dupe
        {
            /**
             * if (captureDrops.get())
             * {
             * capturedDrops.get().add(itemIn);
             * return;
             * }
             **/
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
