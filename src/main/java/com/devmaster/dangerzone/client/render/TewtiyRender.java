package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.client.render.model.TewtiyModel;
import com.devmaster.dangerzone.entity.Tewtiy;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class TewtiyRender<T extends Tewtiy> extends BipedRenderer<T, TewtiyModel<T>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID,
                "textures/entity/tewtiy.png");

        public TewtiyRender(EntityRendererManager renderManagerIn) {
                super(renderManagerIn, new TewtiyModel<>(1), 0.5f);
        }

        @Override
        public ResourceLocation getEntityTexture(Tewtiy entity) {
                return TEXTURE;
        }
}