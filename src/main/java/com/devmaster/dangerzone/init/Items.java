package com.devmaster.dangerzone.init;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.blocks.BlockItemMobOre;
import com.devmaster.dangerzone.items.Amethyst;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.devmaster.dangerzone.DangerZone.TAB;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DangerZone.MODID)
public class Items {

	static Item DEBUG;
	static Item DEV_STICK;

	//region materials //TODO rewrite registry
	public static Item AMETHYST;
	public static Item AMETHYST_PICKAXE;
	public static Item AMETHYST_AXE;
	public static Item AMETHYST_SHOVEL;
	public static Item AMETHYST_SWORD;
	public static Item AMETHYST_HELMET;
	public static Item AMETHYST_CHESTPLATE;
	public static Item AMETHYST_LEGGINGS;
	public static Item AMETHYST_BOOTS;

	public static Item RUBY;
	public static Item RUBY_PICKAXE;
	public static Item RUBY_AXE;
	public static Item RUBY_SHOVEL;
	public static Item RUBY_SWORD;
	public static Item RUBY_HELMET;
	public static Item RUBY_CHESTPLATE;
	public static Item RUBY_LEGGINGS;
	public static Item RUBY_BOOTS;

	public static Item PINK_TOURMALINE;
	public static Item PINK_TOURMALINE_PICKAXE;
	public static Item PINK_TOURMALINE_AXE;
	public static Item PINK_TOURMALINE_SHOVEL;
	public static Item PINK_TOURMALINE_SWORD;
	public static Item PINK_TOURMALINE_HELMET;
	public static Item PINK_TOURMALINE_CHESTPLATE;
	public static Item PINK_TOURMALINE_LEGGINGS;
	public static Item PINK_TOURMALINE_BOOTS;

	public static Item TIGER_EYE;
	public static Item TIGER_EYE_PICKAXE;
	public static Item TIGER_EYE_AXE;
	public static Item TIGER_EYE_SHOVEL;
	public static Item TIGER_EYE_SWORD;
	public static Item TIGER_EYE_HELMET;
	public static Item TIGER_EYE_CHESTPLATE;
	public static Item TIGER_EYE_LEGGINGS;
	public static Item TIGER_EYE_BOOTS;

	public static Item TITANIUM_INGOT;
	public static Item TITANIUM_NUGGET;
	public static Item URANIUM_INGOT;
	public static Item URANIUM_NUGGET;
	public static Item ULTIMATE_PICKAXE;
	public static Item ULTIMATE_AXE;
	public static Item ULTIMATE_SHOVEL;
	public static Item ULTIMATE_SWORD;
	public static Item ULTIMATE_BOW;
	public static Item ULTIMATE_HELMET;
	public static Item ULTIMATE_CHESTPLATE;
	public static Item ULTIMATE_LEGGINGS;
	public static Item ULTIMATE_BOOTS;

	public static Item LAPIS_PICKAXE;
	public static Item LAPIS_AXE;
	public static Item LAPIS_SHOVEL;
	public static Item LAPIS_SWORD;
	public static Item LAPIS_HELMET;
	public static Item LAPIS_CHESTPLATE;
	public static Item LAPIS_LEGGINGS;
	public static Item LAPIS_BOOTS;

	public static Item LAVA_CRYSTAL;
	public static Item LAVA_HELMET;
	public static Item LAVA_CHESTPLATE;
	public static Item LAVA_LEGGINGS;
	public static Item LAVA_BOOTS;

	//endregion

	public static Item BATTLE_AXE;
	public static Item BIG_HAMMER;
	public static Item QUEEN_BATTLE_AXE;

	public static Item ZANGETSU_GUARD;
	public static Item ZANGETSU_BLADE;
	public static Item ZANGETSU_HANDLE;
	public static Item ZANGETSU;

	//TODO find out how to do these
	//public static Item rayGun;
	//public static Item squidzookaSmall;

	//public static Item thunder; TODO find out what this does again

	//region misc
	public static Item ENDER_DRAGON_SPAWN_EGG;
	public static Item WITHER_SPAWN_EGG;
	public static Item IRON_GOLEM_SPAWN_EGG;
	public static Item SNOW_GOLEM_SPAWN_EGG;

	public static Item INSTANT_NETHER_PORTAL;
	public static Item INSTANT_SHELTER;
	public static Item INSTANT_GARDEN;
	public static Item MINERS_DREAM;

	public static Item STAIRS_UP;
	public static Item STAIRS_DOWN;
	public static Item BRIDGE;

	public static Item STRUCTURE_TRACKER;

	public static Item RED_SHOE;

	//discs
	public static Item BLANK_DISC;

	//public static Item disc;

	public static Item ENDER_DRAGON_TOOTH;
	public static Item MOLE_NOSE;
	public static Item TRIFFID_GOO;
	public static Item TREX_TOOTH;
	public static Item KRAKEN_TOOTH;
	public static Item SERPENT_TONGUE;
	public static Item MANTIS_CLAW;
	public static Item SCORPION_TAIL;
	public static Item BASILISC_SCALE;
	public static Item NYTEMAIR_SCALE;
	public static Item KATTERKILLER_JAW;

	//endregion


	//region item that are not registered here
	public static Item GIANT_MOLE_SPAWN_EGG;
	public static Item TRIFFID_SPAWN_EGG;
	public static Item MOTHRA_SPAWN_EGG;
	public static Item KATTERKILLER_SPAWN_EGG;
	public static Item TREX_SPAWN_EGG;
	public static Item KRAKEN_SPAWN_EGG;
	public static Item NYTEMAIR_SPAWN_EGG;
	public static Item WATER_DRAGON_SPAWN_EGG;

	public static Item APPLE_COW_SPAWN_EGG;
	public static Item GOLDEN_APPLE_COW_SPAWN_EGG;
	public static Item ENCHANTED_APPLE_COW_SPAWN_EGG;

	public static Item GIRLFRIEND_SPAWN_EGG;

	//endregion


	//region Blocks
	public static Item AMETHYST_BLOCK;
	public static Item AMETHYST_ORE;
	public static Item RUBY_BLOCK;
	public static Item RUBY_ORE;
	public static Item TITANIUM_BLOCK;
	public static Item TITANIUM_ORE;
	public static Item URANIUM_BLOCK;
	public static Item URANIUM_ORE;
	public static Item PINK_TOURMALINE_BLOCK;
	public static Item PINK_TOURMALINE_ORE;
	public static Item TIGER_EYE_BLOCK;
	public static Item TIGER_EYE_ORE;

	public static Item BAT_EGG_ORE;
	public static Item BLAZE_EGG_ORE;
	public static Item CAVE_SPIDER_EGG_ORE;
	public static Item CHICKEN_EGG_ORE;
	public static Item CAT_EGG_ORE;
	public static Item COW_EGG_ORE;
	public static Item COD_EGG_ORE;
	public static Item CREEPER_EGG_ORE;
	public static Item DOLPHIN_EGG_ORE;
	public static Item DONKEY_EGG_ORE;
	public static Item DROWNED_EGG_ORE;
	public static Item ELDER_GUARDIAN_EGG_ORE;
	public static Item ENDER_DRAGON_EGG_ORE;
	public static Item ENDERMAN_EGG_ORE;
	public static Item ENDERMITE_EGG_ORE;
	public static Item EVOKER_EGG_ORE;
	public static Item FOX_EGG_ORE;
	public static Item GHAST_EGG_ORE;
	public static Item GUARDIAN_EGG_ORE;
	public static Item HORSE_EGG_ORE;
	public static Item HUSK_EGG_ORE;
	public static Item IRON_GOLEM_EGG_ORE;
	public static Item LLAMA_EGG_ORE;
	public static Item MAGMA_CUBE_EGG_ORE;
	public static Item MOOSHROOM_EGG_ORE;
	public static Item MULE_EGG_ORE;
	public static Item OCELOT_EGG_ORE;
	public static Item PANDA_EGG_ORE;
	public static Item PARROT_EGG_ORE;
	public static Item PHANTOM_EGG_ORE;
	public static Item PIG_EGG_ORE;
	public static Item PILLAGER_EGG_ORE;
	public static Item POLAR_BEAR_EGG_ORE;
	public static Item RABBIT_EGG_ORE;
	public static Item RAVAGER_EGG_ORE;
	public static Item SHEEP_EGG_ORE;
	public static Item SHULKER_EGG_ORE;
	public static Item SKELETON_EGG_ORE;
	public static Item SLIME_EGG_ORE;
	public static Item SNOW_GOLEM_EGG_ORE;
	public static Item SPIDER_EGG_ORE;
	public static Item SQUID_EGG_ORE;
	public static Item STRAY_EGG_ORE;
	public static Item TURTLE_EGG_ORE;
	public static Item VILLAGER_EGG_ORE;
	public static Item VINDICATOR_EGG_ORE;
	public static Item WANDERING_TRADER_EGG_ORE;
	public static Item WITCH_EGG_ORE;
	public static Item WITHER_EGG_ORE;
	public static Item WITHER_SKELETON_EGG_ORE;
	public static Item WOLF_EGG_ORE;
	public static Item ZOMBIE_EGG_ORE;
	public static Item ZOMBIE_HORSE_EGG_ORE;
	public static Item ZOMBIE_PIGMAN_EGG_ORE;
	public static Item ZOMBIE_VILLAGER_EGG_ORE;

	public static Item ENDER_EYE_BLOCK;
	public static Item ENDER_PEARL_BLOCK;


	//endregion

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
	//if(InsanityOverworld.debug) {
		//	event.getRegistry().registerAll(
				//	DEBUG = new ItemDebug(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("debug"),
			//		DEV_STICK = new ItemDevStick().setRegistryName("dev_stick")
					//);
	//	}

		event.getRegistry().registerAll(

				//region materials
				AMETHYST = new Amethyst().setRegistryName("amethyst"),
			//	AMETHYST_PICKAXE = new PickaxeItem(AMETHYST_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_pickaxe"),
			//	AMETHYST_AXE = new AxeItem(AMETHYST_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_axe"),
			//	AMETHYST_SHOVEL = new ShovelItem(AMETHYST_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_shovel"),
			//	AMETHYST_SWORD = new SwordItem(AMETHYST_TIER, 3, -2F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_sword"),
			//	AMETHYST_HELMET = new ArmorItem(AMETHYST_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_helmet"),
			//	AMETHYST_CHESTPLATE = new ArmorItem(AMETHYST_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_chestplate"),
			//	AMETHYST_LEGGINGS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_leggings"),
			//	AMETHYST_BOOTS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("amethyst_boots"),

			//	RUBY = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby"),
			//	RUBY_PICKAXE = new PickaxeItem(RUBY_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_pickaxe"),
				//RUBY_AXE = new AxeItem(RUBY_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_axe"),
				//RUBY_SHOVEL = new ShovelItem(RUBY_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_shovel"),
			//	RUBY_SWORD = new SwordItem(RUBY_TIER, 3, -1.7F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_sword"),
			//	RUBY_HELMET = new ArmorItem(RUBY_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_helmet"),
			//	RUBY_CHESTPLATE = new ArmorItem(RUBY_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_chestplate"),
			//	RUBY_LEGGINGS = new ArmorItem(RUBY_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_leggings"),
			//	RUBY_BOOTS = new ArmorItem(RUBY_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ruby_boots"),

			//	PINK_TOURMALINE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline"),
			//	PINK_TOURMALINE_PICKAXE = new PickaxeItem(PINK_TOURMALINE_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_pickaxe"),
				//PINK_TOURMALINE_AXE = new AxeItem(PINK_TOURMALINE_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_axe"),
			//	PINK_TOURMALINE_SHOVEL = new ShovelItem(PINK_TOURMALINE_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_shovel"),
			//	PINK_TOURMALINE_SWORD = new SwordItem(PINK_TOURMALINE_TIER, 3, -2F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_sword"),
			//	PINK_TOURMALINE_HELMET = new ArmorItem(PINK_TOURMALINE_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_helmet"),
			//	PINK_TOURMALINE_CHESTPLATE = new ArmorItem(PINK_TOURMALINE_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_chestplate"),
			//	PINK_TOURMALINE_LEGGINGS = new ArmorItem(PINK_TOURMALINE_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_leggings"),
			//	PINK_TOURMALINE_BOOTS = new ArmorItem(PINK_TOURMALINE_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("pink_tourmaline_boots"),

				//TIGER_EYE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye"),
				//TIGER_EYE_PICKAXE = new PickaxeItem(TIGER_EYE_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_pickaxe"),
				//TIGER_EYE_AXE = new AxeItem(TIGER_EYE_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_axe"),
				//TIGER_EYE_SHOVEL = new ShovelItem(TIGER_EYE_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_shovel"),
				//TIGER_EYE_SWORD = new SwordItem(TIGER_EYE_TIER, 3, -2F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_sword"),
				//TIGER_EYE_HELMET = new ArmorItem(TIGER_EYE_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_helmet"),
				//TIGER_EYE_CHESTPLATE = new ArmorItem(TIGER_EYE_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_chestplate"),
				//TIGER_EYE_LEGGINGS = new ArmorItem(TIGER_EYE_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_leggings"),
				//TIGER_EYE_BOOTS = new ArmorItem(TIGER_EYE_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("tiger_eye_boots"),

				//TITANIUM_INGOT = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("titanium_ingot"),
			//	TITANIUM_NUGGET = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("titanium_nugget"),
			//	URANIUM_INGOT = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("uranium_ingot"),
			//	URANIUM_NUGGET = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("uranium_nugget"),
			//	ULTIMATE_PICKAXE = new EnchantedPickaxe(ULTIMATE_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_pickaxe"),
			//	ULTIMATE_AXE = new EnchantedAxeItem(ULTIMATE_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_axe"),
			//	ULTIMATE_SHOVEL = new EnchantedShovelItem(ULTIMATE_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_shovel"),
				//ULTIMATE_SWORD = new EnchantedSwordItem(ULTIMATE_TIER, 3, -1.3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_sword"),
				//ULTIMATE_BOW = new UltimateBowItem(new Item.Properties().group(DEFAULT_GROUP).maxStackSize(1).defaultMaxDamage(1000)).setRegistryName("ultimate_bow"),
				//ULTIMATE_HELMET = new EnchantedArmorItem(ULTIMATE_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_helmet"),
				//ULTIMATE_CHESTPLATE = new EnchantedArmorItem(ULTIMATE_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_chestplate"),
				//ULTIMATE_LEGGINGS = new EnchantedArmorItem(ULTIMATE_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_leggings"),
			//	ULTIMATE_BOOTS = new EnchantedArmorItem(ULTIMATE_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ultimate_boots"),

				//LAPIS_PICKAXE = new EnchantedPickaxe(LAPIS_TIER, 1, -2.8F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_pickaxe"),
			//	LAPIS_AXE = new EnchantedAxeItem(LAPIS_TIER, 6, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_axe"),
				//LAPIS_SHOVEL = new EnchantedShovelItem(LAPIS_TIER, 0, -3F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_shovel"),
				//LAPIS_SWORD = new EnchantedSwordItem(LAPIS_TIER, 3, -2F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_sword"),
			//	LAPIS_HELMET = new EnchantedArmorItem(LAPIS_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_helmet"),
				//LAPIS_CHESTPLATE = new EnchantedArmorItem(LAPIS_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_chestplate"),
				//LAPIS_LEGGINGS = new EnchantedArmorItem(LAPIS_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_leggings"),
			//	LAPIS_BOOTS = new EnchantedArmorItem(LAPIS_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lapis_boots"),

			//	LAVA_CRYSTAL = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lava_crystal"),
			//	LAVA_HELMET = new EnchantedArmorItem(LAVA_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lava_helmet"),
				//LAVA_CHESTPLATE = new EnchantedArmorItem(LAVA_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lava_chestplate"),
				//LAVA_LEGGINGS = new EnchantedArmorItem(LAVA_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lava_leggings"),
				//LAVA_BOOTS = new EnchantedArmorItem(LAVA_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("lava_boots"),

				//endregion

			//	ZANGETSU = new EnchantedSwordItem(ZANGETSU_TIER, 3, -2F, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("zangetsu"),
				//ZANGETSU_BLADE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("zangetsu_blade"),
			//	ZANGETSU_HANDLE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("zangetsu_handle"),
			//	ZANGETSU_GUARD = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("zangetsu_guard"),

				//region Boss Drops

			//	ENDER_DRAGON_TOOTH = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("ender_dragon_tooth"),
			//	MOLE_NOSE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("giant_mole_nose"),
			//	SERPENT_TONGUE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("sea_serpent_tongue"),
			//	KATTERKILLER_JAW = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("katterkiller_jaw"),
			//	BASILISC_SCALE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("basilisc_scale"),
			//	NYTEMAIR_SCALE = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("nytemair_scale"),
			//	TREX_TOOTH = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("trex_tooth"),
			//	KRAKEN_TOOTH = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("kraken_tooth"),
			//	TRIFFID_GOO = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("triffid_goo"),

			//	MANTIS_CLAW = new SpecialSwordItem(MANTIS_CLAW_TIER, 3, -2.4f, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("mantis_claw"),
			//	SCORPION_TAIL = new SpecialSwordItem(SCORPION_TAIL_TIER, 3, -2.4f, new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("scorpion_tail"),

				//endregion



				//region misc

			//	INSTANT_NETHER_PORTAL = new InstaNetherPortalItem().setRegistryName("insta_nether_portal"),
			//	INSTANT_SHELTER = new InstaShelterItem().setRegistryName("insta_shelter"),
			//	INSTANT_GARDEN = new InstaGardenItem().setRegistryName("insta_garden"),
			//	MINERS_DREAM = new MinersDreamItem().setRegistryName("miners_dream"),

			//	BRIDGE = new StairItem().setRegistryName("bridge"),
			//	STAIRS_UP = new StairItem().setRegistryName("stairs_up"),
			//	STAIRS_DOWN = new StairItem().setRegistryName("stairs_down"),

				//STRUCTURE_TRACKER = new TrackerItem().setRegistryName("structure_tracker"),

			//	RED_SHOE = new ShoeItem().setRegistryName("red_shoe"),

			//	ENDER_DRAGON_SPAWN_EGG = new SpawnEggItem(EntityType.ENDER_DRAGON, 0, 1447446, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("enderdragon_spawn_egg"),
				//WITHER_SPAWN_EGG = new SpawnEggItem(EntityType.WITHER, 4672845, 1315860, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("wither_spawn_egg"),
			//	IRON_GOLEM_SPAWN_EGG = new SpawnEggItem(EntityType.IRON_GOLEM, 13545366, 14144467, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("iron_golem_spawn_egg"),
			//	SNOW_GOLEM_SPAWN_EGG = new SpawnEggItem(EntityType.SNOW_GOLEM, 15921906, 15690005, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("snow_golem_spawn_egg"),

			//	BLANK_DISC = new Item(new Item.Properties().group(DEFAULT_GROUP)).setRegistryName("blank_disc"),

				//endregion

				//region Blocks
				AMETHYST_BLOCK = registerItemBlock(Blocks.AMETHYST_BLOCK),
				AMETHYST_ORE = registerItemBlock(Blocks.AMETHYST_ORE_BLOCK),
			//	RUBY_BLOCK = registerItemBlock(Blocks.RUBY_BLOCK),
				//RUBY_ORE = registerItemBlock(Blocks.RUBY_ORE),
			//	TITANIUM_BLOCK = registerItemBlock(Blocks.TITANIUM_BLOCK),
				//TITANIUM_ORE = registerItemBlock(Blocks.TITANIUM_ORE),
			//	URANIUM_BLOCK = registerItemBlock(Blocks.URANIUM_BLOCK),
				//URANIUM_ORE = registerItemBlock(Blocks.URANIUM_ORE),
			//	PINK_TOURMALINE_BLOCK = registerItemBlock(Blocks.PINK_TOURMALINE_BLOCK),
			//	PINK_TOURMALINE_ORE = registerItemBlock(Blocks.PINK_TOURMALINE_ORE),
				//TIGER_EYE_BLOCK = registerItemBlock(Blocks.TIGER_EYE_BLOCK),
				//TIGER_EYE_ORE = registerItemBlock(Blocks.TIGER_EYE_ORE),

				//region Egg Ores
				BAT_EGG_ORE = registerItemBlockMobOre(Blocks.BAT_EGG_ORE),
				BLAZE_EGG_ORE = registerItemBlockMobOre(Blocks.BLAZE_EGG_ORE),
				CAT_EGG_ORE = registerItemBlockMobOre(Blocks.CAT_EGG_ORE),
				CAVE_SPIDER_EGG_ORE = registerItemBlockMobOre(Blocks.CAVE_SPIDER_EGG_ORE),
				CHICKEN_EGG_ORE = registerItemBlockMobOre(Blocks.CHICKEN_EGG_ORE),
				COW_EGG_ORE = registerItemBlockMobOre(Blocks.COW_EGG_ORE),
				COD_EGG_ORE = registerItemBlockMobOre(Blocks.COD_EGG_ORE),
				CREEPER_EGG_ORE = registerItemBlockMobOre(Blocks.CREEPER_EGG_ORE),
				DOLPHIN_EGG_ORE = registerItemBlockMobOre(Blocks.DOLPHIN_EGG_ORE),
				DONKEY_EGG_ORE = registerItemBlockMobOre(Blocks.DONKEY_EGG_ORE),
				DROWNED_EGG_ORE = registerItemBlockMobOre(Blocks.DROWNED_EGG_ORE),
				ELDER_GUARDIAN_EGG_ORE = registerItemBlockMobOre(Blocks.ELDER_GUARDIAN_EGG_ORE),
				ENDER_DRAGON_EGG_ORE = registerItemBlockMobOre(Blocks.ENDER_DRAGON_EGG_ORE),
				ENDERMAN_EGG_ORE = registerItemBlockMobOre(Blocks.ENDERMAN_EGG_ORE),
				ENDERMITE_EGG_ORE = registerItemBlockMobOre(Blocks.ENDERMITE_EGG_ORE),
				EVOKER_EGG_ORE = registerItemBlockMobOre(Blocks.EVOKER_EGG_ORE),
				FOX_EGG_ORE = registerItemBlockMobOre(Blocks.FOX_EGG_ORE),
				GHAST_EGG_ORE = registerItemBlockMobOre(Blocks.GHAST_EGG_ORE),
				GUARDIAN_EGG_ORE = registerItemBlockMobOre(Blocks.GUARDIAN_EGG_ORE),
				HORSE_EGG_ORE = registerItemBlockMobOre(Blocks.HORSE_EGG_ORE),
				HUSK_EGG_ORE = registerItemBlockMobOre(Blocks.HUSK_EGG_ORE),
				IRON_GOLEM_EGG_ORE = registerItemBlockMobOre(Blocks.IRON_GOLEM_EGG_ORE),
				LLAMA_EGG_ORE = registerItemBlockMobOre(Blocks.LLAMA_EGG_ORE),
				MAGMA_CUBE_EGG_ORE = registerItemBlockMobOre(Blocks.MAGMA_CUBE_EGG_ORE),
				MOOSHROOM_EGG_ORE = registerItemBlockMobOre(Blocks.MOOSHROOM_EGG_ORE),
				MULE_EGG_ORE = registerItemBlockMobOre(Blocks.MULE_EGG_ORE),
				OCELOT_EGG_ORE = registerItemBlockMobOre(Blocks.OCELOT_EGG_ORE),
				PANDA_EGG_ORE = registerItemBlockMobOre(Blocks.PANDA_EGG_ORE),
				PARROT_EGG_ORE = registerItemBlockMobOre(Blocks.PARROT_EGG_ORE),
				PHANTOM_EGG_ORE = registerItemBlockMobOre(Blocks.PHANTOM_EGG_ORE),
				PIG_EGG_ORE = registerItemBlockMobOre(Blocks.PIG_EGG_ORE),
				PILLAGER_EGG_ORE = registerItemBlockMobOre(Blocks.PILLAGER_EGG_ORE),
				POLAR_BEAR_EGG_ORE = registerItemBlockMobOre(Blocks.POLAR_BEAR_EGG_ORE),
				RABBIT_EGG_ORE = registerItemBlockMobOre(Blocks.RABBIT_EGG_ORE),
				RAVAGER_EGG_ORE = registerItemBlockMobOre(Blocks.RAVAGER_EGG_ORE),
				SHEEP_EGG_ORE = registerItemBlockMobOre(Blocks.SHEEP_EGG_ORE),
				SHULKER_EGG_ORE = registerItemBlockMobOre(Blocks.SHULKER_EGG_ORE),
				SKELETON_EGG_ORE = registerItemBlockMobOre(Blocks.SKELETON_EGG_ORE),
				SLIME_EGG_ORE = registerItemBlockMobOre(Blocks.SLIME_EGG_ORE),
				SNOW_GOLEM_EGG_ORE = registerItemBlockMobOre(Blocks.SNOW_GOLEM_EGG_ORE),
				SPIDER_EGG_ORE = registerItemBlockMobOre(Blocks.SPIDER_EGG_ORE),
				SQUID_EGG_ORE = registerItemBlockMobOre(Blocks.SQUID_EGG_ORE),
				STRAY_EGG_ORE = registerItemBlockMobOre(Blocks.STRAY_EGG_ORE),
				TURTLE_EGG_ORE = registerItemBlockMobOre(Blocks.TURTLE_EGG_ORE),
				VILLAGER_EGG_ORE = registerItemBlockMobOre(Blocks.VILLAGER_EGG_ORE),
				VINDICATOR_EGG_ORE = registerItemBlockMobOre(Blocks.VINDICATOR_EGG_ORE),
				WANDERING_TRADER_EGG_ORE = registerItemBlockMobOre(Blocks.WANDERING_TRADER_EGG_ORE),
				WITCH_EGG_ORE = registerItemBlockMobOre(Blocks.WITCH_EGG_ORE),
				WITHER_EGG_ORE = registerItemBlockMobOre(Blocks.WITHER_EGG_ORE),
				WITHER_SKELETON_EGG_ORE = registerItemBlockMobOre(Blocks.WITHER_SKELETON_EGG_ORE),
				WOLF_EGG_ORE = registerItemBlockMobOre(Blocks.WOLF_EGG_ORE),
				ZOMBIE_EGG_ORE = registerItemBlockMobOre(Blocks.ZOMBIE_EGG_ORE),
				ZOMBIE_HORSE_EGG_ORE = registerItemBlockMobOre(Blocks.ZOMBIE_HORSE_EGG_ORE),
				ZOMBIE_PIGMAN_EGG_ORE = registerItemBlockMobOre(Blocks.ZOMBIE_PIGMAN_EGG_ORE),
				ZOMBIE_VILLAGER_EGG_ORE = registerItemBlockMobOre(Blocks.ZOMBIE_VILLAGER_EGG_ORE)


				//endregion

			//	ENDER_EYE_BLOCK = registerItemBlock(Blocks.ENDER_EYE_BLOCK),
			//	ENDER_PEARL_BLOCK = registerItemBlock(Blocks.ENDER_PEARL_BLOCK)

				//endregion


				);

	}

	private static Item registerItemBlock(Block block, ItemGroup itemGroup) {
		return new BlockItem(block, new Item.Properties().group(itemGroup)).setRegistryName(block.getRegistryName());
	}

	private static Item registerItemBlock(Block block) {
		return new BlockItem(block, new Item.Properties().group(TAB)).setRegistryName(block.getRegistryName());
	}

	private static Item registerItemBlockMobOre(Block block) {
		return new BlockItemMobOre(block);
	}


}
