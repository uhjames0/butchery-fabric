package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DarkoakbutcherstablebrokenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.NORTH).getBlock()
         && getBlockDirection(world, BlockPos.containing(x + 1.0, y, z)) == Direction.NORTH
         && (
               world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6
                  ? (Integer)world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getValue(_getip6)
                  : -1
            )
            == 2) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x + 1.0, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               ButcheryPersistentData.of(_blockEntity).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x + 1.0, y, z);
         BlockState _bsx = world.getBlockState(_pos);
         if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.NORTH).getBlock()
         && getBlockDirection(world, BlockPos.containing(x - 1.0, y, z)) == Direction.NORTH
         && (
               world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
                  ? (Integer)world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getValue(_getip15)
                  : -1
            )
            == 3) {
         if (!world.isClientSide()) {
            BlockPos _bpx = BlockPos.containing(x - 1.0, y, z);
            BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
            BlockState _bsx = world.getBlockState(_bpx);
            if (_blockEntityx != null) {
               ButcheryPersistentData.of(_blockEntityx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x - 1.0, y, z);
         BlockState _bsxx = world.getBlockState(_pos);
         if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.SOUTH).getBlock()
         && getBlockDirection(world, BlockPos.containing(x + 1.0, y, z)) == Direction.SOUTH
         && (
               world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip24
                  ? (Integer)world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getValue(_getip24)
                  : -1
            )
            == 3) {
         if (!world.isClientSide()) {
            BlockPos _bpxx = BlockPos.containing(x + 1.0, y, z);
            BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
            BlockState _bsxx = world.getBlockState(_bpxx);
            if (_blockEntityxx != null) {
               ButcheryPersistentData.of(_blockEntityxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxx, _bsxx, _bsxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x + 1.0, y, z);
         BlockState _bsxxx = world.getBlockState(_pos);
         if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.SOUTH).getBlock()
         && getBlockDirection(world, BlockPos.containing(x - 1.0, y, z)) == Direction.SOUTH
         && (
               world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
                  ? (Integer)world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getValue(_getip33)
                  : -1
            )
            == 2) {
         if (!world.isClientSide()) {
            BlockPos _bpxxx = BlockPos.containing(x - 1.0, y, z);
            BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
            BlockState _bsxxx = world.getBlockState(_bpxxx);
            if (_blockEntityxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxx, _bsxxx, _bsxxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x - 1.0, y, z);
         BlockState _bsxxxx = world.getBlockState(_pos);
         if (_bsxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.EAST).getBlock()
         && getBlockDirection(world, BlockPos.containing(x, y, z + 1.0)) == Direction.EAST
         && (
               world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip42
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getValue(_getip42)
                  : -1
            )
            == 2) {
         if (!world.isClientSide()) {
            BlockPos _bpxxxx = BlockPos.containing(x, y, z + 1.0);
            BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
            BlockState _bsxxxx = world.getBlockState(_bpxxxx);
            if (_blockEntityxxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxxx, _bsxxxx, _bsxxxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x, y, z + 1.0);
         BlockState _bsxxxxx = world.getBlockState(_pos);
         if (_bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.EAST).getBlock()
         && getBlockDirection(world, BlockPos.containing(x, y, z - 1.0)) == Direction.EAST
         && (
               world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip51
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getValue(_getip51)
                  : -1
            )
            == 3) {
         if (!world.isClientSide()) {
            BlockPos _bpxxxxx = BlockPos.containing(x, y, z - 1.0);
            BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
            BlockState _bsxxxxx = world.getBlockState(_bpxxxxx);
            if (_blockEntityxxxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxxxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxxxx, _bsxxxxx, _bsxxxxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x, y, z - 1.0);
         BlockState _bsxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.WEST).getBlock()
         && getBlockDirection(world, BlockPos.containing(x, y, z + 1.0)) == Direction.WEST
         && (
               world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip60
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getValue(_getip60)
                  : -1
            )
            == 3) {
         if (!world.isClientSide()) {
            BlockPos _bpxxxxxx = BlockPos.containing(x, y, z + 1.0);
            BlockEntity _blockEntityxxxxxx = world.getBlockEntity(_bpxxxxxx);
            BlockState _bsxxxxxx = world.getBlockState(_bpxxxxxx);
            if (_blockEntityxxxxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxxxxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxxxxx, _bsxxxxxx, _bsxxxxxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x, y, z + 1.0);
         BlockState _bsxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxx.setValue(_integerProp, _value), 3);
         }
      } else if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock()
            == blockStateWithDirection(((Block)ButcheryModBlocks.DARK_OAK_BUTCHERS_TABLE.get()).defaultBlockState(), Direction.WEST).getBlock()
         && getBlockDirection(world, BlockPos.containing(x, y, z - 1.0)) == Direction.WEST
         && (
               world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getValue(_getip69)
                  : -1
            )
            == 2) {
         if (!world.isClientSide()) {
            BlockPos _bpxxxxxxx = BlockPos.containing(x, y, z - 1.0);
            BlockEntity _blockEntityxxxxxxx = world.getBlockEntity(_bpxxxxxxx);
            BlockState _bsxxxxxxx = world.getBlockState(_bpxxxxxxx);
            if (_blockEntityxxxxxxx != null) {
               ButcheryPersistentData.of(_blockEntityxxxxxxx).putDouble("stateChanged", 0.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bpxxxxxxx, _bsxxxxxxx, _bsxxxxxxx, 3);
            }
         }

         int _value = 0;
         BlockPos _pos = BlockPos.containing(x, y, z - 1.0);
         BlockState _bsxxxxxxxx = world.getBlockState(_pos);
         if (_bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bsxxxxxxxx.setValue(_integerProp, _value), 3);
         }
      }
   }

   private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
      if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty enumProperty
         && enumProperty.getPossibleValues().contains(newValue)) {
         return (BlockState)blockState.setValue(enumProperty, newValue);
      } else {
         return blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty enumProperty
               && enumProperty.getPossibleValues().contains(newValue.getAxis())
            ? (BlockState)blockState.setValue(enumProperty, newValue.getAxis())
            : blockState;
      }
   }

   private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
      BlockState blockState = world.getBlockState(pos);
      Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
      if (property != null && blockState.getValue(property) instanceof Direction direction) {
         return direction;
      } else if (blockState.hasProperty(BlockStateProperties.AXIS)) {
         return Direction.fromAxisAndDirection((Axis)blockState.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
      } else {
         return blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
            ? Direction.fromAxisAndDirection((Axis)blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
            : Direction.NORTH;
      }
   }
}
