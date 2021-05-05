package com.devmaster.dangerzone.items;


import com.devmaster.dangerzone.misc.DangerZone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.block.Blocks.*;
import static net.minecraft.util.Direction.*;

public class MinersDreamItem extends Item {

	public MinersDreamItem() {
		super(new Item.Properties().group(DangerZone.TAB));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
		ItemStack stack = playerEntity.getHeldItem(hand);
		playerEntity.setActiveHand(hand);
		BlockPos pos = playerEntity.getPosition();
		Direction direction = playerEntity.getAdjustedHorizontalFacing();
		if(!playerEntity.abilities.isCreativeMode) {
			stack.shrink(1);
		}
		if(!world.isRemote) {
			for(int x = -5; x <= 5; x++) {
				for(int y = 0; y <= 5; y++) {
					for(int z = 0; z <= 50; z++) {
						BlockPos newPos = new BlockPos(pos);
						if(direction == SOUTH) {
							newPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
						}else if(direction == NORTH) {
							newPos = new BlockPos(pos.getX() - x, pos.getY() + y, pos.getZ() - z);
						}else if(direction == EAST) {
							newPos = new BlockPos(pos.getX() + z, pos.getY() + y, pos.getZ() + x);
						}else if(direction == WEST) {
							newPos = new BlockPos(pos.getX() - z, pos.getY() + y, pos.getZ() - x);
						}

						BlockPos topPos = new BlockPos(newPos.getX(), newPos.getY() + 1, newPos.getZ());
						if(topPos.getY() <= 50 &&world.getBlockState(topPos) == AIR.getDefaultState() || world.getBlockState(topPos) == WATER.getDefaultState() || world.getBlockState(topPos) == LAVA.getDefaultState()) {
							world.setBlockState(topPos, COBBLESTONE.getDefaultState());
						}


						if(		world.getBlockState(newPos) == STONE.getDefaultState() || world.getBlockState(newPos) == GRANITE.getDefaultState() ||
								world.getBlockState(newPos) == DIORITE.getDefaultState() || world.getBlockState(newPos) == ANDESITE.getDefaultState() ||
								world.getBlockState(newPos) == GRAVEL.getDefaultState() || world.getBlockState(newPos) == DIRT.getDefaultState() ||
								world.getBlockState(newPos) == COBBLESTONE.getDefaultState() || world.getBlockState(newPos) == LAVA.getDefaultState() ||
								world.getBlockState(newPos) == SAND.getDefaultState() || world.getBlockState(newPos) == SANDSTONE.getDefaultState() ||
								world.getBlockState(newPos) == TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == END_STONE.getDefaultState() ||
								world.getBlockState(newPos) == RED_SAND.getDefaultState() || world.getBlockState(newPos) == RED_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == ORANGE_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == GRAY_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == WHITE_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == RED_SANDSTONE.getDefaultState() ||
								world.getBlockState(newPos) == MAGENTA_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == LIGHT_BLUE_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == YELLOW_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == LIME_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == PINK_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == LIGHT_GRAY_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == CYAN_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == PURPLE_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == BLUE_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == BROWN_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == GREEN_TERRACOTTA.getDefaultState() || world.getBlockState(newPos) == RED_TERRACOTTA.getDefaultState() ||
								world.getBlockState(newPos) == GRASS_BLOCK.getDefaultState() || world.getBlockState(newPos) == NETHERRACK.getDefaultState() ||
								world.getBlockState(newPos) == SNOW.getDefaultState()) {


							world.setBlockState(newPos, AIR.getDefaultState());
							if(x == 0 && y == 0 && z % 5 == 0) {
								world.setBlockState(newPos, TORCH.getDefaultState());
							}
						}
					}
				}
			}
			return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}
		return new ActionResult<>(ActionResultType.FAIL, stack);
	}
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
		tooltip.add(new StringTextComponent("\u00A72" + "You've gotta try it! Make one. Now. Take it underground, tap it on a block in front of you at your feet, and be amazed! Indeed. It removes blocks from a large area leaving only the ores behind, instantly. It even lights the place up with torches. All you need to do is run amok with your pickaxe and reap the rewards!" + "\u00A72"));
	}
}
