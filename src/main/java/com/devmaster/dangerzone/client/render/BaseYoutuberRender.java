package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.entity.BaseYoutuber;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class BaseYoutuberRender extends BipedRenderer<BaseYoutuber, BipedModel<BaseYoutuber>> {

    private static final ResourceLocation ANT_VENOM_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/antvenom.png");
    private static final ResourceLocation TEWTIY_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/tewtiy.png");
    private static final ResourceLocation APHMAU_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/aphmau.png");
    private static final ResourceLocation BABY_ANGEL_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyangel.png");
    private static final ResourceLocation BABY_DUCK_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyduck.png");
    private static final ResourceLocation BABY_LEAH_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babyleah.png");
    private static final ResourceLocation BABY_MAX_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/babymax.png");
    private static final ResourceLocation BAJAN_CANADIAN_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/bajancanadian.png");
    private static final ResourceLocation NOT_BREE_BREE_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/notbreebree.png");
    private static final ResourceLocation ROBO_TECHNOBLADE_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/technoblade/technoblade_robo.png");
    private static final ResourceLocation STAMPY_LONG_NOSE_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/stampylongnose.png");
    private static final ResourceLocation ALEXICRAFT_TEXTURE = new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/alexicraft.png");

    public BaseYoutuberRender(EntityRendererManager renderManager) {
        super(renderManager, new BipedModel<>(0.0F), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(BaseYoutuber entity) {

        if (entity.getType() == RegistryHandler.ANTVENOM.get()) {
            return ANT_VENOM_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.ROBO_TECHNOBLADE.get()) {
            return ROBO_TECHNOBLADE_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.NOTBREEBREE.get()) {
            return NOT_BREE_BREE_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.BAJANCANADIAN.get()) {
            return BAJAN_CANADIAN_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.BABYMAX.get()) {
            return BABY_MAX_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.BABYLEAH.get()) {
            return BABY_LEAH_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.BABYDUCK.get()) {
            return BABY_DUCK_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.BABYANGEL.get()) {
            return BABY_ANGEL_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.APHMAU.get()) {
            return APHMAU_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.STAMPYLONGNOSE.get()) {
            return STAMPY_LONG_NOSE_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.ALEXICRAFT.get()) {
            return ALEXICRAFT_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.TEWTIY.get()) {
            return TEWTIY_TEXTURE;
        }
        if (entity.getType() == RegistryHandler.TECHNOBLADE.get()) {
            return new ResourceLocation(DangerZone.MOD_ID, "textures/entity/youtuber/technoblade/technoblade_" + entity.getTechnobladeVariant() + ".png");
        }

        return ANT_VENOM_TEXTURE; //fallback
    }
}