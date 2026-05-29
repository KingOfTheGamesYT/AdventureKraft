package com.teamolympus.dangerzone.items.base;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.TranslationHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class BaseAKItem extends Item {

    public BaseAKItem(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName(DangerZone.MODID_PREFIX + name);
    }

    EnumChatFormatting formatting;
    private final List<String> infoList = new ArrayList<>();
    public BaseAKItem addInfo(String desc, EnumChatFormatting formatting) {
        infoList.add(desc);
        this.formatting = formatting;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b)
    {
        super.addInformation(stack, player, info,b);
        for (String string : infoList) {
            info.add(formatting + TranslationHelper.translate(string));
        }
    }

}
