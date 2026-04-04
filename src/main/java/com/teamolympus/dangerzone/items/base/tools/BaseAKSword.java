package com.teamolympus.dangerzone.items.base.tools;

import net.minecraft.item.ItemSword;

import com.teamolympus.dangerzone.misc.DangerZone;

public class BaseAKSword extends ItemSword {

    public BaseAKSword(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }

}
