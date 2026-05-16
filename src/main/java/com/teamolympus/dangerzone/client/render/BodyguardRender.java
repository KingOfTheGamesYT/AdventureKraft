package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.teamolympus.dangerzone.entity.living.peaceful.bodyguard.BodyguardEntity;
@SideOnly(Side.CLIENT)
public class BodyguardRender extends RenderBiped {

    public static final ResourceLocation[] TEXTURES_MALE = new ResourceLocation[]
    {
            ResourceLocationUtils.registerMale("akio"),
            ResourceLocationUtils.registerMale("bobby"),
            ResourceLocationUtils.registerMale("elyasisly"),
            ResourceLocationUtils.registerMale("jtrent238"),
            ResourceLocationUtils.registerMale("kostuch"),
            ResourceLocationUtils.registerMale("litchking"),
            ResourceLocationUtils.registerMale("prince")
    };

    public static final ResourceLocation[] TEXTURES_FEMALE = new ResourceLocation[]
    {
            ResourceLocationUtils.registerFemale("alice"),
            ResourceLocationUtils.registerFemale("bee"),
            ResourceLocationUtils.registerFemale("egirl"),
            ResourceLocationUtils.registerFemale("knight"),
            ResourceLocationUtils.registerFemale("korean"),
            ResourceLocationUtils.registerFemale("matcha_steam"),
            ResourceLocationUtils.registerFemale("peach"),
            ResourceLocationUtils.registerFemale("princess"),
            ResourceLocationUtils.registerFemale("princess_eleven"),
            ResourceLocationUtils.registerFemale("rose")
    };


    public BodyguardRender()
    {
        super(new ModelBiped(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(BodyguardEntity mobBodyGuard) {
        if (mobBodyGuard.isMale()) {
            return TEXTURES_MALE[mobBodyGuard.getTextureMale()];
        }
        return TEXTURES_FEMALE[mobBodyGuard.getTextureFemale()];
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving p_110775_1_) {
        return this.getEntityTexture((BodyguardEntity) p_110775_1_);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((BodyguardEntity) p_110775_1_);
    }

}
