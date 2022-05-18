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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;


public class BLT extends Item {
    public BLT() {

        super(new Properties()

                .group(DangerZone.WIP)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(2)
                        .build()
                ));
    }
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
                return 800;
            }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A76" + "Try it it's great!" + "\u00A76"));
    }
}
