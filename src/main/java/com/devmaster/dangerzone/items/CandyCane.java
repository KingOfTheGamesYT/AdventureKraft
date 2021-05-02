package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class CandyCane extends Item {
    public CandyCane() {
        super(new Properties()

                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(1)
                        .effect(new EffectInstance(Effects.SPEED, 2000, 0), 1)
                        .saturation(0.5F)
                        .build()
                ));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7e" + "Thank you for 1k downloads" + "\u00A7e"));
    }
}
