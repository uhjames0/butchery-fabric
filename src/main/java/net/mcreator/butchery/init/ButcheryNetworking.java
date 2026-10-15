package net.mcreator.butchery.init;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.butchery.network.ButcheryModVariables;
import net.mcreator.butchery.network.EvokermaskpressMessage;
import net.mcreator.butchery.network.MenuStateUpdateMessage;
import net.mcreator.butchery.network.PillagernosepressMessage;
import net.mcreator.butchery.network.TaxidermystationguiSlotMessage;
import net.mcreator.butchery.network.VindicatornosepressMessage;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class ButcheryNetworking {
    public static List<PayloadEntry> MESSAGES() {
        ArrayList<PayloadEntry> list = new ArrayList<PayloadEntry>();
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return ButcheryModVariables.PlayerVariablesSyncMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return ButcheryModVariables.PlayerVariablesSyncMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                ButcheryModVariables.PlayerVariablesSyncMessage.handleData((ButcheryModVariables.PlayerVariablesSyncMessage)p, c);
            }
        });
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return EvokermaskpressMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return EvokermaskpressMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                EvokermaskpressMessage.handleData((EvokermaskpressMessage)p, c);
            }
        });
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return MenuStateUpdateMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return MenuStateUpdateMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                MenuStateUpdateMessage.handleMenuState((MenuStateUpdateMessage)p, c);
            }
        });
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return PillagernosepressMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return PillagernosepressMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                PillagernosepressMessage.handleData((PillagernosepressMessage)p, c);
            }
        });
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return TaxidermystationguiSlotMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return TaxidermystationguiSlotMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                TaxidermystationguiSlotMessage.handleData((TaxidermystationguiSlotMessage)p, c);
            }
        });
        list.add(new PayloadEntry(){

            @Override
            public CustomPacketPayload.Type<?> type() {
                return VindicatornosepressMessage.TYPE;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec() {
                return VindicatornosepressMessage.STREAM_CODEC;
            }

            @Override
            public void handle(CustomPacketPayload p, ButcheryPayloadContext c) {
                VindicatornosepressMessage.handleData((VindicatornosepressMessage)p, c);
            }
        });
        return list;
    }

    public static interface PayloadEntry {
        public CustomPacketPayload.Type<?> type();

        public StreamCodec<RegistryFriendlyByteBuf, ? extends CustomPacketPayload> codec();

        public void handle(CustomPacketPayload var1, ButcheryPayloadContext var2);
    }
}

