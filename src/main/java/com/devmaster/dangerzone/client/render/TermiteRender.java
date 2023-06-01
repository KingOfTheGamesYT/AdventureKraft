package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.RedAntModel;
import com.devmaster.dangerzone.client.render.model.TermiteModel;
import com.devmaster.dangerzone.entity.RedAnt;
import com.devmaster.dangerzone.entity.Termite;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class TermiteRender extends MobRenderer<Termite, TermiteModel<Termite>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/termite.png");

    public TermiteRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TermiteModel<Termite>(), 0.3F);
    }
@Override
    public ResourceLocation getEntityTexture(Termite entity) {
        return TEXTURE;
    }

}
