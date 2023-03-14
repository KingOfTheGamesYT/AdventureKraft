package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BabyAngelModel;
import com.devmaster.dangerzone.client.render.model.BajanCanadianModel;
import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.entity.BajanCanadian;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class BajanCanadianRender extends BipedRenderer<BajanCanadian, BajanCanadianModel<BajanCanadian>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/bajancanadian.png");

        public BajanCanadianRender(EntityRendererManager renderManager) {
                super(renderManager, new BajanCanadianModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new BajanCanadianModel<>(0.5F, true), new BajanCanadianModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(BajanCanadian entity) {
                return TEXTURE;
        }
}