package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.items.base.BaseAKItem;
import com.teamolympus.dangerzone.misc.DangerZone;

public class WrenchItem extends BaseAKItem {

    public WrenchItem(String name) {
        super(name);
        this.setTextureName(DangerZone.TOOL_MISC_PREFIX + name);
    }
}
