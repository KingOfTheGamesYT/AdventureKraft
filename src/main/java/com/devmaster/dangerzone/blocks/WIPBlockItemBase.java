package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class WIPBlockItemBase extends BlockItem {

    public WIPBlockItemBase(Block block) {
        super(block, new Properties().group(DangerZone.WIP));
    }
}
