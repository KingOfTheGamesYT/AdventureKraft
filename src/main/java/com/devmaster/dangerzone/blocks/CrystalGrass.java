package com.devmaster.dangerzone.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

public class CrystalGrass extends GlassBlock implements IGrowable {

    public CrystalGrass() {
        super(Properties.create(Material.EARTH)
                .hardnessAndResistance(0.6F, 2.0F)
                .sound(SoundType.STONE)
                .harvestLevel(0));
    }


    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A75" + "Similar to stone in the overworld. Use for Kyanite tools and weapons, but not armor. Also makes a nice Crystal Furnace, which is much faster and more fun to watch than a regular stone furnace! Pronounced: ki-an-ite" + "\u00A75"));
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}