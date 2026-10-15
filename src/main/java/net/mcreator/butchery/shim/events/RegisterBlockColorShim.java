package net.mcreator.butchery.shim.events;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RegisterBlockColorShim {
    public static final List<Entry> ENTRIES = new ArrayList<Entry>();

    public void register(LegacyBlockColor color, Block ... blocks) {
        ENTRIES.add(new Entry(color, blocks));
    }

    public record Entry(LegacyBlockColor color, Block[] blocks) {
    }

    @FunctionalInterface
    public static interface LegacyBlockColor {
        public int apply(BlockState var1, BlockGetter var2, BlockPos var3, int var4);
    }
}

