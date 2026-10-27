package com.devmaster.dangerzone.client.render.model;

import com.devmaster.dangerzone.entity.Gingerbread;
import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GingerbreadRender extends MobRenderer<Gingerbread, GingerbreadModel<Gingerbread>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/gingerbread.png");

    public GingerbreadRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GingerbreadModel(), 0.7F);
    }

@Override
    public ResourceLocation getEntityTexture(Gingerbread entity) {
        return TEXTURE;
    }
}