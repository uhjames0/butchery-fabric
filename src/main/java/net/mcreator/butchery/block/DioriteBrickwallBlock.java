package net.mcreator.butchery.block;

import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class DioriteBrickwallBlock
extends WallBlock {
    public DioriteBrickwallBlock(BlockBehaviour.Properties properties) {
        super(properties.strength(1.0f, 10.0f).instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
    }
}

