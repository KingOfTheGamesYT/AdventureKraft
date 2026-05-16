package com.teamolympus.dangerzone.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

@SuppressWarnings("all")
@SideOnly(Side.CLIENT)
public class HydroliscModel extends ModelBase {
	private final ModelRenderer hydrolisc;
	private final ModelRenderer torso;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer headthings;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer backthingsf;
	private final ModelRenderer btfr;
	private final ModelRenderer btfl;
	private final ModelRenderer backthingsm;
	private final ModelRenderer btmr;
	private final ModelRenderer btml;
	private final ModelRenderer backthingsb;
	private final ModelRenderer btbr;
	private final ModelRenderer btbl;
	private final ModelRenderer legsf;
	private final ModelRenderer legsfr;
	private final ModelRenderer legsfl;
	private final ModelRenderer legsb;
	private final ModelRenderer legsbr;
	private final ModelRenderer legsbl;

	public HydroliscModel() {
		textureWidth = 64;
		textureHeight = 64;

		hydrolisc = new ModelRenderer(this);
		hydrolisc.setRotationPoint(0.0F, 24.0F, 0.0F);


		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -6.0F, 3.0F);
		hydrolisc.addChild(torso);
		torso.cubeList.add(new ModelBox(torso, 0, 6, -2.0F, -1.0F, -7.0F, 4, 4, 5, 0.0F));
		torso.cubeList.add(new ModelBox(torso, 18, 6, -2.0F, -1.0F, -2.0F, 4, 3, 3, 0.0F));

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, -6.0F);
		torso.addChild(neck);
		neck.cubeList.add(new ModelBox(neck, 0, 24, -1.0F, -3.0F, -2.0F, 2, 4, 3, -0.01F));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.5F, -0.5F);
		neck.addChild(head);
		head.cubeList.add(new ModelBox(head, 0, 15, -1.0F, -1.5F, -4.5F, 2, 3, 6, 0.0F));

		headthings = new ModelRenderer(this);
		headthings.setRotationPoint(0.0F, -1.5F, 1.5F);
		head.addChild(headthings);
		headthings.cubeList.add(new ModelBox(headthings, 0, 0, -3.0F, 0.0F, 0.0F, 6, 0, 6, 0.0F));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 1.0F);
		torso.addChild(tail);
		tail.cubeList.add(new ModelBox(tail, 16, 15, -1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 5.0F);
		tail.addChild(tail2);
		tail2.cubeList.add(new ModelBox(tail2, 16, 22, 0.0F, -2.0F, 2.0F, 0, 4, 5, 0.0F));
		tail2.cubeList.add(new ModelBox(tail2, 16, 15, -1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F));

		backthingsf = new ModelRenderer(this);
		backthingsf.setRotationPoint(0.0F, -1.0F, -3.0F);
		torso.addChild(backthingsf);


		btfr = new ModelRenderer(this);
		btfr.setRotationPoint(-1.5F, 0.0F, 0.0F);
		backthingsf.addChild(btfr);
		btfr.cubeList.add(new ModelBox(btfr, 24, 0, -1.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		btfl = new ModelRenderer(this);
		btfl.setRotationPoint(1.5F, 0.0F, 0.0F);
		backthingsf.addChild(btfl);
		btfl.cubeList.add(new ModelBox(btfl, 24, 0, -0.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		backthingsm = new ModelRenderer(this);
		backthingsm.setRotationPoint(0.0F, -1.0F, -1.0F);
		torso.addChild(backthingsm);


		btmr = new ModelRenderer(this);
		btmr.setRotationPoint(-1.5F, 0.0F, 0.0F);
		backthingsm.addChild(btmr);
		btmr.cubeList.add(new ModelBox(btmr, 24, 0, -1.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		btml = new ModelRenderer(this);
		btml.setRotationPoint(1.5F, 0.0F, 0.0F);
		backthingsm.addChild(btml);
		btml.cubeList.add(new ModelBox(btml, 24, 0, -0.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		backthingsb = new ModelRenderer(this);
		backthingsb.setRotationPoint(0.0F, -1.0F, 1.0F);
		torso.addChild(backthingsb);


		btbr = new ModelRenderer(this);
		btbr.setRotationPoint(-1.5F, 0.0F, 0.0F);
		backthingsb.addChild(btbr);
		btbr.cubeList.add(new ModelBox(btbr, 24, 0, -1.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		btbl = new ModelRenderer(this);
		btbl.setRotationPoint(1.5F, 0.0F, 0.0F);
		backthingsb.addChild(btbl);
		btbl.cubeList.add(new ModelBox(btbl, 24, 0, -0.5F, -4.0F, 0.0F, 2, 4, 0, 0.0F));

		legsf = new ModelRenderer(this);
		legsf.setRotationPoint(0.0F, 1.0F, -6.0F);
		torso.addChild(legsf);


		legsfr = new ModelRenderer(this);
		legsfr.setRotationPoint(-2.0F, 0.0F, 0.0F);
		legsf.addChild(legsfr);
		legsfr.cubeList.add(new ModelBox(legsfr, 30, 12, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.01F));
		legsfr.cubeList.add(new ModelBox(legsfr, 0, 31, 0.0F, -1.0F, 1.0F, 0, 6, 2, 0.0F));

		legsfl = new ModelRenderer(this);
		legsfl.setRotationPoint(2.0F, 0.0F, 0.0F);
		legsf.addChild(legsfl);
		legsfl.cubeList.add(new ModelBox(legsfl, 30, 12, -1.0F, -1.0F, -1.0F, 2, 6, 2, -0.01F));
		legsfl.cubeList.add(new ModelBox(legsfl, 0, 31, 0.0F, -1.0F, 1.0F, 0, 6, 2, -0.01F));

		legsb = new ModelRenderer(this);
		legsb.setRotationPoint(0.0F, -6.0F, 3.0F);
		hydrolisc.addChild(legsb);


		legsbr = new ModelRenderer(this);
		legsbr.setRotationPoint(-2.0F, 0.0F, 0.0F);
		legsb.addChild(legsbr);
		legsbr.cubeList.add(new ModelBox(legsbr, 26, 22, -1.0F, -1.0F, -1.0F, 2, 7, 2, -0.01F));
		legsbr.cubeList.add(new ModelBox(legsbr, 10, 24, 0.0F, -1.0F, 1.0F, 0, 7, 2, -0.01F));

		legsbl = new ModelRenderer(this);
		legsbl.setRotationPoint(2.0F, 0.0F, 0.0F);
		legsb.addChild(legsbl);
		legsbl.cubeList.add(new ModelBox(legsbl, 26, 22, -1.0F, -1.0F, -1.0F, 2, 7, 2, -0.01F));
		legsbl.cubeList.add(new ModelBox(legsbl, 10, 24, 0.0F, -1.0F, 1.0F, 0, 7, 2, -0.01F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		hydrolisc.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
