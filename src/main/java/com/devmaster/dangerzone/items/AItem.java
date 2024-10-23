package com.devmaster.dangerzone.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class AItem extends Item
{

	private String[] info = new String[0];

	public AItem(int stacksize, ItemGroup group)
	{
		this(get(stacksize, group));
	}

	public AItem(ItemGroup group)
	{
		this( get(64, group));
	}


	public AItem(Properties p)
	{
		super(p);

	}

	protected static final Properties get(int stacksize, ItemGroup group)
	{
		return new Properties().maxStackSize(stacksize).group(group);
	}

	public AItem addInfo(String... newInfo) {
		if (newInfo != null && newInfo.length > 0) {
			String[] combinedInfo = new String[this.info.length + newInfo.length];
			System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
			System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
			this.info = combinedInfo;
		}
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> list, ITooltipFlag flagIn){
		for (String s : info) {
			list.add(new StringTextComponent(s));
		}
	}
}
