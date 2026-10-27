package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.devmaster.dangerzone.entity.Donut;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DonutModel<t> extends EntityModel<Donut> {
	private final ModelRenderer Donut;
	private final ModelRenderer Bottom;
	private final ModelRenderer Shape4_r1;
	private final ModelRenderer Shape5_r1;
	private final ModelRenderer Shape4_r2;
	private final ModelRenderer Shape7_r1;
	private final ModelRenderer Shape9_r1;
	private final ModelRenderer Shape8;
	private final ModelRenderer Shape8_r1;
	private final ModelRenderer Top;
	private final ModelRenderer Shape6_r1;
	private final ModelRenderer Shape5_r2;
	private final ModelRenderer Shape11_r1;
	private final ModelRenderer Shape10_r1;
	private final ModelRenderer Shape9_r2;

	public DonutModel() {
		textureWidth = 64;
		textureHeight = 64;

		Donut = new ModelRenderer(this);
		Donut.setRotationPoint(0.0F, 0.0F, -1.0F);
		

		Bottom = new ModelRenderer(this);
		Bottom.setRotationPoint(-15.0F, 3.3F, 0.0F);
		Donut.addChild(Bottom);
		

		Shape4_r1 = new ModelRenderer(this);
		Shape4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bottom.addChild(Shape4_r1);
		setRotationAngle(Shape4_r1, 0.0F, 0.0F, 0.733F);
		Shape4_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape5_r1 = new ModelRenderer(this);
		Shape5_r1.setRotationPoint(7.0F, -34.8F, 0.2F);
		Bottom.addChild(Shape5_r1);
		setRotationAngle(Shape5_r1, 0.0F, 0.0F, 0.0314F);
		Shape5_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape4_r2 = new ModelRenderer(this);
		Shape4_r2.setRotationPoint(6.0F, 3.0F, 0.2F);
		Bottom.addChild(Shape4_r2);
		setRotationAngle(Shape4_r2, 0.0F, 0.0F, 0.2932F);
		Shape4_r2.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape7_r1 = new ModelRenderer(this);
		Shape7_r1.setRotationPoint(9.0F, 2.8F, 0.3F);
		Bottom.addChild(Shape7_r1);
		setRotationAngle(Shape7_r1, 0.0F, 0.0F, -0.2932F);
		Shape7_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);
		Shape7_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape9_r1 = new ModelRenderer(this);
		Shape9_r1.setRotationPoint(13.8F, 2.6F, 0.1F);
		Bottom.addChild(Shape9_r1);
		setRotationAngle(Shape9_r1, 0.0F, 0.0F, -1.6895F);
		Shape9_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape8 = new ModelRenderer(this);
		Shape8.setRotationPoint(14.8F, -0.4F, 0.2F);
		Bottom.addChild(Shape8);
		

		Shape8_r1 = new ModelRenderer(this);
		Shape8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shape8.addChild(Shape8_r1);
		setRotationAngle(Shape8_r1, 0.0F, 0.0F, -0.733F);
		Shape8_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Top = new ModelRenderer(this);
		Top.setRotationPoint(-9.0F, -5.7F, 0.2F);
		Donut.addChild(Top);
		setRotationAngle(Top, 3.1416F, 0.0F, 0.0F);
		

		Shape6_r1 = new ModelRenderer(this);
		Shape6_r1.setRotationPoint(-7.0F, -8.0F, -5.0F);
		Top.addChild(Shape6_r1);
		setRotationAngle(Shape6_r1, 0.0F, 0.0F, 1.6895F);
		Shape6_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape5_r2 = new ModelRenderer(this);
		Shape5_r2.setRotationPoint(-6.0F, -3.0F, -5.2F);
		Top.addChild(Shape5_r2);
		setRotationAngle(Shape5_r2, 0.0F, 0.0F, 1.1694F);
		Shape5_r2.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape11_r1 = new ModelRenderer(this);
		Shape11_r1.setRotationPoint(4.8F, -2.0F, -5.1F);
		Top.addChild(Shape11_r1);
		setRotationAngle(Shape11_r1, 0.0F, 0.0F, -0.4451F);
		Shape11_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape10_r1 = new ModelRenderer(this);
		Shape10_r1.setRotationPoint(-5.2F, -2.4F, -5.3F);
		Top.addChild(Shape10_r1);
		setRotationAngle(Shape10_r1, 0.0F, 0.0F, 0.4451F);
		Shape10_r1.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);

		Shape9_r2 = new ModelRenderer(this);
		Shape9_r2.setRotationPoint(5.8F, -3.4F, -5.0F);
		Top.addChild(Shape9_r2);
		setRotationAngle(Shape9_r2, 0.0F, 0.0F, -1.1694F);
		Shape9_r2.setTextureOffset(2, 3).addBox(-7.0F, 9.7F, -1.0F, 14.0F, 7.0F, 7.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(Donut donut, float v, float v1, float v2, float v3, float v4) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Donut.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}