package com.devmaster.dangerzone.items;




import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class TitaniumNugget extends Item {

    public TitaniumNugget() {
        super(new Properties().group(DangerZone.TAB));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A7b" + "Titanium Nuggets are smelted from Titanium Ore. You'll needs lots of them to have earned the Ultimate Sword!" + "\u00A7b"));
    }
}