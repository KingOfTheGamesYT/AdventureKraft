package net.minecraft.client.gui.screen;

import net.minecraft.client.GameSettings;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SettingsScreen extends Screen {
   protected final Screen parentScreen;
   protected final GameSettings gameSettings;

   public SettingsScreen(Screen previousScreen, GameSettings gameSettingsObj, ITextComponent textComponentIn) {
      super(textComponentIn);
      this.parentScreen = previousScreen;
      this.gameSettings = gameSettingsObj;
   }

   public void removed() {
      this.minecraft.gameSettings.saveOptions();
   }

   public void onClose() {
      this.minecraft.displayGuiScreen(this.parentScreen);
   }
}
