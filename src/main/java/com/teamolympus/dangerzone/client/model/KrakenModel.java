// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports
package com.teamolympus.dangerzone.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class KrakenModel extends ModelBase {
	private final ModelRenderer HeadBody;
	private final ModelRenderer LeftFins;
	private final ModelRenderer RightFins;
	private final ModelRenderer Mouth;
	private final ModelRenderer BeakLeft;
	private final ModelRenderer BeakRight;
	private final ModelRenderer Tentacle1;
	private final ModelRenderer Tentacle1_1;
	private final ModelRenderer Tentacle1_2;
	private final ModelRenderer Tentacle1_3;
	private final ModelRenderer Tentacle1_4;
	private final ModelRenderer Tentacle2;
	private final ModelRenderer Tentacle2_1;
	private final ModelRenderer Tentacle2_2;
	private final ModelRenderer Tentacle2_3;
	private final ModelRenderer Tentacle2_4;
	private final ModelRenderer Tentacle3;
	private final ModelRenderer Tentacle3_1;
	private final ModelRenderer Tentacle3_2;
	private final ModelRenderer Tentacle3_3;
	private final ModelRenderer Tentacle4;
	private final ModelRenderer Tentacle4_1;
	private final ModelRenderer Tentacle4_2;
	private final ModelRenderer Tentacle4_3;
	private final ModelRenderer InnerTentacle1;
	private final ModelRenderer InnerTentacle1_1;
	private final ModelRenderer InnerTentacle1_2;
	private final ModelRenderer InnerTentacle2;
	private final ModelRenderer InnerTentacle2_1;
	private final ModelRenderer InnerTentacle2_2;
	private final ModelRenderer InnerTentacle3;
	private final ModelRenderer InnerTentacle3_1;
	private final ModelRenderer InnerTentacle3_2;
	private final ModelRenderer InnerTentacle4;
	private final ModelRenderer InnerTentacle4_1;
	private final ModelRenderer InnerTentacle4_2;
	private final ModelRenderer InnerTentacle5;
	private final ModelRenderer InnerTentacle5_1;
	private final ModelRenderer InnerTentacle6_4;
	private final ModelRenderer InnerTentacle6;
	private final ModelRenderer InnerTentacle6_1;
	private final ModelRenderer InnerTentacle6_2;

	public KrakenModel() {
		textureWidth = 256;
		textureHeight = 256;

		HeadBody = new ModelRenderer(this);
		HeadBody.setRotationPoint(-0.1F, 36.0F, 31.4F);
		setRotationAngle(HeadBody, 1.5708F, 0.0F, 0.0F);
		HeadBody.cubeList.add(new ModelBox(HeadBody, 0, 139, -9.9F, -39.35F, 25.05F, 20, 20, 30, 0.0F));
		HeadBody.cubeList.add(new ModelBox(HeadBody, 0, 211, -10.9F, -38.35F, 93.05F, 22, 18, 27, 0.0F));
		HeadBody.cubeList.add(new ModelBox(HeadBody, 0, 220, -9.9F, -36.35F, 120.05F, 20, 14, 22, 0.0F));
		HeadBody.cubeList.add(new ModelBox(HeadBody, 0, 194, -11.9F, -41.35F, 55.05F, 24, 24, 38, 0.0F));

		LeftFins = new ModelRenderer(this);
		LeftFins.setRotationPoint(10.85F, -28.5F, 127.65F);
		HeadBody.addChild(LeftFins);
		LeftFins.cubeList.add(new ModelBox(LeftFins, 0, 231, -0.75F, -1.85F, -7.6F, 16, 3, 22, 0.0F));
		LeftFins.cubeList.add(new ModelBox(LeftFins, 0, 226, 0.25F, -1.85F, -34.6F, 17, 3, 27, 0.0F));

		RightFins = new ModelRenderer(this);
		RightFins.setRotationPoint(-10.65F, -28.5F, 127.65F);
		HeadBody.addChild(RightFins);
		RightFins.cubeList.add(new ModelBox(RightFins, 0, 231, -15.25F, -1.85F, -7.6F, 16, 3, 22, 0.0F));
		RightFins.cubeList.add(new ModelBox(RightFins, 0, 226, -17.25F, -1.85F, -34.6F, 17, 3, 27, 0.0F));

		Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(-0.0083F, 8.9958F, -2.95F);
		setRotationAngle(Mouth, 1.5708F, 0.0F, 0.0F);
		Mouth.cubeList.add(new ModelBox(Mouth, 65, 225, 10.0083F, 15.0042F, -7.95F, 3, 3, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 65, 225, -12.9917F, 15.0042F, -7.95F, 3, 3, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 65, 225, 10.0083F, -7.9958F, -7.95F, 3, 3, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 65, 225, -12.9917F, -7.9958F, -7.95F, 3, 3, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 0, 236, -9.9917F, -6.9958F, -8.95F, 20, 2, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 0, 218, -9.9917F, 15.0042F, -8.95F, 20, 2, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 0, 218, -11.9917F, -4.9958F, -8.95F, 2, 20, 18, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 8.0083F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 6.0083F, -1.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, -6.9917F, -1.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, -6.9917F, 11.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 6.0083F, 11.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 8.0083F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 2.0083F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 2.0083F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 6.0083F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 236, 246, 6.0083F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -0.9917F, -3.9958F, -10.95F, 2, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -0.9917F, 13.0042F, -10.95F, 2, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -4.9917F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -4.9917F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 4.0083F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 4.0083F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -2.9917F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -2.9917F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -6.9917F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -6.9917F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, -3.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, -1.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, -1.9958F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 0.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 0.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 1.9042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 1.9042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 13.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 11.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 11.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 9.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 9.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 7.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 7.0042F, -10.95F, 1, 1, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, -8.9917F, 4.0042F, -10.95F, 1, 2, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 234, 246, 8.0083F, 4.0042F, -10.95F, 1, 2, 9, 0.0F));
		Mouth.cubeList.add(new ModelBox(Mouth, 0, 218, 10.0083F, -4.9958F, -8.95F, 2, 20, 18, 0.0F));

		BeakLeft = new ModelRenderer(this);
		BeakLeft.setRotationPoint(-0.1917F, 5.2542F, -2.1F);
		Mouth.addChild(BeakLeft);
		setRotationAngle(BeakLeft, 0.0F, 0.0F, 1.5708F);
		BeakLeft.cubeList.add(new ModelBox(BeakLeft, 124, 245, -2.5F, -3.2F, -8.85F, 5, 2, 9, 0.0F));
		BeakLeft.cubeList.add(new ModelBox(BeakLeft, 124, 245, 2.5F, -2.2F, -8.85F, 2, 2, 9, 0.0F));
		BeakLeft.cubeList.add(new ModelBox(BeakLeft, 124, 245, -4.5F, -2.2F, -8.85F, 2, 2, 9, 0.0F));
		BeakLeft.cubeList.add(new ModelBox(BeakLeft, 124, 246, -2.5F, -2.2F, -16.85F, 5, 2, 8, 0.0F));

		BeakRight = new ModelRenderer(this);
		BeakRight.setRotationPoint(-0.1917F, 5.2542F, -2.1F);
		Mouth.addChild(BeakRight);
		setRotationAngle(BeakRight, 0.0F, 0.0F, -1.5708F);
		BeakRight.cubeList.add(new ModelBox(BeakRight, 124, 245, -2.5F, -2.8F, -8.85F, 5, 2, 9, 0.0F));
		BeakRight.cubeList.add(new ModelBox(BeakRight, 124, 245, 2.5F, -1.8F, -8.85F, 2, 2, 9, 0.0F));
		BeakRight.cubeList.add(new ModelBox(BeakRight, 124, 245, -4.5F, -1.8F, -8.85F, 2, 2, 9, 0.0F));
		BeakRight.cubeList.add(new ModelBox(BeakRight, 124, 246, -2.5F, -1.8F, -16.85F, 5, 2, 8, 0.0F));

		Tentacle1 = new ModelRenderer(this);
		Tentacle1.setRotationPoint(12.5F, 5.1F, -3.4F);
		setRotationAngle(Tentacle1, 1.5708F, 0.0F, 0.0F);
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 54, 229, -0.5F, -3.6F, -3.8F, 8, 8, 8, 0.0F));

		Tentacle1_1 = new ModelRenderer(this);
		Tentacle1_1.setRotationPoint(8.0F, 0.0F, 0.0F);
		Tentacle1.addChild(Tentacle1_1);
		Tentacle1_1.cubeList.add(new ModelBox(Tentacle1_1, 12, 215, -0.5F, -2.6F, -23.8F, 6, 6, 27, 0.0F));

		Tentacle1_2 = new ModelRenderer(this);
		Tentacle1_2.setRotationPoint(2.0F, 0.0F, -24.0F);
		Tentacle1_1.addChild(Tentacle1_2);
		Tentacle1_2.cubeList.add(new ModelBox(Tentacle1_2, 0, 199, -2.5F, -1.6F, -52.8F, 5, 4, 53, 0.0F));

		Tentacle1_3 = new ModelRenderer(this);
		Tentacle1_3.setRotationPoint(0.0F, 0.0F, -52.8F);
		Tentacle1_2.addChild(Tentacle1_3);
		Tentacle1_3.cubeList.add(new ModelBox(Tentacle1_3, 16, 208, -1.5F, -0.6F, -46.0F, 3, 2, 46, 0.0F));

		Tentacle1_4 = new ModelRenderer(this);
		Tentacle1_4.setRotationPoint(0.0F, 0.0F, -46.0F);
		Tentacle1_3.addChild(Tentacle1_4);
		Tentacle1_4.cubeList.add(new ModelBox(Tentacle1_4, 151, 219, -1.5F, -2.6F, -25.0F, 5, 6, 25, 0.0F));

		Tentacle2 = new ModelRenderer(this);
		Tentacle2.setRotationPoint(-12.5F, 5.1F, -1.95F);
		setRotationAngle(Tentacle2, 1.5708F, 3.1416F, 0.0F);
		Tentacle2.cubeList.add(new ModelBox(Tentacle2, 54, 229, -0.5F, -3.0F, -3.8F, 8, 8, 8, 0.0F));

		Tentacle2_1 = new ModelRenderer(this);
		Tentacle2_1.setRotationPoint(8.0F, 0.0F, 0.0F);
		Tentacle2.addChild(Tentacle2_1);
		Tentacle2_1.cubeList.add(new ModelBox(Tentacle2_1, 12, 215, -0.5F, -2.0F, -23.8F, 6, 6, 27, 0.0F));

		Tentacle2_2 = new ModelRenderer(this);
		Tentacle2_2.setRotationPoint(2.0F, 0.0F, -24.0F);
		Tentacle2_1.addChild(Tentacle2_2);
		Tentacle2_2.cubeList.add(new ModelBox(Tentacle2_2, 0, 199, -2.5F, -1.0F, -52.8F, 5, 4, 53, 0.0F));

		Tentacle2_3 = new ModelRenderer(this);
		Tentacle2_3.setRotationPoint(0.0F, 0.0F, -52.8F);
		Tentacle2_2.addChild(Tentacle2_3);
		Tentacle2_3.cubeList.add(new ModelBox(Tentacle2_3, 16, 208, -1.5F, 0.0F, -46.0F, 3, 2, 46, 0.0F));

		Tentacle2_4 = new ModelRenderer(this);
		Tentacle2_4.setRotationPoint(0.0F, 0.0F, -46.0F);
		Tentacle2_3.addChild(Tentacle2_4);
		Tentacle2_4.cubeList.add(new ModelBox(Tentacle2_4, 151, 219, -1.5F, -2.0F, -25.0F, 5, 6, 25, 0.0F));

		Tentacle3 = new ModelRenderer(this);
		Tentacle3.setRotationPoint(12.0F, 5.9F, 8.875F);
		setRotationAngle(Tentacle3, 1.5708F, 0.0F, 0.0F);
		Tentacle3.cubeList.add(new ModelBox(Tentacle3, 54, 229, 0.0F, -5.8F, -2.975F, 8, 8, 8, 0.0F));

		Tentacle3_1 = new ModelRenderer(this);
		Tentacle3_1.setRotationPoint(8.0F, -1.75F, 1.0F);
		Tentacle3.addChild(Tentacle3_1);
		Tentacle3_1.cubeList.add(new ModelBox(Tentacle3_1, 12, 215, 0.0F, -3.05F, -27.975F, 6, 6, 31, 0.0F));

		Tentacle3_2 = new ModelRenderer(this);
		Tentacle3_2.setRotationPoint(2.25F, 0.0F, -28.0F);
		Tentacle3_1.addChild(Tentacle3_2);
		Tentacle3_2.cubeList.add(new ModelBox(Tentacle3_2, 47, 223, -2.25F, -2.05F, -28.975F, 5, 4, 29, 0.0F));

		Tentacle3_3 = new ModelRenderer(this);
		Tentacle3_3.setRotationPoint(0.0F, 0.0F, -29.0F);
		Tentacle3_2.addChild(Tentacle3_3);
		Tentacle3_3.cubeList.add(new ModelBox(Tentacle3_3, 40, 219, -1.25F, -1.05F, -28.975F, 3, 2, 29, 0.0F));

		Tentacle4 = new ModelRenderer(this);
		Tentacle4.setRotationPoint(-12.0F, 5.9F, 5.675F);
		setRotationAngle(Tentacle4, 1.5708F, 3.1416F, 0.0F);
		Tentacle4.cubeList.add(new ModelBox(Tentacle4, 54, 229, 0.0F, -5.4F, -2.975F, 8, 8, 8, 0.0F));

		Tentacle4_1 = new ModelRenderer(this);
		Tentacle4_1.setRotationPoint(8.0F, -1.75F, 1.0F);
		Tentacle4.addChild(Tentacle4_1);
		Tentacle4_1.cubeList.add(new ModelBox(Tentacle4_1, 12, 215, 0.0F, -2.65F, -27.975F, 6, 6, 31, 0.0F));

		Tentacle4_2 = new ModelRenderer(this);
		Tentacle4_2.setRotationPoint(2.25F, 0.0F, -28.0F);
		Tentacle4_1.addChild(Tentacle4_2);
		Tentacle4_2.cubeList.add(new ModelBox(Tentacle4_2, 47, 223, -2.25F, -1.65F, -28.975F, 5, 4, 29, 0.0F));

		Tentacle4_3 = new ModelRenderer(this);
		Tentacle4_3.setRotationPoint(0.0F, 0.0F, -29.0F);
		Tentacle4_2.addChild(Tentacle4_3);
		Tentacle4_3.cubeList.add(new ModelBox(Tentacle4_3, 40, 219, -1.25F, -0.65F, -28.975F, 3, 2, 29, 0.0F));

		InnerTentacle1 = new ModelRenderer(this);
		InnerTentacle1.setRotationPoint(12.0F, 13.0F, 2.1333F);
		setRotationAngle(InnerTentacle1, 1.5708F, 0.0F, 0.0F);
		InnerTentacle1.cubeList.add(new ModelBox(InnerTentacle1, 18, 219, 1.0F, -3.85F, -29.8333F, 6, 6, 31, 0.0F));

		InnerTentacle1_1 = new ModelRenderer(this);
		InnerTentacle1_1.setRotationPoint(4.0F, -0.95F, -29.85F);
		InnerTentacle1.addChild(InnerTentacle1_1);
		InnerTentacle1_1.cubeList.add(new ModelBox(InnerTentacle1_1, 26, 221, -2.0F, -1.9F, -30.9833F, 4, 4, 31, 0.0F));

		InnerTentacle1_2 = new ModelRenderer(this);
		InnerTentacle1_2.setRotationPoint(0.0F, 0.0F, -31.0F);
		InnerTentacle1_1.addChild(InnerTentacle1_2);
		InnerTentacle1_2.cubeList.add(new ModelBox(InnerTentacle1_2, 26, 212, -1.0F, -0.9F, -34.9833F, 2, 2, 35, 0.0F));

		InnerTentacle2 = new ModelRenderer(this);
		InnerTentacle2.setRotationPoint(-11.0F, 13.0F, 0.1333F);
		setRotationAngle(InnerTentacle2, 1.5708F, 3.1416F, 0.0F);
		InnerTentacle2.cubeList.add(new ModelBox(InnerTentacle2, 18, 219, 1.0F, -3.85F, -29.8333F, 6, 6, 31, 0.0F));

		InnerTentacle2_1 = new ModelRenderer(this);
		InnerTentacle2_1.setRotationPoint(4.0F, -0.95F, -29.85F);
		InnerTentacle2.addChild(InnerTentacle2_1);
		InnerTentacle2_1.cubeList.add(new ModelBox(InnerTentacle2_1, 26, 221, -2.0F, -1.9F, -30.9833F, 4, 4, 31, 0.0F));

		InnerTentacle2_2 = new ModelRenderer(this);
		InnerTentacle2_2.setRotationPoint(0.0F, 0.0F, -31.0F);
		InnerTentacle2_1.addChild(InnerTentacle2_2);
		InnerTentacle2_2.cubeList.add(new ModelBox(InnerTentacle2_2, 26, 212, -1.0F, -0.9F, -34.9833F, 2, 2, 35, 0.0F));

		InnerTentacle3 = new ModelRenderer(this);
		InnerTentacle3.setRotationPoint(-6.2F, 17.1F, -10.8667F);
		setRotationAngle(InnerTentacle3, 1.5708F, 0.0F, 0.0F);
		InnerTentacle3.cubeList.add(new ModelBox(InnerTentacle3, 18, 219, -2.825F, -5.1F, -24.8333F, 6, 6, 31, 0.0F));

		InnerTentacle3_1 = new ModelRenderer(this);
		InnerTentacle3_1.setRotationPoint(0.0F, -1.95F, -24.85F);
		InnerTentacle3.addChild(InnerTentacle3_1);
		InnerTentacle3_1.cubeList.add(new ModelBox(InnerTentacle3_1, 26, 221, -1.825F, -2.15F, -30.9833F, 4, 4, 31, 0.0F));

		InnerTentacle3_2 = new ModelRenderer(this);
		InnerTentacle3_2.setRotationPoint(0.0F, 0.0F, -31.0F);
		InnerTentacle3_1.addChild(InnerTentacle3_2);
		InnerTentacle3_2.cubeList.add(new ModelBox(InnerTentacle3_2, 26, 212, -0.825F, -1.15F, -34.9833F, 2, 2, 35, 0.0F));

		InnerTentacle4 = new ModelRenderer(this);
		InnerTentacle4.setRotationPoint(6.075F, 17.1F, -8.1167F);
		setRotationAngle(InnerTentacle4, 1.5708F, 0.0F, 0.0F);
		InnerTentacle4.cubeList.add(new ModelBox(InnerTentacle4, 18, 219, -3.0F, -7.85F, -24.8333F, 6, 6, 31, 0.0F));

		InnerTentacle4_1 = new ModelRenderer(this);
		InnerTentacle4_1.setRotationPoint(0.0F, -4.95F, -24.85F);
		InnerTentacle4.addChild(InnerTentacle4_1);
		InnerTentacle4_1.cubeList.add(new ModelBox(InnerTentacle4_1, 26, 221, -2.0F, -1.9F, -30.9833F, 4, 4, 31, 0.0F));

		InnerTentacle4_2 = new ModelRenderer(this);
		InnerTentacle4_2.setRotationPoint(0.0F, 0.0F, -31.0F);
		InnerTentacle4_1.addChild(InnerTentacle4_2);
		InnerTentacle4_2.cubeList.add(new ModelBox(InnerTentacle4_2, 26, 212, -1.0F, -0.9F, -34.9833F, 2, 2, 35, 0.0F));

		InnerTentacle5 = new ModelRenderer(this);
		InnerTentacle5.setRotationPoint(-6.075F, 17.075F, 13.6833F);
		setRotationAngle(InnerTentacle5, 1.5708F, 0.0F, 0.0F);
		InnerTentacle5.cubeList.add(new ModelBox(InnerTentacle5, 18, 219, -2.875F, 0.375F, -24.9083F, 6, 6, 31, 0.0F));

		InnerTentacle5_1 = new ModelRenderer(this);
		InnerTentacle5_1.setRotationPoint(0.175F, 3.075F, -25.4F);
		InnerTentacle5.addChild(InnerTentacle5_1);
		InnerTentacle5_1.cubeList.add(new ModelBox(InnerTentacle5_1, 26, 221, -2.05F, -1.7F, -30.5083F, 4, 4, 31, 0.0F));

		InnerTentacle6_4 = new ModelRenderer(this);
		InnerTentacle6_4.setRotationPoint(0.0F, 0.3F, -31.0F);
		InnerTentacle5_1.addChild(InnerTentacle6_4);
		InnerTentacle6_4.cubeList.add(new ModelBox(InnerTentacle6_4, 26, 212, -1.05F, -1.0F, -34.5083F, 2, 2, 35, 0.0F));

		InnerTentacle6 = new ModelRenderer(this);
		InnerTentacle6.setRotationPoint(5.925F, 17.075F, 13.6833F);
		setRotationAngle(InnerTentacle6, 1.5708F, 0.0F, 0.0F);
		InnerTentacle6.cubeList.add(new ModelBox(InnerTentacle6, 18, 219, -2.875F, 0.375F, -24.9083F, 6, 6, 31, 0.0F));

		InnerTentacle6_1 = new ModelRenderer(this);
		InnerTentacle6_1.setRotationPoint(0.175F, 3.075F, -25.4F);
		InnerTentacle6.addChild(InnerTentacle6_1);
		InnerTentacle6_1.cubeList.add(new ModelBox(InnerTentacle6_1, 26, 221, -2.05F, -1.7F, -30.5083F, 4, 4, 31, 0.0F));

		InnerTentacle6_2 = new ModelRenderer(this);
		InnerTentacle6_2.setRotationPoint(0.0F, 0.2F, -31.0F);
		InnerTentacle6_1.addChild(InnerTentacle6_2);
		InnerTentacle6_2.cubeList.add(new ModelBox(InnerTentacle6_2, 26, 212, -1.05F, -0.9F, -34.5083F, 2, 2, 35, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		HeadBody.render(f5);
		Mouth.render(f5);
		Tentacle1.render(f5);
		Tentacle2.render(f5);
		Tentacle3.render(f5);
		Tentacle4.render(f5);
		InnerTentacle1.render(f5);
		InnerTentacle2.render(f5);
		InnerTentacle3.render(f5);
		InnerTentacle4.render(f5);
		InnerTentacle5.render(f5);
		InnerTentacle6.render(f5);

		this.Tentacle1.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)1) + 0.4F;
		this.Tentacle2.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)2) + 0.4F;
		this.Tentacle3.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)3) + 0.4F;
		this.Tentacle4.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)4) + 0.4F;

		this.InnerTentacle1.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)1) + 0.4F;
		this.InnerTentacle2.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)2) + 0.4F;
		this.InnerTentacle3.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)3) + 0.4F;
		this.InnerTentacle4.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)4) + 0.4F;
		this.InnerTentacle5.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)5) + 0.4F;
		this.InnerTentacle6.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + (float)6) + 0.4F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
