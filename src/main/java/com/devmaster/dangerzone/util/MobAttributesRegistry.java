package com.devmaster.dangerzone.util;

import com.devmaster.dangerzone.DangerZone;
import com.devmaster.dangerzone.entity.*;
import com.devmaster.dangerzone.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DangerZone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobAttributesRegistry { 

	@SubscribeEvent
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(RegistryHandler.TEWTIY.get(), Tewtiy.setCustomAttributes().create());
		event.put(RegistryHandler.STAMPYLONGNOSE.get(), StampyLongNose.setCustomAttributes().create());
		event.put(RegistryHandler.NOTBREEBREE.get(), NotBreeBree.setCustomAttributes().create());
		event.put(RegistryHandler.REDROSEWARRIOR.get(), RedRoseWarrior.setCustomAttributes().create());
		event.put(RegistryHandler.RAINBOWANT.get(), RainbowAnt.setCustomAttributes().create());
		event.put(RegistryHandler.BUTTERFLY.get(), Butterfly.setCustomAttributes().create());
		event.put(RegistryHandler.ENT.get(), Ent.setCustomAttributes().create());
		event.put(RegistryHandler.CAVE_FISHER.get(), CaveFisher.setCustomAttributes().create());
		event.put(RegistryHandler.ATTACK_SQUID.get(), AttackSquid.setCustomAttributes().create());
		event.put(RegistryHandler.HYDROLISC.get(), Hydrolisc.setCustomAttributes().create());
		event.put(RegistryHandler.ALLOSAURUS.get(), Allosaurus.setCustomAttributes().create());
        event.put(RegistryHandler.BIRD.get(), Bird.setCustomAttributes().create());
		event.put(RegistryHandler.TECHNOBLADE.get(), Technoblade.setCustomAttributes().create());
		event.put(RegistryHandler.MERMAID.get(), Mermaid.setCustomAttributes().create());
        
	}

}