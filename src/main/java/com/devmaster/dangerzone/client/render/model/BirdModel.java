package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Bird;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BirdModel<t> extends EntityModel<Bird> {
	private float wingspeed = 1.0F;
	private final ModelRenderer bird;
	private final ModelRenderer wing2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer wing1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer head;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leg2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer leg1;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer torso;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;

	public BirdModel(float v) {
		textureWidth = 32;
		textureHeight = 32;

		bird = new ModelRenderer(this);
		bird.setRotationPoint(0.0F, 23.075F, 0.0F);
		setRotationAngle(bird, 0.1396F, 0.0F, 0.0F);
		

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bird.addChild(wing2);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wing2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.136F, 0.1038F, -0.0142F);
		cube_r1.setTextureOffset(9, 11).addBox(2.0F, -3.625F, -3.775F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bird.addChild(wing1);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		wing1.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.136F, -0.1038F, 0.0142F);
		cube_r2.setTextureOffset(0, 9).addBox(-2.075F, -3.625F, -3.775F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		bird.addChild(head);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.1353F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(9, 9).addBox(0.0F, -3.775F, -7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 18).addBox(-1.0F, -4.775F, -5.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bird.addChild(leg2);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg2.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.1353F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(3, 1).addBox(1.0F, 0.625F, -0.9F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.5F, -1.55F, 1.025F);
		leg2.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.1353F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 9).addBox(-0.5F, -1.7009F, -0.7066F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bird.addChild(leg1);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg1.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.1353F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(2, 0).addBox(-1.025F, 0.625F, -0.9F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-0.75F, -1.475F, 0.875F);
		leg1.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.1353F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 0).addBox(-0.275F, -1.7955F, -0.5681F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.5F, -1.775F, 4.275F);
		bird.addChild(torso);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		torso.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.3316F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(18, 10).addBox(-1.025F, -0.7F, -1.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r8.setTextureOffset(17, 6).addBox(-2.025F, -0.675F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-0.5F, 1.775F, -4.275F);
		torso.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.1353F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(13, 0).addBox(-1.0F, -4.0F, -3.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r9.setTextureOffset(0, 0).addBox(-1.0F, -3.625F, -4.0F, 3.0F, 2.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Bird entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.wing1.rotateAngleZ = MathHelper.cos(limbSwing * 1.3F * this.wingspeed) * 1.1415927F * 0.25F;
		this.wing2.rotateAngleZ = this.wing1.rotateAngleZ;
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bird.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}