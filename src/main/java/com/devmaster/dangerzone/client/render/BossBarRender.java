package com.devmaster.dangerzone.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextProperties;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.Iterator;

public abstract class BossBarRender {
    public BossBarRender() {
}

        public static void renderTexture(MatrixStack matrix, int x, int y, float u, float v, float width, float height) {
            renderCustomSizedTexture(matrix, x, y, u, v, (int)width, (int)height, width, height);
        }

        public static void renderCustomSizedTexture(MatrixStack matrix, int x, int y, float u, float v, int uWidth, int vHeight, float textureWidth, float textureHeight) {
            renderScaledCustomSizedTexture(matrix, (float)x, (float)y, u, v, (float)uWidth, (float)vHeight, (float)uWidth, (float)vHeight, textureWidth, textureHeight);
        }

        public static void drawVerticalGradient(MatrixStack matrixStack, int x, int y, int z, int width, int height, int topColour, int bottomColour) {
            float alphaTop = (float)(topColour >> 24 & 255) / 255.0F;
            float redTop = (float)(topColour >> 16 & 255) / 255.0F;
            float greenTop = (float)(topColour >> 8 & 255) / 255.0F;
            float blueTop = (float)(topColour & 255) / 255.0F;
            float alphaBottom = (float)(bottomColour >> 24 & 255) / 255.0F;
            float redBottom = (float)(bottomColour >> 16 & 255) / 255.0F;
            float greenBottom = (float)(bottomColour >> 8 & 255) / 255.0F;
            float blueBottom = (float)(bottomColour & 255) / 255.0F;
            RenderSystem.pushTextureAttributes();
            RenderSystem.disableTexture();
            RenderSystem.enableBlend();
            RenderSystem.disableAlphaTest();
            RenderSystem.defaultBlendFunc();
            RenderSystem.shadeModel(7425);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Matrix4f matrix = matrixStack.getLast().getMatrix();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(matrix, (float)(x + width), (float)y, (float)z).color(redTop, greenTop, blueTop, alphaTop).endVertex();
            bufferbuilder.pos(matrix, (float)x, (float)y, (float)z).color(redTop, greenTop, blueTop, alphaTop).endVertex();
            bufferbuilder.pos(matrix, (float)x, (float)(y + height), (float)z).color(redBottom, greenBottom, blueBottom, alphaBottom).endVertex();
            bufferbuilder.pos(matrix, (float)(x + width), (float)(y + height), (float)z).color(redBottom, greenBottom, blueBottom, alphaBottom).endVertex();
            tessellator.draw();
            RenderSystem.shadeModel(7424);
            RenderSystem.disableBlend();
            RenderSystem.enableAlphaTest();
            RenderSystem.enableTexture();
            RenderSystem.popAttributes();
        }

        public static void drawCenteredScaledString(MatrixStack matrix, FontRenderer fontRenderer, String msg, int x, int y, float scale, int colour, BossBarRender.StringRenderType renderType) {
            drawCenteredScaledMessage(matrix, fontRenderer, new StringTextComponent(msg), x, y, scale, colour, renderType);
        }

        public static void drawScaledMessage(MatrixStack matrix, FontRenderer fontRenderer, ITextComponent msg, int x, int y, float scale, int colour, BossBarRender.StringRenderType renderType) {
            float realX = (float)x / scale;
            float realY = (float)y / scale;
            matrix.push();
            matrix.scale(scale, scale, scale);
            if (renderType == BossBarRender.StringRenderType.OUTLINED) {
                fontRenderer.drawText(matrix, msg, realX, realY + 1.0F / scale, 0);
                fontRenderer.drawText(matrix, msg, realX, realY - 1.0F / scale, 0);
                fontRenderer.drawText(matrix, msg, realX + 1.0F / scale, realY, 0);
                fontRenderer.drawText(matrix, msg, realX - 1.0F / scale, realY, 0);
            }

            if (renderType == BossBarRender.StringRenderType.DROP_SHADOW) {
                fontRenderer.drawTextWithShadow(matrix, msg, realX, realY, colour);
            } else {
                fontRenderer.drawText(matrix, msg, realX, realY, colour);
            }

            RenderSystem.enableAlphaTest();
            matrix.pop();
        }

        public static void drawScaledString(MatrixStack matrix, FontRenderer fontRenderer, String msg, int x, int y, float scale, int colour, BossBarRender.StringRenderType renderType) {
            drawScaledMessage(matrix, fontRenderer, new StringTextComponent(msg), x, y, scale, colour, renderType);
        }

        public static void drawOutlinedText(MatrixStack matrix, FontRenderer fontRenderer, String msg, int x, int y, int colour, float currentScale) {
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            fontRenderer.drawString(matrix, msg, (float)x, (float)y + 1.0F / currentScale, 0);
            fontRenderer.drawString(matrix, msg, (float)x, (float)y - 1.0F / currentScale, 0);
            fontRenderer.drawString(matrix, msg, (float)x + 1.0F / currentScale, (float)y, 0);
            fontRenderer.drawString(matrix, msg, (float)x - 1.0F / currentScale, (float)y, 0);
            fontRenderer.drawString(matrix, msg, (float)x, (float)y, colour);
            RenderSystem.enableAlphaTest();
        }

        public static void drawWrappedMessage(MatrixStack matrix, FontRenderer fontRenderer, ITextProperties message, int x, int y, int maxLength, int color) {
            Matrix4f matrix4f = matrix.getLast().getMatrix();

            for(Iterator var8 = fontRenderer.trimStringToWidth(message, maxLength).iterator(); var8.hasNext(); y += 9) {
                IReorderingProcessor processor = (IReorderingProcessor)var8.next();
                IRenderTypeBuffer.Impl renderTypeBuffer = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
                fontRenderer.drawEntityText(processor, (float)x, (float)y, color, false, matrix4f, renderTypeBuffer, false, 0, 15728880);
                renderTypeBuffer.finish();
                fontRenderer.getClass();
            }

        }
        public static void drawCenteredScaledMessage(MatrixStack matrix, FontRenderer fontRenderer, ITextComponent msg, int x, int y, float scale, int colour, BossBarRender.StringRenderType renderType) {
            matrix.push();
            matrix.scale(scale, scale, scale);
            float realX = ((float)x - (float)fontRenderer.getStringPropertyWidth(msg) * scale / 2.0F) / scale;
            float realY = (float)y / scale;
            if (renderType == BossBarRender.StringRenderType.OUTLINED) {
                fontRenderer.drawText(matrix, msg, realX, realY + 1.0F / scale, 0);
                fontRenderer.drawText(matrix, msg, realX, realY - 1.0F / scale, 0);
                fontRenderer.drawText(matrix, msg, realX + 1.0F / scale, realY, 0);
                fontRenderer.drawText(matrix, msg, realX - 1.0F / scale, realY, 0);
            }

            if (renderType == BossBarRender.StringRenderType.DROP_SHADOW) {
                fontRenderer.drawTextWithShadow(matrix, msg, realX, realY, colour);
            } else {
                fontRenderer.drawText(matrix, msg, realX, realY, colour);
            }

            RenderSystem.enableAlphaTest();
            matrix.pop();
        }

        public static void renderItemInGui(MatrixStack matrix, Minecraft mc, ItemStack stack, int x, int y) {
            IBakedModel model = mc.getItemRenderer().getItemModelWithOverrides(stack, (World)null, (LivingEntity)null);
            matrix.push();
            mc.getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            mc.getTextureManager().getTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE).setBlurMipmapDirect(false, false);
            RenderSystem.enableRescaleNormal();
            RenderSystem.enableAlphaTest();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            matrix.translate((double)((float)x), (double)((float)y), (double)(100.0F + mc.getItemRenderer().zLevel));
            matrix.translate(8.0D, 8.0D, 0.0D);
            matrix.translate(1.0F, -1.0F, 1.0F);
            matrix.translate(16.0F, 16.0F, 16.0F);
            IRenderTypeBuffer.Impl renderTypeBuffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
            boolean useItemLight = !model.isSideLit();
            if (useItemLight) {
                RenderHelper.setupGuiFlatDiffuseLighting();
            }

            mc.getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.GUI, false, matrix, renderTypeBuffer, 15728880, OverlayTexture.NO_OVERLAY, model);
            renderTypeBuffer.finish();
            RenderSystem.enableDepthTest();
            if (useItemLight) {
                RenderHelper.setupGuiFlatDiffuseLighting();
            }

            RenderSystem.disableAlphaTest();
            RenderSystem.disableRescaleNormal();
            matrix.pop();
        }
        public static void renderScaledCustomSizedTexture(MatrixStack matrixStack, float x, float y, float u, float v, float uWidth, float vHeight, float renderWidth, float renderHeight, float textureWidth, float textureHeight) {
            BufferBuilder buffer = Tessellator.getInstance().getBuffer();
            Matrix4f matrix = matrixStack.getLast().getMatrix();
            float widthRatio = 1.0F / textureWidth;
            float heightRatio = 1.0F / textureHeight;
            buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            buffer.pos(matrix, x, y + renderHeight, 0.0F).tex(u * widthRatio, (v + vHeight) * heightRatio).endVertex();
            buffer.pos(matrix, x + renderWidth, y + renderHeight, 0.0F).tex((u + uWidth) * widthRatio, (v + vHeight) * heightRatio).endVertex();
            buffer.pos(matrix, x + renderWidth, y, 0.0F).tex((u + uWidth) * widthRatio, v * heightRatio).endVertex();
            buffer.pos(matrix, x, y, 0.0F).tex(u * widthRatio, v * heightRatio).endVertex();
            buffer.finishDrawing();
            WorldVertexBufferUploader.draw(buffer);
        }
        public static void drawColouredBox(MatrixStack matrixStack, int x, int y, int z, int width, int height, int colour) {
            float alpha = (float)(colour >> 24 & 255) / 255.0F;
            float red = (float)(colour >> 16 & 255) / 255.0F;
            float green = (float)(colour >> 8 & 255) / 255.0F;
            float blue = (float)(colour & 255) / 255.0F;
            BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
            Matrix4f matrix = matrixStack.getLast().getMatrix();
            RenderSystem.pushTextureAttributes();
            RenderSystem.enableBlend();
            RenderSystem.disableTexture();
            RenderSystem.defaultBlendFunc();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(matrix, (float)x, (float)y + (float)height, (float)z).color(red, green, blue, alpha).endVertex();
            bufferbuilder.pos(matrix, (float)x + (float)width, (float)y + (float)height, (float)z).color(red, green, blue, alpha).endVertex();
            bufferbuilder.pos(matrix, (float)x + (float)width, (float)y, (float)z).color(red, green, blue, alpha).endVertex();
            bufferbuilder.pos(matrix, (float)x, (float)y, (float)z).color(red, green, blue, alpha).endVertex();
            bufferbuilder.finishDrawing();
            WorldVertexBufferUploader.draw(bufferbuilder);
            RenderSystem.enableTexture();
            RenderSystem.disableBlend();
            RenderSystem.popAttributes();
        }

public static enum StringRenderType {
    NORMAL,
    DROP_SHADOW,
    OUTLINED;

    private StringRenderType() {
    }
}
    }