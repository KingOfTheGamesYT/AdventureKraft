package com.teamolympus.dangerzone.items.rocks;

import com.teamolympus.dangerzone.entity.rocks.ExplosiveRockEntity;
import com.teamolympus.dangerzone.entity.rocks.SmallRockEntity;
import com.teamolympus.dangerzone.items.RockItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ExplosiveRockItem extends RockItem {
    public ExplosiveRockItem(String name) {
        super(name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStackIn.stackSize;
        }

        worldIn.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(new ExplosiveRockEntity(worldIn, player));
        }

        return itemStackIn;


    }
}
