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

public class FireFish extends Item {
    public FireFish() {
        super(new Item.Properties()

                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(8)
                        .saturation(0.60F)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 1200, 0), 1)
                        .setAlwaysEdible()
                        .build()
                ));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A75" + "This fish lives in lava and provides fire protection and hunger points when eaten. You don't even need to cook it or be hungry to eat it! Use the Ultimate Fishing Rod to Catch it." + "\u00A75"));
    }
}
