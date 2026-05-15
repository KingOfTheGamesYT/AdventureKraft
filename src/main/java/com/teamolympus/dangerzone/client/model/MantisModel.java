package com.teamolympus.dangerzone.client.model;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import com.teamolympus.dangerzone.misc.DZLogger;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

@SuppressWarnings("all")
public class MantisModel extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone_r1;
	private final ModelRenderer bone_r2;
	private final ModelRenderer bone_r3;
	private final ModelRenderer bone_r4;
	private final ModelRenderer bone_r5;
	private final ModelRenderer bone_r6;
	private final ModelRenderer bone_r7;
	private final ModelRenderer bone_r8;
	private final ModelRenderer bone_r9;
	private final ModelRenderer bone3;
	private final ModelRenderer bone3_r1;
	private final ModelRenderer bone3_r2;
	private final ModelRenderer bone3_r3;
	private final ModelRenderer bone3_r4;
	private final ModelRenderer bone2;
	private final ModelRenderer bone2_r1;
	private final ModelRenderer bone2_r2;
	private final ModelRenderer bone2_r3;
	private final ModelRenderer bone2_r4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone5_r1;
	private final ModelRenderer bone7;
	private final ModelRenderer bone7_r1;
	private final ModelRenderer bone6;
	private final ModelRenderer bone6_r1;
	private final ModelRenderer bone6_r2;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone9_r1;
	private final ModelRenderer bone10;
	private final ModelRenderer bone10_r1;
	private final ModelRenderer bone4;
	private final ModelRenderer bone11;
	private final ModelRenderer bone11_r1;
	private final ModelRenderer bone12;
	private final ModelRenderer bone12_r1;

	public MantisModel() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 32, 39, -1.0F, -45.0F, -26.0F, 2, 6, 2, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 6, 46, 1.0F, -44.0F, -27.0F, 2, 2, 1, 0.0F));
		bone.cubeList.add(new ModelBox(bone, 6, 46, -3.0F, -44.0F, -27.0F, 2, 2, 1, 0.0F));

		bone_r1 = new ModelRenderer(this);
		bone_r1.setRotationPoint(18.2025F, 5.2749F, -3.0F);
		bone.addChild(bone_r1);
		setRotationAngle(bone_r1, 0.0F, 0.0F, -0.3054F);
		bone_r1.cubeList.add(new ModelBox(bone_r1, 44, 41, -5.0F, -52.0F, -23.0F, 2, 4, 2, 0.0F));

		bone_r2 = new ModelRenderer(this);
		bone_r2.setRotationPoint(-18.2025F, 5.2749F, -3.0F);
		bone.addChild(bone_r2);
		setRotationAngle(bone_r2, 0.0F, 0.0F, 0.3054F);
		bone_r2.cubeList.add(new ModelBox(bone_r2, 44, 41, 3.0F, -52.0F, -23.0F, 2, 4, 2, 0.0F));

		bone_r3 = new ModelRenderer(this);
		bone_r3.setRotationPoint(-29.3F, 0.5757F, -3.0F);
		bone.addChild(bone_r3);
		setRotationAngle(bone_r3, 0.0F, 0.0F, 0.48F);
		bone_r3.cubeList.add(new ModelBox(bone_r3, 0, 46, 4.0F, -54.0F, -23.0F, 1, 3, 2, 0.0F));

		bone_r4 = new ModelRenderer(this);
		bone_r4.setRotationPoint(29.3F, 0.5757F, -3.0F);
		bone.addChild(bone_r4);
		setRotationAngle(bone_r4, 0.0F, 0.0F, -0.48F);
		bone_r4.cubeList.add(new ModelBox(bone_r4, 0, 46, -5.0F, -54.0F, -23.0F, 1, 3, 2, 0.0F));

		bone_r5 = new ModelRenderer(this);
		bone_r5.setRotationPoint(6.0F, 9.0F, -3.0F);
		bone.addChild(bone_r5);
		setRotationAngle(bone_r5, 0.0F, 0.0F, 0.3054F);
		bone_r5.cubeList.add(new ModelBox(bone_r5, 28, 39, -22.0F, -64.0F, -23.0F, 1, 14, 1, 0.0F));

		bone_r6 = new ModelRenderer(this);
		bone_r6.setRotationPoint(-6.0F, 9.0F, -3.0F);
		bone.addChild(bone_r6);
		setRotationAngle(bone_r6, 0.0F, 0.0F, -0.3054F);
		bone_r6.cubeList.add(new ModelBox(bone_r6, 28, 39, 21.0F, -64.0F, -23.0F, 1, 14, 1, 0.0F));

		bone_r7 = new ModelRenderer(this);
		bone_r7.setRotationPoint(-1.0F, 9.0F, -3.0F);
		bone.addChild(bone_r7);
		setRotationAngle(bone_r7, 1.0036F, 0.0F, 0.0F);
		bone_r7.cubeList.add(new ModelBox(bone_r7, 22, 25, -3.0F, -45.0F, 31.0F, 8, 10, 2, 0.0F));

		bone_r8 = new ModelRenderer(this);
		bone_r8.setRotationPoint(5.0F, 9.0F, -3.0F);
		bone.addChild(bone_r8);
		setRotationAngle(bone_r8, 0.8727F, 0.0F, 0.0F);
		bone_r8.cubeList.add(new ModelBox(bone_r8, 22, 10, -11.0F, -39.0F, 25.0F, 12, 10, 3, 0.0F));

		bone_r9 = new ModelRenderer(this);
		bone_r9.setRotationPoint(6.0F, -4.0F, 0.0F);
		bone.addChild(bone_r9);
		setRotationAngle(bone_r9, 0.6109F, 0.0F, 0.0F);
		bone_r9.cubeList.add(new ModelBox(bone_r9, 0, 10, -10.0F, -26.0F, 5.0F, 8, 33, 3, 0.0F));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 19.0F, -7.0F);
		setRotationAngle(bone3, -0.1745F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 22, 37, 1.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));
		bone3.cubeList.add(new ModelBox(bone3, 44, 36, 11.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		bone3.cubeList.add(new ModelBox(bone3, 44, 36, -14.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		bone3.cubeList.add(new ModelBox(bone3, 22, 37, -11.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));

		bone3_r1 = new ModelRenderer(this);
		bone3_r1.setRotationPoint(-0.6393F, -11.1062F, 0.0F);
		bone3.addChild(bone3_r1);
		setRotationAngle(bone3_r1, 0.0F, 0.0F, 0.829F);
		bone3_r1.cubeList.add(new ModelBox(bone3_r1, 40, 39, 17.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone3_r2 = new ModelRenderer(this);
		bone3_r2.setRotationPoint(0.6393F, -11.1062F, 0.0F);
		bone3.addChild(bone3_r2);
		setRotationAngle(bone3_r2, 0.0F, 0.0F, -0.829F);
		bone3_r2.cubeList.add(new ModelBox(bone3_r2, 40, 39, -23.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone3_r3 = new ModelRenderer(this);
		bone3_r3.setRotationPoint(8.6477F, -32.1392F, -1.0F);
		bone3.addChild(bone3_r3);
		setRotationAngle(bone3_r3, 0.0F, 0.0F, -1.2217F);
		bone3_r3.cubeList.add(new ModelBox(bone3_r3, 22, 23, -34.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone3_r4 = new ModelRenderer(this);
		bone3_r4.setRotationPoint(-8.6477F, -32.1392F, -1.0F);
		bone3.addChild(bone3_r4);
		setRotationAngle(bone3_r4, 0.0F, 0.0F, 1.2217F);
		bone3_r4.cubeList.add(new ModelBox(bone3_r4, 22, 23, 18.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 22, 37, 1.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));
		bone2.cubeList.add(new ModelBox(bone2, 44, 36, 11.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		bone2.cubeList.add(new ModelBox(bone2, 44, 36, -14.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		bone2.cubeList.add(new ModelBox(bone2, 22, 37, -11.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));

		bone2_r1 = new ModelRenderer(this);
		bone2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone2_r1);
		setRotationAngle(bone2_r1, 0.0F, 0.0F, -0.2618F);
		bone2_r1.cubeList.add(new ModelBox(bone2_r1, 40, 39, -23.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone2_r2 = new ModelRenderer(this);
		bone2_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone2_r2);
		setRotationAngle(bone2_r2, 0.0F, 0.0F, 0.2618F);
		bone2_r2.cubeList.add(new ModelBox(bone2_r2, 40, 39, 17.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone2_r3 = new ModelRenderer(this);
		bone2_r3.setRotationPoint(8.6477F, -32.1392F, -1.0F);
		bone2.addChild(bone2_r3);
		setRotationAngle(bone2_r3, 0.0F, 0.0F, -1.2217F);
		bone2_r3.cubeList.add(new ModelBox(bone2_r3, 22, 23, -34.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone2_r4 = new ModelRenderer(this);
		bone2_r4.setRotationPoint(-8.6477F, -32.1392F, -1.0F);
		bone2.addChild(bone2_r4);
		setRotationAngle(bone2_r4, 0.0F, 0.0F, 1.2217F);
		bone2_r4.cubeList.add(new ModelBox(bone2_r4, 22, 23, 18.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-2.0F, -3.0F, -5.0F);


		bone5_r1 = new ModelRenderer(this);
		bone5_r1.setRotationPoint(8.0F, 23.0F, 5.0F);
		bone5.addChild(bone5_r1);
		setRotationAngle(bone5_r1, -2.5744F, 0.1309F, 0.6109F);
		bone5_r1.cubeList.add(new ModelBox(bone5_r1, 0, 0, -57.0F, 12.0F, -1.0F, 39, 10, 0, 0.0F));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 8.0F, 4.0F);
		bone5.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.2618F, -0.6981F);


		bone7_r1 = new ModelRenderer(this);
		bone7_r1.setRotationPoint(5.9692F, 22.125F, 6.2034F);
		bone7.addChild(bone7_r1);
		setRotationAngle(bone7_r1, -2.5744F, 0.1309F, 0.6109F);
		bone7_r1.cubeList.add(new ModelBox(bone7_r1, 0, 0, -55.0F, 12.0F, -1.0F, 39, 10, 0, 0.0F));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.0F, 0.0F, -4.0F);


		bone6_r1 = new ModelRenderer(this);
		bone6_r1.setRotationPoint(-8.0F, 20.0F, 4.0F);
		bone6.addChild(bone6_r1);
		setRotationAngle(bone6_r1, -2.5497F, -0.3012F, 0.1411F);
		bone6_r1.cubeList.add(new ModelBox(bone6_r1, 0, 0, 2.0F, 10.0F, -8.0F, 39, 10, 0, 0.0F));

		bone6_r2 = new ModelRenderer(this);
		bone6_r2.setRotationPoint(-8.0F, 20.0F, 4.0F);
		bone6.addChild(bone6_r2);
		setRotationAngle(bone6_r2, -2.5744F, -0.1309F, -0.6109F);
		bone6_r2.cubeList.add(new ModelBox(bone6_r2, 0, 0, 18.0F, 12.0F, -2.0F, 39, 10, 0, 0.0F));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(2.0F, -13.0F, -20.0F);
		bone8.cubeList.add(new ModelBox(bone8, 22, 39, 0.0F, -3.0F, -1.0F, 1, 14, 2, 0.0F));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(1.0F, 8.4421F, -2.5933F);
		bone8.addChild(bone9);


		bone9_r1 = new ModelRenderer(this);
		bone9_r1.setRotationPoint(3.0F, 15.0F, 34.0F);
		bone9.addChild(bone9_r1);
		setRotationAngle(bone9_r1, 0.48F, 0.0F, 0.0F);
		bone9_r1.cubeList.add(new ModelBox(bone9_r1, 40, 41, -4.0F, -37.0F, -23.0F, 1, 11, 1, 0.0F));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-1.0F, -6.4421F, -2.4067F);
		bone9.addChild(bone10);


		bone10_r1 = new ModelRenderer(this);
		bone10_r1.setRotationPoint(4.0F, 21.5696F, 36.1164F);
		bone10.addChild(bone10_r1);
		setRotationAngle(bone10_r1, -0.0873F, 0.0F, 0.0F);
		bone10_r1.cubeList.add(new ModelBox(bone10_r1, 42, 25, -4.0F, -19.0F, -39.0F, 1, 10, 1, 0.0F));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-3.0F, -13.0F, -20.0F);
		bone4.cubeList.add(new ModelBox(bone4, 22, 39, 0.0F, -3.0F, -1.0F, 1, 14, 2, 0.0F));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 8.4421F, -1.5933F);
		bone4.addChild(bone11);


		bone11_r1 = new ModelRenderer(this);
		bone11_r1.setRotationPoint(4.0F, 15.0F, 33.0F);
		bone11.addChild(bone11_r1);
		setRotationAngle(bone11_r1, 0.48F, 0.0F, 0.0F);
		bone11_r1.cubeList.add(new ModelBox(bone11_r1, 40, 41, -4.0F, -37.0F, -23.0F, 1, 11, 1, 0.0F));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -6.4421F, -4.4067F);
		bone11.addChild(bone12);


		bone12_r1 = new ModelRenderer(this);
		bone12_r1.setRotationPoint(4.0F, 21.5696F, 37.1164F);
		bone12.addChild(bone12_r1);
		setRotationAngle(bone12_r1, -0.0873F, 0.0F, 0.0F);
		bone12_r1.cubeList.add(new ModelBox(bone12_r1, 42, 25, -4.0F, -19.0F, -39.0F, 1, 10, 1, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone3.render(f5);
		bone2.render(f5);
		bone5.render(f5);
		bone6.render(f5);
		bone8.render(f5);
		bone4.render(f5);

		this.bone5.rotateAngleY = MathHelper.cos(f2 * 1.3F) * (float)Math.PI * 0.35F;
		this.bone6.rotateAngleY = -this.bone5.rotateAngleY;

		//Attacks
		/**float attackTime = (entity.ticksExisted % 19) / 19.0F;

		if (attackTime <= 0.2F) {
			float t = attackTime / 0.2F;
			this.bone8.rotateAngleX = (float) Math.toRadians(-52.5F * t);
			this.bone4.rotateAngleX = (float) Math.toRadians(-2.5F + (-50F + 2.5F) * t);
		}

		if (attackTime >= 0.4F) {
			float t = (attackTime - 0.4F) / (0.96F - 0.4F);
			this.bone9.rotateAngleX = (float) Math.toRadians(82.5F + (117.5F - 82.5F) * t);
			this.bone11.rotateAngleX = (float) Math.toRadians(77.5F + (107.5F - 77.5F) * t);
		}

		this.bone10.rotateAngleX = (float) Math.toRadians(-82.5F);
		this.bone12.rotateAngleX = (float) Math.toRadians(-75F);
		 **/
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}