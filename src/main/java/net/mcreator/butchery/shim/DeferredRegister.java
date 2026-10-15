package net.mcreator.butchery.shim;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: DeferredRegister.class */
public class DeferredRegister<T> {
    protected final Registry<T> registry;
    protected final String modid;
    protected final List<Entry<T>> entries = new ArrayList();
    protected final List<Runnable> postActions = new ArrayList();

    /* JADX INFO: loaded from: DeferredRegister$Entry.class */
    public record Entry<T>(Identifier id, Supplier<T> factory) {}

    private DeferredRegister(Registry<T> registry, String modid) {
        this.registry = registry;
        this.modid = modid;
    }

    public static <T> DeferredRegister<T> create(Registry<T> registry, String modid) {
        return new DeferredRegister<>(registry, modid);
    }

    public static <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> key, String modid) {
        return new DeferredRegister<>((Registry) BuiltInRegistries.REGISTRY.getValue(key.identifier()), modid);
    }

    public static Blocks createBlocks(String modid) {
        return new Blocks(modid);
    }

    public static Items createItems(String modid) {
        return new Items(modid);
    }

    public <S extends T> DeferredHolder<T, S> register(String name, Supplier<S> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(this.modid, name);
        DeferredHolder<T, S> holder = new DeferredHolder<>(id, factory);
        this.entries.add(new Entry<>(id, () -> {
            return factory.get();
        }));
        this.postActions.add(() -> {
            holder.bind((S) get(id));
        });
        return holder;
    }

    protected T get(Identifier identifier) {
        return (T) this.registry.getValue(identifier);
    }

    public void register() {
        for (Entry<T> e : this.entries) {
            Registry.register(this.registry, e.id(), e.factory().get());
        }
        this.entries.clear();
        for (Runnable r : this.postActions) {
            r.run();
        }
        this.postActions.clear();
    }

    /* JADX INFO: loaded from: DeferredRegister$Items.class */
    public static class Items extends DeferredRegister<Item> {
        public Items(String modid) {
            super(BuiltInRegistries.ITEM, modid);
        }

        public <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> factory, Item.Properties props) {
            Identifier id = Identifier.fromNamespaceAndPath(this.modid, name);
            props.setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), id));
            DeferredItem<I> holder = new DeferredItem<I>(id, () -> {
                return (I) factory.apply(props);
            });
            this.entries.add(new Entry<>(id, () -> {
                return (Item) factory.apply(props);
            }));
            this.postActions.add(() -> {
                holder.bind((I) get(id));
            });
            return holder;
        }
    }

    /* JADX INFO: loaded from: DeferredRegister$Blocks.class */
    public static class Blocks extends DeferredRegister<Block> {
        public Blocks(String modid) {
            super(BuiltInRegistries.BLOCK, modid);
        }

        public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> factory) {
            return registerBlock(name, factory, BlockBehaviour.Properties.of());
        }

        public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> factory, BlockBehaviour.Properties props) {
            ResourceKey<Block> key = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(this.modid, name));
            props.setId(key);
            DeferredBlock<B> holder = new DeferredBlock<B>(key.identifier(), () -> {
                return (B) factory.apply(props);
            });
            this.entries.add(new Entry<>(key.identifier(), () -> {
                return (Block) factory.apply(props);
            }));
            this.postActions.add(() -> {
                holder.bind((B) get(key.identifier()));
            });
            return holder;
        }
    }
}
