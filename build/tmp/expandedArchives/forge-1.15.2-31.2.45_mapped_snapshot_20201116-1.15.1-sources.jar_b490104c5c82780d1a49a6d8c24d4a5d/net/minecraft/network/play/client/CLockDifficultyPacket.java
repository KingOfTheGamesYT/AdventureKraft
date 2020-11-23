package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CLockDifficultyPacket implements IPacket<IServerPlayNetHandler> {
   private boolean difficultyLocked;

   public CLockDifficultyPacket() {
   }

   @OnlyIn(Dist.CLIENT)
   public CLockDifficultyPacket(boolean lockedIn) {
      this.difficultyLocked = lockedIn;
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IServerPlayNetHandler handler) {
      handler.processLockDifficulty(this);
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.difficultyLocked = buf.readBoolean();
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeBoolean(this.difficultyLocked);
   }

   /**
    * True if the server's difficulty should be set to locked.
    */
   public boolean isDifficultyLocked() {
      return this.difficultyLocked;
   }
}
