package net.Akio.CraftZone.Main.Tools;

import net.Akio.CraftZone.Main.CraftZone;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class Ultimate_Pickaxe extends ItemPickaxe {
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
		onUsingTick(stack, (EntityPlayer) null, 0);
	}


	public boolean canHarvestBlock(Block par1Block) {
		return true;
	}

	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		if (par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
			par1ItemStack.damageItem(1, par7EntityLivingBase);
		}
		if (!par2World.isRemote) {
			if (par3 == Blocks.iron_ore && par2World.rand.nextInt(2) != 0) {
				this.dropItemAnItem(par2World, par4, par5, par6, Items.iron_ingot, 1 + par2World.rand.nextInt(2));
				par2World.setBlockToAir(par4, par5, par6);
			}

			if (par3 == Blocks.gold_ore && par2World.rand.nextInt(2) != 0) {
				this.dropItemAnItem(par2World, par4, par5, par6, Items.gold_ingot, 1 + par2World.rand.nextInt(2));
				System.out.println(par1ItemStack);
				par2World.setBlockToAir(par4, par5, par6);

			}

			if (par3 == Blocks.stone && par2World.rand.nextInt(100) == 2) {
				int i = par2World.rand.nextInt(10);
				if (i == 0) {
					this.dropItemAnItem(par2World, par4, par5, par6, Items.diamond, 1);

				}

				if (i == 1) {
					this.dropItemAnItem(par2World, par4, par5, par6, Items.emerald, 1);
				}

			//	if (i == 2) {
				//	this.dropItemAnItem(par2World, par4, par5, par6, CraftZone.amethyst, 1);
				//}

				//if (i == 3) {
				//	this.dropItemAnItem(par2World, par4, par5, par6, CraftZone.Ruby, 1);
				//}

				//	if (i == 4) {
				//		this.dropItemAnItem(par2World, par4, par5, par6, CraftZone..UraniumNugget, 1);
				//	}

				//	if (i == 5) {
				//		this.dropItemAnItem(par2World, par4, par5, par6, CraftZone..TitaniumNugget, 1);
				//	}
			}
		}

		return bFull3D;
	}


	private ItemStack dropItemAnItem(World world, int x, int y, int z, Item index, int par1) {
		EntityItem var3 = null;
		ItemStack is = new ItemStack(index, par1, 0);
		var3 = new EntityItem(world, (double) x, (double) y, (double) z, is);
		if (var3 != null) {
			world.spawnEntityInWorld(var3);
		}

		return is;
	}
}