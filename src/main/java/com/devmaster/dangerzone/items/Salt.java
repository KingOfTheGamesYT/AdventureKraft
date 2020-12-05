package com.devmaster.dangerzone.items;




import com.devmaster.dangerzone.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;


public class Salt extends Item {

    public Salt() {
        super(new Properties().group(DangerZone.TAB));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new StringTextComponent("\u00A7f" + "Put a salt block in the furnace and add some salt to your food! Forget what the doctors say, this is Minecraft! :)" + "\u00A7f"));
    }
}