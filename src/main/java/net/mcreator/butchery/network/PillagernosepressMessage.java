package net.mcreator.butchery.network;

import net.mcreator.butchery.procedures.PillagermasknoiseProcedure;
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

public record PillagernosepressMessage(int eventType, int pressedms) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<PillagernosepressMessage> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"butchery", (String)"key_pillagernosepress"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PillagernosepressMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.eventType);
        buffer.writeInt(message.pressedms);
    }, buffer -> new PillagernosepressMessage(buffer.readInt(), buffer.readInt()));

    public CustomPacketPayload.Type<PillagernosepressMessage> type() {
        return TYPE;
    }

    public static void handleData(PillagernosepressMessage message, ButcheryPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> PillagernosepressMessage.pressAction(context.player(), message.eventType, message.pressedms)).exceptionally(e -> {
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
            PillagermasknoiseProcedure.execute((LevelAccessor)world, x, y, z, (Entity)entity);
        }
    }
}

