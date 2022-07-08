package com.devmaster.dangerzone.functions;

import com.devmaster.dangerzone.misc.DangerZone;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class MermaidTickUpdateFunction {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onEntityAttacked(LivingAttackEvent event) {
            if (event != null && event.getEntity() != null) {
                Entity entity = event.getEntity();
                Entity sourceentity = event.getSource().getTrueSource();
                Entity immediatesourceentity = event.getSource().getImmediateSource();
                double i = entity.getPosX();
                double j = entity.getPosY();
                double k = entity.getPosZ();
                double amount = event.getAmount();
                World world = entity.world;
                Map<String, Object> dependencies = new HashMap<>();
                dependencies.put("x", i);
                dependencies.put("y", j);
                dependencies.put("z", k);
                dependencies.put("amount", amount);
                dependencies.put("world", world);
                dependencies.put("entity", entity);
                dependencies.put("sourceentity", sourceentity);
                dependencies.put("immediatesourceentity", immediatesourceentity);
                dependencies.put("event", event);
                heathGenerator(dependencies);
            }
        }
    }

    public static void heathGenerator(Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                DangerZone.LOGGER.warn("Failed to load dependency entity for function MermaidTickUpdate!");
            return;
        }

        // To make the health run up faster change 0.08 to a higher number.
        Entity entity = (Entity) dependencies.get("entity");
        if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 0)) {
            for (int index0 = 0; index0 < (int) (MathHelper.nextInt(new Random(), 1, 4)); index0++) {
                if (entity instanceof LivingEntity)
                    ((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 0.08));
            }
        }
    }
    }
