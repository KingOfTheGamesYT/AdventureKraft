package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemMobOre extends BlockItem {

	public BlockItemMobOre(Block blockIn) {
		super(blockIn, new Item.Properties().group(DangerZone.PETRIFIED_ORES));
		setRegistryName(blockIn.getRegistryName());
	}
}
