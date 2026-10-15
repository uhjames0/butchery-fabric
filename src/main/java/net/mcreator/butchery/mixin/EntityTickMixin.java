package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: EntityTickMixin.class */
@Mixin({Entity.class})
public class EntityTickMixin {
    @Inject(method = {"tick()V"}, at = {@At("HEAD")})
    private void butchery$entityTick(CallbackInfo ci) {
        ButcheryMixinHooks.onEntityTick((Entity)(Object) this);
    }
}
