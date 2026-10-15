package net.mcreator.butchery.shim;

import java.util.function.Supplier;
import net.mcreator.butchery.shim.DeferredHolder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class DeferredItem<T extends Item>
extends DeferredHolder<Item, T> {
    public DeferredItem(Identifier id, Supplier<T> supplier) {
        super(id, supplier);
    }
}

