package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class SkinrackOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (SkinrackOnTickUpdateProcedure.getBlockNBTLogic(world, BlockPos.containing((double)x, (double)y, (double)z), "skinWetted")) {
            Level _level;
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    ButcheryPersistentData.of(_blockEntity).putDouble("Timer", SkinrackOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") + 1.0);
                }
                if (world instanceof Level) {
                    _level = (Level)world;
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            if (SkinrackOnTickUpdateProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "Timer") == ButcheryconfigConfiguration.SKIN_DRYING_TIME.get()) {
                IntegerProperty _integerProp;
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("skinWetted", false);
                        ButcheryPersistentData.of(_blockEntityx).putDouble("Timer", 0.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                    }
                }
                int _value = 30;
                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxx = world.getBlockState(_pos);
                Property property = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, (BlockState)_bsxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                }
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
    }
}

