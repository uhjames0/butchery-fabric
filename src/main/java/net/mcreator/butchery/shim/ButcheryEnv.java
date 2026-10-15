package net.mcreator.butchery.shim;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ButcheryEnv {
    public static volatile MinecraftServer currentServer;
    public static final Logger LOGGER;
    public static final EnvType DIST;

    public static MinecraftServer getCurrentServer() {
        return currentServer;
    }

    public static boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    public static boolean isServer() {
        return !ButcheryEnv.isClient();
    }

    static {
        LOGGER = LogManager.getLogger((String)"ButcheryShim");
        DIST = FabricLoader.getInstance().getEnvironmentType();
    }
}

