package net.Akio.CraftZone.Main.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;

public class Crystal_Axe extends ItemAxe{

	private float weaponDamage;



	public Crystal_Axe(ToolMaterial material) {
      super(material);
       this.maxStackSize = 1;
      setMaxDamage(800);
      setCreativeTab(CreativeTabs.tabTools);
	  float weaponDamage = 3;

       }




    public float getDamageVsEntity(Entity par1Entity) {
       return this.weaponDamage;
       }
     
     
       
       public String getMaterialName() {
       return "Amethyst";
       }

}
