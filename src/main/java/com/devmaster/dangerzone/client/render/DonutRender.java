package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.DonutModel;
import com.devmaster.dangerzone.entity.Donut;
import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DonutRender extends MobRenderer<Donut, DonutModel<Donut>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/donut.png");

    public DonutRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DonutModel(), 0.7F);
    }

@Override
    public ResourceLocation getEntityTexture(Donut entity) {
        return TEXTURE;
    }
}