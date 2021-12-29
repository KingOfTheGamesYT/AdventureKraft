package com.devmaster.dangerzone.configs;

import com.devmaster.dangerzone.world.gen.BiomeDictionaryHelper;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import static net.minecraftforge.common.BiomeDictionary.Type.*;

import java.util.Arrays;
import java.util.List;


public class DZConfig {
    public static ForgeConfigSpec.IntValue NotBreeBreemin;
    public static ForgeConfigSpec.IntValue NotBreeBreemax;
    public static ForgeConfigSpec.IntValue NotBreeBreeweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> NotBreeBreeinclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> NotBreeBreeexclude;
    public static ForgeConfigSpec.IntValue StampyLongNosemin;
    public static ForgeConfigSpec.IntValue StampyLongNosemax;
    public static ForgeConfigSpec.IntValue StampyLongNoseweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> StampyLongNoseinclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> StampyLongNoseexclude;
    public static ForgeConfigSpec.IntValue Tewitymin;
    public static ForgeConfigSpec.IntValue Tewitymax;
    public static ForgeConfigSpec.IntValue Tewityweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Tewityinclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Tewityexclude;
    public static ForgeConfigSpec.IntValue Entmin;
    public static ForgeConfigSpec.IntValue Entmax;
    public static ForgeConfigSpec.IntValue Entweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Entinclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Entexclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CaveFisherexclude;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CaveFisherinclude;
    public static ForgeConfigSpec.IntValue CaveFishermin;
    public static ForgeConfigSpec.IntValue CaveFishermax;
    public static ForgeConfigSpec.IntValue CaveFisherweight;
    public static ForgeConfigSpec.IntValue AMETHYST_SWORD_DAMAGE;
    public static ForgeConfigSpec.IntValue AMETHYST_SWORD_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_SWORD_HIT_COST;
    public static ForgeConfigSpec.IntValue CAKE_SWORD_DAMAGE;
    public static ForgeConfigSpec.IntValue CAKE_SWORD_DURABILITY;
    public static ForgeConfigSpec.IntValue CAKE_SWORD_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_SWORD_DAMAGE;
    public static ForgeConfigSpec.IntValue EMERALD_SWORD_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_SWORD_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SWORD_DAMAGE;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SWORD_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SWORD_HIT_COST;
    public static ForgeConfigSpec.IntValue POPPY_SWORD_DAMAGE;
    public static ForgeConfigSpec.IntValue POPPY_SWORD_DURABILITY;
    public static ForgeConfigSpec.IntValue POPPY_SWORD_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_AXE_DAMAGE;
    public static ForgeConfigSpec.IntValue AMETHYST_AXE_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_AXE_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_BOOTS_DURABILTY;
    public static ForgeConfigSpec.IntValue AMETHYST_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_HOE_DAMAGE;
    public static ForgeConfigSpec.IntValue AMETHYST_HOE_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_HOE_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_PICKAXE_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_PICKAXE_DAMAGE;
    public static ForgeConfigSpec.IntValue AMETHYST_PICKAXE_HIT_COST;
    public static ForgeConfigSpec.IntValue AMETHYST_SHOVEL_DURABILITY;
    public static ForgeConfigSpec.IntValue AMETHYST_SHOVEL_DAMAGE;
    public static ForgeConfigSpec.IntValue AMETHYST_SHOVEL_HIT_COST;
    public static ForgeConfigSpec.IntValue CATS_EYE_BOOTS_DURABILITY;
    public static ForgeConfigSpec.IntValue CATS_EYE_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue CATS_EYE_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue CATS_EYE_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue CATS_EYE_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue CATS_EYE_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue CATS_EYE_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue CATS_EYE_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue COPPER_BOOTS_DURABILITY;
    public static ForgeConfigSpec.IntValue COPPER_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue COPPER_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue COPPER_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue COPPER_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue COPPER_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue COPPER_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue COPPER_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_AXE_DAMAGE;
    public static ForgeConfigSpec.IntValue EMERALD_AXE_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_AXE_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_BOOTS_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_HOE_DAMAGE;
    public static ForgeConfigSpec.IntValue EMERALD_HOE_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_HOE_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_PICKAXE_DAMAGE;
    public static ForgeConfigSpec.IntValue EMERALD_PICKAXE_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_PICKAXE_HIT_COST;
    public static ForgeConfigSpec.IntValue EMERALD_SHOVEL_DAMAGE;
    public static ForgeConfigSpec.IntValue EMERALD_SHOVEL_DURABILITY;
    public static ForgeConfigSpec.IntValue EMERALD_SHOVEL_HIT_COST;
    public static ForgeConfigSpec.IntValue LAPIS_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue LAPIS_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue LAPIS_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue LAPIS_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue LAPIS_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue LAPIS_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue LAPIS_BOOTS_DURABILITY;
    public static ForgeConfigSpec.IntValue LAPIS_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_HELMET_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_HELMET_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_CHESTPLATE_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_CHESTPLATE_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_LEGGINGS_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_LEGGINGS_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_BOOTS_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_BOOTS_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_AXE_DAMAGE;
    public static ForgeConfigSpec.IntValue SAPPHIRE_AXE_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_AXE_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_HOE_DAMAGE;
    public static ForgeConfigSpec.IntValue SAPPHIRE_HOE_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_HOE_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SHOVEL_DAMAGE;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SHOVEL_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_SHOVEL_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_PICKAXE_DAMAGE;
    public static ForgeConfigSpec.IntValue SAPPHIRE_PICKAXE_DURABILITY;
    public static ForgeConfigSpec.IntValue SAPPHIRE_PICKAXE_HIT_COST;
    public static ForgeConfigSpec.IntValue SAPPHIRE_PICKAXE_ATTACK_SPEED;
    public static ForgeConfigSpec.IntValue SAPPHIRE_LEGGINGS_ARMOR;
    public static ForgeConfigSpec.IntValue SAPPHIRE_BOOTS_ARMOR;
    public static ForgeConfigSpec.IntValue SAPPHIRE_BOOTS_TOUGHNESS;

    public DZConfig() {
    }

    public static void COMMON(ForgeConfigSpec.Builder builder) {
            builder.comment("Spawn Chances");
            builder.comment("Configure mob spawn weight (How frequently they spawn & min/max group size. Set weight to 0 to disable.");
            builder.push("NotBreeBree Spawn Chances");
            NotBreeBreemin = builder.defineInRange("NotBreeBree Min", 1, 0, 640);
            NotBreeBreemax = builder.defineInRange("NotBreeBree Max", 2, 0, 640);
            NotBreeBreeweight = builder.defineInRange("NotBreeBree Weight", 7, 0, 100);
            builder.pop();

            builder.push("StampyLongNose Spawn Chances");
            StampyLongNosemin = builder.defineInRange("StampyLongNose Min", 1, 0, 64);
            StampyLongNosemax = builder.defineInRange("StampyLongNose Max", 2, 0, 64);
            StampyLongNoseweight = builder.defineInRange("StampyLongNose Weight", 7, 0, 100);
            builder.pop();

            builder.push("Tewity Spawn Chances");
            Tewitymin = builder.defineInRange("Tewity Min", 1, 0, 640);
            Tewitymax = builder.defineInRange("Tewity Max", 2, 0, 640);
            Tewityweight = builder.defineInRange("Tewity Weight", 7, 0, 100);
            builder.pop();

            builder.push("Ent Spawn Chances");
            Entmin = builder.defineInRange("Ent Min", 1, 0, 640);
            Entmax = builder.defineInRange("Ent Max", 1, 0, 640);
            Entweight = builder.defineInRange("Ent Weight", 7, 0, 100);
            builder.pop();

            builder.comment("Spawnable Biomes");
            builder.push("StampyLongNose Biomes Whitelist/Blacklist");
            StampyLongNoseinclude = builder.defineList("include Stampy", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            StampyLongNoseexclude = builder.defineList("exclude Stampy", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();

            builder.comment("Spawnable Biomes");
            builder.push("Cave Fisher Biomes Whitelist/Blacklist");
            CaveFisherinclude = builder.defineList("include CaveFisher", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            CaveFisherexclude = builder.defineList("exclude CaveFisher", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();

            builder.push("Cave Fisher Spawn Chances");
            CaveFishermin = builder.defineInRange("Cave Fisher Min", 1, 0, 64);
            CaveFishermax = builder.defineInRange("Cave Fisher Max", 2, 0, 64);
            CaveFisherweight = builder.defineInRange("Cave Fisher Weight", 7, 0, 100);
            builder.pop();

            builder.push("Tewity Biomes Whitelist/Blacklist");
            Tewityinclude = builder.defineList("include Tewity", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Tewityexclude = builder.defineList("exclude Tewity", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();

            builder.push("NotBreeBree Biomes Whitelist/Blacklist");
            NotBreeBreeinclude = builder.defineList("include NotBreeBree", Arrays.asList(SNOWY.toString(), MOUNTAIN.toString(), MESA.toString(), FOREST.toString(), HILLS.toString(), SANDY.toString(), SAVANNA.toString(), SWAMP.toString(), BEACH.toString(), PLAINS.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            NotBreeBreeexclude = builder.defineList("exclude NotBreeBree", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();

            builder.push("Ent Biomes Whitelist/Blacklist");
            Entinclude = builder.defineList("include Ent", Arrays.asList(MOUNTAIN.toString(), FOREST.toString(), SAVANNA.toString(), SWAMP.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            Entexclude = builder.defineList("exclude Ent", Arrays.asList(OCEAN.toString(), END.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();

            builder.push("Weapon/Tools/Armor");
            builder.comment("Amethyst Set Attributes");
            AMETHYST_AXE_DAMAGE = builder.comment("Amethyst Axe Damage").defineInRange("AMETHYST_AXE_DAMAGE", 20, 0, 1000);
            AMETHYST_AXE_DURABILITY = builder.comment("Amethyst Axe Durability").defineInRange("AMETHYST_AXE_DURABILITY", 2000, 0, 10000);
            AMETHYST_AXE_HIT_COST = builder.comment("How much durability a Amethyst axe loses when an entity is hit").defineInRange("AMETHYST_AXE_HIT_COST", 1, 0, 10000);
            AMETHYST_HOE_DAMAGE = builder.comment("Amethyst Hoe Damage").defineInRange("AMETHYST_HOE_DAMAGE", 10, 0, 1000);
            AMETHYST_HOE_DURABILITY = builder.comment("Amethyst Hoe Durability").defineInRange("AMETHYST_HOE_DURABILITY", 2000, 0, 10000);
            AMETHYST_HOE_HIT_COST = builder.comment("How much durability a Amethyst hoe loses when an entity is hit").defineInRange("AMETHYST_HOE_HIT_COST", 1, 0, 10000);
            AMETHYST_SHOVEL_DAMAGE = builder.comment("Amethyst Shovel Damage").defineInRange("AMETHYST_SHOVEL_DAMAGE", 15, 0, 1000);
            AMETHYST_SHOVEL_DURABILITY = builder.comment("Amethyst Shovel Durability").defineInRange("AMETHYST_SHOVEL_DURABILITY", 2000, 0, 10000);
            AMETHYST_SHOVEL_HIT_COST = builder.comment("How much durability a Amethyst shovel loses when an entity is hit").defineInRange("AMETHYST_SHOVEL_HIT_COST", 1, 0, 1000);
            AMETHYST_SWORD_DAMAGE = builder.comment("Amethyst Sword Damage").defineInRange("AMETHYST_SWORD_DAMAGE", 30, 0, 1000);
            AMETHYST_SWORD_DURABILITY = builder.comment("Amethyst Sword Durability").defineInRange("AMETHYST_SWORD_DURABILITY", 2000, 0, 10000);
            AMETHYST_SWORD_HIT_COST = builder.comment("How much durability a Amethyst sword loses when an entity is hit").defineInRange("AMETHYST_SWORD_HIT_COST", 1, 0, 10000);
            AMETHYST_PICKAXE_DAMAGE = builder.comment("Amethyst Pickaxe Damage").defineInRange("AMETHYST_PICKAXE_DAMAGE", 20, 0, 1000);
            AMETHYST_PICKAXE_DURABILITY = builder.comment("Amethyst Pickaxe Durability").defineInRange("AMETHYST_PICKAXE_DURABILITY", 2000, 0, 10000);
            AMETHYST_PICKAXE_HIT_COST = builder.comment("How much durability a Amethyst pickaxe loses when an entity is hit").defineInRange("AMETHYST_PICKAXE_HIT_COST", 1, 0, 10000);
            AMETHYST_HELMET_DURABILITY = builder.comment("Amethyst Helmet Durability").defineInRange("AMETHYST_HELMET_DURABILITY", 1300, 0, 10000);
            AMETHYST_HELMET_HIT_COST = builder.comment("How much durability a Amethyst helmet loses when a entity hits").defineInRange("AMETHYST_HELMET_HIT_COST", 1, 0, 1000);
            AMETHYST_CHESTPLATE_DURABILITY = builder.comment("Amethyst Chestplate Durability").defineInRange("AMETHYST_CHESTPLATE_DURABILITY", 1500, 0, 10000);
            AMETHYST_CHESTPLATE_HIT_COST = builder.comment("How much durability a Amethyst chestplate loses when a entity hits").defineInRange("AMETHYST_CHESTPLATE_HIT_COST", 1, 0, 1000);
            AMETHYST_LEGGINGS_DURABILITY = builder.comment("Amethyst Leggings Durability").defineInRange("AMETHYST_LEGGINGS_DURABILITY", 1600, 0, 10000);
            AMETHYST_LEGGINGS_HIT_COST = builder.comment("How much durability the Amethyst leggings lose when a entity hits").defineInRange("AMETHYST_LEGGINGS_HIT_COST", 1, 0, 1000);
            AMETHYST_BOOTS_DURABILTY = builder.comment("Amethyst Boots Durability").defineInRange("AMETHYST_BOOTS_DURABILITY", 1100, 0, 10000);
            AMETHYST_BOOTS_HIT_COST = builder.comment("How much durability the Amethyst boots lose when a entity hits").defineInRange("AMETHYST_BOOTS_HIT_COST", 1, 0, 1000);

            builder.comment("Cat's Eye Set Attributes");
            CATS_EYE_HELMET_DURABILITY = builder.comment("Cat's Eye Durability").defineInRange("CATS_EYE_HELMET_DURABILITY", 1500, 0, 10000);
            CATS_EYE_HELMET_HIT_COST = builder.comment("How much durability a Cat's Eye helmet loses when an entity is hit").defineInRange("CATS_EYE_HELMET_HIT_COST", 1, 0, 1000);
            CATS_EYE_CHESTPLATE_DURABILITY = builder.comment("Cat's Eye Chestplate Durability").defineInRange("CATS_EYE_CHESTPLATE_DURABILITY", 2000, 0, 10000);
            CATS_EYE_CHESTPLATE_HIT_COST = builder.comment("How much durability a Cat's Eye chestplate loses when an entity is hit").defineInRange("CATS_EYE_CHESTPLATE_HIT_COST", 1, 0, 1000);
            CATS_EYE_LEGGINGS_DURABILITY = builder.comment("Cat's Eye Leggings Durability").defineInRange("CATS_EYE_LEGGINGS_DURABILITY", 1500, 0, 10000);
            CATS_EYE_LEGGINGS_HIT_COST = builder.comment("How much durability the Cat's Eye leggings lose when a entity is hit").defineInRange("CATS_EYE_LEGGINGS_HIT_COST", 1, 0, 1000);
            CATS_EYE_BOOTS_DURABILITY = builder.comment("Cat's Eye Boots Durability").defineInRange("CATS_EYE_BOOTS_DURABILITY", 500, 0, 10000);
            CATS_EYE_BOOTS_HIT_COST = builder.comment("How much durability the Cat's Eye boots lose when a entity hits").defineInRange("CATS_EYE_BOOTS_HIT_COST", 1, 0, 1000);

            builder.comment("Copper Set Attributes");
            COPPER_HELMET_DURABILITY = builder.comment("Copper Helmet Durability").defineInRange("COPPER_HELMET_DURABILITY", 598, 0, 10000);
            COPPER_HELMET_HIT_COST = builder.comment("How much durability a Copper helmet loses when an entity is hit").defineInRange("COPPER_HELMET_HIT_COST", 1, 0, 10000);
            COPPER_CHESTPLATE_DURABILITY = builder.comment("Copper Chestplate Durability").defineInRange("COPPER_CHESTPLATE_DURABILITY", 690, 0, 10000);
            COPPER_CHESTPLATE_HIT_COST = builder.comment("How much durability a Copper chestplate loses when an entity is hit").defineInRange("COPPER_CHESTPLETE_HIT_COST", 1, 0, 10000);
            COPPER_LEGGINGS_DURABILITY = builder.comment("Copper Leggings Durability").defineInRange("COPPER_LEGGINGS_DURABILITY", 736, 0, 10000);
            COPPER_LEGGINGS_HIT_COST = builder.comment("How much durability the Copper leggings lose when a entity hits").defineInRange("COPPER_LEGGINGS_HIT_COST", 1, 0, 10000);
            COPPER_BOOTS_DURABILITY = builder.comment("Copper Boots Durability").defineInRange("COPPER_BOOTS_DURABILITY", 506, 0, 10000);
            COPPER_BOOTS_HIT_COST = builder.comment("How much durability the Copper boots lose when a entity hits").defineInRange("COPPER_BOOTS_HIT_COST", 1, 0, 10000);

            builder.comment("Emerald Set Attributes");
            EMERALD_AXE_DAMAGE = builder.comment("Emerald Axe Damage").defineInRange("EMERALD_AXE_DAMAGE", 16, 0, 1000);
            EMERALD_AXE_DURABILITY = builder.comment("Emerald Axe Durability").defineInRange("EMERALD_AXE_DURABILITY", 1300, 0, 10000);
            EMERALD_AXE_HIT_COST = builder.comment("How much durability a Emerald axe loses when an entity is hit").defineInRange("EMERALD_AXE_HIT_COST", 1, 0, 10000);
            EMERALD_HOE_DAMAGE = builder.comment("Emerald Hoe Damage").defineInRange("EMERALD_HOE_DAMAGE", 5, 0, 1000);
            EMERALD_HOE_DURABILITY = builder.comment("Emerald Hoe Durability").defineInRange("EMERALD_HOE_DURABILITY", 1300, 0, 10000);
            EMERALD_HOE_HIT_COST = builder.comment("How much durability a Emerald hoe loses when an entity is hit").defineInRange("EMERALD_HOE_HIT_COST", 1, 0, 10000);
            EMERALD_PICKAXE_DAMAGE = builder.comment("Emerald pickaxe Damage").defineInRange("EMERALD_PICKAXE_DAMAGE", 16, 0, 1000);
            EMERALD_PICKAXE_DURABILITY = builder.comment("Emerald Pickaxe Durability").defineInRange("EMERALD_PICKAXE_DURABILITY", 1300, 0, 10000);
            EMERALD_PICKAXE_HIT_COST = builder.comment("How much durability a Emerald pickaxe loses when an entity is hit").defineInRange("EMERALD_PICKAXE_HIT_COST", 1, 0, 10000);
            EMERALD_SHOVEL_DAMAGE = builder.comment("Emerald Shovel Damage").defineInRange("EMERALD_SHOVEL_DAMAGE", 10, 0, 1000);
            EMERALD_SHOVEL_DURABILITY = builder.comment("Emerald Shovel Durability").defineInRange("EMERALD_SHOVEL_DURABILITY", 1300, 0, 10000);
            EMERALD_SHOVEL_HIT_COST = builder.comment("How much durability a Emerald shovel loses when an entity is hit").defineInRange("EMERALD_SHOVEL_HIT_COST", 1, 0, 10000);
            EMERALD_SWORD_DAMAGE = builder.comment("Emerald Sword Damage").defineInRange("EMERALD_SWORD_DAMAGE", 24, 0, 1000);
            EMERALD_SWORD_DURABILITY = builder.comment("Emerald Sword Durability").defineInRange("EMERALD_SWORD_DURABILITY", 1300, 0, 10000);
            EMERALD_SWORD_HIT_COST = builder.comment("How much durability a Emerald sword loses when an entity is hit").defineInRange("EMERALD_SWORD_HIT_COST", 1, 0, 10000);
            EMERALD_HELMET_DURABILITY = builder.comment("Emerald Helmet Durability").defineInRange("EMERALD_HELMET_DURABILITY", 1170, 0, 10000);
            EMERALD_HELMET_HIT_COST = builder.comment("How much durability a Emerald Helmet loses when an entity is hit").defineInRange("EMERALD_HELMET_HIT_COST", 1, 0, 10000);
            EMERALD_CHESTPLATE_DURABILITY = builder.comment("Emerald Chestplate Durability").defineInRange("`EMERALD_CHESTPLATE_DURABILITY", 1350, 0, 10000);
            EMERALD_CHESTPLATE_HIT_COST = builder.comment("How much durability a Emerald Chestplate loses when an entity is hit").defineInRange("EMERALD_CHESTPLATE_HIT_COST", 1, 0, 10000);
            EMERALD_LEGGINGS_DURABILITY = builder.comment("Emerald Leggings Durability").defineInRange("EMERALD_LEGGINGS_DURABILITY", 1440, 0, 10000);
            EMERALD_LEGGINGS_HIT_COST = builder.comment("How much durability the Emerald Leggings lose when a entity hits").defineInRange("EMERALD_LEGGINGS_HIT_COST", 1, 0, 10000);
            EMERALD_BOOTS_DURABILITY = builder.comment("Emerald Boots Durability").defineInRange("EMERALD_BOOTS_DURABILITY", 990, 0, 10000);
            EMERALD_BOOTS_HIT_COST = builder.comment("How much durability the Emerald Boots lose when a entity hits").defineInRange("EMERALD_BOOTS_HIT_COST", 1, 0, 10000);

            builder.comment("Lapis Set Attributes");
            LAPIS_HELMET_DURABILITY = builder.comment("Lapis Helmet Durability").defineInRange("LAPIS_HELMET_DURABILITY", 1170, 0, 10000);
            LAPIS_HELMET_HIT_COST = builder.comment("How much durability the Lapis Helmet loses when an entity hit").defineInRange("LAPIS_HELMET_HIT_COST", 1, 0, 10000);
            LAPIS_CHESTPLATE_DURABILITY = builder.comment("Lapis Chestplate Durability").defineInRange("LAPIS_CHESTPLATE_DURABILITY", 1350, 0, 10000);
            LAPIS_CHESTPLATE_HIT_COST = builder.comment("How much durability the Lapis chestplate loses when an entity is hit").defineInRange("LAPIS_CHESTPLATE_HIT_COST", 1, 0, 10000);
            LAPIS_LEGGINGS_DURABILITY = builder.comment("Lapis Leggings Durability").defineInRange("LAPIS_LEGGINGS_DURABILITY", 1440, 100, 10000);
            LAPIS_LEGGINGS_HIT_COST = builder.comment("How much durability the Lapis leggings loses when an entity is hit").defineInRange("LAPIS_LEGGINGS_HIT_COST", 1, 0, 10000);
            LAPIS_BOOTS_DURABILITY = builder.comment("Lapis Boots Durability").defineInRange("LAPIS_BOOTS_DURABILITY", 990, 0, 10000);
            LAPIS_BOOTS_HIT_COST = builder.comment("How much durability the Lapis boots lose when an entity hits").defineInRange("LAPIS_BOOTS_HIT_COST", 1, 0, 10000);

            builder.comment("Cake Set Attributes");
            CAKE_SWORD_DAMAGE = builder.comment("Cake Sword Damage").defineInRange("CAKE_SWORD_DAMAGE", 1, 0, 1000);
            CAKE_SWORD_DURABILITY = builder.comment("Cake Sword Durability").defineInRange("CAKE_SWORD_DURABILITY", 2500, 0, 10000);
            CAKE_SWORD_HIT_COST = builder.comment("How much durability the Cake sword loses when an entity is hit").defineInRange("CAKE_SWORD_HIT_COST", 1, 0, 10000);

            builder.comment("Poppy Set Attributes");
            POPPY_SWORD_DAMAGE = builder.comment("Poppy Sword Damage").defineInRange("POPPY_SWORD_DAMAGE", 5, 0, 1000);
            POPPY_SWORD_DURABILITY = builder.comment("Poppy Sword Durability").defineInRange("POPPY_SWORD_DURABILITY", 1300, 0, 10000);
            POPPY_SWORD_HIT_COST = builder.comment("How much durability the Poppy sword loses when an entity is hit").defineInRange("POPPY_SWORD_HIT_COST", 1, 0, 10000);

            builder.comment("Sapphire Set Attributes");
            SAPPHIRE_SWORD_DAMAGE = builder.comment("Sapphire Sword Damage").defineInRange("SAPPHIRE_SWORD_DAMAGE", 18, 0, 1000);
            SAPPHIRE_SWORD_DURABILITY = builder.comment("Sapphire Sword Durability").defineInRange("SAPPHIRE_SWORD_DURABILITY", 1400, 0, 10000);
            SAPPHIRE_SWORD_HIT_COST = builder.comment("How much durability the Sapphire sword loses when an entity is hit").defineInRange("SAPPHIRE_SWORD_HIT_COST", 1, 0, 10000);
            SAPPHIRE_HELMET_DURABILITY = builder.comment("Sapphire Helmet Durability").defineInRange("SAPPHIRE_HELMET_DURABILITY", 1170, 0, 10000);
            SAPPHIRE_HELMET_HIT_COST = builder.comment("How much durability the Sapphire helmet loses when an entity is hit").defineInRange("SAPPHIRE_HELMET_HIT_COST", 1, 0, 10000);
            SAPPHIRE_CHESTPLATE_DURABILITY = builder.comment("Sapphire Chestplate Durability").defineInRange("SAPPHIRE_CHESTPLATE_DURABILITY", 1350, 0, 10000);
            SAPPHIRE_CHESTPLATE_HIT_COST = builder.comment("How much durability the Sapphire chestplate loses when an entity is hit").defineInRange("SAPPHIRE_CHESTPLATE_HIT_COST", 1, 0, 10000);
            SAPPHIRE_LEGGINGS_DURABILITY = builder.comment("Sapphire Leggings Durability").defineInRange("SAPPHIRE_LEGGINGS_DURABILITY", 1440, 0, 10000);
            SAPPHIRE_LEGGINGS_HIT_COST = builder.comment("How much durability the Sapphire leggings lose when a entity hits").defineInRange("SAPPHIRE_LEGGINGS_HIT_COST", 1, 0, 10000);
            SAPPHIRE_BOOTS_DURABILITY = builder.comment("Sapphire Boots Durability").defineInRange("SAPPHIRE_BOOTS_DURABILITY", 990, 0, 10000);
            SAPPHIRE_BOOTS_HIT_COST = builder.comment("How much durability the Sapphire boots lose when a entity hits").defineInRange("SAPPHIRE_BOOTS_HIT_COST", 1, 0, 10000);
            SAPPHIRE_AXE_DAMAGE = builder.comment("Sapphire Axe Damage").defineInRange("SAPPHIRE_AXE_DAMAGE", 18, 0, 1000);
            SAPPHIRE_AXE_DURABILITY = builder.comment("Sapphire Axe Durability").defineInRange("SAPPHIRE_AXE_DURABILITY", 1400, 0, 10000);
            SAPPHIRE_AXE_HIT_COST = builder.comment("How much durability a Sapphire axe loses when an entity is hit").defineInRange("SAPPHIRE_AXE_HIT_COST", 1, 0, 10000);
            SAPPHIRE_HOE_DAMAGE = builder.comment("Sapphire Hoe Damage").defineInRange("SAPPHIRE_HOE_DAMAGE", 0, 0, 1000);
            SAPPHIRE_HOE_DURABILITY = builder.comment("Sapphire Hoe Durability").defineInRange("SAPPHIRE_HOE_DURABILITY", 1400, 0, 10000);
            SAPPHIRE_HOE_HIT_COST = builder.comment("How much durability a Sapphire hoe loses when an entity is hit").defineInRange("SAPPHIRE_HOE_HIT_COST", 1, 0, 10000);
            SAPPHIRE_SHOVEL_DAMAGE = builder.comment("Sapphire Shovel Damage").defineInRange("SAPPHIRE_SHOVEL_DAMAGE", 16, 0, 1000);
            SAPPHIRE_SHOVEL_DURABILITY = builder.comment("Sapphire Shovel Durability").defineInRange("SAPPHIRE_SHOVEL_DURABILITY", 1400, 0, 10000);
            SAPPHIRE_SHOVEL_HIT_COST = builder.comment("How much durability a Sapphire shovel loses when an entity is hit").defineInRange("SAPPHIRE_SHOVEL_HIT_COST", 1, 0, 1000);
            SAPPHIRE_PICKAXE_DAMAGE = builder.comment("Sapphire Pickaxe Damage").defineInRange("SAPPHIRE_PICKAXE_DAMAGE", 17, 0, 1000);
            SAPPHIRE_PICKAXE_DURABILITY = builder.comment("Sapphire Pickaxe Durability").defineInRange("SAPPHIRE_PICKAXE_DURABILITY", 1400, 0, 10000);
            SAPPHIRE_PICKAXE_HIT_COST = builder.comment("How much durability a Sapphire pickaxe loses when an entity is hit").defineInRange("SAPPHIRE_PICKAXE_HIT_COST", 1, 0, 10000);
            SAPPHIRE_BOOTS_TOUGHNESS = builder.comment("Sapphire Boots Toughness, must be a whole number").defineInRange("SAPPHIRE_BOOTS_TOUGHNESS", 0, 0, 1000);
            SAPPHIRE_BOOTS_ARMOR = builder.comment("Sapphire Boots Armor").defineInRange("SAPPHIRE_BOOTS_ARMOR", 3, 0, 1000);
            SAPPHIRE_PICKAXE_ATTACK_SPEED = builder.comment("Sapphire Pickaxe Attack Speed, must be whole number").defineInRange("SAPPHIRE_PICKAXE_ATTACK_SPEED", 1, 0, 1000);
            SAPPHIRE_LEGGINGS_ARMOR = builder.comment("Sapphire Leggings Armor").defineInRange("SAPPHIRE_LEGGINGS_ARMOR", 7, 0, 1000);
        builder.pop();
        }

        }




