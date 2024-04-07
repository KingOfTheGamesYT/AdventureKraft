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

	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer lfoot;
	private final ModelRenderer lleg;
	private final ModelRenderer upperbody;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer lear;
	private final ModelRenderer lpaw;
	private final ModelRenderer rleg;
	private final ModelRenderer rfoot;
	private final ModelRenderer rear;
	private final ModelRenderer rpaw;

	public EasterBunnyModel(float v) {
		hopspeed = v;
		textureWidth = 64;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 17.0F, 0.0F);
		body.setTextureOffset(0, 44).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 7.0F, 0.0F, true);
		setRotateAngle(body, 0.0F, 0.0F, 0.0F);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 19.0F, 6.0F);
		tail.setTextureOffset(0, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		setRotateAngle(tail, 0.0F, 0.0F, 0.0F);

		lfoot = new ModelRenderer(this);
		lfoot.setRotationPoint(3.0F, 21.0F, 1.0F);
		lfoot.setTextureOffset(0, 30).addBox(-1.0F, 2.0F, -5.0F, 3.0F, 1.0F, 7.0F, 0.0F, true);
		setRotateAngle(lfoot, 0.0F, 0.0F, 0.0F);

		lleg = new ModelRenderer(this);
		lleg.setRotationPoint(3.0F, 21.0F, 1.0F);
		lleg.setTextureOffset(0, 20).addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 5.0F, 0.0F, true);
		setRotateAngle(lleg, 0.0F, 0.0F, 0.0F);

		upperbody = new ModelRenderer(this);
		upperbody.setRotationPoint(0.0F, 16.0F, -1.0F);
		upperbody.setTextureOffset(42, 27).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 5.0F, 0.0F, true);
		setRotateAngle(upperbody, 0.0F, 0.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, -2.0F);
		head.setTextureOffset(40, 17).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, true);
		setRotateAngle(head, 0.0F, 0.0F, 0.0F);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 15.0F, -5.0F);
		nose.setTextureOffset(44, 9).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		setRotateAngle(nose, 0.0F, 0.0F, 0.0F);

		lear = new ModelRenderer(this);
		lear.setRotationPoint(2.0F, 13.0F, -1.0F);
		lear.setTextureOffset(54, 0).addBox(0.0F, -10.0F, -1.0F, 1.0F, 10.0F, 3.0F, 0.0F, true);
		setRotateAngle(lear, -0.2268928F, 0.0F, 0.0F);

		lpaw = new ModelRenderer(this);
		lpaw.setRotationPoint(0.5F, 19.0F, -4.0F);
		lpaw.setTextureOffset(6, 7).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		setRotateAngle(lpaw, 0.0F, 0.0F, 0.0F);

		rleg = new ModelRenderer(this);
		rleg.setRotationPoint(-4.0F, 21.0F, 1.0F);
		rleg.setTextureOffset(21, 20).addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 5.0F, 0.0F, true);
		setRotateAngle(rleg, 0.0F, 0.0F, 0.0F);

		rfoot = new ModelRenderer(this);
		rfoot.setRotationPoint(-4.0F, 21.0F, 1.0F);
		rfoot.setTextureOffset(21, 30).addBox(-1.0F, 2.0F, -5.0F, 3.0F, 1.0F, 7.0F, 0.0F, true);
		setRotateAngle(rfoot, 0.0F, 0.0F, 0.0F);

		rear = new ModelRenderer(this);
		rear.setRotationPoint(-3.0F, 13.0F, -1.0F);
		rear.setTextureOffset(32, 0).addBox(0.0F, -10.0F, -1.0F, 1.0F, 10.0F, 3.0F, 0.0F, true);
		setRotateAngle(rear, -0.418879F, 0.0F, 0.0F);

		rpaw = new ModelRenderer(this);
		rpaw.setRotationPoint(-1.5F, 19.0F, -4.0F);
		rpaw.setTextureOffset(0, 7).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		setRotateAngle(rpaw, 0.0F, 0.0F, 0.0F);

	}

	@Override
	public void setRotationAngles(EasterBunny entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.lear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lfoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		upperbody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		nose.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lpaw.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rfoot.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rpaw.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}