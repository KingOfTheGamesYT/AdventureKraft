package com.devmaster.dangerzone.blocks;

import com.devmaster.dangerzone.entity.*;
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
import java.util.Random;

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
        Random random = new Random();
        float i = random.nextInt(13);
        if (i == 0) {
            Tewtiy tewtiy = RegistryHandler.TEWTIY.get().create(world);
            tewtiy.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(tewtiy);
            tewtiy.spawnExplosionParticle();
        }

        if (i == 1) {
            NotBreeBree notBreeBree = RegistryHandler.NOTBREEBREE.get().create(world);
            notBreeBree.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(notBreeBree);
            notBreeBree.spawnExplosionParticle();

        }

        if (i == 2) {
            StampyLongNose stampyLongNose = RegistryHandler.STAMPYLONGNOSE.get().create(world);
            stampyLongNose.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(stampyLongNose);
            stampyLongNose.spawnExplosionParticle();
        }
        if (i == 3) {
            Technoblade technoblade = RegistryHandler.TECHNOBLADE.get().create(world);
            technoblade.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(technoblade);
            technoblade.spawnExplosionParticle();
        }
        if (i == 4) {
            AlexiCraft alexicraft = RegistryHandler.ALEXICRAFT.get().create(world);
            alexicraft.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(alexicraft);
            alexicraft.spawnExplosionParticle();
        }
        if (i == 5) {
            AntVenom antvenom = RegistryHandler.ANTVENOM.get().create(world);
            antvenom.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(antvenom);
            antvenom.spawnExplosionParticle();
        }
        if (i == 6) {
            BabyAngel babyangel = RegistryHandler.BABYANGEL.get().create(world);
            babyangel.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(babyangel);
            babyangel.spawnExplosionParticle();
        }
        if (i == 7) {
            BabyDuck babyduck = RegistryHandler.BABYDUCK.get().create(world);
            babyduck.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(babyduck);
            babyduck.spawnExplosionParticle();
        }
        if (i == 8) {
            BabyLeah babyleah = RegistryHandler.BABYLEAH.get().create(world);
            babyleah.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(babyleah);
            babyleah.spawnExplosionParticle();
        }
        if (i == 9) {
            BabyMax babyangel = RegistryHandler.BABYMAX.get().create(world);
            babyangel.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(babyangel);
            babyangel.spawnExplosionParticle();
        }
        if (i == 10) {
            BajanCanadian bajancanadian = RegistryHandler.BAJANCANADIAN.get().create(world);
            bajancanadian.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(bajancanadian);
            bajancanadian.spawnExplosionParticle();
        }
        if (i == 11) {
            CaptainSparkelz captainsparkelz = RegistryHandler.CAPTAINSPARKELZ.get().create(world);
            captainsparkelz.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(captainsparkelz);
            captainsparkelz.spawnExplosionParticle();
        }
        if (i == 12) {
            Aphmau aphmau = RegistryHandler.APHMAU.get().create(world);
            aphmau.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addEntity(aphmau);
            aphmau.spawnExplosionParticle();
        }
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
