package com.devmaster.dangerzone.blocks;


import net.minecraft.block.BlockState;
import net.minecraft.block.WebBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;

public class StickyBlock extends WebBlock {

    public StickyBlock() {
        super(Properties.create(Material.WEB)
                .hardnessAndResistance(4.0F, 12.0F)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .doesNotBlockMovement()
                .notSolid());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       tooltip.add(new StringTextComponent(   "\u00A7f" + "Yuck. Stay away." + "\u00A7f"));
    }
}