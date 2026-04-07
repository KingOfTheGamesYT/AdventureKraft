package com.devmaster.dangerzone.misc;

import com.devmaster.dangerzone.items.*;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class HitCostEvent {

    // Constructor to register the event handler
    public HitCostEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        //(this includes players and mobs)
        if (event.getEntityLiving() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntityLiving();

            applyArmorHitCost(entity);
        }
    }

    private void applyArmorHitCost(LivingEntity entity) {

        for (ItemStack armorPiece : entity.getArmorInventoryList()) {
            if (armorPiece.getItem() instanceof Armour) {
                Armour armour = (Armour) armorPiece.getItem();

                //Apply custom durability multiplier
                int damage = (int) (armour.durabilityMultiplier);
                armorPiece.damageItem(damage, entity, (e) -> {
                    e.sendBreakAnimation(armorPiece.getEquipmentSlot());
                });
            }
        }
    }
    }