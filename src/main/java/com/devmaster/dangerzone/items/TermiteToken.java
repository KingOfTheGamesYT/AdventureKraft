package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.world.teleportors.CrystalTeleporter;
import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ITag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.lang.reflect.Method;
import java.util.List;


public class TermiteToken extends Item {

    public TermiteToken() {
        super(new Properties().group(DangerZone.TAB));
    }

    private boolean isInventoryEmpty(PlayerEntity player) {
        ITag<Item> allowedItemsTag = DangerZone.CRYSTAL_DIMENSION_ALLOWED_ITEMS;

        for (ItemStack stack : player.inventory.mainInventory) {
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) {
                return false;
            }
        }

        for (ItemStack stack : player.inventory.armorInventory) {
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) {
                return false;
            }
        }

        for (ItemStack stack : player.inventory.offHandInventory) {
            if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) {
                return false;
            }
        }

        if (ModList.get().isLoaded("curios")) {
            return checkCuriosSlots(player, allowedItemsTag);
        }

        return true;
    }

    private boolean checkCuriosSlots(PlayerEntity player, ITag<Item> allowedItemsTag) {
        return top.theillusivec4.curios.api.CuriosApi.getCuriosHelper().getEquippedCurios(player).map(handler -> {
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty() && !allowedItemsTag.contains(stack.getItem())) {
                    return false;
                }
            }
            return true;
        }).orElse(true);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

            // Dimension logic
            if (world.getDimensionKey() == RegistryHandler.CRYSTAL) {
                if (!ForgeHooks.onTravelToDimension(serverPlayer, World.OVERWORLD)) {
                    return new ActionResult<>(ActionResultType.FAIL, stack);
                }

                stack.shrink(1);
                teleportToDimension(world, serverPlayer, World.OVERWORLD);
            } else {
                if (!isInventoryEmpty(serverPlayer)) {
                    player.sendMessage(new StringTextComponent("Your inventory must be clear as a crystal to enter"), player.getUniqueID());
                    return new ActionResult<>(ActionResultType.FAIL, stack);
                }

                if (!ForgeHooks.onTravelToDimension(serverPlayer, RegistryHandler.CRYSTAL)) {
                    return new ActionResult<>(ActionResultType.FAIL, stack);
                }

                stack.shrink(1);
                teleportToDimension(world, serverPlayer, RegistryHandler.CRYSTAL);
            }

            serverPlayer.addStat(Stats.ITEM_USED.get(stack.getItem()));
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    public void teleportToDimension(World worldIn, PlayerEntity player, RegistryKey<World> dimension) {
        if (player.isAlive() && !worldIn.isRemote()) {
            if (!player.isPassenger() && player.canChangeDimension()) {
                ServerPlayerEntity playerMP = (ServerPlayerEntity) player;
                MinecraftServer server = player.getServer();
                ServerWorld destinationWorld = server != null ? server.getWorld(dimension) : null;
                if (destinationWorld == null) {
                    return;
                }

                CrystalTeleporter teleporter = new CrystalTeleporter();
                playerMP.changeDimension(destinationWorld, teleporter);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77This is needed to get to the Crystal Dimension\u00A77"));
    }
}