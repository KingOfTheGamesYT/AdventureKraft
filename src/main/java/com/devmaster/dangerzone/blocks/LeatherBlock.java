package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.ForgeSoundType;

import java.util.Collections;
import java.util.List;

public class LeatherBlock extends Block {
    public LeatherBlock() {
        super(Block.Properties.create(Material.EARTH)
                .sound(new ForgeSoundType(1.0f, 1.0f,
                        () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_BREAK.get().getRegistryName()),
                        () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_STEP.get().getRegistryName()),
                        () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_PLACE.get().getRegistryName()),
                        () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_HIT.get().getRegistryName()),
                        () -> new SoundEvent(RegistryHandler.LEATHER_BLOCK_PLACE.get().getRegistryName())))
                .hardnessAndResistance(1f, 1f)
                .setLightLevel(s -> 0)
                .harvestLevel(1));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
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
        tooltip.add(new StringTextComponent("\u00A76" + "What a great place to store all that leather" + "\u00A76"));
    }

}

