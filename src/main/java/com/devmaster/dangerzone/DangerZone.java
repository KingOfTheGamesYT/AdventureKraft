package com.devmaster.dangerzone;

import com.devmaster.dangerzone.util.RegistryHandler;
import com.devmaster.dangerzone.world.gen.ModOregen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("dangerzone")
public class DangerZone {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "dangerzone";

    public DangerZone() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, EventPriority.LOW, ModOregen::addConfigFeatures);

        MinecraftForge.EVENT_BUS.addListener(ModOregen::handleWorldGen);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("dangerzonetab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.AMETHYST.get());
        }
    };
    public static final ItemGroup BLOCKS = new ItemGroup("dangerzoneblocks") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.AMETHYST_BLOCK.get());
        }
    };
    public static final ItemGroup TOOLS = new ItemGroup("dangerzonetools") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.AMETHYST_AXE.get());
        }
    };
    public static final ItemGroup WEAPONS = new ItemGroup("dangerzoneweapons") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.AMETHYST_SWORD.get());
        }
    };
    public static final ItemGroup FOOD = new ItemGroup("dangerzonefood") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.FIRE_FISH.get());
        }
    };
    public static final ItemGroup ARMOR = new ItemGroup("dangerzonearmory") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.AMETHYST_CHESTPLATE.get());
        }
    };
}


