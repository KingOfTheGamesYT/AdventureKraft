package com.devmaster.dangerzone.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class RandomStructureBlock extends Block {

    public RandomStructureBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5f, 6.0f)
                .notSolid());
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isRemote) {

            world.getPendingBlockTicks().scheduleTick(pos, this, 100 + new Random().nextInt(100));
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        //Ensure the chunk is fully loaded before generating structures

        Random random = new Random();

        if (random.nextDouble() < 0.3) {  //30% chance to try spawning a village
            //Attempt to spawn a village
            ResourceLocation villageLocation = getRandomVillageJigsaw(world);
            if (villageLocation != null) {
                System.out.println("Attempting to spawn village: " + villageLocation);
                spawnVillageStructure(world, pos, villageLocation);
            } else {
                System.out.println("No village jigsaw pool found.");
            }
        } else if (random.nextBoolean()) {
            //Randomly decide whether to spawn a jigsaw structure or template
            ResourceLocation jigsawStructureLocation = getRandomJigsawStructure(world);
            System.out.println("Attempting to spawn jigsaw structure: " + jigsawStructureLocation);
            boolean jigsawSuccess = spawnJigsawStructure(world, pos, jigsawStructureLocation);

            if (!jigsawSuccess) {
                ResourceLocation templateStructureLocation = getRandomTemplateStructure();
                System.out.println("Jigsaw failed, attempting to spawn template structure: " + templateStructureLocation);
                spawnTemplateStructure(world, pos, templateStructureLocation);
            }
        } else {
            ResourceLocation templateStructureLocation = getRandomTemplateStructure();
            System.out.println("Attempting to spawn template structure: " + templateStructureLocation);
            boolean templateSuccess = spawnTemplateStructure(world, pos, templateStructureLocation);

            if (!templateSuccess) {
                ResourceLocation jigsawStructureLocation = getRandomJigsawStructure(world);
                System.out.println("Template failed, attempting to spawn jigsaw structure: " + jigsawStructureLocation);
                spawnJigsawStructure(world, pos, jigsawStructureLocation);
            }
        }

        //Remove the Random Structure Block after structure generation
        world.removeBlock(pos, false);
    }

    private ResourceLocation getRandomVillageJigsaw(ServerWorld world) {
        DynamicRegistries dynamicRegistryManager = world.func_241828_r();
        Registry<JigsawPattern> jigsawPoolRegistry = dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY);

        List<ResourceLocation> villagePoolList = new ArrayList<>();
        for (ResourceLocation pool : jigsawPoolRegistry.keySet()) {
            if (pool.getPath().contains("village/")) {// Filter for villages
                villagePoolList.add(pool);
            }
        }

        //Return null if no village is found
        if (villagePoolList.isEmpty()) {
            return null;
        }

        //Select a random village
        Random random = new Random();
        return villagePoolList.get(random.nextInt(villagePoolList.size()));
    }

    private void spawnVillageStructure(ServerWorld world, BlockPos blockPos, ResourceLocation villageJigsawLocation) {
        DynamicRegistries dynamicRegistryManager = world.func_241828_r();
        Registry<JigsawPattern> templatePoolRegistry = dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY);

        //Retrieve the start pool for the village
        JigsawPattern startPool = templatePoolRegistry.getOrDefault(villageJigsawLocation);

        if (startPool != null) {
            System.out.println("Successfully loaded village jigsaw pool: " + villageJigsawLocation);

            //Configuration for jigsaw generation (maximum depth is set to 10)
            VillageConfig villageConfig = new VillageConfig(() -> startPool, 10);

            List<StructurePiece> structurePieces = new ArrayList<>();

            //Use JigsawManager to assemble the structure
            JigsawManager.func_242837_a(
                    dynamicRegistryManager,
                    villageConfig,
                    AbstractVillagePiece::new,
                    world.getChunkProvider().getChunkGenerator(),
                    world.getStructureTemplateManager(),
                    blockPos,
                    structurePieces,
                    world.getRandom(),
                    true, //Use heightmap for placement
                    true //Adjust for height
            );

            //Place the structure pieces in the world
            for (StructurePiece piece : structurePieces) {
                piece.func_230383_a_(world, world.getStructureManager(), world.getChunkProvider().getChunkGenerator(), world.getRandom(), piece.getBoundingBox(), world.getChunk(blockPos).getPos(), blockPos);
            }
        }
    }

    private boolean spawnTemplateStructure(ServerWorld world, BlockPos blockPos, ResourceLocation structureLocation) {
        //Get the template manager responsible for managing structure templates
        TemplateManager templateManager = world.getStructureTemplateManager();

        //Load the structure template from the resourceLocation
        Template template = templateManager.getTemplate(structureLocation);

        if (template != null) {
            //Define placement settings for the structure
            PlacementSettings placementSettings = new PlacementSettings()
                    .setIgnoreEntities(false)
                    .setRotation(Rotation.randomRotation(new Random()))
                    .setMirror(Mirror.values()[new Random().nextInt(Mirror.values().length)]);

            //Adjust the spawn position to the terrain height
            int groundY = world.getHeight(Heightmap.Type.WORLD_SURFACE, blockPos.getX(), blockPos.getZ());
            BlockPos spawnPos = new BlockPos(blockPos.getX(), groundY, blockPos.getZ());

            //Place the structure in the world
            template.func_237146_a_(world, spawnPos, spawnPos, placementSettings, world.getRandom(), 3);

            return true; //Return true if the template structure was successfully placed
        } else {
            return false; //Return false if the template structure could not be loaded
        }
    }

    //Method to dynamically spawn a jigsaw based structure
    private boolean spawnJigsawStructure(ServerWorld world, BlockPos blockPos, ResourceLocation jigsawPoolLocation) {
        //Access the dynamic registry manager to retrieve jigsaw pools
        DynamicRegistries dynamicRegistryManager = world.func_241828_r();
        Registry<JigsawPattern> templatePoolRegistry = dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY);

        //Retrieve the start pool for the structure
        JigsawPattern startPool = templatePoolRegistry.getOrDefault(jigsawPoolLocation);

        if (startPool != null) {

            //Configuration for jigsaw generation (maximum depth is set to 10)
            VillageConfig villageConfig = new VillageConfig(() -> startPool, 10);

            List<StructurePiece> structurePieces = new ArrayList<>();

            //Use JigsawManager to assemble the structure
            JigsawManager.func_242837_a(
                    dynamicRegistryManager,
                    villageConfig,
                    AbstractVillagePiece::new,
                    world.getChunkProvider().getChunkGenerator(),
                    world.getStructureTemplateManager(),
                    blockPos,
                    structurePieces,
                    world.getRandom(),
                    false, // Use heightmap for placement
                    false // Adjust for height
            );

            //Ensure the structure pieces are placed at ground level
            for (StructurePiece piece : structurePieces) {
                //Adjust the block position to the terrain height (ground level)
                BlockPos groundPos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());

                //Check if height is valid
                if (groundPos.getY() > 0) {
                    piece.func_230383_a_(world, world.getStructureManager(), world.getChunkProvider().getChunkGenerator(), world.getRandom(), piece.getBoundingBox(), world.getChunk(groundPos).getPos(), groundPos);
                }
            }
            return true; //Return true if the structure was successfully placed
        } else {
            return false; //Return false if the jigsaw pool could not be loaded
        }
    }

    private ResourceLocation getRandomJigsawStructure(ServerWorld world) {
        DynamicRegistries dynamicRegistryManager = world.func_241828_r();
        Registry<JigsawPattern> jigsawPoolRegistry = dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY);

        //Get all registered jigsaw pools
        List<ResourceLocation> jigsawPoolList = new ArrayList<>(jigsawPoolRegistry.keySet());
        Random random = new Random();

        //Filters out the crashing jigsaw pools
        jigsawPoolList.removeIf(pool -> pool.toString().equals("minecraft:empty") || pool.getPath().contains("village/"));

        //Select a random jigsaw pool (ignoring crashing pools)
        return jigsawPoolList.get(random.nextInt(jigsawPoolList.size()));
    }

    private ResourceLocation getRandomTemplateStructure() {
        List<ResourceLocation> templateList = new ArrayList<>(ForgeRegistries.STRUCTURE_FEATURES.getKeys());
        Random random = new Random();

        return templateList.get(random.nextInt(templateList.size()));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(   "\u00A7b" + "Spawns any structure in the game" + "\u00A7b"));
    }
}