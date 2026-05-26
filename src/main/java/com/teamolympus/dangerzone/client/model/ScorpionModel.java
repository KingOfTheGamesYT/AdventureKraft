package com.teamolympus.dangerzone.client.model;

import com.teamolympus.dangerzone.misc.DangerZone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

@SuppressWarnings("all")
@SideOnly(Side.CLIENT)
public class ScorpionModel extends ModelBase {
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
		body.cubeList.add(new ModelBox(body, 15, 12, -2.5F, -4.0F, -9.0F, 5, 2, 5, 0.0F));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -4.5F, -4.0F, 6, 3, 7, 0.0F));
		body.cubeList.add(new ModelBox(body, 0, 10, -2.0F, -4.8F, -3.2F, 4, 1, 6, 0.0F));
		body.cubeList.add(new ModelBox(body, 1, 1, -1.5F, -3.5F, -10.0F, 1, 1, 1, 0.0F));
		body.cubeList.add(new ModelBox(body, 1, 1, 0.5F, -3.5F, -10.0F, 1, 1, 1, 0.0F));

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 21.0F, 2.0F);
		

		tail1_r1 = new ModelRenderer(this);
		tail1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail1.addChild(tail1_r1);
		setRotationAngle(tail1_r1, 0.3054F, 0.0F, 0.0F);
		tail1_r1.cubeList.add(new ModelBox(tail1_r1, 0, 17, -2.0F, -1.6375F, 0.1433F, 4, 3, 5, 0.0F));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 20.0F, 6.0F);
		

		tail2_r1 = new ModelRenderer(this);
		tail2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail2.addChild(tail2_r1);
		setRotationAngle(tail2_r1, -1.2217F, 0.0F, 0.0F);
		tail2_r1.cubeList.add(new ModelBox(tail2_r1, 0, 25, -1.5F, -4.8483F, -1.649F, 3, 5, 2, 0.0F));

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 18.0F, 10.0F);
		

		tail3_r1 = new ModelRenderer(this);
		tail3_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
		tail3.addChild(tail3_r1);
		setRotationAngle(tail3_r1, 0.6981F, 0.0F, 0.0F);
		tail3_r1.cubeList.add(new ModelBox(tail3_r1, 18, 19, -1.0F, -8.0F, -2.0F, 2, 8, 2, 0.0F));

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.0F, 13.0F, 4.0F);
		

		tail4_r1 = new ModelRenderer(this);
		tail4_r1.setRotationPoint(0.0F, -1.0F, -2.0F);
		tail4.addChild(tail4_r1);
		setRotationAngle(tail4_r1, -1.0036F, 0.0F, 0.0F);
		tail4_r1.cubeList.add(new ModelBox(tail4_r1, 0, 10, -0.5F, -0.1F, -0.2503F, 1, 2, 1, 0.0F));

		tail4_r2 = new ModelRenderer(this);
		tail4_r2.setRotationPoint(0.0F, -1.0F, 0.0F);
		tail4.addChild(tail4_r2);
		setRotationAngle(tail4_r2, 0.0436F, 0.0F, 0.0F);
		tail4_r2.cubeList.add(new ModelBox(tail4_r2, 19, 0, -1.5F, -1.5009F, -2.0436F, 3, 3, 3, 0.0F));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(2.0F, 22.0F, -8.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 10, 25, 1.0F, -1.5F, -2.5F, 2, 2, 2, 0.0F));

		leftarm_r1 = new ModelRenderer(this);
		leftarm_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
		leftarm.addChild(leftarm_r1);
		setRotationAngle(leftarm_r1, 0.0F, 0.6981F, 0.0F);
		leftarm_r1.cubeList.add(new ModelBox(leftarm_r1, 0, 0, 0.5F, -1.0F, -0.268F, 1, 1, 2, 0.0F));

		leftarm_r2 = new ModelRenderer(this);
		leftarm_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarm_r2);
		setRotationAngle(leftarm_r2, 0.0F, 0.1745F, 0.0F);
		leftarm_r2.cubeList.add(new ModelBox(leftarm_r2, 0, 0, 2.5F, -1.0F, -3.0F, 1, 1, 2, 0.0F));

		leftarm_r3 = new ModelRenderer(this);
		leftarm_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarm_r3);
		setRotationAngle(leftarm_r3, 0.0F, -0.7854F, 0.0F);
		leftarm_r3.cubeList.add(new ModelBox(leftarm_r3, 26, 6, 0.0F, -1.0F, -2.0F, 1, 1, 3, 0.0F));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-2.0F, 21.0F, -8.0F);
		setRotationAngle(rightarm, 0.0F, 0.0F, -3.1416F);
		rightarm.cubeList.add(new ModelBox(rightarm, 10, 25, 1.0F, -1.5F, -2.5F, 2, 2, 2, 0.0F));

		rightarm_r1 = new ModelRenderer(this);
		rightarm_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
		rightarm.addChild(rightarm_r1);
		setRotationAngle(rightarm_r1, 0.0F, 0.6981F, 0.0F);
		rightarm_r1.cubeList.add(new ModelBox(rightarm_r1, 0, 0, 0.5F, -1.0F, -0.268F, 1, 1, 2, 0.0F));

		rightarm_r2 = new ModelRenderer(this);
		rightarm_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarm_r2);
		setRotationAngle(rightarm_r2, 0.0F, 0.1745F, 0.0F);
		rightarm_r2.cubeList.add(new ModelBox(rightarm_r2, 0, 0, 2.5F, -1.0F, -3.0F, 1, 1, 2, 0.0F));

		rightarm_r3 = new ModelRenderer(this);
		rightarm_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarm_r3);
		setRotationAngle(rightarm_r3, 0.0F, -0.7854F, 0.0F);
		rightarm_r3.cubeList.add(new ModelBox(rightarm_r3, 26, 6, 0.0F, -1.0F, -2.0F, 1, 1, 3, 0.0F));

		rightleg1 = new ModelRenderer(this);
		rightleg1.setRotationPoint(-2.0F, 20.0F, -4.0F);
		setRotationAngle(rightleg1, 0.0F, -0.3491F, 0.0F);
		rightleg1.cubeList.add(new ModelBox(rightleg1, 0, 5, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		rightleg1_r1 = new ModelRenderer(this);
		rightleg1_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg1.addChild(rightleg1_r1);
		setRotationAngle(rightleg1_r1, 0.0F, 0.0F, -1.0908F);
		rightleg1_r1.cubeList.add(new ModelBox(rightleg1_r1, 24, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		rightleg1_r2 = new ModelRenderer(this);
		rightleg1_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg1.addChild(rightleg1_r2);
		setRotationAngle(rightleg1_r2, 0.0F, 0.0F, 0.3491F);
		rightleg1_r2.cubeList.add(new ModelBox(rightleg1_r2, 26, 22, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-3.0F, 20.0F, -2.0F);
		rightleg2.cubeList.add(new ModelBox(rightleg2, 0, 5, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		rightleg2_r1 = new ModelRenderer(this);
		rightleg2_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg2.addChild(rightleg2_r1);
		setRotationAngle(rightleg2_r1, 0.0F, 0.0F, -1.0908F);
		rightleg2_r1.cubeList.add(new ModelBox(rightleg2_r1, 24, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		rightleg2_r2 = new ModelRenderer(this);
		rightleg2_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg2.addChild(rightleg2_r2);
		setRotationAngle(rightleg2_r2, 0.0F, 0.0F, 0.3491F);
		rightleg2_r2.cubeList.add(new ModelBox(rightleg2_r2, 26, 22, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		rightleg3 = new ModelRenderer(this);
		rightleg3.setRotationPoint(-3.0F, 20.0F, 1.0F);
		rightleg3.cubeList.add(new ModelBox(rightleg3, 0, 5, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		rightleg3_r1 = new ModelRenderer(this);
		rightleg3_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg3.addChild(rightleg3_r1);
		setRotationAngle(rightleg3_r1, 0.0F, 0.0F, -1.0908F);
		rightleg3_r1.cubeList.add(new ModelBox(rightleg3_r1, 24, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		rightleg3_r2 = new ModelRenderer(this);
		rightleg3_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg3.addChild(rightleg3_r2);
		setRotationAngle(rightleg3_r2, 0.0F, 0.0F, 0.3491F);
		rightleg3_r2.cubeList.add(new ModelBox(rightleg3_r2, 26, 22, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		rightleg4 = new ModelRenderer(this);
		rightleg4.setRotationPoint(-2.0F, 20.0F, 3.0F);
		setRotationAngle(rightleg4, 0.0F, 0.6109F, 0.0F);
		rightleg4.cubeList.add(new ModelBox(rightleg4, 0, 5, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		rightleg4_r1 = new ModelRenderer(this);
		rightleg4_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg4.addChild(rightleg4_r1);
		setRotationAngle(rightleg4_r1, 0.0F, 0.0F, -1.0908F);
		rightleg4_r1.cubeList.add(new ModelBox(rightleg4_r1, 24, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		rightleg4_r2 = new ModelRenderer(this);
		rightleg4_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		rightleg4.addChild(rightleg4_r2);
		setRotationAngle(rightleg4_r2, 0.0F, 0.0F, 0.3491F);
		rightleg4_r2.cubeList.add(new ModelBox(rightleg4_r2, 26, 22, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		leftleg1 = new ModelRenderer(this);
		leftleg1.setRotationPoint(2.0F, 20.0F, -4.0F);
		setRotationAngle(leftleg1, 0.0F, -2.7925F, 0.0F);
		leftleg1.cubeList.add(new ModelBox(leftleg1, 0, 3, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		leftleg1_r1 = new ModelRenderer(this);
		leftleg1_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg1.addChild(leftleg1_r1);
		setRotationAngle(leftleg1_r1, 0.0F, 0.0F, -1.0908F);
		leftleg1_r1.cubeList.add(new ModelBox(leftleg1_r1, 14, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		leftleg1_r2 = new ModelRenderer(this);
		leftleg1_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg1.addChild(leftleg1_r2);
		setRotationAngle(leftleg1_r2, 0.0F, 0.0F, 0.3491F);
		leftleg1_r2.cubeList.add(new ModelBox(leftleg1_r2, 26, 19, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(3.0F, 20.0F, -2.0F);
		setRotationAngle(leftleg2, 0.0F, 3.1416F, 0.0F);
		leftleg2.cubeList.add(new ModelBox(leftleg2, 0, 3, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		leftleg2_r1 = new ModelRenderer(this);
		leftleg2_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg2.addChild(leftleg2_r1);
		setRotationAngle(leftleg2_r1, 0.0F, 0.0F, -1.0908F);
		leftleg2_r1.cubeList.add(new ModelBox(leftleg2_r1, 14, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		leftleg2_r2 = new ModelRenderer(this);
		leftleg2_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg2.addChild(leftleg2_r2);
		setRotationAngle(leftleg2_r2, 0.0F, 0.0F, 0.3491F);
		leftleg2_r2.cubeList.add(new ModelBox(leftleg2_r2, 26, 19, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		leftleg3 = new ModelRenderer(this);
		leftleg3.setRotationPoint(3.0F, 20.0F, 1.0F);
		setRotationAngle(leftleg3, 0.0F, 3.1416F, 0.0F);
		leftleg3.cubeList.add(new ModelBox(leftleg3, 0, 3, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		leftleg3_r1 = new ModelRenderer(this);
		leftleg3_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg3.addChild(leftleg3_r1);
		setRotationAngle(leftleg3_r1, 0.0F, 0.0F, -1.0908F);
		leftleg3_r1.cubeList.add(new ModelBox(leftleg3_r1, 14, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		leftleg3_r2 = new ModelRenderer(this);
		leftleg3_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg3.addChild(leftleg3_r2);
		setRotationAngle(leftleg3_r2, 0.0F, 0.0F, 0.3491F);
		leftleg3_r2.cubeList.add(new ModelBox(leftleg3_r2, 26, 19, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));

		leftleg4 = new ModelRenderer(this);
		leftleg4.setRotationPoint(2.0F, 20.0F, 3.0F);
		setRotationAngle(leftleg4, 0.0F, 2.5307F, 0.0F);
		leftleg4.cubeList.add(new ModelBox(leftleg4, 0, 3, -4.4F, 3.0F, -0.501F, 2, 1, 1, 0.0F));

		leftleg4_r1 = new ModelRenderer(this);
		leftleg4_r1.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg4.addChild(leftleg4_r1);
		setRotationAngle(leftleg4_r1, 0.0F, 0.0F, -1.0908F);
		leftleg4_r1.cubeList.add(new ModelBox(leftleg4_r1, 14, 10, -3.75F, -2.0F, 0.5F, 4, 1, 1, 0.0F));

		leftleg4_r2 = new ModelRenderer(this);
		leftleg4_r2.setRotationPoint(0.0F, 1.0F, -1.0F);
		leftleg4.addChild(leftleg4_r2);
		setRotationAngle(leftleg4_r2, 0.0F, 0.0F, 0.3491F);
		leftleg4_r2.cubeList.add(new ModelBox(leftleg4_r2, 26, 19, -2.0F, -1.0F, 0.0F, 2, 1, 2, 0.0F));
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotateYaw, float rotatePitch, float pixelSize) {
		body.render(pixelSize);
		tail1.render(pixelSize);
		tail2.render(pixelSize);
		tail3.render(pixelSize);
		tail4.render(pixelSize);
		leftarm.render(pixelSize);
		rightarm.render(pixelSize);
		rightleg1.render(pixelSize);
		rightleg2.render(pixelSize);
		rightleg3.render(pixelSize);
		rightleg4.render(pixelSize);
		leftleg1.render(pixelSize);
		leftleg2.render(pixelSize);
		leftleg3.render(pixelSize);
		leftleg4.render(pixelSize);

		float rotateLeg1 = MathHelper.cos(limbSwing * 0.6F) * DangerZone.PI * 0.4F * limbSwingAmount;
		rightleg1.rotateAngleY = rotateLeg1;
		leftleg1.rotateAngleY = rotateLeg1;

		rightleg2.rotateAngleY = rotateLeg1;
		leftleg2.rotateAngleY = rotateLeg1;

		rightleg3.rotateAngleY = rotateLeg1;
		leftleg3.rotateAngleY = rotateLeg1;

		rightleg4.rotateAngleY = rotateLeg1;
		leftleg4.rotateAngleY = rotateLeg1;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}