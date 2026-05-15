package com.teamolympus.dangerzone.client.model;// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
@SuppressWarnings("all")
public class AllosaurusModel extends ModelBase {
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

	public AllosaurusModel() {
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -8.0F, 0.0F);


		below_torso_part_r1 = new ModelRenderer(this);
		below_torso_part_r1.setRotationPoint(0.0F, 32.2F, 0.0F);
		body.addChild(below_torso_part_r1);
		setRotationAngle(below_torso_part_r1, 0.2182F, 0.0F, 0.0F);
		below_torso_part_r1.cubeList.add(new ModelBox(below_torso_part_r1, 114, 0, -2.5F, -24.2F, 2.3F, 5, 4, 8, 0.0F));

		below_torso_part_r2 = new ModelRenderer(this);
		below_torso_part_r2.setRotationPoint(0.0F, 32.2F, 0.0F);
		body.addChild(below_torso_part_r2);
		setRotationAngle(below_torso_part_r2, -0.4363F, 0.0F, 0.0F);
		below_torso_part_r2.cubeList.add(new ModelBox(below_torso_part_r2, 94, 0, -2.0F, -20.5F, -21.6F, 4, 4, 12, 0.0F));

		torso_r1 = new ModelRenderer(this);
		torso_r1.setRotationPoint(0.0F, 32.0F, 0.0F);
		body.addChild(torso_r1);
		setRotationAngle(torso_r1, -0.1309F, 0.0F, 0.0F);
		torso_r1.cubeList.add(new ModelBox(torso_r1, 49, 0, -7.0F, -37.5F, -12.6F, 14, 2, 17, 0.01F));
		torso_r1.cubeList.add(new ModelBox(torso_r1, 0, 0, -7.0F, -36.4F, -16.7F, 14, 13, 21, 0.0F));

		torso_r2 = new ModelRenderer(this);
		torso_r2.setRotationPoint(-0.1F, 32.0F, 0.0F);
		body.addChild(torso_r2);
		setRotationAngle(torso_r2, 0.1309F, 0.0F, 0.0F);
		torso_r2.cubeList.add(new ModelBox(torso_r2, 0, 34, -7.4F, -39.5F, -18.4F, 15, 16, 16, 0.0F));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 1.0F, 7.4F);
		body.addChild(tail);


		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, 31.0F, -7.4F);
		tail.addChild(tail_r1);
		setRotationAngle(tail_r1, -0.0436F, 0.0F, 0.0F);
		tail_r1.cubeList.add(new ModelBox(tail_r1, 0, 66, -5.0F, -36.4F, 4.3F, 10, 12, 13, 0.0F));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 1.8F, 11.7F);
		tail.addChild(tail2);
		setRotationAngle(tail2, 0.0436F, 0.0F, 0.0F);


		tail_r2 = new ModelRenderer(this);
		tail_r2.setRotationPoint(0.0F, 29.2154F, -7.1651F);
		tail2.addChild(tail_r2);
		setRotationAngle(tail_r2, -0.0436F, 0.0F, 0.0F);
		tail_r2.cubeList.add(new ModelBox(tail_r2, 72, 97, -4.0F, -35.7F, 4.3F, 8, 11, 10, 0.0F));

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.5F, 0.7F, 7.8F);
		tail2.addChild(tail3);
		setRotationAngle(tail3, -0.0436F, 0.0F, 0.0F);


		tail_r3 = new ModelRenderer(this);
		tail_r3.setRotationPoint(0.0F, 29.2154F, -7.1651F);
		tail3.addChild(tail_r3);
		setRotationAngle(tail_r3, -0.0436F, 0.0F, 0.0F);
		tail_r3.cubeList.add(new ModelBox(tail_r3, 108, 97, -4.0F, -35.7F, 5.3F, 7, 10, 8, 0.0F));

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.6F, 1.0F, 8.2F);
		tail3.addChild(tail4);
		setRotationAngle(tail4, 0.0436F, 0.0F, 0.0F);


		tail_r4 = new ModelRenderer(this);
		tail_r4.setRotationPoint(-0.1F, 29.1369F, -8.9633F);
		tail4.addChild(tail_r4);
		setRotationAngle(tail_r4, -0.0436F, 0.0F, 0.0F);
		tail_r4.cubeList.add(new ModelBox(tail_r4, 0, 115, -4.0F, -35.7F, 5.3F, 6, 8, 9, 0.0F));

		tail5 = new ModelRenderer(this);
		tail5.setRotationPoint(0.0F, -0.9785F, 8.8017F);
		tail4.addChild(tail5);
		setRotationAngle(tail5, -0.0436F, 0.0F, 0.0F);


		tail_r5 = new ModelRenderer(this);
		tail_r5.setRotationPoint(-0.1F, 30.1199F, -9.2861F);
		tail5.addChild(tail_r5);
		setRotationAngle(tail_r5, -0.0436F, 0.0F, 0.0F);
		tail_r5.cubeList.add(new ModelBox(tail_r5, 120, 81, -3.0F, -34.7F, 5.3F, 4, 6, 9, 0.0F));

		tail6 = new ModelRenderer(this);
		tail6.setRotationPoint(-0.5F, 0.7F, 8.5F);
		tail5.addChild(tail6);
		setRotationAngle(tail6, -0.0436F, 0.0F, 0.0F);


		tail_r6 = new ModelRenderer(this);
		tail_r6.setRotationPoint(-0.1F, 30.1199F, -9.2861F);
		tail6.addChild(tail_r6);
		setRotationAngle(tail_r6, -0.0436F, 0.0F, 0.0F);
		tail_r6.cubeList.add(new ModelBox(tail_r6, 122, 120, -2.0F, -34.7F, 5.3F, 3, 5, 9, 0.0F));

		tail7 = new ModelRenderer(this);
		tail7.setRotationPoint(0.4F, 0.8F, 5.4F);
		tail6.addChild(tail7);
		setRotationAngle(tail7, -0.3054F, 0.0F, 0.0F);


		tail_r7 = new ModelRenderer(this);
		tail_r7.setRotationPoint(0.0F, 30.1199F, -9.2861F);
		tail7.addChild(tail_r7);
		setRotationAngle(tail_r7, -0.0436F, 0.0F, 0.0F);
		tail_r7.cubeList.add(new ModelBox(tail_r7, 18, 132, -2.0F, -34.7F, 6.3F, 2, 3, 8, 0.0F));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(-7.0F, 4.7F, -14.0F);
		body.addChild(left_arm);


		arm_r1 = new ModelRenderer(this);
		arm_r1.setRotationPoint(7.0F, -2.3F, 0.7F);
		left_arm.addChild(arm_r1);
		setRotationAngle(arm_r1, 0.8727F, 0.0F, 0.0F);
		arm_r1.cubeList.add(new ModelBox(arm_r1, 65, 134, -9.4F, -4.0686F, -6.2857F, 4, 10, 5, 0.0F));

		left_armpart2 = new ModelRenderer(this);
		left_armpart2.setRotationPoint(-0.7F, 4.8F, 1.4F);
		left_arm.addChild(left_armpart2);


		arm_r2 = new ModelRenderer(this);
		arm_r2.setRotationPoint(7.7F, -7.1F, -0.7F);
		left_armpart2.addChild(arm_r2);
		setRotationAngle(arm_r2, 0.0436F, 0.0F, 0.0F);
		arm_r2.cubeList.add(new ModelBox(arm_r2, 57, 10, -8.4F, 6.3314F, -2.5857F, 2, 4, 2, 0.0F));
		arm_r2.cubeList.add(new ModelBox(arm_r2, 80, 46, -9.0F, 4.6314F, -1.4857F, 3, 10, 3, 0.0F));

		arm_r3 = new ModelRenderer(this);
		arm_r3.setRotationPoint(7.7F, -7.1F, -0.7F);
		left_armpart2.addChild(arm_r3);
		setRotationAngle(arm_r3, -0.1309F, 0.0F, 0.0F);
		arm_r3.cubeList.add(new ModelBox(arm_r3, 49, 0, -8.7F, 9.6314F, -0.9857F, 3, 5, 5, 0.0F));

		left_arm_finger = new ModelRenderer(this);
		left_arm_finger.setRotationPoint(1.1F, 7.9F, -2.4F);
		left_armpart2.addChild(left_arm_finger);
		setRotationAngle(left_arm_finger, -0.1886F, -0.3864F, 0.0718F);


		finger_r1 = new ModelRenderer(this);
		finger_r1.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger.addChild(finger_r1);
		setRotationAngle(finger_r1, -0.2835F, -0.1153F, -0.3762F);
		finger_r1.cubeList.add(new ModelBox(finger_r1, 13, 34, -8.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r2 = new ModelRenderer(this);
		finger_r2.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger.addChild(finger_r2);
		setRotationAngle(finger_r2, -0.2986F, -0.0651F, -0.2084F);
		finger_r2.cubeList.add(new ModelBox(finger_r2, 35, 91, -8.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		left_arm_finger2 = new ModelRenderer(this);
		left_arm_finger2.setRotationPoint(0.3F, 7.9F, -0.9F);
		left_armpart2.addChild(left_arm_finger2);
		setRotationAngle(left_arm_finger2, 0.1436F, -0.2305F, 0.0024F);


		finger_r3 = new ModelRenderer(this);
		finger_r3.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger2.addChild(finger_r3);
		setRotationAngle(finger_r3, -0.2835F, -0.1153F, -0.3762F);
		finger_r3.cubeList.add(new ModelBox(finger_r3, 11, 34, -8.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r4 = new ModelRenderer(this);
		finger_r4.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger2.addChild(finger_r4);
		setRotationAngle(finger_r4, -0.2986F, -0.0651F, -0.2084F);
		finger_r4.cubeList.add(new ModelBox(finger_r4, 27, 91, -8.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		left_arm_finger3 = new ModelRenderer(this);
		left_arm_finger3.setRotationPoint(0.9F, 7.9F, -0.5F);
		left_armpart2.addChild(left_arm_finger3);
		setRotationAngle(left_arm_finger3, 0.8649F, 0.3304F, -0.4721F);


		finger_r5 = new ModelRenderer(this);
		finger_r5.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger3.addChild(finger_r5);
		setRotationAngle(finger_r5, -0.2835F, -0.1153F, -0.3762F);
		finger_r5.cubeList.add(new ModelBox(finger_r5, 2, 34, -8.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r6 = new ModelRenderer(this);
		finger_r6.setRotationPoint(7.2F, 0.618F, 1.1666F);
		left_arm_finger3.addChild(finger_r6);
		setRotationAngle(finger_r6, -0.2986F, -0.0651F, -0.2084F);
		finger_r6.cubeList.add(new ModelBox(finger_r6, 84, 75, -8.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(7.0F, 4.7F, -14.0F);
		body.addChild(right_arm);


		arm_r4 = new ModelRenderer(this);
		arm_r4.setRotationPoint(-7.0F, -2.3F, 0.7F);
		right_arm.addChild(arm_r4);
		setRotationAngle(arm_r4, 0.8727F, 0.0F, 0.0F);
		arm_r4.cubeList.add(new ModelBox(arm_r4, 0, 132, 5.4F, -4.0686F, -6.2857F, 4, 10, 5, 0.0F));

		right_armpart3 = new ModelRenderer(this);
		right_armpart3.setRotationPoint(0.7F, 4.8F, 1.4F);
		right_arm.addChild(right_armpart3);


		arm_r5 = new ModelRenderer(this);
		arm_r5.setRotationPoint(-7.7F, -7.1F, -0.7F);
		right_armpart3.addChild(arm_r5);
		setRotationAngle(arm_r5, 0.0436F, 0.0F, 0.0F);
		arm_r5.cubeList.add(new ModelBox(arm_r5, 49, 10, 6.4F, 6.3314F, -2.5857F, 2, 4, 2, 0.0F));
		arm_r5.cubeList.add(new ModelBox(arm_r5, 0, 66, 6.0F, 4.6314F, -1.4857F, 3, 10, 3, 0.0F));

		arm_r6 = new ModelRenderer(this);
		arm_r6.setRotationPoint(-7.7F, -7.1F, -0.7F);
		right_armpart3.addChild(arm_r6);
		setRotationAngle(arm_r6, -0.1309F, 0.0F, 0.0F);
		arm_r6.cubeList.add(new ModelBox(arm_r6, 49, 0, 5.7F, 9.6314F, -0.9857F, 3, 5, 5, 0.0F));

		right_arm_finger4 = new ModelRenderer(this);
		right_arm_finger4.setRotationPoint(-1.1F, 7.9F, -2.4F);
		right_armpart3.addChild(right_arm_finger4);
		setRotationAngle(right_arm_finger4, -0.1886F, 0.3864F, -0.0718F);


		finger_r7 = new ModelRenderer(this);
		finger_r7.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger4.addChild(finger_r7);
		setRotationAngle(finger_r7, -0.2835F, 0.1153F, 0.3762F);
		finger_r7.cubeList.add(new ModelBox(finger_r7, 0, 34, 7.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r8 = new ModelRenderer(this);
		finger_r8.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger4.addChild(finger_r8);
		setRotationAngle(finger_r8, -0.2986F, 0.0651F, 0.2084F);
		finger_r8.cubeList.add(new ModelBox(finger_r8, 8, 44, 6.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		right_arm_finger5 = new ModelRenderer(this);
		right_arm_finger5.setRotationPoint(-0.3F, 7.9F, -0.9F);
		right_armpart3.addChild(right_arm_finger5);
		setRotationAngle(right_arm_finger5, 0.1436F, 0.2305F, -0.0024F);


		finger_r9 = new ModelRenderer(this);
		finger_r9.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger5.addChild(finger_r9);
		setRotationAngle(finger_r9, -0.2835F, 0.1153F, 0.3762F);
		finger_r9.cubeList.add(new ModelBox(finger_r9, 18, 16, 7.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r10 = new ModelRenderer(this);
		finger_r10.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger5.addChild(finger_r10);
		setRotationAngle(finger_r10, -0.2986F, 0.0651F, 0.2084F);
		finger_r10.cubeList.add(new ModelBox(finger_r10, 0, 44, 6.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		right_arm_finger6 = new ModelRenderer(this);
		right_arm_finger6.setRotationPoint(-0.9F, 7.9F, -0.5F);
		right_armpart3.addChild(right_arm_finger6);
		setRotationAngle(right_arm_finger6, 0.8649F, -0.3304F, 0.4721F);


		finger_r11 = new ModelRenderer(this);
		finger_r11.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger6.addChild(finger_r11);
		setRotationAngle(finger_r11, -0.2835F, 0.1153F, 0.3762F);
		finger_r11.cubeList.add(new ModelBox(finger_r11, 8, 18, 7.6F, -0.6533F, -1.1878F, 1, 3, 0, 0.0F));

		finger_r12 = new ModelRenderer(this);
		finger_r12.setRotationPoint(-7.2F, 0.618F, 1.1666F);
		right_arm_finger6.addChild(finger_r12);
		setRotationAngle(finger_r12, -0.2986F, 0.0651F, 0.2084F);
		finger_r12.cubeList.add(new ModelBox(finger_r12, 10, 14, 6.6F, -2.9533F, -2.1878F, 2, 4, 2, 0.0F));

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 3.0F, -22.9F);
		body.addChild(neck);
		setRotationAngle(neck, 0.3927F, 0.0F, 0.0F);


		neck_r1 = new ModelRenderer(this);
		neck_r1.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r1);
		setRotationAngle(neck_r1, 1.8762F, 0.0F, 0.0F);
		neck_r1.cubeList.add(new ModelBox(neck_r1, 82, 129, -3.4F, -18.1F, 48.6F, 7, 5, 5, 0.0F));

		neck_r2 = new ModelRenderer(this);
		neck_r2.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r2);
		setRotationAngle(neck_r2, -1.1345F, 0.0F, 0.0F);
		neck_r2.cubeList.add(new ModelBox(neck_r2, 107, 37, -3.4F, 6.1F, -51.5F, 7, 10, 8, 0.01F));

		neck_r3 = new ModelRenderer(this);
		neck_r3.setRotationPoint(-0.1F, 31.1F, 22.0F);
		neck.addChild(neck_r3);
		setRotationAngle(neck_r3, -0.6545F, 0.0F, 0.0F);
		neck_r3.cubeList.add(new ModelBox(neck_r3, 110, 64, -4.4F, -16.5F, -46.9F, 9, 11, 6, 0.0F));

		neck_r4 = new ModelRenderer(this);
		neck_r4.setRotationPoint(-0.1F, 31.0F, 22.9F);
		neck.addChild(neck_r4);
		setRotationAngle(neck_r4, -0.4363F, 0.0F, 0.0F);
		neck_r4.cubeList.add(new ModelBox(neck_r4, 82, 75, -4.4F, -25.6F, -39.7F, 9, 12, 10, 0.1F));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -8.1F, -9.7F);
		neck.addChild(head);
		setRotationAngle(head, -0.3491F, 0.0F, 0.0F);


		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.3F, -2.9794F, -6.484F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 1.8316F, -0.0094F, 0.218F);
		head_r1.cubeList.add(new ModelBox(head_r1, 33, 66, 2.2F, -3.8502F, 4.5235F, 1, 7, 2, 0.0F));

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.3F, -2.9794F, -6.484F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 1.6551F, -0.0206F, 0.3484F);
		head_r2.cubeList.add(new ModelBox(head_r2, 46, 42, 1.4F, -1.4502F, 5.2235F, 1, 4, 4, 0.0F));

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(-0.1F, -2.9794F, -6.484F);
		head.addChild(head_r3);
		setRotationAngle(head_r3, 1.6144F, 0.0F, 0.0F);
		head_r3.cubeList.add(new ModelBox(head_r3, 87, 140, -2.4F, -12.8502F, 4.9235F, 5, 16, 1, 0.0F));
		head_r3.cubeList.add(new ModelBox(head_r3, 30, 124, -4.4F, -12.8502F, -6.0765F, 9, 13, 2, 0.0F));
		head_r3.cubeList.add(new ModelBox(head_r3, 46, 75, -4.4F, -12.8502F, -4.0765F, 9, 21, 9, 0.0F));

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(-0.3F, -2.9794F, -6.484F);
		head.addChild(head_r4);
		setRotationAngle(head_r4, 1.6551F, 0.0206F, -0.3484F);
		head_r4.cubeList.add(new ModelBox(head_r4, 0, 91, -2.4F, -1.4502F, 5.2235F, 1, 4, 4, 0.0F));

		head_r5 = new ModelRenderer(this);
		head_r5.setRotationPoint(-0.3F, -2.9794F, -6.484F);
		head.addChild(head_r5);
		setRotationAngle(head_r5, 1.8316F, 0.0094F, -0.218F);
		head_r5.cubeList.add(new ModelBox(head_r5, 49, 75, -3.2F, -3.8502F, 4.5235F, 1, 7, 2, 0.0F));

		upper_jaw = new ModelRenderer(this);
		upper_jaw.setRotationPoint(0.5F, -2.1794F, -8.884F);
		head.addChild(upper_jaw);


		lower_jaw = new ModelRenderer(this);
		lower_jaw.setRotationPoint(0.4F, 1.7206F, -0.184F);
		head.addChild(lower_jaw);
		setRotationAngle(lower_jaw, 0.4363F, 0.0F, 0.0F);


		head_r6 = new ModelRenderer(this);
		head_r6.setRotationPoint(-1.0F, -4.7F, -6.3F);
		lower_jaw.addChild(head_r6);
		setRotationAngle(head_r6, 1.6144F, 0.0F, 0.0F);
		head_r6.cubeList.add(new ModelBox(head_r6, 0, 0, -3.4F, -11.8502F, -4.0765F, 8, 12, 2, 0.01F));
		head_r6.cubeList.add(new ModelBox(head_r6, 59, 118, -3.4F, -2.8502F, -10.0765F, 8, 10, 6, 0.01F));
		head_r6.cubeList.add(new ModelBox(head_r6, 0, 14, -1.4F, -3.8502F, -4.0765F, 4, 3, 1, 0.01F));
		head_r6.cubeList.add(new ModelBox(head_r6, 88, 19, -1.4F, -0.8502F, -4.0765F, 4, 6, 2, 0.01F));
		head_r6.cubeList.add(new ModelBox(head_r6, 129, 30, -3.4F, -11.8502F, -8.0765F, 8, 9, 4, 0.01F));

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
		left_muscle_r1.cubeList.add(new ModelBox(left_muscle_r1, 80, 46, -1.3428F, 1.0471F, -7.0249F, 7, 5, 13, 0.0F));

		left_muscleconnector_r1 = new ModelRenderer(this);
		left_muscleconnector_r1.setRotationPoint(1.3F, -10.2F, 0.0F);
		bone.addChild(left_muscleconnector_r1);
		setRotationAngle(left_muscleconnector_r1, 2.3998F, -0.6545F, 0.0F);
		left_muscleconnector_r1.cubeList.add(new ModelBox(left_muscleconnector_r1, 0, 91, -2.0741F, -5.9925F, -9.8194F, 8, 8, 11, 0.0F));

		left_leg_topmuscle_r1 = new ModelRenderer(this);
		left_leg_topmuscle_r1.setRotationPoint(-5.6F, 11.0F, 0.0F);
		bone.addChild(left_leg_topmuscle_r1);
		setRotationAngle(left_leg_topmuscle_r1, 1.3526F, -0.6981F, 0.0F);
		left_leg_topmuscle_r1.cubeList.add(new ModelBox(left_leg_topmuscle_r1, 44, 48, 3.0F, -14.9F, 14.2F, 9, 9, 18, 0.0F));

		foot3 = new ModelRenderer(this);
		foot3.setRotationPoint(0.5083F, 5.2F, 3.2448F);
		bone.addChild(foot3);


		left_foot_r1 = new ModelRenderer(this);
		left_foot_r1.setRotationPoint(-6.1083F, 5.8F, -3.2448F);
		foot3.addChild(left_foot_r1);
		setRotationAngle(left_foot_r1, 0.9163F, -0.6545F, 0.0F);
		left_foot_r1.cubeList.add(new ModelBox(left_foot_r1, 115, 16, 3.2F, -6.8F, -1.4F, 7, 5, 9, 0.0F));

		left_toe = new ModelRenderer(this);
		left_toe.setRotationPoint(2.4F, 4.2F, -2.0F);
		foot3.addChild(left_toe);
		setRotationAngle(left_toe, 0.0F, -0.1745F, 0.0F);


		left_toeclaw_r1 = new ModelRenderer(this);
		left_toeclaw_r1.setRotationPoint(-8.5083F, 1.6F, -1.2448F);
		left_toe.addChild(left_toeclaw_r1);
		setRotationAngle(left_toeclaw_r1, 0.0F, -0.6545F, 0.0F);
		left_toeclaw_r1.cubeList.add(new ModelBox(left_toeclaw_r1, 2, 18, 9.0F, -2.0F, -12.7F, 0, 1, 1, 0.0F));
		left_toeclaw_r1.cubeList.add(new ModelBox(left_toeclaw_r1, 4, 16, 9.0F, -1.0F, -13.7F, 0, 1, 2, 0.0F));
		left_toeclaw_r1.cubeList.add(new ModelBox(left_toeclaw_r1, 131, 3, 8.0F, -2.0F, -11.7F, 2, 2, 9, 0.0F));

		left_toe2_r1 = new ModelRenderer(this);
		left_toe2_r1.setRotationPoint(-8.5083F, 1.6F, -1.2448F);
		left_toe.addChild(left_toe2_r1);
		setRotationAngle(left_toe2_r1, 0.5265F, -0.7539F, -0.0718F);
		left_toe2_r1.cubeList.add(new ModelBox(left_toe2_r1, 43, 130, 7.0F, -6.3F, -9.3F, 2, 2, 9, 0.0F));

		left_toe3 = new ModelRenderer(this);
		left_toe3.setRotationPoint(-1.0F, 2.9F, -4.7F);
		foot3.addChild(left_toe3);


		left_toeclaw_r2 = new ModelRenderer(this);
		left_toeclaw_r2.setRotationPoint(-6.1083F, 2.9F, 1.4552F);
		left_toe3.addChild(left_toeclaw_r2);
		setRotationAngle(left_toeclaw_r2, 0.0F, -0.2618F, 0.0F);
		left_toeclaw_r2.cubeList.add(new ModelBox(left_toeclaw_r2, 18, 0, 6.2F, -2.0F, -10.6F, 0, 1, 1, 0.0F));
		left_toeclaw_r2.cubeList.add(new ModelBox(left_toeclaw_r2, 0, 16, 6.2F, -1.0F, -11.6F, 0, 1, 2, 0.0F));
		left_toeclaw_r2.cubeList.add(new ModelBox(left_toeclaw_r2, 129, 106, 5.2F, -2.0F, -9.6F, 2, 2, 9, 0.0F));

		left_toe3_r1 = new ModelRenderer(this);
		left_toe3_r1.setRotationPoint(-6.1083F, 2.9F, 1.4552F);
		left_toe3.addChild(left_toe3_r1);
		setRotationAngle(left_toe3_r1, 0.4669F, -0.1761F, 0.0624F);
		left_toe3_r1.cubeList.add(new ModelBox(left_toe3_r1, 33, 68, 5.7F, -5.4F, -5.7F, 2, 2, 7, 0.0F));

		left_toe7 = new ModelRenderer(this);
		left_toe7.setRotationPoint(3.1F, 3.4F, -3.4F);
		foot3.addChild(left_toe7);
		setRotationAngle(left_toe7, 0.0F, -0.2182F, 0.0F);


		left_toeclaw_r3 = new ModelRenderer(this);
		left_toeclaw_r3.setRotationPoint(-9.2083F, 2.4F, 0.1552F);
		left_toe7.addChild(left_toeclaw_r3);
		setRotationAngle(left_toeclaw_r3, 0.0F, -0.4363F, 0.0F);
		left_toeclaw_r3.cubeList.add(new ModelBox(left_toeclaw_r3, 0, 0, 7.8F, -1.0F, -12.2F, 0, 1, 1, 0.0F));
		left_toeclaw_r3.cubeList.add(new ModelBox(left_toeclaw_r3, 10, 13, 7.8F, -2.0F, -11.2F, 0, 2, 1, 0.0F));
		left_toeclaw_r3.cubeList.add(new ModelBox(left_toeclaw_r3, 106, 129, 6.8F, -2.0F, -10.2F, 2, 2, 9, 0.01F));

		left_toe4_r1 = new ModelRenderer(this);
		left_toe4_r1.setRotationPoint(-9.2083F, 2.4F, 0.1552F);
		left_toe7.addChild(left_toe4_r1);
		setRotationAngle(left_toe4_r1, 0.5236F, -0.4363F, 0.0F);
		left_toe4_r1.cubeList.add(new ModelBox(left_toe4_r1, 128, 46, 6.8F, -5.8F, -7.0F, 2, 2, 9, 0.0F));

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
		left_muscle_r2.cubeList.add(new ModelBox(left_muscle_r2, 80, 46, -5.6572F, 1.0471F, -7.0249F, 7, 5, 13, 0.0F));

		left_muscleconnector_r2 = new ModelRenderer(this);
		left_muscleconnector_r2.setRotationPoint(-1.3F, -10.2F, 0.0F);
		bone2.addChild(left_muscleconnector_r2);
		setRotationAngle(left_muscleconnector_r2, 2.3998F, 0.6545F, 0.0F);
		left_muscleconnector_r2.cubeList.add(new ModelBox(left_muscleconnector_r2, 0, 91, -5.9259F, -5.9925F, -9.8194F, 8, 8, 11, 0.0F));

		left_leg_topmuscle_r2 = new ModelRenderer(this);
		left_leg_topmuscle_r2.setRotationPoint(5.6F, 11.0F, 0.0F);
		bone2.addChild(left_leg_topmuscle_r2);
		setRotationAngle(left_leg_topmuscle_r2, 1.3526F, 0.6981F, 0.0F);
		left_leg_topmuscle_r2.cubeList.add(new ModelBox(left_leg_topmuscle_r2, 44, 48, -12.0F, -14.9F, 14.2F, 9, 9, 18, 0.0F));

		foot2 = new ModelRenderer(this);
		foot2.setRotationPoint(-0.5083F, 5.2F, 3.2448F);
		bone2.addChild(foot2);


		left_foot_r2 = new ModelRenderer(this);
		left_foot_r2.setRotationPoint(6.1083F, 5.8F, -3.2448F);
		foot2.addChild(left_foot_r2);
		setRotationAngle(left_foot_r2, 0.9163F, 0.6545F, 0.0F);
		left_foot_r2.cubeList.add(new ModelBox(left_foot_r2, 115, 16, -10.2F, -6.8F, -1.4F, 7, 5, 9, 0.0F));

		right_toe = new ModelRenderer(this);
		right_toe.setRotationPoint(-2.4F, 4.2F, -2.0F);
		foot2.addChild(right_toe);
		setRotationAngle(right_toe, 0.0F, 0.1745F, 0.0F);


		left_toeclaw_r4 = new ModelRenderer(this);
		left_toeclaw_r4.setRotationPoint(8.5083F, 1.6F, -1.2448F);
		right_toe.addChild(left_toeclaw_r4);
		setRotationAngle(left_toeclaw_r4, 0.0F, 0.6545F, 0.0F);
		left_toeclaw_r4.cubeList.add(new ModelBox(left_toeclaw_r4, 2, 18, -9.0F, -2.0F, -12.7F, 0, 1, 1, 0.0F));
		left_toeclaw_r4.cubeList.add(new ModelBox(left_toeclaw_r4, 4, 16, -9.0F, -1.0F, -13.7F, 0, 1, 2, 0.0F));
		left_toeclaw_r4.cubeList.add(new ModelBox(left_toeclaw_r4, 131, 3, -10.0F, -2.0F, -11.7F, 2, 2, 9, 0.0F));

		left_toe2_r2 = new ModelRenderer(this);
		left_toe2_r2.setRotationPoint(8.5083F, 1.6F, -1.2448F);
		right_toe.addChild(left_toe2_r2);
		setRotationAngle(left_toe2_r2, 0.5265F, 0.7539F, 0.0718F);
		left_toe2_r2.cubeList.add(new ModelBox(left_toe2_r2, 43, 130, -9.0F, -6.3F, -9.3F, 2, 2, 9, 0.0F));

		right_toe4 = new ModelRenderer(this);
		right_toe4.setRotationPoint(1.0F, 2.9F, -4.7F);
		foot2.addChild(right_toe4);


		left_toeclaw_r5 = new ModelRenderer(this);
		left_toeclaw_r5.setRotationPoint(6.1083F, 2.9F, 1.4552F);
		right_toe4.addChild(left_toeclaw_r5);
		setRotationAngle(left_toeclaw_r5, 0.0F, 0.2618F, 0.0F);
		left_toeclaw_r5.cubeList.add(new ModelBox(left_toeclaw_r5, 18, 0, -6.2F, -2.0F, -10.6F, 0, 1, 1, 0.0F));
		left_toeclaw_r5.cubeList.add(new ModelBox(left_toeclaw_r5, 0, 16, -6.2F, -1.0F, -11.6F, 0, 1, 2, 0.0F));
		left_toeclaw_r5.cubeList.add(new ModelBox(left_toeclaw_r5, 129, 106, -7.2F, -2.0F, -9.6F, 2, 2, 9, 0.0F));

		left_toe3_r2 = new ModelRenderer(this);
		left_toe3_r2.setRotationPoint(6.1083F, 2.9F, 1.4552F);
		right_toe4.addChild(left_toe3_r2);
		setRotationAngle(left_toe3_r2, 0.4669F, 0.1761F, -0.0624F);
		left_toe3_r2.cubeList.add(new ModelBox(left_toe3_r2, 33, 68, -7.7F, -5.4F, -5.7F, 2, 2, 7, 0.0F));

		right_toe5 = new ModelRenderer(this);
		right_toe5.setRotationPoint(-3.1F, 3.4F, -3.4F);
		foot2.addChild(right_toe5);
		setRotationAngle(right_toe5, 0.0F, 0.2182F, 0.0F);


		left_toeclaw_r6 = new ModelRenderer(this);
		left_toeclaw_r6.setRotationPoint(9.2083F, 2.4F, 0.1552F);
		right_toe5.addChild(left_toeclaw_r6);
		setRotationAngle(left_toeclaw_r6, 0.0F, 0.4363F, 0.0F);
		left_toeclaw_r6.cubeList.add(new ModelBox(left_toeclaw_r6, 0, 0, -7.8F, -1.0F, -12.2F, 0, 1, 1, 0.0F));
		left_toeclaw_r6.cubeList.add(new ModelBox(left_toeclaw_r6, 10, 13, -7.8F, -2.0F, -11.2F, 0, 2, 1, 0.0F));
		left_toeclaw_r6.cubeList.add(new ModelBox(left_toeclaw_r6, 106, 129, -8.8F, -2.0F, -10.2F, 2, 2, 9, 0.01F));

		left_toe4_r2 = new ModelRenderer(this);
		left_toe4_r2.setRotationPoint(9.2083F, 2.4F, 0.1552F);
		right_toe5.addChild(left_toe4_r2);
		setRotationAngle(left_toe4_r2, 0.5236F, 0.4363F, 0.0F);
		left_toe4_r2.cubeList.add(new ModelBox(left_toe4_r2, 128, 46, -8.8F, -5.8F, -7.0F, 2, 2, 9, 0.0F));
	}


	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
        this.left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.lower_jaw.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.4F * f1;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
