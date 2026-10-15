package net.mcreator.butchery.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.client.gui.FreezerinventoryScreen;
import net.mcreator.butchery.client.gui.MeatgrinderguiScreen;
import net.mcreator.butchery.client.gui.PestleandmotarguiScreen;
import net.mcreator.butchery.client.gui.TaxidermystationguiScreen;
import net.mcreator.butchery.init.ButcheryModClientRegistries;
import net.mcreator.butchery.init.ButcheryModKeyMappings;
import net.mcreator.butchery.init.ButcheryModMenus;
import net.mcreator.butchery.shim.events.RegisterBlockColorShim;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

@Environment(value=EnvType.CLIENT)
public class ButcheryClientEventBridge {
    public static void registerClientEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ButcheryModKeyMappings.clientTick();
            ShimEvent.ClientTickShim ev = new ShimEvent.ClientTickShim();
        });
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {});
    }

    public static void registerClientRegistries() {
        ButcheryModClientRegistries.registerLayerDefinitions();
        ButcheryModClientRegistries.registerEntityRenderers();
        ButcheryModClientRegistries.registerBlockEntityRenderers();
        ButcheryModClientRegistries.registerParticleProviders();
        ButcheryModKeyMappings.registerKeys();
        try {
            MenuScreens.register(ButcheryModMenus.MEATGRINDERGUI.get(), MeatgrinderguiScreen::new);
            MenuScreens.register(ButcheryModMenus.FREEZERINVENTORY.get(), FreezerinventoryScreen::new);
            MenuScreens.register(ButcheryModMenus.TAXIDERMYSTATIONGUI.get(), TaxidermystationguiScreen::new);
            MenuScreens.register(ButcheryModMenus.PESTLEANDMOTARGUI.get(), PestleandmotarguiScreen::new);
        }
        catch (Exception e) {
            ButcheryMod.LOGGER.warn("[Butchery] screen registration issue", (Throwable)e);
        }
        for (RegisterBlockColorShim.Entry entry : RegisterBlockColorShim.ENTRIES) {
            BlockColorRegistry.register((bs, level, pos, tintList) -> {
                try {
                    tintList.add(entry.color().apply(bs, (BlockGetter)level, pos, 0));
                }
                catch (Exception e) {
                    tintList.add(-1);
                }
            }, (Block[])entry.blocks());
        }
    }
}

