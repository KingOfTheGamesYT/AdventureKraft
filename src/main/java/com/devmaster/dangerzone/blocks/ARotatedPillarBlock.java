package com.devmaster.dangerzone.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ARotatedPillarBlock extends RotatedPillarBlock {
	protected int xpdropped;

	protected String name;
	private String[] info = new String[0];


	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		if (xpdropped == 0) {
			return 0;
		}
		int min = (int) (xpdropped * 0.667);
		int max = (int) (xpdropped * 1.5);
		return silktouch == 0 ? new Random().nextInt(max - min) + min : 0;
	}

	public ARotatedPillarBlock(Properties properties, int xpdropped) {
		super(properties);
		this.xpdropped = xpdropped;
	}

	public ARotatedPillarBlock addInfo(String... newInfo) {
		if (newInfo != null && newInfo.length > 0) {
			String[] combinedInfo = new String[this.info.length + newInfo.length];
			System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
			System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
			this.info = combinedInfo;
		}
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, IBlockReader world, List<ITextComponent> list, ITooltipFlag advanced) {
        for (String s : info) {
            list.add(new StringTextComponent(s));
        }
    }

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
