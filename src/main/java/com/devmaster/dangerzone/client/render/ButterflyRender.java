package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.ButterflyModel;
import com.devmaster.dangerzone.entity.Butterfly;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;



public class ButterflyRender extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/butterfly/butterfly_1.png"), new ResourceLocation("dangerzone", "textures/entity/butterfly/butterfly_2.png"), new ResourceLocation("dangerzone", "textures/entity/butterfly/butterfly_3.png"), new ResourceLocation("dangerzone", "textures/entity/butterfly/butterfly_4.png")};

    public ButterflyRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ButterflyModel<>(0.0F), 0.4F);
    }

    public ResourceLocation getEntityTexture(Butterfly entity) {
        return TEXTURE[entity.getButterflyVariant()];
    }




}

