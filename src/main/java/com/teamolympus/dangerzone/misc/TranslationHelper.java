package com.teamolympus.dangerzone.misc;

import net.minecraft.util.StatCollector;

public class TranslationHelper {

    public static String translate(String localString) {
        return (StatCollector.translateToLocal(localString)).trim();
    }

}
