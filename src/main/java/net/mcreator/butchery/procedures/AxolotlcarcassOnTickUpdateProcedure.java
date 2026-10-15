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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class AxolotlcarcassOnTickUpdateProcedure {
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
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 448.0) {
            if (world instanceof ServerLevel _level) {
               _level.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
            }

            ButcheryMod.queueServerWork(5, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(15, () -> {
               if (world instanceof ServerLevel _levelx) {
                  _levelx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
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
            || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 450.0) {
            FillbloodgrateProcedure.execute(world, x, y, z);
         }

         if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") == 450.0) {
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

            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLUE_AXOLOTL_CARCASS.get()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.BLUE_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOld : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                     } catch (Exception var18) {
                     }
                  }
               }

               world.setBlock(_bpxx, _bsxx, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_AXOLOTL_CARCASS.get()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_BROWN_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                     } catch (Exception var17) {
                     }
                  }
               }

               world.setBlock(_bpxx, _bsxx, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CYAN_AXOLOTL_CARCASS.get()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_CYAN_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                     } catch (Exception var16) {
                     }
                  }
               }

               world.setBlock(_bpxx, _bsxx, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GOLD_AXOLOTL_CARCASS.get()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_GOLD_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                     } catch (Exception var15) {
                     }
                  }
               }

               world.setBlock(_bpxx, _bsxx, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PINK_AXOLOTL_CARCASS.get()) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_PINK_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                     } catch (Exception var14) {
                     }
                  }
               }

               world.setBlock(_bpxx, _bsxx, 3);
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
