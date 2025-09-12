package com.devmaster.dangerzone.init;

import com.devmaster.dangerzone.items.Amethyst;
import com.devmaster.dangerzone.items.AmethystOre;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ContentRegistryHandler {

        public static final List<Block> BLOCKS = new ArrayList<Block>();
        public static final List<Item> ITEMS = new ArrayList<Item>();

    //Items
    public static final Item AMETHYST = new Amethyst("amethyst");

    //Blocks
    public static final Block AMETHYST_ORE_BLOCK = new AmethystOre("amethyst_ore_block", 10,12,0,"pickaxe");
    }

