package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Butterfly;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.MathHelper;

public class ButterflyModel<B extends CreatureEntity> extends EntityModel<Butterfly> {
	private float wingspeed = 1.0F;
	private final ModelRenderer leftwing3;
	private final ModelRenderer head;
	private final ModelRenderer leftwing2;
	private final ModelRenderer leftwing4;
	private final ModelRenderer rightwing4;
	private final ModelRenderer rightwing3;
	private final ModelRenderer body;
	private final ModelRenderer rightwing2;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;

	public ButterflyModel(float v) {
		textureWidth = 64;
		textureHeight = 32;

		leftwing3 = new ModelRenderer(this);
		leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
		setRotationAngle(leftwing3, 0.0F, 0.0F, 0.5463F);
		leftwing3.setTextureOffset(0, 9).addBox(0.0F, 0.0F, 1.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 17.0F, 1.0F);
		head.setTextureOffset(21, 11).addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftwing2 = new ModelRenderer(this);
		leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
		setRotationAngle(leftwing2, 0.0F, 0.0F, 0.5463F);
		leftwing2.setTextureOffset(0, 0).addBox(1.0F, 0.0F, -6.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);

		leftwing4 = new ModelRenderer(this);
		leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
		setRotationAngle(leftwing4, 0.0F, 0.0F, 0.5463F);
		leftwing4.setTextureOffset(2, 24).addBox(0.0F, 0.0F, 6.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		rightwing4 = new ModelRenderer(this);
		rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
		setRotationAngle(rightwing4, 0.0F, 0.0F, -0.5463F);
		rightwing4.setTextureOffset(2, 16).addBox(-1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		rightwing3 = new ModelRenderer(this);
		rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
		setRotationAngle(rightwing3, 0.0F, 0.0F, -0.5463F);
		rightwing3.setTextureOffset(27, 9).addBox(-5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 17.0F, 0.0F);
		body.setTextureOffset(21, 19).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		rightwing2 = new ModelRenderer(this);
		rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
		setRotationAngle(rightwing2, 0.0F, 0.0F, -0.5463F);
		rightwing2.setTextureOffset(29, 0).addBox(-7.0F, 0.0F, -6.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
		setRotationAngle(leftwing, 0.0F, 0.0F, 0.5463F);
		leftwing.setTextureOffset(43, 24).addBox(0.0F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
		setRotationAngle(rightwing, 0.0F, 0.0F, -0.5463F);
		rightwing.setTextureOffset(43, 17).addBox(-5.0F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Butterfly entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			this.rightwing.rotateAngleZ = MathHelper.cos(limbSwing * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
			this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
			this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
			this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
			this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
			this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
			this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
			this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;

		}



	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		leftwing3.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leftwing2.render(matrixStack, buffer, packedLight, packedOverlay);
		leftwing4.render(matrixStack, buffer, packedLight, packedOverlay);
		rightwing4.render(matrixStack, buffer, packedLight, packedOverlay);
		rightwing3.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightwing2.render(matrixStack, buffer, packedLight, packedOverlay);
		leftwing.render(matrixStack, buffer, packedLight, packedOverlay);
		rightwing.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}