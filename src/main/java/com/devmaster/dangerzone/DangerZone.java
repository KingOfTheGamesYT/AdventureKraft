package com.devmaster.dangerzone;

import com.devmaster.dangerzone.core.init.BlockInit;
import com.devmaster.dangerzone.core.init.CreativeModeTabInit;
import com.devmaster.dangerzone.core.init.ItemInit;
import lombok.val;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DangerZone.MOD_ID)
public class DangerZone {
    public static final String MOD_ID = "dangerzone";
    public static final Logger logger = LogManager.getLogger(MOD_ID);
    
    public DangerZone() {
        val modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register registries
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(modEventBus);
    }
}
