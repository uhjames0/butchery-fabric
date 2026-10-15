package net.mcreator.butchery.network;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.mcreator.butchery.shim.ButcheryNet;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class ButcheryModVariables {
    public static final Map<UUID, PlayerVariables> PLAYER_VARIABLES = new ConcurrentHashMap<UUID, PlayerVariables>();

    public static PlayerVariables getPlayerVariables(Player player) {
        return PLAYER_VARIABLES.computeIfAbsent(player.getUUID(), k -> new PlayerVariables());
    }

    public static void sync(ServerPlayer player) {
        ButcheryNet.sendToPlayer((Player)player, new PlayerVariablesSyncMessage(ButcheryModVariables.getPlayerVariables((Player)player)));
    }

    public static class PlayerVariables {
        public double first_join_guide;

        public void markSyncDirty() {
        }
    }

    public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload
    {
        public static final CustomPacketPayload.Type<PlayerVariablesSyncMessage> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"butchery", (String)"player_variables_sync"));
        public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.ofMember(PlayerVariablesSyncMessage::write, PlayerVariablesSyncMessage::decode);

        public static void write(PlayerVariablesSyncMessage msg, RegistryFriendlyByteBuf buf) {
            buf.writeDouble(msg.data().first_join_guide);
        }

        public static PlayerVariablesSyncMessage decode(RegistryFriendlyByteBuf buf) {
            PlayerVariables data = new PlayerVariables();
            data.first_join_guide = buf.readDouble();
            return new PlayerVariablesSyncMessage(data);
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }

        public static void handleData(PlayerVariablesSyncMessage payload, ButcheryPayloadContext context) {
            if (context.player() != null) {
                PLAYER_VARIABLES.put(context.player().getUUID(), payload.data());
            }
        }
    }
}

