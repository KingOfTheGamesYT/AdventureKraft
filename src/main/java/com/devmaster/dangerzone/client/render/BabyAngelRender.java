package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BabyAngelModel;
import com.devmaster.dangerzone.entity.AlexiCraft;
import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BabyAngelRender extends BipedRenderer<BabyAngel, BabyAngelModel<BabyAngel>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyangel.png");

        public BabyAngelRender(EntityRendererManager renderManager) {
                super(renderManager, new BabyAngelModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new BabyAngelModel<>(0.5F, true), new BabyAngelModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(BabyAngel entity) {
                return TEXTURE;
        }
}