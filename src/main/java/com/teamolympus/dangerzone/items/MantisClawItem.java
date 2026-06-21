package com.teamolympus.dangerzone.items;

import java.util.List;

import com.teamolympus.dangerzone.misc.TranslationHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b) {
        for (byte i = 1; i <= 4; i++) {
            info.add(TranslationHelper.translate("MantisDesc" + i));
        }
    }

}
