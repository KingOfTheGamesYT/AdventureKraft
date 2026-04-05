package com.teamolympus.dangerzone.items.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.Translations;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseAKFood extends ItemFood {

    private int useDuration = 32;
    private final List<String> infoList = new ArrayList<>(8);
    private final List<PotionEffect> potions = new ArrayList<>(8);

    public BaseAKFood(String name, int healAmm, float saturation, boolean wolfEat) {
        super(healAmm, saturation, wolfEat);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DangerZone.FOOD);
        this.setTextureName(DangerZone.FOOD_PREFIX + name);
    }

    public BaseAKFood addPotionEffect(PotionEffect effect) {
        potions.add(effect);
        return this;
    }
    EnumChatFormatting formatting;

    public BaseAKFood addInfo(String desc, EnumChatFormatting formatting) {
        infoList.add(desc);
        this.formatting = formatting;
        return this;
    }


    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            for (PotionEffect potion : potions) {
                player.addPotionEffect(potion);
            }
        }

        super.onFoodEaten(stack, world, player);
    }

    public BaseAKFood setUseDuration(int useDuration) {
        this.useDuration = useDuration;
        return this;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return useDuration;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b)
    {
        super.addInformation(stack, player, info,b);
        for (String string : infoList) {
            info.add(formatting + Translations.translate(string));
        }
    }
}
