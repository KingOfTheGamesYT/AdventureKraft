package com.teamolympus.dangerzone.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseAKTab extends CreativeTabs {

    public BaseAKTab(String label) {
        super(label);

        // TODO: ADD WHEN WE NEED TO UPDATE.
        this.setBackgroundImageName("dangerzone.png");
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

    public boolean hasSearchBar() {
        return false;
    }
}
