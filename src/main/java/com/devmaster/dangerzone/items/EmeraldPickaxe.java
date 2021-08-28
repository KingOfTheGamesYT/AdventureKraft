package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import java.util.List;


public class EmeraldPickaxe extends PickaxeItem {

    public EmeraldPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {


        super(tier, 15, -2.4F, new Item.Properties().group(DangerZone.TOOLS));
        tier.getHarvestLevel();


    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "Now you know why those greedy villagers love these green gems so much\n" + "\u00A72"));
    }

}

