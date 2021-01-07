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


public class CookedBacon extends Item {
    public CookedBacon() {
        super(new Properties()

                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(28)
                        .saturation(1.5F)
                        .effect(new EffectInstance(Effects.STRENGTH, 2000, 0), 1)
                        .effect(new EffectInstance(Effects.REGENERATION, 2000, 0), 1)
                        .setAlwaysEdible()

                        .build()
                ));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A78" + "BACON!!! Yes!!! The most gloriously wonderful food in the world is here! You've got to try it!" + "\u00A78"));
    }
}
