package com.devmaster.dangerzone.client.render.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Allosaurus;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AllosaurusModel<t> extends EntityModel<Allosaurus> {
	private final ModelRenderer body;
	private final ModelRenderer below_torso_part_r1;
	private final ModelRenderer below_torso_part_r2;
	private final ModelRenderer torso_r1;
	private final ModelRenderer torso_r2;
	private final ModelRenderer tail;
	private final ModelRenderer tail_r1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail_r2;
	private final ModelRenderer tail3;
	private final ModelRenderer tail_r3;
	private final ModelRenderer tail4;
	private final ModelRenderer tail_r4;
	private final ModelRenderer tail5;
	private final ModelRenderer tail_r5;
	private final ModelRenderer tail6;
	private final ModelRenderer tail_r6;
	private final ModelRenderer tail7;
	private final ModelRenderer tail_r7;
	private final ModelRenderer left_arm;
	private final ModelRenderer arm_r1;
	private final ModelRenderer left_armpart2;
	private final ModelRenderer arm_r2;
	private final ModelRenderer arm_r3;
	private final ModelRenderer left_arm_finger;
	private final ModelRenderer finger_r1;
	private final ModelRenderer finger_r2;
	private final ModelRenderer left_arm_finger2;
	private final ModelRenderer finger_r3;
	private final ModelRenderer finger_r4;
	private final ModelRenderer left_arm_finger3;
	private final ModelRenderer finger_r5;
	private final ModelRenderer finger_r6;
	private final ModelRenderer right_arm;
	private final ModelRenderer arm_r4;
	private final ModelRenderer right_armpart3;
	private final ModelRenderer arm_r5;
	private final ModelRenderer arm_r6;
	private final ModelRenderer right_arm_finger4;
	private final ModelRenderer finger_r7;
	private final ModelRenderer finger_r8;
	private final ModelRenderer right_arm_finger5;
	private final ModelRenderer finger_r9;
	private final ModelRenderer finger_r10;
	private final ModelRenderer right_arm_finger6;
	private final ModelRenderer finger_r11;
	private final ModelRenderer finger_r12;
	private final ModelRenderer neck;
	private final ModelRenderer neck_r1;
	private final ModelRenderer neck_r2;
	private final ModelRenderer neck_r3;
	private final ModelRenderer neck_r4;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer head_r5;
	private final ModelRenderer upper_jaw;
	private final ModelRenderer lower_jaw;
	private final ModelRenderer head_r6;
	private final ModelRenderer left_leg;
	private final ModelRenderer bone;
	private final ModelRenderer left_muscle_r1;
	private final ModelRenderer left_muscleconnector_r1;
	private final ModelRenderer left_leg_topmuscle_r1;
	private final ModelRenderer foot3;
	private final ModelRenderer left_foot_r1;
	private final ModelRenderer left_toe;
	private final ModelRenderer left_toeclaw_r1;
	private final ModelRenderer left_toe2_r1;
	private final ModelRenderer left_toe3;
	private final ModelRenderer left_toeclaw_r2;
	private final ModelRenderer left_toe3_r1;
	private final ModelRenderer left_toe7;
	private final ModelRenderer left_toeclaw_r3;
	private final ModelRenderer left_toe4_r1;
	private final ModelRenderer right_leg;
	private final ModelRenderer bone2;
	private final ModelRenderer left_muscle_r2;
	private final ModelRenderer left_muscleconnector_r2;
	private final ModelRenderer left_leg_topmuscle_r2;
	private final ModelRenderer foot2;
	private final ModelRenderer left_foot_r2;
	private final ModelRenderer right_toe;
	private final ModelRenderer left_toeclaw_r4;
	private final ModelRenderer left_toe2_r2;
	private final ModelRenderer right_toe4;
	private final ModelRenderer left_toeclaw_r5;
	private final ModelRenderer left_toe3_r2;
	private final ModelRenderer right_toe5;
	private final ModelRenderer left_toeclaw_r6;
	private final ModelRenderer left_toe4_r2;

	public AllosaurusModel(float v) {
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -8.0F, 0.0F);
		

		below_torso_part_r1 = new ModelRenderer(this);
		below_torso_part_r1.setRotationPoint(0.0F, 32.2F, 0.0F);
		body.addChild(below_torso_part_r1);
		setRotationAngle(below_torso_part_r1, 0.2182F, 0.0F, 0.0F);
		below_torso_part_r1.setTextureOffset(114, 0).addBox(-2.5F, -24.2F, 2.3F, 5.0F, 4.0F, 8.0F, 0.0F, false);

		below_torso_part_r2 = new ModelRenderer(this);
		below_torso_part_r2.setRotationPoint(0.0F, 32.2F, 0.0F);
		body.addChild(below_torso_part_r2);
		setRotationAngle(below_torso_part_r2, -0.4363F, 0.0F, 0.0F);
		below_torso_part_r2.setTextureOffset(94, 0).addBox(-2.0F, -20.5F, -21.6F, 4.0F, 4.0F, 12.0F, 0.0F, false);

		torso_r1 = new ModelRenderer(this);
		torso_r1.setRotationPoint(0.0F, 32.0F, 0.0F);
		body.addChild(torso_r1);
		setRotationAngle(torso_r1, -0.1309F, 0.0F, 0.0F);
		torso_r1.setTextureOffset(49, 0).addBox(-7.0F, -37.5F, -12.6F, 14.0F, 2.0F, 17.0F, 0.01F, false);
		torso_r1.setTextureOffset(0, 0).addBox(-7.0F, -36.4F, -16.7F, 14.0F, 13.0F, 21.0F, 0.0F, false);

		torso_r2 = new ModelRenderer(this);
		torso_r2.setRotationPoint(-0.1F, 32.0F, 0.0F);
		body.addChild(torso_r2);
		setRotationAngle(torso_r2, 0.1309F, 0.0F, 0.0F);
		torso_r2.setTextureOffset(0, 34).addBox(-7.4F, -39.5F, -18.4F, 15.0F, 16.0F, 16.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 1.0F, 7.4F);
		body.addChild(tail);
		

		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, 31.0F, -7.4F);
		tail.addChild(tail_r1);
		setRotationAngle(tail_r1, -0.0436F, 0.0F, 0.0F);
		tail_r1.setTextureOffset(0, 66).addBox(-5.0F, -36.4F, 4.3F, 10.0F, 12.0F, 13.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 1.8F, 11.7F);
		tail.addChild(tail2);
		setRotationAngle(tail2, 0.0436F, 0.0F, 0.0F);
		

		tail_r2 = new ModelRenderer(this);
		tail_r2.setRotationPoint(0.0F, 29.2154F, -7.1651F);
		tail2.addChild(tail_r2);
		setRotationAngle(tail_r2, -0.0436F, 0.0F, 0.0F);
		tail_r2.setTextureOffset(72, 97).addBox(-4.0F, -35.7F, 4.3F, 8.0F, 11.0F, 10.0F, 0.0F, false);

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.5F, 0.7F, 7.8F);
		tail2.addChild(tail3);
		setRotationAngle(tail3, -0.0436F, 0.0F, 0.0F);
		

		tail_r3 = new ModelRenderer(this);
		tail_r3.setRotationPoint(0.0F, 29.2154F, -7.1651F);
		tail3.addChild(tail_r3);
		setRotationAngle(tail_r3, -0.0436F, 0.0F, 0.0F);
		tail_r3.setTextureOffset(108, 97).addBox(-4.0F, -35.7F, 5.3F, 7.0F, 10.0F, 8.0F, 0.0F, false);

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.6F, 1.0F, 8.2F);
		tail3.addChild(tail4);
		setRotationAngle(tail4, 0.0436F, 0.0F, 0.0F);
		

		tail_r4 = new ModelRenderer(this);
		tail_r4.setRotationPoint(-0.1F, 29.1369F, -8.9633F);
		tail4.addChild(tail_r4);
		setRotationAngle(tail_r4, -0.0436F, 0.0F, 0.0F);
		tail_r4.setTextureOffset(0, 115).addBox(-4.0F, -35.7F, 5.3F, 6.0F, 8.0F, 9.0F, 0.0F, false);

		tail5 = new ModelRenderer(this);
		tail5.setRotationPoint(0.0F, -0.9785F, 8.8017F);
		tail4.addChild(tail5);
		setRotationAngle(tail5, -0.0436F, 0.0F, 0.0F);
		

		tail_r5 = new ModelRenderer(this);
		tail_r5.setRotationPoint(-0.1F, 30.1199F, -9.2861F);
		tail5.addChild(tail_r5);
		setRotationAngle(tail_r5, -0.0436F, 0.0F, 0.0F);
		tail_r5.setTextureOffset(120, 81).addBox(-3.0F, -34.7F, 5.3F, 4.0F, 6.0F, 9.0F, 0.0F, false);

		tail6 = new ModelRenderer(this);
		tail6.setRotationPoint(-0.5F, 0.7F, 8.5F);
		tail5.addChild(tail6);
		setRotationAngle(tail6, -0.0436F, 0.0F, 0.0F);
		

		tail_r6 = new ModelRenderer(this);
		tail_r6.setRotationPoint(-0.1F, 30.1199F, -9.2861F);
		tail6.addChild(tail_r6);
		setRotationAngle(tail_r6, -0.0436F, 0.0F, 0.0F);
		tail_r6.setTextureOffset(122, 120).addBox(-2.0F, -34.7F, 5.3F, 3.0F, 5.0F, 9.0F, 0.0F, false);

		tail7 = new ModelRenderer(this);
		tail7.setRotationPoint(0.4F, 0.8F, 5.4F);
		tail6.addChild(tail7);
		setRotationAngle(tail7, -0.3054F, 0.0F, 0.0F);
		

		tail_r7 = new ModelRenderer(this);
		tail_r7.setRotationPoint(0.0F, 30.1199F, -9.2861F);
		tail7.addChild(tail_r7);
		setRotationAngle(tail_r7, -0.0436F, 0.0F, 0.0F);
		tail_r7.setTextureOffset(18, 132).addBox(-2.0F, -34.7F, 6.3F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(-7.0F, 4.7F, -14.0F);
		body.addChild(left_arm);
		

		arm_r1 = new ModelRenderer(this);
		arm_r1.setRotationPoint(7.0F, -2.3F, 0.7F);
		left_arm.addChild(arm_r1);
		setRotationAngle(arm_r1, 0.8727F, 0.0F, 0.0F);
		arm_r1.setTextureOffset(65, 134).addBox(-9.4F, -4.0686F, -6.2857F, 4.0F, 10.0F, 5.0F, 0.0F, false);

		left_armpart2 = new ModelRenderer(this);
		left_armpart2.setRotationPoint(-0.7F, 4.8F, 1.4F);
		left_arm.addChild(left_armpart2);
		

		arm_r2 = new ModelRenderer(this);
		arm_r2.setRotationPoint(7.7F, -7.1F, -0.7F);
		left_armpart2.addChild(arm_r2);
		setRotationAngle(arm_r2, 0.0436F, 0.0F, 0.0F);
		arm_r2.setTextureOffset(57, 10).addBox(-8.4F, 6.3314F, -2.5857F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm_r2.setTextureOffset(80, 46).addBox(-9.0F, 4.6314F, -1.4857F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		arm_r3 = new ModelRenderer(this);
		arm_r3.setRotationPoint(7.7F, -7.1F, -0.7F);
		left_armpart2.addChild(arm_r3);
		setRotationAngle(arm_r3, -0.1309F, 0.0F, 0.0F);
		arm_r3.setTextureOffset(49, 0).addBox(-8.7F, 9.6314F, -0.9857F, 3.0F, 5.0F, 5.0F, 0.0F, false);

		left_arm_finger = new ModelRenderer(this);
		left_arm_finger.setRotationPoint(1.1F, 7.9F, -2.4F);
		left_armpart2.addChild(left_arm_finger);
		setRotationAngle(left_arm_finger, -0.1886F, -0.3864F, 0.0718F);
		

		finger_r1 = new ModelRenderer(this);
		finger_r1.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger.addChild(finger_r1);
		setRotationAngle(finger_r1, -0.2835F, -0.1153F, -0.3762F);
		finger_r1.setTextureOffset(13, 34).addBox(-8.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r2 = new ModelRenderer(this);
		finger_r2.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger.addChild(finger_r2);
		setRotationAngle(finger_r2, -0.2986F, -0.0651F, -0.2084F);
		finger_r2.setTextureOffset(35, 91).addBox(-8.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		left_arm_finger2 = new ModelRenderer(this);
		left_arm_finger2.setRotationPoint(0.3F, 7.9F, -0.9F);
		left_armpart2.addChild(left_arm_finger2);
		setRotationAngle(left_arm_finger2, 0.1436F, -0.2305F, 0.0024F);
		

		finger_r3 = new ModelRenderer(this);
		finger_r3.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger2.addChild(finger_r3);
		setRotationAngle(finger_r3, -0.2835F, -0.1153F, -0.3762F);
		finger_r3.setTextureOffset(11, 34).addBox(-8.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r4 = new ModelRenderer(this);
		finger_r4.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger2.addChild(finger_r4);
		setRotationAngle(finger_r4, -0.2986F, -0.0651F, -0.2084F);
		finger_r4.setTextureOffset(27, 91).addBox(-8.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		left_arm_finger3 = new ModelRenderer(this);
		left_arm_finger3.setRotationPoint(0.9F, 7.9F, -0.5F);
		left_armpart2.addChild(left_arm_finger3);
		setRotationAngle(left_arm_finger3, 0.8649F, 0.3304F, -0.4721F);
		

		finger_r5 = new ModelRenderer(this);
		finger_r5.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger3.addChild(finger_r5);
		setRotationAngle(finger_r5, -0.2835F, -0.1153F, -0.3762F);
		finger_r5.setTextureOffset(2, 34).addBox(-8.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r6 = new ModelRenderer(this);
		finger_r6.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger3.addChild(finger_r6);
		setRotationAngle(finger_r6, -0.2986F, -0.0651F, -0.2084F);
		finger_r6.setTextureOffset(84, 75).addBox(-8.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(7.0F, 4.7F, -14.0F);
		body.addChild(right_arm);
		

		arm_r4 = new ModelRenderer(this);
		arm_r4.setRotationPoint(-7.0F, -2.3F, 0.7F);
		right_arm.addChild(arm_r4);
		setRotationAngle(arm_r4, 0.8727F, 0.0F, 0.0F);
		arm_r4.setTextureOffset(0, 132).addBox(5.4F, -4.0686F, -6.2857F, 4.0F, 10.0F, 5.0F, 0.0F, false);

		right_armpart3 = new ModelRenderer(this);
		right_armpart3.setRotationPoint(0.7F, 4.8F, 1.4F);
		right_arm.addChild(right_armpart3);
		

		arm_r5 = new ModelRenderer(this);
		arm_r5.setRotationPoint(-7.7F, -7.1F, -0.7F);
		right_armpart3.addChild(arm_r5);
		setRotationAngle(arm_r5, 0.0436F, 0.0F, 0.0F);
		arm_r5.setTextureOffset(49, 10).addBox(6.4F, 6.3314F, -2.5857F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm_r5.setTextureOffset(0, 66).addBox(6.0F, 4.6314F, -1.4857F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		arm_r6 = new ModelRenderer(this);
		arm_r6.setRotationPoint(-7.7F, -7.1F, -0.7F);
		right_armpart3.addChild(arm_r6);
		setRotationAngle(arm_r6, -0.1309F, 0.0F, 0.0F);
		arm_r6.setTextureOffset(49, 0).addBox(5.7F, 9.6314F, -0.9857F, 3.0F, 5.0F, 5.0F, 0.0F, true);

		right_arm_finger4 = new ModelRenderer(this);
		right_arm_finger4.setRotationPoint(-1.1F, 7.9F, -2.4F);
		right_armpart3.addChild(right_arm_finger4);
		setRotationAngle(right_arm_finger4, -0.1886F, 0.3864F, -0.0718F);
		

		finger_r7 = new ModelRenderer(this);
		finger_r7.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger4.addChild(finger_r7);
		setRotationAngle(finger_r7, -0.2835F, 0.1153F, 0.3762F);
		finger_r7.setTextureOffset(0, 34).addBox(7.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r8 = new ModelRenderer(this);
		finger_r8.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger4.addChild(finger_r8);
		setRotationAngle(finger_r8, -0.2986F, 0.0651F, 0.2084F);
		finger_r8.setTextureOffset(8, 44).addBox(6.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		right_arm_finger5 = new ModelRenderer(this);
		right_arm_finger5.setRotationPoint(-0.3F, 7.9F, -0.9F);
		right_armpart3.addChild(right_arm_finger5);
		setRotationAngle(right_arm_finger5, 0.1436F, 0.2305F, -0.0024F);
		

		finger_r9 = new ModelRenderer(this);
		finger_r9.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger5.addChild(finger_r9);
		setRotationAngle(finger_r9, -0.2835F, 0.1153F, 0.3762F);
		finger_r9.setTextureOffset(18, 16).addBox(7.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r10 = new ModelRenderer(this);
		finger_r10.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger5.addChild(finger_r10);
		setRotationAngle(finger_r10, -0.2986F, 0.0651F, 0.2084F);
		finger_r10.setTextureOffset(0, 44).addBox(6.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		right_arm_finger6 = new ModelRenderer(this);
		right_arm_finger6.setRotationPoint(-0.9F, 7.9F, -0.5F);
		right_armpart3.addChild(right_arm_finger6);
		setRotationAngle(right_arm_finger6, 0.8649F, -0.3304F, 0.4721F);
		

		finger_r11 = new ModelRenderer(this);
		finger_r11.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger6.addChild(finger_r11);
		setRotationAngle(finger_r11, -0.2835F, 0.1153F, 0.3762F);
		finger_r11.setTextureOffset(8, 18).addBox(7.6F, -0.6533F, -1.1878F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		finger_r12 = new ModelRenderer(this);
		finger_r12.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger6.addChild(finger_r12);
		setRotationAngle(finger_r12, -0.2986F, 0.0651F, 0.2084F);
		finger_r12.setTextureOffset(10, 14).addBox(6.6F, -2.9533F, -2.1878F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 3.0F, -22.9F);
		body.addChild(neck);
		setRotationAngle(neck, 0.3927F, 0.0F, 0.0F);
		

		neck_r1 = new ModelRenderer(this);
		neck_r1.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r1);
		setRotationAngle(neck_r1, 1.8762F, 0.0F, 0.0F);
		neck_r1.setTextureOffset(82, 129).addBox(-3.4F, -18.1F, 48.6F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		neck_r2 = new ModelRenderer(this);
		neck_r2.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r2);
		setRotationAngle(neck_r2, -1.1345F, 0.0F, 0.0F);
		neck_r2.setTextureOffset(107, 37).addBox(-3.4F, 6.1F, -51.5F, 7.0F, 10.0F, 8.0F, 0.01F, false);

		neck_r3 = new ModelRenderer(this);
		neck_r3.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r3);
		setRotationAngle(neck_r3, -0.6545F, 0.0F, 0.0F);
		neck_r3.setTextureOffset(110, 64).addBox(-4.4F, -16.5F, -46.9F, 9.0F, 11.0F, 6.0F, 0.0F, false);

		neck_r4 = new ModelRenderer(this);
		neck_r4.setRotationPoint(-0.1F, 31.0F, 22.9F);
		neck.addChild(neck_r4);
		setRotationAngle(neck_r4, -0.4363F, 0.0F, 0.0F);
		neck_r4.setTextureOffset(82, 75).addBox(-4.4F, -25.6F, -39.7F, 9.0F, 12.0F, 10.0F, 0.1F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -8.1F, -9.7F);
		neck.addChild(head);
		setRotationAngle(head, -0.3491F, 0.0F, 0.0F);
		

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.3F, -2.9794F, -6.484F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 1.8316F, -0.0094F, 0.218F);
		head_r1.setTextureOffset(33, 66).addBox(2.2F, -3.8502F, 4.5235F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.3F, -2.9794F, -6.484F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 1.6551F, -0.0206F, 0.3484F);
		head_r2.setTextureOffset(46, 42).addBox(1.4F, -1.4502F, 5.2235F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(-0.1F, -2.9794F, -6.484F);
		head.addChild(head_r3);
		setRotationAngle(head_r3, 1.6144F, 0.0F, 0.0F);
		head_r3.setTextureOffset(87, 140).addBox(-2.4F, -12.8502F, 4.9235F, 5.0F, 16.0F, 1.0F, 0.0F, false);
		head_r3.setTextureOffset(30, 124).addBox(-4.4F, -12.8502F, -6.0765F, 9.0F, 13.0F, 2.0F, 0.0F, false);
		head_r3.setTextureOffset(46, 75).addBox(-4.4F, -12.8502F, -4.0765F, 9.0F, 21.0F, 9.0F, 0.0F, false);

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(-0.3F, -2.9794F, -6.484F);
		head.addChild(head_r4);
		setRotationAngle(head_r4, 1.6551F, 0.0206F, -0.3484F);
		head_r4.setTextureOffset(0, 91).addBox(-2.4F, -1.4502F, 5.2235F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		head_r5 = new ModelRenderer(this);
		head_r5.setRotationPoint(-0.3F, -2.9794F, -6.484F);
		head.addChild(head_r5);
		setRotationAngle(head_r5, 1.8316F, 0.0094F, -0.218F);
		head_r5.setTextureOffset(49, 75).addBox(-3.2F, -3.8502F, 4.5235F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		upper_jaw = new ModelRenderer(this);
		upper_jaw.setRotationPoint(0.5F, -2.1794F, -8.884F);
		head.addChild(upper_jaw);
		

		lower_jaw = new ModelRenderer(this);
		lower_jaw.setRotationPoint(0.4F, 1.7206F, -0.184F);
		head.addChild(lower_jaw);
		setRotationAngle(lower_jaw, 1.0472F, 0.0F, 0.0F);
		

		head_r6 = new ModelRenderer(this);
		head_r6.setRotationPoint(-1.0F, -4.7F, -6.3F);
		lower_jaw.addChild(head_r6);
		setRotationAngle(head_r6, 1.6144F, 0.0F, 0.0F);
		head_r6.setTextureOffset(0, 0).addBox(-3.4F, -11.8502F, -4.0765F, 8.0F, 12.0F, 2.0F, 0.01F, false);
		head_r6.setTextureOffset(59, 118).addBox(-3.4F, -2.8502F, -10.0765F, 8.0F, 10.0F, 6.0F, 0.01F, false);
		head_r6.setTextureOffset(0, 14).addBox(-1.4F, -3.8502F, -4.0765F, 4.0F, 3.0F, 1.0F, 0.01F, false);
		head_r6.setTextureOffset(88, 19).addBox(-1.4F, -0.8502F, -4.0765F, 4.0F, 6.0F, 2.0F, 0.01F, false);
		head_r6.setTextureOffset(129, 30).addBox(-3.4F, -11.8502F, -8.0765F, 8.0F, 9.0F, 4.0F, 0.01F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(8.7F, -3.1F, -0.2F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-4.6041F, 16.1F, -1.3127F);
		left_leg.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.6545F, 0.0F);
		

		left_muscle_r1 = new ModelRenderer(this);
		left_muscle_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(left_muscle_r1);
		setRotationAngle(left_muscle_r1, 1.7453F, -0.6545F, 0.0F);
		left_muscle_r1.setTextureOffset(80, 46).addBox(-1.3428F, 1.0471F, -7.0249F, 7.0F, 5.0F, 13.0F, 0.0F, false);

		left_muscleconnector_r1 = new ModelRenderer(this);
		left_muscleconnector_r1.setRotationPoint(1.3F, -10.2F, 0.0F);
		bone.addChild(left_muscleconnector_r1);
		setRotationAngle(left_muscleconnector_r1, 2.3998F, -0.6545F, 0.0F);
		left_muscleconnector_r1.setTextureOffset(0, 91).addBox(-2.0741F, -5.9925F, -9.8194F, 8.0F, 8.0F, 11.0F, 0.0F, false);

		left_leg_topmuscle_r1 = new ModelRenderer(this);
		left_leg_topmuscle_r1.setRotationPoint(-5.6F, 11.0F, 0.0F);
		bone.addChild(left_leg_topmuscle_r1);
		setRotationAngle(left_leg_topmuscle_r1, 1.3526F, -0.6981F, 0.0F);
		left_leg_topmuscle_r1.setTextureOffset(44, 48).addBox(3.0F, -14.9F, 14.2F, 9.0F, 9.0F, 18.0F, 0.0F, false);

		foot3 = new ModelRenderer(this);
		foot3.setRotationPoint(0.5083F, 5.2F, 3.2448F);
		bone.addChild(foot3);
		

		left_foot_r1 = new ModelRenderer(this);
		left_foot_r1.setRotationPoint(-6.1083F, 5.8F, -3.2448F);
		foot3.addChild(left_foot_r1);
		setRotationAngle(left_foot_r1, 0.9163F, -0.6545F, 0.0F);
		left_foot_r1.setTextureOffset(115, 16).addBox(3.2F, -6.8F, -1.4F, 7.0F, 5.0F, 9.0F, 0.0F, false);

		left_toe = new ModelRenderer(this);
		left_toe.setRotationPoint(2.4F, 4.2F, -2.0F);
		foot3.addChild(left_toe);
		setRotationAngle(left_toe, 0.0F, -0.1745F, 0.0F);
		

		left_toeclaw_r1 = new ModelRenderer(this);
		left_toeclaw_r1.setRotationPoint(-8.5083F, 1.6F, -1.2448F);
		left_toe.addChild(left_toeclaw_r1);
		setRotationAngle(left_toeclaw_r1, 0.0F, -0.6545F, 0.0F);
		left_toeclaw_r1.setTextureOffset(2, 18).addBox(9.0F, -2.0F, -12.7F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		left_toeclaw_r1.setTextureOffset(4, 16).addBox(9.0F, -1.0F, -13.7F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		left_toeclaw_r1.setTextureOffset(131, 3).addBox(8.0F, -2.0F, -11.7F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		left_toe2_r1 = new ModelRenderer(this);
		left_toe2_r1.setRotationPoint(-8.5083F, 1.6F, -1.2448F);
		left_toe.addChild(left_toe2_r1);
		setRotationAngle(left_toe2_r1, 0.5265F, -0.7539F, -0.0718F);
		left_toe2_r1.setTextureOffset(43, 130).addBox(7.0F, -6.3F, -9.3F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		left_toe3 = new ModelRenderer(this);
		left_toe3.setRotationPoint(-1.0F, 2.9F, -4.7F);
		foot3.addChild(left_toe3);
		

		left_toeclaw_r2 = new ModelRenderer(this);
		left_toeclaw_r2.setRotationPoint(-6.1083F, 2.9F, 1.4552F);
		left_toe3.addChild(left_toeclaw_r2);
		setRotationAngle(left_toeclaw_r2, 0.0F, -0.2618F, 0.0F);
		left_toeclaw_r2.setTextureOffset(18, 0).addBox(6.2F, -2.0F, -10.6F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		left_toeclaw_r2.setTextureOffset(0, 16).addBox(6.2F, -1.0F, -11.6F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		left_toeclaw_r2.setTextureOffset(129, 106).addBox(5.2F, -2.0F, -9.6F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		left_toe3_r1 = new ModelRenderer(this);
		left_toe3_r1.setRotationPoint(-6.1083F, 2.9F, 1.4552F);
		left_toe3.addChild(left_toe3_r1);
		setRotationAngle(left_toe3_r1, 0.4669F, -0.1761F, 0.0624F);
		left_toe3_r1.setTextureOffset(33, 68).addBox(5.7F, -5.4F, -5.7F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		left_toe7 = new ModelRenderer(this);
		left_toe7.setRotationPoint(3.1F, 3.4F, -3.4F);
		foot3.addChild(left_toe7);
		setRotationAngle(left_toe7, 0.0F, -0.2182F, 0.0F);
		

		left_toeclaw_r3 = new ModelRenderer(this);
		left_toeclaw_r3.setRotationPoint(-9.2083F, 2.4F, 0.1552F);
		left_toe7.addChild(left_toeclaw_r3);
		setRotationAngle(left_toeclaw_r3, 0.0F, -0.4363F, 0.0F);
		left_toeclaw_r3.setTextureOffset(0, 0).addBox(7.8F, -1.0F, -12.2F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		left_toeclaw_r3.setTextureOffset(10, 13).addBox(7.8F, -2.0F, -11.2F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		left_toeclaw_r3.setTextureOffset(106, 129).addBox(6.8F, -2.0F, -10.2F, 2.0F, 2.0F, 9.0F, 0.01F, false);

		left_toe4_r1 = new ModelRenderer(this);
		left_toe4_r1.setRotationPoint(-9.2083F, 2.4F, 0.1552F);
		left_toe7.addChild(left_toe4_r1);
		setRotationAngle(left_toe4_r1, 0.5236F, -0.4363F, 0.0F);
		left_toe4_r1.setTextureOffset(128, 46).addBox(6.8F, -5.8F, -7.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-8.7F, -3.1F, -0.2F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(4.6041F, 16.1F, -1.3127F);
		right_leg.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -0.6545F, 0.0F);
		

		left_muscle_r2 = new ModelRenderer(this);
		left_muscle_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(left_muscle_r2);
		setRotationAngle(left_muscle_r2, 1.7453F, 0.6545F, 0.0F);
		left_muscle_r2.setTextureOffset(80, 46).addBox(-5.6572F, 1.0471F, -7.0249F, 7.0F, 5.0F, 13.0F, 0.0F, true);

		left_muscleconnector_r2 = new ModelRenderer(this);
		left_muscleconnector_r2.setRotationPoint(-1.3F, -10.2F, 0.0F);
		bone2.addChild(left_muscleconnector_r2);
		setRotationAngle(left_muscleconnector_r2, 2.3998F, 0.6545F, 0.0F);
		left_muscleconnector_r2.setTextureOffset(0, 91).addBox(-5.9259F, -5.9925F, -9.8194F, 8.0F, 8.0F, 11.0F, 0.0F, true);

		left_leg_topmuscle_r2 = new ModelRenderer(this);
		left_leg_topmuscle_r2.setRotationPoint(5.6F, 11.0F, 0.0F);
		bone2.addChild(left_leg_topmuscle_r2);
		setRotationAngle(left_leg_topmuscle_r2, 1.3526F, 0.6981F, 0.0F);
		left_leg_topmuscle_r2.setTextureOffset(44, 48).addBox(-12.0F, -14.9F, 14.2F, 9.0F, 9.0F, 18.0F, 0.0F, true);

		foot2 = new ModelRenderer(this);
		foot2.setRotationPoint(-0.5083F, 5.2F, 3.2448F);
		bone2.addChild(foot2);
		

		left_foot_r2 = new ModelRenderer(this);
		left_foot_r2.setRotationPoint(6.1083F, 5.8F, -3.2448F);
		foot2.addChild(left_foot_r2);
		setRotationAngle(left_foot_r2, 0.9163F, 0.6545F, 0.0F);
		left_foot_r2.setTextureOffset(115, 16).addBox(-10.2F, -6.8F, -1.4F, 7.0F, 5.0F, 9.0F, 0.0F, true);

		right_toe = new ModelRenderer(this);
		right_toe.setRotationPoint(-2.4F, 4.2F, -2.0F);
		foot2.addChild(right_toe);
		setRotationAngle(right_toe, 0.0F, 0.1745F, 0.0F);
		

		left_toeclaw_r4 = new ModelRenderer(this);
		left_toeclaw_r4.setRotationPoint(8.5083F, 1.6F, -1.2448F);
		right_toe.addChild(left_toeclaw_r4);
		setRotationAngle(left_toeclaw_r4, 0.0F, 0.6545F, 0.0F);
		left_toeclaw_r4.setTextureOffset(2, 18).addBox(-9.0F, -2.0F, -12.7F, 0.0F, 1.0F, 1.0F, 0.0F, true);
		left_toeclaw_r4.setTextureOffset(4, 16).addBox(-9.0F, -1.0F, -13.7F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		left_toeclaw_r4.setTextureOffset(131, 3).addBox(-10.0F, -2.0F, -11.7F, 2.0F, 2.0F, 9.0F, 0.0F, true);

		left_toe2_r2 = new ModelRenderer(this);
		left_toe2_r2.setRotationPoint(8.5083F, 1.6F, -1.2448F);
		right_toe.addChild(left_toe2_r2);
		setRotationAngle(left_toe2_r2, 0.5265F, 0.7539F, 0.0718F);
		left_toe2_r2.setTextureOffset(43, 130).addBox(-9.0F, -6.3F, -9.3F, 2.0F, 2.0F, 9.0F, 0.0F, true);

		right_toe4 = new ModelRenderer(this);
		right_toe4.setRotationPoint(1.0F, 2.9F, -4.7F);
		foot2.addChild(right_toe4);
		

		left_toeclaw_r5 = new ModelRenderer(this);
		left_toeclaw_r5.setRotationPoint(6.1083F, 2.9F, 1.4552F);
		right_toe4.addChild(left_toeclaw_r5);
		setRotationAngle(left_toeclaw_r5, 0.0F, 0.2618F, 0.0F);
		left_toeclaw_r5.setTextureOffset(18, 0).addBox(-6.2F, -2.0F, -10.6F, 0.0F, 1.0F, 1.0F, 0.0F, true);
		left_toeclaw_r5.setTextureOffset(0, 16).addBox(-6.2F, -1.0F, -11.6F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		left_toeclaw_r5.setTextureOffset(129, 106).addBox(-7.2F, -2.0F, -9.6F, 2.0F, 2.0F, 9.0F, 0.0F, true);

		left_toe3_r2 = new ModelRenderer(this);
		left_toe3_r2.setRotationPoint(6.1083F, 2.9F, 1.4552F);
		right_toe4.addChild(left_toe3_r2);
		setRotationAngle(left_toe3_r2, 0.4669F, 0.1761F, -0.0624F);
		left_toe3_r2.setTextureOffset(33, 68).addBox(-7.7F, -5.4F, -5.7F, 2.0F, 2.0F, 7.0F, 0.0F, true);

		right_toe5 = new ModelRenderer(this);
		right_toe5.setRotationPoint(-3.1F, 3.4F, -3.4F);
		foot2.addChild(right_toe5);
		setRotationAngle(right_toe5, 0.0F, 0.2182F, 0.0F);
		

		left_toeclaw_r6 = new ModelRenderer(this);
		left_toeclaw_r6.setRotationPoint(9.2083F, 2.4F, 0.1552F);
		right_toe5.addChild(left_toeclaw_r6);
		setRotationAngle(left_toeclaw_r6, 0.0F, 0.4363F, 0.0F);
		left_toeclaw_r6.setTextureOffset(0, 0).addBox(-7.8F, -1.0F, -12.2F, 0.0F, 1.0F, 1.0F, 0.0F, true);
		left_toeclaw_r6.setTextureOffset(10, 13).addBox(-7.8F, -2.0F, -11.2F, 0.0F, 2.0F, 1.0F, 0.0F, true);
		left_toeclaw_r6.setTextureOffset(106, 129).addBox(-8.8F, -2.0F, -10.2F, 2.0F, 2.0F, 9.0F, 0.01F, true);

		left_toe4_r2 = new ModelRenderer(this);
		left_toe4_r2.setRotationPoint(9.2083F, 2.4F, 0.1552F);
		right_toe5.addChild(left_toe4_r2);
		setRotationAngle(left_toe4_r2, 0.5236F, 0.4363F, 0.0F);
		left_toe4_r2.setTextureOffset(128, 46).addBox(-8.8F, -5.8F, -7.0F, 2.0F, 2.0F, 9.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(Allosaurus entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.lower_jaw.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}