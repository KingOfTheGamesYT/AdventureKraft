package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.entity.NotBreeBree;
import com.devmaster.dangerzone.entity.StampyLongNose;
import com.devmaster.dangerzone.entity.Tewtiy;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.List;

import static net.minecraft.util.Direction.*;

public class PlayButtonOreBlock extends OreBlock {


    public PlayButtonOreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(10.0F, 12.0F)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    private void spawnYoutuber(ServerWorld world, BlockPos pos) {
        Tewtiy tewtiy = RegistryHandler.TEWTIY.get().create(world);
        tewtiy.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        StampyLongNose stampyLongNose = RegistryHandler.STAMPYLONGNOSE.get().create(world);
        stampyLongNose.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        NotBreeBree notBreeBree = RegistryHandler.NOTBREEBREE.get().create(world);
        notBreeBree.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(tewtiy);
            tewtiy.spawnExplosionParticle();
            world.addEntity(notBreeBree);
            notBreeBree.spawnExplosionParticle();
            world.addEntity(stampyLongNose);
            stampyLongNose.spawnExplosionParticle();
        }


    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack){
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
        if (worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            this.spawnYoutuber(worldIn, pos);
        }
    }


    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(   "\u00A7e" + "Used to hire Youtubers" + "\u00A7e"));
    }
}
