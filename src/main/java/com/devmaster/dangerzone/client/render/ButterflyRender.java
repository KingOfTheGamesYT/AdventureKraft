package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.ButterflyModel;
import com.devmaster.dangerzone.entity.Butterfly;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;



public class ButterflyRender extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    public ButterflyRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ButterflyModel<>(0.0F), 0.4F);
    }


    //  private static final ResourceLocation TEXTURE_E = new ResourceLocation("orespawn", "eyemoth.png");
    //  private static final ResourceLocation TEXTURE_F = new ResourceLocation("orespawn", "lunamoth.png");
    //  private static final ResourceLocation TEXTURE_G = new ResourceLocation("orespawn", "darkmoth.png");
    //  private static final ResourceLocation TEXTURE_H = new ResourceLocation("orespawn", "firemoth.png");
    //  private static final ResourceLocation TEXTURE_AI = new ResourceLocation("orespawn", "vbutterfly1.png");

    public ResourceLocation getEntityTexture(Butterfly entity) {
        return entity.getButterflyTypeName();
    }




}

