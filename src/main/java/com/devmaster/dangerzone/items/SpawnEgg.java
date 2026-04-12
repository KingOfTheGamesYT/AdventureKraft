package com.devmaster.dangerzone.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.*;

public class SpawnEgg extends SpawnEggItem {
    protected static final List<SpawnEgg> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;
    private String[] info = new String[0];

    public SpawnEgg(EntityType<?> entityType, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.entityTypeSupplier = Lazy.of(() -> entityType);
        UNADDED_EGGS.add(this);
    }

    public SpawnEgg(RegistryObject<? extends EntityType<?>> entityTypeSupplier, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
        UNADDED_EGGS.add(this);
    }

    public static void initSpawnEggs() {
        DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn((ServerWorld) source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };
        for (final SpawnEgg spawnEgg : UNADDED_EGGS) {
            DispenserBlock.registerDispenseBehavior(spawnEgg, dispenseBehaviour);
        }
        UNADDED_EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable final CompoundNBT nbt) {
        return entityTypeSupplier.get();
    }

    public SpawnEgg addInfo(String... newInfo) {
        if (newInfo != null && newInfo.length > 0) {
            String[] combinedInfo = new String[this.info.length + newInfo.length];
            System.arraycopy(this.info, 0, combinedInfo, 0, this.info.length);
            System.arraycopy(newInfo, 0, combinedInfo, this.info.length, newInfo.length);
            this.info = combinedInfo;
        }
        return this;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> list, ITooltipFlag flagIn){
        for (String s : info) {
            list.add(new StringTextComponent(s));
        }
    }
}