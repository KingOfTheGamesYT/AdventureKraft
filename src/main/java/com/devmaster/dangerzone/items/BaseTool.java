package com.devmaster.dangerzone.items;

import com.devmaster.dangerzone.misc.DangerZone;
import com.devmaster.dangerzone.util.ToolTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolType;

import java.util.*;

public class BaseTool extends ToolItem {
    protected static final UUID MOVESPEED = UUID.fromString("35f5b798-7778-4017-98f9-ff557dc28f03");
    protected static final UUID REACH = UUID.fromString("168fad76-3979-4638-91c9-a366c0933551");
    private static final String HAS_ENCHANTS_TAG = "hasEnchants";
    protected Map<Enchantment, Integer> defaultEnchantments = new HashMap<>();
    private final Set<ToolType> toolTypes;
    private final int hitCost;
    private final List<String> info = new ArrayList<>();
    private float reach = 0;
    private float movespeed = 0;
    private float lifeSteal = 0;
    protected Multimap<Attribute, AttributeModifier> modifiers;
    public static final ToolType SWORD = ToolType.get("sword");

    public BaseTool(ToolTier tier, Set<ToolType> toolTypes, int hitCost) {
        super(0.0F, 0.0F, tier, Collections.emptySet(), new Properties().group(toolTypes.contains(SWORD) ? DangerZone.WEAPONS : DangerZone.TOOLS)
        );

        this.toolTypes = toolTypes;
        this.hitCost = hitCost;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "gear_damage", tier.getAttackDamage(), AttributeModifier.Operation.ADDITION)
        );

        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "gear_speed", tier.getAttackSpeed(), AttributeModifier.Operation.ADDITION)
        );
        this.modifiers = builder.build();
    }

    @Override
    public Set<ToolType> getToolTypes(ItemStack stack) {
        return toolTypes;
    }

    public BaseTool addDefaultEnchantment(Enchantment enchantment, int level)
    {
        this.defaultEnchantments.put(enchantment, level);
        return this;
    }

    private void applyDefaultEnchantments(ItemStack stack)
    {
        if (stack.hasTag() && stack.getTag().getBoolean(HAS_ENCHANTS_TAG))
            return;

        for (Map.Entry<Enchantment, Integer> entry : defaultEnchantments.entrySet())
        {
            stack.addEnchantment(entry.getKey(), entry.getValue());
        }

        stack.getOrCreateTag().putBoolean(HAS_ENCHANTS_TAG, true);
    }

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player)
    {
        super.onCreated(stack, world, player);
        applyDefaultEnchantments(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof LivingEntity)
        {
            applyDefaultEnchantments(stack);
        }
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();

        if (toolTypes.contains(ToolType.PICKAXE) &&
                (material == Material.ROCK ||
                material == Material.IRON ||
                material == Material.ANVIL))
        {
            return this.efficiency;
        }

        if (toolTypes.contains(ToolType.AXE) &&
                (material == Material.WOOD ||
                material == Material.NETHER_WOOD ||
                material == Material.PLANTS ||
                material == Material.TALL_PLANTS ||
                material == Material.BAMBOO))
        {
            return this.efficiency;
        }

        if (toolTypes.contains(ToolType.SHOVEL) &&
                (material == Material.EARTH ||
                material == Material.SAND ||
                material == Material.SNOW))
        {
            return this.efficiency;
        }

        if (toolTypes.contains(ToolType.HOE) &&
                (state.getHarvestTool() == ToolType.HOE ||
                material == Material.PLANTS ||
                material == Material.TALL_PLANTS ||
                material == Material.LEAVES ||
                material == Material.ORGANIC))
        {
            return this.efficiency;
        }

        if (toolTypes.contains(SWORD) &&
                (material == Material.PLANTS ||
                 material == Material.TALL_PLANTS ||
                 material == Material.LEAVES ||
                 state.getBlock() == Blocks.COBWEB ||
                 state.getBlock() == Blocks.BAMBOO ||
                 state.getBlock() == Blocks.LADDER ||
                 state.getBlock() == Blocks.VINE))
        {
            return this.efficiency;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean canHarvestBlock(BlockState state)
    {
        ToolType tool = state.getHarvestTool();

        if (tool == null) return false;

        if (toolTypes.contains(tool))
        {
            return this.getTier().getHarvestLevel() >= state.getHarvestLevel();
        }
        return false;
    }

    //Right Click Actions
    @Override
    public ActionResultType onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);

        if (player == null || player.isCreative())
            return ActionResultType.PASS;

        ItemStack stack = context.getItem();

        if (toolTypes.contains(ToolType.AXE))
        {
            BlockState stripped = state.getToolModifiedState(world, pos, player, stack, ToolType.AXE);
            if (stripped != null)
            {
                world.setBlockState(pos, stripped, 11);
                stack.damageItem(hitCost, player, p -> p.sendBreakAnimation(context.getHand()));
                return ActionResultType.SUCCESS;
            }
        }

        if (toolTypes.contains(ToolType.SHOVEL))
        {
            BlockState path = state.getToolModifiedState(world, pos, player, stack, ToolType.SHOVEL);
            if (path != null)
            {
                world.setBlockState(pos, path, 11);
                stack.damageItem(hitCost, player, p -> p.sendBreakAnimation(context.getHand()));
                return ActionResultType.SUCCESS;
            }
        }

        if (toolTypes.contains(ToolType.HOE))
        {
            BlockState tilled = state.getToolModifiedState(world, pos, player, stack, ToolType.HOE);
            if (tilled != null)
            {
                world.setBlockState(pos, tilled, 11);
                stack.damageItem(hitCost, player, p -> p.sendBreakAnimation(context.getHand()));
                return ActionResultType.SUCCESS;
            }
        }
        return super.onItemUse(context);
    }

    //Lifesteal
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if (attacker instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) attacker;

            stack.damageItem(hitCost, player, p -> p.sendBreakAnimation(EquipmentSlotType.MAINHAND));

            if (!player.world.isRemote && lifeSteal > 0.0F)
            {
                player.heal(lifeSteal);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    //Creative Breaking Restriction
    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player)
    {
        if (toolTypes.contains(SWORD))
        {
            return !player.isCreative();
        }
        return super.canPlayerBreakBlockWhileHolding(state, world, pos, player);
    }

    //Attributes
    public BaseTool reach(float value)
    {
        this.reach = value;
        rebuild();
        return this;
    }

    public BaseTool movespeed(float value)
    {
        this.movespeed = value;
        rebuild();
        return this;
    }

    public BaseTool lifeSteal(float value)
    {
        this.lifeSteal = value;
        return this;
    }

    public BaseTool rebuild()
    {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(this.modifiers);

        if (movespeed != 0)
        {
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVESPEED, "tool_movespeed", movespeed, AttributeModifier.Operation.MULTIPLY_TOTAL)
            );
        }

        if (reach != 0)
        {
            builder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(REACH, "tool_reach", reach, AttributeModifier.Operation.ADDITION)
            );
        }

        this.modifiers = builder.build();
        return this;
    }

    //Tooltip
    public BaseTool addInfo(String... lines)
    {
        if (lines != null)
        {
            Collections.addAll(this.info, lines);
        }
        return this;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        for (String s : info)
        {
            tooltip.add(new StringTextComponent(s));
        }
    }

    //Attribute access
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot)
    {
        return slot == EquipmentSlotType.MAINHAND ? modifiers : super.getAttributeModifiers(slot);
    }
}