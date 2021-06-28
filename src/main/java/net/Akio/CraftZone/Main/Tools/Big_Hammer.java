package net.Akio.CraftZone.Main.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class Big_Hammer extends ItemSword {

	private float weaponDamage;



	public Big_Hammer(ToolMaterial material) {
      super(material);
       this.maxStackSize = 1;
      setMaxDamage(9000);
      setCreativeTab(CreativeTabs.tabTools);
	  float weaponDamage = 54;

       }
     
     
     
     
       
       public float getDamageVsEntity(Entity par1Entity) {
       return this.weaponDamage;
       }
     
     
       
       public String getMaterialName() {
       return "Amethyst";
       }

}
