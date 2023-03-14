package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AphmauModel;
import com.devmaster.dangerzone.entity.AlexiCraft;
import com.devmaster.dangerzone.entity.Aphmau;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class AphmauRender extends BipedRenderer<Aphmau, AphmauModel<Aphmau>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/aphmau.png");

        public AphmauRender(EntityRendererManager renderManager) {
                super(renderManager, new AphmauModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new AphmauModel<>(0.5F, true), new AphmauModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(Aphmau entity) {
                return TEXTURE;
        }
}