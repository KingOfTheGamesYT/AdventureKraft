package com.devmaster.dangerzone.core.init;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.blocks.VerticalSlabBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BlockInit {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, DangerZone.MOD_ID);

    public static final RegistryObject<Block> ABYSSAL_ORE_BLOCK = BLOCKS.register("abyssal_ore_block", AbyssalOreBlock::new);

    public static final RegistryObject<Block> ABYSSAL_ORE_VERTICAL_SLAB = conditionallyRegisterBlock("abyssal_ore_vertical_slab", () ->
            new VerticalSlabBlock(Block.Properties.copy(Blocks.STONE_SLAB)), () -> isLoaded("quark"));

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
    public static final RegistryObject<Block> DARK_RED_BLOCK = BLOCKS.register("dark_red_block", DarkRedBlock::new);
    public static final RegistryObject<Block> HEART_BLOCK = BLOCKS.register("heart_block", HeartBlock::new);
    public static final RegistryObject<Block> KYANITE = BLOCKS.register("kyanite", Kyanite::new);
    public static final RegistryObject<Block> LEATHER_BLOCK = BLOCKS.register("leather_block", LeatherBlock::new);
    public static final RegistryObject<Block> ORANGE_BLOCK = BLOCKS.register("orange_block", OrangeBlock::new);
    public static final RegistryObject<Block> PLAY_BUTTON_ORE_BLOCK = BLOCKS.register("play_button_ore_block", PlayButtonOreBlock::new);
    public static final RegistryObject<Block> RED_BLOCK = BLOCKS.register("red_block", RedBlock::new);
    public static final RegistryObject<Block> RANDOM_STRUCTURE_BLOCK = BLOCKS.register("random_structure_spawner", RandomStructureBlock::new);
    public static final RegistryObject<Block> SALT_ORE_BLOCK = BLOCKS.register("salt_ore_block", SaltOreBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = BLOCKS.register("sapphire_ore_block", SapphireOreBlock::new);
    public static final RegistryObject<Block> STICKY_BLOCK = BLOCKS.register("sticky_block", StickyBlock::new);
    public static final RegistryObject<Block> TERMITE_TROLL_ORE = BLOCKS.register("termite_troll_ore_block", TermiteTrollOre::new);
    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", TitaniumBlock::new);
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);

    public static @Nullable RegistryObject<Block> conditionallyRegisterBlock(String registryName, Supplier<Block> block, Supplier<Boolean> condition) {
        if (condition.get())
            return BLOCKS.register(registryName, block);
        return null;
    }

    public static boolean isLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
