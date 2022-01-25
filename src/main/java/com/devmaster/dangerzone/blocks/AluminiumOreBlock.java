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

public class AluminiumOreBlock extends OreBlock {


    public AluminiumOreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(500F, 20F)
                .sound(SoundType.STONE)
                .harvestLevel(35)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7f" + "Worse than Iron but does the trick!" + "\u00A7f"));
    }
}