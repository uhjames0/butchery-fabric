package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModMobEffects;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

/* JADX INFO: loaded from: WitheredheardfinishedusingProcedure.class */
public class WitheredheardfinishedusingProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null && !ButcheryPersistentData.of(entity).getBooleanOr("hasBlessing", false)) {
            ButcheryPersistentData.of(entity).putBoolean("hasBlessing", true);
            if (entity instanceof LivingEntity) {
                LivingEntity _entity = (LivingEntity) entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder((MobEffect) ButcheryModMobEffects.WITHEREDHEARTEFFECT.get()), 6000, 1, false, false));
                }
            }
            ButcheryMod.queueServerWork(6000, () -> {
                ButcheryPersistentData.of(entity).putBoolean("hasBlessing", false);
            });
            if (Math.random() >= 0.25d || !(entity instanceof LivingEntity)) {
                return;
            }
            LivingEntity _entity2 = (LivingEntity) entity;
            if (!_entity2.level().isClientSide()) {
                _entity2.addEffect(new MobEffectInstance(MobEffects.WITHER, 250, 12, false, false));
            }
        }
    }
}
