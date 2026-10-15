package net.mcreator.butchery.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SulfuroreBlock
extends Block {
    public SulfuroreBlock(BlockBehaviour.Properties properties) {
        super(properties.strength(1.0f, 3.0f));
    }

    public int getLightBlock(BlockState state) {
        return 15;
    }
}

