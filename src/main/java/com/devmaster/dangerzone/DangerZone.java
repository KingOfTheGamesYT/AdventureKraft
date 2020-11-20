package com.devmaster.dangerzone;

import com.devmaster.dangerzone.init.Blocks;
import com.devmaster.dangerzone.init.DangerZoneConfig;
import com.devmaster.dangerzone.init.Items;
import com.devmaster.dangerzone.world.gen.WorldGenOres;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.devmaster.dangerzone.DangerZone.MODID;

@Mod(value = MODID)
public class DangerZone {
    public static final String MODID = "dangerzone";

        public static boolean debug;


        public static DangerZoneConfig config;

        public DangerZone() {

            debug = true;

            setupConfig();
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::finishLoading);
            MinecraftForge.EVENT_BUS.register(this);

        }

        private void setup(final FMLCommonSetupEvent event) {
          //  CalendarUtils.dayCheck();
            WorldGenOres.setupOreGen();
        }

        private void clientSetup(final FMLClientSetupEvent event) {
          //  DangerZoneBlocks.setRenderLayers();
           // DangerZoneEntities.registerEntityRenders();
          // DangerZoneContainerTypes.registerScreens();
        }

        private void finishLoading(final FMLLoadCompleteEvent event) {

        }

        private void setupConfig() {
            ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

            config = new DangerZoneConfig(configBuilder);

            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configBuilder.build(), MODID + ".toml");
        }

    public static final ItemGroup TAB = new ItemGroup("dangerzonetab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.AMETHYST.getItem());
        }
    };

        public static final ItemGroup PETRIFIED_ORES = new ItemGroup("dangerzonepetrified_ores") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.MULE_EGG_ORE);
        }
    };
}
//}
