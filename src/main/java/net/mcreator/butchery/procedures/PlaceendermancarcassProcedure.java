package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class PlaceendermancarcassProcedure {
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
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() != ButcheryModItems.ENDERMAN.get()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() != ButcheryModItems.ENDERMAN.get()) {
               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ButcheryModItems.DRAINED_ENDERMAN.get()
                  || (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ButcheryModItems.DRAINED_ENDERMAN.get()) {
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip69)
                                 : -1
                           )
                           == 0) {
                        int _value = 1;
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_value)) {
                           world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
                        }

                        if (world instanceof Level _level) {
                           if (!_level.isClientSide()) {
                              _level.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _level.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip75
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip75)
                                 : -1
                           )
                           == 1) {
                        int _valuex = 2;
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip81)
                                 : -1
                           )
                           == 2) {
                        int _valuexx = 3;
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip87
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip87)
                                 : -1
                           )
                           == 4) {
                        int _valuexxx = 5;
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip93
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip93)
                                 : -1
                           )
                           == 5) {
                        int _valuexxxx = 6;
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip99
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip99)
                                 : -1
                           )
                           == 6) {
                        int _valuexxxxx = 7;
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
                     }

                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.HANGING_DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                     if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get() && world instanceof Level _levelxxxxxx) {
                        if (!_levelxxxxxx.isClientSide()) {
                           _levelxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxx.playLocalSound(
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
                        BlockState _bsxxxxxx = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           ButcheryPersistentData.of(_blockEntity).putBoolean("isDrained", true);
                        }

                        if (world instanceof Level _levelxxxxxxx) {
                           _levelxxxxxxx.sendBlockUpdated(_bp, _bsxxxxxx, _bsxxxxxx, 3);
                        }
                     }

                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
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
                     int _valuexxxxxx = 1;
                     BlockPos _posxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxx);
                     if (_bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxx)) {
                        world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxxx.setValue(_integerProp, _valuexxxxxx), 3);
                     }

                     if (world instanceof Level _levelxxxxxxx) {
                        if (!_levelxxxxxxx.isClientSide()) {
                           _levelxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxx.playLocalSound(
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
                     int _valuexxxxxxx = 2;
                     BlockPos _posxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxx = world.getBlockState(_posxxxxxxx);
                     if (_bsxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxx)) {
                        world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxxx.setValue(_integerProp, _valuexxxxxxx), 3);
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip29)
                              : -1
                        )
                        == 2) {
                     int _valuexxxxxxxx = 3;
                     BlockPos _posxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxx = world.getBlockState(_posxxxxxxxx);
                     if (_bsxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxx)) {
                        world.setBlock(_posxxxxxxxx, (BlockState)_bsxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxx), 3);
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip35)
                              : -1
                        )
                        == 4) {
                     int _valuexxxxxxxxx = 5;
                     BlockPos _posxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxx = world.getBlockState(_posxxxxxxxxx);
                     if (_bsxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxx, (BlockState)_bsxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxx), 3);
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip41)
                              : -1
                        )
                        == 5) {
                     int _valuexxxxxxxxxx = 6;
                     BlockPos _posxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxx);
                     if (_bsxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxx), 3);
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip47)
                              : -1
                        )
                        == 6) {
                     int _valuexxxxxxxxxxx = 7;
                     BlockPos _posxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxx)) {
                        world.setBlock(_posxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxx), 3);
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
                  }

                  world.setBlock(
                     BlockPos.containing(x, y - 1.0, z),
                     blockStateWithDirection(
                        ((Block)ButcheryModBlocks.HANGING_ENDERMAN_CARCASS.get()).defaultBlockState(),
                        getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                     ),
                     3
                  );
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                     && world instanceof Level _levelxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxx.playLocalSound(
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
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip116
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip116)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip118
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip118)
                           : -1
                     )
                     == 7
            )) {
            if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.ENDERMAN.get()
               || (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.ENDERMAN.get()
               || (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ButcheryModItems.DRAINED_ENDERMAN.get()
               || (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ButcheryModItems.DRAINED_ENDERMAN.get()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               world.destroyBlock(BlockPos.containing(x, y, z), false);
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }
            }
         } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() != ButcheryModItems.ENDERMAN.get()
            && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem() != ButcheryModItems.ENDERMAN.get()) {
            if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ButcheryModItems.DRAINED_ENDERMAN.get()
               || (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ButcheryModItems.DRAINED_ENDERMAN.get()) {
               if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.NORTH) {
                  if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                              - 1
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.SOUTH) {
                  if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                              + 1
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.WEST) {
                  if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX()
                              - 1,
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.EAST) {
                  if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX()
                              + 1,
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.UP) {
                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                  }

                  if (entity.getDirection() == Direction.NORTH) {
                     if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 + 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.SOUTH) {
                     if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 + 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.WEST) {
                     if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 + 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY()
                              + 1,
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.level()
                     .clip(
                        new ClipContext(
                           entity.getEyePosition(1.0F),
                           entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                           net.minecraft.world.level.ClipContext.Block.OUTLINE,
                           Fluid.NONE,
                           entity
                        )
                     )
                     .getDirection()
                  == Direction.DOWN) {
                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                  }

                  if (entity.getDirection() == Direction.NORTH) {
                     if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 - 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.SOUTH) {
                     if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 - 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.WEST) {
                     if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                                 x,
                                 y,
                                 z,
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F,
                                 false
                              );
                           }
                        }

                        world.setBlock(
                           new BlockPos(
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getX(),
                              entity.level()
                                    .clip(
                                       new ClipContext(
                                          entity.getEyePosition(1.0F),
                                          entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                          net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                          Fluid.NONE,
                                          entity
                                       )
                                    )
                                    .getBlockPos()
                                    .getY()
                                 - 1,
                              entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getZ()
                           ),
                           blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                           3
                        );
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }
                  } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entity.level()
                                 .clip(
                                    new ClipContext(
                                       entity.getEyePosition(1.0F),
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                       net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                       Fluid.NONE,
                                       entity
                                    )
                                 )
                                 .getBlockPos()
                                 .getY()
                              - 1,
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(((Block)ButcheryModBlocks.DRAINED_ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.DRAINED_ENDERMAN.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.NORTH) {
            if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

               world.setBlock(
                  new BlockPos(
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                        - 1
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.SOUTH) {
            if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

               world.setBlock(
                  new BlockPos(
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                        + 1
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.WEST) {
            if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

               world.setBlock(
                  new BlockPos(
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX()
                        - 1,
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.EAST) {
            if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
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

               world.setBlock(
                  new BlockPos(
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX()
                        + 1,
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getY(),
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.UP) {
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (entity.getDirection() == Direction.NORTH) {
               if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           + 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.SOUTH) {
               if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           + 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.WEST) {
               if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           + 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               world.setBlock(
                  new BlockPos(
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY()
                        + 1,
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
         } else if (entity.level()
               .clip(
                  new ClipContext(
                     entity.getEyePosition(1.0F),
                     entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                     net.minecraft.world.level.ClipContext.Block.OUTLINE,
                     Fluid.NONE,
                     entity
                  )
               )
               .getDirection()
            == Direction.DOWN) {
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (entity.getDirection() == Direction.NORTH) {
               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           - 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.SOUTH),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.SOUTH) {
               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           - 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.NORTH),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.WEST) {
               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F,
                           false
                        );
                     }
                  }

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getX(),
                        entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY()
                           - 1,
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.EAST),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               world.setBlock(
                  new BlockPos(
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getX(),
                     entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY()
                        - 1,
                     entity.level()
                        .clip(
                           new ClipContext(
                              entity.getEyePosition(1.0F),
                              entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(100.0)),
                              net.minecraft.world.level.ClipContext.Block.OUTLINE,
                              Fluid.NONE,
                              entity
                           )
                        )
                        .getBlockPos()
                        .getZ()
                  ),
                  blockStateWithDirection(((Block)ButcheryModBlocks.ENDERMAN_CARCASS.get()).defaultBlockState(), Direction.WEST),
                  3
               );
               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModItems.ENDERMAN.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
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
