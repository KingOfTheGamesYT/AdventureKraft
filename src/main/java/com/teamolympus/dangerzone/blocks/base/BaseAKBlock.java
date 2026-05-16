package com.teamolympus.dangerzone.blocks.base;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseAKBlock extends Block {

    public BaseAKBlock(String name, float hardness, float resistance, Material materialIn) {
        super(materialIn);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(DangerZone.BLOCKS);
        this.setBlockName(name);
        this.setBlockTextureName(DangerZone.MODID_PREFIX + name);
    }
}
