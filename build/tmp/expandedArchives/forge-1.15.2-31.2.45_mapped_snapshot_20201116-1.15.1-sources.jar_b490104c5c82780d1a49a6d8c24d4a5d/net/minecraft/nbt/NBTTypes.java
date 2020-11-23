package net.minecraft.nbt;

public class NBTTypes {
   private static final INBTType<?>[] field_229709_a_ = new INBTType[]{EndNBT.TYPE, ByteNBT.TYPE, ShortNBT.TYPE, IntNBT.TYPE, LongNBT.TYPE, FloatNBT.TYPE, DoubleNBT.TYPE, ByteArrayNBT.TYPE, StringNBT.TYPE, ListNBT.TYPE, CompoundNBT.TYPE, IntArrayNBT.TYPE, LongArrayNBT.TYPE};

   /**
    * Retrieves an INBTType by its numeric ID.<br/>Relies on a static final array, if for some reason someone has made a
    * custom INBTType, do not rely on this to retrieve it.
    */
   public static INBTType<?> getGetTypeByID(int p_229710_0_) {
      return p_229710_0_ >= 0 && p_229710_0_ < field_229709_a_.length ? field_229709_a_[p_229710_0_] : INBTType.func_229707_a_(p_229710_0_);
   }
}
