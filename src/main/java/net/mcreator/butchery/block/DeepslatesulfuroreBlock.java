package net.mcreator.butchery.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class DeepslatesulfuroreBlock
extends Block {
    public DeepslatesulfuroreBlock(BlockBehaviour.Properties properties) {
        super(properties.strength(1.0f, 4.5f));
    }

    public int getLightBlock(BlockState state) {
        return 15;
    }
}

