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

public class CatcarcassbleedingProcedure {
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
            world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLACK_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CALICO_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.JELLIE_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RED_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.TABBY_CAT_CARCASS.get()
               || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_CAT_CARCASS.get()
         )
         && (
               world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                  ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)
                  : -1
            )
            == 1
         && (
            (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
         )) {
         if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isBleeding") && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isDrained")) {
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
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLACK_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CALICO_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.JELLIE_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RED_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.TABBY_CAT_CARCASS.get()
                        || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_CAT_CARCASS.get()
                  )
                  && (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip62
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip62)
                           : -1
                     )
                     == 1) {
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip66
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip66)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOld : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOld));
                           } catch (Exception var52) {
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
                           } catch (Exception var51) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BLACK_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip72
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip72)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                           } catch (Exception var50) {
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
                           } catch (Exception var49) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip78
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip78)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                           } catch (Exception var48) {
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
                           } catch (Exception var47) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.CALICO_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip84
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip84)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                           } catch (Exception var46) {
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
                           } catch (Exception var45) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.JELLIE_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip90
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip90)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxx));
                           } catch (Exception var44) {
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
                           } catch (Exception var43) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip96
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip96)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxx));
                           } catch (Exception var42) {
                           }
                        }
                     }

                     BlockEntity _bexxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxx = null;
                     if (_bexxxxx != null) {
                        _bnbtxxxxx = _bexxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxx != null) {
                        _bexxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxx != null) {
                           try {
                              _bexxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxx));
                           } catch (Exception var41) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip102
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip102)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxx));
                           } catch (Exception var40) {
                           }
                        }
                     }

                     BlockEntity _bexxxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxxx = null;
                     if (_bexxxxxx != null) {
                        _bnbtxxxxxx = _bexxxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxxx != null) {
                        _bexxxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxxx != null) {
                           try {
                              _bexxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxx));
                           } catch (Exception var39) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.RED_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip108
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip108)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxx));
                           } catch (Exception var38) {
                           }
                        }
                     }

                     BlockEntity _bexxxxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxxxx = null;
                     if (_bexxxxxxx != null) {
                        _bnbtxxxxxxx = _bexxxxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxxxx != null) {
                        _bexxxxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxxxx != null) {
                           try {
                              _bexxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxx));
                           } catch (Exception var37) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip114
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip114)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxx));
                           } catch (Exception var36) {
                           }
                        }
                     }

                     BlockEntity _bexxxxxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxxxxx = null;
                     if (_bexxxxxxxx != null) {
                        _bnbtxxxxxxxx = _bexxxxxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxxxxx != null) {
                        _bexxxxxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxxxxx != null) {
                           try {
                              _bexxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxx));
                           } catch (Exception var35) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.TABBY_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip120
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip120)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxx));
                           } catch (Exception var34) {
                           }
                        }
                     }

                     BlockEntity _bexxxxxxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxxxxxx = null;
                     if (_bexxxxxxxxx != null) {
                        _bnbtxxxxxxxxx = _bexxxxxxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxxxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxxxxxx != null) {
                        _bexxxxxxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxxxxxx != null) {
                           try {
                              _bexxxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxxx));
                           } catch (Exception var33) {
                           }
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WHITE_CAT_CARCASS.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip126
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip126)
                              : -1
                        )
                        == 1) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockState _bsx = (new Object() {
                           public BlockState with(BlockState _bs, String _property, int _newValue) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                              return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                 ? (BlockState)_bs.setValue(_ip, _newValue)
                                 : _bs;
                           }
                        })
                        .with(((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).defaultBlockState(), "blockstate", 1);
                     BlockState _bso = world.getBlockState(_bpx);

                     for (Property<?> _propertyOldxxxxxxxxxx : _bso.getProperties()) {
                        Property _propertyNew = _bsx.getBlock().getStateDefinition().getProperty(_propertyOldxxxxxxxxxx.getName());
                        if (_propertyNew != null && _bsx.getValue(_propertyNew) != null) {
                           try {
                              _bsx = (BlockState)_bsx.setValue(_propertyNew, _bso.getValue(_propertyOldxxxxxxxxxx));
                           } catch (Exception var32) {
                           }
                        }
                     }

                     BlockEntity _bexxxxxxxxxx = world.getBlockEntity(_bpx);
                     CompoundTag _bnbtxxxxxxxxxx = null;
                     if (_bexxxxxxxxxx != null) {
                        _bnbtxxxxxxxxxx = _bexxxxxxxxxx.saveWithFullMetadata(world.registryAccess());
                        _bexxxxxxxxxx.setRemoved();
                     }

                     world.setBlock(_bpx, _bsx, 3);
                     if (_bnbtxxxxxxxxxx != null) {
                        _bexxxxxxxxxx = world.getBlockEntity(_bpx);
                        if (_bexxxxxxxxxx != null) {
                           try {
                              _bexxxxxxxxxx.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbtxxxxxxxxxx));
                           } catch (Exception var31) {
                           }
                        }
                     }
                  }

                  if (!world.isClientSide()) {
                     BlockPos _bpx = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                     BlockState _bsx = world.getBlockState(_bpx);
                     if (_blockEntityx != null) {
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isBleeding", false);
                        ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxx) {
                        _levelxxxx.sendBlockUpdated(_bpx, _bsx, _bsx, 3);
                     }
                  }

                  SmallInstantfillbloodgrateProcedure.execute(world, x, y, z);
                  if (world instanceof ServerLevel _levelxxxx) {
                     _levelxxxx.sendParticles(
                        (SimpleParticleType)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1
                     );
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
         }

         PlacebloodpuddleProcedure.execute(world, x, y, z);
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }
}
