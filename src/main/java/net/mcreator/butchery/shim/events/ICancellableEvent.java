package net.mcreator.butchery.shim.events;

public interface ICancellableEvent {
    public void setCanceled(boolean var1);

    public boolean isCanceled();
}

