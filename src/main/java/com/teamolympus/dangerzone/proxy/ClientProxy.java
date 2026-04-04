package com.teamolympus.dangerzone.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import com.teamolympus.dangerzone.client.render.BodyguardRender;
import com.teamolympus.dangerzone.client.render.AllosaurusRender;
import com.teamolympus.dangerzone.client.render.MantisRender;
import com.teamolympus.dangerzone.entity.living.hostile.AllosaurusEntity;
import com.teamolympus.dangerzone.entity.living.hostile.MantisEntity;
import com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.BodyguardEntity;

public class ClientProxy extends CommonProxy {

    @Override
    public void clientRegistry()
    {
        renderEntity(BodyguardEntity.class, new BodyguardRender());
        renderEntity(MantisEntity.class, new MantisRender());
        renderEntity(AllosaurusEntity.class, new AllosaurusRender());
    }

    private void renderEntity(Class<? extends Entity> clazz, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(clazz, render);
    }

}
