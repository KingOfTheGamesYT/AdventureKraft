package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.blocks.*;
import com.devmaster.dangerzone.items.*;
import com.devmaster.dangerzone.items.EmeraldPickaxe;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DangerZone.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DangerZone.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerZone.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DangerZone.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Armor
    public static final RegistryObject<CatsEyeBoots> CATS_EYE_BOOTS = ITEMS.register("cats_eye_boots", CatsEyeBoots::new);

    public static final RegistryObject<CatsEyeChestplate> CATS_EYE_CHESTPLATE = ITEMS.register("cats_eye_chestplate", CatsEyeChestplate::new);

    public static final RegistryObject<CatsEyeHelmet> CATS_EYE_HELMET = ITEMS.register("cats_eye_helmet", CatsEyeHelmet::new);

    public static final RegistryObject<CatsEyeLeggings> CATS_EYE_LEGGINGS = ITEMS.register("cats_eye_leggings", CatsEyeLeggings::new);

    public static final RegistryObject<CoarseAmethystBoots> COARSE_AMETHYST_BOOTS = ITEMS.register("coarse_amethyst_boots", CoarseAmethystBoots::new);

    public static final RegistryObject<CoarseAmethystChestplate> COARSE_AMETHYST_CHESTPLATE = ITEMS.register("coarse_amethyst_chestplate", CoarseAmethystChestplate::new);

    public static final RegistryObject<CoarseAmethystHelmet> COARSE_AMETHYST_HELMET = ITEMS.register("coarse_amethyst_helmet", CoarseAmethystHelmet::new);

    public static final RegistryObject<CoarseAmethystLeggings> COARSE_AMETHYST_LEGGINGS = ITEMS.register("coarse_amethyst_leggings", CoarseAmethystLeggings::new);

    public static final RegistryObject<CopperBoots> COPPER_BOOTS = ITEMS.register("copper_boots", CopperBoots::new);

    public static final RegistryObject<CopperChestplate> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", CopperChestplate::new);

    public static final RegistryObject<CopperHelmet> COPPER_HELMET = ITEMS.register("copper_helmet", CopperHelmet::new);

    public static final RegistryObject<CopperLeggings> COPPER_LEGGINGS = ITEMS.register("copper_leggings", CopperLeggings::new);

    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", EmeraldBoots::new);

    public static final RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", EmeraldChestplate::new);

    public static final RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", EmeraldHelmet::new);

    public static final RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", EmeraldLeggings::new);
    public static final RegistryObject<ExperienceScythe> EXPERIENCE_SCYTHE = ITEMS.register("experience_scythe", ExperienceScythe::new);

    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", LapisBoots::new);

    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", LapisChestplate::new);

    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", LapisHelmet::new);

    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",  LapisLeggings::new);

    public static final RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", SapphireBoots::new);

    public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", SapphireChestplate::new);

    public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", SapphireHelmet::new);

    public static final RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", SapphireLeggings::new);

    //Blocks
    public static final RegistryObject<Block> ABYSSAL_ORE_BLOCK = BLOCKS.register("abyssal_ore_block", AbyssalOreBlock::new);
    public static final RegistryObject<Block> ABYSSAL_ORE_VERTICAL_SLAB = conditionallyRegisterBlock("abyssal_ore_vertical_slab", () -> new VerticalSlabBlock(Block.Properties.from(Blocks.STONE_SLAB)), () -> isLoaded("quark"));
    public static final RegistryObject<Block> ADAMANTINE_BLOCK = BLOCKS.register("adamantine_block", AdamantineBlock::new);

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block", AluminiumBlock::new);

    public static final RegistryObject<Block> ALUMINIUM_ORE_BLOCK = BLOCKS.register("aluminium_ore_block", AluminiumOreBlock::new);

    public static final RegistryObject<Block> APPLE_BLOCK = BLOCKS.register("apple_block", AppleBlock::new);

    public static final RegistryObject<Block> APPLE_LEAVES = BLOCKS.register("apple_leaves", AppleLeaves::new);

    public static final RegistryObject<Block> APPLE_LOG = BLOCKS.register("apple_log", AppleLog::new);

    public static final RegistryObject<Block> BLOODSTONE_BLOCK = BLOCKS.register("bloodstone_block", BloodStoneBlock::new);

    public static final RegistryObject<Block> BROWN_BLOCK = BLOCKS.register("brown_block", BrownBlock::new);

    public static final RegistryObject<Block> CATS_EYE_BLOCK = BLOCKS.register("cats_eye_block", CatsEyeBlock::new);

    public static final RegistryObject<Block> CATS_EYE_ORE = BLOCKS.register("cats_eye_ore", CatsEyeOre::new);

    public static final RegistryObject<Block> COARSE_AMETHYST_BLOCK = BLOCKS.register("coarse_amethyst_block", CoarseAmethystBlock::new);

    public static final RegistryObject<Block> COARSE_AMETHYST_ORE_BLOCK = BLOCKS.register("coarse_amethyst_ore_block", CoarseAmethystOreBlock::new);

    public static final RegistryObject<Block> COMPRESSED_POPPY_BLOCK = BLOCKS.register("compressed_poppy_block", CompressedPoppyBlock::new);

    public static final RegistryObject<Block> CRYSTAL_GRASS = BLOCKS.register("crystal_grass", CrystalGrass::new);

    public static final RegistryObject<Block> DARK_BROWN_BLOCK = BLOCKS.register("dark_brown_block", DarkBrownBlock::new);

    public static final RegistryObject<Block> DARK_ORANGE_BLOCK = BLOCKS.register("dark_orange_block", DarkOrangeBlock::new);

    public static final RegistryObject<Block> HEART_BLOCK = BLOCKS.register("heart_block", HeartBlock::new);

    public static final RegistryObject<Block> KYANITE = BLOCKS.register("kyanite", Kyanite::new);

    public static final RegistryObject<Block> LEATHER_BLOCK = BLOCKS.register("leather_block", LeatherBlock::new);

    public static final RegistryObject<Block> ORANGE_BLOCK = BLOCKS.register("orange_block", OrangeBlock::new);

    public static final RegistryObject<Block> PLAY_BUTTON_ORE_BLOCK = BLOCKS.register("play_button_ore_block", PlayButtonOreBlock::new);

    public static final RegistryObject<Block> RED_BLOCK = BLOCKS.register("red_block", RedBlock::new);

    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);

    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);

    public static final RegistryObject<Block> STICKY_BLOCK = BLOCKS.register("sticky_block", StickyBlock::new);

    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", TitaniumBlock::new);

    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);

    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);

    //Block Items
    public static final RegistryObject<Item> ABYSSAL_ORE_BLOCK_ITEM = ITEMS.register("abyssal_ore_block", () -> new BlockItemBase(ABYSSAL_ORE_BLOCK.get()));

    public static final RegistryObject<Item> ABYSSAL_ORE_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("abyssal_ore_vertical_slab", () -> new BlockItemBase(ABYSSAL_ORE_VERTICAL_SLAB.get()), () -> isLoaded("quark"));
    public static final RegistryObject<Item> ADAMANTINE_BLOCK_ITEM = ITEMS.register("adamantine_block", () -> new BlockItemBase(ADAMANTINE_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINIUM_BLOCK_ITEM = ITEMS.register("aluminium_block", () -> new BlockItemBase(ALUMINIUM_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINIUM_ORE_BLOCK_ITEM = ITEMS.register("aluminium_ore_block", () -> new WIPBlockItemBase(ALUMINIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> APPLE_BLOCK_ITEM = ITEMS.register("apple_block", () -> new BlockItemBase(APPLE_BLOCK.get()));

    public static final RegistryObject<Item> APPLE_LOG_ITEM = ITEMS.register("apple_log", () -> new WIPBlockItemBase(APPLE_LOG.get()));

    public static final RegistryObject<Item> APPLE_LEAVES_ITEM = ITEMS.register("apple_leaves", () -> new WIPBlockItemBase(APPLE_LEAVES.get()));

    public static final RegistryObject<Item> BLOODSTONE_BLOCK_ITEM = ITEMS.register("bloodstone_block", () -> new WIPBlockItemBase(BLOODSTONE_BLOCK.get()));

    public static final RegistryObject<Item> BROWN_BLOCK_ITEM = ITEMS.register("brown_block", () -> new BlockItemBase(BROWN_BLOCK.get()));

    public static final RegistryObject<Item> CATS_EYE_BLOCK_ITEM = ITEMS.register("cats_eye_block", () -> new BlockItemBase(CATS_EYE_BLOCK.get()));

    public static final RegistryObject<Item> CATS_EYE_ORE_ITEM = ITEMS.register("cats_eye_ore", () -> new BlockItemBase(CATS_EYE_ORE.get()));

    public static final RegistryObject<Item> COARSE_AMETHYST_BLOCK_ITEM = ITEMS.register("coarse_amethyst_block", () -> new BlockItemBase(COARSE_AMETHYST_BLOCK.get()));

    public static final RegistryObject<Item> COARSE_AMETHYST_ORE_BLOCK_ITEM = ITEMS.register("coarse_amethyst_ore_block", () -> new BlockItemBase(COARSE_AMETHYST_ORE_BLOCK.get()));

    public static final RegistryObject<Item> COMPRESSED_POPPY_BLOCK_ITEM = ITEMS.register("compressed_poppy_block", () -> new BlockItemBase(COMPRESSED_POPPY_BLOCK.get()));

    public static final RegistryObject<Item> CRYSTAL_GRASS_ITEM = ITEMS.register("crystal_grass", () -> new BlockItemBase(CRYSTAL_GRASS.get()));

    public static final RegistryObject<Item> DARK_BROWN_BLOCK_ITEM = ITEMS.register("dark_brown_block", () -> new BlockItemBase(DARK_BROWN_BLOCK.get()));

    public static final RegistryObject<Item> DARK_ORANGE_BLOCK_ITEM = ITEMS.register("dark_orange_block", () -> new BlockItemBase(DARK_ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> HEART_BLOCK_ITEM = ITEMS.register("heart_block", () -> new WIPBlockItemBase(HEART_BLOCK.get()));

    public static final RegistryObject<Item> KYANITE_BLOCK_ITEM = ITEMS.register("kyanite", () -> new BlockItemBase(KYANITE.get()));

    public static final RegistryObject<Item> LEATHER_BLOCK_ITEM = ITEMS.register("leather_block", () -> new BlockItemBase(LEATHER_BLOCK.get()));

    public static final RegistryObject<Item> ORANGE_BLOCK_ITEM = ITEMS.register("orange_block", () -> new BlockItemBase(ORANGE_BLOCK.get()));

    public static final RegistryObject<Item> PLAY_BUTTON_ORE_BLOCK_ITEM = ITEMS.register("play_button_ore_block", () -> new BlockItemBase(PLAY_BUTTON_ORE_BLOCK.get()));
    public static final RegistryObject<Item> RED_BLOCK_ITEM = ITEMS.register("red_block", () -> new BlockItemBase(RED_BLOCK.get()));

    public static final RegistryObject<Item> SALT_ORE_BLOCK_ITEM = ITEMS.register("salt_ore_block", () -> new BlockItemBase(SALT_ORE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_ORE_BLOCK_ITEM = ITEMS.register("sapphire_ore_block", () -> new BlockItemBase(SAPPHIRE_ORE_BLOCK.get()));

    public static final RegistryObject<Item> STICKY_BLOCK_ITEM = ITEMS.register("sticky_block", () -> new BlockItemBase(STICKY_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_BLOCK_ITEM = ITEMS.register("titanium_block", () -> new BlockItemBase(TITANIUM_BLOCK.get()));

    public static final RegistryObject<Item> TITANIUM_ORE_BLOCK_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));

    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block", () -> new WIPBlockItemBase(URANIUM_BLOCK.get()));

    //Dimensions
    public static final RegistryKey<World> DANGER = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "danger"));

    public static final RegistryKey<World> VILLAGES = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "villages"));

    public static final RegistryKey<World> CRYSTAL = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "crystal"));

    public static final RegistryKey<World> PAST = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DangerZone.MOD_ID, "past"));

    //Entities
    public static final RegistryObject<EntityType<AlexiCraft>> ALEXICRAFT = ENTITIES
            .register("alexicraft",
                    () -> EntityType.Builder.<AlexiCraft>create(AlexiCraft::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "alexicraft").toString()));

    public static final RegistryObject<EntityType<Allosaurus>> ALLOSAURUS = ENTITIES
            .register("allosaurus",
                    () -> EntityType.Builder.<Allosaurus>create(Allosaurus::new, EntityClassification.MONSTER)
                            .size(1.0f, 0.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "allosaurus").toString()));

    public static final RegistryObject<EntityType<AntVenom>> ANTVENOM = ENTITIES
            .register("antvenom",
                    () -> EntityType.Builder.<AntVenom>create(AntVenom::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "antvenom").toString()));

    public static final RegistryObject<EntityType<Aphmau>> APHMAU = ENTITIES
            .register("aphmau",
                    () -> EntityType.Builder.<Aphmau>create(Aphmau::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "aphmau").toString()));

    public static final RegistryObject<EntityType<AttackSquid>> ATTACK_SQUID = ENTITIES
            .register("attack_squid",
                    () -> EntityType.Builder.<AttackSquid>create(AttackSquid::new, EntityClassification.WATER_CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "attack_squid").toString()));

    public static final RegistryObject<EntityType<BabyAngel>> BABYANGEL = ENTITIES
            .register("babyangel",
                    () -> EntityType.Builder.<BabyAngel>create(BabyAngel::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyangel").toString()));

    public static final RegistryObject<EntityType<BabyDuck>> BABYDUCK = ENTITIES
            .register("babyduck",
                    () -> EntityType.Builder.<BabyDuck>create(BabyDuck::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyduckl").toString()));

    public static final RegistryObject<EntityType<BabyLeah>> BABYLEAH = ENTITIES
            .register("babyleah",
                    () -> EntityType.Builder.<BabyLeah>create(BabyLeah::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babyleah").toString()));

    public static final RegistryObject<EntityType<BabyMax>> BABYMAX = ENTITIES
            .register("babymax",
                    () -> EntityType.Builder.<BabyMax>create(BabyMax::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "babymax").toString()));

    public static final RegistryObject<EntityType<BajanCanadian>> BAJANCANADIAN = ENTITIES
            .register("bajancanadian",
                    () -> EntityType.Builder.<BajanCanadian>create(BajanCanadian::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "bajancanadian").toString()));

    public static final RegistryObject<EntityType<BetterFireball>> BETTER_FIREBALL = ENTITIES
            .register("better_fireball",
                    () ->  EntityType.Builder.<BetterFireball>create(BetterFireball::new, EntityClassification.MISC)
                            .size(1.0F, 1.0F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "better_fireball").toString()));
    public static final RegistryObject<EntityType<Bird>> BIRD = ENTITIES
            .register("bird",
                    () -> EntityType.Builder.<Bird>create(Bird::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "bird").toString()));

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES
            .register("butterfly",
                    () -> EntityType.Builder.<Butterfly>create(Butterfly::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "butterfly").toString()));

    public static final RegistryObject<EntityType<CaptainSparkelz>> CAPTAINSPARKELZ = ENTITIES
            .register("captainsparkelz",
                    () -> EntityType.Builder.<CaptainSparkelz>create(CaptainSparkelz::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "captainsparkelz").toString()));

    public static final RegistryObject<EntityType<CaveFisher>> CAVE_FISHER = ENTITIES
            .register("cave_fisher",
                    () -> EntityType.Builder.<CaveFisher>create(CaveFisher::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "cave_fisher").toString()));

    public static final RegistryObject<EntityType<EasterBunny>> EASTER_BUNNY = ENTITIES
            .register("easter_bunny",
                    () -> EntityType.Builder.<EasterBunny>create(EasterBunny::new, EntityClassification.CREATURE)
                            .size(2.0F, 1.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "easter_bunny").toString()));

    public static final RegistryObject<EntityType<Ent>> ENT = ENTITIES
            .register("ent",
                    () -> EntityType.Builder.<Ent>create(Ent::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "ent").toString()));

    public static final RegistryObject<EntityType<Godzilla>> GODZILLA = ENTITIES
            .register("godzilla",
                    () -> EntityType.Builder.<Godzilla>create(Godzilla::new, EntityClassification.CREATURE)
                            .size(9.9F, 5.05F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "godzilla").toString()));

    public static final RegistryObject<EntityType<Hydrolisc>> HYDROLISC = ENTITIES
            .register("hydrolisc",
                    () -> EntityType.Builder.<Hydrolisc>create(Hydrolisc::new, EntityClassification.CREATURE)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "hydrolisc").toString()));

    public static final RegistryObject<EntityType<Mermaid>> MERMAID = ENTITIES
            .register("mermaid",
                    () -> EntityType.Builder.<Mermaid>create(Mermaid::new, EntityClassification.WATER_CREATURE)
                            .size(0.9f, 1.7f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "mermaid").toString()));

    public static final RegistryObject<EntityType<NotBreeBree>> NOTBREEBREE = ENTITIES
            .register("notbreebree",
                    () -> EntityType.Builder.<NotBreeBree>create(NotBreeBree::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "notbreebree").toString()));

    public static final RegistryObject<EntityType<RainbowAnt>> RAINBOWANT = ENTITIES
            .register("rainbow_ant",
                    () -> EntityType.Builder.<RainbowAnt>create(RainbowAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "rainbow_ant").toString()));

    public static final RegistryObject<EntityType<RedAnt>> RED_ANT = ENTITIES
            .register("red_ant",
                    () -> EntityType.Builder.<RedAnt>create(RedAnt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "red_ant").toString()));


    public static final RegistryObject<EntityType<RedCow>> RED_COW = ENTITIES
            .register("red_cow",
                    () -> EntityType.Builder.<RedCow>create(RedCow::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.45f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "red_cow").toString()));

    public static final RegistryObject<EntityType<RedRoseWarrior>> REDROSEWARRIOR = ENTITIES
            .register("redrosewarrior",
                    () -> EntityType.Builder.<RedRoseWarrior>create(RedRoseWarrior::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "redrosewarrior").toString()));

    public static final RegistryObject<EntityType<RoboTechnoblade>> ROBO_TECHNOBLADE = ENTITIES
            .register("robo_technoblade",
                    () -> EntityType.Builder.<RoboTechnoblade>create(RoboTechnoblade::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "robo_technoblade").toString()));

    public static final RegistryObject<EntityType<StampyLongNose>> STAMPYLONGNOSE = ENTITIES
            .register("stampylongnose",
                    () -> EntityType.Builder.<StampyLongNose>create(StampyLongNose::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "stampylongnose").toString()));

    public static final RegistryObject<EntityType<Technoblade>> TECHNOBLADE = ENTITIES
            .register("technoblade",
                    () -> EntityType.Builder.<Technoblade>create(Technoblade::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "technoblade").toString()));

   public static final RegistryObject<EntityType<Termite>> TERMITE = ENTITIES
            .register("termite",
                    () -> EntityType.Builder.<Termite>create(Termite::new, EntityClassification.CREATURE)
                            .size(0.9f, .9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "termite").toString()));

    public static final RegistryObject<EntityType<Tewtiy>> TEWTIY = ENTITIES
            .register("tewtiy",
                    () -> EntityType.Builder.<Tewtiy>create(Tewtiy::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.9f)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "tewtiy").toString()));

    public static final RegistryObject<EntityType<WaterProjectile>> WATER_PROJECTILE = ENTITIES
            .register("water_projectile",
                    () -> EntityType.Builder.<WaterProjectile>create(WaterProjectile::new, EntityClassification.MISC)
                            .size(1.0F, 3.5F)
                            .build(new ResourceLocation(DangerZone.MOD_ID, "water_projectile").toString()));

    //Items
    public static final RegistryObject<Item> ALLOSAURUS_TOOTH = ITEMS.register("allosaurus_tooth", AllosaurusTooth::new);
    public static final RegistryObject<Item> ALUMINIUM = ITEMS.register("aluminium_ingot", AluminiumIngot::new);

    public static final RegistryObject<Item> ALUMINIUM_LUMP = ITEMS.register("aluminium_lump", AluminiumLump::new);

    public static final RegistryObject<AppleSeed> APPLE_SEED = ITEMS.register("apple_seed", AppleSeed::new);
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", BismuthIngot::new);

    public static final RegistryObject<Item> BLOODSTONE = ITEMS.register("bloodstone", BloodStone::new);

    public static final RegistryObject<BLT> BLT = ITEMS.register("blt", BLT::new);

    public static final RegistryObject<Butter> BUTTER = ITEMS.register("butter", Butter::new);

    public static final RegistryObject<ButterCandy> BUTTER_CANDY = ITEMS.register("butter_candy", ButterCandy::new);

    public static final RegistryObject<CandyCane> CANDY_CANE = ITEMS.register("candy_cane", CandyCane::new);

    public static final RegistryObject<Item> CATS_EYE = ITEMS.register("cats_eye", CatsEye::new);

    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);

    public static final RegistryObject<Item> COARSE_AMETHYST = ITEMS.register("coarse_amethyst", CoarseAmethyst::new);

    public static final RegistryObject<CookedBacon> COOKED_BACON = ITEMS.register("cooked_bacon", CookedBacon::new);

    public static final RegistryObject<Item> COPPER_LUMP = ITEMS.register("copper_lump", CopperLump::new);

    public static final RegistryObject<CritterCage> CRITTER_CAGE = ITEMS.register("critter_cage", CritterCage::new);

    public static final RegistryObject<CrystalApple> CRYSTAL_APPLE = ITEMS.register("crystal_apple", CrystalApple::new);

    public static final RegistryObject<CZLoinCoin> CZ_LOIN_COIN = ITEMS.register("cz_loin_coin", CZLoinCoin::new);

    public static final RegistryObject<DeadRainbowAnt> DEAD_RAINBOW_ANT = ITEMS.register("dead_rainbow_ant", DeadRainbowAnt::new);

    public static final RegistryObject<DeadTermite> DEAD_TERMITE = ITEMS.register("dead_termite", DeadTermite::new);
    public static final RegistryObject<StairItem> INSTANT_BRIDGE = ITEMS.register("instant_bridge", StairItem::new);
    public static final RegistryObject<StairItem> INSTANT_STAIRS_UP = ITEMS.register("instant_stairs_up", StairItem::new);
    public static final RegistryObject<StairItem> INSTANT_STAIRS_DOWN = ITEMS.register("instant_stairs_down", StairItem::new);
    public static final RegistryObject<MinersDreamItem> MINERS_DREAM = ITEMS.register("miners_dream", MinersDreamItem::new);
    public static final RegistryObject<Item> MITHRIL_LUMP = ITEMS.register("mithril_lump", MithrilLump::new);
    public static final RegistryObject<Popcorn> POPCORN = ITEMS.register("popcorn", Popcorn::new);

    public static final RegistryObject<RainbowAntAbdomen> RAINBOW_ANT_ABDOMEN = ITEMS.register("rainbow_ant_abdomen", RainbowAntAbdomen::new);

    public static final RegistryObject<RainbowAntEye> RAINBOW_ANT_EYE = ITEMS.register("rainbow_ant_eye", RainbowAntEye::new);

    public static final RegistryObject<RainbowAntLeg> RAINBOW_ANT_LEG = ITEMS.register("rainbow_ant_leg", RainbowAntLeg::new);

    public static final RegistryObject<RainbowAntToken> RAINBOW_ANT_TOKEN = ITEMS.register("rainbow_ant_token", RainbowAntToken::new);

    public static final RegistryObject<RawBacon> RAW_BACON = ITEMS.register("raw_bacon", RawBacon::new);
    public static final RegistryObject<RedAntEye> RED_ANT_EYE = ITEMS.register("red_ant_eye", RedAntEye::new);

    public static final RegistryObject<RedAntToken> RED_ANT_TOKEN = ITEMS.register("red_ant_token", RedAntToken::new);

    public static final RegistryObject<Item> ROBOT_FINGER = ITEMS.register("robot_finger", RobotFinger::new);

    public static final RegistryObject<Item> ROBOT_HAND = ITEMS.register("robot_hand", RobotHand::new);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", Salt::new);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", Sapphire::new);

    public static final RegistryObject<Item> STONE_RUNE = ITEMS.register("stone_rune", StoneRune::new);

    public static final RegistryObject<TermiteAbdomen> TERMITE_ABDOMEN = ITEMS.register("termite_abdomen", TermiteAbdomen::new);

    public static final RegistryObject<TermiteEye> TERMITE_EYE = ITEMS.register("termite_eye", TermiteEye::new);

    public static final RegistryObject<TermiteLeg> TERMITE_LEG = ITEMS.register("termite_leg", TermiteLeg::new);

    public static final RegistryObject<TermiteToken> TERMITE_TOKEN = ITEMS.register("termite_token", TermiteToken::new);

    public static final RegistryObject<Item> TITANIUM_CAKE = ITEMS.register("titanium_cake", TitaniumCake::new);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", TitaniumIngot::new);

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", TitaniumNugget::new);
    public static final RegistryObject<Item> WATER_DRAGON_SCALE = ITEMS.register("water_dragon_scale", WaterDragonScale::new);

    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", Wrench::new);

    //Petrified Mob blocks
    public static final RegistryObject<Block> BUTTERFLY_EGG_ORE = BLOCKS.register("butterfly_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> GODZILLA_EGG_ORE = BLOCKS.register("godzilla_egg_ore", BlockMobOre::new);
    public static final RegistryObject<Block> GUARDIAN_EGG_ORE = BLOCKS.register("guardian_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> MAGMA_CUBE_EGG_ORE = BLOCKS.register("magma_cube_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> MUTANT_ZOMBIE_EGG_ORE = BLOCKS.register("mutant_zombie_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> RAINBOW_ANT_EGG_ORE = BLOCKS.register("rainbow_ant_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> REDROSEWARRIOR_EGG_ORE = BLOCKS.register("redrosewarrior_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> STAMPYLONGNOSE_EGG_ORE = BLOCKS.register("petrified_stampylongnose_ore", BlockMobOre::new);

    public static final RegistryObject<Block> TERMITE_EGG_ORE = BLOCKS.register("termite_egg_ore", BlockMobOre::new);

    public static final RegistryObject<Block> TEWTIY_EGG_ORE = BLOCKS.register("petrified_tewtiy_ore", BlockMobOre::new);

    public static final RegistryObject<Block> ZOMBIE_EGG_ORE = BLOCKS.register("petrified_zombie_ore", BlockMobOre::new);


    //Petrified Mob items
    public static final RegistryObject<Item> BUTTERFLY_EGG_ORE_ITEM = ITEMS.register("butterfly_egg_ore", () -> new BlockItemMobOre(BUTTERFLY_EGG_ORE.get()));

    public static final RegistryObject<Item> GODZILLA_EGG_ORE_ITEM = ITEMS.register("godzilla_egg_ore", () -> new BlockItemMobOre(GODZILLA_EGG_ORE.get()));
    public static final RegistryObject<Item> GUARDIAN_EGG_ORE_ITEM = ITEMS.register("guardian_egg_ore", () -> new BlockItemMobOre(GUARDIAN_EGG_ORE.get()));

    public static final RegistryObject<Item> REDROSEWARRIOR_EGG_ORE_ITEM = ITEMS.register("redrosewarrior_egg_ore", () -> new BlockItemMobOre(REDROSEWARRIOR_EGG_ORE.get()));

    public static final RegistryObject<Item> MAGMA_CUBE_EGG_ORE_ITEM = ITEMS.register("magma_cube_egg_ore", () -> new BlockItemMobOre(MAGMA_CUBE_EGG_ORE.get()));

    public static final RegistryObject<Item> Mutant_Zombie_EGG_ORE_ITEM = ITEMS.register("mutant_zombie_egg_ore", () -> new BlockItemMobOre(MUTANT_ZOMBIE_EGG_ORE.get()));

    public static final RegistryObject<Item> RAINBOW_ANT_EGG_ORE_ITEM = ITEMS.register("rainbow_ant_egg_ore", () -> new BlockItemMobOre(RAINBOW_ANT_EGG_ORE.get()));

    public static final RegistryObject<Item> STAMPYLONGNOSE_EGG_ORE_ITEM = ITEMS.register("petrified_stampylongnose_ore", () -> new BlockItemMobOre(STAMPYLONGNOSE_EGG_ORE.get()));

    public static final RegistryObject<Item> TERMITE_EGG_ORE_ITEM = ITEMS.register("termite_egg_ore", () -> new BlockItemMobOre(TERMITE_EGG_ORE.get()));

    public static final RegistryObject<Item> TEWTIY_EGG_ORE_ITEM = ITEMS.register("petrified_tewtiy_ore", () -> new BlockItemMobOre(TEWTIY_EGG_ORE.get()));

    public static final RegistryObject<Item> ZOMBIE_EGG_ORE_ITEM = ITEMS.register("petrified_zombie_ore", () -> new BlockItemMobOre(ZOMBIE_EGG_ORE.get()));

    //Spawn Eggs
    public static final RegistryObject<Item> ALLOSAURUS_SPAWN_EGG = ITEMS.register("allosaurus_spawn_egg", () -> new SpawnEgg(RegistryHandler.ALLOSAURUS, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> ATTACK_SQUID_SPAWN_EGG = ITEMS.register("attack_squid_spawn_egg", () -> new SpawnEgg(RegistryHandler.ATTACK_SQUID, 0, 0,new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> BASILISK_SCALE = ITEMS.register("basilisk_scale", BasiliskScale::new);
    public static final RegistryObject<Item> BEAVER_SPAWN_EGG = ITEMS.register("beaver_spawn_egg", BeaverSpawnEgg::new);

    public static final RegistryObject<Item> BIRD_SPAWN_EGG = ITEMS.register("bird_spawn_egg", () -> new SpawnEgg(RegistryHandler.BIRD, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> BUTTERFLY_SPAWN_EGG = ITEMS.register("butterfly_spawn_egg", () -> new SpawnEgg(RegistryHandler.BUTTERFLY, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> ENT_SPAWN_EGG = ITEMS.register("ent_spawn_egg", () -> new SpawnEgg(RegistryHandler.ENT, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> FIRE_FISH_SPAWN_EGG = ITEMS.register("fire_fish_spawn_egg", FireFishSpawnEgg::new);

    public static final RegistryObject<Item> GODZILLA_SPAWN_EGG = ITEMS.register("godzilla_spawn_egg", () -> new SpawnEgg(RegistryHandler.GODZILLA, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<Item> KING_GHIDORAH_SCALE = ITEMS.register("king_ghidorah_scale", KingGhidorahScale::new);

    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", () -> new SpawnEgg(RegistryHandler.MERMAID, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> MOLDY_SPAWN_EGG = ITEMS.register("moldy_spawn_egg", MoldySpawnEgg::new);

    public static final RegistryObject<SpawnEgg> NOTBREEBREE_SPAWN_EGG = ITEMS.register("notbreebree_spawn_egg", () -> new SpawnEgg(RegistryHandler.NOTBREEBREE, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> RAINBOW_ANT_SPAWN_EGG = ITEMS.register("rainbow_ant_spawn_egg", () -> new SpawnEgg(RegistryHandler.RAINBOWANT, 0, 0, new Item.Properties().group(DangerZone.TAB)));
    public static final RegistryObject<SpawnEgg> RED_ANT_SPAWN_EGG = ITEMS.register("red_ant_spawn_egg", () -> new SpawnEgg(RegistryHandler.RED_ANT, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> RED_COW_SPAWN_EGG = ITEMS.register("red_cow_spawn_egg", () -> new SpawnEgg(RegistryHandler.RED_COW, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> REDROSEWARRIOR_SPAWN_EGG = ITEMS.register("redrosewarrior_spawn_egg", () -> new SpawnEgg(RegistryHandler.REDROSEWARRIOR, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<Item> ROBO_BOMB_SPAWN_EGG = ITEMS.register("robo-bomb_spawn_egg", RoboBombSpawnEgg::new);

    public static final RegistryObject<SpawnEgg> STAMPYLONGNOSE_SPAWN_EGG = ITEMS.register("stampylongnose_spawn_egg", () -> new SpawnEgg(RegistryHandler.STAMPYLONGNOSE, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> TECHNOBLADE_SPAWN_EGG = ITEMS.register("technoblade_spawn_egg", () -> new SpawnEgg(RegistryHandler.TECHNOBLADE, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> TERMITE_SPAWN_EGG = ITEMS.register("termite_spawn_egg", () -> new SpawnEgg(RegistryHandler.TERMITE, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    public static final RegistryObject<SpawnEgg> TEWTIY_SPAWN_EGG = ITEMS.register("tewtiy_spawn_egg", () -> new SpawnEgg(RegistryHandler.TEWTIY, 0, 0, new Item.Properties().group(DangerZone.TAB)));

    //Tools and Weapons

    public static final RegistryObject<CoarseAmethystAxe> COARSE_AMETHYST_AXE = ITEMS.register("coarse_amethyst_axe", CoarseAmethystAxe::new);

    public static final RegistryObject<CoarseAmethystHoe> COARSE_AMETHYST_HOE = ITEMS.register("coarse_amethyst_hoe", CoarseAmethystHoe::new);

    public static final RegistryObject<CoarseAmethystPickaxe> COARSE_AMETHYST_PICKAXE = ITEMS.register("coarse_amethyst_pickaxe", CoarseAmethystPickaxe::new);

    public static final RegistryObject<CoarseAmethystShovel> COARSE_AMETHYST_SHOVEL = ITEMS.register("coarse_amethyst_shovel", CoarseAmethystShovel::new);

    public static final RegistryObject<CoarseAmethystSword> COARSE_AMETHYST_SWORD = ITEMS.register("coarse_amethyst_sword", CoarseAmethystSword::new);

    public static final RegistryObject<CakeSword> CAKE_SWORD = ITEMS.register("cake_sword", CakeSword::new);

    public static final RegistryObject<EmeraldAxe> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);

    public static final RegistryObject<EmeraldHoe> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);

    public static final RegistryObject<EmeraldPickaxe> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);

    public static final RegistryObject<EmeraldShovel> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);

    public static final RegistryObject<EmeraldSword> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);
    public static final RegistryObject<Hammy> HAMMY = ITEMS.register("hammy", Hammy::new);

    public static final RegistryObject<MantisClaw> MANTIS_CLAW = ITEMS.register("mantis_claw", MantisClaw::new);

    public static final RegistryObject<PoppySword> POPPY_SWORD = ITEMS.register("poppy_sword", PoppySword::new);

    public static final RegistryObject<QueenGhidorahScaleBattleAxe> QUEEN_GHIDORAH_SCALE_BATTLE_AXE = ITEMS.register("queen_ghidorah_scale_battle_axe", QueenGhidorahScaleBattleAxe::new);

    public static final RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", SapphireAxe::new);

    public static final RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", SapphireHoe::new);

    public static final RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", SapphirePickaxe::new);

    public static final RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", SapphireShovel::new);

    public static final RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", SapphireSword::new);

    public static final RegistryObject<AluminiumAxe> ALUMINIUM_AXE = ITEMS.register("aluminium_axe", AluminiumAxe::new);

    public static final RegistryObject<AluminiumHoe> ALUMINIUM_HOE = ITEMS.register("aluminium_hoe", AluminiumHoe::new);

    public static final RegistryObject<AluminiumPickaxe> ALUMINIUM_PICKAXE = ITEMS.register("aluminium_pickaxe", AluminiumPickaxe::new);

    public static final RegistryObject<AluminiumShovel> ALUMINIUM_SHOVEL = ITEMS.register("aluminium_shovel", AluminiumShovel::new);

    public static final RegistryObject<GodzillaAxe> GODZILLA_AXE = ITEMS.register("godzilla_axe", GodzillaAxe::new);

    public static final RegistryObject<FireCakeSword> FIRE_CAKE_SWORD = ITEMS.register("fire_cake_sword", FireCakeSword::new);

    public static final RegistryObject<TitaniumCakeSword> TITANIUM_CAKE_SWORD = ITEMS.register("titanium_cake_sword", TitaniumCakeSword::new);
    public static final RegistryObject<TitaniumHoe> TITANIUM_HOE = ITEMS.register("titanium_hoe", TitaniumHoe::new);
    public static final RegistryObject<TitaniumShovel> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", TitaniumShovel::new);
    public static final RegistryObject<TitaniumPickaxe> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", TitaniumPickaxe::new);
    public static final RegistryObject<TitaniumAxe> TITANIUM_AXE = ITEMS.register("titanium_axe", TitaniumAxe::new);

    //SOUNDS
    public static final RegistryObject<SoundEvent> AMOXICILLIN_AMBIENT = SOUNDS.register("amoxcillin_ambient", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "amoxcillin_ambient")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_BREAK = SOUNDS.register("leather_block_break", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_break")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_STEP = SOUNDS.register("leather_block_step", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_step")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_PLACE = SOUNDS.register("leather_block_place", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "leather_block_place")));
    public static final RegistryObject<SoundEvent> LEATHER_BLOCK_HIT = SOUNDS.register("leather_block_hit", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID, "leather_block_hit")));
    public static final RegistryObject<SoundEvent> STAMPYLONGNOSE_AMBIENT = SOUNDS.register("stampylivingsound", () -> new SoundEvent(new ResourceLocation(DangerZone.MOD_ID , "stampylivingsound")));

    public static RegistryObject<Item> conditionallyRegisterItem(String registryName, Supplier<Item> item, Supplier<Boolean> condition) {
        if (condition.get())
            return ITEMS.register(registryName, item);
        return null;
    }
    public static RegistryObject<Block> conditionallyRegisterBlock(String registryName, Supplier<Block> block, Supplier<Boolean> condition) {
        if (condition.get())
            return BLOCKS.register(registryName, block);
        return null;
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }
}
