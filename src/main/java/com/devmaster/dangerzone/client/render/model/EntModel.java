package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Ent;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.MathHelper;

public class EntModel<E extends CreatureEntity> extends EntityModel<Ent> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer left_foot;
	private final ModelRenderer foot_r1;
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer right_foot;
	private final ModelRenderer foot_r2;
	private final ModelRenderer head;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer left_arm;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer right_arm;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;

	public EntModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 1.9F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0509F, -0.2473F, -0.0851F);
		cube_r1.setTextureOffset(35, 34).addBox(-0.3F, -47.0F, -0.7F, 2.0F, 5.0F, 15.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 1.9F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.22F, -0.1196F, -0.0557F);
		cube_r2.setTextureOffset(57, 53).addBox(2.0F, -43.0F, 6.2F, 2.0F, 3.0F, 15.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 1.9F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3512F, 0.1264F, 0.0341F);
		cube_r3.setTextureOffset(0, 49).addBox(2.0F, -44.1F, 12.7F, 2.0F, 5.0F, 15.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 1.9F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.2618F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(0, 29).addBox(-7.0F, -46.1F, 4.0F, 14.0F, 9.0F, 11.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 1.9F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0873F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(54, 29).addBox(-5.0F, -41.9F, -0.4F, 10.0F, 9.0F, 8.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.9F, -33.0F, 3.1F);
		body.addChild(left_leg);
		setRotationAngle(left_leg, 0.0385F, -0.2148F, -0.1787F);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-10.2F, 33.0F, -2.8F);
		left_leg.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.4025F, -0.3641F, -0.0786F);
		cube_r6.setTextureOffset(83, 84).addBox(8.7F, -31.0F, -18.0F, 6.0F, 16.0F, 6.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-10.2F, 33.0F, -2.8F);
		left_leg.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.2618F, -0.5236F, 0.0F);
		cube_r7.setTextureOffset(48, 90).addBox(6.5F, -25.0F, -3.4F, 5.0F, 17.0F, 6.0F, 0.0F, false);

		left_foot = new ModelRenderer(this);
		left_foot.setRotationPoint(0.1F, 23.1F, 0.7F);
		left_leg.addChild(left_foot);
		

		foot_r1 = new ModelRenderer(this);
		foot_r1.setRotationPoint(-10.3F, 9.9F, -3.5F);
		left_foot.addChild(foot_r1);
		setRotationAngle(foot_r1, 0.0529F, -0.1842F, 0.1631F);
		foot_r1.setTextureOffset(25, 68).addBox(4.6F, -11.0F, -4.5F, 7.0F, 11.0F, 9.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.9F, -33.0F, 3.1F);
		body.addChild(right_leg);
		setRotationAngle(right_leg, 0.0385F, 0.2148F, 0.1787F);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(10.2F, 33.0F, -2.8F);
		right_leg.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.4025F, 0.3641F, 0.0786F);
		cube_r8.setTextureOffset(0, 0).addBox(-14.7F, -31.0F, -18.0F, 6.0F, 16.0F, 6.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(10.2F, 33.0F, -2.8F);
		right_leg.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.2618F, 0.5236F, 0.0F);
		cube_r9.setTextureOffset(26, 88).addBox(-11.5F, -25.0F, -3.4F, 5.0F, 17.0F, 6.0F, 0.0F, false);

		right_foot = new ModelRenderer(this);
		right_foot.setRotationPoint(-0.1F, 23.1F, 0.7F);
		right_leg.addChild(right_foot);
		

		foot_r2 = new ModelRenderer(this);
		foot_r2.setRotationPoint(10.3F, 9.9F, -3.5F);
		right_foot.addChild(foot_r2);
		setRotationAngle(foot_r2, 0.0529F, 0.1842F, -0.1631F);
		foot_r2.setTextureOffset(68, 0).addBox(-11.6F, -11.0F, -4.5F, 7.0F, 11.0F, 9.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -45.6F, -2.6F);
		body.addChild(head);
		

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 45.6F, 4.5F);
		head.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.2618F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-11.0F, -56.0F, -5.8F, 22.0F, 5.0F, 24.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 45.6F, 4.5F);
		head.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1309F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(34, 54).addBox(-5.0F, -46.4F, -5.6F, 10.0F, 5.0F, 9.0F, 0.0F, false);
		cube_r11.setTextureOffset(57, 71).addBox(-4.0F, -52.4F, -4.6F, 8.0F, 11.0F, 8.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(7.6F, -42.5F, 0.4F);
		body.addChild(left_arm);
		setRotationAngle(left_arm, 0.0F, 0.0F, -0.5236F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-7.6F, 42.5F, 1.5F);
		left_arm.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.3937F, 0.0226F, -0.0843F);
		cube_r12.setTextureOffset(85, 41).addBox(5.6F, -31.2F, -13.2F, 8.0F, 18.0F, 5.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-7.6F, 42.5F, 1.5F);
		left_arm.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.2608F, 0.0226F, -0.0843F);
		cube_r13.setTextureOffset(92, 20).addBox(6.6F, -43.0F, 7.0F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-7.6F, -42.5F, 0.4F);
		body.addChild(right_arm);
		setRotationAngle(right_arm, 0.0F, 0.0F, 0.5236F);
		

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(7.6F, 42.5F, 1.5F);
		right_arm.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.3937F, -0.0226F, 0.0843F);
		cube_r14.setTextureOffset(0, 83).addBox(-13.6F, -31.2F, -13.2F, 8.0F, 18.0F, 5.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(7.6F, 42.5F, 1.5F);
		right_arm.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.2608F, -0.0226F, 0.0843F);
		cube_r15.setTextureOffset(91, 64).addBox(-12.6F, -43.0F, 7.0F, 6.0F, 15.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Ent entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}