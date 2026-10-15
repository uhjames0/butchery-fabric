package net.mcreator.butchery.procedures;

import net.mcreator.butchery.block.entity.PlayercorpseBlockEntity;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class PlaceplayercorpseProcedure {
   public static void onRightClickBlock(RightClickBlockShim event) {
      if (event.getHand() == InteractionHand.MAIN_HAND) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable RightClickBlockShim event, LevelAccessor world, double x, double y, double z, Entity entity) {
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
                  == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()) {
               if (event != null) {
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip29)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip35)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip41)
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip47)
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

                  ItemStack corpseStack = ItemStack.EMPTY;
                  if (entity instanceof LivingEntity livingEntity) {
                     if (livingEntity.getMainHandItem().getItem() == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()) {
                        corpseStack = livingEntity.getMainHandItem();
                     } else if (livingEntity.getOffhandItem().getItem() == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()) {
                        corpseStack = livingEntity.getOffhandItem();
                     }
                  }

                  String playerUUID = "";
                  String playerName = "";
                  boolean isBleeding = false;
                  boolean isDrained = false;
                  if (!corpseStack.isEmpty()) {
                     CustomData customData = (CustomData)corpseStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
                     CompoundTag corpseData = customData.copyTag();
                     if (corpseData.contains("PlayerUUID")) {
                        playerUUID = corpseData.getString("PlayerUUID").orElse("");
                     }

                     if (corpseData.contains("PlayerName")) {
                        playerName = corpseData.getString("PlayerName").orElse("");
                     }

                     if (corpseData.contains("isBleeding")) {
                        isBleeding = corpseData.getBoolean("isBleeding").orElse(false);
                     }

                     if (corpseData.contains("isDrained")) {
                        isDrained = corpseData.getBoolean("isDrained").orElse(false);
                     }
                  }

                  world.setBlock(
                     BlockPos.containing(x, y - 1.0, z),
                     (new Object() {
                           public BlockState with(BlockState _bs, Direction newValue) {
                              if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _ep
                                 && _ep.getPossibleValues().contains(newValue)) {
                                 return (BlockState)_bs.setValue(_ep, newValue);
                              } else {
                                 return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                       && _ep.getPossibleValues().contains(newValue.getAxis())
                                    ? (BlockState)_bs.setValue(_ep, newValue.getAxis())
                                    : _bs;
                              }
                           }
                        })
                        .with(
                           ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).defaultBlockState(),
                           (new Object() {
                                 public Direction getDirection(BlockState _bs) {
                                    if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _ep
                                       && _ep.getPossibleValues().toArray()[0] instanceof Direction) {
                                       return (Direction)_bs.getValue(_ep);
                                    } else {
                                       return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                             && _ep.getPossibleValues().toArray()[0] instanceof Axis
                                          ? Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE)
                                          : Direction.NORTH;
                                    }
                                 }
                              })
                              .getDirection(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                     3
                  );
                  int _valuexxxxxx = 1;
                  BlockPos _posxxxxxx = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                  if (_bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxx)) {
                     world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxx.setValue(_integerProp, _valuexxxxxx), 3);
                  }

                  if (!world.isClientSide()) {
                     BlockPos corpsePos = BlockPos.containing(x, y - 1.0, z);
                     if (world.getBlockEntity(corpsePos) instanceof PlayercorpseBlockEntity playerCorpseBlockEntity) {
                        if (!playerUUID.isEmpty()) {
                           playerCorpseBlockEntity.setPlayerUUID(playerUUID);
                        }

                        if (!playerName.isEmpty()) {
                           playerCorpseBlockEntity.setPlayerName(playerName);
                        }

                        ButcheryPersistentData.of(playerCorpseBlockEntity).putBoolean("isBleeding", isBleeding);
                        ButcheryPersistentData.of(playerCorpseBlockEntity).putBoolean("isDrained", isDrained);
                        playerCorpseBlockEntity.setChanged();
                        BlockState corpseBlockState = world.getBlockState(corpsePos);
                        if (world instanceof Level level) {
                           level.sendBlockUpdated(corpsePos, corpseBlockState, corpseBlockState, 3);
                        }
                     }
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

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                  }

                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.PLAYERCORPSE.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip118
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip118)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip120
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip120)
                           : -1
                     )
                     == 7
            )
            && (
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                     == ((Block)ButcheryModBlocks.PLAYERCORPSE.get()).asItem()
            )) {
            if (event != null) {
               event.setCanceled(true);
            }

            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }
         }
      }
   }
}
