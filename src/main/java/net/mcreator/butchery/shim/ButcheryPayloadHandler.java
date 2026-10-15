package net.mcreator.butchery.shim;

import net.mcreator.butchery.shim.ButcheryPayloadContext;

public interface ButcheryPayloadHandler<T> {
    public void handle(T var1, ButcheryPayloadContext var2);
}

