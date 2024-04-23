package com.devmaster.dangerzone.functions;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ScytheHitEvent {

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        World world = player.world;
        ItemStack heldItem = player.getHeldItemMainhand();

        // Check if the item used is the Scythe
        if (heldItem.getItem() == RegistryHandler.EXPERIENCE_SCYTHE.get()) {
            // Check if the entity attacked is a mob
            if (event.getTarget() instanceof MobEntity) {
                // Drop a bottle of enchanting
                ItemStack bottleStack = new ItemStack(Items.EXPERIENCE_BOTTLE);

                // Drop the ItemStack onto the ground at the mob's position
                world.addEntity(new ItemEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), bottleStack));
            }
        }
    }
}
