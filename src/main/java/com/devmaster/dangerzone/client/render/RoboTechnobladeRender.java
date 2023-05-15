package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.RoboTechnobladeModel;
import com.devmaster.dangerzone.entity.RoboTechnoblade;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;


public class RoboTechnobladeRender extends BipedRenderer<RoboTechnoblade, RoboTechnobladeModel<RoboTechnoblade>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/technoblade/technoblade_15.png");

    public RoboTechnobladeRender(EntityRendererManager renderManager) {
        super(renderManager, new RoboTechnobladeModel<>(0.0F, false), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new RoboTechnobladeModel<>(0.5F, true), new RoboTechnobladeModel<>(1.0F, true)));
    }

    @Override
    public ResourceLocation getEntityTexture(RoboTechnoblade entity) {
        return TEXTURE;
    }
}
