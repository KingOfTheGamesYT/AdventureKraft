package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.init.ContentRegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class AmethystOre extends Block {

    public AmethystOre(String name, float hardness, float resistance, int mininglevel, String tool)
    {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DangerZone.BLOCKS);
        setResistance(12);
        setHardness(10);
        setHarvestLevel("pickaxe",0);

        ContentRegistryHandler.BLOCKS.add(this);
        ContentRegistryHandler.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}