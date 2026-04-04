package com.teamolympus.dangerzone.items.base.tools;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.item.ItemSpade;

public class BaseShovel extends ItemSpade {
    public BaseShovel(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.TOOLS);
        this.setTextureName(DangerZone.TOOL_PREFIX + name);
    }
}
