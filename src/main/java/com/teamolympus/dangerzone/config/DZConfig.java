package com.teamolympus.dangerzone.config;

import java.io.File;
import java.util.*;

import com.teamolympus.dangerzone.misc.DZLogger;
import net.minecraftforge.common.config.Configuration;

public class DZConfig {

    private static String[] bannedBlocksStringsDefault = new String[] {
            "minecraft:stone", "minecraft:dirt", "minecraft:grass", "minecraft:sand", "minecraft:sandstone",
            "minecraft:water", "minecraft:lava", "minecraft:flowing_water", "minecraft:flowing_lava",
            "minecraft:gravel", "minecraft:netherrack", "minecraft:end_stone"
    };
    public static String[] bannedBlocksStrings = new String[] {
            "minecraft:stone", "minecraft:dirt", "minecraft:grass", "minecraft:sand", "minecraft:sandstone",
            "minecraft:water", "minecraft:lava", "minecraft:flowing_water", "minecraft:flowing_lava",
            "minecraft:gravel", "minecraft:netherrack", "minecraft:end_stone"
    };

    public static String[] finalMinerDreamList;
    public static int minerDreamFlag;

    public static List<String> bannedBlockListAPI = new ArrayList<>(512);

    public static int krakenHurtTimer = 30;
    public static int pizzaFoodLevels = 4;
    public static float pizzaSatLevels = 0.2F;

    public static final double mantisAttackDamage = 6.0D;
    public static final double mantisSpeed = 0.319D;
    public static final double mantisMaxHp = 120;

  //public static int minerX;
  //  public static int minerY;
  //  public static int minerZ;

    static final String MOB_CATEGORY = "MOB_CONFIGURATION";
    static final String PIZZA_CATEGORY = "PIZZA_CONFIGURATION";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        configuration.load();

        bannedBlocksStrings = configuration.getStringList("Miner Dream Category", "Miner dream breakable Block list", bannedBlocksStringsDefault, "In class or unlocalized name format.");
      //  minerX = configuration.getInt("Miner Dream Z Search", "Miner Dream Category", 50, Integer.MIN_VALUE, Integer.MAX_VALUE, "How deep on the Z axis will the miner's dream search?");
     //   minerY = configuration.getInt("Miner Dream Y Search", "Miner Dream Category", 5, Integer.MIN_VALUE, Integer.MAX_VALUE, "How deep on the Y axis will the miner's dream search?");
     //   minerX = configuration.getInt("Miner Dream X Search", "Miner Dream Category", 5, Integer.MIN_VALUE, Integer.MAX_VALUE, "(Added by 5)How deep on the X axis will the miner's dream search?");
        /**
        krakenHurtTimer = configuration.getInt(MOB_CATEGORY, "Kraken Hurt Timer", 30, 1 , Integer.MAX_VALUE, "The amount of ticks the Kraken is immune to being hit.");

        pizzaFoodLevels = configuration.getInt(PIZZA_CATEGORY, "Pizza Food levels", 4, 1 , 20, "The amount of hunger given when a slice of pizza is eaten.");

        pizzaSatLevels = configuration.getFloat(PIZZA_CATEGORY, "Pizza Food levels", 0.2F, 0.1F , 20, "The amount of saturation given when a slice of pizza is eaten.");

         mantisAttackDamage = configuration.getFloat(MOB_CATEGORY, "Mantis Attack Damage", 6.0f, 1.0f, 9000, "The Attack damage of the Mantis");

         mantisSpeed = configuration.getFloat(MOB_CATEGORY, "Mantis Speed", 0.319f, 0.1f, 9000, "The Movement Speed of the Mantis");

         mantisMaxHp = configuration.getFloat(MOB_CATEGORY, "Mantis HP", 120f, 1f, 9000, "The HP of the Mantis");
         **/

        minerDreamFlag = configuration.getInt("Miner dream flags", "Miner Dream Category", 2,2,3,"2 causes some minor bugs but is faster. 3 causes block updates but fixes bugs.", "en_us");





        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    public static void mergeConfigAPIListMinerDream() {
         Collections.addAll(bannedBlockListAPI, bannedBlocksStrings);
        finalMinerDreamList = bannedBlockListAPI.toArray(new String[0]);

        DZLogger.debug("Merged config and API list for Miner's dream.");

        bannedBlockListAPI.clear();
        bannedBlocksStrings = new String[0];
        bannedBlocksStringsDefault = new String[0];
    }

}
