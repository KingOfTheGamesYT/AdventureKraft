package net.minecraft.client.gui.fonts;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TextInputUtil {
   private final Minecraft minecraft;
   private final FontRenderer fontRenderer;
   private final Supplier<String> textSupplier;
   private final Consumer<String> textConsumer;
   private final int textWidth;
   private int endIndex;
   private int startIndex;

   public TextInputUtil(Minecraft minecraftIn, Supplier<String> textSupplierIn, Consumer<String> textConsumerIn, int textWidthIn) {
      this.minecraft = minecraftIn;
      this.fontRenderer = minecraftIn.fontRenderer;
      this.textSupplier = textSupplierIn;
      this.textConsumer = textConsumerIn;
      this.textWidth = textWidthIn;
      this.putCursorAtEnd();
   }

   public boolean putChar(char character) {
      if (SharedConstants.isAllowedCharacter(character)) {
         this.putText(Character.toString(character));
      }

      return true;
   }

   private void putText(String text) {
      if (this.startIndex != this.endIndex) {
         this.removeSelectedText();
      }

      String s = this.textSupplier.get();
      this.endIndex = MathHelper.clamp(this.endIndex, 0, s.length());
      String s1 = (new StringBuilder(s)).insert(this.endIndex, text).toString();
      if (this.fontRenderer.getStringWidth(s1) <= this.textWidth) {
         this.textConsumer.accept(s1);
         this.startIndex = this.endIndex = Math.min(s1.length(), this.endIndex + text.length());
      }

   }

   public boolean specialKeyPressed(int keyIn) {
      String s = this.textSupplier.get();
      if (Screen.isSelectAll(keyIn)) {
         this.startIndex = 0;
         this.endIndex = s.length();
         return true;
      } else if (Screen.isCopy(keyIn)) {
         this.minecraft.keyboardListener.setClipboardString(this.getSelectedText());
         return true;
      } else if (Screen.isPaste(keyIn)) {
         this.putText(SharedConstants.filterAllowedCharacters(TextFormatting.getTextWithoutFormattingCodes(this.minecraft.keyboardListener.getClipboardString().replaceAll("\\r", ""))));
         this.startIndex = this.endIndex;
         return true;
      } else if (Screen.isCut(keyIn)) {
         this.minecraft.keyboardListener.setClipboardString(this.getSelectedText());
         this.removeSelectedText();
         return true;
      } else if (keyIn == 259) {
         if (!s.isEmpty()) {
            if (this.startIndex != this.endIndex) {
               this.removeSelectedText();
            } else if (this.endIndex > 0) {
               s = (new StringBuilder(s)).deleteCharAt(Math.max(0, this.endIndex - 1)).toString();
               this.startIndex = this.endIndex = Math.max(0, this.endIndex - 1);
               this.textConsumer.accept(s);
            }
         }

         return true;
      } else if (keyIn == 261) {
         if (!s.isEmpty()) {
            if (this.startIndex != this.endIndex) {
               this.removeSelectedText();
            } else if (this.endIndex < s.length()) {
               s = (new StringBuilder(s)).deleteCharAt(Math.max(0, this.endIndex)).toString();
               this.textConsumer.accept(s);
            }
         }

         return true;
      } else if (keyIn == 263) {
         int j = this.fontRenderer.getBidiFlag() ? 1 : -1;
         if (Screen.hasControlDown()) {
            this.endIndex = this.fontRenderer.getWordPosition(s, j, this.endIndex, true);
         } else {
            this.endIndex = Math.max(0, Math.min(s.length(), this.endIndex + j));
         }

         if (!Screen.hasShiftDown()) {
            this.startIndex = this.endIndex;
         }

         return true;
      } else if (keyIn == 262) {
         int i = this.fontRenderer.getBidiFlag() ? -1 : 1;
         if (Screen.hasControlDown()) {
            this.endIndex = this.fontRenderer.getWordPosition(s, i, this.endIndex, true);
         } else {
            this.endIndex = Math.max(0, Math.min(s.length(), this.endIndex + i));
         }

         if (!Screen.hasShiftDown()) {
            this.startIndex = this.endIndex;
         }

         return true;
      } else if (keyIn == 268) {
         this.endIndex = 0;
         if (!Screen.hasShiftDown()) {
            this.startIndex = this.endIndex;
         }

         return true;
      } else if (keyIn == 269) {
         this.endIndex = this.textSupplier.get().length();
         if (!Screen.hasShiftDown()) {
            this.startIndex = this.endIndex;
         }

         return true;
      } else {
         return false;
      }
   }

   private String getSelectedText() {
      String s = this.textSupplier.get();
      int i = Math.min(this.endIndex, this.startIndex);
      int j = Math.max(this.endIndex, this.startIndex);
      return s.substring(i, j);
   }

   private void removeSelectedText() {
      if (this.startIndex != this.endIndex) {
         String s = this.textSupplier.get();
         int i = Math.min(this.endIndex, this.startIndex);
         int j = Math.max(this.endIndex, this.startIndex);
         String s1 = s.substring(0, i) + s.substring(j);
         this.endIndex = i;
         this.startIndex = this.endIndex;
         this.textConsumer.accept(s1);
      }
   }

   public void putCursorAtEnd() {
      this.startIndex = this.endIndex = this.textSupplier.get().length();
   }

   public int getEndIndex() {
      return this.endIndex;
   }

   public int getStartIndex() {
      return this.startIndex;
   }
}
