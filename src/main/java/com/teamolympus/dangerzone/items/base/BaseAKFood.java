package com.teamolympus.dangerzone.items.base;

import java.util.ArrayList;
import java.util.List;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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

    public BaseAKFood addInfo(String desc) {
        infoList.add(desc);
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
    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return useDuration;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean b)
    {
        super.addInformation(stack, player, info,b);
        info.addAll(infoList);
    }
}
