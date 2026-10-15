package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class PlasticsheetOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == ButcheryModBlocks.PLASTIC_SHEET.get()) {
            IntegerProperty _integerProp;
            int _value = 0;
            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = world.getBlockState(_pos);
            Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        } else if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() != ButcheryModBlocks.PLASTIC_SHEET.get()) {
            IntegerProperty _integerProp;
            int _value = 1;
            BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
            BlockState _bs = world.getBlockState(_pos);
            Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
    }
}

