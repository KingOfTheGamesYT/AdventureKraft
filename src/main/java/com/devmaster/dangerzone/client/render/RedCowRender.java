package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.RedCowModel;
import com.devmaster.dangerzone.entity.RedCow;
import com.devmaster.dangerzone.misc.DangerZone;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class RedCowRender extends MobRenderer<RedCow, RedCowModel<RedCow>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/red_cow.png");

    public RedCowRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedCowModel<RedCow>(), 0.7F);
    }


    public void render(RedCow redCow, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        if (redCow.isChild()) {
            matrixStackIn.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(redCow, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(RedCow entity) {
        return TEXTURE;
    }
}
