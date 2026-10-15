package net.mcreator.butchery.shim;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mcreator.butchery.ClientEnvHooks;
import net.mcreator.butchery.shim.ButcheryEnv;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class ButcheryNet {
    public static void sendToPlayer(Player player, CustomPacketPayload payload) {
        if (player instanceof ServerPlayer) {
            ServerPlayer sp = (ServerPlayer)player;
            ServerPlayNetworking.send((ServerPlayer)sp, (CustomPacketPayload)payload);
        }
    }

    public static void sendToServer(CustomPacketPayload payload) {
        ButcheryNet.sendToServer(payload, new CustomPacketPayload[0]);
    }

    public static void sendToServer(CustomPacketPayload payload, CustomPacketPayload ... extra) {
        if (ButcheryEnv.isClient() && ClientEnvHooks.clientConnected()) {
            ClientPlayNetworking.send((CustomPacketPayload)payload);
        }
    }
}

