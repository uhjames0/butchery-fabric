package net.mcreator.butchery.shim;

public class ButcheryRegistryHolder<T> {
    public final T value;

    public ButcheryRegistryHolder(T value) {
        this.value = value;
    }

    public T get() {
        return this.value;
    }
}

