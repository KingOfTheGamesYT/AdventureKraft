package devmaster.dangerzone.items;


import devmaster.dangerzone.DangerZone;
import devmaster.dangerzone.init.ModItems;
import net.minecraft.item.Item;

public class Amethyst extends Item
{
    public Amethyst (String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DangerZone.TAB);

        ModItems.ITEMS.add(this);
    }


}
