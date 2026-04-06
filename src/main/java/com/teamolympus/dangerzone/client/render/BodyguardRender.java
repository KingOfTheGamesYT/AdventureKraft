package com.teamolympus.dangerzone.client.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.BodyguardEntity;

public class BodyguardRender extends RenderBiped {

    public static final ResourceLocation[] TEXTURES_MALE = new ResourceLocation[]
    {
            registerMale("akio"),
            registerMale("bobby"),
            registerMale("elyasisly"),
            registerMale("jtrent238"),
            registerMale("kostuch"),
            registerMale("litchking"),
            registerMale("prince")
    };

    public static final ResourceLocation[] TEXTURES_FEMALE = new ResourceLocation[]
    {
            registerFemale("alice"),
            registerFemale("bee"),
            registerFemale("egirl"),
            registerFemale("knight"),
            registerFemale("korean"),
            registerFemale("matcha_stream"),
            registerFemale("peach"),
            registerFemale("princess"),
            registerFemale("princess_eleven"),
            registerFemale("rose")
    };


    private static ResourceLocation registerMale(String name) {
        final String textureName =
        DangerZone.ENTITY_PREFIX_MALE_GUARDS_PEACEFUL + use18Textures() + "bodyguard_male_" + name + ".png";
        return new ResourceLocation(
                DangerZone.MODID,
                textureName);
    }

    private static ResourceLocation registerFemale(String name) {
        final String textureName = DangerZone.ENTITY_PREFIX_FEMALE_GUARDS_PEACEFUL + use18Textures() + "bodyguard_female_" + name + ".png";
        return new ResourceLocation(DangerZone.MODID,textureName);
    }

    private static String use18Textures() {
        return DangerZone.isAbleToLoader18Skin ? "18/" : "";
    }


    public BodyguardRender()
    {
        super(new ModelBiped(), 0.5F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */


    protected ResourceLocation getEntityTexture(BodyguardEntity mobBodyGuard) {
        if (mobBodyGuard.isMale()) {
            System.out.println("MALE TEXTURE INDEX     " + mobBodyGuard.getTextureMale());
            return TEXTURES_MALE[mobBodyGuard.getTextureMale()];
        }
        return TEXTURES_FEMALE[mobBodyGuard.getTextureFemale()];
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityLiving p_110775_1_) {
        return this.getEntityTexture((BodyguardEntity) p_110775_1_);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */



    protected void preRenderCallback(BodyguardEntity mob, float f1)
    {

    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((BodyguardEntity) p_77041_1_, p_77041_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((BodyguardEntity) p_110775_1_);
    }

}
