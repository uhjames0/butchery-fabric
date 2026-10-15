package net.mcreator.butchery.mixin;

import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerAdvancements.class})
public interface PlayerAdvancementsAccessor {
    @Accessor(value="player")
    ServerPlayer butchery$getPlayer();
}
