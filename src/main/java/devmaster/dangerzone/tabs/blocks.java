package devmaster.dangerzone.tabs;

import devmaster.dangerzone.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class blocks extends CreativeTabs
{
    public blocks(String label)
    {
        super("blocks");

    }
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModBlocks.AMETHYST_ORE_BLOCK);
    }
}