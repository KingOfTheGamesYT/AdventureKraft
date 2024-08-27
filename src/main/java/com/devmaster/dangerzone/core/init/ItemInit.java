package com.devmaster.dangerzone.core.init;

import com.devmaster.dangerzone.DangerZone;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, DangerZone.MOD_ID);
}
