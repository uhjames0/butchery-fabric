package net.mcreator.butchery.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Ate_intestinesProcedure {
    public static void execute(Entity entity) {
        LivingEntity _entity;
        if (entity != null && entity instanceof LivingEntity && !(_entity = (LivingEntity)entity).level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1, false, false));
        }
    }
}

