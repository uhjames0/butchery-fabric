package net.mcreator.butchery.shim;

import java.util.concurrent.CompletableFuture;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public record ButcheryPayloadContext(Player player, PacketFlow flow, ServerPlayer serverPlayer) {
    public CompletableFuture<Void> enqueueWork(Runnable work) {
        work.run();
        return CompletableFuture.completedFuture(null);
    }

    public Connection connection() {
        return new Connection();
    }

    public static class Connection {
        public void disconnect(Component msg) {
        }
    }
}

