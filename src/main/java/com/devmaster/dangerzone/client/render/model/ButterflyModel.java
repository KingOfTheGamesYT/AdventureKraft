package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
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
	private final ModelRenderer Butterfly;
	private final ModelRenderer head;
	private final ModelRenderer wing2;
	private final ModelRenderer wing1;
	private final ModelRenderer body;

	public ButterflyModel() {
		textureWidth = 64;
		textureHeight = 64;

		Butterfly = new ModelRenderer(this);
		Butterfly.setRotationPoint(0.0F, 24.0F, 0.0F);
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.1F, -9.875F);
		Butterfly.addChild(head);
		setRotationAngle(head, 0.0F, -1.5708F, 0.0F);
		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(10.0F, -18.0F, 0.3F);
		head.addChild(wing2);
		wing2.setTextureOffset(0, 4).addBox(-9.0F, -1.0F, -9.0F, 9.0F, 1.0F, 8.0F, 0.0F, false);
		wing2.setTextureOffset(0, 22).addBox(0.0F, -1.0F, -7.0F, 8.5F, 1.0F, 6.0F, 0.0F, false);
		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(9.0F, -18.0F, -0.3F);
		head.addChild(wing1);
		wing1.setTextureOffset(0, 13).addBox(-8.0F, -1.0F, 1.0F, 9.0F, 1.0F, 8.0F, 0.0F, false);
		wing1.setTextureOffset(29, 22).addBox(1.0F, -1.0F, 1.0F, 8.5F, 1.0F, 6.0F, 0.0F, false);
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -4.0F, -0.875F);
		Butterfly.addChild(body);
		setRotationAngle(body, 0.0F, -1.5708F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-10.0F, 0.0F, -1.0F, 20.5F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Butterfly entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.wing2.rotateAngleX = MathHelper.cos(limbSwing * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
		this.wing1.rotateAngleX = -this.wing2.rotateAngleX;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Butterfly.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}