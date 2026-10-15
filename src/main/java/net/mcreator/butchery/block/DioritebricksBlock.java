package net.mcreator.butchery.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class DioritebricksBlock
extends Block {
    public DioritebricksBlock(BlockBehaviour.Properties properties) {
        super(properties.strength(1.0f, 10.0f).instrument(NoteBlockInstrument.BASEDRUM));
    }

    public int getLightBlock(BlockState state) {
        return 15;
    }
}

