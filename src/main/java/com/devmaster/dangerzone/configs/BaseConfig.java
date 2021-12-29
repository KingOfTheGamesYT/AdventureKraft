package com.devmaster.dangerzone.configs;

import com.devmaster.dangerzone.configs.DZConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig.Loading;
import net.minecraftforge.fml.config.ModConfig.Reloading;

@EventBusSubscriber
public class BaseConfig {
    private static final Builder COMMON_BUILDER = new Builder();
    public static final ForgeConfigSpec COMMON;

    public BaseConfig() {
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        CommentedFileConfig configData = (CommentedFileConfig)CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        config.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(Loading configEvent) {
    }

    @SubscribeEvent
    public static void onReload(Reloading configEvent) {
    }

    static {
        DZConfig.COMMON(COMMON_BUILDER);
        COMMON = COMMON_BUILDER.build();
    }
}
