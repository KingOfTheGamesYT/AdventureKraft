package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class WaterProjectile extends BaseProjectile {

    public WaterProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    protected WaterProjectile(World worldIn, LivingEntity thrower) {
        this(RegistryHandler.WATER_PROJECTILE.get(), worldIn);
        this.lifespan = 80;
        super.setShooter(thrower);
        this.setPosition(thrower.getPosX(), thrower.getPosYEye() - 0.1D, thrower.getPosZ());
        setDirectionAndMovement(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, 0.78F, 0.85F);
        markVelocityChanged();
    }

    public static WaterProjectile create(World worldIn, LivingEntity thrower) {
        return new WaterProjectile(worldIn, thrower);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected List<EffectInstance> getPotionEffects(final LivingEntity entity) {
        return ImmutableList.of(new EffectInstance(Effects.INSTANT_DAMAGE, 0, 1));
    }

    protected IParticleData getImpactParticle(final LivingEntity entity) { return ParticleTypes.SPLASH; }

    protected IParticleData getTrailParticle() { return ParticleTypes.DRIPPING_WATER; }

    protected float getImpactDamage(final LivingEntity entity) { return 2F; }
}