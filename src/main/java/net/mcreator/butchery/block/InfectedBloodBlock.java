package net.mcreator.butchery.block;

import net.mcreator.butchery.init.ButcheryModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class InfectedBloodBlock
extends LiquidBlock {
    public InfectedBloodBlock(BlockBehaviour.Properties properties) {
        super(ButcheryModFluids.INFECTED_BLOOD.get(), properties.mapColor(MapColor.WATER).strength(10.0f).noCollision().noLootTable().liquid().pushReaction(PushReaction.POPPED).sound(SoundType.EMPTY).replaceable());
    }

    public int getLightBlock(BlockState state) {
        return 5;
    }
}

