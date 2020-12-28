package devmaster.dangerzone.util.handlers;

import devmaster.dangerzone.DangerZone;
import devmaster.dangerzone.init.ModBlocks;
import devmaster.dangerzone.init.ModItems;
import devmaster.dangerzone.world.WorldGenOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		//BlockInit.getBlocks();
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	
	public static void preInitRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenOres(),0);
	}
	
	public static void initRegistries() {
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
	}
}
