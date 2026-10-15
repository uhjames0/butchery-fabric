package net.mcreator.butchery.shim;

import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class DeferredHolder<R, T extends R>
implements Supplier<T> {
    protected final Identifier id;
    private volatile Supplier<T> supplier;
    private volatile T cached;

    public DeferredHolder(Identifier id, Supplier<T> supplier) {
        this.id = id;
        this.supplier = supplier;
    }

    public void bind(T value) {
        this.cached = value;
        this.supplier = null;
    }

    @Override
    public T get() {
        T v = this.cached;
        if (v == null) {
            this.cached = v = this.supplier.get();
        }
        return v;
    }

    public Identifier getId() {
        return this.id;
    }

    public Identifier key() {
        return this.id;
    }

    public T value() {
        return this.get();
    }

    public static DeferredHolder create(ResourceKey rawKey, Identifier id) {
        return new DeferredHolder(id, () -> {
            Registry reg = BuiltInRegistries.REGISTRY.get(rawKey.identifier()).map(r -> (Registry)r.value()).orElse(null);
            return reg == null ? null : reg.getValue(id);
        });
    }
}

