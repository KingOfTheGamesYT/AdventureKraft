package com.devmaster.dangerzone.entity;

import com.devmaster.dangerzone.util.RegistryHandler;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import net.minecraftforge.fml.network.NetworkHooks;

public class BetterFireball extends ThrowableEntity implements IRendersAsItem {
	public int explosionPower = 2;

	public BetterFireball(EntityType<? extends BetterFireball> type, World world) {
		super(type, world);
	}

	public BetterFireball(World worldIn, LivingEntity thrower) {
		super(RegistryHandler.BETTER_FIREBALL.get(), thrower, worldIn);
		this.setPosition(thrower.getPosX(), thrower.getPosYEye() - 0.1D, thrower.getPosZ());
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Items.FIRE_CHARGE);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.getType() == RayTraceResult.Type.ENTITY) {
				this.onEntityHit((EntityRayTraceResult) result);
			}

			boolean griefing = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.getShooter());
			this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), explosionPower, true, griefing ? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
			this.remove();
		}
	}

	@Override
	protected void registerData() {}

	@Override
	public void tick() {
		super.tick();

		//Raytrace collision detection
		RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_);
		if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS) {
			this.onImpact(raytraceresult);
		}

		//Apply movement
		Vector3d motion = this.getMotion();
		this.setPosition(this.getPosX() + motion.x, this.getPosY() + motion.y, this.getPosZ() + motion.z);
		this.setMotion(motion.scale(0.95)); //Apply slight drag
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("ExplosionPower", explosionPower);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("ExplosionPower", 99)) {
			this.explosionPower = compound.getInt("ExplosionPower");
		}
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}