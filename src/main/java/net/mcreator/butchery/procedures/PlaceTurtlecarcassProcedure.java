package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class PlaceTurtlecarcassProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
            || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip5)
                        : -1
                  )
                  != 3
               && (
                     world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7
                        ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip7)
                        : -1
                  )
                  != 7) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).asItem()) {
               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).asItem()
                  && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).asItem()) {
                  if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()) {
                     if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                     }

                     if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                        int _value = 8;
                        BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_value)) {
                           world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
                        }

                        if (entity instanceof LivingEntity _entity) {
                           _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get() && world instanceof Level _level) {
                           if (!_level.isClientSide()) {
                              _level.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _level.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        if (!world.isClientSide()) {
                           BlockPos _bp = BlockPos.containing(x, y - 1.0, z);
                           BlockEntity _blockEntity = world.getBlockEntity(_bp);
                           _bs = world.getBlockState(_bp);
                           if (_blockEntity != null) {
                              ButcheryPersistentData.of(_blockEntity).putBoolean("isDrained", true);
                           }

                           if (world instanceof Level _levelx) {
                              _levelx.sendBlockUpdated(_bp, _bs, _bs, 3);
                           }
                        }

                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  }
               } else {
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip70
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip70)
                                 : -1
                           )
                           == 0) {
                        int _valuex = 1;
                        BlockPos _posx = BlockPos.containing(x, y, z);
                        BlockState _bsx = world.getBlockState(_posx);
                        if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuex)) {
                           world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _valuex), 3);
                        }

                        if (world instanceof Level _levelx) {
                           if (!_levelx.isClientSide()) {
                              _levelx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip76
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip76)
                                 : -1
                           )
                           == 1) {
                        int _valuexx = 2;
                        BlockPos _posxx = BlockPos.containing(x, y, z);
                        BlockState _bsxx = world.getBlockState(_posxx);
                        if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexx)) {
                           world.setBlock(_posxx, (BlockState)_bsxx.setValue(_integerProp, _valuexx), 3);
                        }

                        if (world instanceof Level _levelxx) {
                           if (!_levelxx.isClientSide()) {
                              _levelxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip82
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip82)
                                 : -1
                           )
                           == 2) {
                        int _valuexxx = 3;
                        BlockPos _posxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxx = world.getBlockState(_posxxx);
                        if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxx)) {
                           world.setBlock(_posxxx, (BlockState)_bsxxx.setValue(_integerProp, _valuexxx), 3);
                        }

                        if (world instanceof Level _levelxxx) {
                           if (!_levelxxx.isClientSide()) {
                              _levelxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip88
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip88)
                                 : -1
                           )
                           == 4) {
                        int _valuexxxx = 5;
                        BlockPos _posxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxx = world.getBlockState(_posxxxx);
                        if (_bsxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxx)) {
                           world.setBlock(_posxxxx, (BlockState)_bsxxxx.setValue(_integerProp, _valuexxxx), 3);
                        }

                        if (world instanceof Level _levelxxxx) {
                           if (!_levelxxxx.isClientSide()) {
                              _levelxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip94
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip94)
                                 : -1
                           )
                           == 5) {
                        int _valuexxxxx = 6;
                        BlockPos _posxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxx = world.getBlockState(_posxxxxx);
                        if (_bsxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxx)) {
                           world.setBlock(_posxxxxx, (BlockState)_bsxxxxx.setValue(_integerProp, _valuexxxxx), 3);
                        }

                        if (world instanceof Level _levelxxxxx) {
                           if (!_levelxxxxx.isClientSide()) {
                              _levelxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip100
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip100)
                                 : -1
                           )
                           == 6) {
                        int _valuexxxxxx = 7;
                        BlockPos _posxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                        if (_bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxx)) {
                           world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxx.setValue(_integerProp, _valuexxxxxx), 3);
                        }

                        if (world instanceof Level _levelxxxxxx) {
                           if (!_levelxxxxxx.isClientSide()) {
                              _levelxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F,
                                 false
                              );
                           }
                        }
                     }

                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                     int _valuexxxxxxx = 17;
                     BlockPos _posxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                     BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                     if (_bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxx)) {
                        world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxx.setValue(_integerProp, _valuexxxxxxx), 3);
                     }

                     if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get() && world instanceof Level _levelxxxxxxx) {
                        if (!_levelxxxxxxx.isClientSide()) {
                           _levelxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (!world.isClientSide()) {
                        BlockPos _bpx = BlockPos.containing(x, y - 1.0, z);
                        BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                        _bsxxxxxxx = world.getBlockState(_bpx);
                        if (_blockEntityx != null) {
                           ButcheryPersistentData.of(_blockEntityx).putBoolean("isDrained", true);
                        }

                        if (world instanceof Level _levelxxxxxxxx) {
                           _levelxxxxxxxx.sendBlockUpdated(_bpx, _bsxxxxxxx, _bsxxxxxxx, 3);
                        }
                     }

                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               }
            } else {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip17)
                              : -1
                        )
                        == 0) {
                     int _valuexxxxxxxx = 1;
                     BlockPos _posxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxx = world.getBlockState(_posxxxxxxxx);
                     if (_bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxx)) {
                        world.setBlock(_posxxxxxxxx, (BlockState)_bsxxxxxxxx.setValue(_integerProp, _valuexxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxx) {
                        if (!_levelxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)
                              : -1
                        )
                        == 1) {
                     int _valuexxxxxxxxx = 2;
                     BlockPos _posxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxx = world.getBlockState(_posxxxxxxxxx);
                     if (_bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxx, (BlockState)_bsxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxxx) {
                        if (!_levelxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip29)
                              : -1
                        )
                        == 2) {
                     int _valuexxxxxxxxxx = 3;
                     BlockPos _posxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxx);
                     if (_bsxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxx, (BlockState)_bsxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip35)
                              : -1
                        )
                        == 4) {
                     int _valuexxxxxxxxxxx = 5;
                     BlockPos _posxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip41)
                              : -1
                        )
                        == 5) {
                     int _valuexxxxxxxxxxxx = 6;
                     BlockPos _posxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip47)
                              : -1
                        )
                        == 6) {
                     int _valuexxxxxxxxxxxxx = 7;
                     BlockPos _posxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F,
                              false
                           );
                        }
                     }
                  }

                  world.setBlock(
                     BlockPos.containing(x, y - 1.0, z),
                     blockStateWithDirection(
                        ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).defaultBlockState(),
                        getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                     ),
                     3
                  );
                  int _valuexxxxxxxxxxxxxx = 1;
                  BlockPos _posxxxxxxxxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxx)) {
                     world.setBlock(_posxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxx), 3);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                     && world instanceof Level _levelxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                  }

                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.TURTLE_CARCASS.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip136
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip136)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip138
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip138)
                           : -1
                     )
                     == 7
            )
            && (
               (entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.TURTLE_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TURTLE_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()
            )) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
         }
      }
   }

   private static Direction getDirectionFromBlockState(BlockState blockState) {
      if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class) {
         return (Direction)blockState.getValue(ep);
      } else {
         return blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty ep && ep.getValueClass() == Axis.class
            ? Direction.fromAxisAndDirection((Axis)blockState.getValue(ep), AxisDirection.POSITIVE)
            : Direction.NORTH;
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
}
