package com.devmaster.dangerzone.client.render.model;
// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.NotBreeBree;
import com.devmaster.dangerzone.entity.RedRoseWarrior;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;

public class RedRoseWarriorModel<N extends CreatureEntity> extends EntityModel<RedRoseWarrior> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer body_rotation;
    private final ModelRenderer body_sub_1;
    private final ModelRenderer mane;
    private final ModelRenderer mane_rotation;
    private final ModelRenderer mane_sub_1;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tail;
    private final ModelRenderer tail_r1;
    private final ModelRenderer tail_r2;
    private final ModelRenderer tail_r3;

    public RedRoseWarriorModel() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0833F, 13.9167F, -6.25F);
        head.setTextureOffset(0, 0).addBox(-3.0833F, -3.4167F, -2.75F, 6.0F, 6.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(29, 22).addBox(2.125F, -3.4584F, -0.9583F, 2.0F, 2.0F, 1.0F, 0.0F, true);
        head.setTextureOffset(29, 22).addBox(-4.25F, -3.5F, -0.9167F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 10).addBox(-1.5833F, -0.3533F, -5.0417F, 3.0F, 2.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 14.0F, 2.0F);


        body_rotation = new ModelRenderer(this);
        body_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(body_rotation);
        setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);


        body_sub_1 = new ModelRenderer(this);
        body_sub_1.setRotationPoint(0.1667F, -2.8333F, 0.0F);
        body_rotation.addChild(body_sub_1);
        body_sub_1.setTextureOffset(18, 14).addBox(-3.1667F, 0.8333F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);

        mane = new ModelRenderer(this);
        mane.setRotationPoint(1.0F, 14.0F, 2.0F);


        mane_rotation = new ModelRenderer(this);
        mane_rotation.setRotationPoint(-1.0F, 2.5F, -2.5F);
        mane.addChild(mane_rotation);
        setRotationAngle(mane_rotation, 1.5708F, 0.0F, 0.0F);


        mane_sub_1 = new ModelRenderer(this);
        mane_sub_1.setRotationPoint(0.0F, 0.2083F, 3.2083F);
        mane_rotation.addChild(mane_sub_1);
        mane_sub_1.setTextureOffset(21, 0).addBox(-4.0F, -5.7083F, -3.7083F, 8.0F, 6.0F, 7.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(2.5F, 16.7917F, 7.0F);
        leg1.setTextureOffset(0, 18).addBox(-2.0F, -0.7917F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-1.6667F, 16.5417F, 7.0F);
        leg2.setTextureOffset(0, 18).addBox(-0.8333F, -0.5417F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(1.5417F, 16.75F, -4.0F);
        leg3.setTextureOffset(9, 18).addBox(-1.0417F, -0.75F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
        leg3.setTextureOffset(9, 18).addBox(-1.0417F, -0.75F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(-1.7083F, 16.7083F, -4.0F);
        leg4.setTextureOffset(9, 18).addBox(-0.7917F, -0.7083F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-0.0833F, 12.0F, 9.0417F);
        setRotationAngle(tail, 0.0F, 0.0F, 3.1343F);


        tail_r1 = new ModelRenderer(this);
        tail_r1.setRotationPoint(0.0833F, -1.125F, 0.7083F);
        tail.addChild(tail_r1);
        setRotationAngle(tail_r1, 0.0873F, 0.0F, 0.0F);
        tail_r1.setTextureOffset(47, 18).addBox(-1.0F, -1.875F, -1.1667F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        tail_r2 = new ModelRenderer(this);
        tail_r2.setRotationPoint(0.0833F, 3.625F, 0.8333F);
        tail.addChild(tail_r2);
        setRotationAngle(tail_r2, 0.6981F, 0.0F, 0.0F);
        tail_r2.setTextureOffset(47, 21).addBox(-1.0F, -0.2917F, -0.9167F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        tail_r3 = new ModelRenderer(this);
        tail_r3.setRotationPoint(0.0833F, 5.5833F, 2.25F);
        tail.addChild(tail_r3);
        setRotationAngle(tail_r3, 1.5272F, 0.0F, 0.0F);
        tail_r3.setTextureOffset(47, 21).addBox(-1.0F, -0.3691F, -0.7431F, 2.0F, 4.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(RedRoseWarrior entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        mane.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}