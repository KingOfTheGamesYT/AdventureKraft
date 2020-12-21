package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
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


public class ButterCandy extends Item {
    public ButterCandy() {
        super(new Properties()

                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(0.5F)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 2000, 0), 1)
                        .effect(new EffectInstance(Effects.SPEED, 2000, 0), 1)
                        .setAlwaysEdible()

                        .build()
                ));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7e" + "Try some! Catch a sugar buzz! :)" + "\u00A78"));
    }
}
