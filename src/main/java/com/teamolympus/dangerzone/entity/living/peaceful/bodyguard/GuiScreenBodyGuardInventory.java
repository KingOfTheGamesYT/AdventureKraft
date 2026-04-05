package com.teamolympus.dangerzone.entity.living.peaceful.bodyguard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenBodyGuardInventory extends GuiContainer {

    private static final ResourceLocation horseGuiTextures = new ResourceLocation("textures/gui/container/horse.png");
    private IInventory mainPlayerInv;
    private IInventory mobInv;
    private BodyguardEntity bodyguardEntity;
    private float field_147033_y;
    private float field_147032_z;

    public GuiScreenBodyGuardInventory(IInventory mainPlayerInv, IInventory mobInv, BodyguardEntity bodyguardEntity)
    {
        super(new ContainerGuardInventory(mainPlayerInv, mobInv, bodyguardEntity));
        this.mainPlayerInv = mainPlayerInv;
        this.mobInv = mobInv;
        this.bodyguardEntity = bodyguardEntity;
        this.allowUserInput = false;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        this.fontRendererObj.drawString(this.mobInv.hasCustomInventoryName() ? this.mobInv.getInventoryName() : I18n.format(this.mobInv.getInventoryName(), new Object[0]), 8, 6, 4210752);
        this.fontRendererObj.drawString(this.mainPlayerInv.hasCustomInventoryName() ? this.mainPlayerInv.getInventoryName() : I18n.format(this.mainPlayerInv.getInventoryName(), new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(horseGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.bodyguardEntity.isTamed() /**.isChested()**/)
        {
            this.drawTexturedModalRect(k + 79, l + 17, 0, this.ySize, 90, 54);
        }

      //  if (this.bodyguardEntity.func_110259_cr())
     //   {
            this.drawTexturedModalRect(k + 7, l + 35, 0, this.ySize + 54, 18, 18);
     //   }

        GuiInventory.func_147046_a(k + 51, l + 60, 17, (float)(k + 51) - this.field_147033_y, (float)(l + 75 - 50) - this.field_147032_z, this.bodyguardEntity);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.field_147033_y = (float)p_73863_1_;
        this.field_147032_z = (float)p_73863_2_;
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
