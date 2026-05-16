package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.client.model.ScorpionModel;
import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ScorpionRender extends RenderLiving {

    private static final ResourceLocation SCORPION_TEXTURE = ResourceLocationUtils.makeResourceLocationEntityHostile("scorpion");

    public ScorpionRender()
    {
        super(new ScorpionModel(), 0.8f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return SCORPION_TEXTURE;
    }
}
