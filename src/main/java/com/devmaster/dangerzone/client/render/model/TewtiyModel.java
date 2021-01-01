package com.devmaster.dangerzone.client.render.model;
// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.Tewtiy;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.function.Consumer;

public class TewtiyModel<T  extends Tewtiy> extends BipedModel<T> {

public TewtiyModel(float modelSize) {
		super(modelSize, 0.0F, 64, 64);

		// eyes

		bipedHead.setTextureOffset(15, 33).addBox(-3.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, modelSize);
		bipedHead.setTextureOffset(15, 33).addBox(1.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, modelSize);

		// chest

		bipedBody.setTextureOffset(0, 33).addBox(-1.0F, 1.0F, -2.0F, 4.0F, 4.0F, 3.0F, modelSize);

		// arms

		bipedLeftArm = new ModelRenderer(this, 32, 48);
		bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSize);
		bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
		bipedLeftArm.mirror = true;

		bipedRightArm = new ModelRenderer(this, 40, 16);
		bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSize);
		bipedRightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);

		// legs

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 2.0F);
		bipedLeftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 2.0F);
		bipedRightLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		}

public ModelRenderer getBodyModel() {
		return this.bipedBody;
		}

@Override
public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
}

		}
