package net.minecraft.world.gen;

import java.util.BitSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.EntityClassification;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

public abstract class ChunkGenerator<C extends GenerationSettings> {
   protected final IWorld world;
   protected final long seed;
   protected final BiomeProvider biomeProvider;
   protected final C settings;

   public ChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, C generationSettingsIn) {
      this.world = worldIn;
      this.seed = worldIn.getSeed();
      this.biomeProvider = biomeProviderIn;
      this.settings = generationSettingsIn;
   }

   public void generateBiomes(IChunk chunkIn) {
      ChunkPos chunkpos = chunkIn.getPos();
      ((ChunkPrimer)chunkIn).setBiomes(new BiomeContainer(chunkpos, this.biomeProvider));
   }

   protected Biome getBiome(BiomeManager biomeManagerIn, BlockPos posIn) {
      return biomeManagerIn.getBiome(posIn);
   }

   public void generateCarvers(BiomeManager biomeManagerIn, IChunk chunkIn, GenerationStage.Carving carvingStage) {
      SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
      int i = 8;
      ChunkPos chunkpos = chunkIn.getPos();
      int j = chunkpos.x;
      int k = chunkpos.z;
      Biome biome = this.getBiome(biomeManagerIn, chunkpos.asBlockPos());
      BitSet bitset = chunkIn.getCarvingMask(carvingStage);

      for(int l = j - 8; l <= j + 8; ++l) {
         for(int i1 = k - 8; i1 <= k + 8; ++i1) {
            List<ConfiguredCarver<?>> list = biome.getCarvers(carvingStage);
            ListIterator<ConfiguredCarver<?>> listiterator = list.listIterator();

            while(listiterator.hasNext()) {
               int j1 = listiterator.nextIndex();
               ConfiguredCarver<?> configuredcarver = listiterator.next();
               sharedseedrandom.setLargeFeatureSeed(this.seed + (long)j1, l, i1);
               if (configuredcarver.shouldCarve(sharedseedrandom, l, i1)) {
                  configuredcarver.carveRegion(chunkIn, (p_227059_2_) -> {
                     return this.getBiome(biomeManagerIn, p_227059_2_);
                  }, sharedseedrandom, this.getSeaLevel(), l, i1, j, k, bitset);
               }
            }
         }
      }

   }

   @Nullable
   public BlockPos findNearestStructure(World worldIn, String name, BlockPos pos, int radius, boolean skipExistingChunks) {
      Structure<?> structure = Feature.STRUCTURES.get(name.toLowerCase(Locale.ROOT));
      return structure != null ? structure.findNearest(worldIn, this, pos, radius, skipExistingChunks) : null;
   }

   public void decorate(WorldGenRegion region) {
      int i = region.getMainChunkX();
      int j = region.getMainChunkZ();
      int k = i * 16;
      int l = j * 16;
      BlockPos blockpos = new BlockPos(k, 0, l);
      Biome biome = this.getBiome(region.getBiomeManager(), blockpos.add(8, 8, 8));
      SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
      long i1 = sharedseedrandom.setDecorationSeed(region.getSeed(), k, l);

      for(GenerationStage.Decoration generationstage$decoration : GenerationStage.Decoration.values()) {
         try {
            biome.decorate(generationstage$decoration, this, region, i1, sharedseedrandom, blockpos);
         } catch (Exception exception) {
            CrashReport crashreport = CrashReport.makeCrashReport(exception, "Biome decoration");
            crashreport.makeCategory("Generation").addDetail("CenterX", i).addDetail("CenterZ", j).addDetail("Step", generationstage$decoration).addDetail("Seed", i1).addDetail("Biome", Registry.BIOME.getKey(biome));
            throw new ReportedException(crashreport);
         }
      }

   }

   /**
    * Generate the SURFACE part of a chunk
    */
   public abstract void generateSurface(WorldGenRegion p_225551_1_, IChunk p_225551_2_);

   public void spawnMobs(WorldGenRegion region) {
   }

   public C getSettings() {
      return this.settings;
   }

   public abstract int getGroundHeight();

   public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
   }

   public boolean hasStructure(Biome biomeIn, Structure<? extends IFeatureConfig> structureIn) {
      return biomeIn.hasStructure(structureIn);
   }

   @Nullable
   public <C extends IFeatureConfig> C getStructureConfig(Biome biomeIn, Structure<C> structureIn) {
      return biomeIn.getStructureConfig(structureIn);
   }

   public BiomeProvider getBiomeProvider() {
      return this.biomeProvider;
   }

   public long getSeed() {
      return this.seed;
   }

   public int getMaxHeight() {
      return 256;
   }

   public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
      return this.world.getBiome(pos).getSpawns(creatureType);
   }

   public void generateStructures(BiomeManager p_227058_1_, IChunk p_227058_2_, ChunkGenerator<?> p_227058_3_, TemplateManager p_227058_4_) {
      for(Structure<?> structure : Feature.STRUCTURES.values()) {
         if (p_227058_3_.getBiomeProvider().hasStructure(structure)) {
            StructureStart structurestart = p_227058_2_.getStructureStart(structure.getStructureName());
            int i = structurestart != null ? structurestart.getRefCount() : 0;
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
            ChunkPos chunkpos = p_227058_2_.getPos();
            StructureStart structurestart1 = StructureStart.DUMMY;
            Biome biome = p_227058_1_.getBiome(new BlockPos(chunkpos.getXStart() + 9, 0, chunkpos.getZStart() + 9));
            if (structure.canBeGenerated(p_227058_1_, p_227058_3_, sharedseedrandom, chunkpos.x, chunkpos.z, biome)) {
               StructureStart structurestart2 = structure.getStartFactory().create(structure, chunkpos.x, chunkpos.z, MutableBoundingBox.getNewBoundingBox(), i, p_227058_3_.getSeed());
               structurestart2.init(this, p_227058_4_, chunkpos.x, chunkpos.z, biome);
               structurestart1 = structurestart2.isValid() ? structurestart2 : StructureStart.DUMMY;
            }

            p_227058_2_.putStructureStart(structure.getStructureName(), structurestart1);
         }
      }

   }

   public void generateStructureStarts(IWorld worldIn, IChunk chunkIn) {
      int i = 8;
      int j = chunkIn.getPos().x;
      int k = chunkIn.getPos().z;
      int l = j << 4;
      int i1 = k << 4;

      for(int j1 = j - 8; j1 <= j + 8; ++j1) {
         for(int k1 = k - 8; k1 <= k + 8; ++k1) {
            long l1 = ChunkPos.asLong(j1, k1);

            for(Entry<String, StructureStart> entry : worldIn.getChunk(j1, k1).getStructureStarts().entrySet()) {
               StructureStart structurestart = entry.getValue();
               if (structurestart != StructureStart.DUMMY && structurestart.getBoundingBox().intersectsWith(l, i1, l + 15, i1 + 15)) {
                  chunkIn.addStructureReference(entry.getKey(), l1);
                  DebugPacketSender.sendStructureStart(worldIn, structurestart);
               }
            }
         }
      }

   }

   public abstract void makeBase(IWorld worldIn, IChunk chunkIn);

   public int getSeaLevel() {
      return world.getDimension().getSeaLevel();
   }

   public abstract int getHeight(int x, int z, Heightmap.Type heightmapType);

   public int getNoiseHeight(int x, int z, Heightmap.Type heightmapType) {
      return this.getHeight(x, z, heightmapType);
   }

   public int getNoiseHeightMinusOne(int x, int z, Heightmap.Type heightmapType) {
      return this.getHeight(x, z, heightmapType) - 1;
   }
}