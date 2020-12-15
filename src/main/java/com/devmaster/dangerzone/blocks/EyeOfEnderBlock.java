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

public class EyeOfEnderBlock extends Block {

    public EyeOfEnderBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(0.5F, 1.0F)
                .sound(SoundType.GROUND)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A76" + "Eye of Ender blocks can be used to summon a Cephadrome. Place an Eye of Ender block on the ground, then top it off with an Extreme Torch. Poof! " + "\u00A75"));
    }
}