package com.devmaster.dangerzone.client.render.model;
// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.devmaster.dangerzone.entity.BabyAngel;
import com.devmaster.dangerzone.entity.BabyDuck;
import net.minecraft.client.renderer.entity.model.BipedModel;


public class BabyDuckModel<T  extends BabyDuck> extends BipedModel<T> {
	public BabyDuckModel(float modelSize, boolean hasSmallTexture) {
		super(modelSize, 0, 64, hasSmallTexture ? 64 : 32);
	}
}