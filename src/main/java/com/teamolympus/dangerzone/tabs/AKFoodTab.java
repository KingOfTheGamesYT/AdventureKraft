package com.teamolympus.dangerzone.tabs;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.item.Item;

import com.teamolympus.dangerzone.misc.DangerZone;

public class AKFoodTab extends BaseAKTab {

    public AKFoodTab() {
        super(DangerZone.MODID + "Food");
    }

    @Override
    public Item getTabIconItem() {
        return RegistryHandler.butterFood;
    }
}
