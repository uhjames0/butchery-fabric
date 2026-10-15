package net.mcreator.butchery.shim.events;

import net.mcreator.butchery.shim.ButcheryEnv;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.minecraft.server.MinecraftServer;

public class NeoEvent
implements ICancellableEvent {
    public boolean canceled = false;

    @Override
    public void setCanceled(boolean c) {
        this.canceled = c;
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    public MinecraftServer getServer() {
        return ButcheryEnv.getCurrentServer();
    }
}

