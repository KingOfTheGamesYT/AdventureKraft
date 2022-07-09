package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.devmaster.dangerzone.entity.Mermaid;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MermaidModel<t> extends EntityModel<Mermaid> {
	private final ModelRenderer mermaid;
	private final ModelRenderer fish;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer Body;
	private final ModelRenderer Head;

	public MermaidModel() {
		textureWidth = 64;
		textureHeight = 64;

		mermaid = new ModelRenderer(this);
		mermaid.setRotationPoint(0.0F, 27.0F, -7.0F);
		

		fish = new ModelRenderer(this);
		fish.setRotationPoint(0.0F, 0.0F, 0.0F);
		mermaid.addChild(fish);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.4F, 3.85F);
		fish.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.3701F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(20, 28).addBox(-3.525F, -1.725F, 6.4F, 7.0F, 8.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -1.175F, 3.85F);
		fish.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.7461F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(24, 16).addBox(-4.025F, -11.95F, 3.075F, 8.0F, 8.0F, 4.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(2.625F, -8.9978F, 19.0353F);
		fish.addChild(tail);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.9654F, 0.2262F, 0.0931F);
		cube_r3.setTextureOffset(24, 0).addBox(0.175F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.9533F, 0.2023F, -0.1003F);
		tail.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.9591F, 0.1456F, 0.0593F);
		cube_r4.setTextureOffset(42, 28).addBox(-1.5F, -3.0F, 0.1F, 3.0F, 6.0F, 0.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-5.25F, 0.0F, 0.0F);
		tail.addChild(cube_r5);
		setRotationAngle(cube_r5, 1.955F, 0.0364F, 0.0147F);
		cube_r5.setTextureOffset(32, 40).addBox(2.25F, -3.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.2967F, 0.2023F, -0.1003F);
		tail.addChild(cube_r6);
		setRotationAngle(cube_r6, 1.9591F, -0.1456F, -0.0593F);
		cube_r6.setTextureOffset(38, 40).addBox(-1.025F, -3.15F, 0.1F, 3.0F, 6.0F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-5.25F, 0.0F, 0.0F);
		tail.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.9654F, -0.2262F, -0.0931F);
		cube_r7.setTextureOffset(0, 0).addBox(-0.95F, -3.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-2.5F, 1.3015F, -4.4893F);
		tail.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.9111F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(16, 40).addBox(-3.0F, -4.3F, -1.4F, 6.0F, 6.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		mermaid.addChild(LeftArm);
		setRotationAngle(LeftArm, -0.1745F, 0.0F, 0.0F);
		LeftArm.setTextureOffset(0, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		mermaid.addChild(RightArm);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		RightArm.setTextureOffset(32, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		mermaid.addChild(Body);
		Body.setTextureOffset(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		mermaid.addChild(Head);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Mermaid entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	//	this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	//	this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		mermaid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}