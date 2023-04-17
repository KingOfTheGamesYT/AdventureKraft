package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.GodzillaModel;
import com.devmaster.dangerzone.entity.Godzilla;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class GodzillaRender extends MobRenderer<Godzilla, GodzillaModel<Godzilla>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/godzilla.png");

    public GodzillaRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GodzillaModel<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(Godzilla entity) {
        return TEXTURE;
    }
}
