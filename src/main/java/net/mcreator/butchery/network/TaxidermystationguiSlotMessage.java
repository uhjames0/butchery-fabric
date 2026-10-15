package net.mcreator.butchery.network;

import net.mcreator.butchery.procedures.TaxidermyTakenfromslotProcedure;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public record TaxidermystationguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<TaxidermystationguiSlotMessage> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"butchery", (String)"taxidermystationgui_slots"));
    public static final StreamCodec<RegistryFriendlyByteBuf, TaxidermystationguiSlotMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {
        buffer.writeInt(message.slotID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        buffer.writeInt(message.changeType);
        buffer.writeInt(message.meta);
    }, buffer -> new TaxidermystationguiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    public CustomPacketPayload.Type<TaxidermystationguiSlotMessage> type() {
        return TYPE;
    }

    public static void handleData(TaxidermystationguiSlotMessage message, ButcheryPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> TaxidermystationguiSlotMessage.handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
                context.connection().disconnect((Component)Component.literal((String)e.getMessage()));
                return null;
            });
        }
    }

    public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
        Level world = entity.level();
        if (world.hasChunkAt(new BlockPos(x, y, z)) && slot == 3 && changeType == 1) {
            TaxidermyTakenfromslotProcedure.execute((LevelAccessor)world, x, y, z);
        }
    }
}

