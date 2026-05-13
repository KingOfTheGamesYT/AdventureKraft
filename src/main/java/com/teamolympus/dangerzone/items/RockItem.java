package com.teamolympus.dangerzone.items;

import com.teamolympus.dangerzone.entity.rocks.ExplosiveRockEntity;
import com.teamolympus.dangerzone.entity.rocks.GreenRockEntity;
import com.teamolympus.dangerzone.entity.rocks.RedRockEntity;
import com.teamolympus.dangerzone.entity.rocks.SmallRockEntity;
import com.teamolympus.dangerzone.misc.DangerZone;
import com.teamolympus.dangerzone.misc.EnumRockTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.items.base.BaseAKItem;

public class RockItem extends BaseAKItem {

    final EnumRockTypes rockTypes;
    public RockItem(String name, EnumRockTypes rockTypes) {
        super(name);
       this.setHasSubtypes(true);
        this.setTextureName(DangerZone.ROCK_PREFIX + name);
        this.rockTypes = rockTypes;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            switch (rockTypes) {
                case GREEN_ROCK:
                    worldIn.spawnEntityInWorld(new GreenRockEntity(worldIn, player));
                    break;
                case RED_ROCK:
                    worldIn.spawnEntityInWorld(new RedRockEntity(worldIn, player));
                    break;
                case EXPLOSIVE_ROCK:
                    worldIn.spawnEntityInWorld(new ExplosiveRockEntity(worldIn, player));
                    break;
                case SMALL_ROCK:
                    worldIn.spawnEntityInWorld(new SmallRockEntity(worldIn, player));
                    break;
                default:
                    return itemStackIn;
            }
        }

        return itemStackIn;
    }


}
