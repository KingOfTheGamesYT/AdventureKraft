package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.common.ToolType;

public class TermiteTrollOre extends OreBlock {

    public TermiteTrollOre() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }

    private void spawnTermite(ServerWorld world, BlockPos pos) {
            Termite termite = RegistryHandler.TERMITE.get().create(world);
            termite.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(termite);
            world.addEntity(termite);
            world.addEntity(termite);
            world.addEntity(termite);
            world.addEntity(termite);
        termite.spawnExplosionParticle();
        }


    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack){
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
        if (worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            this.spawnTermite(worldIn, pos);
        }
    }
}
