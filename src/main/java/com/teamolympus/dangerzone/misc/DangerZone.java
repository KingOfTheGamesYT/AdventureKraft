package com.teamolympus.dangerzone.misc;

import com.teamolympus.dangerzone.config.DZConfig;
import com.teamolympus.dangerzone.proxy.CommonProxy;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import com.teamolympus.dangerzone.tabs.AKBlocksTab;
import com.teamolympus.dangerzone.tabs.AKFoodTab;
import com.teamolympus.dangerzone.tabs.AKPetOresTab;
import com.teamolympus.dangerzone.tabs.AKToolsTab;

@Mod(
    modid = DangerZone.MODID,
    version = DangerZone.VERSION,
    name = "AdventureKraft",
    acceptedMinecraftVersions = "[1.7.10]"
)
public class DangerZone {

    @Mod.Instance("dangerzone")
    public static DangerZone INSTANCE;

    public static final String MODID = "dangerzone";
    public static final Logger LOG = LogManager.getLogger(MODID);

    public static final boolean isAbleToLoader18Skin = Loader.isModLoaded("skinport");

    public static final CreativeTabs FOOD = new AKFoodTab();
    public static final CreativeTabs TOOLS = new AKToolsTab();
    public static final CreativeTabs BLOCKS = new AKBlocksTab();
    public static final CreativeTabs PETRIFIED = new AKPetOresTab();

    public static final String VERSION = "0.3-dev";

    public static final String MODID_PREFIX = MODID + ":";

    public static final String SPAWING_PREFIX = MODID + ".";

    public static final String PETRIFIED_PREFIX = MODID_PREFIX + "fossils/";

    public static final String TOOL_PREFIX = MODID_PREFIX + "tools/";
    public static final String TOOL_MISC_PREFIX = MODID_PREFIX + "tools/misc/";

    public static final String FOOD_PREFIX = MODID_PREFIX + "food/";

    public static final String SPAWN_EGG_PREFIX = MODID_PREFIX + "eggs/";

    public static final String ROCK_PREFIX =MODID_PREFIX + "rock/";

    public static final String MAT_PREFIX = MODID_PREFIX + "materials/";

    public static final String SPECIAL_PREFIX = MODID_PREFIX + "special/";

    public static final String ENTITY_PREFIX = "textures/entity/";

    public static final String ENTITY_PREFIX_HOSTILE = "textures/entity/hostile/";

    public static final String ENTITY_PREFIX_PEACEFUL = "textures/entity/peaceful/";

    private static final String ENTITY_PREFIX_GUARDS_PEACEFUL = "textures/entity/peaceful/guards/";

    public static final String ENTITY_PREFIX_MALE_GUARDS_PEACEFUL = ENTITY_PREFIX_GUARDS_PEACEFUL + "male/";

    public static final String ENTITY_PREFIX_FEMALE_GUARDS_PEACEFUL = ENTITY_PREFIX_GUARDS_PEACEFUL + "female/";

    public static final int TEXTURE_DW = 22;
    public static final String VARIANT = "Variant";

    @SidedProxy(
        clientSide = "com.teamolympus.dangerzone.proxy.ClientProxy",
        serverSide = "com.teamolympus.dangerzone.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        DZConfig.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        RegistryHandler.initPre();
        proxy.clientRegistry();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
    }
}
