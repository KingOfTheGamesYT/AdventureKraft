package com.devmaster.dangerzone.gui;

import com.devmaster.dangerzone.client.render.BossBarRender;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.BossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;


@OnlyIn(Dist.CLIENT)
public class BossBar {
    private static final HashMap<String, ResourceLocation> textureCache = new HashMap();

    public BossBar() {
    }

    @SubscribeEvent
    public static void renderBossBar(BossInfo info) {
        if (!info.isCancelable()) {
            ITextComponent nameComponent = info.getBossInfo().getName();
            MatrixStack matrix = info.getMatrixStack();
            if (nameComponent.getSiblings().isEmpty() || !(nameComponent instanceof TranslationTextComponent)) {
                return;
            }

            String id = ((TranslationTextComponent)nameComponent).getKey();
            if (!id.startsWith("entity.dangerzone.")) {
                return;
            }

            ITextComponent name = (ITextComponent)nameComponent.getSiblings().get(0);
            Minecraft mc = Minecraft.getInstance();
            MainWindow mainWindow = mc.getMainWindow();
            ResourceLocation texture = getTexture(id.substring(12));
            int textureWidth = 196;
            int xPos = mainWindow.getScaledHeight() / 2 - 100;
            int percentPixels = (int)Math.ceil((double)(info.getBossInfo().getPercent() * (float)textureWidth));
            int stringWidth = mc.fontRenderer.getStringPropertyWidth(name);
            int x = mainWindow.getScaledWidth() / 2 - stringWidth / 2;
            matrix.push();
            RenderSystem.enableAlphaTest();
            RenderSystem.disableDepthTest();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.getTextureManager().bindTexture(texture);
            if (percentPixels < textureWidth) {
                BossBarRender.renderCustomSizedTexture(matrix, xPos, info.getY(), 0.0F, 12.0F, 200, 12, 200.0F, 36.0F);
            }

            if (percentPixels > 0) {
                BossBarRender.renderCustomSizedTexture(matrix, xPos + 2, info.getY(), 2.0F, 0.0F, percentPixels, 12, 200.0F, 36.0F);
            }

            BossBarRender.renderCustomSizedTexture(matrix, xPos, info.getY(), 0.0F, 24.0F, 200, 12, 200.0F, 36.0F);
            mc.fontRenderer.drawTextWithShadow(info.getMatrixStack(), name, (float)x, (float)(info.getY() - 9), 16777215);
            RenderSystem.enableDepthTest();
            RenderSystem.disableAlphaTest();
            matrix.pop();
            info.setIncrement(info.getIncrement() + 5);
            info.setCanceled(true);
        }

    }

    private static ResourceLocation getTexture(String id) {
        if (textureCache.containsKey(id)) {
            return (ResourceLocation)textureCache.get(id);
        } else {
            ResourceLocation texture = new ResourceLocation("dangerzone", "textures/gui/" + id + ".png");
            textureCache.put(id, texture);
            return texture;
        }
    }

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, RenderGameOverlayEvent.BossInfo.class, BossBar::renderBossBar);
    }
}