package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ITag;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.ModList;

import java.util.List;
import java.util.function.Supplier;

public class BaseToken extends Item {

    public static class TokenConfig {
        public final RegistryKey<World> targetDimension;
        public final Supplier<ITeleporter> teleporter;
        public final boolean isFood;
        public final boolean requireEmptyInventory;
        public final String tooltip;

        public TokenConfig(RegistryKey<World> targetDimension, Supplier<ITeleporter> teleporter, boolean isFood, boolean requireEmptyInventory, String tooltip) {
            this.targetDimension = targetDimension;
            this.teleporter = teleporter;
            this.isFood = isFood;
            this.requireEmptyInventory = requireEmptyInventory;
            this.tooltip = tooltip;
        }
    }

    private final TokenConfig config;

    public BaseToken (Properties properties, TokenConfig config) {
        super(config.isFood
                ? properties.food(new Food.Builder()
                .fastToEat()
                .setAlwaysEdible()
                .build())
                : properties);

        this.config = config;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (config.isFood && this.getFood() != null) {
            return this.getFood().isFastEating() ? 1 : 32;
        }
        return 0;
    }

    private void teleport(World world, ServerPlayerEntity player, RegistryKey<World> destination) {
        if (!player.isAlive() || world.isRemote()) return;
        if (player.isPassenger() || !player.canChangeDimension()) return;

        MinecraftServer server = player.getServer();
        ServerWorld destWorld = server != null ? server.getWorld(destination) : null;
        if (destWorld == null) return;

        player.changeDimension(destWorld, config.teleporter.get());
    }

    private boolean isInventoryEmpty(PlayerEntity player) {
        ITag<Item> allowedItemsTag = DangerZone.CRYSTAL_DIMENSION_ALLOWED_ITEMS;

        for (ItemStack stack : player.inventory.mainInventory)
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) return false;

        for (ItemStack stack : player.inventory.armorInventory)
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) return false;

        for (ItemStack stack : player.inventory.offHandInventory)
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) return false;

        if (ModList.get().isLoaded("curios")) {
            return top.theillusivec4.curios.api.CuriosApi.getCuriosHelper()
                    .getEquippedCurios(player)
                    .map(handler -> {
                        for (int i = 0; i < handler.getSlots(); i++) {
                            ItemStack stack = handler.getStackInSlot(i);
                            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) return false;
                        }
                        return true;
                    }).orElse(true);
        }
        return true;
    }

    private void handleTeleport(World world, ServerPlayerEntity player) {
        RegistryKey<World> current = world.getDimensionKey();

        if (current == config.targetDimension) {
            if (!ForgeHooks.onTravelToDimension(player, World.OVERWORLD)) return;
            teleport(world, player, World.OVERWORLD);
        } else {
            if (config.requireEmptyInventory && !isInventoryEmpty(player)) {
                player.sendMessage(new StringTextComponent("Your inventory must be clear as a crystal"), player.getUniqueID());
                return;
            }

            if (!ForgeHooks.onTravelToDimension(player, config.targetDimension)) return;
            teleport(world, player, config.targetDimension);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (config.isFood) {
            player.setActiveHand(hand);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }

        if (!world.isRemote) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            handleTeleport(world, serverPlayer);
            stack.shrink(1);
            serverPlayer.addStat(Stats.ITEM_USED.get(this));
        }
        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
        if (!config.isFood) return stack;

        if (!world.isRemote && entity instanceof ServerPlayerEntity) {
            handleTeleport(world, (ServerPlayerEntity) entity);
        }

        if (!(entity instanceof PlayerEntity) || !((PlayerEntity) entity).abilities.isCreativeMode) {
            stack.shrink(1);
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent(config.tooltip));
    }
}