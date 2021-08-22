package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.EntModel;
import com.devmaster.dangerzone.entity.Ent;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class EntRender extends MobRenderer<Ent, EntModel<Ent>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/ent.png");

    public EntRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EntModel<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(Ent entity) {
        return TEXTURE;
    }
}
