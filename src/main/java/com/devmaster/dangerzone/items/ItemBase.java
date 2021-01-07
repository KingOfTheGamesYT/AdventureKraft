package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.item.Item;


public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(DangerZone.TAB));
    }
}
