package com.teamolympus.dangerzone.items.base;

import com.teamolympus.dangerzone.misc.DangerZone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BaseItemAKSpawnEgg extends BaseAKItem {

   String entName;

    public BaseItemAKSpawnEgg(String name) {
        super(name + "_spawn_egg");
        this.entName = name;
        this.setTextureName(DangerZone.SPAWN_EGG_PREFIX + name + "_spawn_egg");
    }


    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_,
        int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!world.isRemote) {
            Block block = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
            p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
            p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
            p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
            double d0 = 0.0D;

            if (p_77648_7_ == 1 && block.getRenderType() == 11) {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(
                world,
                entName,
                (double) p_77648_4_ + 0.5D,
                (double) p_77648_5_ + d0,
                (double) p_77648_6_ + 0.5D);

            if (entity != null) {
                if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
                    ((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
                }

                if (!player.capabilities.isCreativeMode) {
                    --stack.stackSize;
                }
            }

        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, player, true);

            if (movingobjectposition != null) {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!worldIn.canMineBlock(player, i, j, k)) {
                        return itemStackIn;
                    }

                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStackIn)) {
                        return itemStackIn;
                    }

                    if (worldIn.getBlock(i, j, k) instanceof BlockLiquid) {
                        Entity entity = spawnCreature(worldIn,entName, i, j, k);

                        if (entity != null) {
                            if (entity instanceof EntityLivingBase && itemStackIn.hasDisplayName()) {
                                ((EntityLiving) entity).setCustomNameTag(itemStackIn.getDisplayName());
                            }

                            if (!player.capabilities.isCreativeMode) {
                                --itemStackIn.stackSize;
                            }
                        }
                    }
                }

            }
        }
        return itemStackIn;
    }

    public static Entity spawnCreature(World world, String name, double x, double y,
        double z) {
        if (!EntityList.stringToClassMapping.containsKey(DangerZone.SPAWING_PREFIX + name)) {
            return null;
        } else {
            Entity entity = null;

            for (int j = 0; j < 1; ++j) {
                entity = EntityList.createEntityByName(DangerZone.SPAWING_PREFIX + name, world);

                if (entity instanceof EntityLivingBase) {
                    EntityLiving entityliving = (EntityLiving) entity;
                    entity.setLocationAndAngles(
                        x,
                        y,
                        z,
                        MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F),
                        0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg(null);
                    world.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        }
    }




}
