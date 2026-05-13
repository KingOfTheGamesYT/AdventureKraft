package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import com.teamolympus.dangerzone.client.model.HydroliscModel;

public class HydroliscRender extends RenderLiving {

   private static final ResourceLocation TEXTURE =
           ResourceLocationUtils.makeResourceLocationEntityPeaceful("hydrolisc");

    public HydroliscRender() {
        super(new HydroliscModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TEXTURE;
    }
}
