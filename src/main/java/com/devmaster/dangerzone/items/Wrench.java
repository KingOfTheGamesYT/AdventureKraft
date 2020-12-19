package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Wrench extends Item {
    public Wrench() {
        super(new Item.Properties().group(DangerZone.TAB));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A78" + "The wrench is for taking down some spider and red ant robots!! Good luck!!!" + "\u00A78"));
    }
}
