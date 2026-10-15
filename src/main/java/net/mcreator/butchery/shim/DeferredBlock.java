package net.mcreator.butchery.shim;

import java.util.function.Supplier;
import net.mcreator.butchery.shim.DeferredHolder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class DeferredBlock<T extends Block>
extends DeferredHolder<Block, T> {
    public DeferredBlock(Identifier id, Supplier<T> supplier) {
        super(id, supplier);
    }
}

