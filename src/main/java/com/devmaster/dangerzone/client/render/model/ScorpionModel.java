package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ScorpionModel extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer tail1;
	private final ModelRenderer tail1_r1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail2_r1;
	private final ModelRenderer tail3;
	private final ModelRenderer tail3_r1;
	private final ModelRenderer tail4;
	private final ModelRenderer tail4_r1;
	private final ModelRenderer tail4_r2;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftarm_r1;
	private final ModelRenderer leftarm_r2;
	private final ModelRenderer leftarm_r3;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightarm_r1;
	private final ModelRenderer rightarm_r2;
	private final ModelRenderer rightarm_r3;
	private final ModelRenderer rightleg1;
	private final ModelRenderer rightleg1_r1;
	private final ModelRenderer rightleg1_r2;
	private final ModelRenderer rightleg2;
	private final ModelRenderer rightleg2_r1;
	private final ModelRenderer rightleg2_r2;
	private final ModelRenderer rightleg3;
	private final ModelRenderer rightleg3_r1;
	private final ModelRenderer rightleg3_r2;
	private final ModelRenderer rightleg4;
	private final ModelRenderer rightleg4_r1;
	private final ModelRenderer rightleg4_r2;
	private final ModelRenderer leftleg1;
	private final ModelRenderer leftleg1_r1;
	private final ModelRenderer leftleg1_r2;
	private final ModelRenderer leftleg2;
	private final ModelRenderer leftleg2_r1;
	private final ModelRenderer leftleg2_r2;
	private final ModelRenderer leftleg3;
	private final ModelRenderer leftleg3_r1;
	private final ModelRenderer leftleg3_r2;
	private final ModelRenderer leftleg4;
	private final ModelRenderer leftleg4_r1;
	private final ModelRenderer leftleg4_r2;

	public ScorpionModel() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(15, 12).addBox(-2.5F, -4.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-3.0F, -4.5F, -4.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 10).addBox(-2.0F, -4.8F, -3.2F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(1, 1).addBox(-1.5F, -3.5F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(1, 1).addBox(0.5F, -3.5F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 21.0F, 2.0F);
		

		tail1_r1 = new ModelRenderer(this);
		tail1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail1.addChild(tail1_r1);
		setRotationAngle(tail1_r1, 0.3054F, 0.0F, 0.0F);
		tail1_r1.setTextureOffset(0, 17).addBox(-2.0F, -1.6375F, 0.1433F, 4.0F, 3.0F, 5.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 20.0F, 6.0F);
		

		tail2_r1 = new ModelRenderer(this);
		tail2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail2.addChild(tail2_r1);
		setRotationAngle(tail2_r1, -1.2217F, 0.0F, 0.0F);
		tail2_r1.setTextureOffset(0, 25).addBox(-1.5F, -4.8483F, -1.649F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 18.0F, 10.0F);
		

		tail3_r1 = new ModelRenderer(this);
		tail3_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
		tail3.addChild(tail3_r1);
		setRotationAngle(tail3_r1, 0.6981F, 0.0F, 0.0F);
		tail3_r1.setTextureOffset(18, 19).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.0F, 13.0F, 4.0F);
		

		tail4_r1 = new ModelRenderer(this);
		tail4_r1.setRotationPoint(0.0F, -1.0F, -2.0F);
		tail4.addChild(tail4_r1);
		setRotationAngle(tail4_r1, -1.0036F, 0.0F, 0.0F);
		tail4_r1.setTextureOffset(0, 10).addBox(-0.5F, -0.1F, -0.2503F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tail4_r2 = new ModelRenderer(this);
		tail4_r2.setRotationPoint(0.0F, -1.0F, 0.0F);
		tail4.addChild(tail4_r2);
		setRotationAngle(tail4_r2, 0.0436F, 0.0F, 0.0F);
		tail4_r2.setTextureOffset(19, 0).addBox(-1.5F, -1.5009F, -2.0436F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(2.0F, 22.0F, -8.0F);
		leftarm.setTextureOffset(10, 25).addBox(1.0F, -1.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		leftarm_r1 = new ModelRenderer(this);
		leftarm_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
		leftarm.addChild(leftarm_r1);
		setRotationAngle(leftarm_r1, 0.0F, 0.6981F, 0.0F);
		leftarm_r1.setTextureOffset(0, 0).addBox(0.5F, -1.0F, -0.268F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		leftarm_r2 = new ModelRenderer(this);
		leftarm_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarm_r2);
		setRotationAngle(leftarm_r2, 0.0F, 0.1745F, 0.0F);
		leftarm_r2.setTextureOffset(0, 0).addBox(2.5F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		leftarm_r3 = new ModelRenderer(this);
		leftarm_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarm_r3);
		setRotationAngle(leftarm_r3, 0.0F, -0.7854F, 0.0F);
		leftarm_r3.setTextureOffset(26, 6).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-2.0F, 21.0F, -8.0F);
		setRotationAngle(rightarm, 0.0F, 0.0F, -3.1416F);
		rightarm.setTextureOffset(10, 25).addBox(1.0F, -1.5F, -2.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rightarm_r1 = new ModelRenderer(this);
		rightarm_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
		rightarm.addChild(rightarm_r1);
		setRotationAngle(rightarm_r1, 0.0F, 0.6981F, 0.0F);
		rightarm_r1.setTextureOffset(0, 0).addBox(0.5F, -1.0F, -0.268F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		rightarm_r2 = new ModelRenderer(this);
		rightarm_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarm_r2);
		setRotationAngle(rightarm_r2, 0.0F, 0.1745F, 0.0F);
		rightarm_r2.setTextureOffset(0, 0).addBox(2.5F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		rightarm_r3 = new ModelRenderer(this);
		rightarm_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarm_r3);
		setRotationAngle(rightarm_r3, 0.0F, -0.7854F, 0.0F);
		rightarm_r3.setTextureOffset(26, 6).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rightleg1 = new ModelRenderer(this);
		rightleg1.setRotationPoint(-2.0F, 20.0F, -4.0F);
		setRotationAngle(rightleg1, 0.0F, -0.3491F, 0.0F);
		rightleg1.setTextureOffset(0, 5).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg1_r1 = new ModelRenderer(this);
		rightleg1_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg1.addChild(rightleg1_r1);
		setRotationAngle(rightleg1_r1, 0.0F, 0.0F, -1.0908F);
		rightleg1_r1.setTextureOffset(24, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg1_r2 = new ModelRenderer(this);
		rightleg1_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg1.addChild(rightleg1_r2);
		setRotationAngle(rightleg1_r2, 0.0F, 0.0F, 0.3491F);
		rightleg1_r2.setTextureOffset(26, 22).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-3.0F, 20.0F, -2.0F);
		rightleg2.setTextureOffset(0, 5).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg2_r1 = new ModelRenderer(this);
		rightleg2_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg2.addChild(rightleg2_r1);
		setRotationAngle(rightleg2_r1, 0.0F, 0.0F, -1.0908F);
		rightleg2_r1.setTextureOffset(24, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg2_r2 = new ModelRenderer(this);
		rightleg2_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg2.addChild(rightleg2_r2);
		setRotationAngle(rightleg2_r2, 0.0F, 0.0F, 0.3491F);
		rightleg2_r2.setTextureOffset(26, 22).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightleg3 = new ModelRenderer(this);
		rightleg3.setRotationPoint(-3.0F, 20.0F, 1.0F);
		rightleg3.setTextureOffset(0, 5).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg3_r1 = new ModelRenderer(this);
		rightleg3_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg3.addChild(rightleg3_r1);
		setRotationAngle(rightleg3_r1, 0.0F, 0.0F, -1.0908F);
		rightleg3_r1.setTextureOffset(24, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg3_r2 = new ModelRenderer(this);
		rightleg3_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg3.addChild(rightleg3_r2);
		setRotationAngle(rightleg3_r2, 0.0F, 0.0F, 0.3491F);
		rightleg3_r2.setTextureOffset(26, 22).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightleg4 = new ModelRenderer(this);
		rightleg4.setRotationPoint(-2.0F, 20.0F, 3.0F);
		setRotationAngle(rightleg4, 0.0F, 0.6109F, 0.0F);
		rightleg4.setTextureOffset(0, 5).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg4_r1 = new ModelRenderer(this);
		rightleg4_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg4.addChild(rightleg4_r1);
		setRotationAngle(rightleg4_r1, 0.0F, 0.0F, -1.0908F);
		rightleg4_r1.setTextureOffset(24, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg4_r2 = new ModelRenderer(this);
		rightleg4_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg4.addChild(rightleg4_r2);
		setRotationAngle(rightleg4_r2, 0.0F, 0.0F, 0.3491F);
		rightleg4_r2.setTextureOffset(26, 22).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		leftleg1 = new ModelRenderer(this);
		leftleg1.setRotationPoint(2.0F, 20.0F, -4.0F);
		setRotationAngle(leftleg1, 0.0F, -2.7925F, 0.0F);
		leftleg1.setTextureOffset(0, 3).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg1_r1 = new ModelRenderer(this);
		leftleg1_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg1.addChild(leftleg1_r1);
		setRotationAngle(leftleg1_r1, 0.0F, 0.0F, -1.0908F);
		leftleg1_r1.setTextureOffset(14, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg1_r2 = new ModelRenderer(this);
		leftleg1_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg1.addChild(leftleg1_r2);
		setRotationAngle(leftleg1_r2, 0.0F, 0.0F, 0.3491F);
		leftleg1_r2.setTextureOffset(26, 19).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(3.0F, 20.0F, -2.0F);
		setRotationAngle(leftleg2, 0.0F, 3.1416F, 0.0F);
		leftleg2.setTextureOffset(0, 3).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg2_r1 = new ModelRenderer(this);
		leftleg2_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg2.addChild(leftleg2_r1);
		setRotationAngle(leftleg2_r1, 0.0F, 0.0F, -1.0908F);
		leftleg2_r1.setTextureOffset(14, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg2_r2 = new ModelRenderer(this);
		leftleg2_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg2.addChild(leftleg2_r2);
		setRotationAngle(leftleg2_r2, 0.0F, 0.0F, 0.3491F);
		leftleg2_r2.setTextureOffset(26, 19).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		leftleg3 = new ModelRenderer(this);
		leftleg3.setRotationPoint(3.0F, 20.0F, 1.0F);
		setRotationAngle(leftleg3, 0.0F, 3.1416F, 0.0F);
		leftleg3.setTextureOffset(0, 3).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg3_r1 = new ModelRenderer(this);
		leftleg3_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg3.addChild(leftleg3_r1);
		setRotationAngle(leftleg3_r1, 0.0F, 0.0F, -1.0908F);
		leftleg3_r1.setTextureOffset(14, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg3_r2 = new ModelRenderer(this);
		leftleg3_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg3.addChild(leftleg3_r2);
		setRotationAngle(leftleg3_r2, 0.0F, 0.0F, 0.3491F);
		leftleg3_r2.setTextureOffset(26, 19).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		leftleg4 = new ModelRenderer(this);
		leftleg4.setRotationPoint(2.0F, 20.0F, 3.0F);
		setRotationAngle(leftleg4, 0.0F, 2.5307F, 0.0F);
		leftleg4.setTextureOffset(0, 3).addBox(-4.4F, 3.0F, -0.501F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg4_r1 = new ModelRenderer(this);
		leftleg4_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg4.addChild(leftleg4_r1);
		setRotationAngle(leftleg4_r1, 0.0F, 0.0F, -1.0908F);
		leftleg4_r1.setTextureOffset(14, 10).addBox(-3.75F, -2.0F, 0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg4_r2 = new ModelRenderer(this);
		leftleg4_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg4.addChild(leftleg4_r2);
		setRotationAngle(leftleg4_r2, 0.0F, 0.0F, 0.3491F);
		leftleg4_r2.setTextureOffset(26, 19).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail1.render(matrixStack, buffer, packedLight, packedOverlay);
		tail2.render(matrixStack, buffer, packedLight, packedOverlay);
		tail3.render(matrixStack, buffer, packedLight, packedOverlay);
		tail4.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg1.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg3.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg4.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}