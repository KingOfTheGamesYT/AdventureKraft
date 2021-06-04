package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.NotBreeBreeModel;
import com.devmaster.dangerzone.entity.NotBreeBree;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class NotBreeBreeRender extends BipedRenderer<NotBreeBree, NotBreeBreeModel<NotBreeBree>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/notbreebree.png");

        public NotBreeBreeRender(EntityRendererManager renderManager) {
                super(renderManager, new NotBreeBreeModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new NotBreeBreeModel<>(0.5F, true), new NotBreeBreeModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(NotBreeBree entity) {
                return TEXTURE;
        }
}