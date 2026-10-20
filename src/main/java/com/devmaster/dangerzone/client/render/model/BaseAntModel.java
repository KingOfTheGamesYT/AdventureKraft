// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

package com.devmaster.dangerzone.client.render.model;

import com.devmaster.dangerzone.entity.BaseAnt;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.MathHelper;

public class BaseAntModel<N extends CreatureEntity> extends EntityModel<BaseAnt> {
	private final ModelRenderer llegb;
	private final ModelRenderer llegbb_r1;
	private final ModelRenderer llegbt_r1;
	private final ModelRenderer llegm;
	private final ModelRenderer llegmb_r1;
	private final ModelRenderer llegmt_r1;
	private final ModelRenderer abdomen;
	private final ModelRenderer head;
	private final ModelRenderer thorax;
	private final ModelRenderer rlegb;
	private final ModelRenderer rlegbb_r1;
	private final ModelRenderer rlegbt_r1;
	private final ModelRenderer rlegm;
	private final ModelRenderer rlegmb_r1;
	private final ModelRenderer rlegmt_r1;
	private final ModelRenderer llegtop;
	private final ModelRenderer llegtb_r1;
	private final ModelRenderer llegtt_r1;
	private final ModelRenderer rlegt;
	private final ModelRenderer rlegtb_r1;
	private final ModelRenderer rlegtt_r1;
	private final ModelRenderer connector;
	private final ModelRenderer tendrils;
	private final ModelRenderer tendrillb_r1;
	private final ModelRenderer tendrilrb_r1;
	private final ModelRenderer tendrilrt_r1;
	private final ModelRenderer tendrilllt_r1;

	public BaseAntModel() {
		textureWidth = 64;
		textureHeight = 32;

		llegb = new ModelRenderer(this);
		llegb.setRotationPoint(-1.0F, 16.5F, 3.0F);
		llegbb_r1 = new ModelRenderer(this);
		llegbb_r1.setRotationPoint(-1.2F, 0.5F, 1.9F);
		llegb.addChild(llegbb_r1);
		setRotationAngle(llegbb_r1, 0.0F, 0.0F, 0.8499F);
		llegbb_r1.setTextureOffset(16, 10).addBox(6.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		llegbt_r1 = new ModelRenderer(this);
		llegbt_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		llegb.addChild(llegbt_r1);
		setRotationAngle(llegbt_r1, 0.0F, 0.0F, 0.3875F);
		llegbt_r1.setTextureOffset(16, 10).addBox(4.0F, 1.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		llegm = new ModelRenderer(this);
		llegm.setRotationPoint(-1.0F, 16.5F, 0.0F);
		llegmb_r1 = new ModelRenderer(this);
		llegmb_r1.setRotationPoint(-1.2F, 0.5F, 0.9F);
		llegm.addChild(llegmb_r1);
		setRotationAngle(llegmb_r1, 0.0F, 0.0F, 0.8499F);
		llegmb_r1.setTextureOffset(16, 10).addBox(6.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		llegmt_r1 = new ModelRenderer(this);
		llegmt_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		llegm.addChild(llegmt_r1);
		setRotationAngle(llegmt_r1, 0.0F, 0.0F, 0.3875F);
		llegmt_r1.setTextureOffset(16, 10).addBox(4.0F, 1.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		abdomen = new ModelRenderer(this);
		abdomen.setRotationPoint(0.0F, 17.0F, 0.0F);
		abdomen.setTextureOffset(39, 0).addBox(1.0F, 0.0F, 4.0F, 2.0F, 3.0F, 5.0F, 0.0F, true);
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 17.0F, 0.0F);
		head.setTextureOffset(7, 0).addBox(1.0F, 0.0F, -4.0F, 2.0F, 3.0F, 3.0F, 0.0F, true);
		thorax = new ModelRenderer(this);
		thorax.setRotationPoint(0.0F, 17.0F, 0.0F);
		thorax.setTextureOffset(23, 0).addBox(1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 3.0F, 0.0F, true);
		rlegb = new ModelRenderer(this);
		rlegb.setRotationPoint(1.0F, 17.0F, 2.0F);
		rlegbb_r1 = new ModelRenderer(this);
		rlegbb_r1.setRotationPoint(0.923F, -0.3878F, -1.1043F);
		rlegb.addChild(rlegbb_r1);
		setRotationAngle(rlegbb_r1, 0.0F, 0.0F, -0.8499F);
		rlegbb_r1.setTextureOffset(26, 10).addBox(-6.223F, -0.0122F, 4.0043F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		rlegbt_r1 = new ModelRenderer(this);
		rlegbt_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		rlegb.addChild(rlegbt_r1);
		setRotationAngle(rlegbt_r1, 0.0F, 0.0F, -0.3875F);
		rlegbt_r1.setTextureOffset(26, 10).addBox(-3.0F, 2.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		rlegm = new ModelRenderer(this);
		rlegm.setRotationPoint(1.0F, 17.0F, 2.0F);
		rlegmb_r1 = new ModelRenderer(this);
		rlegmb_r1.setRotationPoint(0.7F, -0.2F, -2.1F);
		rlegm.addChild(rlegmb_r1);
		setRotationAngle(rlegmb_r1, 0.0F, 0.0F, -0.8499F);
		rlegmb_r1.setTextureOffset(26, 10).addBox(-6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		rlegmt_r1 = new ModelRenderer(this);
		rlegmt_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rlegm.addChild(rlegmt_r1);
		setRotationAngle(rlegmt_r1, 0.0F, 0.0F, -0.3875F);
		rlegmt_r1.setTextureOffset(26, 10).addBox(-3.0F, 2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		llegtop = new ModelRenderer(this);
		llegtop.setRotationPoint(-2.2F, 17.0F, -3.1F);
		llegtb_r1 = new ModelRenderer(this);
		llegtb_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		llegtop.addChild(llegtb_r1);
		setRotationAngle(llegtb_r1, 0.0F, 0.0F, 0.8499F);
		llegtb_r1.setTextureOffset(16, 10).addBox(6.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		llegtt_r1 = new ModelRenderer(this);
		llegtt_r1.setRotationPoint(1.2F, -0.5F, 0.1F);
		llegtop.addChild(llegtt_r1);
		setRotationAngle(llegtt_r1, 0.0F, 0.0F, 0.3875F);
		llegtt_r1.setTextureOffset(16, 10).addBox(4.0F, 1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		rlegt = new ModelRenderer(this);
		rlegt.setRotationPoint(1.7F, 17.11F, -3.0F);
		rlegtb_r1 = new ModelRenderer(this);
		rlegtb_r1.setRotationPoint(0.0F, -0.31F, -0.1F);
		rlegt.addChild(rlegtb_r1);
		setRotationAngle(rlegtb_r1, 0.0F, 0.0F, -0.8499F);
		rlegtb_r1.setTextureOffset(26, 10).addBox(-6.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		rlegtt_r1 = new ModelRenderer(this);
		rlegtt_r1.setRotationPoint(-0.7F, -0.11F, 5.0F);
		rlegt.addChild(rlegtt_r1);
		setRotationAngle(rlegtt_r1, 0.0F, 0.0F, -0.3875F);
		rlegtt_r1.setTextureOffset(26, 10).addBox(-3.0F, 2.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		connector = new ModelRenderer(this);
		connector.setRotationPoint(0.0F, 17.0F, 0.0F);
		connector.setTextureOffset(36, 12).addBox(1.5F, 1.0F, -1.0F, 1.0F, 1.0F, 11.0F, 0.0F, true);
		tendrils = new ModelRenderer(this);
		tendrils.setRotationPoint(2.0F, 19.6F, 1.0F);
		tendrillb_r1 = new ModelRenderer(this);
		tendrillb_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tendrils.addChild(tendrillb_r1);
		setRotationAngle(tendrillb_r1, 0.0F, -0.1396F, 0.0F);
		tendrillb_r1.setTextureOffset(3, 9).addBox(-1.6F, -0.6F, -5.2F, 0.4F, 0.0F, 0.9F, 0.0F, false);
		tendrilrb_r1 = new ModelRenderer(this);
		tendrilrb_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tendrils.addChild(tendrilrb_r1);
		setRotationAngle(tendrilrb_r1, 0.0F, 0.1396F, 0.0F);
		tendrilrb_r1.setTextureOffset(3, 9).addBox(1.2F, -0.6F, -5.2F, 0.4F, 0.0F, 0.9F, 0.0F, false);
		tendrilrt_r1 = new ModelRenderer(this);
		tendrilrt_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tendrils.addChild(tendrilrt_r1);
		setRotationAngle(tendrilrt_r1, 0.0F, 0.8029F, 0.0F);
		tendrilrt_r1.setTextureOffset(3, 9).addBox(4.0F, -0.6F, -3.7F, 0.4F, 0.0F, 0.7F, 0.0F, false);
		tendrilllt_r1 = new ModelRenderer(this);
		tendrilllt_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tendrils.addChild(tendrilllt_r1);
		setRotationAngle(tendrilllt_r1, 0.0F, -0.8029F, 0.0F);
		tendrilllt_r1.setTextureOffset(3, 9).addBox(-4.4F, -0.6F, -3.7F, 0.4F, 0.0F, 0.7F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BaseAnt entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.llegtop.rotateAngleX = MathHelper.cos(limbSwing * 2.7F) * 3.1415927F * 0.45F * limbSwingAmount;
		this.llegb.rotateAngleX = this.llegtop.rotateAngleX;
		this.rlegt.rotateAngleX = this.llegtop.rotateAngleX;
		this.rlegm.rotateAngleX = this.llegtop.rotateAngleX;
		this.rlegb.rotateAngleX = this.llegtop.rotateAngleX;
		this.llegm.rotateAngleX = this.llegtop.rotateAngleX;
		this.tendrils.rotateAngleY = MathHelper.cos(limbSwing * 0.4F) * 3.1415927F * 0.05F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		llegb.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		llegm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		abdomen.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		thorax.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rlegb.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rlegm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		llegtop.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rlegt.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		connector.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tendrils.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}