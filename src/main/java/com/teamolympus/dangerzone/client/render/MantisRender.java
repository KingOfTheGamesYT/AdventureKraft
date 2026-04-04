package com.teamolympus.dangerzone.client.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.client.model.MantisModel;
import com.teamolympus.dangerzone.entity.living.hostile.MantisEntity;

public class MantisRender extends RenderLiving {

    private static final ResourceLocation mantisTexture = new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE + "mantis.png");

    private static final float scaleFactor = 1.1f;

    public MantisRender() {
        super(new MantisModel(), 0.9F);
    }

    protected void preRenderCallback(MantisEntity p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((MantisEntity)p_77041_1_, p_77041_2_);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return mantisTexture;
    }
}
