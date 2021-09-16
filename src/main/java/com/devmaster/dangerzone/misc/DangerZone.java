package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.client.render.*;
import com.devmaster.dangerzone.creative_tabs.*;
import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.util.RegistryHandler;
import com.devmaster.dangerzone.world.gen.ModOregen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("dangerzone")
public class DangerZone {
    public static final Logger LOGGER = LogManager.getLogger("DangerZone");
    public static final String MOD_ID = "dangerzone";
    public static final ItemGroup TAB = new DangerZoneItems();
    public static final ItemGroup  ARMOR = new DangerZoneArmory();
    public static final ItemGroup  WEAPONS = new DangerZoneWeapons();
    public static final ItemGroup  TOOLS = new DangerZoneTools();
    public static final ItemGroup  BLOCKS = new DangerZoneBlocks();
    public static final ItemGroup  PETRIFIED_ORES = new DangerZonePetrifiedOres();
    public static final ItemGroup  FOOD = new DangerZoneFood();




    public static final ITag.INamedTag<Block> MINERS_DREAM_MINEABLE = BlockTags.makeWrapperTag(DangerZone.MOD_ID+":breakable");

    public DangerZone() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DZConfig.BUILDER.build());

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
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(RegistryHandler.TEWTIY.get(), Tewtiy.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.STAMPYLONGNOSE.get(), StampyLongNose.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.NOTBREEBREE.get(), NotBreeBree.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.REDROSEWARRIOR.get(), RedRoseWarrior.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.RAINBOWANT.get(), RainbowAnt.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.BUTTERFLY.get(), Butterfly.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.ENT.get(), Ent.getAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.CAVE_FISHER.get(), CaveFisher.getAttributes().create());

        });
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.STICKY_BLOCK.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.TEWTIY.get(), TewtiyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.STAMPYLONGNOSE.get(), StampyLongNoseRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.NOTBREEBREE.get(), NotBreeBreeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.REDROSEWARRIOR.get(), RedRoseWarriorRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.RAINBOWANT.get(), RainbowAntRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BUTTERFLY.get(), ButterflyRender::new);
        RenderTypeLookup.setRenderLayer(RegistryHandler.KYANITE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CRYSTAL_GRASS .get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.ENT.get(), EntRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.CAVE_FISHER.get(), CaveFisherRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.WATER_PROJECTILE.get(), WaterProjectileRender::new);


    }

}



