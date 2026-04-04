package com.teamolympus.dangerzone.items.base.tools;

import net.minecraft.item.ItemAxe;

import com.teamolympus.dangerzone.misc.DangerZone;

public class BaseAKAxe extends ItemAxe {


    public BaseAKAxe(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }


}
