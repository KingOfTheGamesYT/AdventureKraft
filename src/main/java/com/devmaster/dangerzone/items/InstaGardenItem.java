package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.DangerZone;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class InstaGardenItem extends Item {

	public InstaGardenItem() {
		super(new Properties().group(DangerZone.TAB));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		if(!(world instanceof ServerWorld)) {
			return ActionResultType.FAIL;
		}
		ItemStack stack = context.getItem();
		PlayerEntity playerEntity = context.getPlayer();
		ServerWorld serverWorld = (ServerWorld)world;
		Direction direction = context.getPlacementHorizontalFacing();
		BlockPos pos = context.getPos();
		Rotation rotation = Rotation.NONE;
		if(!playerEntity.abilities.isCreativeMode) {
			stack.shrink(1);
		}

		if(direction == Direction.NORTH) {
			pos = pos.add(8, 0, 0);
			rotation = Rotation.CLOCKWISE_180;
		}else if(direction == Direction.SOUTH) {
			pos = pos.add(-8, 0, 0);
			rotation = Rotation.NONE;
		}else if(direction == Direction.EAST) {
			pos = pos.add(0, 0, 8);
			rotation = Rotation.COUNTERCLOCKWISE_90;
		}else if(direction == Direction.WEST) {
			pos = pos.add(0, 0, -8);
			rotation = Rotation.CLOCKWISE_90;
		}

		generateShelter(serverWorld, pos, rotation);

		return ActionResultType.SUCCESS;

	}

	private void generateShelter(ServerWorld world, BlockPos pos, Rotation rotation) {
		Template template = world.getStructureTemplateManager().getTemplate(new ResourceLocation(DangerZone.MODID, "struct_instant_garden"));
		PlacementSettings settings = new PlacementSettings();
		settings.setRotation(rotation);

		template.addBlocksToWorld(world, pos, settings);

	}

}
