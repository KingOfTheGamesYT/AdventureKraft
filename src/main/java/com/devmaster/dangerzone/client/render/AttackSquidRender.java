package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AttackSquidModel;
import com.devmaster.dangerzone.entity.AttackSquid;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class AttackSquidRender extends MobRenderer<AttackSquid, AttackSquidModel<AttackSquid>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/attack_squid.png");

    public AttackSquidRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AttackSquidModel(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(AttackSquid entity) {
        return TEXTURE;
    }
}
