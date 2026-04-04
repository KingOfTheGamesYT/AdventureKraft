package com.teamolympus.dangerzone.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class DZConfig {

  //   public static String[] bannedBlocksStrings = new String[]{};

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

      //    bannedBlocksStrings = configuration.getStringList("Miner's Dream Breakable Blocks", "Items", new String[]{""}, "The class Name of the Block");



        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

}
