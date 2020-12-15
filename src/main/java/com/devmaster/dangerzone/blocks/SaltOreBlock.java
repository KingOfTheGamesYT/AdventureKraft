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

public class SaltOreBlock extends OreBlock {


    public SaltOreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }
    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(   "\u00A7f" + "Salt ore kill ants. Great for keeping ants out of places you don't want them! Place a few Salt ore in front of your door. Double wide does the trick. Sometimes ants will cross just one block." + "\u00A7f"));
    }

        }

