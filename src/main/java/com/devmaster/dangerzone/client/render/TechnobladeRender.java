package com.devmaster.dangerzone.client.render;

import com.devmaster.dangerzone.client.render.model.TechnobladeModel;
import com.devmaster.dangerzone.entity.Technoblade;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;


public class TechnobladeRender extends MobRenderer<Technoblade, TechnobladeModel<Technoblade>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_1.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_2.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_3.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_4.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_5.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_6.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_7.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_8.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_9.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_10.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_11.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_12.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_13.png"), new ResourceLocation("dangerzone", "textures/entity/youtuber/technoblade/technoblade_14.png")};

    public TechnobladeRender(EntityRendererManager renderManager) {
        super(renderManager, new TechnobladeModel<>(0.0F, false), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new TechnobladeModel<>(0.5F, true), new TechnobladeModel<>(1.0F, true)));
    }

    public ResourceLocation getEntityTexture(Technoblade entity) {
        return TEXTURE[entity.getTechnobladeVariant()];
    }




}

