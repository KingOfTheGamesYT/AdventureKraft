package com.devmaster.dangerzone.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import java.util.List;


public class FireCakeSword extends SwordItem {

    public FireCakeSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "Thank you for 2k downloads" + "\u00A72"));
        int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT,1);
        }
    }

}

