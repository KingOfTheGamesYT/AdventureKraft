package com.teamolympus.dangerzone.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class MantisModel extends ModelBase {
	private final ModelRenderer mainBody;
	private final ModelRenderer bone_r1;
	private final ModelRenderer bone_r2;
	private final ModelRenderer bone_r3;
	private final ModelRenderer bone_r4;
	private final ModelRenderer bone_r5;
	private final ModelRenderer bone_r6;
	private final ModelRenderer bone_r7;
	private final ModelRenderer bone_r8;
	private final ModelRenderer bone_r9;
	private final ModelRenderer legs1;
	private final ModelRenderer bone3_r1;
	private final ModelRenderer bone3_r2;
	private final ModelRenderer bone3_r3;
	private final ModelRenderer bone3_r4;
	private final ModelRenderer legs2;
	private final ModelRenderer bone2_r1;
	private final ModelRenderer bone2_r2;
	private final ModelRenderer bone2_r3;
	private final ModelRenderer bone2_r4;
	private final ModelRenderer wings2;
	private final ModelRenderer wing1_r1;
	private final ModelRenderer wings3;
	private final ModelRenderer wing2_r1;
	private final ModelRenderer wings;
	private final ModelRenderer wing2_r2;
	private final ModelRenderer wing1_r2;
	private final ModelRenderer frontLeg;
	private final ModelRenderer bone9;
	private final ModelRenderer bone9_r1;
	private final ModelRenderer bone10;
	private final ModelRenderer bone10_r1;
	private final ModelRenderer fontLeg2;
	private final ModelRenderer bone11;
	private final ModelRenderer bone11_r1;
	private final ModelRenderer bone12;
	private final ModelRenderer bone12_r1;

	public MantisModel() {
		textureWidth = 128;
		textureHeight = 128;

		mainBody = new ModelRenderer(this);
		mainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		mainBody.cubeList.add(new ModelBox(mainBody, 32, 39, -1.0F, -45.0F, -26.0F, 2, 6, 2, 0.0F));
		mainBody.cubeList.add(new ModelBox(mainBody, 6, 46, 1.0F, -44.0F, -27.0F, 2, 2, 1, 0.0F));
		mainBody.cubeList.add(new ModelBox(mainBody, 6, 46, -3.0F, -44.0F, -27.0F, 2, 2, 1, 0.0F));

		bone_r1 = new ModelRenderer(this);
		bone_r1.setRotationPoint(18.2025F, 5.2749F, -3.0F);
		mainBody.addChild(bone_r1);
		setRotationAngle(bone_r1, 0.0F, 0.0F, -0.3054F);
		bone_r1.cubeList.add(new ModelBox(bone_r1, 44, 41, -5.0F, -52.0F, -23.0F, 2, 4, 2, 0.0F));

		bone_r2 = new ModelRenderer(this);
		bone_r2.setRotationPoint(-18.2025F, 5.2749F, -3.0F);
		mainBody.addChild(bone_r2);
		setRotationAngle(bone_r2, 0.0F, 0.0F, 0.3054F);
		bone_r2.cubeList.add(new ModelBox(bone_r2, 44, 41, 3.0F, -52.0F, -23.0F, 2, 4, 2, 0.0F));

		bone_r3 = new ModelRenderer(this);
		bone_r3.setRotationPoint(-29.3F, 0.5757F, -3.0F);
		mainBody.addChild(bone_r3);
		setRotationAngle(bone_r3, 0.0F, 0.0F, 0.48F);
		bone_r3.cubeList.add(new ModelBox(bone_r3, 0, 46, 4.0F, -54.0F, -23.0F, 1, 3, 2, 0.0F));

		bone_r4 = new ModelRenderer(this);
		bone_r4.setRotationPoint(29.3F, 0.5757F, -3.0F);
		mainBody.addChild(bone_r4);
		setRotationAngle(bone_r4, 0.0F, 0.0F, -0.48F);
		bone_r4.cubeList.add(new ModelBox(bone_r4, 0, 46, -5.0F, -54.0F, -23.0F, 1, 3, 2, 0.0F));

		bone_r5 = new ModelRenderer(this);
		bone_r5.setRotationPoint(6.0F, 9.0F, -3.0F);
		mainBody.addChild(bone_r5);
		setRotationAngle(bone_r5, 0.0F, 0.0F, 0.3054F);
		bone_r5.cubeList.add(new ModelBox(bone_r5, 28, 39, -22.0F, -64.0F, -23.0F, 1, 14, 1, 0.0F));

		bone_r6 = new ModelRenderer(this);
		bone_r6.setRotationPoint(-6.0F, 9.0F, -3.0F);
		mainBody.addChild(bone_r6);
		setRotationAngle(bone_r6, 0.0F, 0.0F, -0.3054F);
		bone_r6.cubeList.add(new ModelBox(bone_r6, 28, 39, 21.0F, -64.0F, -23.0F, 1, 14, 1, 0.0F));

		bone_r7 = new ModelRenderer(this);
		bone_r7.setRotationPoint(-1.0F, 9.0F, -3.0F);
		mainBody.addChild(bone_r7);
		setRotationAngle(bone_r7, 1.0036F, 0.0F, 0.0F);
		bone_r7.cubeList.add(new ModelBox(bone_r7, 22, 25, -3.0F, -45.0F, 31.0F, 8, 10, 2, 0.0F));

		bone_r8 = new ModelRenderer(this);
		bone_r8.setRotationPoint(5.0F, 9.0F, -3.0F);
		mainBody.addChild(bone_r8);
		setRotationAngle(bone_r8, 0.8727F, 0.0F, 0.0F);
		bone_r8.cubeList.add(new ModelBox(bone_r8, 22, 10, -11.0F, -39.0F, 25.0F, 12, 10, 3, 0.0F));

		bone_r9 = new ModelRenderer(this);
		bone_r9.setRotationPoint(6.0F, -4.0F, 0.0F);
		mainBody.addChild(bone_r9);
		setRotationAngle(bone_r9, 0.6109F, 0.0F, 0.0F);
		bone_r9.cubeList.add(new ModelBox(bone_r9, 0, 10, -10.0F, -26.0F, 5.0F, 8, 33, 3, 0.0F));

		legs1 = new ModelRenderer(this);
		legs1.setRotationPoint(0.0F, 19.0F, -7.0F);
		setRotationAngle(legs1, -0.1745F, 0.0F, 0.0F);
		legs1.cubeList.add(new ModelBox(legs1, 22, 37, 1.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));
		legs1.cubeList.add(new ModelBox(legs1, 44, 36, 11.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		legs1.cubeList.add(new ModelBox(legs1, 44, 36, -14.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		legs1.cubeList.add(new ModelBox(legs1, 22, 37, -11.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));

		bone3_r1 = new ModelRenderer(this);
		bone3_r1.setRotationPoint(-0.6393F, -11.1062F, 0.0F);
		legs1.addChild(bone3_r1);
		setRotationAngle(bone3_r1, 0.0F, 0.0F, 0.829F);
		bone3_r1.cubeList.add(new ModelBox(bone3_r1, 40, 39, 17.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone3_r2 = new ModelRenderer(this);
		bone3_r2.setRotationPoint(0.6393F, -11.1062F, 0.0F);
		legs1.addChild(bone3_r2);
		setRotationAngle(bone3_r2, 0.0F, 0.0F, -0.829F);
		bone3_r2.cubeList.add(new ModelBox(bone3_r2, 40, 39, -23.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone3_r3 = new ModelRenderer(this);
		bone3_r3.setRotationPoint(8.6477F, -32.1392F, -1.0F);
		legs1.addChild(bone3_r3);
		setRotationAngle(bone3_r3, 0.0F, 0.0F, -1.2217F);
		bone3_r3.cubeList.add(new ModelBox(bone3_r3, 22, 23, -34.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone3_r4 = new ModelRenderer(this);
		bone3_r4.setRotationPoint(-8.6477F, -32.1392F, -1.0F);
		legs1.addChild(bone3_r4);
		setRotationAngle(bone3_r4, 0.0F, 0.0F, 1.2217F);
		bone3_r4.cubeList.add(new ModelBox(bone3_r4, 22, 23, 18.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		legs2 = new ModelRenderer(this);
		legs2.setRotationPoint(0.0F, 24.0F, 0.0F);
		legs2.cubeList.add(new ModelBox(legs2, 22, 37, 1.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));
		legs2.cubeList.add(new ModelBox(legs2, 44, 36, 11.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		legs2.cubeList.add(new ModelBox(legs2, 44, 36, -14.0F, -20.0F, -8.0F, 3, -1, 3, 0.0F));
		legs2.cubeList.add(new ModelBox(legs2, 22, 37, -11.0F, -21.0F, -7.0F, 10, 1, 1, 0.0F));

		bone2_r1 = new ModelRenderer(this);
		bone2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs2.addChild(bone2_r1);
		setRotationAngle(bone2_r1, 0.0F, 0.0F, -0.2618F);
		bone2_r1.cubeList.add(new ModelBox(bone2_r1, 40, 39, -23.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone2_r2 = new ModelRenderer(this);
		bone2_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs2.addChild(bone2_r2);
		setRotationAngle(bone2_r2, 0.0F, 0.0F, 0.2618F);
		bone2_r2.cubeList.add(new ModelBox(bone2_r2, 40, 39, 17.0F, -12.0F, -7.0F, 6, 1, 1, 0.0F));

		bone2_r3 = new ModelRenderer(this);
		bone2_r3.setRotationPoint(8.6477F, -32.1392F, -1.0F);
		legs2.addChild(bone2_r3);
		setRotationAngle(bone2_r3, 0.0F, 0.0F, -1.2217F);
		bone2_r3.cubeList.add(new ModelBox(bone2_r3, 22, 23, -34.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		bone2_r4 = new ModelRenderer(this);
		bone2_r4.setRotationPoint(-8.6477F, -32.1392F, -1.0F);
		legs2.addChild(bone2_r4);
		setRotationAngle(bone2_r4, 0.0F, 0.0F, 1.2217F);
		bone2_r4.cubeList.add(new ModelBox(bone2_r4, 22, 23, 18.0F, -18.0F, -6.0F, 16, 1, 1, 0.0F));

		wings2 = new ModelRenderer(this);
		wings2.setRotationPoint(-2.0F, -3.0F, -5.0F);


		wing1_r1 = new ModelRenderer(this);
		wing1_r1.setRotationPoint(8.0F, 23.0F, 5.0F);
		wings2.addChild(wing1_r1);
		setRotationAngle(wing1_r1, -2.5744F, 0.1309F, 0.6109F);
		wing1_r1.cubeList.add(new ModelBox(wing1_r1, 0, 0, -57.0F, 12.0F, -1.0F, 39, 10, 0, 0.0F));

		wings3 = new ModelRenderer(this);
		wings3.setRotationPoint(0.0F, 8.0F, 4.0F);
		wings2.addChild(wings3);
		setRotationAngle(wings3, 0.0F, 0.2618F, -0.6981F);


		wing2_r1 = new ModelRenderer(this);
		wing2_r1.setRotationPoint(5.9692F, 22.125F, 6.2034F);
		wings3.addChild(wing2_r1);
		setRotationAngle(wing2_r1, -2.5744F, 0.1309F, 0.6109F);
		wing2_r1.cubeList.add(new ModelBox(wing2_r1, 0, 0, -55.0F, 12.0F, -1.0F, 39, 10, 0, 0.0F));

		wings = new ModelRenderer(this);
		wings.setRotationPoint(2.0F, 0.0F, -4.0F);


		wing2_r2 = new ModelRenderer(this);
		wing2_r2.setRotationPoint(-8.0F, 20.0F, 4.0F);
		wings.addChild(wing2_r2);
		setRotationAngle(wing2_r2, -2.5497F, -0.3012F, 0.1411F);
		wing2_r2.cubeList.add(new ModelBox(wing2_r2, 0, 0, 2.0F, 10.0F, -8.0F, 39, 10, 0, 0.0F));

		wing1_r2 = new ModelRenderer(this);
		wing1_r2.setRotationPoint(-8.0F, 20.0F, 4.0F);
		wings.addChild(wing1_r2);
		setRotationAngle(wing1_r2, -2.5744F, -0.1309F, -0.6109F);
		wing1_r2.cubeList.add(new ModelBox(wing1_r2, 0, 0, 18.0F, 12.0F, -2.0F, 39, 10, 0, 0.0F));

		frontLeg = new ModelRenderer(this);
		frontLeg.setRotationPoint(2.0F, -13.0F, -20.0F);
		frontLeg.cubeList.add(new ModelBox(frontLeg, 22, 39, 0.0F, -3.0F, -1.0F, 1, 14, 2, 0.0F));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(1.0F, 8.4421F, -2.5933F);
		frontLeg.addChild(bone9);


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

		fontLeg2 = new ModelRenderer(this);
		fontLeg2.setRotationPoint(-3.0F, -13.0F, -20.0F);
		fontLeg2.cubeList.add(new ModelBox(fontLeg2, 22, 39, 0.0F, -3.0F, -1.0F, 1, 14, 2, 0.0F));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 8.4421F, -1.5933F);
		fontLeg2.addChild(bone11);


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
		mainBody.render(f5);
		legs1.render(f5);
		legs2.render(f5);
		wings2.render(f5);
		wings.render(f5);
		frontLeg.render(f5);
		fontLeg2.render(f5);

    //    f6 = (180F / (float)Math.PI);
        this.wings.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wings2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wings.rotateAngleY = MathHelper.cos(f3 * 1.3F) * (float)Math.PI * 0.25F;
        this.wings2.rotateAngleY = -this.wings.rotateAngleY;
        this.wings.rotateAngleY = this.wings.rotateAngleY * 8.0F;
        this.wings2.rotateAngleY = -this.wings.rotateAngleY * 8.5F;

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
