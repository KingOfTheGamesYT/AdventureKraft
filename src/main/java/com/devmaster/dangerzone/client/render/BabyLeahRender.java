package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BabyAngelModel;
import com.devmaster.dangerzone.client.render.model.BabyLeahModel;
import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.entity.BabyLeah;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BabyLeahRender extends BipedRenderer<BabyLeah, BabyLeahModel<BabyLeah>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyleah.png");

        public BabyLeahRender(EntityRendererManager renderManager) {
                super(renderManager, new BabyLeahModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new BabyLeahModel<>(0.5F, true), new BabyLeahModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(BabyLeah entity) {
                return TEXTURE;
        }
}