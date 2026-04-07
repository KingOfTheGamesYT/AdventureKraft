package com.teamolympus.dangerzone.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class DZConfig {

  //   public static String[] bannedBlocksStrings = new String[]{};

    public static int KrakenHurtTimer;

    static final String MOB_CATAGORY = "MOB_CONFIGURATION";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

      //    bannedBlocksStrings = configuration.getStringList("Miner's Dream Breakable Blocks", "Items", new String[]{""}, "The class Name of the Block");

        KrakenHurtTimer = configuration.getInt(MOB_CATAGORY, "Kraken Hurt Timer", 30, 1 , Integer.MAX_VALUE, "The amount of ticks the Kraken is immune to being hit.");


        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

}
