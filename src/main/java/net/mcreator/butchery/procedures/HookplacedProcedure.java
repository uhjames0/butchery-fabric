package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class HookplacedProcedure {
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
         && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ((Block)ButcheryModBlocks.HOOK.get()).asItem()) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.IRON_CHAIN) {
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
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _level.playLocalSound(
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

                  if (world instanceof Level _levelx) {
                     if (!_levelx.isClientSide()) {
                        _levelx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelx.playLocalSound(
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
                     blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 2),
                        Direction.NORTH
                     ),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
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
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world instanceof Level _levelxx) {
                     if (!_levelxx.isClientSide()) {
                        _levelxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxx.playLocalSound(
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

                  if (world instanceof Level _levelxxx) {
                     if (!_levelxxx.isClientSide()) {
                        _levelxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxx.playLocalSound(
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
                     blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 2),
                        Direction.SOUTH
                     ),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
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
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world instanceof Level _levelxxxx) {
                     if (!_levelxxxx.isClientSide()) {
                        _levelxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxx.playLocalSound(
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

                  if (world instanceof Level _levelxxxxx) {
                     if (!_levelxxxxx.isClientSide()) {
                        _levelxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxx.playLocalSound(
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
                     blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 2),
                        Direction.WEST
                     ),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
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
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world instanceof Level _levelxxxxxx) {
                     if (!_levelxxxxxx.isClientSide()) {
                        _levelxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxx.playLocalSound(
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

                  if (world instanceof Level _levelxxxxxxx) {
                     if (!_levelxxxxxxx.isClientSide()) {
                        _levelxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxx.playLocalSound(
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
                     blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 2),
                        Direction.EAST
                     ),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
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
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (entity.getDirection() == Direction.NORTH) {
                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxx) {
                        if (!_levelxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxx.playLocalSound(
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

                     if (world instanceof Level _levelxxxxxxxxx) {
                        if (!_levelxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxx.playLocalSound(
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(
                           (new Object() {
                                 public BlockState with(BlockState _bs, String _property, int _newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                    return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                       ? (BlockState)_bs.setValue(_ip, _newValue)
                                       : _bs;
                                 }
                              })
                              .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 1),
                           Direction.SOUTH
                        ),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.getDirection() == Direction.SOUTH) {
                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxx.playLocalSound(
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

                     if (world instanceof Level _levelxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxx.playLocalSound(
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(
                           (new Object() {
                                 public BlockState with(BlockState _bs, String _property, int _newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                    return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                       ? (BlockState)_bs.setValue(_ip, _newValue)
                                       : _bs;
                                 }
                              })
                              .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 1),
                           Direction.NORTH
                        ),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.getDirection() == Direction.WEST) {
                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world instanceof Level _levelxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxx.playLocalSound(
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

                     if (world instanceof Level _levelxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxx.playLocalSound(
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

                     world.setBlock(
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                       entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.NONE,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        blockStateWithDirection(
                           (new Object() {
                                 public BlockState with(BlockState _bs, String _property, int _newValue) {
                                    Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                    return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                       ? (BlockState)_bs.setValue(_ip, _newValue)
                                       : _bs;
                                 }
                              })
                              .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 1),
                           Direction.EAST
                        ),
                        3
                     );
                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else if (entity.getDirection() == Direction.EAST && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
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

                  if (world instanceof Level _levelxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxx.playLocalSound(
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

                  world.setBlock(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
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
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.NONE,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     ),
                     blockStateWithDirection(
                        (new Object() {
                              public BlockState with(BlockState _bs, String _property, int _newValue) {
                                 Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                                 return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue)
                                    ? (BlockState)_bs.setValue(_ip, _newValue)
                                    : _bs;
                              }
                           })
                           .with(((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState(), "blockstate", 1),
                        Direction.WEST
                     ),
                     3
                  );
                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.IRON_CHAIN) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            if (entity.getDirection() == Direction.NORTH) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = ((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);

               for (Property<?> _propertyOld : _bso.getProperties()) {
                  Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                  if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                     } catch (Exception var21) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
               if (world instanceof Level _levelxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxx.playLocalSound(
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

               Direction _dir = Direction.SOUTH;
               BlockPos _pos = BlockPos.containing(x, y, z);
               _bso = world.getBlockState(_pos);
               if (_bso.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                  world.setBlock(_pos, (BlockState)_bso.setValue(_dp, _dir), 3);
               } else if (_bso.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                  && _ap.getPossibleValues().contains(_dir.getAxis())) {
                  world.setBlock(_pos, (BlockState)_bso.setValue(_ap, _dir.getAxis()), 3);
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            } else if (entity.getDirection() == Direction.EAST) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = ((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);

               for (Property<?> _propertyOldx : _bso.getProperties()) {
                  Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldx.getName());
                  if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldx));
                     } catch (Exception var20) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxx.playLocalSound(
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

               Direction _dirx = Direction.WEST;
               BlockPos _posx = BlockPos.containing(x, y, z);
               _bso = world.getBlockState(_posx);
               if (_bso.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dirx)) {
                  world.setBlock(_posx, (BlockState)_bso.setValue(_dp, _dirx), 3);
               } else if (_bso.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                  && _ap.getPossibleValues().contains(_dirx.getAxis())) {
                  world.setBlock(_posx, (BlockState)_bso.setValue(_ap, _dirx.getAxis()), 3);
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            } else if (entity.getDirection() == Direction.SOUTH) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = ((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);

               for (Property<?> _propertyOldxx : _bso.getProperties()) {
                  Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxx.getName());
                  if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxx));
                     } catch (Exception var19) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxx.playLocalSound(
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

               Direction _dirxx = Direction.NORTH;
               BlockPos _posxx = BlockPos.containing(x, y, z);
               _bso = world.getBlockState(_posxx);
               if (_bso.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dirxx)) {
                  world.setBlock(_posxx, (BlockState)_bso.setValue(_dp, _dirxx), 3);
               } else if (_bso.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                  && _ap.getPossibleValues().contains(_dirxx.getAxis())) {
                  world.setBlock(_posxx, (BlockState)_bso.setValue(_ap, _dirxx.getAxis()), 3);
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            } else if (entity.getDirection() == Direction.WEST) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockState _bs = ((Block)ButcheryModBlocks.HOOK.get()).defaultBlockState();
               BlockState _bso = world.getBlockState(_bp);

               for (Property<?> _propertyOldxxx : _bso.getProperties()) {
                  Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOldxxx.getName());
                  if (_propertyNew != null && _bs.getValue(_propertyNew) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOldxxx));
                     } catch (Exception var18) {
                     }
                  }
               }

               world.setBlock(_bp, _bs, 3);
               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

               Direction _dirxxx = Direction.EAST;
               BlockPos _posxxx = BlockPos.containing(x, y, z);
               _bso = world.getBlockState(_posxxx);
               if (_bso.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dirxxx)) {
                  world.setBlock(_posxxx, (BlockState)_bso.setValue(_dp, _dirxxx), 3);
               } else if (_bso.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap
                  && _ap.getPossibleValues().contains(_dirxxx.getAxis())) {
                  world.setBlock(_posxxx, (BlockState)_bso.setValue(_ap, _dirxxx.getAxis()), 3);
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.HOOK.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }
            }
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
}
