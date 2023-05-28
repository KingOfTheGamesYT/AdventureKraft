package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.AntModel;
import com.devmaster.dangerzone.client.render.model.RedAntModel;
import com.devmaster.dangerzone.entity.RainbowAnt;
import com.devmaster.dangerzone.entity.RedAnt;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RedAntRender extends MobRenderer<RedAnt, RedAntModel<RedAnt>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/red_ant.png");

    public RedAntRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedAntModel<>(), 0.3F);
    }
@Override
    public ResourceLocation getEntityTexture(RedAnt entity) {
        return TEXTURE;
    }

}
