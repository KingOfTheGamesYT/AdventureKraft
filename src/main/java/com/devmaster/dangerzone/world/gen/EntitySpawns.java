package com.devmaster.dangerzone.world.gen;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class EntitySpawns {
    private static final String MOD_ID = DangerZone.MOD_ID;

    public static void addBiomeSpawns(final BiomeLoadingEvent event) {
        addSpawns(event, RegistryHandler.TEWTIY.get(), 3, 3);
    }
    private static void addSpawns(final BiomeLoadingEvent event, final EntityType<?> entity, final int min, final int max) {
        final String name = entity.getRegistryName().getPath();
        final RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
     }
}