package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BabyAngelModel;
import com.devmaster.dangerzone.client.render.model.BabyMaxModel;
import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.entity.BabyMax;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BabyMaxRender extends BipedRenderer<BabyMax, BabyMaxModel<BabyMax>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babymax.png");

        public BabyMaxRender(EntityRendererManager renderManager) {
                super(renderManager, new BabyMaxModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new BabyMaxModel<>(0.5F, true), new BabyMaxModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(BabyMax entity) {
                return TEXTURE;
        }
}