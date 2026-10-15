package net.mcreator.butchery.mixin;

import java.util.Collection;
import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: LivingEntityEffectMixin.class */
@Mixin({LivingEntity.class})
public class LivingEntityEffectMixin {
    @Inject(method = {"onEffectsRemoved(Ljava/util/Collection;)V"}, at = {@At("HEAD")}, require = 0)
    private void butchery$onEffectRemoved(Collection<MobEffectInstance> effects, CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object) this;
        for (MobEffectInstance effect : effects) {
            ButcheryMixinHooks.onEffectRemoved(self, effect);
        }
    }
}
