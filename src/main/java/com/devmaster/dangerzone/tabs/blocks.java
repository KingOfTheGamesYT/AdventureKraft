package com.devmaster.dangerzone.tabs;

import com.devmaster.dangerzone.init.ContentRegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class blocks extends CreativeTabs
{
    public blocks(String label)
    {
        super("blocks");

    }
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ContentRegistryHandler.AMETHYST_ORE_BLOCK);
    }
}