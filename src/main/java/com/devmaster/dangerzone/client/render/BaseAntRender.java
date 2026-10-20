package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.BaseAntModel;
import com.devmaster.dangerzone.entity.BaseAnt;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BaseAntRender extends MobRenderer<BaseAnt, BaseAntModel<BaseAnt>> {

    private static final ResourceLocation RED_ANT_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/ants/red_ant.png");

    public BaseAntRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BaseAntModel<>(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(BaseAnt entity) {

        if (entity.getType() == RegistryHandler.RED_ANT.get()) {
            return new ResourceLocation(DangerZone.MOD_ID, "textures/entity/ants/red_ant/red_ant_" + entity.getRedAntVariant() + ".png");
        }
        if (entity.getType() == RegistryHandler.RAINBOWANT.get()) {
            return new ResourceLocation(DangerZone.MOD_ID, "textures/entity/ants/rainbow_ant/rainbow_ant_" + entity.getRainbowAntVariant() + ".png");
        }
        if (entity.getType() == RegistryHandler.TERMITE.get()) {
            return new ResourceLocation(DangerZone.MOD_ID, "textures/entity/ants/termite/termite_1.png");
        }
        return RED_ANT_TEXTURE;
    }
}