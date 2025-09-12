package com.devmaster.dangerzone.tabs;

import com.devmaster.dangerzone.init.ContentRegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class items  extends CreativeTabs
{
    public items(String label)
    {
        super("tab");

    }
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ContentRegistryHandler.AMETHYST);
    }
}