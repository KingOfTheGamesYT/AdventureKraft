package com.devmaster.dangerzone.items;


import com.devmaster.dangerzone.DangerZone;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InstaNetherPortalItem extends Item {

	public InstaNetherPortalItem() {
		super(new Item.Properties().group(DangerZone.TAB));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World world = context.getWorld();
		PlayerEntity playerEntity = context.getPlayer();
		BlockPos pos = context.getPos();
		Direction direction = playerEntity.getAdjustedHorizontalFacing();
		if(!playerEntity.abilities.isCreativeMode) {
			stack.shrink(1);
		}
		if(!world.isRemote) {
			for(int x = -1; x <= 2; x++) {
				for(int y = 0; y <= 4; y++) {

					BlockPos newPos = new BlockPos(pos);
					if(direction == Direction.SOUTH) {
						newPos = pos.add(-(x), y, 0);
					}else if(direction == Direction.NORTH) {
						newPos = pos.add(x, y, 0);
					}else if(direction == Direction.EAST) {
						newPos = pos.add(0, y, x);
					}else if(direction == Direction.WEST) {
						newPos = pos.add(0, y, -(x));
					}

					world.setBlockState(newPos, Blocks.AIR.getDefaultState()); //Remove all blocks before placing new ones

					if(x == 0 || x == 1) {
						if(y != 1 && y != 2 && y != 3) {
							world.setBlockState(newPos, Blocks.OBSIDIAN.getDefaultState());
						}
					}else {
						world.setBlockState(newPos, Blocks.OBSIDIAN.getDefaultState());
					}
				}
			}
			if(direction == Direction.SOUTH) {
				world.setBlockState(pos.add(0, 1, 0), Blocks.FIRE.getDefaultState());
			}else if(direction == Direction.NORTH) {
				world.setBlockState(pos.add(0, 1, 0), Blocks.FIRE.getDefaultState());
			}else if(direction == Direction.EAST) {
				world.setBlockState(pos.add(0, 1, 1), Blocks.FIRE.getDefaultState());
			}else if(direction == Direction.WEST) {
				world.setBlockState(pos.add(0, 1, 0), Blocks.FIRE.getDefaultState());
			}

			return ActionResultType.SUCCESS;
		}else {
			world.playSound(playerEntity, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 0.5F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) * 0.5F);
		}

		return ActionResultType.FAIL;
	}
}
