package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import com.teamolympus.dangerzone.client.model.AllosaurusModel;
import com.teamolympus.dangerzone.entity.living.hostile.AllosaurusEntity;

public class AllosaurusRender extends RenderLiving {

   public static final ResourceLocation[] resourceLocations = new ResourceLocation[]
        {
        new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE+ "allo1.png"),
        new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE + "allo2.png"),
        new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE + "allo3.png"),
        new ResourceLocation(DangerZone.MODID, DangerZone.ENTITY_PREFIX_HOSTILE + "allo4.png")
    };

    public AllosaurusRender() {
        super(new AllosaurusModel(), 0.4f);
    }

    protected ResourceLocation getEntityTexture(AllosaurusEntity allosaurus) {
        return resourceLocations[allosaurus.getRandomTextureSelector()];
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((AllosaurusEntity)entity);
    }
    public void doRender(AllosaurusEntity allosaurus, double p, double p2, double p3, float p4, float p5)
    {
        BossStatus.setBossStatus(allosaurus, true);
        super.doRender((EntityLiving)allosaurus, p,p2,p3,p4,p5);
    }

    public void doRender(EntityLiving entityLiving, double p1, double p2, double p3, float p4, float p5)
    {
        this.doRender((AllosaurusEntity)entityLiving, p1,p2,p3,p4,p5);
    }
}
