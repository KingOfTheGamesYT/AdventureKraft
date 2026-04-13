package com.teamolympus.dangerzone.proxy;

import com.teamolympus.dangerzone.entity.rocks.ExplosiveRockEntity;
import com.teamolympus.dangerzone.entity.rocks.GreenRockEntity;
import com.teamolympus.dangerzone.entity.rocks.RedRockEntity;
import com.teamolympus.dangerzone.entity.rocks.SmallRockEntity;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
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
        renderEntity(ExplosiveRockEntity.class, new RenderSnowball(RegistryHandler.explosiveRock));
        renderEntity(SmallRockEntity.class, new RenderSnowball(RegistryHandler.smallRock));
        renderEntity(RedRockEntity.class, new RenderSnowball(RegistryHandler.redRock));
        renderEntity(GreenRockEntity.class, new RenderSnowball(RegistryHandler.greenRock));
    }

    private void renderEntity(Class<? extends Entity> clazz, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(clazz, render);
    }

}
