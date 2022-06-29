package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AllosaurusModel;
import com.devmaster.dangerzone.entity.Allosaurus;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class AllosaurusRender extends MobRenderer<Allosaurus, AllosaurusModel<Allosaurus>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/allosaurus/allosaurus_1.png"), new ResourceLocation("dangerzone", "textures/entity/allosaurus/allosaurus_2.png"), new ResourceLocation("dangerzone", "textures/entity/allosaurus/allosaurus_3.png"), new ResourceLocation("dangerzone", "textures/entity/allosaurus/allosaurus_4.png")};

    public AllosaurusRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AllosaurusModel<>(0.0F), 0.4F);
    }

    public ResourceLocation getEntityTexture(Allosaurus entity) {
        return TEXTURE[entity.getAllosaurusVariant()];
    }

}


