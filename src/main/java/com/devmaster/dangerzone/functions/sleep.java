package com.devmaster.dangerzone.functions;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID)
public class sleep {

    @SubscribeEvent
    public static void onSleepFinished(SleepFinishedTimeEvent event) {
        IWorld world = event.getWorld();
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            if (serverWorld.getDimensionKey() == RegistryHandler.VILLAGES && world.getWorldInfo() instanceof DerivedWorldInfo) {
                ((DerivedWorldInfo)world.getWorldInfo()).delegate.setDayTime(event.getNewTime());
            }
            if (serverWorld.getDimensionKey() == RegistryHandler.VILLAGES && world.getWorldInfo() instanceof DerivedWorldInfo) {
                ((DerivedWorldInfo)world.getWorldInfo()).delegate.setRaining(false);
            }
        }

    }
            }

