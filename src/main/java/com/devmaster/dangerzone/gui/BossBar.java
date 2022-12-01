package com.devmaster.dangerzone.gui;

import com.devmaster.dangerzone.misc.DangerZone;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;

import java.util.*;

import static com.devmaster.dangerzone.client.render.BossBarRender.renderScaledCustomSizedTexture;


@OnlyIn(Dist.CLIENT)
public class BossBar {
    private static final HashMap<String, ResourceLocation> textureCache = new HashMap<String, ResourceLocation>();

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, RenderGameOverlayEvent.BossInfo.class, BossBar::onBossInfoRender);
    }

    private static void onBossInfoRender(final RenderGameOverlayEvent.BossInfo position) {
        if (!position.isCanceled()) {
            ITextComponent nameComponent = position.getBossInfo().getName();
            ITextComponent name;
            String id;
            MatrixStack matrix = position.getMatrixStack();

            if (nameComponent.getSiblings().isEmpty() || !(nameComponent instanceof TranslationTextComponent))
                return;

            id = ((TranslationTextComponent)nameComponent).getKey();

            if (!id.startsWith("entity.dangerzone."))
                return;

            name = nameComponent.getSiblings().get(0);

            Minecraft mc = Minecraft.getInstance();
            MainWindow mainWindow = mc.getMainWindow();
            ResourceLocation texture = getTexture(id.substring(12));
            int textureWidth = 196;
            int xPos = mainWindow.getScaledWidth() / 2 - 100;
            int percentPixels = (int)Math.ceil(position.getBossInfo().getPercent() * textureWidth);
            int stringWidth = mc.fontRenderer.getStringWidth("name");
            int x = mainWindow.getScaledHeight() / 2 - stringWidth / 2;

            matrix.push();
            RenderSystem.enableAlphaTest();
            RenderSystem.disableDepthTest();
            RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
            mc.getTextureManager().bindTexture(texture);

            if (percentPixels < textureWidth)
                BossBar.renderCustomSizedTexture(matrix, xPos, position.getY(), 0, 12, 200, 12, 200, 36);

            if (percentPixels > 0)
                BossBar.renderCustomSizedTexture(matrix, xPos + 2, position.getY(), 2, 0, percentPixels, 12, 200, 36);

            BossBar.renderCustomSizedTexture(matrix, xPos, position.getY(), 0, 24, 200, 12, 200, 36);
            mc.fontRenderer.drawTextWithShadow(position.getMatrixStack(), name, x, position.getY() - 9, 16777215);
            RenderSystem.enableDepthTest();
            RenderSystem.disableAlphaTest();
            matrix.pop();

            position.setIncrement(position.getIncrement() + 5);
            position.setCanceled(true);
        }
    }

    private static ResourceLocation getTexture(String mob) {
        if (textureCache.containsKey(mob))
            return textureCache.get(mob);

        ResourceLocation BOSS_BAR = new ResourceLocation(DangerZone.MOD_ID, "textures/gui/redrosewarrior.png");

        textureCache.put(mob, BOSS_BAR);

        return BOSS_BAR;
    }

    public static void renderCustomSizedTexture(MatrixStack matrix, int x, int y, float u, float v, float uWidth, float vHeight, float textureWidth, float textureHeight) {
        renderScaledCustomSizedTexture(matrix, x, y, u, v, uWidth, vHeight, uWidth, vHeight, textureWidth, textureHeight);
    }
}