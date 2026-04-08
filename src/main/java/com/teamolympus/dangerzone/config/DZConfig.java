package com.teamolympus.dangerzone.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class DZConfig {

  //   public static String[] bannedBlocksStrings = new String[]{};

    public static int krakenHurtTimer = 30;
    public static int pizzaFoodLevels = 4;
    public static float pizzaSatLevels = 0.2F;

    static final String MOB_CATEGORY = "MOB_CONFIGURATION";
    static final String PIZZA_CATEGORY = "PIZZA_CONFIGURATION";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

      //    bannedBlocksStrings = configuration.getStringList("Miner's Dream Breakable Blocks", "Items", new String[]{""}, "The class Name of the Block");

        /**
        krakenHurtTimer = configuration.getInt(MOB_CATEGORY, "Kraken Hurt Timer", 30, 1 , Integer.MAX_VALUE, "The amount of ticks the Kraken is immune to being hit.");

        pizzaFoodLevels = configuration.getInt(PIZZA_CATEGORY, "Pizza Food levels", 4, 1 , 20, "The amount of hunger given when a slice of pizza is eaten.");

        pizzaSatLevels = configuration.getFloat(PIZZA_CATEGORY, "Pizza Food levels", 0.2F, 0.1F , 20, "The amount of saturation given when a slice of pizza is eaten.");

         **/
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

}
