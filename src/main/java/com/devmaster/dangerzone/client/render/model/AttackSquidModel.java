package com.devmaster.dangerzone.client.render.model;//Made with Blockbench
//Paste this code into your mod.

import com.devmaster.dangerzone.entity.AttackSquid;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class AttackSquidModel<t> extends EntityModel<AttackSquid> {
	private float wingspeed = 1.0F;
	private final ModelRenderer HeadBody;
	private final ModelRenderer Fin1;
	private final ModelRenderer Fin2;
	private final ModelRenderer TentacleLeft1;
	private final ModelRenderer TentacleLeft2;
	private final ModelRenderer TentacleLeft3;
	private final ModelRenderer TentacleRight1;
	private final ModelRenderer TentacleRight2;
	private final ModelRenderer TentacleRight3;
	private final ModelRenderer TentacleFront1;
	private final ModelRenderer TentacleFront2;
	private final ModelRenderer TentacleBack1;
	private final ModelRenderer TentacleBack2;

	public AttackSquidModel() {
		textureWidth = 128;
		textureHeight = 128;

		HeadBody = new ModelRenderer(this);
		HeadBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		HeadBody.setTextureOffset(0, 40).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);
		HeadBody.setTextureOffset(0, 55).addBox(-2.0F, -15.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		HeadBody.setTextureOffset(6, 58).addBox(-1.0F, -19.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Fin1 = new ModelRenderer(this);
		Fin1.setRotationPoint(-2.0F, -12.5F, 0.5F);
		HeadBody.addChild(Fin1);
		Fin1.setTextureOffset(7, 58).addBox(-2.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		Fin2 = new ModelRenderer(this);
		Fin2.setRotationPoint(2.0F, -12.5F, 0.5F);
		HeadBody.addChild(Fin2);
		Fin2.setTextureOffset(8, 56).addBox(0.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		TentacleLeft1 = new ModelRenderer(this);
		TentacleLeft1.setRotationPoint(3.0F, 0.0F, -2.5F);
		HeadBody.addChild(TentacleLeft1);
		TentacleLeft1.setTextureOffset(18, 46).addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleLeft2 = new ModelRenderer(this);
		TentacleLeft2.setRotationPoint(3.0F, 0.0F, -0.5F);
		HeadBody.addChild(TentacleLeft2);
		TentacleLeft2.setTextureOffset(34, 49).addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleLeft3 = new ModelRenderer(this);
		TentacleLeft3.setRotationPoint(3.0F, 0.0F, 1.5F);
		HeadBody.addChild(TentacleLeft3);
		TentacleLeft3.setTextureOffset(31, 61).addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleRight1 = new ModelRenderer(this);
		TentacleRight1.setRotationPoint(-3.0F, 0.0F, -2.5F);
		HeadBody.addChild(TentacleRight1);
		TentacleRight1.setTextureOffset(23, 43).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleRight2 = new ModelRenderer(this);
		TentacleRight2.setRotationPoint(-3.0F, 0.0F, -0.5F);
		HeadBody.addChild(TentacleRight2);
		TentacleRight2.setTextureOffset(22, 48).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleRight3 = new ModelRenderer(this);
		TentacleRight3.setRotationPoint(-3.0F, 0.0F, 1.5F);
		HeadBody.addChild(TentacleRight3);
		TentacleRight3.setTextureOffset(26, 54).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleFront1 = new ModelRenderer(this);
		TentacleFront1.setRotationPoint(1.5F, 0.0F, -3.0F);
		HeadBody.addChild(TentacleFront1);
		TentacleFront1.setTextureOffset(41, 62).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleFront2 = new ModelRenderer(this);
		TentacleFront2.setRotationPoint(-1.5F, 0.0F, -3.0F);
		HeadBody.addChild(TentacleFront2);
		TentacleFront2.setTextureOffset(48, 60).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleBack1 = new ModelRenderer(this);
		TentacleBack1.setRotationPoint(1.5F, 0.0F, 3.0F);
		HeadBody.addChild(TentacleBack1);
		TentacleBack1.setTextureOffset(27, 50).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		TentacleBack2 = new ModelRenderer(this);
		TentacleBack2.setRotationPoint(-1.5F, 0.0F, 3.0F);
		HeadBody.addChild(TentacleBack2);
		TentacleBack2.setTextureOffset(11, 66).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(AttackSquid entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		TentacleFront1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleFront2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleBack1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleBack2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleLeft1.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleLeft2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleLeft3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleRight1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleRight2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		TentacleRight3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}



	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		HeadBody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}