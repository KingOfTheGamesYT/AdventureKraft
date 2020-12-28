package devmaster.dangerzone.items;

import devmaster.dangerzone.DangerZone;
import devmaster.dangerzone.init.ModBlocks;
import devmaster.dangerzone.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class AmethystOre extends Block {

    public AmethystOre(String name)
    {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DangerZone.BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}