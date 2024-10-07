package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.EasterBunnyModel;
import com.devmaster.dangerzone.entity.EasterBunny;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EasterBunnyRender extends MobRenderer<EasterBunny, EasterBunnyModel<EasterBunny>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/easter_bunny/easter_bunny_1.png"), new ResourceLocation("dangerzone", "textures/entity/easter_bunny/easter_bunny.png")};

    public EasterBunnyRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EasterBunnyModel<EasterBunny>(0.0F), 0.4F);
    }

    public ResourceLocation getEntityTexture(EasterBunny entity) {
        return TEXTURE[entity.getEasterBunnyVariant()];
    }




}

