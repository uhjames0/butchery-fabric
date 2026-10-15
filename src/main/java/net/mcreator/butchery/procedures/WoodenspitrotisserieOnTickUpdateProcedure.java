package net.mcreator.butchery.procedures;
import net.minecraft.world.level.block.state.properties.Property;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/* JADX INFO: loaded from: WoodenspitrotisserieOnTickUpdateProcedure.class */
public class WoodenspitrotisserieOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int iIntValue;
        int iIntValue2;
        if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "mobCooking")) {
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    ButcheryPersistentData.of(_blockEntity).putDouble("Timer", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") + 1.0d);
                }
                if (world instanceof Level) {
                    Level _level = (Level) world;
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
            if (world.getBlockState(BlockPos.containing(x, y - 1.0d, z)).getBlock() == Blocks.CAMPFIRE) {
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 1800.0d) {
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                        Property<?> property = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property instanceof IntegerProperty) {
                            Property<?> _getip9 = property;
                            iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip9)).intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        if (iIntValue2 == 1) {
                            BlockPos _pos = BlockPos.containing(x, y, z);
                            BlockState _bsx = world.getBlockState(_pos);
                            Property<?> property2 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property2 instanceof IntegerProperty) {
                                IntegerProperty _integerProp = (IntegerProperty) property2;
                                if (_integerProp.getPossibleValues().contains(2)) {
                                    world.setBlock(_pos, (BlockState) _bsx.setValue(_integerProp, 2), 3);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 3600.0d) {
                    if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()) {
                        Property<?> property3 = world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (property3 instanceof IntegerProperty) {
                            Property<?> _getip15 = property3;
                            iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip15)).intValue();
                        } else {
                            iIntValue = -1;
                        }
                        if (iIntValue == 2) {
                            BlockPos _pos2 = BlockPos.containing(x, y, z);
                            BlockState _bsx2 = world.getBlockState(_pos2);
                            Property<?> property4 = _bsx2.getBlock().getStateDefinition().getProperty("blockstate");
                            if (property4 instanceof IntegerProperty) {
                                IntegerProperty _integerProp2 = (IntegerProperty) property4;
                                if (_integerProp2.getPossibleValues().contains(3)) {
                                    world.setBlock(_pos2, (BlockState) _bsx2.setValue(_integerProp2, 3), 3);
                                }
                            }
                        }
                    }
                    if (!world.isClientSide()) {
                        BlockPos _bpx = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                        BlockState _bsx3 = world.getBlockState(_bpx);
                        if (_blockEntityx != null) {
                            ButcheryPersistentData.of(_blockEntityx).putBoolean("mobCooking", false);
                        }
                        if (world instanceof Level) {
                            Level _level2 = (Level) world;
                            _level2.sendBlockUpdated(_bpx, _bsx3, _bsx3, 3);
                        }
                    }
                }
            }
        }
    }

    private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false);
        }
        return false;
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            return ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0d);
        }
        return -1.0d;
    }
}
