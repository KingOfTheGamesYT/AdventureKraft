package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import com.teamolympus.dangerzone.client.model.KrakenModel;

public class KrakenRender extends RenderLiving {

    private static final ResourceLocation TEXTURE = ResourceLocationUtils.makeResourceLocationEntityHostile("kraken");

    public KrakenRender() {
        super(new KrakenModel(), 2.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TEXTURE;
    }
}
