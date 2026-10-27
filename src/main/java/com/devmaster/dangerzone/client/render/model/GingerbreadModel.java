package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Gingerbread;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GingerbreadModel<t> extends EntityModel<Gingerbread> {
	private final ModelRenderer rightArm;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer leftLeg;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer head10;
	private final ModelRenderer body;
	private final ModelRenderer body6;
	private final ModelRenderer head;
	private final ModelRenderer rightLeg6;
	private final ModelRenderer rightLeg2;
	private final ModelRenderer rightLeg5;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArm3;
	private final ModelRenderer leftArm4;
	private final ModelRenderer leftLeg2;
	private final ModelRenderer rightArm3;
	private final ModelRenderer rightArm4;
	private final ModelRenderer leftLeg6;
	private final ModelRenderer leftLeg5;
	private final ModelRenderer head8;
	private final ModelRenderer head15;
	private final ModelRenderer head9;
	private final ModelRenderer head16;
	private final ModelRenderer head17;
	private final ModelRenderer head18;
	private final ModelRenderer rightLeg;
	private final ModelRenderer head11;
	private final ModelRenderer head12;
	private final ModelRenderer head13;
	private final ModelRenderer head14;
	private final ModelRenderer head2;
	private final ModelRenderer head3;
	private final ModelRenderer head4;
	private final ModelRenderer head19;
	private final ModelRenderer head5;
	private final ModelRenderer head6;
	private final ModelRenderer head7;

	public GingerbreadModel() {
		textureWidth = 64;
		textureHeight = 64;

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 2.0F);
		rightArm.setTextureOffset(54, 0).addBox(-2.0F, 5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 0.0F, 2.0F);
		body2.setTextureOffset(1, 24).addBox(-1.0F, 2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		body3 = new ModelRenderer(this);
		body3.setRotationPoint(0.0F, 0.0F, 2.0F);
		body3.setTextureOffset(20, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 2.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(2.0F, 12.0F, 2.0F);
		leftLeg.setTextureOffset(9, 25).addBox(0.5F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		body4 = new ModelRenderer(this);
		body4.setRotationPoint(0.0F, 0.0F, 2.0F);
		body4.setTextureOffset(7, 21).addBox(-1.5F, 9.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		body5 = new ModelRenderer(this);
		body5.setRotationPoint(0.0F, 0.0F, 2.0F);
		body5.setTextureOffset(7, 18).addBox(-3.5F, 9.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		head10 = new ModelRenderer(this);
		head10.setRotationPoint(0.0F, 0.0F, 2.0F);
		head10.setTextureOffset(13, 6).addBox(1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 2.0F);
		body.setTextureOffset(1, 24).addBox(-1.0F, 5.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		body6 = new ModelRenderer(this);
		body6.setRotationPoint(0.0F, 0.0F, 2.0F);
		body6.setTextureOffset(7, 18).addBox(1.5F, 9.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 2.0F);
		head.setTextureOffset(0, 18).addBox(3.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		rightLeg6 = new ModelRenderer(this);
		rightLeg6.setRotationPoint(-2.0F, 12.0F, 2.0F);
		rightLeg6.setTextureOffset(9, 25).addBox(-1.5F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightLeg2 = new ModelRenderer(this);
		rightLeg2.setRotationPoint(-2.0F, 12.0F, 2.0F);
		rightLeg2.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);

		rightLeg5 = new ModelRenderer(this);
		rightLeg5.setRotationPoint(-2.0F, 12.0F, 2.0F);
		rightLeg5.setTextureOffset(0, 28).addBox(-1.5F, 8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 2.0F);
		leftArm.setTextureOffset(54, 0).addBox(0.0F, 5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftArm3 = new ModelRenderer(this);
		leftArm3.setRotationPoint(5.0F, 2.0F, 2.0F);
		leftArm3.setTextureOffset(40, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);

		leftArm4 = new ModelRenderer(this);
		leftArm4.setRotationPoint(5.0F, 2.0F, 2.0F);
		leftArm4.setTextureOffset(54, 0).addBox(0.0F, 8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftLeg2 = new ModelRenderer(this);
		leftLeg2.setRotationPoint(2.0F, 12.0F, 2.0F);
		leftLeg2.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);

		rightArm3 = new ModelRenderer(this);
		rightArm3.setRotationPoint(-5.0F, 2.0F, 2.0F);
		rightArm3.setTextureOffset(40, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);

		rightArm4 = new ModelRenderer(this);
		rightArm4.setRotationPoint(-5.0F, 2.0F, 2.0F);
		rightArm4.setTextureOffset(54, 0).addBox(-2.0F, 8.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftLeg6 = new ModelRenderer(this);
		leftLeg6.setRotationPoint(2.0F, 12.0F, 2.0F);
		leftLeg6.setTextureOffset(9, 25).addBox(-1.5F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		leftLeg5 = new ModelRenderer(this);
		leftLeg5.setRotationPoint(2.0F, 12.0F, 2.0F);
		leftLeg5.setTextureOffset(0, 28).addBox(-1.5F, 8.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		head8 = new ModelRenderer(this);
		head8.setRotationPoint(0.0F, 0.0F, 2.0F);
		head8.setTextureOffset(13, 1).addBox(-3.0F, -7.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		head15 = new ModelRenderer(this);
		head15.setRotationPoint(0.0F, 0.0F, 2.0F);
		head15.setTextureOffset(2, 15).addBox(-2.0F, -3.25F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head9 = new ModelRenderer(this);
		head9.setRotationPoint(0.0F, 0.0F, 2.0F);
		head9.setTextureOffset(13, 1).addBox(1.0F, -7.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		head16 = new ModelRenderer(this);
		head16.setRotationPoint(0.0F, 0.0F, 2.0F);
		head16.setTextureOffset(2, 15).addBox(2.0F, -3.5F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head17 = new ModelRenderer(this);
		head17.setRotationPoint(0.0F, 0.0F, 2.0F);
		head17.setTextureOffset(2, 15).addBox(2.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head18 = new ModelRenderer(this);
		head18.setRotationPoint(0.0F, 0.0F, 2.0F);
		head18.setTextureOffset(2, 15).addBox(1.0F, -3.25F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-2.0F, 12.0F, 2.0F);
		rightLeg.setTextureOffset(9, 25).addBox(0.5F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		head11 = new ModelRenderer(this);
		head11.setRotationPoint(0.0F, 0.0F, 2.0F);
		head11.setTextureOffset(13, 6).addBox(-3.0F, -9.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		head12 = new ModelRenderer(this);
		head12.setRotationPoint(0.0F, 0.0F, 2.0F);
		head12.setTextureOffset(2, 15).addBox(-3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head13 = new ModelRenderer(this);
		head13.setRotationPoint(0.0F, 0.0F, 2.0F);
		head13.setTextureOffset(2, 15).addBox(-3.0F, -3.5F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head14 = new ModelRenderer(this);
		head14.setRotationPoint(0.0F, 0.0F, 2.0F);
		head14.setTextureOffset(2, 15).addBox(-2.0F, -1.75F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, 0.0F, 2.0F);
		head2.setTextureOffset(20, 14).addBox(-5.0F, -10.0F, -2.0F, 10.0F, 10.0F, 2.0F, 0.0F, false);

		head3 = new ModelRenderer(this);
		head3.setRotationPoint(0.0F, 0.0F, 2.0F);
		head3.setTextureOffset(13, 6).addBox(-4.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head4 = new ModelRenderer(this);
		head4.setRotationPoint(0.0F, 0.0F, 2.0F);
		head4.setTextureOffset(13, 6).addBox(3.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head19 = new ModelRenderer(this);
		head19.setRotationPoint(0.0F, 0.0F, 2.0F);
		head19.setTextureOffset(2, 15).addBox(1.0F, -1.75F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head5 = new ModelRenderer(this);
		head5.setRotationPoint(0.0F, 0.0F, 2.0F);
		head5.setTextureOffset(2, 15).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		head6 = new ModelRenderer(this);
		head6.setRotationPoint(0.0F, 0.0F, 2.0F);
		head6.setTextureOffset(2, 15).addBox(-1.0F, -1.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		head7 = new ModelRenderer(this);
		head7.setRotationPoint(0.0F, 0.0F, 2.0F);
		head7.setTextureOffset(0, 18).addBox(-4.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Gingerbread entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightArm.rotateAngleZ = 0.0F;
		this.rightArm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightArm3.rotateAngleZ = 0.0F;
		this.rightArm4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightArm4.rotateAngleZ = 0.0F;

		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.rotateAngleZ = 0.0F;
		this.leftArm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm3.rotateAngleZ = 0.0F;
		this.leftArm4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm4.rotateAngleZ = 0.0F;

		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightLeg.rotateAngleY = 0.0F;
		this.rightLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightLeg2.rotateAngleY = 0.0F;
		this.rightLeg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightLeg5.rotateAngleY = 0.0F;
		this.rightLeg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightLeg6.rotateAngleY = 0.0F;

		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftLeg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftLeg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head10.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head8.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head15.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head9.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head16.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head17.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head18.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head11.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head12.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head13.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head14.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head19.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head7.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}