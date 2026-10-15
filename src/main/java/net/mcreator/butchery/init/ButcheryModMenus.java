package net.mcreator.butchery.init;

import io.netty.buffer.Unpooled;
import java.util.Map;
import java.util.function.BiFunction;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuProvider;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.mcreator.butchery.network.MenuStateUpdateMessage;
import net.mcreator.butchery.shim.ButcheryNet;
import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.world.inventory.FreezerinventoryMenu;
import net.mcreator.butchery.world.inventory.MeatgrinderguiMenu;
import net.mcreator.butchery.world.inventory.PestleandmotarguiMenu;
import net.mcreator.butchery.world.inventory.TaxidermystationguiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

public class ButcheryModMenus {
    public static final DeferredHolder<MenuType<?>, MenuType<MeatgrinderguiMenu>> MEATGRINDERGUI = ButcheryModMenus.registerMenu("meatgrindergui", (syncId, inv, pos) -> new MeatgrinderguiMenu(syncId, inv, ButcheryModMenus.bufWithPos(pos)));
    public static final DeferredHolder<MenuType<?>, MenuType<FreezerinventoryMenu>> FREEZERINVENTORY = ButcheryModMenus.registerMenu("freezerinventory", (syncId, inv, pos) -> new FreezerinventoryMenu(syncId, inv, ButcheryModMenus.bufWithPos(pos)));
    public static final DeferredHolder<MenuType<?>, MenuType<TaxidermystationguiMenu>> TAXIDERMYSTATIONGUI = ButcheryModMenus.registerMenu("taxidermystationgui", (syncId, inv, pos) -> new TaxidermystationguiMenu(syncId, inv, ButcheryModMenus.bufWithPos(pos)));
    public static final DeferredHolder<MenuType<?>, MenuType<PestleandmotarguiMenu>> PESTLEANDMOTARGUI = ButcheryModMenus.registerMenu("pestleandmotargui", (syncId, inv, pos) -> new PestleandmotarguiMenu(syncId, inv, ButcheryModMenus.bufWithPos(pos)));

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenu(String name, ExtendedMenuType.ExtendedFactory<T, BlockPos> factory) {
        ResourceKey key = ResourceKey.create((ResourceKey)Registries.MENU, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)name));
        ExtendedMenuType type = new ExtendedMenuType(factory, BlockPos.STREAM_CODEC);
        Registry.register((Registry)BuiltInRegistries.MENU, (ResourceKey)key, (Object)type);
        DeferredHolder holder = new DeferredHolder(key.identifier(), () -> ButcheryModMenus.lambda$registerMenu$0((MenuType)type));
        holder.bind((MenuType)type);
        return holder;
    }

    public static FriendlyByteBuf bufWithPos(BlockPos pos) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeBlockPos(pos == null ? BlockPos.ZERO : pos);
        return buf;
    }

    public static MenuProvider posMenuProvider(final String title, final BlockPos pos, final BiFunction<Integer, Inventory, AbstractContainerMenu> supplier) {
        return new ExtendedMenuProvider<BlockPos>(){

            public Component getDisplayName() {
                return Component.literal((String)title);
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return (AbstractContainerMenu)supplier.apply(id, inventory);
            }

            public BlockPos getScreenOpeningData(ServerPlayer player) {
                return pos;
            }
        };
    }

    private static /* synthetic */ MenuType lambda$registerMenu$0(MenuType type) {
        return type;
    }

    public static interface MenuAccessor {
        public Map<String, Object> getMenuState();

        public Map<Integer, Slot> getSlots();

        default public void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
            this.getMenuState().put(elementType + ":" + name, elementState);
            if (player instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer)player;
                ButcheryNet.sendToPlayer((Player)serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
            }
        }
    }
}

