package net.Akio.CraftZone.Main.Foods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Butter_Candy extends ItemFood{

	public Butter_Candy(int par1, int par2, float par3, boolean par4) {
	       super(par2, par3, par4);
	       setAlwaysEdible();
	       }
	     
	     
	       
	       public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	       super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	       if (!par2World.isRemote)
	         {
	         par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 0));
	         par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 2000, 0));

	         }
	       }
}
