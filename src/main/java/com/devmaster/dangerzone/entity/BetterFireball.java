
package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


public class BetterFireball extends ProjectileItemEntity {
	public int explosionPower = 2;

	public BetterFireball(EntityType<? extends ProjectileItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public static BetterFireball create(World worldIn, LivingEntity thrower) {
		return new BetterFireball(worldIn, thrower);
	}

	public static BetterFireball create(World worldIn, EntityType<? extends BetterFireball> thrower) {
		return new BetterFireball(thrower, worldIn);
	}

	@Override
	protected Item getDefaultItem() {
		return Items.FIRE_CHARGE.getItem();
	}

	protected BetterFireball(World worldIn, LivingEntity thrower) {
		this(RegistryHandler.BETTER_FIREBALL.get(), worldIn);
		super.setShooter(thrower);
		this.setPosition(thrower.getPosX(), thrower.getPosYEye() - 0.1D, thrower.getPosZ());
		setDirectionAndMovement(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, 0.78F, 0.85F);
		markVelocityChanged();
	}

	/**
	 * Called when this hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.getShooter());
			this.world.createExplosion((Entity)null, this.getPosX(), this.getPosY(), this.getPosZ(), (float)this.explosionPower, flag, flag ? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
			this.remove();
		}

	}
	@Override
	public void setVelocity(double xMotion, double yMotion, double zMotion) {
		// Update the entity's position based on its motion
		this.prevPosX += xMotion;
		this.prevPosY += yMotion;
		this.prevPosZ += zMotion;

		// Update the entity's bounding box
		this.setPosition(this.prevPosX, this.prevPosY, this.prevPosZ);

		// Update the entity's velocity
		this.setMotion(xMotion, yMotion, zMotion);
	}

	/**
	 * Called when the Better Fireball hits an entity
	 */
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		if (!this.world.isRemote) {
			Entity entity = result.getEntity();
			Entity entity1 = this.getShooter();
			entity.attackEntityFrom(DamageSource.ON_FIRE.setFireDamage(), 6.0F);
			if (entity1 instanceof LivingEntity) {
				this.applyEnchantments((LivingEntity)entity1, entity);
			}

		}
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("ExplosionPower", this.explosionPower);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("ExplosionPower", 99)) {
			this.explosionPower = compound.getInt("ExplosionPower");
		}

	}
}
