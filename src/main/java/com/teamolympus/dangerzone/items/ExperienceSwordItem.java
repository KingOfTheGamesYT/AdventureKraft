package com.teamolympus.dangerzone.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import com.teamolympus.dangerzone.items.base.tools.BaseAKSword;

public class ExperienceSwordItem extends BaseAKSword {

    public ExperienceSwordItem(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        int XP = 10;

        XP = player.experienceLevel / 2;

        if (XP > 0) {
            player.addExperience(XP);
        }

        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), XP);

        for (int i = 0; i < XP / 2; i++) {
            entity.worldObj.spawnParticle(
                "portal",
                entity.posX,
                entity.posY + entity.worldObj.rand.nextDouble() * 2.0D,
                entity.posZ,
                entity.worldObj.rand.nextGaussian(),
                0.0D,
                entity.worldObj.rand.nextGaussian());
        }

        return false;
    }
}
