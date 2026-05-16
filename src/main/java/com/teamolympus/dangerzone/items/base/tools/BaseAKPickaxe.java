package com.teamolympus.dangerzone.items.base.tools;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.Translations;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BaseAKPickaxe extends ItemPickaxe {

    public BaseAKPickaxe(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }

    private final List<String> infoList = new ArrayList<>(8);
    EnumChatFormatting formatting;
    public Item addInfo(String desc, EnumChatFormatting formatting) {
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
            info.add(formatting + Translations.translate(string));
        }
    }

}
