package com.teamolympus.dangerzone.tabs;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.item.Item;

public class AKToolsTab extends BaseAKTab {

    public AKToolsTab() {
        super(DangerZone.MODID + "Tools");
    }

    @Override
    public Item getTabIconItem() {
        return RegistryHandler.coarseAmethystAxe;
    }
}
