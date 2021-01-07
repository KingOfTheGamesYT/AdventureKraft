package com.devmaster.dangerzone.misc;

import net.minecraftforge.common.ForgeConfigSpec;

public class DZConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final CategoryMisc misc = new CategoryMisc(BUILDER);
    public static final ForgeConfigSpec spec = BUILDER.build();

    public static class CategoryMisc {

        public final ForgeConfigSpec.ConfigValue<Integer> tewtiySpawnWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> stampylongnoseSpawnWeight;

        public CategoryMisc(ForgeConfigSpec.Builder builder) {

            builder.push("Misc");

            tewtiySpawnWeight = builder.comment("Tewtiy Spawn Weight", "The higher the value is, the more frequent it spawns.").defineInRange("tewtiySpawnWeight", 1, 1, 256);
            stampylongnoseSpawnWeight = builder.comment("StampyLongNose Spawn Weight", "The higher the value is, the more frequent it spawns.").defineInRange("stampylongnoseSpawnWeight", 1, 1, 256);

            builder.pop();
        }
    }
}
