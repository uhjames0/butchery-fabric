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

public class PlacefrogcarcassProcedure {
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
                  != ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()) {
               if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
                  && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()) {
                  if ((entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        != ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
                     && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        != ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()) {
                     if ((entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                           != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
                        && (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                           != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()) {
                        if ((entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                           && (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                              != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()) {
                           if ((entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                              || (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()) {
                              if (event instanceof ICancellableEvent) {
                                 event.setCanceled(true);
                              }

                              if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                                 world.setBlock(
                                    BlockPos.containing(x, y - 1.0, z),
                                    blockStateWithDirection(
                                       ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).defaultBlockState(),
                                       getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                                    ),
                                    3
                                 );
                                 int _value = 1;
                                 BlockPos _pos = BlockPos.containing(x, y - 1.0, z);
                                 BlockState _bs = world.getBlockState(_pos);
                                 if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                                    && _integerProp.getPossibleValues().contains(_value)) {
                                    world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
                                 }

                                 if (entity instanceof LivingEntity _entity) {
                                    _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                                 }

                                 if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                                    && world instanceof Level _level) {
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

                                 if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)
                                    && (
                                       (entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                                .getItem()
                                             == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                                          || (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                                                .getItem()
                                             == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                                    )
                                    && entity instanceof Player _player) {
                                    ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get());
                                    _player.getInventory()
                                       .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                                 }
                              }

                              if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                                 && (
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip330
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip330)
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
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip336
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip336)
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
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip342
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip342)
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
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip348
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip348)
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
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip354
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip354)
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
                                       world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip360
                                          ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip360)
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
                           }
                        } else {
                           if (event instanceof ICancellableEvent) {
                              event.setCanceled(true);
                           }

                           if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                              world.setBlock(
                                 BlockPos.containing(x, y - 1.0, z),
                                 blockStateWithDirection(
                                    ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).defaultBlockState(),
                                    getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                                 ),
                                 3
                              );
                              int _valuexxxxxxx = 1;
                              BlockPos _posxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                              BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                              if (_bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                                 && _integerProp.getPossibleValues().contains(_valuexxxxxxx)) {
                                 world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxx.setValue(_integerProp, _valuexxxxxxx), 3);
                              }

                              if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                                 && world instanceof Level _levelxxxxxxx) {
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

                              if (entity instanceof LivingEntity _entity) {
                                 _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
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

                              if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)
                                 && (
                                    (entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                          == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                                       || (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                          == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                                 )
                                 && entity instanceof Player _player) {
                                 ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get());
                                 _player.getInventory()
                                    .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                              }
                           }

                           if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                              && (
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip272
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip272)
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
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip278
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip278)
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
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip284
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip284)
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
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip290
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip290)
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
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip296
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip296)
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
                                    world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip302
                                       ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip302)
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
                        }
                     } else {
                        if (event instanceof ICancellableEvent) {
                           event.setCanceled(true);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                           world.setBlock(
                              BlockPos.containing(x, y - 1.0, z),
                              blockStateWithDirection(
                                 ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).defaultBlockState(),
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

                           if (!world.isClientSide()) {
                              BlockPos _bpxx = BlockPos.containing(x, y - 1.0, z);
                              BlockEntity _blockEntityxx = world.getBlockEntity(_bpxx);
                              _bsxxxxxxxxxxxxxx = world.getBlockState(_bpxx);
                              if (_blockEntityxx != null) {
                                 ButcheryPersistentData.of(_blockEntityxx).putBoolean("isDrained", true);
                              }

                              if (world instanceof Level _levelxxxxxxxxxxxxxxx) {
                                 _levelxxxxxxxxxxxxxxx.sendBlockUpdated(_bpxx, _bsxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxx, 3);
                              }
                           }

                           if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                              if ((entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                    != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
                                 && (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                    != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()) {
                                 if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                       != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                                    && (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                       != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()) {
                                    if ((
                                          (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                                   .getItem()
                                                == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                                             || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx
                                                      ? _livEntxxxxxxxxxxxxxx.getOffhandItem()
                                                      : ItemStack.EMPTY)
                                                   .getItem()
                                                == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                                       )
                                       && entity instanceof Player _player) {
                                       ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get());
                                       _player.getInventory()
                                          .clearOrCountMatchingItems(
                                             p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                          );
                                    }
                                 } else if (entity instanceof Player _player) {
                                    ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get());
                                    _player.getInventory()
                                       .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                                 }
                              } else if (entity instanceof Player _player) {
                                 ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get());
                                 _player.getInventory()
                                    .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                              }
                           }
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                           && (
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip214
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip214)
                                    : -1
                              )
                              == 0) {
                           int _valuexxxxxxxxxxxxxxx = 1;
                           BlockPos _posxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxx)) {
                              world.setBlock(_posxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxx), 3);
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxx.playLocalSound(
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
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip220
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip220)
                                    : -1
                              )
                              == 1) {
                           int _valuexxxxxxxxxxxxxxxx = 2;
                           BlockPos _posxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxx)) {
                              world.setBlock(_posxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxx), 3);
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxxx.playLocalSound(
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
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip226
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip226)
                                    : -1
                              )
                              == 2) {
                           int _valuexxxxxxxxxxxxxxxxx = 3;
                           BlockPos _posxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxx)) {
                              world.setBlock(_posxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxx), 3);
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxxxx.playLocalSound(
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
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip232
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip232)
                                    : -1
                              )
                              == 4) {
                           int _valuexxxxxxxxxxxxxxxxxx = 5;
                           BlockPos _posxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxx)) {
                              world.setBlock(_posxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxx), 3);
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip238
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip238)
                                    : -1
                              )
                              == 5) {
                           int _valuexxxxxxxxxxxxxxxxxxx = 6;
                           BlockPos _posxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxx)) {
                              world.setBlock(_posxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxx), 3);
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                                 world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip244
                                    ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip244)
                                    : -1
                              )
                              == 6) {
                           int _valuexxxxxxxxxxxxxxxxxxxx = 7;
                           BlockPos _posxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                           BlockState _bsxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxx);
                           if (_bsxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                              && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxx)) {
                              world.setBlock(
                                 _posxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxx), 3
                              );
                           }

                           if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxx) {
                              if (!_levelxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                                 _levelxxxxxxxxxxxxxxxxxxxx.playSound(
                                    null,
                                    BlockPos.containing(x, y, z),
                                    (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                    SoundSource.NEUTRAL,
                                    0.5F,
                                    1.0F
                                 );
                              } else {
                                 _levelxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                     }
                  } else {
                     if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                     }

                     if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                        int _valuexxxxxxxxxxxxxxxxxxxxx = 1;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxx), 3
                           );
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                           && world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                                 SoundSource.NEUTRAL,
                                 1.0F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

                        if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                           && (
                              (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                    == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
                                 || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                    == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
                           )
                           && entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ORANGE_FROG_CARCASS.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip146
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip146)
                                 : -1
                           )
                           == 0) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxx = 1;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxx), 3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip152
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip152)
                                 : -1
                           )
                           == 1) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxxx = 2;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxx), 3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip158
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip158)
                                 : -1
                           )
                           == 2) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxxxx = 3;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxx), 3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip164
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip164)
                                 : -1
                           )
                           == 4) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxxxxx = 5;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxxxxx,
                              (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxx),
                              3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip170
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip170)
                                 : -1
                           )
                           == 5) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxxxxxx = 6;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxx),
                              3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip176
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip176)
                                 : -1
                           )
                           == 6) {
                        int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxx = 7;
                        BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                        BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                        if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                           && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                           world.setBlock(
                              _posxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                              (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxx),
                              3
                           );
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                                 null,
                                 BlockPos.containing(x, y, z),
                                 (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                                 SoundSource.NEUTRAL,
                                 0.5F,
                                 1.0F
                              );
                           } else {
                              _levelxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                  }
               } else {
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxx = 1;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                        && world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

                     if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                        && (
                           (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
                              || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                                 == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
                        )
                        && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.GREEN_FROG_CARCASS.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                     && (
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip89
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip89)
                              : -1
                        )
                        == 0) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 1;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip95
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip95)
                              : -1
                        )
                        == 1) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 2;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip101
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip101)
                              : -1
                        )
                        == 2) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 3;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip107
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip107)
                              : -1
                        )
                        == 4) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 5;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip113
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip113)
                              : -1
                        )
                        == 5) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 6;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip119
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip119)
                              : -1
                        )
                        == 6) {
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 7;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                              SoundSource.NEUTRAL,
                              0.5F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
               }
            } else {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                  world.setBlock(
                     BlockPos.containing(x, y - 1.0, z),
                     blockStateWithDirection(
                        ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).defaultBlockState(),
                        getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                     ),
                     3
                  );
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 1;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.HOOK.get()
                     && world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

                  if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                     && (
                        (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
                           || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                              == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
                     )
                     && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.GRAY_FROG_CARCASS.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }

               if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                  && (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip32
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip32)
                           : -1
                     )
                     == 0) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 1;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip38
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip38)
                           : -1
                     )
                     == 1) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 2;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip44
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip44)
                           : -1
                     )
                     == 2) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 3;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip50
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip50)
                           : -1
                     )
                     == 4) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 5;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip56
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip56)
                           : -1
                     )
                     == 5) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 6;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip62
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip62)
                           : -1
                     )
                     == 6) {
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 7;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:rope")),
                           SoundSource.NEUTRAL,
                           0.5F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip366
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip366)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip368
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip368)
                           : -1
                     )
                     == 7
            )) {
            if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                     .getItem()
                  == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                     .getItem()
                  == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               world.destroyBlock(BlockPos.containing(x, y, z), false);
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.METAL_TRAY.get()) {
            if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()) {
               if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                  && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                     != ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()) {
                  if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()) {
                     if (event instanceof ICancellableEvent) {
                        event.setCanceled(true);
                     }

                     world.setBlock(
                        BlockPos.containing(x, y, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                     int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 2;
                     BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                        world.setBlock(
                           _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                           (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                           3
                        );
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                              null,
                              BlockPos.containing(x, y, z),
                              (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                              SoundSource.NEUTRAL,
                              1.0F,
                              1.0F
                           );
                        } else {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

                     if (!world.isClientSide()) {
                        BlockPos _bpxxx = BlockPos.containing(x, y - 1.0, z);
                        BlockEntity _blockEntityxxx = world.getBlockEntity(_bpxxx);
                        _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxx);
                        if (_blockEntityxxx != null) {
                           ButcheryPersistentData.of(_blockEntityxxx).putBoolean("isDrained", true);
                        }

                        if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                           _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(
                              _bpxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, 3
                           );
                        }
                     }

                     if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                        && (
                           (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                                    .getItem()
                                 == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                              || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                                    .getItem()
                                 == ((Block)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get()).asItem()
                        )
                        && entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_ORANGE_FROG_CARCASS.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               } else {
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  world.setBlock(
                     BlockPos.containing(x, y, z),
                     blockStateWithDirection(
                        ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).defaultBlockState(),
                        getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                     ),
                     3
                  );
                  int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 2;
                  BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
                  BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                     world.setBlock(
                        _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                        (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                        3
                     );
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

                  if (!world.isClientSide()) {
                     BlockPos _bpxxxx = BlockPos.containing(x, y - 1.0, z);
                     BlockEntity _blockEntityxxxx = world.getBlockEntity(_bpxxxx);
                     _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxx);
                     if (_blockEntityxxxx != null) {
                        ButcheryPersistentData.of(_blockEntityxxxx).putBoolean("isDrained", true);
                     }

                     if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                        _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(
                           _bpxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, 3
                        );
                     }
                  }

                  if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                     && (
                        (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                              == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                           || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                                 .getItem()
                              == ((Block)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get()).asItem()
                     )
                     && entity instanceof Player _player) {
                     ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GREEN_FROG_CARCASS.get());
                     _player.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                  }
               }
            } else {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               world.setBlock(
                  BlockPos.containing(x, y, z),
                  blockStateWithDirection(
                     ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).defaultBlockState(),
                     getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                  ),
                  3
               );
               int _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = 2;
               BlockPos _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = BlockPos.containing(x, y, z);
               BlockState _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
               if (_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)) {
                  world.setBlock(
                     _posxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx,
                     (BlockState)_bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx),
                     3
                  );
               }

               if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  if (!_levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.isClientSide()) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.chain.hit")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.playLocalSound(
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

               if (!world.isClientSide()) {
                  BlockPos _bpxxxxx = BlockPos.containing(x, y - 1.0, z);
                  BlockEntity _blockEntityxxxxx = world.getBlockEntity(_bpxxxxx);
                  _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = world.getBlockState(_bpxxxxx);
                  if (_blockEntityxxxxx != null) {
                     ButcheryPersistentData.of(_blockEntityxxxxx).putBoolean("isDrained", true);
                  }

                  if (world instanceof Level _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                     _levelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sendBlockUpdated(
                        _bpxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, _bsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, 3
                     );
                  }
               }

               if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)
                  && (
                     (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get()).asItem()
                  )
                  && entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_GRAY_FROG_CARCASS.get());
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
