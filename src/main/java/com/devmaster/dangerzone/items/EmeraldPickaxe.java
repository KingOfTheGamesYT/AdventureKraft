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


        super(tier, 7, -2.4F, new Item.Properties().group(DangerZone.TOOLS));
        tier.getHarvestLevel();


    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A72" + "Comes with Silk Touch automatically. You can use this to mine ice for your Prince or Princess!\n" + "\u00A72"));
        int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantments.SILK_TOUCH,1);
            //change the Enchantments.SILK_TOUCH to whatever you desire for both of statements
// Enchantments moduler by Alchemy
        }
    }

}

