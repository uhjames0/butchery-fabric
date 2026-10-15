package net.mcreator.butchery.mixin;

import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Fires the NeoForge-equivalent of AdvancementEvent.AdvancementEarnEvent.
 * Required by BreathlessadvancementaddedProcedure and
 * ItsafloateradvancementgrantedProcedure (play the butchery:coin sound when
 * the breathless / itsafloater advancements are earned).
 */
@Mixin(value={PlayerAdvancements.class})
public abstract class PlayerAdvancementsAwardMixin {
    @Inject(method={"award(Lnet/minecraft/advancements/AdvancementHolder;Ljava/lang/String;)Z"}, at={@At(value="TAIL")})
    private void butchery$onAdvancementAwarded(AdvancementHolder holder, String criterion, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValueZ()) {
            ServerPlayer player = ((PlayerAdvancementsAccessor)this).butchery$getPlayer();
            if (player != null) {
                ButcheryMixinHooks.onAdvancementEarned(player, holder);
            }
        }
    }
}
