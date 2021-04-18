package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.RedRoseWarriorModel;
import com.devmaster.dangerzone.entity.RedRoseWarrior;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedRoseWarriorRender extends MobRenderer<RedRoseWarrior, RedRoseWarriorModel<RedRoseWarrior>> {
    private static final ResourceLocation DOG_TEXTURES = new ResourceLocation("dangerzone:textures/entity/redrosewarrior.png");

    public RedRoseWarriorRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedRoseWarriorModel<>(), 0.7F);
    }

    public ResourceLocation getEntityTexture(RedRoseWarrior entity) {
        return DOG_TEXTURES;
    }
}
