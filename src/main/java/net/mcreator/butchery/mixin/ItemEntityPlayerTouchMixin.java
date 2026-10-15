package net.mcreator.butchery.mixin;

import net.mcreator.butchery.init.ButcheryEventBridge;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: ItemEntityPlayerTouchMixin.class */
@Mixin({ItemEntity.class})
public abstract class ItemEntityPlayerTouchMixin {
    @Inject(method = {"playerTouch"}, at = {@At("HEAD")})
    private void butchery$onPlayerTouch(Player player, CallbackInfo ci) {
        ButcheryEventBridge.onItemPickup(player, (ItemEntity)(Object) this);
    }
}
