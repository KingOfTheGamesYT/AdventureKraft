package com.devmaster.dangerzone.armor;

import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class LapisBoots extends ArmorItem {

    public LapisBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {

        super(materialIn, slot, new Properties().group(DangerZone.ARMOR));
    }

    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A79" + "Comes with Protection, Feather Falling, Depth strider and Projectile Protection. This is for those that want to look seriously spiffy. Built for general awesomeness, it's right at home on the battlefield, the rugby field, the boardroom, or the dance floor.\n" + "\u00A79"));
        int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantments.PROTECTION, 1);

            lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, stack);
            if (lvl <= 0) {
                stack.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 1);

                lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.DEPTH_STRIDER, stack);
                if (lvl <= 0) {
                    stack.addEnchantment(Enchantments.DEPTH_STRIDER, 1);

                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FEATHER_FALLING, stack);
                    if (lvl <= 0) {
                        stack.addEnchantment(Enchantments.FEATHER_FALLING, 1);
                    }
                }
            }


        }
    }
}