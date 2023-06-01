package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.RainbowAnt;
import com.devmaster.dangerzone.entity.Termite;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.MathHelper;

public class TermiteModel<N extends AnimalEntity> extends EntityModel<Termite> {
	private final ModelRenderer llegtop2;
	private final ModelRenderer llegtop1;
	private final ModelRenderer abdomen;
	private final ModelRenderer abdomen1;
	private final ModelRenderer head;
	private final ModelRenderer thorax;
	private final ModelRenderer rlegbot3;
	private final ModelRenderer rlegtop3;
	private final ModelRenderer thorax3;
	private final ModelRenderer jawsl;
	private final ModelRenderer rlegtop1;
	private final ModelRenderer llegtop3;
	private final ModelRenderer rlegtop2;
	private final ModelRenderer jawsr;
	private final ModelRenderer rlegbot1;
	private final ModelRenderer llegbot3;
	private final ModelRenderer rlegbot2;
	private final ModelRenderer llegbot2;
	private final ModelRenderer thorax1;
	private final ModelRenderer llegbot1;

	public TermiteModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.thorax = new ModelRenderer(this, 22, 0);
		this.thorax.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
		this.thorax.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.thorax.setTextureSize(64, 32);
		this.thorax.mirror = true;
		this.setRotateAngle(this.thorax, 0.0F, 0.0F, 0.0F);
		this.thorax1 = new ModelRenderer(this, 18, 0);
		this.thorax1.addBox(1.0F, 1.0F, -1.0F, 1, 1, 1);
		this.thorax1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.thorax1.setTextureSize(64, 32);
		this.thorax1.mirror = true;
		this.setRotateAngle(this.thorax1, 0.0F, 0.0F, 0.0F);
		this.thorax3 = new ModelRenderer(this, 34, 0);
		this.thorax3.addBox(1.0F, 1.0F, 3.0F, 1, 1, 1);
		this.thorax3.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.thorax3.setTextureSize(64, 32);
		this.thorax3.mirror = true;
		this.setRotateAngle(this.thorax3, 0.0F, 0.0F, 0.0F);
		this.abdomen = new ModelRenderer(this, 38, 0);
		this.abdomen.addBox(0.0F, 0.0F, 4.0F, 3, 3, 5);
		this.abdomen.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.abdomen.setTextureSize(64, 32);
		this.abdomen.mirror = true;
		this.setRotateAngle(this.abdomen, 0.0F, 0.0F, 0.0F);
		this.abdomen1 = new ModelRenderer(this, 54, 0);
		this.abdomen1.addBox(1.0F, 1.0F, 9.0F, 1, 1, 1);
		this.abdomen1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.abdomen1.setTextureSize(64, 32);
		this.abdomen1.mirror = true;
		this.setRotateAngle(this.abdomen1, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 6, 0);
		this.head.addBox(0.0F, -1.0F, -4.0F, 3, 3, 3);
		this.head.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotateAngle(this.head, 0.0F, 0.0F, 0.0F);
		this.jawsr = new ModelRenderer(this, 0, 9);
		this.jawsr.addBox(-1.0F, 0.0F, -6.0F, 1, 1, 3);
		this.jawsr.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.jawsr.setTextureSize(64, 32);
		this.jawsr.mirror = true;
		this.setRotateAngle(this.jawsr, 0.0F, 0.0F, 0.0F);
		this.jawsl = new ModelRenderer(this, 0, 14);
		this.jawsl.addBox(3.0F, 0.0F, -6.0F, 1, 1, 3);
		this.jawsl.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.jawsl.setTextureSize(64, 32);
		this.jawsl.mirror = true;
		this.setRotateAngle(this.jawsl, 0.0F, 0.0F, 0.0F);
		this.llegtop1 = new ModelRenderer(this, 15, 10);
		this.llegtop1.addBox(3.0F, 1.0F, 1.0F, 3, 1, 1);
		this.llegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegtop1.setTextureSize(64, 32);
		this.llegtop1.mirror = true;
		this.setRotateAngle(this.llegtop1, 0.0F, 0.0F, 0.3839724F);
		this.llegbot1 = new ModelRenderer(this, 15, 19);
		this.llegbot1.addBox(5.0F, -3.0F, 1.0F, 3, 1, 1);
		this.llegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegbot1.setTextureSize(64, 32);
		this.llegbot1.mirror = true;
		this.setRotateAngle(this.llegbot1, 0.0F, 0.0F, 1.064651F);
		this.llegtop2 = new ModelRenderer(this, 15, 13);
		this.llegtop2.addBox(3.0F, 1.0F, 2.0F, 3, 1, 1);
		this.llegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegtop2.setTextureSize(64, 32);
		this.llegtop2.mirror = true;
		this.setRotateAngle(this.llegtop2, 0.0F, -0.2094395F, 0.3839724F);
		this.llegbot2 = new ModelRenderer(this, 15, 22);
		this.llegbot2.addBox(5.0F, -3.0F, 2.0F, 3, 1, 1);
		this.llegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegbot2.setTextureSize(64, 32);
		this.llegbot2.mirror = true;
		this.setRotateAngle(this.llegbot2, 0.0F, -0.2268928F, 1.064651F);
		this.llegtop3 = new ModelRenderer(this, 15, 16);
		this.llegtop3.addBox(3.0F, 1.0F, 0.0F, 3, 1, 1);
		this.llegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegtop3.setTextureSize(64, 32);
		this.llegtop3.mirror = true;
		this.setRotateAngle(this.llegtop3, 0.0F, 0.3490659F, 0.3839724F);
		this.llegbot3 = new ModelRenderer(this, 15, 25);
		this.llegbot3.addBox(5.0F, -3.0F, 0.0F, 3, 1, 1);
		this.llegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.llegbot3.setTextureSize(64, 32);
		this.llegbot3.mirror = true;
		this.setRotateAngle(this.llegbot3, 0.0F, 0.3490659F, 1.064651F);
		this.rlegtop1 = new ModelRenderer(this, 25, 10);
		this.rlegtop1.addBox(-4.0F, 2.0F, 1.0F, 3, 1, 1);
		this.rlegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegtop1.setTextureSize(64, 32);
		this.rlegtop1.mirror = true;
		this.setRotateAngle(this.rlegtop1, 0.0F, 0.0F, -0.4712389F);
		this.rlegbot1 = new ModelRenderer(this, 25, 19);
		this.rlegbot1.addBox(-7.0F, 0.0F, 1.0F, 3, 1, 1);
		this.rlegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegbot1.setTextureSize(64, 32);
		this.rlegbot1.mirror = true;
		this.setRotateAngle(this.rlegbot1, 0.0F, 0.0F, -0.9773844F);
		this.rlegtop2 = new ModelRenderer(this, 25, 13);
		this.rlegtop2.addBox(-4.0F, 2.0F, 0.0F, 3, 1, 1);
		this.rlegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegtop2.setTextureSize(64, 32);
		this.rlegtop2.mirror = true;
		this.setRotateAngle(this.rlegtop2, 0.0F, -0.5934119F, -0.4712389F);
		this.rlegbot2 = new ModelRenderer(this, 25, 22);
		this.rlegbot2.addBox(-7.0F, 0.0F, 0.0F, 3, 1, 1);
		this.rlegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegbot2.setTextureSize(64, 32);
		this.rlegbot2.mirror = true;
		this.setRotateAngle(this.rlegbot2, 0.0F, -0.5934119F, -0.9773844F);
		this.rlegtop3 = new ModelRenderer(this, 25, 16);
		this.rlegtop3.addBox(-4.0F, 2.0F, 2.0F, 3, 1, 1);
		this.rlegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegtop3.setTextureSize(64, 32);
		this.rlegtop3.mirror = true;
		this.setRotateAngle(this.rlegtop3, 0.0F, 0.418879F, -0.4712389F);
		this.rlegbot3 = new ModelRenderer(this, 25, 25);
		this.rlegbot3.addBox(-7.0F, 0.0F, 2.0F, 3, 1, 1);
		this.rlegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.rlegbot3.setTextureSize(64, 32);
		this.rlegbot3.mirror = true;
		this.setRotateAngle(this.rlegbot3, 0.0F, 0.418879F, -0.9773844F);
	}

	@Override
	public void setRotationAngles(Termite entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			this.llegtop1.rotateAngleX = MathHelper.cos(limbSwing * 2.7F) * 3.1415927F * 0.45F * limbSwingAmount;
			this.llegbot1.rotateAngleX = this.llegtop1.rotateAngleX;
			this.rlegtop2.rotateAngleX = this.llegtop1.rotateAngleX;
			this.rlegbot2.rotateAngleX = this.llegtop1.rotateAngleX;
			this.rlegtop3.rotateAngleX = this.llegtop1.rotateAngleX;
			this.rlegbot3.rotateAngleX = this.llegtop1.rotateAngleX;
			this.rlegtop1.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.rlegbot1.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.llegtop2.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.llegbot2.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.llegtop3.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.llegbot3.rotateAngleX = -this.llegtop1.rotateAngleX;
			this.jawsl.rotateAngleY = MathHelper.cos(limbSwing * 0.4F) * 3.1415927F * 0.05F;
			this.jawsr.rotateAngleY = -this.jawsl.rotateAngleY;

		}




	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		llegtop2.render(matrixStack, buffer, packedLight, packedOverlay);
		llegtop1.render(matrixStack, buffer, packedLight, packedOverlay);
		abdomen.render(matrixStack, buffer, packedLight, packedOverlay);
		abdomen1.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		thorax.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegbot3.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegtop3.render(matrixStack, buffer, packedLight, packedOverlay);
		thorax3.render(matrixStack, buffer, packedLight, packedOverlay);
		jawsl.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegtop1.render(matrixStack, buffer, packedLight, packedOverlay);
		llegtop3.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegtop2.render(matrixStack, buffer, packedLight, packedOverlay);
		jawsr.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegbot1.render(matrixStack, buffer, packedLight, packedOverlay);
		llegbot3.render(matrixStack, buffer, packedLight, packedOverlay);
		rlegbot2.render(matrixStack, buffer, packedLight, packedOverlay);
		llegbot2.render(matrixStack, buffer, packedLight, packedOverlay);
		thorax1.render(matrixStack, buffer, packedLight, packedOverlay);
		llegbot1.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}
