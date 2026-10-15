package net.mcreator.butchery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryEventBridge;
import net.mcreator.butchery.init.ButcheryModBlockEntities;
import net.mcreator.butchery.init.ButcheryModBlockEntitiesInit;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModCommands;
import net.mcreator.butchery.init.ButcheryModCompostables;
import net.mcreator.butchery.init.ButcheryModEntities;
import net.mcreator.butchery.init.ButcheryModEntitiesInit;
import net.mcreator.butchery.init.ButcheryModFeatures;
import net.mcreator.butchery.init.ButcheryModFluidTypes;
import net.mcreator.butchery.init.ButcheryModFluids;
import net.mcreator.butchery.init.ButcheryModFuels;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.init.ButcheryModLootModifiers;
import net.mcreator.butchery.init.ButcheryModMenusInit;
import net.mcreator.butchery.init.ButcheryModMobEffects;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.init.ButcheryModRecipeTypes;
import net.mcreator.butchery.init.ButcheryModSounds;
import net.mcreator.butchery.init.ButcheryModTabsInit;
import net.mcreator.butchery.init.ButcheryModTrades;
import net.mcreator.butchery.init.ButcheryModVillagerInit;
import net.mcreator.butchery.init.ButcheryModWorldgen;
import net.mcreator.butchery.init.ButcheryNetworking;
import net.mcreator.butchery.mixinbridge.ButcheryMixinHooks;
import net.mcreator.butchery.network.ButcheryModVariables;
import net.mcreator.butchery.shim.ButcheryEnv;
import net.mcreator.butchery.shim.ButcheryPayloadContext;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.ModConfigSpec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: ButcheryMod.class */
public class ButcheryMod implements ModInitializer {
    public static final String MODID = "butchery";
    public static final Logger LOGGER = LogManager.getLogger(ButcheryMod.class);
    private static final ConcurrentLinkedQueue<Work> workQueue = new ConcurrentLinkedQueue<>();

    /* JADX INFO: loaded from: ButcheryMod$Work.class */
    private static final class Work {
        final Runnable action;
        int ticks;

        Work(Runnable action, int ticks) {
            this.action = action;
            this.ticks = ticks;
        }
    }

    public void onInitialize() {
        LOGGER.info("[Butchery] ============================================================");
        LOGGER.info("[Butchery] Fabric 26.3 port BUILD r16 (5.3.1-r16) is ACTIVE.");
        LOGGER.info("[Butchery] If this line does not say r16, an old jar is still in mods/!");
        LOGGER.info("[Butchery] ============================================================");
        LOGGER.info("[Butchery] Fabric 26.3 port initializing...");
        ButcheryPersistentData.touch();
        ModConfigSpec.load();
        ButcheryconfigConfiguration.SPEC.getClass();
        ButcheryModFluidTypes.BLOOD_TYPE.get();
        ButcheryModFluidTypes.INFECTED_BLOOD_TYPE.get();
        ButcheryModFluids.register();
        ButcheryModBlocks.REGISTRY.register();
        ButcheryModItems.REGISTRY.register();
        ButcheryModBlockEntities.class.getName();
        ButcheryModBlockEntitiesInit.register();
        ButcheryModEntitiesInit.register();
        ButcheryModSounds.REGISTRY.register();
        ButcheryModParticleTypes.REGISTRY.register();
        ButcheryModMobEffects.REGISTRY.register();
        ButcheryModFeatures.REGISTRY.register();
        ButcheryModMenusInit.register();
        ButcheryModTabsInit.register();
        ButcheryModRecipeTypes.register();
        ButcheryModEntities.registerAttributes();
        registerNetworking();
        ButcheryModFuels.registerFuels();
        ButcheryModLootModifiers.initLootModifiers();
        ButcheryModWorldgen.registerBiomeModifications();
        ButcheryModCompostables.initCompostables();
        ButcheryModCommands.register();
        ButcheryModTrades.register();
        ButcheryEventBridge.registerServerEvents();
        ButcheryModVillagerInit.noop();
        ButcheryMixinHooks.initHooks();
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            tick();
        });
        ServerTickEvents.END_SERVER_TICK.register(server2 -> {
            for (ServerPlayer sp : server2.getPlayerList().getPlayers()) {
                try {
                    ButcheryEventBridge.playerTick(sp);
                } catch (Exception e) {
                    LOGGER.error("[Butchery] player tick error", e);
                }
            }
        });
        ServerLifecycleEvents.SERVER_STARTED.register(server3 -> {
            ButcheryEnv.currentServer = server3;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server4 -> {
            ButcheryEnv.currentServer = null;
            workQueue.clear();
        });
        LOGGER.info("[Butchery] initialization complete");
    }

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new Work(action, tick));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tick() {
        if (workQueue.isEmpty()) {
            return;
        }
        List<Work> due = null;
        Iterator<Work> it = workQueue.iterator();
        while (it.hasNext()) {
            Work wk = it.next();
            wk.ticks--;
            if (wk.ticks <= 0) {
                it.remove();
                if (due == null) {
                    due = new ArrayList<>();
                }
                due.add(wk);
            }
        }
        if (due != null) {
            for (Work w : due) {
                try {
                    w.action.run();
                } catch (Exception e) {
                    LOGGER.error("[Butchery] queued delayed action failed", e);
                }
            }
        }
    }

    private static void registerNetworking() {
        List<ButcheryNetworking.PayloadEntry> messages = ButcheryNetworking.MESSAGES();
        Iterator<ButcheryNetworking.PayloadEntry> it = messages.iterator();
        while (it.hasNext()) {
            registerPayload(it.next());
        }
        for (ButcheryNetworking.PayloadEntry e : messages) {
            ServerPlayNetworking.registerGlobalReceiver(e.type(), (payload, context) -> {
                try {
                    e.handle(payload, new ButcheryPayloadContext(context.player(), (PacketFlow) null, context.player()));
                } catch (Exception ex) {
                    LOGGER.error("[Butchery] network handler error", ex);
                }
            });
        }
    }

    private static void registerPayload(ButcheryNetworking.PayloadEntry e) {
        PayloadTypeRegistry.clientboundPlay().register((net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type) e.type(), (net.minecraft.network.codec.StreamCodec) e.codec());
        PayloadTypeRegistry.serverboundPlay().register((net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type) e.type(), (net.minecraft.network.codec.StreamCodec) e.codec());
    }

    public static void clientRegisterNetworking() {
        List<ButcheryNetworking.PayloadEntry> messages = ButcheryNetworking.MESSAGES();
        for (ButcheryNetworking.PayloadEntry e : messages) {
            clientRegisterPayload(e);
        }
    }

    private static void clientRegisterPayload(ButcheryNetworking.PayloadEntry e) {
        ClientEnvHooks.registerClientPayloadReceiver(e);
    }

    public static void sendSyncToPlayer(ServerPlayer player) {
        ButcheryModVariables.sync(player);
    }

    @Nullable
    public static Player clientPlayer() {
        if (!ButcheryEnv.isClient()) {
            return null;
        }
        try {
            return ClientEnvHooks.clientPlayer();
        } catch (Throwable var1) {
            LOGGER.error("Failed to get client player", var1);
            return null;
        }
    }
}
