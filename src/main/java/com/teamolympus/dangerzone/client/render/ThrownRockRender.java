package com.teamolympus.dangerzone.client.render;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.teamolympus.dangerzone.entity.RockEntity;

@SideOnly(Side.CLIENT)
public class ThrownRockRender extends Render {

    private final Item item;

    public ThrownRockRender(Item item) {
        this.item = item;
    }

    @Override
    public void doRender(Entity entity, double parX, double parY, double parZ, float par1, float par2) {
        IIcon iicon = this.item.getIconFromDamage(0);
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) parX, (float) parY, (float) parZ);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindEntityTexture(entity);
            Tessellator tessellator = Tessellator.instance;
            this.renderManager(tessellator, iicon);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity ent) {
        RockEntity rock = (RockEntity) ent;
         switch (rock.rockTypes) {
             case EXPLOSIVE_ROCK :
                 return new ResourceLocation(DangerZone.MODID, "textures/item/explosiverock.png");
             case SMALL_ROCK:
                 return new ResourceLocation(DangerZone.MODID, "textures/item/smallrock.png");
             case GREEN_ROCK:
                return new ResourceLocation(DangerZone.MODID, "textures/item/greenRock.png");
             case RED_ROCK :
                return new ResourceLocation(DangerZone.MODID, "textures/item/redRock.png");

        };

         System.out.println("ERROR HERE IN RENDERING FOR ROCK!!!!!!!!!");
        return null;
    }

    // TODO: REFERENCE from RenderXPOrb or RenderArrow class..
    private void renderManager(Tessellator tessellator, IIcon icon) {
        float f = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((0.0F - f5), (0.0F - f6), 0.0D, f, f3);
        tessellator.addVertexWithUV((f4 - f5), (0.0F - f6), 0.0D, f1, f3);
        tessellator.addVertexWithUV((f4 - f5), (f4 - f6), 0.0D, f1, f2);
        tessellator.addVertexWithUV((0.0F - f5), (f4 - f6), 0.0D, f, f2);
        tessellator.draw();
    }

}
