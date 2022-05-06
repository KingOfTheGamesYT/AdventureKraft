package com.devmaster.dangerzone.blocks;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class AppleLeaves extends LeavesBlock {


    public AppleLeaves() {
        super(Properties.create(Material.LEAVES)
                .hardnessAndResistance(0.2F, 0.2F)
                .sound(SoundType.PLANT)
                .notSolid()
                .harvestLevel(0));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A75" + "Apples from the trees" + "\u00A75"));
    }
}