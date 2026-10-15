package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModMobEffects;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: WitheredheartchanceProcedure.class */
public class WitheredheartchanceProcedure {
    public static void onEntityAttacked(ShimEvent.LivingDamageShim event) {
        if (event.getEntity() != null) {
            execute(event, event.getEntity());
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable NeoEvent event, Entity entity) {
        if (entity == null || !(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity _livEnt0 = (LivingEntity) entity;
        if (_livEnt0.hasEffect(BuiltInRegistries.MOB_EFFECT.wrapAsHolder((MobEffect) ButcheryModMobEffects.WITHEREDHEARTEFFECT.get())) && Math.random() < 0.05d) {
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity) entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 2400, 2, false, false));
                }
            }
            if (entity instanceof LivingEntity) {
                LivingEntity _entity2 = (LivingEntity) entity;
                if (!_entity2.level().isClientSide()) {
                    _entity2.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 2400, 99, false, false));
                }
            }
        }
    }
}
