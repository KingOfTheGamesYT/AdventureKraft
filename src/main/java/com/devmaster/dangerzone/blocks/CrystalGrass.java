package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

import java.util.List;

public class CrystalGrass extends Block {

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
}