package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.MermaidModel;
import com.devmaster.dangerzone.entity.Mermaid;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class MermaidRender extends MobRenderer<Mermaid, MermaidModel<Mermaid>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/mermaid.png");

    public MermaidRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MermaidModel(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(Mermaid entity) {
        return TEXTURE;
    }
    }
