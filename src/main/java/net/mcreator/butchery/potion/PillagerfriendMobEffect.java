package net.mcreator.butchery.potion;

import net.mcreator.butchery.procedures.Pillager_disguised_startedProcedure;
import net.mcreator.butchery.procedures.PillagerignoreProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PillagerfriendMobEffect
extends MobEffect {
    public PillagerfriendMobEffect() {
        super(MobEffectCategory.NEUTRAL, -10066330);
    }

    public void onEffectStarted(LivingEntity entity, int amplifier) {
        Pillager_disguised_startedProcedure.execute((Entity)entity);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        PillagerignoreProcedure.execute((LevelAccessor)level, entity.getX(), entity.getY(), entity.getZ(), (Entity)entity);
        return super.applyEffectTick(level, entity, amplifier);
    }
}

