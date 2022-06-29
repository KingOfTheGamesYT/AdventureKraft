package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BirdModel;
import com.devmaster.dangerzone.client.render.model.ButterflyModel;
import com.devmaster.dangerzone.entity.Bird;
import com.devmaster.dangerzone.entity.Butterfly;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class BirdRender extends MobRenderer<Bird, BirdModel<Bird>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/bird/bird_1.png"), new ResourceLocation("dangerzone", "textures/entity/bird/bird_2.png"), new ResourceLocation("dangerzone", "textures/entity/bird/bird_3.png"), new ResourceLocation("dangerzone", "textures/entity/bird/bird_4.png"), new ResourceLocation("dangerzone", "textures/entity/bird/bird_5.png"), new ResourceLocation("dangerzone", "textures/entity/bird/bird_6.png")};

    public BirdRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BirdModel<>(0.0F), 0.4F);
    }

    public ResourceLocation getEntityTexture(Bird entity) {
        return TEXTURE[entity.getBirdVariant()];
    }




}

