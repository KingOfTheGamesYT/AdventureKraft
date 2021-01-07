package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.client.render.model.StampyLongNoseModel;
import com.devmaster.dangerzone.entity.StampyLongNose;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class StampyLongNoseRender extends BipedRenderer<StampyLongNose, StampyLongNoseModel<StampyLongNose>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/stampylongnose.png");

        public StampyLongNoseRender(EntityRendererManager renderManager) {
                super(renderManager, new StampyLongNoseModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new StampyLongNoseModel<>(0.5F, true), new StampyLongNoseModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(StampyLongNose entity) {
                return TEXTURE;
        }
}