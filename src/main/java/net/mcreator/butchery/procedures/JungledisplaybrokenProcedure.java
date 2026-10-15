package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

/* JADX INFO: loaded from: JungledisplaybrokenProcedure.class */
public class JungledisplaybrokenProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        Blocks.AIR.defaultBlockState();
        BlockState displayType = ((Block) ButcheryModBlocks.JUNGLE_BUTCHER_DISPLAY.get()).defaultBlockState();
        if (world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getBlock() == blockStateWithDirection(displayType, Direction.NORTH).getBlock() && getBlockDirection(world, BlockPos.containing(x + 1.0d, y, z)) == Direction.NORTH) {
            Property<?> property = world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip6 = property;
                iIntValue8 = ((Integer) world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getValue(_getip6)).intValue();
            } else {
                iIntValue8 = -1;
            }
            if (iIntValue8 == 1) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x + 1.0d, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level) world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }
                BlockPos _pos = BlockPos.containing(x + 1.0d, y, z);
                BlockState _bsx = world.getBlockState(_pos);
                Property<?> property2 = _bsx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property2 instanceof IntegerProperty) {
                    IntegerProperty _integerProp = (IntegerProperty) property2;
                    if (_integerProp.getPossibleValues().contains(0)) {
                        world.setBlock(_pos, (BlockState) _bsx.setValue(_integerProp, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getBlock() == blockStateWithDirection(displayType, Direction.NORTH).getBlock() && getBlockDirection(world, BlockPos.containing(x - 1.0d, y, z)) == Direction.NORTH) {
            Property<?> property3 = world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property3 instanceof IntegerProperty) {
                Property<?> _getip15 = property3;
                iIntValue7 = ((Integer) world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getValue(_getip15)).intValue();
            } else {
                iIntValue7 = -1;
            }
            if (iIntValue7 == 2) {
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing(x - 1.0d, y, z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx2 = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level2 = (Level) world;
                        _level2.sendBlockUpdated(_bpx, _bsx2, _bsx2, 3);
                    }
                }
                BlockPos _pos2 = BlockPos.containing(x - 1.0d, y, z);
                BlockState _bsxx = world.getBlockState(_pos2);
                Property<?> property4 = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property4 instanceof IntegerProperty) {
                    IntegerProperty _integerProp2 = (IntegerProperty) property4;
                    if (_integerProp2.getPossibleValues().contains(0)) {
                        world.setBlock(_pos2, (BlockState) _bsxx.setValue(_integerProp2, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getBlock() == blockStateWithDirection(displayType, Direction.SOUTH).getBlock() && getBlockDirection(world, BlockPos.containing(x + 1.0d, y, z)) == Direction.SOUTH) {
            Property<?> property5 = world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property5 instanceof IntegerProperty) {
                Property<?> _getip24 = property5;
                iIntValue6 = ((Integer) world.getBlockState(BlockPos.containing(x + 1.0d, y, z)).getValue(_getip24)).intValue();
            } else {
                iIntValue6 = -1;
            }
            if (iIntValue6 == 2) {
                if (!world.isClientSide()) {
                    BlockPos _bpxx = BlockPos.containing(x + 1.0d, y, z);
                    BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                    BlockState _bsxx2 = world.getBlockState(_bpxx);
                    if (_blockEntityxx != null) {
                        ButcheryPersistentData.of(_blockEntityxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level3 = (Level) world;
                        _level3.sendBlockUpdated(_bpxx, _bsxx2, _bsxx2, 3);
                    }
                }
                BlockPos _pos3 = BlockPos.containing(x + 1.0d, y, z);
                BlockState _bsxxx = world.getBlockState(_pos3);
                Property<?> property6 = _bsxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property6 instanceof IntegerProperty) {
                    IntegerProperty _integerProp3 = (IntegerProperty) property6;
                    if (_integerProp3.getPossibleValues().contains(0)) {
                        world.setBlock(_pos3, (BlockState) _bsxxx.setValue(_integerProp3, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getBlock() == blockStateWithDirection(displayType, Direction.SOUTH).getBlock() && getBlockDirection(world, BlockPos.containing(x - 1.0d, y, z)) == Direction.SOUTH) {
            Property<?> property7 = world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property7 instanceof IntegerProperty) {
                Property<?> _getip33 = property7;
                iIntValue5 = ((Integer) world.getBlockState(BlockPos.containing(x - 1.0d, y, z)).getValue(_getip33)).intValue();
            } else {
                iIntValue5 = -1;
            }
            if (iIntValue5 == 1) {
                if (!world.isClientSide()) {
                    BlockPos _bpxxx = BlockPos.containing(x - 1.0d, y, z);
                    BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                    BlockState _bsxxx2 = world.getBlockState(_bpxxx);
                    if (_blockEntityxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level4 = (Level) world;
                        _level4.sendBlockUpdated(_bpxxx, _bsxxx2, _bsxxx2, 3);
                    }
                }
                BlockPos _pos4 = BlockPos.containing(x - 1.0d, y, z);
                BlockState _bsxxxx = world.getBlockState(_pos4);
                Property<?> property8 = _bsxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property8 instanceof IntegerProperty) {
                    IntegerProperty _integerProp4 = (IntegerProperty) property8;
                    if (_integerProp4.getPossibleValues().contains(0)) {
                        world.setBlock(_pos4, (BlockState) _bsxxxx.setValue(_integerProp4, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getBlock() == blockStateWithDirection(displayType, Direction.EAST).getBlock() && getBlockDirection(world, BlockPos.containing(x, y, z + 1.0d)) == Direction.EAST) {
            Property<?> property9 = world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property9 instanceof IntegerProperty) {
                Property<?> _getip42 = property9;
                iIntValue4 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getValue(_getip42)).intValue();
            } else {
                iIntValue4 = -1;
            }
            if (iIntValue4 == 1) {
                if (!world.isClientSide()) {
                    BlockPos _bpxxxx = BlockPos.containing(x, y, z + 1.0d);
                    BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                    BlockState _bsxxxx2 = world.getBlockState(_bpxxxx);
                    if (_blockEntityxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level5 = (Level) world;
                        _level5.sendBlockUpdated(_bpxxxx, _bsxxxx2, _bsxxxx2, 3);
                    }
                }
                BlockPos _pos5 = BlockPos.containing(x, y, z + 1.0d);
                BlockState _bsxxxxx = world.getBlockState(_pos5);
                Property<?> property10 = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property10 instanceof IntegerProperty) {
                    IntegerProperty _integerProp5 = (IntegerProperty) property10;
                    if (_integerProp5.getPossibleValues().contains(0)) {
                        world.setBlock(_pos5, (BlockState) _bsxxxxx.setValue(_integerProp5, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getBlock() == blockStateWithDirection(displayType, Direction.EAST).getBlock() && getBlockDirection(world, BlockPos.containing(x, y, z - 1.0d)) == Direction.EAST) {
            Property<?> property11 = world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property11 instanceof IntegerProperty) {
                Property<?> _getip51 = property11;
                iIntValue3 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getValue(_getip51)).intValue();
            } else {
                iIntValue3 = -1;
            }
            if (iIntValue3 == 2) {
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxx = BlockPos.containing(x, y, z - 1.0d);
                    BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                    BlockState _bsxxxxx2 = world.getBlockState(_bpxxxxx);
                    if (_blockEntityxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level6 = (Level) world;
                        _level6.sendBlockUpdated(_bpxxxxx, _bsxxxxx2, _bsxxxxx2, 3);
                    }
                }
                BlockPos _pos6 = BlockPos.containing(x, y, z - 1.0d);
                BlockState _bsxxxxxx = world.getBlockState(_pos6);
                Property<?> property12 = _bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property12 instanceof IntegerProperty) {
                    IntegerProperty _integerProp6 = (IntegerProperty) property12;
                    if (_integerProp6.getPossibleValues().contains(0)) {
                        world.setBlock(_pos6, (BlockState) _bsxxxxxx.setValue(_integerProp6, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getBlock() == blockStateWithDirection(displayType, Direction.WEST).getBlock() && getBlockDirection(world, BlockPos.containing(x, y, z + 1.0d)) == Direction.WEST) {
            Property<?> property13 = world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property13 instanceof IntegerProperty) {
                Property<?> _getip60 = property13;
                iIntValue2 = ((Integer) world.getBlockState(BlockPos.containing(x, y, z + 1.0d)).getValue(_getip60)).intValue();
            } else {
                iIntValue2 = -1;
            }
            if (iIntValue2 == 2) {
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxx = BlockPos.containing(x, y, z + 1.0d);
                    BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                    BlockState _bsxxxxxx2 = world.getBlockState(_bpxxxxxx);
                    if (_blockEntityxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level7 = (Level) world;
                        _level7.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx2, _bsxxxxxx2, 3);
                    }
                }
                BlockPos _pos7 = BlockPos.containing(x, y, z + 1.0d);
                BlockState _bsxxxxxxx = world.getBlockState(_pos7);
                Property<?> property14 = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property14 instanceof IntegerProperty) {
                    IntegerProperty _integerProp7 = (IntegerProperty) property14;
                    if (_integerProp7.getPossibleValues().contains(0)) {
                        world.setBlock(_pos7, (BlockState) _bsxxxxxxx.setValue(_integerProp7, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getBlock() == blockStateWithDirection(displayType, Direction.WEST).getBlock() && getBlockDirection(world, BlockPos.containing(x, y, z - 1.0d)) == Direction.WEST) {
            Property<?> property15 = world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property15 instanceof IntegerProperty) {
                Property<?> _getip69 = property15;
                iIntValue = ((Integer) world.getBlockState(BlockPos.containing(x, y, z - 1.0d)).getValue(_getip69)).intValue();
            } else {
                iIntValue = -1;
            }
            if (iIntValue == 1) {
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z - 1.0d);
                    BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                    BlockState _bsxxxxxxx2 = world.getBlockState(_bpxxxxxxx);
                    if (_blockEntityxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("stateChanged", 0.0d);
                    }
                    if (world instanceof Level) {
                        Level _level8 = (Level) world;
                        _level8.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx2, _bsxxxxxxx2, 3);
                    }
                }
                BlockPos _pos8 = BlockPos.containing(x, y, z - 1.0d);
                BlockState _bsxxxxxxxx = world.getBlockState(_pos8);
                Property<?> property16 = _bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property16 instanceof IntegerProperty) {
                    IntegerProperty _integerProp8 = (IntegerProperty) property16;
                    if (_integerProp8.getPossibleValues().contains(0)) {
                        world.setBlock(_pos8, (BlockState) _bsxxxxxxxx.setValue(_integerProp8, 0), 3);
                    }
                }
            }
        }
    }

    private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
        Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property instanceof EnumProperty) {
            EnumProperty enumProperty = (EnumProperty) property;
            if (enumProperty.getPossibleValues().contains(newValue)) {
                return (BlockState) blockState.setValue(enumProperty, newValue);
            }
        }
        Property<?> property2 = blockState.getBlock().getStateDefinition().getProperty("axis");
        if (property2 instanceof EnumProperty) {
            EnumProperty enumProperty2 = (EnumProperty) property2;
            if (enumProperty2.getPossibleValues().contains(newValue.getAxis())) {
                return (BlockState) blockState.setValue(enumProperty2, newValue.getAxis());
            }
        }
        return blockState;
    }

    private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property != null) {
            Direction value = (Direction) blockState.getValue(property);
            if (value instanceof Direction) {
                Direction direction = value;
                return direction;
            }
        }
        if (blockState.hasProperty(BlockStateProperties.AXIS)) {
            return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
        }
        if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
        }
        return Direction.NORTH;
    }
}
