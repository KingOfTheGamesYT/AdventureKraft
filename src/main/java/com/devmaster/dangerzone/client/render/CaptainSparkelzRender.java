package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.CaptainSparkelzModel;
import com.devmaster.dangerzone.entity.CaptainSparkelz;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class CaptainSparkelzRender extends BipedRenderer<CaptainSparkelz, CaptainSparkelzModel<CaptainSparkelz>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/captainsparkelz.png");

        public CaptainSparkelzRender(EntityRendererManager renderManager) {
                super(renderManager, new CaptainSparkelzModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new CaptainSparkelzModel<>(0.5F, true), new CaptainSparkelzModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(CaptainSparkelz entity) {
                return TEXTURE;
        }
}