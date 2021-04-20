package net.Akio.CraftZone.Main;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.Akio.CraftZone.Main.Tools.Emerald_Pickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemTool;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = CraftZone.MOD_ID, version = CraftZone.MC_VERSION)

public class CraftZone {

	public static final String MOD_AUTHOR = "Katara";
	public static final String MOD_CODER = "Akio";
    public static final String MOD_ID = "CraftZone";
    public static final String MC_VERSION = "1.7.10";
    public static final double MOD_VERSION = 0.1;
	 
    public static ItemPickaxe emerald_pickaxe;
    

    public void preInit(FMLPreInitializationEvent event) {
    	emerald_pickaxe = new Emerald_Pickaxe().setUnlocalizedName("EmeraldPickaxe").setTextureName("CZ:emerald_pickaxe");
        GameRegistry.registerItem(emerald_pickaxe, emerald_pickaxe.getUnlocalizedName().substring(5));
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
    
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
   
}
