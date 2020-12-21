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

public class UraniumBlock extends Block {

    public UraniumBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0F, 5.0F)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .setLightLevel(state -> 2));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A7e" + "Make a nice yellow block!" + "\u00A7e"));
    }
}