package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class RawBacon extends Item {
    public RawBacon() {
        super(new Item.Properties()

                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(16)
                        .saturation(1.0F)
                        .build()
                ));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A76" + "Great stuff, even raw! Although we do recommend cooking it first." + "\u00A76"));
    }
}
