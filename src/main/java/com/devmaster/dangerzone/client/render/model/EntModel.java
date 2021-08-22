package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Ent;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.MathHelper;

public class EntModel<N extends CreatureEntity> extends EntityModel<Ent> {
	private final ModelRenderer Body;
	private final ModelRenderer BodyUpPart;
	private final ModelRenderer Leg;
	private final ModelRenderer Leg2;
	private final ModelRenderer Head;
	private final ModelRenderer HeadHairJaw;
	private final ModelRenderer Left_Arm;
	private final ModelRenderer Arm;
	private final ModelRenderer Right_Arm;
	private final ModelRenderer Arm2;
	public boolean isAttacking = false;
	public int attackTimer;


	public EntModel() {
		textureWidth = 256;
		textureHeight = 256;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(54, 88).addBox(-7.0F, -38.0F, -6.0F, 14.0F, 12.0F, 11.0F, 0.0F, false);

		BodyUpPart = new ModelRenderer(this);
		BodyUpPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(BodyUpPart);
		setRotationAngle(BodyUpPart, 0.0436F, 0.0F, 0.0F);
		BodyUpPart.setTextureOffset(0, 44).addBox(3.0F, -36.2F, 5.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(0, 44).addBox(0.0F, -41.2F, 5.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(0, 44).addBox(-4.0F, -34.2F, 6.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(0, 44).addBox(-4.0F, -43.2F, 6.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(0, 44).addBox(-6.0F, -51.2F, 6.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(0, 44).addBox(3.0F, -47.2F, 6.8F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		BodyUpPart.setTextureOffset(87, 0).addBox(-7.0F, -51.2F, -4.2F, 14.0F, 14.0F, 11.0F, 0.0F, false);

		Leg = new ModelRenderer(this);
		Leg.setRotationPoint(-3.0F, -25.0F, 0.0F);
		Body.addChild(Leg);
		Leg.setTextureOffset(26, 106).addBox(-4.0F, -1.0F, -3.0F, 6.0F, 26.0F, 7.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(3.0F, -25.0F, 0.0F);
		Body.addChild(Leg2);
		Leg2.setTextureOffset(1, 106).addBox(-2.0F, -1.0F, -3.0F, 6.0F, 26.0F, 7.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -49.0F, -3.0F);
		Body.addChild(Head);


		HeadHairJaw = new ModelRenderer(this);
		HeadHairJaw.setRotationPoint(0.0F, 49.0F, 3.0F);
		Head.addChild(HeadHairJaw);
		setRotationAngle(HeadHairJaw, 0.0436F, 0.0F, 0.0F);
		HeadHairJaw.setTextureOffset(0, 0).addBox(-15.0F, -79.2F, -18.2F, 30.0F, 17.0F, 27.0F, 0.0F, false);
		HeadHairJaw.setTextureOffset(0, 82).addBox(-7.0F, -62.2F, -11.2F, 14.0F, 11.0F, 13.0F, 0.0F, false);
		HeadHairJaw.setTextureOffset(96, 103).addBox(-8.0F, -52.2F, -12.2F, 16.0F, 6.0F, 8.0F, 0.0F, false);

		Left_Arm = new ModelRenderer(this);
		Left_Arm.setRotationPoint(8.0F, -48.0F, 0.0F);
		Body.addChild(Left_Arm);


		Arm = new ModelRenderer(this);
		Arm.setRotationPoint(-8.0F, 48.0F, 0.0F);
		Left_Arm.addChild(Arm);
		setRotationAngle(Arm, 0.0357F, -0.025F, 0.6104F);
		Arm.setTextureOffset(92, 57).addBox(-23.7F, -45.8F, -2.2F, 18.0F, 6.0F, 7.0F, 0.0F, false);
		Arm.setTextureOffset(46, 50).addBox(-5.7F, -45.8F, -27.2F, 7.0F, 6.0F, 32.0F, 0.0F, false);
		Arm.setTextureOffset(46, 53).addBox(-5.7F, -45.8F, -34.2F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		Arm.setTextureOffset(0, 10).addBox(-5.7F, -42.8F, -34.2F, 3.0F, 3.0F, 7.0F, 0.0F, false);
		Arm.setTextureOffset(0, 10).addBox(-1.7F, -45.8F, -34.2F, 3.0F, 3.0F, 7.0F, 0.0F, false);

		Right_Arm = new ModelRenderer(this);
		Right_Arm.setRotationPoint(-8.0F, -48.0F, 0.0F);
		Body.addChild(Right_Arm);


		Arm2 = new ModelRenderer(this);
		Arm2.setRotationPoint(8.0F, 48.0F, 0.0F);
		Right_Arm.addChild(Arm2);
		setRotationAngle(Arm2, 0.0357F, 0.025F, -0.6104F);
		Arm2.setTextureOffset(92, 44).addBox(5.7F, -45.8F, -2.2F, 18.0F, 6.0F, 7.0F, 0.0F, false);
		Arm2.setTextureOffset(0, 44).addBox(-1.3F, -45.8F, -27.2F, 7.0F, 6.0F, 32.0F, 0.0F, false);
		Arm2.setTextureOffset(46, 44).addBox(4.7F, -45.8F, -34.2F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		Arm2.setTextureOffset(0, 0).addBox(2.7F, -42.8F, -34.2F, 3.0F, 3.0F, 7.0F, 0.0F, false);
		Arm2.setTextureOffset(0, 0).addBox(-1.3F, -45.8F, -34.2F, 3.0F, 3.0F, 7.0F, 0.0F, false);
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(Ent entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

			this.Left_Arm.rotateAngleX = MathHelper.cos(limbSwing * -2.0F) * 2.0F *limbSwingAmount;
		this.Right_Arm.rotateAngleX = MathHelper.cos(limbSwing * -2.0F) * 2.0F *limbSwingAmount;

		this.Leg.rotateAngleX = MathHelper.cos(limbSwing * 2.7F) * 3.1415927F * 0.45F * limbSwingAmount;
		this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 4.7F) * 3.1415927F * 0.45F * limbSwingAmount;
		}


		}


