package net.minecraft.village;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.block.BlockState;
import net.minecraft.util.SectionDistanceGraph;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.storage.RegionSectionCache;

public class PointOfInterestManager extends RegionSectionCache<PointOfInterestData> {
   private final PointOfInterestManager.DistanceGraph distanceTracker;
   private final LongSet loadedChunks = new LongOpenHashSet();

   public PointOfInterestManager(File p_i50298_1_, DataFixer data) {
      super(p_i50298_1_, PointOfInterestData::new, PointOfInterestData::new, data, DefaultTypeReferences.POI_CHUNK);
      this.distanceTracker = new PointOfInterestManager.DistanceGraph();
   }

   public void add(BlockPos pos, PointOfInterestType poiType) {
      this.func_219110_e(SectionPos.from(pos).asLong()).add(pos, poiType);
   }

   public void remove(BlockPos pos) {
      this.func_219110_e(SectionPos.from(pos).asLong()).remove(pos);
   }

   public long getCountInRange(Predicate<PointOfInterestType> p_219145_1_, BlockPos p_219145_2_, int p_219145_3_, PointOfInterestManager.Status status) {
      return this.func_219146_b(p_219145_1_, p_219145_2_, p_219145_3_, status).count();
   }

   public Stream<PointOfInterest> getInSquare(Predicate<PointOfInterestType> p_226353_1_, BlockPos p_226353_2_, int p_226353_3_, PointOfInterestManager.Status status) {
      return ChunkPos.getAllInBox(new ChunkPos(p_226353_2_), Math.floorDiv(p_226353_3_, 16)).flatMap((p_226350_3_) -> {
         return this.getInChunk(p_226353_1_, p_226350_3_, status);
      });
   }

   public Stream<PointOfInterest> func_219146_b(Predicate<PointOfInterestType> p_219146_1_, BlockPos pos, int distance, PointOfInterestManager.Status status) {
      int i = distance * distance;
      return this.getInSquare(p_219146_1_, pos, distance, status).filter((p_226349_2_) -> {
         return p_226349_2_.getPos().distanceSq(pos) <= (double)i;
      });
   }

   public Stream<PointOfInterest> getInChunk(Predicate<PointOfInterestType> p_219137_1_, ChunkPos posChunk, PointOfInterestManager.Status status) {
      return IntStream.range(0, 16).boxed().flatMap((p_219149_4_) -> {
         return this.getInSelection(p_219137_1_, SectionPos.from(posChunk, p_219149_4_).asLong(), status);
      });
   }

   private Stream<PointOfInterest> getInSelection(Predicate<PointOfInterestType> p_219136_1_, long p_219136_2_, PointOfInterestManager.Status status) {
      return this.func_219113_d(p_219136_2_).map((p_219159_2_) -> {
         return p_219159_2_.getRecords(p_219136_1_, status);
      }).orElseGet(Stream::empty);
   }

   public Stream<BlockPos> findAll(Predicate<PointOfInterestType> p_225399_1_, Predicate<BlockPos> p_225399_2_, BlockPos p_225399_3_, int p_225399_4_, PointOfInterestManager.Status status) {
      return this.func_219146_b(p_225399_1_, p_225399_3_, p_225399_4_, status).map(PointOfInterest::getPos).filter(p_225399_2_);
   }

   public Optional<BlockPos> find(Predicate<PointOfInterestType> p_219127_1_, Predicate<BlockPos> p_219127_2_, BlockPos p_219127_3_, int p_219127_4_, PointOfInterestManager.Status status) {
      return this.findAll(p_219127_1_, p_219127_2_, p_219127_3_, p_219127_4_, status).findFirst();
   }

   public Optional<BlockPos> findClosest(Predicate<PointOfInterestType> p_219147_1_, Predicate<BlockPos> p_219147_2_, BlockPos pos, int p_219147_4_, PointOfInterestManager.Status status) {
      return this.func_219146_b(p_219147_1_, pos, p_219147_4_, status).map(PointOfInterest::getPos).sorted(Comparator.comparingDouble((p_219160_1_) -> {
         return p_219160_1_.distanceSq(pos);
      })).filter(p_219147_2_).findFirst();
   }

   public Optional<BlockPos> take(Predicate<PointOfInterestType> p_219157_1_, Predicate<BlockPos> p_219157_2_, BlockPos pos, int p_219157_4_) {
      return this.func_219146_b(p_219157_1_, pos, p_219157_4_, PointOfInterestManager.Status.HAS_SPACE).filter((p_219129_1_) -> {
         return p_219157_2_.test(p_219129_1_.getPos());
      }).findFirst().map((p_219152_0_) -> {
         p_219152_0_.claim();
         return p_219152_0_.getPos();
      });
   }

   public Optional<BlockPos> getRandom(Predicate<PointOfInterestType> p_219163_1_, Predicate<BlockPos> p_219163_2_, PointOfInterestManager.Status p_219163_3_, BlockPos pos, int p_219163_5_, Random p_219163_6_) {
      List<PointOfInterest> list = this.func_219146_b(p_219163_1_, pos, p_219163_5_, p_219163_3_).collect(Collectors.toList());
      Collections.shuffle(list, p_219163_6_);
      return list.stream().filter((p_219131_1_) -> {
         return p_219163_2_.test(p_219131_1_.getPos());
      }).findFirst().map(PointOfInterest::getPos);
   }

   public boolean release(BlockPos pos) {
      return this.func_219110_e(SectionPos.from(pos).asLong()).release(pos);
   }

   public boolean exists(BlockPos pos, Predicate<PointOfInterestType> p_219138_2_) {
      return this.func_219113_d(SectionPos.from(pos).asLong()).map((p_219133_2_) -> {
         return p_219133_2_.exists(pos, p_219138_2_);
      }).orElse(false);
   }

   public Optional<PointOfInterestType> getType(BlockPos pos) {
      PointOfInterestData pointofinterestdata = this.func_219110_e(SectionPos.from(pos).asLong());
      return pointofinterestdata.getType(pos);
   }

   public int sectionsToVillage(SectionPos p_219150_1_) {
      this.distanceTracker.runAllUpdates();
      return this.distanceTracker.getLevel(p_219150_1_.asLong());
   }

   private boolean isVillageCenter(long p_219154_1_) {
      Optional<PointOfInterestData> optional = this.func_219106_c(p_219154_1_);
      return optional == null ? false : optional.map((p_223144_0_) -> {
         return p_223144_0_.getRecords(PointOfInterestType.MATCH_ANY, PointOfInterestManager.Status.IS_OCCUPIED).count() > 0L;
      }).orElse(false);
   }

   public void tick(BooleanSupplier p_219115_1_) {
      super.tick(p_219115_1_);
      this.distanceTracker.runAllUpdates();
   }

   protected void markDirty(long sectionPosIn) {
      super.markDirty(sectionPosIn);
      this.distanceTracker.updateSourceLevel(sectionPosIn, this.distanceTracker.getSourceLevel(sectionPosIn), false);
   }

   protected void onSectionLoad(long p_219111_1_) {
      this.distanceTracker.updateSourceLevel(p_219111_1_, this.distanceTracker.getSourceLevel(p_219111_1_), false);
   }

   public void checkConsistencyWithBlocks(ChunkPos pos, ChunkSection section) {
      SectionPos sectionpos = SectionPos.from(pos, section.getYLocation() >> 4);
      Util.acceptOrElse(this.func_219113_d(sectionpos.asLong()), (p_219130_3_) -> {
         p_219130_3_.refresh((p_219141_3_) -> {
            if (hasAnyPOI(section)) {
               this.updateFromSelection(section, sectionpos, p_219141_3_);
            }

         });
      }, () -> {
         if (hasAnyPOI(section)) {
            PointOfInterestData pointofinterestdata = this.func_219110_e(sectionpos.asLong());
            this.updateFromSelection(section, sectionpos, pointofinterestdata::add);
         }

      });
   }

   private static boolean hasAnyPOI(ChunkSection p_219151_0_) {
      return PointOfInterestType.getAllStates().anyMatch(p_219151_0_::contains);
   }

   private void updateFromSelection(ChunkSection p_219132_1_, SectionPos p_219132_2_, BiConsumer<BlockPos, PointOfInterestType> p_219132_3_) {
      p_219132_2_.allBlocksWithin().forEach((p_219143_2_) -> {
         BlockState blockstate = p_219132_1_.getBlockState(SectionPos.mask(p_219143_2_.getX()), SectionPos.mask(p_219143_2_.getY()), SectionPos.mask(p_219143_2_.getZ()));
         PointOfInterestType.forState(blockstate).ifPresent((p_219161_2_) -> {
            p_219132_3_.accept(p_219143_2_, p_219161_2_);
         });
      });
   }

   public void ensureLoadedAndValid(IWorldReader worldReader, BlockPos pos, int p_226347_3_) {
      SectionPos.func_229421_b_(new ChunkPos(pos), Math.floorDiv(p_226347_3_, 16)).map((p_226354_1_) -> {
         return Pair.of(p_226354_1_, this.func_219113_d(p_226354_1_.asLong()));
      }).filter((p_226352_0_) -> {
         return !p_226352_0_.getSecond().map(PointOfInterestData::isValid).orElse(false);
      }).map((p_226348_0_) -> {
         return p_226348_0_.getFirst().asChunkPos();
      }).filter((p_226351_1_) -> {
         return this.loadedChunks.add(p_226351_1_.asLong());
      }).forEach((p_226346_1_) -> {
         worldReader.getChunk(p_226346_1_.x, p_226346_1_.z, ChunkStatus.EMPTY);
      });
   }

   final class DistanceGraph extends SectionDistanceGraph {
      private final Long2ByteMap levels = new Long2ByteOpenHashMap();

      protected DistanceGraph() {
         super(7, 16, 256);
         this.levels.defaultReturnValue((byte)7);
      }

      protected int getSourceLevel(long pos) {
         return PointOfInterestManager.this.isVillageCenter(pos) ? 0 : 7;
      }

      protected int getLevel(long sectionPosIn) {
         return this.levels.get(sectionPosIn);
      }

      protected void setLevel(long sectionPosIn, int level) {
         if (level > 6) {
            this.levels.remove(sectionPosIn);
         } else {
            this.levels.put(sectionPosIn, (byte)level);
         }

      }

      public void runAllUpdates() {
         super.processUpdates(Integer.MAX_VALUE);
      }
   }

   public static enum Status {
      HAS_SPACE(PointOfInterest::hasSpace),
      IS_OCCUPIED(PointOfInterest::isOccupied),
      ANY((p_221036_0_) -> {
         return true;
      });

      private final Predicate<? super PointOfInterest> test;

      private Status(Predicate<? super PointOfInterest> testIn) {
         this.test = testIn;
      }

      public Predicate<? super PointOfInterest> getTest() {
         return this.test;
      }
   }
}
