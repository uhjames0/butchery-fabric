package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class EmptyturtleshellBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
        BlockState _bs = new Object(){

            /*
             * Enabled aggressive block sorting
             */
            public BlockState with(BlockState _bs, String _property, int _newValue) {
                BlockState blockState;
                Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                if (_prop instanceof IntegerProperty) {
                    Property<?> _ip = (IntegerProperty)_prop;
                    if (_prop.getPossibleValues().contains(_newValue)) {
                        blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                        return blockState;
                    }
                }
                blockState = _bs;
                return blockState;
            }
        }.with(((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState(), "blockstate", 16);
        BlockState _bso = world.getBlockState(_bp);
        for (Property _propertyOld : _bso.getProperties()) {
            Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
            if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
            try {
                _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
            }
            catch (Exception exception) {}
        }
        world.setBlock(_bp, _bs, 3);
    }
}

