package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.world.gen.BiomeDictionaryHelper;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import static net.minecraftforge.common.BiomeDictionary.Type.*;

import java.util.Arrays;
import java.util.List;


public class DZConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final Spawn SPAWN = new Spawn(BUILDER);


    public static class Spawn {
        public final ForgeConfigSpec.IntValue NotBreeBreemin;
        public final ForgeConfigSpec.IntValue NotBreeBreemax;
        public final ForgeConfigSpec.IntValue NotBreeBreeweight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> NotBreeBreeinclude;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> NotBreeBreeexclude;
        public final ForgeConfigSpec.IntValue StampyLongNosemin;
        public final ForgeConfigSpec.IntValue StampyLongNosemax;
        public final ForgeConfigSpec.IntValue StampyLongNoseweight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> StampyLongNoseinclude;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> StampyLongNoseexclude;
        public final ForgeConfigSpec.IntValue Tewitymin;
        public final ForgeConfigSpec.IntValue Tewitymax;
        public final ForgeConfigSpec.IntValue Tewityweight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> Tewityinclude;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> Tewityexclude;
        public final ForgeConfigSpec.IntValue Entmin;
        public final ForgeConfigSpec.IntValue Entmax;
        public final ForgeConfigSpec.IntValue Entweight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> Entinclude;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> Entexclude;

        Spawn(ForgeConfigSpec.Builder builder) {
            builder.push("spawn chances");
            builder.comment("Configure youtubers spawn weight & min/max group size. Set weight to 0 to disable.");
            NotBreeBreemin = builder.defineInRange("NotBreeBree Min", 1, 0, 64);
            NotBreeBreemax = builder.defineInRange("NotBreeBree Max", 4, 0, 64);
            NotBreeBreeweight = builder.defineInRange("NotBreeBree Weight", 7, 0, 100);
            StampyLongNosemin = builder.defineInRange("StampyLongNose Min", 1, 0, 64);
            StampyLongNosemax = builder.defineInRange("StampyLongNose Max", 4, 0, 64);
            StampyLongNoseweight = builder.defineInRange("StampyLongNose Weight", 7, 0, 100);
            Tewitymin = builder.defineInRange("Tewity Min", 1, 0, 64);
            Tewitymax = builder.defineInRange("Tewity Max", 4, 0, 64);
            Tewityweight = builder.defineInRange("Tewity Weight", 7, 0, 100);
            Entmin = builder.defineInRange("Ent Min", 1, 0, 64);
            Entmax = builder.defineInRange("Ent Max", 4, 0, 64);
            Entweight = builder.defineInRange("Ent Weight", 7, 0, 100);
            builder.pop();

            builder.push("spawnable biomes");
            StampyLongNoseinclude = builder.defineList("include Stampy", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            StampyLongNoseexclude = builder.defineList("exclude Stampy", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Tewityexclude = builder.defineList("include Tewity", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Tewityinclude = builder.defineList("exclude Tewity", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            NotBreeBreeinclude = builder.defineList("include NotBreeBree", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            NotBreeBreeexclude = builder.defineList("exclude NotBreeBree", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Entinclude = builder.defineList("include Ent", Arrays.asList( MOUNTAIN.toString(), FOREST.toString(), SAVANNA.toString(), SWAMP.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Entexclude = builder.defineList("exclude Ent", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();


        }

        public static final ForgeConfigSpec spec = BUILDER.build();

    }
}

