package net.minecraft.advancements.criterion;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class BeeNestDestroyedTrigger extends AbstractCriterionTrigger<BeeNestDestroyedTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("bee_nest_destroyed");

   public ResourceLocation getId() {
      return ID;
   }

   /**
    * Deserialize a ICriterionInstance of this trigger from the data in the JSON.
    */
   public BeeNestDestroyedTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
      Block block = func_226221_a_(json);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      MinMaxBounds.IntBound minmaxbounds$intbound = MinMaxBounds.IntBound.fromJson(json.get("num_bees_inside"));
      return new BeeNestDestroyedTrigger.Instance(block, itempredicate, minmaxbounds$intbound);
   }

   @Nullable
   private static Block func_226221_a_(JsonObject json) {
      if (json.has("block")) {
         ResourceLocation resourcelocation = new ResourceLocation(JSONUtils.getString(json, "block"));
         return Registry.BLOCK.getValue(resourcelocation).orElseThrow(() -> {
            return new JsonSyntaxException("Unknown block type '" + resourcelocation + "'");
         });
      } else {
         return null;
      }
   }

   public void test(ServerPlayerEntity player, Block blockIn, ItemStack stack, int p_226223_4_) {
      this.func_227070_a_(player.getAdvancements(), (p_226220_3_) -> {
         return p_226220_3_.test(blockIn, stack, p_226223_4_);
      });
   }

   public static class Instance extends CriterionInstance {
      private final Block block;
      private final ItemPredicate predicate;
      private final MinMaxBounds.IntBound bound;

      public Instance(Block blockIn, ItemPredicate predicateIn, MinMaxBounds.IntBound boundIn) {
         super(BeeNestDestroyedTrigger.ID);
         this.block = blockIn;
         this.predicate = predicateIn;
         this.bound = boundIn;
      }

      public static BeeNestDestroyedTrigger.Instance func_226229_a_(Block p_226229_0_, ItemPredicate.Builder p_226229_1_, MinMaxBounds.IntBound p_226229_2_) {
         return new BeeNestDestroyedTrigger.Instance(p_226229_0_, p_226229_1_.build(), p_226229_2_);
      }

      public boolean test(Block p_226228_1_, ItemStack p_226228_2_, int p_226228_3_) {
         if (this.block != null && p_226228_1_ != this.block) {
            return false;
         } else {
            return !this.predicate.test(p_226228_2_) ? false : this.bound.test(p_226228_3_);
         }
      }

      public JsonElement serialize() {
         JsonObject jsonobject = new JsonObject();
         if (this.block != null) {
            jsonobject.addProperty("block", Registry.BLOCK.getKey(this.block).toString());
         }

         jsonobject.add("item", this.predicate.serialize());
         jsonobject.add("num_bees_inside", this.bound.serialize());
         return jsonobject;
      }
   }
}
