package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemMobOre extends BlockItem {

    public BlockItemMobOre(Block block) {
        super(block, new Item.Properties().group(DangerZone.PETRIFIED_ORES));
        }

    }
