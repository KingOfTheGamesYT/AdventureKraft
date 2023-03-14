package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AntVenomModel;
import com.devmaster.dangerzone.entity.AlexiCraft;
import com.devmaster.dangerzone.entity.AntVenom;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class AntVenomRender extends BipedRenderer<AntVenom, AntVenomModel<AntVenom>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/antvenom.png");

        public AntVenomRender(EntityRendererManager renderManager) {
                super(renderManager, new AntVenomModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new AntVenomModel<>(0.5F, true), new AntVenomModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(AntVenom entity) {
                return TEXTURE;
        }
}