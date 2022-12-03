package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class CrystalApple extends Item {
    public CrystalApple() {
        super(new Properties()
                .maxStackSize(16)
                .group(DangerZone.FOOD)
                .food(new Food.Builder()
                        .hunger(5)
                        .effect(new EffectInstance(Effects.REGENERATION, 300, 1), 1)
                        .setAlwaysEdible()
                        .build()
                ));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
        return 1580;
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A74" + "Dropped by trees in the Crystal Dimension! Used for breeding critters. Amazing effect when eaten!" + "\u00A74"));
    }
}
