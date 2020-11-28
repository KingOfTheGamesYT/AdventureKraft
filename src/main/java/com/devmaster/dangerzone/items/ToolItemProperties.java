package com.devmaster.dangerzone.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ToolItemProperties extends Item.Properties {
    private int width;
    private IItemTier tier;
    private int attackDamage;
    private float attackSpeed;

    public ToolItemProperties() {
        super();
    }

    public int getWidth() {
        return width;
    }

    public ToolItemProperties width(int width) {
        this.width = width;
        return this;
    }

    public IItemTier getTier() {
        return tier;
    }

    public ToolItemProperties tier(IItemTier tier) {
        this.tier = tier;
        return this;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public ToolItemProperties attackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
        return this;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public ToolItemProperties attackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
        return this;
    }

    public ToolItemProperties setGroup (ItemGroup group) {
        super.group(group);
        return this;
    }
}
