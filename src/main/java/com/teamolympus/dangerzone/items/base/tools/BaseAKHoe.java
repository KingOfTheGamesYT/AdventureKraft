package com.teamolympus.dangerzone.items.base.tools;

import net.minecraft.item.ItemHoe;

import com.teamolympus.dangerzone.misc.DangerZone;

public class BaseAKHoe extends ItemHoe {

    public BaseAKHoe(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }
}
