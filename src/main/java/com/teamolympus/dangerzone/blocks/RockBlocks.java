package com.teamolympus.dangerzone.blocks;

import com.teamolympus.dangerzone.blocks.base.BaseAKBlock;
import com.teamolympus.dangerzone.misc.EnumRockTypes;
import com.teamolympus.dangerzone.registry.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class RockBlocks extends BaseAKBlock {
    final EnumRockTypes rockTypes;
    public RockBlocks(String name, float hardness, float resistance, Material materialIn, EnumRockTypes rockTypes) {
        super(name, hardness, resistance, materialIn);
        this.rockTypes = rockTypes;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2)
    {
        switch (rockTypes) {
            case EXPLOSIVE_ROCK:
                return RegistryHandler.explosiveRock;
            case GREEN_ROCK:
                return RegistryHandler.greenRock;
            case SMALL_ROCK:
                return RegistryHandler.smallRock;
            case RED_ROCK:
                return RegistryHandler.redRock;
        }
        return RegistryHandler.smallRock;
    }

}
