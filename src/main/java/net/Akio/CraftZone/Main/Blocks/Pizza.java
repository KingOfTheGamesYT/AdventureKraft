package net.Akio.CraftZone.Main.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Pizza extends Block{

	public Pizza(int par1) {
		super(Material.cake);
		setHardness(0F);
	    setResistance(0F);
	    setCreativeTab(CreativeTabs.tabBlock);
	}
}
