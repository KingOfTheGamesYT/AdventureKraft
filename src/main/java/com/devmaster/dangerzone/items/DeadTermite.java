package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class DeadTermite extends Item {

    public DeadTermite() {
        super(new Properties().group(DangerZone.FOOD) .food(new Food.Builder()
                .hunger(1)
                .saturation(0.5F)
                .build()
        ));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A78" + "Yes! It's dead finally" + "\u00A78"));
    }
}