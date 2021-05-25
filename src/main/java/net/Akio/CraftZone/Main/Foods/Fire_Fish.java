package net.Akio.CraftZone.Main.Foods;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Fire_Fish extends ItemFood{
	       public Fire_Fish(int par1, int par2, float par3, boolean par4) {
		       super(par2, par3, par4);
		       setAlwaysEdible();
		       }



		       public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		       super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		       if (!par2World.isRemote)
		         {
		         par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200, 0));
		         }
		       }

}