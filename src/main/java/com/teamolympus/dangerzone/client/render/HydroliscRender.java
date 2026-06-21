package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import com.teamolympus.dangerzone.client.model.HydroliscModel;
@SideOnly(Side.CLIENT)
public class HydroliscRender extends RenderLiving {

   private static final ResourceLocation HYDROLISC_TEXTURE =
           ResourceLocationUtils.makeResourceLocationEntityPeaceful("hydrolisc");

    public HydroliscRender() {
        super(new HydroliscModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return HYDROLISC_TEXTURE;
    }
}
