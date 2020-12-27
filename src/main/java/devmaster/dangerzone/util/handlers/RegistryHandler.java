package devmaster.dangerzone.util.handlers;

import devmaster.dangerzone.DangerZone;
import devmaster.dangerzone.init.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			DangerZone.proxy.registerItemRenderer(item, 0, "inventory");
		}
			}



	
	public static void preInitRegistries() {

	}
	
	public static void initRegistries() {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
	}
}
