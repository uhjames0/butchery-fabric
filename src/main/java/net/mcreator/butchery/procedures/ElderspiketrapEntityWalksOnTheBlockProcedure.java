package net.mcreator.butchery.procedures;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class ElderspiketrapEntityWalksOnTheBlockProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            LivingEntity _entity;
            entity.hurt(new DamageSource((Holder)world.registryAccess().getOrThrow(DamageTypes.GENERIC)), 2.0f);
            if (entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 60, 1, false, false));
            }
        }
    }
}

