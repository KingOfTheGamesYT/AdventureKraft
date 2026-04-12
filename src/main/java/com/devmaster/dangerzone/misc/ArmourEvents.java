package com.devmaster.dangerzone.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ArmourEvents {
	private EventType type;
	private float eventmodifier;
	private QuadConsumer<PlayerEntity, Entity, DamageSource, ItemStack> action;
	private QuadPredicate<PlayerEntity, Entity, DamageSource, ItemStack> condition;
	public static HashMap<EventType, ArrayList<ArmourEvents>> eventlist = new HashMap<>();

	public ArmourEvents(EventType type, QuadPredicate<PlayerEntity, Entity, DamageSource, ItemStack> condition, QuadConsumer<PlayerEntity, Entity, DamageSource, ItemStack> action) {
		this.type = type;
		this.condition = condition != null ? condition : (player, enemy, source, helditem) -> true; // Default to true if condition is null
		this.action = action;
		this.eventmodifier = 1.0f;
	}

	public static void addEvent(ArmourEvents event) {
		eventlist.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
	}

	public EventType getEventType() {
		return type;
	}

	public float getModifier() {
		return eventmodifier;
	}

	public QuadPredicate<PlayerEntity, Entity, DamageSource, ItemStack> getCondition() {
		return condition;
	}

	public QuadConsumer<PlayerEntity, Entity, DamageSource, ItemStack> getAction() {
		return action;
	}

	private void doEvents(EventType type, Event event, PlayerEntity player, LivingEntity target) {
		if (eventlist.containsKey(type)) {
			ItemStack stack = player.getHeldItemMainhand();
			for (ArmourEvents e : eventlist.get(type)) {
				if (event instanceof LivingHurtEvent) { //Player is hurt
					LivingHurtEvent ev = (LivingHurtEvent) event;
					if (e.getCondition().test(player, target, ev.getSource(), stack)) {
						ev.setAmount(ev.getAmount() * e.getModifier());
						e.getAction().accept(player, target, ev.getSource(), stack);
					}
				} else if (event instanceof LivingDamageEvent) { //Player deals damage
					LivingDamageEvent ev = (LivingDamageEvent) event;
					if (e.getCondition().test(player, target, ev.getSource(), stack)) {
						ev.setAmount(ev.getAmount() * e.getModifier());
						e.getAction().accept(player, target, ev.getSource(), stack);
					}
				} else if (event instanceof LivingFallEvent) { //Player falls
					LivingFallEvent ev = (LivingFallEvent) event;
					if (e.getCondition().test(player, null, null, stack)) {
						ev.setDistance(ev.getDistance() * e.getModifier());
						e.getAction().accept(player, null, null, stack);
					}
				} else if (event instanceof LivingJumpEvent) { //Player jumps
					if (e.getCondition().test(player, null, null, stack)) {
						player.setMotion(player.getMotion().x, player.getMotion().y * e.getModifier(), player.getMotion().z);
						e.getAction().accept(player, null, null, stack);
					}
				} else if (event instanceof LivingUpdateEvent) { //Auto event
					if (e.getCondition().test(player, null, null, stack)) {
						e.getAction().accept(player, null, null, stack);
					}
				}
			}
		}
	}

	public static enum EventType {
		Auto,
		PlayerFell,
		PlayerJumped,
		PlayerHurtByProjectile,
		PlayerHurtByMelee,
		PlayerHurtByMagic,
		PlayerCausedProjectileDamage,
		PlayerCausedMeleeDamage,
		PlayerCausedMagicDamage,
		CritChance;
	}

	@FunctionalInterface
	public interface QuadConsumer<K, V, S, T> {
		void accept(K k, V v, S s, T t);
	}

	@FunctionalInterface
	public interface QuadPredicate<T, U, V, W> {
		boolean test(T t, U u, V v, W w);

		default QuadPredicate<T, U, V, W> and(QuadPredicate<? super T, ? super U, ? super V, ? super W> other) {
			Objects.requireNonNull(other);
			return (T t, U u, V v, W w) -> test(t, u, v, w) && other.test(t, u, v, w);
		}

		default QuadPredicate<T, U, V, W> negate() {
			return (T t, U u, V v, W w) -> !test(t, u, v, w);
		}

		default QuadPredicate<T, U, V, W> or(QuadPredicate<? super T, ? super U, ? super V, ? super W> other) {
			Objects.requireNonNull(other);
			return (T t, U u, V v, W w) -> test(t, u, v, w) || other.test(t, u, v, w);
		}
	}
}