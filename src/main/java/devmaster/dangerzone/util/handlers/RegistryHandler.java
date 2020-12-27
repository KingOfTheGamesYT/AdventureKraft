package devmaster.dangerzone.util.handlers;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {

	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {

			}


	
	public static void preInitRegistries() {

	}
	
	public static void initRegistries() {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
	}
}
