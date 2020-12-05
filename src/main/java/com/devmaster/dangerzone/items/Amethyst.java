package com.devmaster.dangerzone.items;




import com.devmaster.dangerzone.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class Amethyst extends Item {

    public Amethyst() {
        super(new Item.Properties().group(DangerZone.TAB));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A75" + "They make some pretty cool Amethyst Tools & Amethyst Sword, you can make Amethyst Armor" + "\u00A75"));
    }
}