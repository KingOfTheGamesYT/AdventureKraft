package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AntModel;
import com.devmaster.dangerzone.entity.RainbowAnt;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RainbowAntRender extends MobRenderer<RainbowAnt, AntModel<RainbowAnt>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/rainbow_ant.png");

    public RainbowAntRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AntModel<>(), 0.3F);
    }
@Override
    public ResourceLocation getEntityTexture(RainbowAnt entity) {
        return TEXTURE;
    }

}
