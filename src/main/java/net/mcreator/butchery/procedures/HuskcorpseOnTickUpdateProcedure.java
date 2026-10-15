package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class HuskcorpseOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isBleeding")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               ButcheryPersistentData.of(_blockEntity).putDouble("Timer", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") + 1.0);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 28.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 56.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 84.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 112.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 140.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 168.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 196.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 224.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 252.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 280.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 308.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 336.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 364.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 392.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 420.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 448.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 476.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 504.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 532.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 560.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 588.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 616.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 644.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 672.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 700.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 728.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 756.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 784.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 812.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 840.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 868.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 896.0) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
            }

            ButcheryMod.queueServerWork(5, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(15, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 45.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 90.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 135.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 180.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 225.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 270.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 315.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 360.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 405.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 450.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 495.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 540.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 585.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 630.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 675.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 720.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 765.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 810.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 855.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 900.0) {
            PlacesandProcedure.execute(world, x, y, z);
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 28.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 56.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 84.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 112.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 140.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 168.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 196.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 224.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 252.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 280.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 308.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 336.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 364.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 392.0
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 420.0) {
            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip80)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip83)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip86
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip86)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip89
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip89)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip92
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip92)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip95
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip95)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip98
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip98)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip101
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip101)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip104
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip104)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip107
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip107)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip110
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip110)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip113
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip113)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip116
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip116)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip119
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip119)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip122
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getValue(_getip122)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxxxxxx));
                        } catch (Exception var255) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip127
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip127)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip130
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip130)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip133
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip133)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip136
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip136)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip139
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip139)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip142
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip142)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip145
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip145)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip148
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip148)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip151
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip151)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip154
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip154)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip157
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip157)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip160
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip160)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip163
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip163)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip166
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip166)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip169
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 2.0, z)).getValue(_getip169)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 2.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxxxxx));
                        } catch (Exception var256) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip174
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip174)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip177
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip177)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip180
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip180)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip183
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip183)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip186
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip186)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip189
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip189)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip192
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip192)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip195
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip195)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip198
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip198)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip201
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip201)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip204
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip204)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip207
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip207)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip210
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip210)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip213
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip213)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip216
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 3.0, z)).getValue(_getip216)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 3.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxxxx));
                        } catch (Exception var257) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip221
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip221)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip224
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip224)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip227
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip227)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip230
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip230)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip233
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip233)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip236
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip236)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip239
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip239)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip242
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip242)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip245
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip245)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip248
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip248)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip251
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip251)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip254
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip254)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip257
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip257)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip260
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip260)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip263
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 4.0, z)).getValue(_getip263)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 4.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxxx));
                        } catch (Exception var258) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip268
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip268)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip271
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip271)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip274
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip274)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip277
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip277)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip280
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip280)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip283
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip283)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip286
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip286)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip289
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip289)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip292
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip292)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip295
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip295)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip298
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip298)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip301
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip301)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip304
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip304)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip307
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip307)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip310
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 5.0, z)).getValue(_getip310)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 5.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxx));
                        } catch (Exception var259) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip315
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip315)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip318
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip318)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip321
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip321)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip324
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip324)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip327
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip327)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip330
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip330)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip333
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip333)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip336
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip336)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip339
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip339)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip342
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip342)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip345
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip345)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip348
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip348)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip351
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip351)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip354
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip354)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip357
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 6.0, z)).getValue(_getip357)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 6.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxx));
                        } catch (Exception var260) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip362
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip362)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip365
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip365)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip368
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip368)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip371
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip371)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip374
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip374)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip377
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip377)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip380
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip380)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip383
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip383)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip386
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip386)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip389
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip389)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip392
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip392)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip395
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip395)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip398
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip398)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip401
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip401)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip404
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 7.0, z)).getValue(_getip404)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 7.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxx));
                        } catch (Exception var261) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip409
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip409)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip412
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip412)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip415
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip415)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip418
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip418)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip421
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip421)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip424
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip424)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip427
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip427)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip430
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip430)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip433
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip433)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip436
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip436)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip439
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip439)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip442
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip442)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip445
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip445)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip448
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip448)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip451
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 8.0, z)).getValue(_getip451)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 8.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxx));
                        } catch (Exception var262) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip456
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip456)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip459
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip459)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip462
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip462)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip465
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip465)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip468
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip468)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip471
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip471)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip474
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip474)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip477
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip477)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip480
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip480)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip483
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip483)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip486
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip486)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip489
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip489)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip492
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip492)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip495
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip495)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip498
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getValue(_getip498)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 9.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxx));
                        } catch (Exception var263) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip503
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip503)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip506
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip506)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip509
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip509)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip512
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip512)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip515
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip515)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip518
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip518)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip521
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip521)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip524
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip524)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip527
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip527)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip530
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip530)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip533
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip533)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip536
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip536)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip539
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip539)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip542
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip542)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip545
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 10.0, z)).getValue(_getip545)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 10.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxx));
                        } catch (Exception var264) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 9.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip550
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip550)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip553
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip553)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip556
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip556)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip559
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip559)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip562
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip562)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip565
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip565)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip568
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip568)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip571
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip571)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip574
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip574)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip577
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip577)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip580
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip580)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip583
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip583)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip586
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip586)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip589
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip589)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip592
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 11.0, z)).getValue(_getip592)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 11.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxx));
                        } catch (Exception var265) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip597
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip597)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip600
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip600)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip603
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip603)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip606
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip606)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip609
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip609)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip612
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip612)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip615
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip615)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip618
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip618)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip621
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip621)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip624
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip624)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip627
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip627)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip630
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip630)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip633
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip633)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip636
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip636)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip639
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 12.0, z)).getValue(_getip639)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 12.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                        } catch (Exception var266) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip644
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip644)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip647
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip647)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip650
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip650)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip653
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip653)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip656
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip656)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip659
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip659)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip662
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip662)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip665
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip665)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip668
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip668)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip671
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip671)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip674
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip674)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip677
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip677)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip680
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip680)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip683
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip683)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip686
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 13.0, z)).getValue(_getip686)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 13.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                        } catch (Exception var267) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip691
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip691)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip694
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip694)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip697
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip697)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip700
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip700)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip703
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip703)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip706
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip706)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip709
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip709)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip712
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip712)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip715
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip715)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip718
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip718)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip721
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip721)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip724
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip724)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip727
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip727)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip730
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip730)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip733
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 14.0, z)).getValue(_getip733)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 14.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                        } catch (Exception var268) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip738
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip738)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip741
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip741)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip744
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip744)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip747
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip747)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip750
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip750)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip753
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip753)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip756
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip756)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip759
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip759)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip762
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip762)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip765
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip765)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip768
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip768)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip771
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip771)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip774
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip774)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip777
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip777)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip780
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 15.0, z)).getValue(_getip780)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 15.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                        } catch (Exception var269) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            } else if (world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock() == ButcheryModBlocks.SAND.get()) {
               if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip785
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip785)
                  )
                  == 0) {
                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip788
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip788)
                  )
                  == 1) {
                  int _value = 2;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip791
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip791)
                  )
                  == 2) {
                  int _value = 3;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip794
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip794)
                  )
                  == 3) {
                  int _value = 4;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip797
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip797)
                  )
                  == 4) {
                  int _value = 5;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip800
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip800)
                  )
                  == 5) {
                  int _value = 6;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip803
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip803)
                  )
                  == 6) {
                  int _value = 7;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip806
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip806)
                  )
                  == 7) {
                  int _value = 8;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip809
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip809)
                  )
                  == 8) {
                  int _value = 9;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip812
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip812)
                  )
                  == 9) {
                  int _value = 10;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip815
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip815)
                  )
                  == 10) {
                  int _value = 11;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip818
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip818)
                  )
                  == 11) {
                  int _value = 12;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip821
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip821)
                  )
                  == 12) {
                  int _value = 13;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip824
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip824)
                  )
                  == 13) {
                  int _value = 14;
                  BlockPos _pos = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }
               } else if ((
                     !(
                           world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip827
                        )
                        ? -1
                        : (Integer)world.getBlockState(BlockPos.containing(x, y - 16.0, z)).getValue(_getip827)
                  )
                  == 14) {
                  BlockPos _bpx = BlockPos.containing(x, y - 16.0, z);
                  BlockState _bsx = Blocks.SAND.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOld : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                        } catch (Exception var270) {
                        }
                     }
                  }

                  world.setBlock(_bpx, _bsx, 3);
               }
            }
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 900.0) {
            if (!world.isClientSide()) {
               BlockPos _bpx = BlockPos.containing(x, y, z);
               BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
               BlockState _bsx = world.getBlockState(_bpx);
               if (_blockEntityx != null) {
                  ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
               }

               if (world instanceof Level _level) {
                  _level.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
               }
            }

            BlockPos _bpxx = BlockPos.containing(x, y, z);
            BlockState _bsxx = (new Object() {
               public BlockState with(BlockState _bs, String _property, int _newValue) {
                  Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                  return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? (BlockState)_bs.setValue(_ip, _newValue) : _bs;
               }
            }).with(((Block)ButcheryModBlocks.DRAINED_HUSK_CORPSE.get()).defaultBlockState(), "blockstate", 1);
            BlockState _bso = world.getBlockState(_bpxx);

            for (Property<?> _propertyOldxxxxxxxxxxxxxxxx : _bso.getProperties()) {
               Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxxxxxxxx.getName());
               if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                  try {
                     _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxxxxxxxx));
                  } catch (Exception var254) {
                  }
               }
            }

            world.setBlock(_bpxx, _bsxx, 3);
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
