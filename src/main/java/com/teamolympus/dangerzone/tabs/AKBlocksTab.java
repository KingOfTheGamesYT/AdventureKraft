package com.teamolympus.dangerzone.tabs;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AKBlocksTab extends BaseAKTab {

    public AKBlocksTab() {
        super(DangerZone.MODID + "Blocks");
    }

    @Override
    public Item getTabIconItem() {
        // TODO: CHANGE TO ACTUAL BLOCK
        return Items.apple;
    }
}
