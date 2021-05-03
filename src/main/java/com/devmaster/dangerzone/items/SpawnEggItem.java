package com.devmaster.dangerzone.items;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class SpawnEggItem extends SpawnEgg {
    private Supplier<? extends EntityType<?>> typeGetter;

    public SpawnEggItem(Supplier<? extends EntityType<?>> typeIn, Properties properties) {
        super(null, properties);
        typeGetter = typeIn;
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        return typeGetter.get();
    }

}