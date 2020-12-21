package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class SapphireBlock extends Block {

    public SapphireBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0F, 3.0F)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A79" + "Sapphire blocks are seriously blue!" + "\u00A79"));
    }
}