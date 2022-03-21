// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

package com.devmaster.dangerzone.client.render.model;
import com.devmaster.dangerzone.entity.CaveFisher;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;

public class CaveFisherModel<N extends CreatureEntity> extends EntityModel<CaveFisher> {
	private final ModelRenderer Cave_Fisher;
	private final ModelRenderer Main_body;
	private final ModelRenderer Right_arm;
	private final ModelRenderer Right_arm_r1;
	private final ModelRenderer Right_arm_r2;
	private final ModelRenderer Right_arm_segment;
	private final ModelRenderer Right_arm_segment_r1;
	private final ModelRenderer Left_arm;
	private final ModelRenderer Left_arm_r1;
	private final ModelRenderer Left_arm_r2;
	private final ModelRenderer Left_arm_segment;
	private final ModelRenderer Left_arm_segment_r1;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Eye;
	private final ModelRenderer Eye_r1;
	private final ModelRenderer Main_body_segment;
	private final ModelRenderer Main_body_segment_2;
	private final ModelRenderer Tail;
	private final ModelRenderer Left_Leg_1;
	private final ModelRenderer Left_Leg_1_r1;
	private final ModelRenderer Left_Leg_5;
	private final ModelRenderer Left_Leg_6;
	private final ModelRenderer Left_Leg_8;
	private final ModelRenderer Left_Leg_9;
	private final ModelRenderer Left_Leg3;
	private final ModelRenderer Left_Leg3_r1;
	private final ModelRenderer Right_Leg_1;
	private final ModelRenderer Right_Leg_1_r1;
	private final ModelRenderer Right_Leg_5;
	private final ModelRenderer Right4_r1;
	private final ModelRenderer Right_Leg_6;
	private final ModelRenderer Right_Leg5_r1;
	private final ModelRenderer Right_Leg8;
	private final ModelRenderer Right_Leg6_r1;
	private final ModelRenderer Left_Leg_2;
	private final ModelRenderer Left_Leg_2_r1;
	private final ModelRenderer Left_Leg7;
	private final ModelRenderer Left_Leg7_r1;
	private final ModelRenderer Left_Leg8;
	private final ModelRenderer Left_Leg8_r1;
	private final ModelRenderer Left_Leg9;
	private final ModelRenderer Left_Leg9_r1;
	private final ModelRenderer Right_Leg_2;
	private final ModelRenderer Right_Leg_2_r1;
	private final ModelRenderer Right_Leg10;
	private final ModelRenderer Right_Leg10_r1;
	private final ModelRenderer Right_Leg11;
	private final ModelRenderer Right_Leg11_r1;
	private final ModelRenderer Right_Leg12;
	private final ModelRenderer Right_Leg12_r1;
	private final ModelRenderer Left_Leg_3;
	private final ModelRenderer Left_Leg_3_r1;
	private final ModelRenderer Left_Leg13;
	private final ModelRenderer Left_Leg13_r1;
	private final ModelRenderer Left_Leg14;
	private final ModelRenderer Left_Leg14_r1;
	private final ModelRenderer Left_Leg15;
	private final ModelRenderer Left_Leg15_r1;
	private final ModelRenderer Right_Leg_3;
	private final ModelRenderer Right_Leg_3_r1;
	private final ModelRenderer Right_Leg16;
	private final ModelRenderer Right_Leg16_r1;
	private final ModelRenderer Right_Leg17;
	private final ModelRenderer Right_Leg17_r1;
	private final ModelRenderer Right_leg18;
	private final ModelRenderer Right_Leg18_r1;
	private final ModelRenderer Left_Leg_4;
	private final ModelRenderer Left_Leg_4_r1;
	private final ModelRenderer Left_Leg_back_upper;
	private final ModelRenderer Left_Leg2;
	private final ModelRenderer Left_Leg_back_mid;
	private final ModelRenderer Left_Leg4;
	private final ModelRenderer Left_Leg_Lower_Back;
	private final ModelRenderer Left_Leg;
	private final ModelRenderer Right_Leg_4;
	private final ModelRenderer Right_Leg_4_r1;
	private final ModelRenderer Right_Leg_Back_Upper;
	private final ModelRenderer Right_Leg_Back_Upper2;
	private final ModelRenderer Right_Leg_Mid_Back;
	private final ModelRenderer Right_Leg_mig_Back;
	private final ModelRenderer Right_Leg_Back_Lower;
	private final ModelRenderer Right_Lower_Back_Leg;

	public CaveFisherModel() {
		textureWidth = 64;
		textureHeight = 64;

		Cave_Fisher = new ModelRenderer(this);
		Cave_Fisher.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Main_body = new ModelRenderer(this);
		Main_body.setRotationPoint(0.0F, -6.1625F, 10.5F);
		Cave_Fisher.addChild(Main_body);
		Main_body.setTextureOffset(0, 0).addBox(-3.5F, -2.5875F, -14.25F, 7.0F, 5.0F, 8.0F, 0.0F, false);

		Right_arm = new ModelRenderer(this);
		Right_arm.setRotationPoint(-2.7675F, 2.5567F, -13.022F);
		Main_body.addChild(Right_arm);
		

		Right_arm_r1 = new ModelRenderer(this);
		Right_arm_r1.setRotationPoint(-1.5349F, -2.2505F, -1.9625F);
		Right_arm.addChild(Right_arm_r1);
		setRotationAngle(Right_arm_r1, -1.0996F, 0.2618F, 0.0F);
		Right_arm_r1.setTextureOffset(42, 6).addBox(-1.25F, -1.25F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		Right_arm_r2 = new ModelRenderer(this);
		Right_arm_r2.setRotationPoint(-0.9825F, -2.6053F, -0.5595F);
		Right_arm.addChild(Right_arm_r2);
		setRotationAngle(Right_arm_r2, -0.3054F, 0.4363F, 0.0F);
		Right_arm_r2.setTextureOffset(34, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Right_arm_segment = new ModelRenderer(this);
		Right_arm_segment.setRotationPoint(-1.8524F, 0.3599F, -4.3465F);
		Right_arm.addChild(Right_arm_segment);
		

		Right_arm_segment_r1 = new ModelRenderer(this);
		Right_arm_segment_r1.setRotationPoint(-1.25F, 0.0F, -2.5F);
		Right_arm_segment.addChild(Right_arm_segment_r1);
		setRotationAngle(Right_arm_segment_r1, -1.295F, -0.1884F, 0.0371F);
		Right_arm_segment_r1.setTextureOffset(0, 42).addBox(-0.4375F, -2.5F, -1.375F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		Right_arm_segment_r1.setTextureOffset(34, 37).addBox(-1.0F, 2.125F, -1.625F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		Left_arm = new ModelRenderer(this);
		Left_arm.setRotationPoint(2.7675F, 2.5567F, -13.022F);
		Main_body.addChild(Left_arm);
		

		Left_arm_r1 = new ModelRenderer(this);
		Left_arm_r1.setRotationPoint(1.5349F, -2.2505F, -1.9625F);
		Left_arm.addChild(Left_arm_r1);
		setRotationAngle(Left_arm_r1, -1.0996F, -0.2618F, 0.0F);
		Left_arm_r1.setTextureOffset(38, 16).addBox(-0.75F, -1.25F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		Left_arm_r2 = new ModelRenderer(this);
		Left_arm_r2.setRotationPoint(0.9825F, -2.6053F, -0.5595F);
		Left_arm.addChild(Left_arm_r2);
		setRotationAngle(Left_arm_r2, -0.3054F, -0.4363F, 0.0F);
		Left_arm_r2.setTextureOffset(22, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Left_arm_segment = new ModelRenderer(this);
		Left_arm_segment.setRotationPoint(1.8524F, 0.3599F, -4.3465F);
		Left_arm.addChild(Left_arm_segment);
		

		Left_arm_segment_r1 = new ModelRenderer(this);
		Left_arm_segment_r1.setRotationPoint(1.25F, 0.0F, -2.5F);
		Left_arm_segment.addChild(Left_arm_segment_r1);
		setRotationAngle(Left_arm_segment_r1, -1.295F, 0.1884F, -0.0371F);
		Left_arm_segment_r1.setTextureOffset(24, 37).addBox(-2.0F, 2.125F, -1.625F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		Left_arm_segment_r1.setTextureOffset(0, 0).addBox(-1.5625F, -2.5F, -1.375F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -0.8754F, -13.0207F);
		Main_body.addChild(Head);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-3.25F, -2.4621F, 0.0207F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.7854F, 0.0F, -0.4363F);
		Head_r1.setTextureOffset(0, 24).addBox(-2.5F, -0.5F, -4.0F, 5.0F, 2.0F, 7.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(0.0F, -3.255F, 0.2707F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.7854F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(17, 28).addBox(-2.5F, -1.0F, -3.5F, 5.0F, 2.0F, 7.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setRotationPoint(0.0F, 0.1414F, -1.8328F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.7854F, 0.0F, 0.0F);
		Head_r3.setTextureOffset(23, 6).addBox(-3.0F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setRotationPoint(3.25F, -2.4621F, 0.0207F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.7854F, 0.0F, 0.4363F);
		Head_r4.setTextureOffset(0, 33).addBox(-2.5F, -0.5F, -4.0F, 5.0F, 2.0F, 7.0F, 0.0F, false);

		Eye = new ModelRenderer(this);
		Eye.setRotationPoint(0.0F, -0.8371F, -2.9168F);
		Head.addChild(Eye);
		

		Eye_r1 = new ModelRenderer(this);
		Eye_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Eye.addChild(Eye_r1);
		setRotationAngle(Eye_r1, -0.6109F, 0.0F, 0.0F);
		Eye_r1.setTextureOffset(17, 28).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Main_body_segment = new ModelRenderer(this);
		Main_body_segment.setRotationPoint(0.0F, 0.0F, -4.75F);
		Main_body.addChild(Main_body_segment);
		Main_body_segment.setTextureOffset(19, 17).addBox(-3.0F, -2.35F, -3.5F, 6.0F, 4.0F, 7.0F, 0.0F, false);

		Main_body_segment_2 = new ModelRenderer(this);
		Main_body_segment_2.setRotationPoint(0.0F, 0.0F, 4.75F);
		Main_body_segment.addChild(Main_body_segment_2);
		Main_body_segment_2.setTextureOffset(0, 13).addBox(-3.0F, -2.35F, -3.5F, 6.0F, 4.0F, 7.0F, -0.2F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 0.35F, 6.5F);
		Main_body_segment_2.addChild(Tail);
		Tail.setTextureOffset(27, 28).addBox(-3.0F, 0.0F, -3.5F, 6.0F, 0.0F, 7.0F, 0.0F, false);

		Left_Leg_1 = new ModelRenderer(this);
		Left_Leg_1.setRotationPoint(3.1513F, -4.5362F, 4.0862F);
		Cave_Fisher.addChild(Left_Leg_1);
		

		Left_Leg_1_r1 = new ModelRenderer(this);
		Left_Leg_1_r1.setRotationPoint(-0.5609F, 0.7046F, -1.1316F);
		Left_Leg_1.addChild(Left_Leg_1_r1);
		setRotationAngle(Left_Leg_1_r1, -0.3054F, 0.384F, 0.0F);
		Left_Leg_1_r1.setTextureOffset(8, 42).addBox(-0.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Left_Leg_5 = new ModelRenderer(this);
		Left_Leg_5.setRotationPoint(-0.7958F, 1.5945F, -2.7191F);
		Left_Leg_1.addChild(Left_Leg_5);
		

		Left_Leg_6 = new ModelRenderer(this);
		Left_Leg_6.setRotationPoint(2.918F, -2.9417F, 1.3671F);
		Left_Leg_5.addChild(Left_Leg_6);
		setRotationAngle(Left_Leg_6, -3.0418F, 0.4201F, 0.7311F);
		Left_Leg_6.setTextureOffset(0, 24).addBox(-1.3125F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Left_Leg_8 = new ModelRenderer(this);
		Left_Leg_8.setRotationPoint(1.2986F, 0.153F, -0.2187F);
		Left_Leg_5.addChild(Left_Leg_8);
		

		Left_Leg_9 = new ModelRenderer(this);
		Left_Leg_9.setRotationPoint(3.6541F, -2.7887F, 1.1484F);
		Left_Leg_8.addChild(Left_Leg_9);
		setRotationAngle(Left_Leg_9, 0.2732F, -0.3983F, 2.2156F);
		Left_Leg_9.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, false);

		Left_Leg3 = new ModelRenderer(this);
		Left_Leg3.setRotationPoint(4.8416F, 1.1863F, 0.6484F);
		Left_Leg_8.addChild(Left_Leg3);
		

		Left_Leg3_r1 = new ModelRenderer(this);
		Left_Leg3_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Left_Leg3.addChild(Left_Leg3_r1);
		setRotationAngle(Left_Leg3_r1, 0.0F, -0.4111F, -3.127F);
		Left_Leg3_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, false);

		Right_Leg_1 = new ModelRenderer(this);
		Right_Leg_1.setRotationPoint(-3.1513F, -4.5362F, 4.0862F);
		Cave_Fisher.addChild(Right_Leg_1);
		

		Right_Leg_1_r1 = new ModelRenderer(this);
		Right_Leg_1_r1.setRotationPoint(0.5609F, 0.7046F, -1.1316F);
		Right_Leg_1.addChild(Right_Leg_1_r1);
		setRotationAngle(Right_Leg_1_r1, -0.3054F, -0.384F, 0.0F);
		Right_Leg_1_r1.setTextureOffset(8, 42).addBox(-1.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		Right_Leg_5 = new ModelRenderer(this);
		Right_Leg_5.setRotationPoint(0.7958F, 1.5945F, -2.7191F);
		Right_Leg_1.addChild(Right_Leg_5);
		

		Right4_r1 = new ModelRenderer(this);
		Right4_r1.setRotationPoint(-2.918F, -2.9417F, 1.3671F);
		Right_Leg_5.addChild(Right4_r1);
		setRotationAngle(Right4_r1, -3.0418F, -0.4201F, -0.7311F);
		Right4_r1.setTextureOffset(0, 24).addBox(-0.1875F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		Right_Leg_6 = new ModelRenderer(this);
		Right_Leg_6.setRotationPoint(-1.2986F, 0.153F, -0.2187F);
		Right_Leg_5.addChild(Right_Leg_6);
		

		Right_Leg5_r1 = new ModelRenderer(this);
		Right_Leg5_r1.setRotationPoint(-3.6541F, -2.7887F, 1.1484F);
		Right_Leg_6.addChild(Right_Leg5_r1);
		setRotationAngle(Right_Leg5_r1, 0.2732F, 0.3983F, -2.2156F);
		Right_Leg5_r1.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, true);

		Right_Leg8 = new ModelRenderer(this);
		Right_Leg8.setRotationPoint(-4.8416F, 1.1863F, 0.6484F);
		Right_Leg_6.addChild(Right_Leg8);
		

		Right_Leg6_r1 = new ModelRenderer(this);
		Right_Leg6_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Right_Leg8.addChild(Right_Leg6_r1);
		setRotationAngle(Right_Leg6_r1, 0.0F, 0.4111F, 3.127F);
		Right_Leg6_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, true);

		Left_Leg_2 = new ModelRenderer(this);
		Left_Leg_2.setRotationPoint(3.1513F, -4.5362F, 6.3362F);
		Cave_Fisher.addChild(Left_Leg_2);
		setRotationAngle(Left_Leg_2, 0.0F, -0.4538F, 0.0F);
		

		Left_Leg_2_r1 = new ModelRenderer(this);
		Left_Leg_2_r1.setRotationPoint(-0.5609F, 0.7046F, -1.1316F);
		Left_Leg_2.addChild(Left_Leg_2_r1);
		setRotationAngle(Left_Leg_2_r1, -0.3054F, 0.384F, 0.0F);
		Left_Leg_2_r1.setTextureOffset(8, 42).addBox(-0.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Left_Leg7 = new ModelRenderer(this);
		Left_Leg7.setRotationPoint(-0.7958F, 1.5945F, -3.8441F);
		Left_Leg_2.addChild(Left_Leg7);
		

		Left_Leg7_r1 = new ModelRenderer(this);
		Left_Leg7_r1.setRotationPoint(2.918F, -2.9417F, 2.4921F);
		Left_Leg7.addChild(Left_Leg7_r1);
		setRotationAngle(Left_Leg7_r1, -3.0418F, 0.4201F, 0.7311F);
		Left_Leg7_r1.setTextureOffset(0, 24).addBox(-1.3125F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Left_Leg8 = new ModelRenderer(this);
		Left_Leg8.setRotationPoint(1.2986F, 0.153F, -0.2187F);
		Left_Leg7.addChild(Left_Leg8);
		

		Left_Leg8_r1 = new ModelRenderer(this);
		Left_Leg8_r1.setRotationPoint(3.6541F, -2.7887F, 2.2734F);
		Left_Leg8.addChild(Left_Leg8_r1);
		setRotationAngle(Left_Leg8_r1, 0.2732F, -0.3983F, 2.2156F);
		Left_Leg8_r1.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, false);

		Left_Leg9 = new ModelRenderer(this);
		Left_Leg9.setRotationPoint(4.8416F, 1.1863F, 1.7734F);
		Left_Leg8.addChild(Left_Leg9);
		

		Left_Leg9_r1 = new ModelRenderer(this);
		Left_Leg9_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Left_Leg9.addChild(Left_Leg9_r1);
		setRotationAngle(Left_Leg9_r1, 0.0F, -0.4111F, -3.127F);
		Left_Leg9_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, false);

		Right_Leg_2 = new ModelRenderer(this);
		Right_Leg_2.setRotationPoint(-3.1513F, -4.5362F, 6.3362F);
		Cave_Fisher.addChild(Right_Leg_2);
		setRotationAngle(Right_Leg_2, 0.0F, 0.4538F, 0.0F);
		

		Right_Leg_2_r1 = new ModelRenderer(this);
		Right_Leg_2_r1.setRotationPoint(0.5609F, 0.7046F, -1.1316F);
		Right_Leg_2.addChild(Right_Leg_2_r1);
		setRotationAngle(Right_Leg_2_r1, -0.3054F, -0.384F, 0.0F);
		Right_Leg_2_r1.setTextureOffset(8, 42).addBox(-1.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		Right_Leg10 = new ModelRenderer(this);
		Right_Leg10.setRotationPoint(0.7958F, 1.5945F, -3.8441F);
		Right_Leg_2.addChild(Right_Leg10);
		

		Right_Leg10_r1 = new ModelRenderer(this);
		Right_Leg10_r1.setRotationPoint(-2.918F, -2.9417F, 2.4921F);
		Right_Leg10.addChild(Right_Leg10_r1);
		setRotationAngle(Right_Leg10_r1, -3.0418F, -0.4201F, -0.7311F);
		Right_Leg10_r1.setTextureOffset(0, 24).addBox(-0.1875F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		Right_Leg11 = new ModelRenderer(this);
		Right_Leg11.setRotationPoint(-1.2986F, 0.153F, -0.2187F);
		Right_Leg10.addChild(Right_Leg11);
		

		Right_Leg11_r1 = new ModelRenderer(this);
		Right_Leg11_r1.setRotationPoint(-3.6541F, -2.7887F, 2.2734F);
		Right_Leg11.addChild(Right_Leg11_r1);
		setRotationAngle(Right_Leg11_r1, 0.2732F, 0.3983F, -2.2156F);
		Right_Leg11_r1.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, true);

		Right_Leg12 = new ModelRenderer(this);
		Right_Leg12.setRotationPoint(-4.8416F, 1.1863F, 1.7734F);
		Right_Leg11.addChild(Right_Leg12);
		

		Right_Leg12_r1 = new ModelRenderer(this);
		Right_Leg12_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Right_Leg12.addChild(Right_Leg12_r1);
		setRotationAngle(Right_Leg12_r1, 0.0F, 0.4111F, 3.127F);
		Right_Leg12_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, true);

		Left_Leg_3 = new ModelRenderer(this);
		Left_Leg_3.setRotationPoint(2.6513F, -4.5362F, 8.3362F);
		Cave_Fisher.addChild(Left_Leg_3);
		setRotationAngle(Left_Leg_3, 0.0F, -0.8029F, 0.0F);
		

		Left_Leg_3_r1 = new ModelRenderer(this);
		Left_Leg_3_r1.setRotationPoint(-0.5609F, 0.7046F, -1.1316F);
		Left_Leg_3.addChild(Left_Leg_3_r1);
		setRotationAngle(Left_Leg_3_r1, -0.3054F, 0.384F, 0.0F);
		Left_Leg_3_r1.setTextureOffset(8, 42).addBox(-0.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Left_Leg13 = new ModelRenderer(this);
		Left_Leg13.setRotationPoint(-0.5458F, 1.5945F, -4.8441F);
		Left_Leg_3.addChild(Left_Leg13);
		

		Left_Leg13_r1 = new ModelRenderer(this);
		Left_Leg13_r1.setRotationPoint(2.668F, -2.9417F, 3.4921F);
		Left_Leg13.addChild(Left_Leg13_r1);
		setRotationAngle(Left_Leg13_r1, -3.0418F, 0.4201F, 0.7311F);
		Left_Leg13_r1.setTextureOffset(0, 24).addBox(-1.3125F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Left_Leg14 = new ModelRenderer(this);
		Left_Leg14.setRotationPoint(1.2986F, 0.153F, -0.2187F);
		Left_Leg13.addChild(Left_Leg14);
		

		Left_Leg14_r1 = new ModelRenderer(this);
		Left_Leg14_r1.setRotationPoint(3.4041F, -2.7887F, 3.2734F);
		Left_Leg14.addChild(Left_Leg14_r1);
		setRotationAngle(Left_Leg14_r1, 0.2732F, -0.3983F, 2.2156F);
		Left_Leg14_r1.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, false);

		Left_Leg15 = new ModelRenderer(this);
		Left_Leg15.setRotationPoint(4.5916F, 1.1863F, 2.7734F);
		Left_Leg14.addChild(Left_Leg15);
		

		Left_Leg15_r1 = new ModelRenderer(this);
		Left_Leg15_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Left_Leg15.addChild(Left_Leg15_r1);
		setRotationAngle(Left_Leg15_r1, 0.0F, -0.4111F, -3.127F);
		Left_Leg15_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, false);

		Right_Leg_3 = new ModelRenderer(this);
		Right_Leg_3.setRotationPoint(-2.6513F, -4.5362F, 8.3362F);
		Cave_Fisher.addChild(Right_Leg_3);
		setRotationAngle(Right_Leg_3, 0.0F, 0.8029F, 0.0F);
		

		Right_Leg_3_r1 = new ModelRenderer(this);
		Right_Leg_3_r1.setRotationPoint(0.5609F, 0.7046F, -1.1316F);
		Right_Leg_3.addChild(Right_Leg_3_r1);
		setRotationAngle(Right_Leg_3_r1, -0.3054F, -0.384F, 0.0F);
		Right_Leg_3_r1.setTextureOffset(8, 42).addBox(-1.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		Right_Leg16 = new ModelRenderer(this);
		Right_Leg16.setRotationPoint(0.5458F, 1.5945F, -4.8441F);
		Right_Leg_3.addChild(Right_Leg16);
		

		Right_Leg16_r1 = new ModelRenderer(this);
		Right_Leg16_r1.setRotationPoint(-2.668F, -2.9417F, 3.4921F);
		Right_Leg16.addChild(Right_Leg16_r1);
		setRotationAngle(Right_Leg16_r1, -3.0418F, -0.4201F, -0.7311F);
		Right_Leg16_r1.setTextureOffset(0, 24).addBox(-0.1875F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		Right_Leg17 = new ModelRenderer(this);
		Right_Leg17.setRotationPoint(-1.2986F, 0.153F, -0.2187F);
		Right_Leg16.addChild(Right_Leg17);
		

		Right_Leg17_r1 = new ModelRenderer(this);
		Right_Leg17_r1.setRotationPoint(-3.4041F, -2.7887F, 3.2734F);
		Right_Leg17.addChild(Right_Leg17_r1);
		setRotationAngle(Right_Leg17_r1, 0.2732F, 0.3983F, -2.2156F);
		Right_Leg17_r1.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, true);

		Right_leg18 = new ModelRenderer(this);
		Right_leg18.setRotationPoint(-4.5916F, 1.1863F, 2.7734F);
		Right_Leg17.addChild(Right_leg18);
		

		Right_Leg18_r1 = new ModelRenderer(this);
		Right_Leg18_r1.setRotationPoint(0.0F, -0.35F, 0.0F);
		Right_leg18.addChild(Right_Leg18_r1);
		setRotationAngle(Right_Leg18_r1, 0.0F, 0.4111F, 3.127F);
		Right_Leg18_r1.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, true);

		Left_Leg_4 = new ModelRenderer(this);
		Left_Leg_4.setRotationPoint(2.4013F, -4.5362F, 10.3362F);
		Cave_Fisher.addChild(Left_Leg_4);
		setRotationAngle(Left_Leg_4, 0.0F, -1.309F, 0.0F);
		

		Left_Leg_4_r1 = new ModelRenderer(this);
		Left_Leg_4_r1.setRotationPoint(-0.5609F, 0.7046F, -1.1316F);
		Left_Leg_4.addChild(Left_Leg_4_r1);
		setRotationAngle(Left_Leg_4_r1, -0.3054F, 0.384F, 0.0F);
		Left_Leg_4_r1.setTextureOffset(8, 42).addBox(-0.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Left_Leg_back_upper = new ModelRenderer(this);
		Left_Leg_back_upper.setRotationPoint(-0.4208F, 1.5945F, -5.8441F);
		Left_Leg_4.addChild(Left_Leg_back_upper);
		

		Left_Leg2 = new ModelRenderer(this);
		Left_Leg2.setRotationPoint(2.543F, -2.9417F, 4.4921F);
		Left_Leg_back_upper.addChild(Left_Leg2);
		setRotationAngle(Left_Leg2, -3.0418F, 0.4201F, 0.7311F);
		Left_Leg2.setTextureOffset(0, 24).addBox(-1.3125F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Left_Leg_back_mid = new ModelRenderer(this);
		Left_Leg_back_mid.setRotationPoint(1.2986F, 0.153F, -0.2187F);
		Left_Leg_back_upper.addChild(Left_Leg_back_mid);
		

		Left_Leg4 = new ModelRenderer(this);
		Left_Leg4.setRotationPoint(3.2791F, -2.7887F, 4.2734F);
		Left_Leg_back_mid.addChild(Left_Leg4);
		setRotationAngle(Left_Leg4, 0.2732F, -0.3983F, 2.2156F);
		Left_Leg4.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, false);

		Left_Leg_Lower_Back = new ModelRenderer(this);
		Left_Leg_Lower_Back.setRotationPoint(4.4666F, 1.1863F, 3.7734F);
		Left_Leg_back_mid.addChild(Left_Leg_Lower_Back);
		

		Left_Leg = new ModelRenderer(this);
		Left_Leg.setRotationPoint(0.0F, -0.35F, 0.0F);
		Left_Leg_Lower_Back.addChild(Left_Leg);
		setRotationAngle(Left_Leg, 0.0F, -0.4111F, -3.127F);
		Left_Leg.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, false);

		Right_Leg_4 = new ModelRenderer(this);
		Right_Leg_4.setRotationPoint(-2.4013F, -4.5362F, 10.3362F);
		Cave_Fisher.addChild(Right_Leg_4);
		setRotationAngle(Right_Leg_4, 0.0F, 1.309F, 0.0F);
		

		Right_Leg_4_r1 = new ModelRenderer(this);
		Right_Leg_4_r1.setRotationPoint(0.5609F, 0.7046F, -1.1316F);
		Right_Leg_4.addChild(Right_Leg_4_r1);
		setRotationAngle(Right_Leg_4_r1, -0.3054F, -0.384F, 0.0F);
		Right_Leg_4_r1.setTextureOffset(8, 42).addBox(-1.5F, -2.25F, -0.4375F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		Right_Leg_Back_Upper = new ModelRenderer(this);
		Right_Leg_Back_Upper.setRotationPoint(0.4208F, 1.5945F, -5.8441F);
		Right_Leg_4.addChild(Right_Leg_Back_Upper);
		

		Right_Leg_Back_Upper2 = new ModelRenderer(this);
		Right_Leg_Back_Upper2.setRotationPoint(-2.543F, -2.9417F, 4.4921F);
		Right_Leg_Back_Upper.addChild(Right_Leg_Back_Upper2);
		setRotationAngle(Right_Leg_Back_Upper2, -3.0418F, -0.4201F, -0.7311F);
		Right_Leg_Back_Upper2.setTextureOffset(0, 24).addBox(-0.1875F, -2.0F, -0.75F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		Right_Leg_Mid_Back = new ModelRenderer(this);
		Right_Leg_Mid_Back.setRotationPoint(-1.2986F, 0.153F, -0.2187F);
		Right_Leg_Back_Upper.addChild(Right_Leg_Mid_Back);
		

		Right_Leg_mig_Back = new ModelRenderer(this);
		Right_Leg_mig_Back.setRotationPoint(-3.2791F, -2.7887F, 4.2734F);
		Right_Leg_Mid_Back.addChild(Right_Leg_mig_Back);
		setRotationAngle(Right_Leg_mig_Back, 0.2732F, 0.3983F, -2.2156F);
		Right_Leg_mig_Back.setTextureOffset(0, 13).addBox(-0.75F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F, -0.2F, true);

		Right_Leg_Back_Lower = new ModelRenderer(this);
		Right_Leg_Back_Lower.setRotationPoint(-4.4666F, 1.1863F, 3.7734F);
		Right_Leg_Mid_Back.addChild(Right_Leg_Back_Lower);
		

		Right_Lower_Back_Leg = new ModelRenderer(this);
		Right_Lower_Back_Leg.setRotationPoint(0.0F, -0.35F, 0.0F);
		Right_Leg_Back_Lower.addChild(Right_Lower_Back_Leg);
		setRotationAngle(Right_Lower_Back_Leg, 0.0F, 0.4111F, 3.127F);
		Right_Lower_Back_Leg.setTextureOffset(19, 13).addBox(-0.75F, -2.3F, -0.75F, 1.0F, 5.0F, 1.0F, -0.3F, true);
	}

	@Override
	public void setRotationAngles(CaveFisher entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Cave_Fisher.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}