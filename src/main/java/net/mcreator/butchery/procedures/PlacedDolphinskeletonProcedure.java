package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class PlacedDolphinskeletonProcedure {
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
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip15)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip21)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip27)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip33)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip39
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip39)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip45)
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

                  if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()
                     || (entity instanceof LivingEntity _livEntx ? _livEntx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           (new Object() {
                                 public BlockState with(BlockState _bs, String _property, int _newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                    return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                       ? (BlockState)_bs.setValue(_ip, _newValue)
                                       : _bs;
                                 }
                              })
                              .with(((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).defaultBlockState(), "blockstate", 1),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                     if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                     }

                     if (world instanceof Level _levelxxxxxx) {
                        if (!_levelxxxxxx.isClientSide()) {
                           _levelxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxx.playLocalSound(
                              x,
                              y,
                              z,
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F,
                              false
                           );
                        }
                     }

                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)
                        && (
                           (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()
                              || (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()
                        )
                        && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DOLPHIN_SKELETON.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip68
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip68)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip70
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip70)
                           : -1
                     )
                     == 7
            )
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.DOLPHIN_SKELETON.get()).asItem()) {
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
