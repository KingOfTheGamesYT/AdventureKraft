package net.Akio.CraftZone.Main.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Dried_Villager extends Block{

	public Dried_Villager(int par1) {
		super(Material.iron);
		setHardness(4.0F);
	    setResistance(4.0F);
	    setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(0.4F);
	}

}
