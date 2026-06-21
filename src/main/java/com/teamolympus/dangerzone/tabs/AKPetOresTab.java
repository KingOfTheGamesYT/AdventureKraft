package com.teamolympus.dangerzone.tabs;

import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.item.Item;

public class AKPetOresTab extends BaseAKTab {

    public AKPetOresTab() {
        super("petrifiedOres");
    }

    @Override
    public Item getTabIconItem() {
        // TODO: CHANGE TO REDROSEWARRIOR.
        return Item.getItemFromBlock(RegistryHandler.pertifiedCreeper);
    }

}
