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

    public static @Nullable RegistryObject<Block> conditionallyRegisterBlock(String registryName, Supplier<Block> block, Supplier<Boolean> condition) {
        if (condition.get())
            return BLOCKS.register(registryName, block);
        return null;
    }

    public static boolean isLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
