package com.devmaster.dangerzone.init;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.blocks.AmethystBlock;
import com.devmaster.dangerzone.blocks.AmethystOreBlock;
import com.devmaster.dangerzone.blocks.BlockMobOre;
import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static net.minecraftforge.common.ToolType.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DangerZone.MODID)
public class Blocks {

	//region Materials
	public static Block AMETHYST_BLOCK;
	public static Block AMETHYST_ORE_BLOCK;
	public static Block RUBY_BLOCK;
	public static Block RUBY_ORE;
	public static Block TITANIUM_BLOCK;
	public static Block TITANIUM_ORE;
	public static Block URANIUM_BLOCK;
	public static Block URANIUM_ORE;
	public static Block PINK_TOURMALINE_BLOCK;
	public static Block PINK_TOURMALINE_ORE;
	public static Block TIGER_EYE_BLOCK;
	public static Block TIGER_EYE_ORE;
	//endregion

	//region vanilla eggs
	public static Block BAT_EGG_ORE;
	public static Block BLAZE_EGG_ORE;
	public static Block CAT_EGG_ORE;
	public static Block CAVE_SPIDER_EGG_ORE;
	public static Block CHICKEN_EGG_ORE;
	public static Block COD_EGG_ORE;
	public static Block COW_EGG_ORE;
	public static Block CREEPER_EGG_ORE;
	public static Block DOLPHIN_EGG_ORE;
	public static Block DONKEY_EGG_ORE;
	public static Block DROWNED_EGG_ORE;
	public static Block ELDER_GUARDIAN_EGG_ORE;
	public static Block ENDER_DRAGON_EGG_ORE;
	public static Block ENDERMAN_EGG_ORE;
	public static Block ENDERMITE_EGG_ORE;
	public static Block EVOKER_EGG_ORE;
	public static Block FOX_EGG_ORE;
	public static Block GHAST_EGG_ORE;
	public static Block GUARDIAN_EGG_ORE;
	public static Block HORSE_EGG_ORE;
	public static Block HUSK_EGG_ORE;
	public static Block IRON_GOLEM_EGG_ORE;
	public static Block LLAMA_EGG_ORE;
	public static Block MAGMA_CUBE_EGG_ORE;
	public static Block MOOSHROOM_EGG_ORE;
	public static Block MULE_EGG_ORE;
	public static Block OCELOT_EGG_ORE;
	public static Block PANDA_EGG_ORE;
	public static Block PARROT_EGG_ORE;
	public static Block PHANTOM_EGG_ORE;
	public static Block PIG_EGG_ORE;
	public static Block PILLAGER_EGG_ORE;
	public static Block POLAR_BEAR_EGG_ORE;
	public static Block PUFFERFISH_EGG_ORE;
	public static Block RABBIT_EGG_ORE;
	public static Block RAVAGER_EGG_ORE;
	public static Block SALMON_EGG_ORE;
	public static Block SHEEP_EGG_ORE;
	public static Block SHULKER_EGG_ORE;
	public static Block SILVERFISH_EGG_ORE;
	public static Block SKELETON_EGG_ORE;
	public static Block SKELETON_HORSE_EGG_ORE;
	public static Block SLIME_EGG_ORE;
	public static Block SNOW_GOLEM_EGG_ORE;
	public static Block SPIDER_EGG_ORE;
	public static Block SQUID_EGG_ORE;
	public static Block STRAY_EGG_ORE;
	public static Block TRADER_LLAMA_EGG_ORE;
	public static Block TROPICAL_FISH_EGG_ORE;
	public static Block TURTLE_EGG_ORE;
	public static Block VEX_EGG_ORE;
	public static Block VILLAGER_EGG_ORE;
	public static Block VINDICATOR_EGG_ORE;
	public static Block WANDERING_TRADER_EGG_ORE;
	public static Block WITCH_EGG_ORE;
	public static Block WITHER_EGG_ORE;
	public static Block WITHER_SKELETON_EGG_ORE;
	public static Block WOLF_EGG_ORE;
	public static Block ZOMBIE_EGG_ORE;
	public static Block ZOMBIE_HORSE_EGG_ORE;
	public static Block ZOMBIE_PIGMAN_EGG_ORE;
	public static Block ZOMBIE_VILLAGER_EGG_ORE;

	//endregion

	//region misc


	//endregion



	//region Not usable blocks
	public static Block appleBlock;
	public static Block goldenAppleBlock;

	//endregion

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				//region Materials
				AMETHYST_BLOCK = new AmethystBlock().setRegistryName("amethyst_block"),
				AMETHYST_ORE_BLOCK = new AmethystOreBlock().setRegistryName("amethyst_ore_block"),
			//	RUBY_BLOCK = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("ruby_block"),
				//RUBY_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("ruby_ore"),

				//TITANIUM_BLOCK = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("titanium_block"),
			//	TITANIUM_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(8.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("titanium_ore"),
				//URANIUM_BLOCK = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("uranium_block"),
				//URANIUM_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(8.0F, 4.0F).harvestTool(PICKAXE)).setRegistryName("uranium_ore"),

				//PINK_TOURMALINE_BLOCK = new GlassBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).harvestTool(PICKAXE).notSolid()).setRegistryName("pink_tourmaline_block"),
				//PINK_TOURMALINE_ORE = new GlassBlock(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(5.0F, 4.0F).harvestTool(PICKAXE).notSolid()).setRegistryName("pink_tourmaline_ore"),

			//	TIGER_EYE_BLOCK = new GlassBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).harvestTool(PICKAXE).notSolid()).setRegistryName("tiger_eye_block"),
				//TIGER_EYE_ORE = new GlassBlock(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(5.0F, 4.0F).harvestTool(PICKAXE).notSolid()).setRegistryName("tiger_eye_ore"),
				//endregion


				//region vanilla eggs
				BAT_EGG_ORE = new BlockMobOre(getLocation("bat_ore")),
				BLAZE_EGG_ORE = new BlockMobOre(getLocation("blaze_ore")),
				CAT_EGG_ORE = new BlockMobOre(getLocation("cat_ore")),
				CAVE_SPIDER_EGG_ORE = new BlockMobOre(getLocation("cavespider_ore")),
				CHICKEN_EGG_ORE = new BlockMobOre(getLocation("chicken_ore")),
				COD_EGG_ORE = new BlockMobOre(getLocation("cod_ore")),
				COW_EGG_ORE = new BlockMobOre(getLocation("cow_ore")),
				CREEPER_EGG_ORE = new BlockMobOre(getLocation("creeper_ore")),
				DOLPHIN_EGG_ORE = new BlockMobOre(getLocation("dolphin_ore")),
				DONKEY_EGG_ORE = new BlockMobOre(getLocation("donkey_ore")),
				DROWNED_EGG_ORE = new BlockMobOre(getLocation("drowned_ore")),
				ELDER_GUARDIAN_EGG_ORE = new BlockMobOre(getLocation("elder_guardian_ore")),
				ENDER_DRAGON_EGG_ORE = new BlockMobOre(getLocation("enderdragon_ore")),
				ENDERMAN_EGG_ORE = new BlockMobOre(getLocation("enderman_ore")),
				ENDERMITE_EGG_ORE = new BlockMobOre(getLocation("endermite_ore")),
				EVOKER_EGG_ORE = new BlockMobOre(getLocation("evoker_ore")),
				FOX_EGG_ORE = new BlockMobOre(getLocation("fox_ore")),
				GHAST_EGG_ORE = new BlockMobOre(getLocation("ghast_ore")),
				GUARDIAN_EGG_ORE = new BlockMobOre(getLocation("guardian_ore")),
				HORSE_EGG_ORE = new BlockMobOre(getLocation("horse_ore")),
				HUSK_EGG_ORE = new BlockMobOre(getLocation("husk_ore")),
				IRON_GOLEM_EGG_ORE = new BlockMobOre(getLocation("iron_golem_ore")),
				LLAMA_EGG_ORE = new BlockMobOre(getLocation("llama_ore")),
				MAGMA_CUBE_EGG_ORE = new BlockMobOre(getLocation("magmacube_ore")),
				MOOSHROOM_EGG_ORE = new BlockMobOre(getLocation("mooshroom_ore")),
				MULE_EGG_ORE = new BlockMobOre(getLocation("mule_ore")),
				OCELOT_EGG_ORE = new BlockMobOre(getLocation("ocelot_ore")),
				PANDA_EGG_ORE = new BlockMobOre(getLocation("panda_ore")),
				PARROT_EGG_ORE = new BlockMobOre(getLocation("parrot_ore")),
				PHANTOM_EGG_ORE = new BlockMobOre(getLocation("phantom_ore")),
				PIG_EGG_ORE = new BlockMobOre(getLocation("pig_ore")),
				PILLAGER_EGG_ORE = new BlockMobOre(getLocation("pillager_ore")),
				POLAR_BEAR_EGG_ORE = new BlockMobOre(getLocation("polarbear_ore")),
				PUFFERFISH_EGG_ORE = new BlockMobOre(getLocation("pufferfish_ore")),
				RABBIT_EGG_ORE = new BlockMobOre(getLocation("rabbit_ore")),
				RAVAGER_EGG_ORE = new BlockMobOre(getLocation("ravager_ore")),
				SALMON_EGG_ORE = new BlockMobOre(getLocation("salmon_ore")),
				SHEEP_EGG_ORE = new BlockMobOre(getLocation("sheep_ore")),
				SHULKER_EGG_ORE = new BlockMobOre(getLocation("shulker_ore")),
				SILVERFISH_EGG_ORE = new BlockMobOre(getLocation("silverfish_ore")),
				SKELETON_EGG_ORE = new BlockMobOre(getLocation("skeleton_ore")),
				SKELETON_HORSE_EGG_ORE = new BlockMobOre(getLocation("skeleton_horse_ore")),
				SLIME_EGG_ORE = new BlockMobOre(getLocation("slime_ore")),
				SNOW_GOLEM_EGG_ORE = new BlockMobOre(getLocation("snow_golem_ore")),
				SPIDER_EGG_ORE = new BlockMobOre(getLocation("spider_ore")),
				SQUID_EGG_ORE = new BlockMobOre(getLocation("squid_ore")),
				STRAY_EGG_ORE = new BlockMobOre(getLocation("stray_ore")),
				TRADER_LLAMA_EGG_ORE = new BlockMobOre(getLocation("trader_llama_ore")),
				TROPICAL_FISH_EGG_ORE = new BlockMobOre(getLocation("tropical_fish_ore")),
				TURTLE_EGG_ORE = new BlockMobOre(getLocation("turtle_ore")),
				VEX_EGG_ORE = new BlockMobOre(getLocation("vex_ore")),
				VILLAGER_EGG_ORE = new BlockMobOre(getLocation("villager_ore")),
				VINDICATOR_EGG_ORE = new BlockMobOre(getLocation("vindicator_ore")),
				WANDERING_TRADER_EGG_ORE = new BlockMobOre(getLocation("wandering_trader_ore")),
				WITCH_EGG_ORE = new BlockMobOre(getLocation("witch_ore")),
				WITHER_EGG_ORE = new BlockMobOre(getLocation("wither_ore")),
				WITHER_SKELETON_EGG_ORE = new BlockMobOre(getLocation("wither_skeleton_ore")),
				WOLF_EGG_ORE = new BlockMobOre(getLocation("wolf_ore")),
				ZOMBIE_EGG_ORE = new BlockMobOre(getLocation("zombie_ore")),
				ZOMBIE_HORSE_EGG_ORE = new BlockMobOre(getLocation("zombie_horse_ore")),
				ZOMBIE_PIGMAN_EGG_ORE = new BlockMobOre(getLocation("zombie_pigman_ore")),
				ZOMBIE_VILLAGER_EGG_ORE = new BlockMobOre(getLocation("zombie_villager_ore"))

				//endregion

				//region misc
				//endregion

				//region not usable blocks
			//	appleBlock = new MushroomBlock(Block.Properties.create(Material.AIR)).setRegistryName("apple_block"),
			//	goldenAppleBlock = new MushroomBlock(Block.Properties.create(Material.AIR)).setRegistryName("golden_apple_block")
				//endregion
		);

	}

	//public static void setRenderLayers() {
	//	RenderTypeLookup.setRenderLayer(PINK_TOURMALINE_BLOCK, RenderType.getTranslucent());
	//	RenderTypeLookup.setRenderLayer(PINK_TOURMALINE_ORE, RenderType.getTranslucent());
	//	RenderTypeLookup.setRenderLayer(TIGER_EYE_BLOCK, RenderType.getTranslucent());
	//	RenderTypeLookup.setRenderLayer(TIGER_EYE_ORE, RenderType.getTranslucent());
//	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation(DangerZone.MODID, name);
	}

}
