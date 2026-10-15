package net.mcreator.butchery.shim;

import net.mcreator.butchery.shim.ButcheryCaps;

public class ILevelExtension {
    private final Object holder;

    public ILevelExtension(Object holder) {
        this.holder = holder;
    }

    public <T> T getCapability(Object cap, Object ... extra) {
        return ButcheryCaps.getCapability(this.holder, cap, extra);
    }
}

