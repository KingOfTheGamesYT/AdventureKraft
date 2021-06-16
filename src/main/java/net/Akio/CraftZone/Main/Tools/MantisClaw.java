package net.Akio.CraftZone.Main.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class MantisClaw extends ItemAxe{

	private float weaponDamage;



	public MantisClaw(ToolMaterial material) {
      super(material);
       this.maxStackSize = 1;
        this.setMaxDamage(1000);

      setCreativeTab(CreativeTabs.tabCombat);
	  float weaponDamage = 11;

       }
     
       public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
        int var2 = 1;
        if (par2EntityLiving != null && par3EntityLiving != null && !par2EntityLiving.worldObj.isRemote) {
            par2EntityLiving.heal(-1.0F);
            par3EntityLiving.heal(1.0F);
        }

        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }


       public float getDamageVsEntity(Entity par1Entity) {
       return this.weaponDamage;
       }
     
       public String getMaterialName() {
       return "Amethyst";
       }

}
