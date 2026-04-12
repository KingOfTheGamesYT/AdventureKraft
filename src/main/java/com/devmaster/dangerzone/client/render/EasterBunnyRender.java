package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.EasterBunnyModel;
import com.devmaster.dangerzone.entity.EasterBunny;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EasterBunnyRender extends MobRenderer<EasterBunny, EasterBunnyModel<EasterBunny>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/easter_bunny/easter_bunny_1.png"), new ResourceLocation("dangerzone", "textures/entity/easter_bunny/easter_bunny.png")};

    public EasterBunnyRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EasterBunnyModel<EasterBunny>(0.0F), 0.4F);
    }

    public void render(EasterBunny easterBunny, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        if (easterBunny.isChild()) {
            matrixStackIn.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(easterBunny, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
    }

    public ResourceLocation getEntityTexture(EasterBunny entity) {
        return TEXTURE[entity.getEasterBunnyVariant()];
    }
}