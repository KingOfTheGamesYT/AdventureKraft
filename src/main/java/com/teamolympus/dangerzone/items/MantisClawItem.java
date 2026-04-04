package com.teamolympus.dangerzone.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.teamolympus.dangerzone.items.base.tools.BaseAKSword;

public class MantisClawItem extends BaseAKSword {

    public MantisClawItem(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving) entity;
            if (!player.worldObj.isRemote && !entity.worldObj.isRemote) {
                player.heal(2.0f);
                entityLiving.heal(-2.0f);
            }

        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b) {
        info.add("You killed a Mantis. This is your reward!");
        info.add("Not only does it do a respectable amount");
        info.add("of damage but with every hit it sucks half");
        info.add("a heart out of its victim... and gives it to you!");
    }

}
