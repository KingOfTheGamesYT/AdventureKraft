package net.Akio.CraftZone.Main.Tools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class Ultimate_Pickaxe extends ItemPickaxe{
	 private int weaponDamage = 15;
	       
	         
	         public Ultimate_Pickaxe(ToolMaterial par2) {
	         super(par2);
	         this.maxStackSize = 1;
	         setMaxDamage(3000);
	         setCreativeTab(CreativeTabs.tabTools);
	         }
	       
	         


			public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	         par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
	         par1ItemStack.addEnchantment(Enchantment.fortune, 5);
	         }
	       
	       
	       
	       
	       
	       
	       
	       
	         
	         public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
	         int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
	         if (lvl <= 0) {
	           stack.addEnchantment(Enchantment.efficiency, 5);
	           stack.addEnchantment(Enchantment.fortune, 5);
	           } 
	         }
	       
	         
	         public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
	         onUsingTick(stack, (EntityPlayer)null, 0);
	         }
	       
	       
	       
	       
	         
	         public boolean canHarvestBlock(Block par1Block) {
	         return true;
	         }
	         
	           public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
	        	        if (par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D)
	        	           {
	        	          par1ItemStack.damageItem(1, par7EntityLivingBase);
	        	           }
	        	        if (!par2World.isRemote) {
	        	       
	       
	       
	       
	        	        }
						return bFull3D;
	        	        }	         
}