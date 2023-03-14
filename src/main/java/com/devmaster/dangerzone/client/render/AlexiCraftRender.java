package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AlexiCraftModel;
import com.devmaster.dangerzone.client.render.model.TewtiyModel;
import com.devmaster.dangerzone.entity.AlexiCraft;
import com.devmaster.dangerzone.entity.Tewtiy;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public class AlexiCraftRender extends BipedRenderer<AlexiCraft, AlexiCraftModel<AlexiCraft>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/alexicraft.png");

        public AlexiCraftRender(EntityRendererManager renderManager) {
                super(renderManager, new AlexiCraftModel<>(0.0F, false), 0.5F);
                this.addLayer(new BipedArmorLayer<>(this, new AlexiCraftModel<>(0.5F, true), new AlexiCraftModel<>(1.0F, true)));
        }

        @Override
        public ResourceLocation getEntityTexture(AlexiCraft entity) {
                return TEXTURE;
        }
}