package net.mcreator.butchery.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class DioritebrickstairsBlock
extends StairBlock {
    public DioritebrickstairsBlock(BlockBehaviour.Properties properties) {
        super(Blocks.AIR.defaultBlockState(), properties.strength(1.0f, 10.0f).instrument(NoteBlockInstrument.BASEDRUM));
    }

    public float getExplosionResistance() {
        return 10.0f;
    }
}

