package net.mcreator.butchery.init;

import net.mcreator.butchery.potion.PillagerfriendMobEffect;
import net.mcreator.butchery.potion.WitheredhearteffectMobEffect;
import net.mcreator.butchery.procedures.Pillager_disguise_expiresProcedure;
import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.shim.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;

public class ButcheryModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, "butchery");
    public static final DeferredHolder<MobEffect, MobEffect> WITHEREDHEARTEFFECT = REGISTRY.register("witheredhearteffect", () -> new WitheredhearteffectMobEffect());
    public static final DeferredHolder<MobEffect, MobEffect> PILLAGERFRIEND = REGISTRY.register("pillagerfriend", () -> new PillagerfriendMobEffect());

    public static void onEffectRemoved(Entity entity, MobEffectInstance effectInstance) {
        ButcheryModMobEffects.expireEffects(entity, effectInstance);
    }

    private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
        if (effectInstance.getEffect().is(PILLAGERFRIEND.getId())) {
            Pillager_disguise_expiresProcedure.execute(entity);
        }
    }
}

