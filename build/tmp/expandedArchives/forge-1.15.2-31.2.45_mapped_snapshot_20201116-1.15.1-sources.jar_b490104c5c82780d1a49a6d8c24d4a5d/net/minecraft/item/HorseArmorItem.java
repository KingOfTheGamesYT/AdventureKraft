package net.minecraft.item;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HorseArmorItem extends Item {
   private final int armorValue;
   private final ResourceLocation texture;

   public HorseArmorItem(int armorValueIn, String tierArmor, Item.Properties builder) {
      this(armorValueIn, new ResourceLocation("textures/entity/horse/armor/horse_armor_" + tierArmor + ".png"), builder);
   }

   public HorseArmorItem(int armorValueIn, ResourceLocation texture, Item.Properties builder) {
      super(builder);
      this.armorValue = armorValueIn;
      this.texture = texture;
   }

   @OnlyIn(Dist.CLIENT)
   public ResourceLocation getArmorTexture() {
      return texture;
   }

   public int getArmorValue() {
      return this.armorValue;
   }
}