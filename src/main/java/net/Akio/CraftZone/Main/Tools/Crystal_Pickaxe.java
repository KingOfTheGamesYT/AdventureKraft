package net.Akio.CraftZone.Main.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class Crystal_Pickaxe extends ItemPickaxe{
		public float weaponDamage = 2F;


	       public Crystal_Pickaxe(ToolMaterial material) {
			super(material);
			this.maxStackSize = 1;
			setMaxDamage(800);
			setCreativeTab(CreativeTabs.tabTools);
	}

}
