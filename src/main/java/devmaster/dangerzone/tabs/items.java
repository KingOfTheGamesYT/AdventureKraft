package devmaster.dangerzone.tabs;

import devmaster.dangerzone.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class items  extends CreativeTabs
{
    public items(String label)
    {
        super("tab");

    }
    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.AMETHYST);
    }
}