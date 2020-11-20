package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public class BlockMobOre extends Block {
	public BlockMobOre(ResourceLocation name) {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(2,2).harvestTool(ToolType.PICKAXE).harvestLevel(2));
		setRegistryName(name);
	}
}
