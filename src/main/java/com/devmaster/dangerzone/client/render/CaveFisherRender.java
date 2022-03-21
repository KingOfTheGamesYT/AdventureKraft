package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.CaveFisherModel;
import com.devmaster.dangerzone.entity.CaveFisher;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class CaveFisherRender extends MobRenderer<CaveFisher, CaveFisherModel<CaveFisher>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/cave_fisher.png");

    public CaveFisherRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CaveFisherModel(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(CaveFisher entity) {
        return TEXTURE;
    }
}
