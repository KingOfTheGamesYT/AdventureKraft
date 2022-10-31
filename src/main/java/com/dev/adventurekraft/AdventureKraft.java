package com.dev.adventurekraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;

@Mod(modid = "dangerzone", name = "AdventureKraft", version = "@VERSION@", useMetadata = true)
public class AdventureKraft {


	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e) {
	}


	@ForgeSubscribe
	public void onRenderPlayerPost(RenderPlayerEvent.Specials.Post e) {

	}

}

