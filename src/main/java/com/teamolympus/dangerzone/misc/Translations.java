package com.teamolympus.dangerzone.misc;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class Translations {

    public static String translate(String string)
    {
        return (""+StatCollector.translateToLocal(string)).trim();
    }
}
