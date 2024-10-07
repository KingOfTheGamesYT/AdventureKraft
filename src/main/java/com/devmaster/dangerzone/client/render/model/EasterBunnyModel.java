package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.EasterBunny;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class EasterBunnyModel<t> extends EntityModel<EasterBunny> {
	private float hopspeed = 1.0F;

	private final ModelRenderer Bunny;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Legs;
	private final ModelRenderer Body;
	private final ModelRenderer Ears;
	private final ModelRenderer Ears_r1;
	private final ModelRenderer Ear;
	private final ModelRenderer Ear_r1;

	public EasterBunnyModel(float v) {
		hopspeed = v;
		textureWidth = 64;
		textureHeight = 64;

		Bunny = new ModelRenderer(this);
		Bunny.setRotationPoint(-3.4F, 18.5F, -1.5F);
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bunny.addChild(Head);
		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Head_r1);
		setRotateAngle(Head_r1, 0.0873F, -0.0873F, 0.0F);
		Head_r1.setTextureOffset(4, 19).addBox(2.7F, -4.4F, -2.8F, 1.0F, 1.0F, 1.6F, 0.0F, true);
		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(0.0F, -0.9F, 2.1F);
		Head.addChild(Head_r2);
		setRotateAngle(Head_r2, 0.0873F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(11, 0).addBox(1.0F, -6.1F, -4.5F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(8.4F, 5.5F, 3.6F);
		Bunny.addChild(Legs);
		Legs.setTextureOffset(28, 18).addBox(-10.5F, -1.0F, -6.3F, 3.3F, 1.0F, 7.2F, 0.0F, false);
		Legs.setTextureOffset(28, 22).addBox(-2.8F, -1.0F, -6.3F, 3.3F, 1.0F, 7.2F, 0.0F, false);
		Legs.setTextureOffset(31, 37).addBox(-9.3F, -5.2F, -4.3F, 0.7F, 4.2F, 4.6F, 0.0F, false);
		Legs.setTextureOffset(5, 10).addBox(-1.3F, -5.2F, -4.3F, 0.7F, 4.2F, 4.6F, 0.0F, false);
		Legs.setTextureOffset(28, 28).addBox(-8.4F, -2.0F, -5.1F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Legs.setTextureOffset(29, 29).addBox(-2.5F, -2.0F, -5.1F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Body = new ModelRenderer(this);
		Body.setRotationPoint(-2.0F, 6.2F, -0.1F);
		Bunny.addChild(Body);
		Body.setTextureOffset(33, 15).addBox(1.8F, -8.2F, -1.9F, 7.5F, 6.3F, 6.5F, 0.0F, true);
		Body.setTextureOffset(16, 18).addBox(6.5F, -6.9F, -2.7F, 1.1F, 3.9F, 1.0F, 0.0F, false);
		Body.setTextureOffset(18, 29).addBox(3.5F, -6.9F, -2.7F, 1.1F, 3.9F, 1.0F, 0.0F, false);
		Body.setTextureOffset(42, 35).addBox(2.8F, -7.6F, 3.8F, 5.5F, 5.1F, 1.7F, 0.0F, false);
		Body.setTextureOffset(10, 10).addBox(3.5F, -6.9F, 4.4F, 4.1F, 3.7F, 1.8F, 0.0F, true);
		Ears = new ModelRenderer(this);
		Ears.setRotationPoint(7.5F, -4.5F, 1.1F);
		Bunny.addChild(Ears);
		Ears_r1 = new ModelRenderer(this);
		Ears_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ears.addChild(Ears_r1);
		setRotateAngle(Ears_r1, -0.3908F, -0.04F, -0.0968F);
		Ears_r1.setTextureOffset(25, 12).addBox(-1.9F, -8.8F, -1.5F, 0.9F, 7.7F, 2.0F, 0.0F, false);
		Ear = new ModelRenderer(this);
		Ear.setRotationPoint(-0.4F, -4.5F, 1.1F);
		Bunny.addChild(Ear);
		Ear_r1 = new ModelRenderer(this);
		Ear_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ear.addChild(Ear_r1);
		setRotateAngle(Ear_r1, -0.3908F, 0.04F, 0.0968F);
		Ear_r1.setTextureOffset(23, 24).addBox(1.0F, -8.8F, -1.5F, 0.9F, 7.7F, 2.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(EasterBunny entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Ear_r1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Ears_r1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Bunny.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

	}
}