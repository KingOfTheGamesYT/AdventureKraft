package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class RandomStructureBlock extends Block {

    public RandomStructureBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f));
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
        if (!worldIn.isRemote) {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 120); // Schedule block tick for 6 seconds (120 ticks)
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        // Generate structure and remove block
        generateRandomStructure(worldIn, pos);
        worldIn.removeBlock(pos, false);
    }

    private void generateRandomStructure(ServerWorld world, BlockPos pos) {
        ConfiguredFeature<?, ?> configuredFeature = getRandomConfiguredFeature(world.rand);
        if (configuredFeature != null) {
            configuredFeature.generate(world, world.getChunkProvider().getChunkGenerator(), world.rand, pos);
        }
    }

    private ConfiguredFeature<?, ?> getRandomConfiguredFeature(Random rand) {
        ConfiguredFeature<?, ?>[] features = ForgeRegistries.STRUCTURE_FEATURES.getValues().toArray(new ConfiguredFeature<?, ?>[0]);
        if (features.length > 0) {
            return features[rand.nextInt(features.length)];
        }
        return null;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        tick(state, worldIn, pos, random);
    }
}