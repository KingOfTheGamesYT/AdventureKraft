package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BabyAngelModel;
import com.devmaster.dangerzone.client.render.model.BabyDuckModel;
import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.entity.BabyDuck;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BabyDuckRender extends BipedRenderer<BabyDuck, BabyDuckModel<BabyDuck>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyduck.png");

        public BabyDuckRender(EntityRendererManager renderManager) {
                super(renderManager, new BabyDuckModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new BabyDuckModel<>(0.5F, true), new BabyDuckModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(BabyDuck entity) {
                return TEXTURE;
        }
}