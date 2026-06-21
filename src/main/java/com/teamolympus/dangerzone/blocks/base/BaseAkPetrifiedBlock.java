package com.teamolympus.dangerzone.blocks.base;

import net.minecraft.block.material.Material;

import com.teamolympus.dangerzone.misc.DangerZone;

public class BaseAkPetrifiedBlock extends BaseAKBlock {

    public BaseAkPetrifiedBlock(String name) {
        super(name, 4.0f, 4.0f, Material.iron);
        this.setBlockTextureName(DangerZone.PETRIFIED_PREFIX + name);
        this.setCreativeTab(DangerZone.PETRIFIED);
    }
}
