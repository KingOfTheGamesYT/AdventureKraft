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
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


public class TermiteToken extends Item {
    public TermiteToken() {
        super(new Properties().group(DangerZone.TAB)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .fastToEat()
                        .build()));
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public ItemStack onItemUseFinish (ItemStack stack, World world, LivingEntity entity) {
        if (stack.isFood()) {

            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                player.addStat(Stats.ITEM_USED.get(stack.getItem()));
                if (player instanceof ServerPlayerEntity && world.getDimensionKey() == RegistryHandler.CRYSTAL) {
                    CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)player, stack);
                }
            }

            if (!(entity instanceof PlayerEntity) || (world.getDimensionKey() == RegistryHandler.CRYSTAL || (!((PlayerEntity) entity).abilities.isCreativeMode))) {
                stack.shrink(1);
            }
        }
        if (!world.isRemote && entity instanceof PlayerEntity)  {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;

            if (world.getDimensionKey() == RegistryHandler.CRYSTAL) {
                if (!ForgeHooks.onTravelToDimension(player, World.OVERWORLD))
                    return stack;

                teleportToDimension(world, player, World.OVERWORLD);
            } else {
                if (!ForgeHooks.onTravelToDimension(player, RegistryHandler.CRYSTAL))
                    return stack;

                teleportToDimension(world, player, RegistryHandler.CRYSTAL);
            }
        }
        return stack;
    }

    public int getUseDuration(ItemStack p_77626_1_) {
        if (p_77626_1_.getItem().isFood()) {
            return this.getFood().isFastEating() ? 1 : 32;
        } else {
            return 0;
        }
    }

    public void teleportToDimension(World worldIn, PlayerEntity player, RegistryKey<World> dimension) {
        if (player.isAlive() && !worldIn.isRemote()) {
            if (!player.isPassenger() && !player.isPassenger() && player.canChangeDimension()) {
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

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        player.setActiveHand(hand);
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A77" + "This is needed to get to the Crystal Dimension" + "\u00A77"));
    }
}