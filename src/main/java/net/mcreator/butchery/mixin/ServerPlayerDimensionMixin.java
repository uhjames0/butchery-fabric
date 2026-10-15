package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: ServerPlayerDimensionMixin.class */
@Mixin({ServerPlayer.class})
public class ServerPlayerDimensionMixin {
    @Inject(method = {"triggerDimensionChangeTriggers(Lnet/minecraft/server/level/ServerLevel;)V"}, at = {@At("HEAD")}, require = 0)
    private void butchery$onDimChange(ServerLevel fromLevel, CallbackInfo ci) {
        ButcheryMixinHooks.onDimensionChange((ServerPlayer)(Object) this);
    }
}
