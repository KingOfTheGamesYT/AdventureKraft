package com.teamolympus.dangerzone.items;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.teamolympus.dangerzone.items.base.tools.BaseAKPickaxe;

public class UltimatePickaxeItem extends BaseAKPickaxe {

    public UltimatePickaxeItem(String name, ToolMaterial material) {
        super(name, material);
    }

    // TODO: FINISH LIST
    static final Item[] itemDroppable = new Item[]
     {Items.iron_ingot, Items.gold_ingot, Items.diamond, Items.emerald

    };

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        super.onCreated(stack, world, player);
        stack.addEnchantment(Enchantment.efficiency, 5);
        stack.addEnchantment(Enchantment.fortune, 5);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, int x, int y, int z,
        EntityLivingBase entityLivingBase) {
        if (!worldIn.isRemote) {
            int dropIngotRand = worldIn.rand.nextInt(2);

            if (blockIn == Blocks.iron_ore && dropIngotRand != 0) {
                worldIn.setBlockToAir(x, y, z);
                dropBlockAsItem(worldIn, x, y, z, new ItemStack(Items.iron_ingot));
            }

            if (blockIn == Blocks.gold_ore && dropIngotRand != 0) {
                worldIn.setBlockToAir(x, y, z);
                dropBlockAsItem(worldIn, x, y, z, new ItemStack(Items.gold_ingot));
            }

            if (blockIn == Blocks.stone && worldIn.rand.nextInt(100) == 0)
            {
                int randomDroppable = worldIn.rand.nextInt(itemDroppable.length);
                dropBlockAsItem(worldIn, x, y, z, new ItemStack(itemDroppable[randomDroppable]));
            }

        }

        return super.onBlockDestroyed(stack, worldIn, blockIn, x, y, z, entityLivingBase);
    }

}
