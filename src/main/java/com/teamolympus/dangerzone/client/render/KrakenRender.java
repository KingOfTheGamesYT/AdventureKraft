package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.entity.living.hostile.KrakenEntity;
import com.teamolympus.dangerzone.misc.ResourceLocationUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import com.teamolympus.dangerzone.client.model.KrakenModel;
@SideOnly(Side.CLIENT)
public class KrakenRender extends RenderLiving {

    private static final ResourceLocation TEXTURE = ResourceLocationUtils.makeResourceLocationEntityHostile("kraken");

    public KrakenRender() {
        super(new KrakenModel(), 2.0f);
    }

    public void doRender(KrakenEntity krakenEntity, double p, double p2, double p3, float p4, float p5)
    {
        BossStatus.setBossStatus(krakenEntity, true);
        super.doRender(krakenEntity, p,p2,p3,p4,p5);
    }

    public void doRender(EntityLiving entityLiving, double p1, double p2, double p3, float p4, float p5)
    {
        this.doRender((KrakenEntity)entityLiving, p1,p2,p3,p4,p5);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TEXTURE;
    }
}
