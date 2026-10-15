package net.mcreator.butchery;

import net.fabricmc.api.ClientModInitializer;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.client.ButcheryArmorRendering;
import net.mcreator.butchery.client.ButcheryClientEventBridge;
import net.mcreator.butchery.client.ButcheryFluidRendering;

public class ButcheryModClient
implements ClientModInitializer {
    public void onInitializeClient() {
        ButcheryMod.LOGGER.info("[Butchery] client init");
        ButcheryClientEventBridge.registerClientRegistries();
        ButcheryClientEventBridge.registerClientEvents();
        ButcheryMod.clientRegisterNetworking();
        ButcheryArmorRendering.init();
        ButcheryFluidRendering.register();
        net.mcreator.butchery.client.ButcheryHintOverlays.register();
    }
}

