package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.init.ContentRegistryHandler;

import net.minecraft.item.Item;

public class Amethyst extends Item
{
    public Amethyst (String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DangerZone.TAB);

        ContentRegistryHandler.ITEMS.add(this);
    }


}
