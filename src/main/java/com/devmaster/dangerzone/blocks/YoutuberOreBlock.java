package com.devmaster.dangerzone.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class YoutuberOreBlock extends OreBlock {


    public YoutuberOreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(10.0F, 12.0F)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));

    }



    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(   "\u00A75" + "Amethyst can be found between levels 25 and 0 rarely deep underground. You can make some awesome stuff with this purple beauty!" + "\u00A75"));
    }
}
