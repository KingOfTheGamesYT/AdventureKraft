package com.devmaster.dangerzone.CreativeTabs;

import com.devmaster.dangerzone.items.SpawnEgg;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DangerZoneSpawnEggs extends ItemGroup {
    private static final long CYCLE_INTERVAL_MS = 1000L;

    public DangerZoneSpawnEggs() {
        super("dangerzonespawn");
    }

    @Override
    public ItemStack createIcon() {
        return getCyclingIcon();
    }

    @Override
    public ItemStack getIcon() {
        return getCyclingIcon();
    }

    private ItemStack getCyclingIcon() {
        if (SpawnEgg.ALL_SPAWN_EGGS.isEmpty()) {
            return ItemStack.EMPTY;
        }

        long cycle = System.currentTimeMillis() / CYCLE_INTERVAL_MS;
        int index = (int) (cycle % SpawnEgg.ALL_SPAWN_EGGS.size());

        return new ItemStack(SpawnEgg.ALL_SPAWN_EGGS.get(index));
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation getBackgroundImage() {
        return new ResourceLocation(DangerZone.MOD_ID, "textures/gui/inventory_tab.png");
    }

    @Override
    public ResourceLocation getTabsImage() {
        return new ResourceLocation(DangerZone.MOD_ID, "textures/gui/tab_icons.png");
    }
}