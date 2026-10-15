package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;

public class CatcarcassOnTickUpdateProcedure {
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
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
               }
            });
            ButcheryMod.queueServerWork(15, () -> {
               if (world instanceof ServerLevel _level) {
                  _level.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
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

            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip41)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOld : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                     } catch (Exception var46) {
                     }
                  }
               }

               BlockEntity _be = world.getBlockEntity(_bpxx);
               CompoundTag _bnbt = null;
               if (_be != null) {
                  _bnbt = _be.saveWithFullMetadata(world.registryAccess());
                  _be.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbt != null) {
                  _be = world.getBlockEntity(_bpxx);
                  if (_be != null) {
                     try {
                        _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                     } catch (Exception var45) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLACK_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip47)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                     } catch (Exception var44) {
                     }
                  }
               }

               BlockEntity _bex = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtx = null;
               if (_bex != null) {
                  _bnbtx = _bex.saveWithFullMetadata(world.registryAccess());
                  _bex.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtx != null) {
                  _bex = world.getBlockEntity(_bpxx);
                  if (_bex != null) {
                     try {
                        _bex.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtx));
                     } catch (Exception var43) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip53
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip53)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                     } catch (Exception var42) {
                     }
                  }
               }

               BlockEntity _bexx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxx = null;
               if (_bexx != null) {
                  _bnbtxx = _bexx.saveWithFullMetadata(world.registryAccess());
                  _bexx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxx != null) {
                  _bexx = world.getBlockEntity(_bpxx);
                  if (_bexx != null) {
                     try {
                        _bexx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxx));
                     } catch (Exception var41) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CALICO_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip59
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip59)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                     } catch (Exception var40) {
                     }
                  }
               }

               BlockEntity _bexxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxx = null;
               if (_bexxx != null) {
                  _bnbtxxx = _bexxx.saveWithFullMetadata(world.registryAccess());
                  _bexxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxx != null) {
                  _bexxx = world.getBlockEntity(_bpxx);
                  if (_bexxx != null) {
                     try {
                        _bexxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxx));
                     } catch (Exception var39) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.JELLIE_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip65
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip65)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                     } catch (Exception var38) {
                     }
                  }
               }

               BlockEntity _bexxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxx = null;
               if (_bexxxx != null) {
                  _bnbtxxxx = _bexxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxx != null) {
                  _bexxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxx != null) {
                     try {
                        _bexxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxx));
                     } catch (Exception var37) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip71
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip71)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxx));
                     } catch (Exception var36) {
                     }
                  }
               }

               BlockEntity _bexxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxx = null;
               if (_bexxxxx != null) {
                  _bnbtxxxxx = _bexxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxx != null) {
                  _bexxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxx != null) {
                     try {
                        _bexxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxx));
                     } catch (Exception var35) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip77
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip77)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxx));
                     } catch (Exception var34) {
                     }
                  }
               }

               BlockEntity _bexxxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxxx = null;
               if (_bexxxxxx != null) {
                  _bnbtxxxxxx = _bexxxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxxx != null) {
                  _bexxxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxxx != null) {
                     try {
                        _bexxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxx));
                     } catch (Exception var33) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RED_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip83)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxx));
                     } catch (Exception var32) {
                     }
                  }
               }

               BlockEntity _bexxxxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxxxx = null;
               if (_bexxxxxxx != null) {
                  _bnbtxxxxxxx = _bexxxxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxxxx != null) {
                  _bexxxxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxxxx != null) {
                     try {
                        _bexxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxx));
                     } catch (Exception var31) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip89
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip89)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxx));
                     } catch (Exception var30) {
                     }
                  }
               }

               BlockEntity _bexxxxxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxxxxx = null;
               if (_bexxxxxxxx != null) {
                  _bnbtxxxxxxxx = _bexxxxxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxxxxx != null) {
                  _bexxxxxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxxxxx != null) {
                     try {
                        _bexxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxx));
                     } catch (Exception var29) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.TABBY_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip95
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip95)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxx));
                     } catch (Exception var28) {
                     }
                  }
               }

               BlockEntity _bexxxxxxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxxxxxx = null;
               if (_bexxxxxxxxx != null) {
                  _bnbtxxxxxxxxx = _bexxxxxxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxxxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxxxxxx != null) {
                  _bexxxxxxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxxxxxx != null) {
                     try {
                        _bexxxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxxx));
                     } catch (Exception var27) {
                     }
                  }
               }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_CAT_CARCASS.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip101
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip101)
                        : -1
                  )
                  == 1) {
               BlockPos _bpxx = BlockPos.containing(x, y, z);
               BlockState _bsxx = (new Object() {
                     public BlockState with(BlockState _bs, String _property, int _newValue) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                        return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                           ? (BlockState)_bs.setValue(_ip, _newValue)
                           : _bs;
                     }
                  })
                  .with(((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
               BlockState _bso = world.getBlockState(_bpxx);

               for (Property<?> _propertyOldxxxxxxxxxx : _bso.getProperties()) {
                  Property _propertyNew = _bsxx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxx.getName());
                  if (_propertyNew != null && _bsxx.getValue(_propertyNew) != null) {
                     try {
                        _bsxx = (BlockState)_bsxx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxx));
                     } catch (Exception var26) {
                     }
                  }
               }

               BlockEntity _bexxxxxxxxxx = world.getBlockEntity(_bpxx);
               CompoundTag _bnbtxxxxxxxxxx = null;
               if (_bexxxxxxxxxx != null) {
                  _bnbtxxxxxxxxxx = _bexxxxxxxxxx.saveWithFullMetadata(world.registryAccess());
                  _bexxxxxxxxxx.setRemoved();
               }

               world.setBlock(_bpxx, _bsxx, 3);
               if (_bnbtxxxxxxxxxx != null) {
                  _bexxxxxxxxxx = world.getBlockEntity(_bpxx);
                  if (_bexxxxxxxxxx != null) {
                     try {
                        _bexxxxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxxxx));
                     } catch (Exception var25) {
                     }
                  }
               }
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
