package com.teamolympus.dangerzone.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.items.base.BaseAKItem;
import com.teamolympus.dangerzone.enums.EnumRockTypes;
import com.teamolympus.dangerzone.entity.RockEntity;

public class RockItem extends BaseAKItem {

    EnumRockTypes rockTypes;

    public RockItem(String name, EnumRockTypes rockTypes) {
        super(name);
        this.rockTypes = rockTypes;
    }

    @Override // ItemSnowball
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStackIn.stackSize;
        }

        worldIn.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(new RockEntity(worldIn, player, rockTypes));
        }

        return itemStackIn;
    }
}
