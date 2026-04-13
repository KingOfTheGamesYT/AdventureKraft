package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.items.base.BaseAKItem;

public class RockItem extends BaseAKItem {

    public RockItem(String name) {
        super(name);
       this.setHasSubtypes(true);
        this.setTextureName(DangerZone.ROCK_PREFIX + name);
    }

    @Override // ItemSnowball
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        return itemStackIn;
    }

}
