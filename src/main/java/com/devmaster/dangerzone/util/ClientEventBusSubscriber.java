package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.client.render.*;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.TEWTIY.get(), TewtiyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.STAMPYLONGNOSE.get(), StampyLongNoseRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.NOTBREEBREE.get(), NotBreeBreeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.REDROSEWARRIOR.get(), RedRoseWarriorRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.RAINBOWANT.get(), RainbowAntRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BUTTERFLY.get(), ButterflyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ENT.get(), EntRender::new);

    }
}
