package net.minecraft.tileentity;

import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JigsawTileEntity extends TileEntity {
   private ResourceLocation attachmentType = new ResourceLocation("empty");
   private ResourceLocation targetPool = new ResourceLocation("empty");
   private String finalState = "minecraft:air";

   public JigsawTileEntity(TileEntityType<?> type) {
      super(type);
   }

   public JigsawTileEntity() {
      this(TileEntityType.JIGSAW);
   }

   @OnlyIn(Dist.CLIENT)
   public ResourceLocation getAttachmentType() {
      return this.attachmentType;
   }

   @OnlyIn(Dist.CLIENT)
   public ResourceLocation getTargetPool() {
      return this.targetPool;
   }

   @OnlyIn(Dist.CLIENT)
   public String getFinalState() {
      return this.finalState;
   }

   public void setAttachmentType(ResourceLocation attachmentLocation) {
      this.attachmentType = attachmentLocation;
   }

   public void setTargetPool(ResourceLocation poolLocation) {
      this.targetPool = poolLocation;
   }

   public void setFinalState(String blockName) {
      this.finalState = blockName;
   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      compound.putString("attachement_type", this.attachmentType.toString());
      compound.putString("target_pool", this.targetPool.toString());
      compound.putString("final_state", this.finalState);
      return compound;
   }

   public void read(CompoundNBT compound) {
      super.read(compound);
      this.attachmentType = new ResourceLocation(compound.getString("attachement_type"));
      this.targetPool = new ResourceLocation(compound.getString("target_pool"));
      this.finalState = compound.getString("final_state");
   }

   /**
    * Retrieves packet to send to the client whenever this Tile Entity is resynced via World.notifyBlockUpdate. For
    * modded TE's, this packet comes back to you clientside in {@link #onDataPacket}
    */
   @Nullable
   public SUpdateTileEntityPacket getUpdatePacket() {
      return new SUpdateTileEntityPacket(this.pos, 12, this.getUpdateTag());
   }

   /**
    * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the chunk or when
    * many blocks change at once. This compound comes back to you clientside in {@link handleUpdateTag}
    */
   public CompoundNBT getUpdateTag() {
      return this.write(new CompoundNBT());
   }
}
