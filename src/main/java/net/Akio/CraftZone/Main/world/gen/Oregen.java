package net.Akio.CraftZone.Main.world.gen;

import cpw.mods.fml.common.IWorldGenerator;
import net.Akio.CraftZone.Main.CraftZone;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class Oregen implements IWorldGenerator {

    WorldGenMinable petrified_cow;
    WorldGenMinable petrified_villager;
    WorldGenMinable petrified_chicken;
    WorldGenMinable petrified_cave_spider;
    WorldGenMinable petrified_creeper;
    WorldGenMinable petrified_squid;
    WorldGenMinable petrified_wolf;
    WorldGenMinable petrified_slime;
    WorldGenMinable petrified_pig;
   WorldGenMinable petrified_Iron_golem;
  //  WorldGenMinable liquidHelium;

    public Oregen() {
        petrified_villager = new WorldGenMinable(CraftZone.Dried_Villager, 0, CraftZone.oreSizeVillager, Blocks.stone);
        petrified_cow = new WorldGenMinable(CraftZone.Dried_cow, 1, CraftZone.oreSizeCow, Blocks.stone);
        petrified_cave_spider = new WorldGenMinable(CraftZone.Dried_cave_spider, 2, CraftZone.oreSizeCaveSpider, Blocks.stone);
        petrified_chicken = new WorldGenMinable(CraftZone.Dried_chicken, 3, CraftZone.oreSizeChicken, Blocks.stone);
        petrified_creeper = new WorldGenMinable(CraftZone.Dried_Creeper, 4, CraftZone.oreSizeCreeper, Blocks.stone);
        petrified_slime = new WorldGenMinable(CraftZone.Dried_Slime, 5, CraftZone.oreSizeSlime, Blocks.stone);
        petrified_squid = new WorldGenMinable(CraftZone.Dried_Squid, 7, CraftZone.oreSizeSquid, Blocks.stone);
        petrified_wolf = new WorldGenMinable(CraftZone.Dried_Wolf, 8, CraftZone.oreSizeWolf, Blocks.stone);
        petrified_pig = new WorldGenMinable(CraftZone.Dried_pig, 9, CraftZone.oreSizePig, Blocks.stone);
        petrified_Iron_golem = new WorldGenMinable(CraftZone.Dried_Iron_Golem, 6, CraftZone.oreSizeIronGolem, Blocks.stone);
      //  liquidHelium = new WorldGenMinable(NCBlocks.blockHelium, 0, 8, Blocks.end_stone); */
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
         if (world.provider.terrainType != WorldType.FLAT) generateSurface(random, chunkX * 16, chunkZ * 16, world);
    }

    void generateSurface(Random random, int xChunk, int zChunk, World world) {
        int xPos, yPos, zPos;
        if (CraftZone.oreGenCow)
        { for (int i = 0; i < CraftZone.oreRarityCow; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightCow); zPos = zChunk + random.nextInt(16);
            petrified_cow.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenVillager)
        { for (int i = 0; i < CraftZone.oreRarityVillager; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightVillager); zPos = zChunk + random.nextInt(16);
            petrified_villager.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenCaveSpider)
        { for (int i = 0; i < CraftZone.oreRarityCaveSpider; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightCaveSpider); zPos = zChunk + random.nextInt(16);
            petrified_cave_spider.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenChicken)
        { for (int i = 0; i < CraftZone.oreRarityChicken; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightChicken); zPos = zChunk + random.nextInt(16);
            petrified_chicken.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenPig)
        { for (int i = 0; i < CraftZone.oreRarityPig; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightPig); zPos = zChunk + random.nextInt(16);
            petrified_pig.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenCreeper)
        { for (int i = 0; i < CraftZone.oreRarityCreeper; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightCreeper); zPos = zChunk + random.nextInt(16);
            petrified_creeper.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenIronGolem)
        { for (int i = 0; i < CraftZone.oreRarityIronGolem; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightIronGolem); zPos = zChunk + random.nextInt(16);
            petrified_Iron_golem.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenSlime)
        { for (int i = 0; i < CraftZone.oreRaritySlime; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightSlime); zPos = zChunk + random.nextInt(16);
            petrified_slime.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenSquid)
        { for (int i = 0; i < CraftZone.oreRaritySquid; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightSquid); zPos = zChunk + random.nextInt(16);
            petrified_squid.generate(world, random, xPos, yPos, zPos); } }

        if (CraftZone.oreGenWolf)
        { for (int i = 0; i < CraftZone.oreRarityWolf; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(CraftZone.oreMaxHeightWolf); zPos = zChunk + random.nextInt(16);
            petrified_wolf.generate(world, random, xPos, yPos, zPos); } }


    }


    /*
      Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class

      @param The Block to spawn
      @param The World to spawn in
      @param A Random object for retrieving random positions within the world to spawn the Block
      @param An int for passing the X-Coordinate for the Generation method
      @param An int for passing the Z-Coordinate for the Generation method
      @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
      @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
      @param An int for setting the maximum size of a vein
      @param An int for the Number of chances available for the Block to spawn per-chunk
      @param An int for the minimum Y-Coordinate height at which this block may spawn
      @param An int for the maximum Y-Coordinate height at which this block may spawn
     */

    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
        assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
        assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

        int diffBtwnMinMaxY = maxY - minY;
        for (int x = 0; x < chancesToSpawn; x++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }
}