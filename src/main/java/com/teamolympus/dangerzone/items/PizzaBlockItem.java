package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemReed;

public class PizzaBlockItem extends ItemReed
{

    public PizzaBlockItem(String name, Block block) {
        super(block);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.BLOCKS);
        this.setTextureName(DangerZone.FOOD_PREFIX + name);
    }



}
