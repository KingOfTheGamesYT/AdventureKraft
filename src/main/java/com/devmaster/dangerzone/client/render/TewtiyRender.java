package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.client.render.model.TewtiyModel;
import com.devmaster.dangerzone.entity.Tewtiy;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class TewtiyRender extends BipedRenderer<Tewtiy, TewtiyModel<Tewtiy>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/tewtiy.png");

        public TewtiyRender(EntityRendererManager renderManager) {
                super(renderManager, new TewtiyModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new TewtiyModel<>(0.5F, true), new TewtiyModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(Tewtiy entity) {
                return TEXTURE;
        }
}