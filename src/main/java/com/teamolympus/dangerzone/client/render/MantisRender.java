package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.teamolympus.dangerzone.client.model.MantisModel;
@SideOnly(Side.CLIENT)
public class MantisRender extends RenderLiving {

    private static final ResourceLocation MANTIS_TEXTURE =
            ResourceLocationUtils.makeResourceLocationEntityHostile("mantis");

    private static final float scaleFactor = 1.1f;

    public MantisRender() {
        super(new MantisModel(), 0.9F);
    }
    @Override
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return MANTIS_TEXTURE;
    }
}
