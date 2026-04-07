package com.devmaster.dangerzone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.RegistryObject;

import java.util.*;

public class ABlock extends Block implements IGrowable {

    protected int xpdropped;
    protected boolean isGrowable;
    protected boolean canSustainPlants;
    protected boolean randomizeSpawn = false;
    protected float damageAmount = 0f;
    private boolean silkTouchOnlyDrop = false;
    protected DamageSource damageSource;
    protected Set<Class<? extends Entity>> damageTargets = new HashSet<>();
    Map<RegistryObject<? extends EntityType<?>>, Integer> spawnEntities = new HashMap<>();
    private String[] info = new String[0];

    public ABlock(Properties properties, int xpdropped, boolean isGrowable, boolean canSustainPlants, DamageSource damageSource) {
        super(properties);
        this.xpdropped = xpdropped;
        this.isGrowable = isGrowable;
        this.canSustainPlants = canSustainPlants;
        this.damageSource = damageSource;
    }

    public ABlock silkTouchOnlyDrop(boolean value) {
        this.silkTouchOnlyDrop = value;
        return this;
    }

    public ABlock setEntityDamage(float amount) {
        this.damageAmount = amount;
        return this;
    }

    public ABlock addDamageTarget(Class<? extends Entity> entity) {
        this.damageTargets.add(entity);
        return this;
    }

    public ABlock addSpawnEntity(RegistryObject<? extends EntityType<?>> entity, int count) {
        this.spawnEntities.put(entity, count);
        return this;
    }

    public ABlock setRandomSpawn(boolean value) {
        this.randomizeSpawn = value;
        return this;
    }

    private boolean shouldDamage(Entity entity) {
        if (damageTargets.isEmpty()) return true;

        for (Class<? extends Entity> mob : damageTargets) {
            if (mob.isInstance(entity)) {
                return true;
            }
        }
        return false;
    }

    public ABlock addInfo(String... newInfo) {
        if (newInfo != null && newInfo.length > 0) {
            String[] combined = new String[this.info.length + newInfo.length];
            System.arraycopy(this.info, 0, combined, 0, this.info.length);
            System.arraycopy(newInfo, 0, combined, this.info.length, newInfo.length);
            this.info = combined;
        }
        return this;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        if (xpdropped == 0) {
            return 0;
        }
        int min = (int) (xpdropped * 0.667);
        int max = (int) (xpdropped * 1.5);
        return silktouch == 0 ? new Random().nextInt(max - min) + min : 0;
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        if (damageAmount > 0 && damageSource != null && shouldDamage(entity)) {
            entity.attackEntityFrom(damageSource, damageAmount);
        }
        super.onEntityWalk(world, pos, entity);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (damageAmount > 0 && damageSource != null && shouldDamage(entity)) {
            entity.attackEntityFrom(damageSource, damageAmount);
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

        List<ItemStack> original = super.getDrops(state, builder);

        //If the loot table already has defined drops → respect it
        if (!original.isEmpty()) {
            return original;
        }

        ItemStack tool = builder.get(LootParameters.TOOL);

        boolean silk = tool != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;

        //If the block requires Silk Touch then drop itself
        if (silkTouchOnlyDrop) {

            if (silk) {
                return Collections.singletonList(new ItemStack(this));
            } else {
                return Collections.emptyList();
            }
        }

        //Drop the block
        return Collections.singletonList(new ItemStack(this));
    }

    @Override
    public void spawnAdditionalDrops(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, world, pos, stack);

        //Silk touch prevents mob spawns
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
            return;
        }

        Random rand = world.rand;

        if (spawnEntities == null || spawnEntities.isEmpty()) {
            return;
        }

        if (randomizeSpawn) {

            List<RegistryObject<? extends EntityType<?>>> expanded = new ArrayList<>();

            for (Map.Entry<RegistryObject<? extends EntityType<?>>, Integer> entry : spawnEntities.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    expanded.add(entry.getKey());
                }
            }

            if (!expanded.isEmpty()) {

                RegistryObject<? extends EntityType<?>> chosen = expanded.get(rand.nextInt(expanded.size()));
                EntityType<?> type = chosen.get();
                Entity entity = type.create(world);

                if (entity != null) {
                    entity.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    world.addEntity(entity);
                }
            }

        } else {

            for (Map.Entry<RegistryObject<? extends EntityType<?>>, Integer> entry : spawnEntities.entrySet()) {

                EntityType<?> type = entry.getKey().get();

                for (int i = 0; i < entry.getValue(); i++) {

                    Entity entity = type.create(world);

                    if (entity != null) {

                        double offsetX = (rand.nextDouble() - 0.5D);
                        double offsetZ = (rand.nextDouble() - 0.5D);

                        entity.setPosition(pos.getX() + 0.5 + offsetX, pos.getY(), pos.getZ() + 0.5 + offsetZ
                        );

                        world.addEntity(entity);
                    }
                }
            }
        }
    }

    @Override
    public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient) {
        return isGrowable;
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
        return isGrowable;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return canSustainPlants;
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        for (String s : info) {
            tooltip.add(new StringTextComponent(s));
        }
    }
}