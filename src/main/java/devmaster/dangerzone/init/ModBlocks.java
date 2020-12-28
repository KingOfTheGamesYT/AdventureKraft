package devmaster.dangerzone.init;


import devmaster.dangerzone.items.AmethystOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    //items
    public static final Block AMETHYST_ORE_BLOCK = new AmethystOre("amethyst_ore_block");
}
