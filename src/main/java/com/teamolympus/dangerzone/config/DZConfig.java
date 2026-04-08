package com.teamolympus.dangerzone.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class DZConfig {

  //   public static String[] bannedBlocksStrings = new String[]{};

    public static int krakenHurtTimer = 30;
    public static int pizzaFoodLevels = 4;
    public static float pizzaSatLevels = 0.2F;

    public static final double mantisAttackDamage = 6.0D;
    public static final double mantisSpeed = 0.319D;
    public static final double mantisMaxHp = 120;

    static final String MOB_CATEGORY = "MOB_CONFIGURATION";
    static final String PIZZA_CATEGORY = "PIZZA_CONFIGURATION";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

      //    bannedBlocksStrings = configuration.getStringList("Miner's Dream Breakable Blocks", "Items", new String[]{""}, "The class Name of the Block");

        /**
        krakenHurtTimer = configuration.getInt(MOB_CATEGORY, "Kraken Hurt Timer", 30, 1 , Integer.MAX_VALUE, "The amount of ticks the Kraken is immune to being hit.");

        pizzaFoodLevels = configuration.getInt(PIZZA_CATEGORY, "Pizza Food levels", 4, 1 , 20, "The amount of hunger given when a slice of pizza is eaten.");

        pizzaSatLevels = configuration.getFloat(PIZZA_CATEGORY, "Pizza Food levels", 0.2F, 0.1F , 20, "The amount of saturation given when a slice of pizza is eaten.");

         mantisAttackDamage = configuration.getFloat(MOB_CATEGORY, "Mantis Attack Damage", 6.0f, 1.0f, 9000, "The Attack damage of the Mantis");

         mantisSpeed = configuration.getFloat(MOB_CATEGORY, "Mantis Speed", 0.319f, 0.1f, 9000, "The Movement Speed of the Mantis");

         mantisMaxHp = configuration.getFloat(MOB_CATEGORY, "Mantis HP", 120f, 1f, 9000, "The HP of the Mantis");
         **/





        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

}
