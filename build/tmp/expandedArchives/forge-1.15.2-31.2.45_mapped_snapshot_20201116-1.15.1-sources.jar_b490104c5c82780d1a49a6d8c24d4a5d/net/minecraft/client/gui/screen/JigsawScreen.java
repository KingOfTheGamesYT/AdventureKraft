package net.minecraft.client.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.play.client.CUpdateJigsawBlockPacket;
import net.minecraft.tileentity.JigsawTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JigsawScreen extends Screen {
   private final JigsawTileEntity field_214259_a;
   private TextFieldWidget attachementTypeField;
   private TextFieldWidget targetPoolField;
   private TextFieldWidget finalStateField;
   private Button doneButton;

   public JigsawScreen(JigsawTileEntity p_i51083_1_) {
      super(NarratorChatListener.EMPTY);
      this.field_214259_a = p_i51083_1_;
   }

   public void tick() {
      this.attachementTypeField.tick();
      this.targetPoolField.tick();
      this.finalStateField.tick();
   }

   private void func_214256_b() {
      this.func_214258_d();
      this.minecraft.displayGuiScreen((Screen)null);
   }

   private void func_214257_c() {
      this.minecraft.displayGuiScreen((Screen)null);
   }

   private void func_214258_d() {
      this.minecraft.getConnection().sendPacket(new CUpdateJigsawBlockPacket(this.field_214259_a.getPos(), new ResourceLocation(this.attachementTypeField.getText()), new ResourceLocation(this.targetPoolField.getText()), this.finalStateField.getText()));
   }

   public void onClose() {
      this.func_214257_c();
   }

   protected void init() {
      this.minecraft.keyboardListener.enableRepeatEvents(true);
      this.doneButton = this.addButton(new Button(this.width / 2 - 4 - 150, 210, 150, 20, I18n.format("gui.done"), (p_214255_1_) -> {
         this.func_214256_b();
      }));
      this.addButton(new Button(this.width / 2 + 4, 210, 150, 20, I18n.format("gui.cancel"), (p_214252_1_) -> {
         this.func_214257_c();
      }));
      this.targetPoolField = new TextFieldWidget(this.font, this.width / 2 - 152, 40, 300, 20, I18n.format("jigsaw_block.target_pool"));
      this.targetPoolField.setMaxStringLength(128);
      this.targetPoolField.setText(this.field_214259_a.getTargetPool().toString());
      this.targetPoolField.setResponder((p_214254_1_) -> {
         this.func_214253_a();
      });
      this.children.add(this.targetPoolField);
      this.attachementTypeField = new TextFieldWidget(this.font, this.width / 2 - 152, 80, 300, 20, I18n.format("jigsaw_block.attachement_type"));
      this.attachementTypeField.setMaxStringLength(128);
      this.attachementTypeField.setText(this.field_214259_a.getAttachmentType().toString());
      this.attachementTypeField.setResponder((p_214251_1_) -> {
         this.func_214253_a();
      });
      this.children.add(this.attachementTypeField);
      this.finalStateField = new TextFieldWidget(this.font, this.width / 2 - 152, 120, 300, 20, I18n.format("jigsaw_block.final_state"));
      this.finalStateField.setMaxStringLength(256);
      this.finalStateField.setText(this.field_214259_a.getFinalState());
      this.children.add(this.finalStateField);
      this.setFocusedDefault(this.targetPoolField);
      this.func_214253_a();
   }

   protected void func_214253_a() {
      this.doneButton.active = ResourceLocation.isResouceNameValid(this.attachementTypeField.getText()) & ResourceLocation.isResouceNameValid(this.targetPoolField.getText());
   }

   public void resize(Minecraft p_resize_1_, int p_resize_2_, int p_resize_3_) {
      String s = this.attachementTypeField.getText();
      String s1 = this.targetPoolField.getText();
      String s2 = this.finalStateField.getText();
      this.init(p_resize_1_, p_resize_2_, p_resize_3_);
      this.attachementTypeField.setText(s);
      this.targetPoolField.setText(s1);
      this.finalStateField.setText(s2);
   }

   public void removed() {
      this.minecraft.keyboardListener.enableRepeatEvents(false);
   }

   public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
      if (super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_)) {
         return true;
      } else if (!this.doneButton.active || p_keyPressed_1_ != 257 && p_keyPressed_1_ != 335) {
         return false;
      } else {
         this.func_214256_b();
         return true;
      }
   }

   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
      this.renderBackground();
      this.drawString(this.font, I18n.format("jigsaw_block.target_pool"), this.width / 2 - 153, 30, 10526880);
      this.targetPoolField.render(p_render_1_, p_render_2_, p_render_3_);
      this.drawString(this.font, I18n.format("jigsaw_block.attachement_type"), this.width / 2 - 153, 70, 10526880);
      this.attachementTypeField.render(p_render_1_, p_render_2_, p_render_3_);
      this.drawString(this.font, I18n.format("jigsaw_block.final_state"), this.width / 2 - 153, 110, 10526880);
      this.finalStateField.render(p_render_1_, p_render_2_, p_render_3_);
      super.render(p_render_1_, p_render_2_, p_render_3_);
   }
}
