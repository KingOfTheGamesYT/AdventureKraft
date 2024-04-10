package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class Popcorn extends Item {
    public Popcorn() {

        super(new Properties()

                .group(DangerZone.WIP)
                .food(new Food.Builder()
                        .hunger(8)
                        .build()
                ));
    }
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
                return 8;
            }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7f" + "Put corn in a furnace and watch it pop!" + "\u00A7f"));
    }
}
