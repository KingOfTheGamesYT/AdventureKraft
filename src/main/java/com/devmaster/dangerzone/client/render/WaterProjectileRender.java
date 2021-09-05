package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.WaterProjectileModel;
import com.devmaster.dangerzone.entity.WaterProjectile;
import com.devmaster.dangerzone.misc.DangerZone;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class WaterProjectileRender <T extends WaterProjectile> extends EntityRenderer<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/water_projectile.png");
    private static final float SCALE = 0.8F;

    protected WaterProjectileModel<T> entityModel;

    public WaterProjectileRender(final EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        entityModel = new WaterProjectileModel<>(0.0F);
    }

    @Override
    public void render(final T entityIn, final float rotationYawIn, final float ageInTicks, final MatrixStack matrixStackIn,
                       final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(SCALE, -SCALE, SCALE);
        final IVertexBuilder vertexBuilder = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(getEntityTexture(entityIn)));
        super.render(entityIn, rotationYawIn, ageInTicks, matrixStackIn, bufferIn, packedLightIn);
        entityModel.render(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(final T entity) {
        return TEXTURE;
    }

}
