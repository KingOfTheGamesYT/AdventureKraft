package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.client.render.StampyLongNoseRender;
import com.devmaster.dangerzone.client.render.TewtiyRender;
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

    }
}
