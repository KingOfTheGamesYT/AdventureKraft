package com.devmaster.dangerzone.items;




import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class CritterCage extends Item {

    public CritterCage() {
        super(new Properties().group(DangerZone.WIP));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A78" + "Critter Cages only work about 80% of the time. You may have to throw more than one. And yes, they catch all types of critters. Handy against creepers. Just throw one at an entity to catch it. Right click it on the ground to release the captured critter. Yes, they work on big critters too, but very rarely.\n" + "\u00A78"));
    }
}