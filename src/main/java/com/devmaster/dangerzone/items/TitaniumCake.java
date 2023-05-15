package com.devmaster.dangerzone.items;




import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class TitaniumCake extends Item {

    public TitaniumCake() {
        super(new Properties().group(DangerZone.FOOD));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A7b" + "Thank you for 6k downloads!" + "\u00A7b"));
    }
}