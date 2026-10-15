package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.TagValueInput;
import org.jetbrains.annotations.Nullable;

public class AxolotlbleedingProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null
         && (
            world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PINK_AXOLOTL_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLUE_AXOLOTL_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_AXOLOTL_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CYAN_AXOLOTL_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GOLD_AXOLOTL_CARCASS.get()
         )
         && (
               world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip11)
                  : -1
            )
            == 1
         && (
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
         )
         && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isBleeding")
         && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               ButcheryPersistentData.of(_blockEntity).putBoolean("isBleeding", true);
            }

            if (world instanceof Level _level) {
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!(Boolean)ButcheryconfigConfiguration.INSTANT_BLEED.get()) {
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }
         } else if ((Boolean)ButcheryconfigConfiguration.INSTANT_BLEED.get()) {
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.player.attack.sweep")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }

            if (world instanceof Level _levelxxx) {
               if (!_levelxxx.isClientSide()) {
                  _levelxxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelxxx.playLocalSound(
                     x,
                     y,
                     z,
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.hit")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F,
                     false
                  );
               }
            }

            if ((
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PINK_AXOLOTL_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLUE_AXOLOTL_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_AXOLOTL_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CYAN_AXOLOTL_CARCASS.get()
                     || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GOLD_AXOLOTL_CARCASS.get()
               )
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip38
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip38)
                        : -1
                  )
                  == 1) {
               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PINK_AXOLOTL_CARCASS.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = (new Object() {
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                           return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                              ? (BlockState)_bs.setValue(_ip, _newValue)
                              : _bs;
                        }
                     })
                     .with(((Block)ButcheryModBlocks.DRAINED_PINK_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOld : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                        } catch (Exception var29) {
                        }
                     }
                  }

                  BlockEntity _be = world.getBlockEntity(_bpx);
                  CompoundTag _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata(world.registryAccess());
                     _be.setRemoved();
                  }

                  world.setBlock(_bpx, _bsx, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bpx);
                     if (_be != null) {
                        try {
                           _be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
                        } catch (Exception var28) {
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                     _bso = world.getBlockState(_bpx);
                     if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                     }
                  }
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLUE_AXOLOTL_CARCASS.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = (new Object() {
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                           return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                              ? (BlockState)_bs.setValue(_ip, _newValue)
                              : _bs;
                        }
                     })
                     .with(((Block)ButcheryModBlocks.DRAINED_BLUE_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                        } catch (Exception var27) {
                        }
                     }
                  }

                  BlockEntity _bex = world.getBlockEntity(_bpx);
                  CompoundTag _bnbtx = null;
                  if (_bex != null) {
                     _bnbtx = _bex.saveWithFullMetadata(world.registryAccess());
                     _bex.setRemoved();
                  }

                  world.setBlock(_bpx, _bsx, 3);
                  if (_bnbtx != null) {
                     _bex = world.getBlockEntity(_bpx);
                     if (_bex != null) {
                        try {
                           _bex.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtx));
                        } catch (Exception var26) {
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxx = world.getBlockEntity(_bpx);
                     _bso = world.getBlockState(_bpx);
                     if (_blockEntityxx != null) {
                        ButcheryPersistentData.of(_blockEntityxx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityxx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                     }
                  }
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BROWN_AXOLOTL_CARCASS.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = (new Object() {
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                           return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                              ? (BlockState)_bs.setValue(_ip, _newValue)
                              : _bs;
                        }
                     })
                     .with(((Block)ButcheryModBlocks.DRAINED_BROWN_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                        } catch (Exception var25) {
                        }
                     }
                  }

                  BlockEntity _bexx = world.getBlockEntity(_bpx);
                  CompoundTag _bnbtxx = null;
                  if (_bexx != null) {
                     _bnbtxx = _bexx.saveWithFullMetadata(world.registryAccess());
                     _bexx.setRemoved();
                  }

                  world.setBlock(_bpx, _bsx, 3);
                  if (_bnbtxx != null) {
                     _bexx = world.getBlockEntity(_bpx);
                     if (_bexx != null) {
                        try {
                           _bexx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxx));
                        } catch (Exception var24) {
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxx = world.getBlockEntity(_bpx);
                     _bso = world.getBlockState(_bpx);
                     if (_blockEntityxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                     }
                  }
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CYAN_AXOLOTL_CARCASS.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = (new Object() {
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                           return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                              ? (BlockState)_bs.setValue(_ip, _newValue)
                              : _bs;
                        }
                     })
                     .with(((Block)ButcheryModBlocks.DRAINED_CYAN_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                        } catch (Exception var23) {
                        }
                     }
                  }

                  BlockEntity _bexxx = world.getBlockEntity(_bpx);
                  CompoundTag _bnbtxxx = null;
                  if (_bexxx != null) {
                     _bnbtxxx = _bexxx.saveWithFullMetadata(world.registryAccess());
                     _bexxx.setRemoved();
                  }

                  world.setBlock(_bpx, _bsx, 3);
                  if (_bnbtxxx != null) {
                     _bexxx = world.getBlockEntity(_bpx);
                     if (_bexxx != null) {
                        try {
                           _bexxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxx));
                        } catch (Exception var22) {
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpx);
                     _bso = world.getBlockState(_bpx);
                     if (_blockEntityxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                     }
                  }
               } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.GOLD_AXOLOTL_CARCASS.get()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockState _bsx = (new Object() {
                        public BlockState with(BlockState _bs, String _property, int _newValue) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                           return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                              ? (BlockState)_bs.setValue(_ip, _newValue)
                              : _bs;
                        }
                     })
                     .with(((Block)ButcheryModBlocks.DRAINED_GOLD_AXOLOTL_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                  BlockState _bso = world.getBlockState(_bpx);

                  for (Property<?> _propertyOldxxxx : _bso.getProperties()) {
                     Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                     if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                        try {
                           _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                        } catch (Exception var21) {
                        }
                     }
                  }

                  BlockEntity _bexxxx = world.getBlockEntity(_bpx);
                  CompoundTag _bnbtxxxx = null;
                  if (_bexxxx != null) {
                     _bnbtxxxx = _bexxxx.saveWithFullMetadata(world.registryAccess());
                     _bexxxx.setRemoved();
                  }

                  world.setBlock(_bpx, _bsx, 3);
                  if (_bnbtxxxx != null) {
                     _bexxxx = world.getBlockEntity(_bpx);
                     if (_bexxxx != null) {
                        try {
                           _bexxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxx));
                        } catch (Exception var20) {
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpx);
                     _bso = world.getBlockState(_bpx);
                     if (_blockEntityxxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bso, _bso, 3);
                     }
                  }
               }

               InstantfillbloodgrateProcedure.execute(world, x, y, z);
               if (world instanceof ServerLevel _levelxxxx) {
                  _levelxxxx.sendParticles((SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
               }

               ButcheryMod.queueServerWork(
                  1,
                  () -> {
                     if (world instanceof ServerLevel _levelxxxxx) {
                        _levelxxxxx.sendParticles(
                           (SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1
                        );
                     }
                  }
               );
               ButcheryMod.queueServerWork(
                  2,
                  () -> {
                     if (world instanceof ServerLevel _levelxxxxx) {
                        _levelxxxxx.sendParticles(
                           (SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1
                        );
                     }
                  }
               );
               ButcheryMod.queueServerWork(
                  3,
                  () -> {
                     if (world instanceof ServerLevel _levelxxxxx) {
                        _levelxxxxx.sendParticles(
                           (SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1
                        );
                     }
                  }
               );
            }
         }

         PlacebloodpuddleProcedure.execute(world, x, y, z);
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }
}
