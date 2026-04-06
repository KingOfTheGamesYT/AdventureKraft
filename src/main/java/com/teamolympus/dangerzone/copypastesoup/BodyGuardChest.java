package com.teamolympus.dangerzone.copypastesoup;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BodyGuardChest extends BodyGuardInvBasic {


    public BodyGuardChest(String p_i1796_1_, int p_i1796_2_)
    {
        super(p_i1796_1_, false, p_i1796_2_);
    }

    @SideOnly(Side.CLIENT)
    public BodyGuardChest(String p_i1797_1_, boolean p_i1797_2_, int p_i1797_3_)
    {
        super(p_i1797_1_, p_i1797_2_, p_i1797_3_);
    }
}
