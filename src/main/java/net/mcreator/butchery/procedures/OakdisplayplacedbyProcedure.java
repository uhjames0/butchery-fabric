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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class OakdisplayplacedbyProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockState displayType = Blocks.AIR.defaultBlockState();
        displayType = ((Block)ButcheryModBlocks.OAK_BUTCHER_DISPLAY.get()).defaultBlockState();
        if (OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "stateChanged") == 0.0 && OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)(x + 1.0), (double)y, (double)z), "stateChanged") == 0.0) {
            if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)(x + 1.0), (double)y, (double)z)) == Direction.NORTH) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpx = BlockPos.containing((double)(x + 1.0), (double)y, (double)z);
                    BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                    BlockState _bsx = world.getBlockState(_bpx);
                    if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                    }
                }
                int _value = 2;
                BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxx = world.getBlockState(_pos);
                Property property = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, (BlockState)_bsxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                }
                _value = 1;
                _pos = BlockPos.containing((double)(x + 1.0), (double)y, (double)z);
                _bsxx = world.getBlockState(_pos);
                property = _bsxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, (BlockState)_bsxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
                }
            } else if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)(x + 1.0), (double)y, (double)z)) == Direction.SOUTH) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                    BlockState _bsxxx = world.getBlockState(_bpxx);
                    if (_blockEntityxx != null) {
                        ButcheryPersistentData.of(_blockEntityxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxx, _bsxxx, _bsxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxx = BlockPos.containing((double)(x + 1.0), (double)y, (double)z);
                    BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                    BlockState _bsxxxx = world.getBlockState(_bpxxx);
                    if (_blockEntityxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxx, _bsxxxx, _bsxxxx, 3);
                    }
                }
                int _valuex = 1;
                BlockPos _posx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxx = world.getBlockState(_posx);
                Property property = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuex)) {
                    world.setBlock(_posx, (BlockState)_bsxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuex)), 3);
                }
                _valuex = 2;
                _posx = BlockPos.containing((double)(x + 1.0), (double)y, (double)z);
                _bsxxxxx = world.getBlockState(_posx);
                property = _bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuex)) {
                    world.setBlock(_posx, (BlockState)_bsxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuex)), 3);
                }
            } else {
                IntegerProperty _integerProp;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                    BlockState _bsxxxxxx = world.getBlockState(_bpxxxx);
                    if (_blockEntityxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxx).putDouble("stateChanged", 0.0);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxx, _bsxxxxxx, _bsxxxxxx, 3);
                    }
                }
                int _valuexx = 0;
                BlockPos _posxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxx = world.getBlockState(_posxx);
                Property property = _bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexx)) {
                    world.setBlock(_posxx, (BlockState)_bsxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexx)), 3);
                }
            }
        } else if (OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "stateChanged") == 0.0 && OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)(x - 1.0), (double)y, (double)z), "stateChanged") == 0.0) {
            if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)(x - 1.0), (double)y, (double)z)) == Direction.NORTH) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                    BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxx);
                    if (_blockEntityxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxx = BlockPos.containing((double)(x - 1.0), (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
                    BlockState _bsxxxxxxxx = world.getBlockState(_bpxxxxxx);
                    if (_blockEntityxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxx, _bsxxxxxxxx, _bsxxxxxxxx, 3);
                    }
                }
                int _valuexx = 1;
                BlockPos _posxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxx = world.getBlockState(_posxx);
                Property property = _bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexx)) {
                    world.setBlock(_posxx, (BlockState)_bsxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexx)), 3);
                }
                _valuexx = 2;
                _posxx = BlockPos.containing((double)(x - 1.0), (double)y, (double)z);
                _bsxxxxxxxxx = world.getBlockState(_posxx);
                property = _bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexx)) {
                    world.setBlock(_posxx, (BlockState)_bsxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexx)), 3);
                }
            } else if (world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)(x - 1.0), (double)y, (double)z)) == Direction.SOUTH) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
                    BlockState _bsxxxxxxxxxx = world.getBlockState(_bpxxxxxxx);
                    if (_blockEntityxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxxxxx, _bsxxxxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxx = BlockPos.containing((double)(x - 1.0), (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxx = world.getBlockEntity(_bpxxxxxxxx);
                    BlockState _bsxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxx);
                    if (_blockEntityxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxx, _bsxxxxxxxxxxx, _bsxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxx = 2;
                BlockPos _posxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxx = world.getBlockState(_posxxx);
                Property property = _bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxx)) {
                    world.setBlock(_posxxx, (BlockState)_bsxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxx)), 3);
                }
                _valuexxx = 1;
                _posxxx = BlockPos.containing((double)(x - 1.0), (double)y, (double)z);
                _bsxxxxxxxxxxxx = world.getBlockState(_posxxx);
                property = _bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxx)) {
                    world.setBlock(_posxxx, (BlockState)_bsxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxx)), 3);
                }
            } else {
                IntegerProperty _integerProp;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxx);
                    if (_blockEntityxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxx).putDouble("stateChanged", 0.0);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxx, _bsxxxxxxxxxxxxx, _bsxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxx = 0;
                BlockPos _posxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_posxxxx);
                Property property = _bsxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxx)) {
                    world.setBlock(_posxxxx, (BlockState)_bsxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxx)), 3);
                }
            }
        } else if (OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "stateChanged") == 0.0 && OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)(z + 1.0)), "stateChanged") == 0.0) {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)x, (double)y, (double)(z + 1.0))) == Direction.EAST) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z + 1.0));
                    BlockEntity _blockEntityxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxx = 2;
                BlockPos _posxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxx);
                Property property = _bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxx)) {
                    world.setBlock(_posxxxx, (BlockState)_bsxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxx)), 3);
                }
                _valuexxxx = 1;
                _posxxxx = BlockPos.containing((double)x, (double)y, (double)(z + 1.0));
                _bsxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxx);
                property = _bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxx)) {
                    world.setBlock(_posxxxx, (BlockState)_bsxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxx)), 3);
                }
            } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)x, (double)y, (double)(z + 1.0))) == Direction.WEST) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z + 1.0));
                    BlockEntity _blockEntityxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxxx = 1;
                BlockPos _posxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxx);
                Property property = _bsxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxx)) {
                    world.setBlock(_posxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxx)), 3);
                }
                _valuexxxxx = 2;
                _posxxxxx = BlockPos.containing((double)x, (double)y, (double)(z + 1.0));
                _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxx);
                property = _bsxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxx)) {
                    world.setBlock(_posxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxx)), 3);
                }
            } else {
                IntegerProperty _integerProp;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxx).putDouble("stateChanged", 0.0);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxxxx = 0;
                BlockPos _posxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxx);
                Property property = _bsxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxx)) {
                    world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxx)), 3);
                }
            }
        } else if (OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)z), "stateChanged") == 0.0 && OakdisplayplacedbyProcedure.getBlockNBTNumber(world, BlockPos.containing((double)x, (double)y, (double)(z - 1.0)), "stateChanged") == 0.0) {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)x, (double)y, (double)(z - 1.0))) == Direction.EAST) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z - 1.0));
                    BlockEntity _blockEntityxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxxxx = 1;
                BlockPos _posxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxx);
                Property property = _bsxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxx)) {
                    world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxx)), 3);
                }
                _valuexxxxxx = 2;
                _posxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z - 1.0));
                _bsxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxx);
                property = _bsxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxx)) {
                    world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxx)), 3);
                }
            } else if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == displayType.getBlock() && OakdisplayplacedbyProcedure.getBlockDirection(world, BlockPos.containing((double)x, (double)y, (double)(z - 1.0))) == Direction.WEST) {
                IntegerProperty _integerProp;
                Level _level;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z - 1.0));
                    BlockEntity _blockEntityxxxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxxxx).putDouble("stateChanged", 1.0);
                    }
                    if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxxxxx = 2;
                BlockPos _posxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxx);
                Property property = _bsxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxxx)) {
                    world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxx)), 3);
                }
                _valuexxxxxxx = 1;
                _posxxxxxxx = BlockPos.containing((double)x, (double)y, (double)(z - 1.0));
                _bsxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxx);
                property = _bsxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxxx)) {
                    world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxx)), 3);
                }
            } else {
                IntegerProperty _integerProp;
                if (!world.isClientSide()) {
                    BlockPos _bpxxxxxxxxxxxxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                    BlockEntity _blockEntityxxxxxxxxxxxxxxxxxxx = world.getBlockEntity(_bpxxxxxxxxxxxxxxxxxxx);
                    BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxxxxxxxxxxxxxxxx);
                    if (_blockEntityxxxxxxxxxxxxxxxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxxxxxxxxxxxxxxxx).putDouble("stateChanged", 0.0);
                    }
                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bpxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx, 3);
                    }
                }
                int _valuexxxxxxxx = 0;
                BlockPos _posxxxxxxxx = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxx);
                Property property = _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_valuexxxxxxxx)) {
                    world.setBlock(_posxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_valuexxxxxxxx)), 3);
                }
            }
        }
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getDoubleOr(tag, 0.0) : -1.0;
    }

    private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
        Comparable comparable;
        BlockState blockState = world.getBlockState(pos);
        Property property = blockState.getBlock().getStateDefinition().getProperty("facing");
        if (property != null && (comparable = blockState.getValue(property)) instanceof Direction) {
            Direction direction = (Direction)comparable;
            return direction;
        }
        if (blockState.hasProperty((Property)BlockStateProperties.AXIS)) {
            return Direction.fromAxisAndDirection((Direction.Axis)((Direction.Axis)blockState.getValue((Property)BlockStateProperties.AXIS)), (Direction.AxisDirection)Direction.AxisDirection.POSITIVE);
        }
        return blockState.hasProperty((Property)BlockStateProperties.HORIZONTAL_AXIS) ? Direction.fromAxisAndDirection((Direction.Axis)((Direction.Axis)blockState.getValue((Property)BlockStateProperties.HORIZONTAL_AXIS)), (Direction.AxisDirection)Direction.AxisDirection.POSITIVE) : Direction.NORTH;
    }
}

