package net.Akio.CraftZone.Main.Items;

import net.Akio.CraftZone.Main.CraftZone;
import net.Akio.CraftZone.Main.Mob.EntityRock;
import net.Akio.CraftZone.Main.Mob.RockMob;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Rock extends Item {
    public Rock(int i) {
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!par2World.isRemote) {
            if (this == CraftZone.small_rock) {
                par2World.spawnEntityInWorld(new EntityRock(par2World, par3EntityPlayer, 1));
            }

            if (this == CraftZone.flame_rock) {
                par2World.spawnEntityInWorld(new EntityRock(par2World, par3EntityPlayer, 3));
            }

            if (this == CraftZone.poison_rock) {
                par2World.spawnEntityInWorld(new EntityRock(par2World, par3EntityPlayer, 4));
            }

            if (this == CraftZone.explosive_rock) {
                par2World.spawnEntityInWorld(new EntityRock(par2World, par3EntityPlayer, 8));
            }

        }

        return par1ItemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            if (x < 0) {
                ++x;
            }

            if (z < 0) {
                ++z;
            }

            Entity e = this.spawnCreature(world, "RockModel", (double) x, (double) y + 1.01D, (double) z);
            if (e != null) {
                RockMob r = (RockMob) e;
                if (this == CraftZone.small_rock) {
                    r.placeRock(1);
                }

                if (this == CraftZone.flame_rock) {
                    r.placeRock(3);
                }

                if (this == CraftZone.poison_rock) {
                    r.placeRock(4);
                }

                if (this == CraftZone.explosive_rock) {
                    r.placeRock(8);
                }

            }
        }

        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }

        return true;
    }

    private Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            if (par2 > 0.0D) {
                par2 += 0.5D;
            }

            if (par2 < 0.0D) {
                par2 -= 0.5D;
            }

            if (par6 > 0.0D) {
                par6 += 0.5D;
            }

            if (par6 < 0.0D) {
                par6 -= 0.5D;
            }

            var8.setLocationAndAngles(par2, par4 + 0.01D, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }

        return var8;
    }
}