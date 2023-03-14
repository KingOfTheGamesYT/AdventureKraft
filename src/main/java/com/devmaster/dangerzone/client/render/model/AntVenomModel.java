package com.devmaster.dangerzone.client.render.model;
// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.AlexiCraft;
import com.devmaster.dangerzone.entity.AntVenom;
import net.minecraft.client.renderer.entity.model.BipedModel;


public class AntVenomModel<T  extends AntVenom> extends BipedModel<T> {
	public AntVenomModel(float modelSize, boolean hasSmallTexture) {
		super(modelSize, 0, 64, hasSmallTexture ? 64 : 32);
	}
}