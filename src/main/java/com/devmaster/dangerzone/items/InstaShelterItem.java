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

public class InstaShelterItem extends Item {

	public InstaShelterItem() {
		super(new Item.Properties().group(DangerZone.TAB));
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
			rotation = Rotation.NONE;
			pos = pos.add(-3, 0, -6);
		}else if(direction == Direction.SOUTH) {
			rotation = Rotation.CLOCKWISE_180;
			pos = pos.add(3, 0, 6);
		}else if(direction == Direction.EAST) {
			rotation = Rotation.CLOCKWISE_90;
			pos = pos.add(6, 0, -3);
		}else if(direction == Direction.WEST) {
			rotation = Rotation.COUNTERCLOCKWISE_90;
			pos = pos.add(-6, 0, 3);
		}

		generateShelter(serverWorld, pos, rotation);

		return ActionResultType.SUCCESS;
	}

	private void generateShelter(ServerWorld world, BlockPos pos, Rotation rotation) {
		Template template = world.getStructureTemplateManager().getTemplate(new ResourceLocation(DangerZone.MODID, "struct_instant_shelter"));
		PlacementSettings settings = new PlacementSettings();
		settings.setRotation(rotation);

		template.addBlocksToWorld(world, pos, settings);

	}

}
