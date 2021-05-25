package net.Akio.CraftZone.Main.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class Dried_Cow extends Block{

	public Dried_Cow(int par1) {
		super(Material.iron);
		setHardness(4.0F);
	    setResistance(4.0F);
	    setCreativeTab(CreativeTabs.tabBlock);
		setLightLevel(0.4F);
	}

}
