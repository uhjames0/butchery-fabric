package net.mcreator.butchery.network;

import net.mcreator.butchery.procedures.VindicatormasknoiseProcedure;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public record VindicatornosepressMessage(int eventType, int pressedms) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<VindicatornosepressMessage> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"butchery", (String)"key_vindicatornosepress"));
    public static final StreamCodec<RegistryFriendlyByteBuf, VindicatornosepressMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.eventType);
        buffer.writeInt(message.pressedms);
    }, buffer -> new VindicatornosepressMessage(buffer.readInt(), buffer.readInt()));

    public CustomPacketPayload.Type<VindicatornosepressMessage> type() {
        return TYPE;
    }

    public static void handleData(VindicatornosepressMessage message, ButcheryPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> VindicatornosepressMessage.pressAction(context.player(), message.eventType, message.pressedms)).exceptionally(e -> {
                context.connection().disconnect((Component)Component.literal((String)e.getMessage()));
                return null;
            });
        }
    }

    public static void pressAction(Player entity, int type, int pressedms) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (world.hasChunkAt(entity.blockPosition()) && type == 0) {
            VindicatormasknoiseProcedure.execute((LevelAccessor)world, x, y, z, (Entity)entity);
        }
    }
}

