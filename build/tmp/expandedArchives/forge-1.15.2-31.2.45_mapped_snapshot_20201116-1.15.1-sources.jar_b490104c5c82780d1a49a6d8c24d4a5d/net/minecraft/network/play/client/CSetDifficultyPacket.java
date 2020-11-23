package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.world.Difficulty;

public class CSetDifficultyPacket implements IPacket<IServerPlayNetHandler> {
   private Difficulty difficulty;

   public CSetDifficultyPacket() {
   }

   public CSetDifficultyPacket(Difficulty difficultyIn) {
      this.difficulty = difficultyIn;
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IServerPlayNetHandler handler) {
      handler.processSetDifficulty(this);
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.difficulty = Difficulty.byId(buf.readUnsignedByte());
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeByte(this.difficulty.getId());
   }

   public Difficulty getDifficulty() {
      return this.difficulty;
   }
}
