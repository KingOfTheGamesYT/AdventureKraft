package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.items.EffectiveToolItem;
import com.devmaster.dangerzone.items.SizedToolItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.HashSet;
import java.util.Set;

public class BreakUtil {
    public static void breakNeighbours(ItemStack tool, World world, BlockPos pos, PlayerEntity player) {
        if (world.isRemote) return;

        if (tool.isEmpty()) return;

        if (!(tool.getItem() instanceof EffectiveToolItem)) return;

        BlockState originalState = world.getBlockState(pos);
        if (originalState.getBlock() == Blocks.TORCH || originalState.getBlockHardness(world, pos) == 0 && originalState.getHarvestTool() == null) {
            return;
        }

        world.setBlockState(pos, Blocks.GLASS.getDefaultState());
        RayTraceResult ray = rayTrace(world, player);
        world.setBlockState(pos, originalState);

        if (ray.getType() != RayTraceResult.Type.BLOCK) {
            return;
        }

        BlockRayTraceResult trace = (BlockRayTraceResult) ray;
        Direction facing = trace.getFace();
        int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, tool);
        int silkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, tool);

        for (BlockPos target : nearbyBlocks(tool, pos, facing, world, player)) {
            BlockState state = world.getBlockState(target);

            if (tool.getItem() instanceof EffectiveToolItem) {
                EffectiveToolItem toolItem = (EffectiveToolItem) tool.getItem();
                if (toolItem.getEffectiveBlocks().contains(state.getBlock()) || toolItem.getEffectiveMaterials().contains(state.getMaterial())) {
                    world.destroyBlock(target, false);
                    state.getBlock().harvestBlock(world, player, target, state, null, tool);
                    state.getBlock().dropXpOnBlockBreak(world, target, state.getExpDrop(world, target, fortune, silkTouch));
                    tool.damageItem(1, player, p -> p.sendBreakAnimation(Hand.MAIN_HAND));
                }
            }
        }
    }

    public static Set<BlockPos> nearbyBlocks(ItemStack tool, BlockPos origin, Direction facing, World world, PlayerEntity player) {
        int width = ((SizedToolItem) tool.getItem()).getWidth();

        Set<BlockPos> result = new HashSet<>();

        for (int x = -width; x < width + 1; x++) {
            for (int z = -width; z < width + 1; z++) {
                if (x == z && z == 0) {
                    continue;
                }

                BlockPos potential;

                switch (facing.getAxis()) {
                    case X:
                        potential = origin.add(0, x, z);
                        break;
                    case Y:
                        potential = origin.add(x, 0, z);
                        break;
                    case Z:
                        potential = origin.add(x, z, 0);
                        break;
                    default:
                        continue;
                }

                BlockState state = world.getBlockState(potential);
                if (BlockTags.WITHER_IMMUNE.contains(state.getBlock())) {
                    continue;
                }

                if (!ForgeHooks.canHarvestBlock(state, player, world, potential)) {
                    continue;
                }

                EffectiveToolItem toolItem = (EffectiveToolItem) tool.getItem();
                if (toolItem.getEffectiveBlocks().contains(state.getBlock()) || toolItem.getEffectiveMaterials().contains(state.getMaterial())) {
                    result.add(potential);
                }
            }
        }

        return result;
    }

    public static RayTraceResult rayTrace(World world, PlayerEntity player) {
        Vec3d eyes = player.getEyePosition(player.getEyeHeight());
        float yawCos = MathHelper.cos(-player.rotationYaw * (float) (Math.PI / 180F) - (float) Math.PI);
        float yawSin = MathHelper.sin(-player.rotationYaw * (float) (Math.PI / 180F) - (float) Math.PI);
        float pitchCos = -MathHelper.cos(-player.rotationPitch * (float) (Math.PI / 180F));
        float pitchSin = MathHelper.sin(-player.rotationPitch * (float) (Math.PI / 180F));

        float f1 = yawSin * pitchCos;
        float f2 = yawCos * pitchCos;

        double reach = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();
        Vec3d reachVec = eyes.add((double) f1 * reach, (double) pitchSin * reach, (double) f2 * reach);
        return world.rayTraceBlocks(new RayTraceContext(eyes, reachVec, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player));
    }
}
