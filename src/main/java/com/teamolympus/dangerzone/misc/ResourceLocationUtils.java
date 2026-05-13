package com.teamolympus.dangerzone.misc;

import net.minecraft.util.ResourceLocation;

public class ResourceLocationUtils {

    public static ResourceLocation makeResourceLocationEntityHostile(String filename) {
        return new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE + filename + ".png");
    }

    public static ResourceLocation makeResourceLocationEntityPeaceful(String filename) {
        return new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_PEACEFUL + filename + ".png");
    }


    private static String use18Textures() {
        return DangerZone.isAbleToLoader18Skin ? "18/" : "";
    }

    public static ResourceLocation registerMale(String name) {
        final String textureName =
                DangerZone.ENTITY_PREFIX_MALE_GUARDS_PEACEFUL + use18Textures() + "bodyguard_male_" + name + ".png";
        return new ResourceLocation(
                DangerZone.MODID,
                textureName);
    }

    public static ResourceLocation registerFemale(String name) {
        final String textureName = DangerZone.ENTITY_PREFIX_FEMALE_GUARDS_PEACEFUL + use18Textures() + "bodyguard_female_" + name + ".png";
        return new ResourceLocation(DangerZone.MODID, textureName);
    }

}
