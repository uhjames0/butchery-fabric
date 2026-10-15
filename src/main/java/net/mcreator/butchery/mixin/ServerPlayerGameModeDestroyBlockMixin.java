package net.mcreator.butchery.mixin;

import net.mcreator.butchery.shim.ButcheryBlockHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ServerPlayerGameMode.class})
public abstract class ServerPlayerGameModeDestroyBlockMixin {
    @Shadow
    public ServerLevel level;
    @Shadow
    public ServerPlayer player;

    @Inject(method={"destroyBlock(Lnet/minecraft/core/BlockPos;)Z"}, at={@At(value="HEAD")})
    private void butchery$beforeDestroy(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        ButcheryBlockHooks.fire((Level)this.level, pos, (Player)this.player);
    }
}

