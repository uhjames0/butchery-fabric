package net.mcreator.butchery.network;

import net.mcreator.butchery.ClientEnvHooks;
import net.mcreator.butchery.init.ButcheryModMenus;
import net.mcreator.butchery.init.ButcheryModScreens;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.AbstractContainerMenu;

public record MenuStateUpdateMessage(int elementType, String name, Object elementState) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MenuStateUpdateMessage> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"butchery", (String)"menustate_update"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MenuStateUpdateMessage> STREAM_CODEC = StreamCodec.of(MenuStateUpdateMessage::write, MenuStateUpdateMessage::read);

    public static void write(FriendlyByteBuf buffer, MenuStateUpdateMessage message) {
        Object object;
        buffer.writeInt(message.elementType);
        buffer.writeUtf(message.name);
        if (message.elementType == 0) {
            buffer.writeUtf((String)message.elementState);
        } else if (message.elementType == 1) {
            buffer.writeBoolean(((Boolean)message.elementState).booleanValue());
        } else if (message.elementType == 2 && (object = message.elementState) instanceof Number) {
            Number n = (Number)object;
            buffer.writeDouble(n.doubleValue());
        }
    }

    public static MenuStateUpdateMessage read(FriendlyByteBuf buffer) {
        int elementType = buffer.readInt();
        String name = buffer.readUtf();
        Object elementState = null;
        if (elementType == 0) {
            elementState = buffer.readUtf();
        } else if (elementType == 1) {
            elementState = buffer.readBoolean();
        } else if (elementType == 2) {
            elementState = buffer.readDouble();
        }
        return new MenuStateUpdateMessage(elementType, name, elementState);
    }

    public CustomPacketPayload.Type<MenuStateUpdateMessage> type() {
        return TYPE;
    }

    public static void handleMenuState(MenuStateUpdateMessage message, ButcheryPayloadContext context) {
        String string;
        Object object;
        if (!(message.name.length() > 256 || (object = message.elementState) instanceof String && (string = (String)object).length() > 8192)) {
            context.enqueueWork(() -> {
                AbstractContainerMenu patt0$temp = context.player().containerMenu;
                if (patt0$temp instanceof ButcheryModMenus.MenuAccessor) {
                    Screen patt1$temp;
                    ButcheryModMenus.MenuAccessor menu = (ButcheryModMenus.MenuAccessor)patt0$temp;
                    menu.getMenuState().put(message.elementType + ":" + message.name, message.elementState);
                    if (context.flow() == PacketFlow.CLIENTBOUND && (patt1$temp = ClientEnvHooks.currentScreen) instanceof ButcheryModScreens.ScreenAccessor) {
                        ButcheryModScreens.ScreenAccessor accessor = (ButcheryModScreens.ScreenAccessor)patt1$temp;
                        accessor.updateMenuState(message.elementType, message.name, message.elementState);
                    }
                }
            }).exceptionally(e -> {
                context.connection().disconnect((Component)Component.literal((String)e.getMessage()));
                return null;
            });
        }
    }
}

