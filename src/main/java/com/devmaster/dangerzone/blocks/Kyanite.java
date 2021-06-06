package com.devmaster.dangerzone.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class Kyanite extends Block {

    public Kyanite() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0F, 10.0F)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }


    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A75" + "Similar to stone in the overworld. Use for Kyanite tools and weapons, but not armor. Also makes a nice Crystal Furnace, which is much faster and more fun to watch than a regular stone furnace! Pronounced: ki-an-ite" + "\u00A75"));
    }

   /* @Override
    public boolean isTransparent(BlockState state) {
        return true;
    }*/
}