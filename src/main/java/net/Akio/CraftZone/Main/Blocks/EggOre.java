package net.Akio.CraftZone.Main.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EggOre extends Block{

	public EggOre(int par1) {
		super(Material.iron);
		setHardness(4.0F);
	    setResistance(4.0F);
		setHarvestLevel("pickaxe", 2);
	setCreativeTab(CreativeTabs.tabBlock);
	}

}
