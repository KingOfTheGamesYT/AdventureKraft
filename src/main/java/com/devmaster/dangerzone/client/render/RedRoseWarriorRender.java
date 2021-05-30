package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.RedRoseWarriorModel;
import com.devmaster.dangerzone.entity.RedRoseWarrior;
import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;



public class RedRoseWarriorRender extends MobRenderer<RedRoseWarrior, RedRoseWarriorModel<RedRoseWarrior>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/redrosewarrior.png");

    public RedRoseWarriorRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedRoseWarriorModel<>(), 0.7F);
    }
@Override
    public ResourceLocation getEntityTexture(RedRoseWarrior entity) {
        return TEXTURE;
    }
}
