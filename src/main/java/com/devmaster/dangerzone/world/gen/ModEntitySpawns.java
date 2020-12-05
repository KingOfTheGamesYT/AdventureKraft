package com.devmaster.dangerzone.world.gen;


import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent e) {
        for (Biome biome : ForgeRegistries.BIOMES) {

            // Nether Mobs
            if (biome.getCategory() == Biome.Category.NETHER) { }

            // End Mobs
            else if (biome.getCategory() == Biome.Category.THEEND) { }

            // Overworld Mobs
            else {
                if (e.getCategory() != Biome.Category.ICY) {
                    e.getSpawns().withSpawner(EntityClassification.CREATURE,
                            new MobSpawnInfo.Spawners(RegistryHandler.QUEEN_GHIDORAH.get(), 10, 1, 1));
                }
            }
        }
    }
}
