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

public class PlacecatcarcassProcedure {
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
            if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxxx ? _livEntxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxxx ? _livEntxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxxx ? _livEntxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxxx ? _livEntxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxxx ? _livEntxxxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxxx ? _livEntxxxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxxx ? _livEntxxxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntxx ? _livEntxx.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
               && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                  != ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()) {
               if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()) {
                  if (event instanceof ICancellableEvent) {
                     event.setCanceled(true);
                  }

                  if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
                        && (
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip288
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip288)
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip294
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip294)
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip300
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip300)
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip306
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip306)
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip312
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip312)
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
                              world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip318
                                 ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip318)
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

                     if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                        || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                 ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                 : ItemStack.EMPTY)
                              .getItem()
                           == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()) {
                        world.setBlock(
                           BlockPos.containing(x, y - 1.0, z),
                           blockStateWithDirection(
                              ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).defaultBlockState(),
                              getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                           ),
                           3
                        );
                     }

                     int _valuexxxxxx = 1;
                     BlockPos _posxxxxxx = BlockPos.containing(x, y - 1.0, z);
                     BlockState _bsxxxxxx = world.getBlockState(_posxxxxxx);
                     if (_bsxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxx)) {
                        world.setBlock(_posxxxxxx, (BlockState)_bsxxxxxx.setValue(_integerProp, _valuexxxxxx), 3);
                     }

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
                        _bsxxxxxx = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           ButcheryPersistentData.of(_blockEntity).putBoolean("isDrained", true);
                        }

                        if (world instanceof Level _levelxxxxxxx) {
                           _levelxxxxxxx.sendBlockUpdated(_bp, _bsxxxxxx, _bsxxxxxx, 3);
                        }
                     }

                     if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                    : ItemStack.EMPTY)
                                 .getItem()
                              != ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                           && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                    : ItemStack.EMPTY)
                                 .getItem()
                              != ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()) {
                           if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                       : ItemStack.EMPTY)
                                    .getItem()
                                 != ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                              && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                       : ItemStack.EMPTY)
                                    .getItem()
                                 != ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()) {
                              if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                          : ItemStack.EMPTY)
                                       .getItem()
                                    != ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                                 && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                          : ItemStack.EMPTY)
                                       .getItem()
                                    != ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()) {
                                 if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                             : ItemStack.EMPTY)
                                          .getItem()
                                       != ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                                    && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                             : ItemStack.EMPTY)
                                          .getItem()
                                       != ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()) {
                                    if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                : ItemStack.EMPTY)
                                             .getItem()
                                          != ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                                       && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                : ItemStack.EMPTY)
                                             .getItem()
                                          != ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()) {
                                       if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                   : ItemStack.EMPTY)
                                                .getItem()
                                             != ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                                          && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                   : ItemStack.EMPTY)
                                                .getItem()
                                             != ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()) {
                                          if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                      : ItemStack.EMPTY)
                                                   .getItem()
                                                != ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                                             && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                      : ItemStack.EMPTY)
                                                   .getItem()
                                                != ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()) {
                                             if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                         : ItemStack.EMPTY)
                                                      .getItem()
                                                   != ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
                                                && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                         : ItemStack.EMPTY)
                                                      .getItem()
                                                   != ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()) {
                                                if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                            : ItemStack.EMPTY)
                                                         .getItem()
                                                      != ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                                                   && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                            : ItemStack.EMPTY)
                                                         .getItem()
                                                      != ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()) {
                                                   if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                               ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                               : ItemStack.EMPTY)
                                                            .getItem()
                                                         != ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                                                      && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                               ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                               : ItemStack.EMPTY)
                                                            .getItem()
                                                         != ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()) {
                                                      if ((
                                                            (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                                        : ItemStack.EMPTY)
                                                                     .getItem()
                                                                  == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                                                               || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                        ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                                        : ItemStack.EMPTY)
                                                                     .getItem()
                                                                  == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                                                         )
                                                         && entity instanceof Player _player) {
                                                         ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get());
                                                         _player.getInventory()
                                                            .clearOrCountMatchingItems(
                                                               p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                            );
                                                      }
                                                   } else if (entity instanceof Player _player) {
                                                      ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get());
                                                      _player.getInventory()
                                                         .clearOrCountMatchingItems(
                                                            p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                         );
                                                   }
                                                } else if (entity instanceof Player _player) {
                                                   ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get());
                                                   _player.getInventory()
                                                      .clearOrCountMatchingItems(
                                                         p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                      );
                                                }
                                             } else if (entity instanceof Player _player) {
                                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get());
                                                _player.getInventory()
                                                   .clearOrCountMatchingItems(
                                                      p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                   );
                                             }
                                          } else if (entity instanceof Player _player) {
                                             ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get());
                                             _player.getInventory()
                                                .clearOrCountMatchingItems(
                                                   p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                );
                                          }
                                       } else if (entity instanceof Player _player) {
                                          ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get());
                                          _player.getInventory()
                                             .clearOrCountMatchingItems(
                                                p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                             );
                                       }
                                    } else if (entity instanceof Player _player) {
                                       ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get());
                                       _player.getInventory()
                                          .clearOrCountMatchingItems(
                                             p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                          );
                                    }
                                 } else if (entity instanceof Player _player) {
                                    ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get());
                                    _player.getInventory()
                                       .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                                 }
                              } else if (entity instanceof Player _player) {
                                 ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get());
                                 _player.getInventory()
                                    .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                              }
                           } else if (entity instanceof Player _player) {
                              ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get());
                              _player.getInventory()
                                 .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                           }
                        } else if (entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip57
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip57)
                              : -1
                        )
                        == 0) {
                     int _valuexxxxxxx = 1;
                     BlockPos _posxxxxxxx = BlockPos.containing(x, y, z);
                     BlockState _bsxxxxxxx = world.getBlockState(_posxxxxxxx);
                     if (_bsxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_valuexxxxxxx)) {
                        world.setBlock(_posxxxxxxx, (BlockState)_bsxxxxxxx.setValue(_integerProp, _valuexxxxxxx), 3);
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip63
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip63)
                              : -1
                        )
                        == 1) {
                     int _valuexxxxxxxx = 2;
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip69)
                              : -1
                        )
                        == 2) {
                     int _valuexxxxxxxxx = 3;
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip75
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip75)
                              : -1
                        )
                        == 4) {
                     int _valuexxxxxxxxxx = 5;
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip81)
                              : -1
                        )
                        == 5) {
                     int _valuexxxxxxxxxxx = 6;
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
                           world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip87
                              ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip87)
                              : -1
                        )
                        == 6) {
                     int _valuexxxxxxxxxxxx = 7;
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
                  }

                  if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  } else if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx
                              ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                              : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
                     || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                           .getItem()
                        == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()) {
                     world.setBlock(
                        BlockPos.containing(x, y - 1.0, z),
                        blockStateWithDirection(
                           ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).defaultBlockState(),
                           getDirectionFromBlockState(world.getBlockState(BlockPos.containing(x, y, z)))
                        ),
                        3
                     );
                  }

                  int _valuexxxxxxxxxxxxx = 1;
                  BlockPos _posxxxxxxxxxxxxx = BlockPos.containing(x, y - 1.0, z);
                  BlockState _bsxxxxxxxxxxxxx = world.getBlockState(_posxxxxxxxxxxxxx);
                  if (_bsxxxxxxxxxxxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_valuexxxxxxxxxxxxx)) {
                     world.setBlock(_posxxxxxxxxxxxxx, (BlockState)_bsxxxxxxxxxxxxx.setValue(_integerProp, _valuexxxxxxxxxxxxx), 3);
                  }

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

                  if (!(entity instanceof Player _plrx && _plrx.getAbilities().instabuild)) {
                     if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem() : ItemStack.EMPTY)
                              .getItem()
                           != ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
                        && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxx ? _livEntxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem() : ItemStack.EMPTY)
                              .getItem()
                           != ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()) {
                        if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                    : ItemStack.EMPTY)
                                 .getItem()
                              != ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
                           && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxx
                                    ? _livEntxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                    : ItemStack.EMPTY)
                                 .getItem()
                              != ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()) {
                           if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                       : ItemStack.EMPTY)
                                    .getItem()
                                 != ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                              && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx
                                       ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                       : ItemStack.EMPTY)
                                    .getItem()
                                 != ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()) {
                              if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                          : ItemStack.EMPTY)
                                       .getItem()
                                    != ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
                                 && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                          ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                          : ItemStack.EMPTY)
                                       .getItem()
                                    != ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()) {
                                 if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                             : ItemStack.EMPTY)
                                          .getItem()
                                       != ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
                                    && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                             : ItemStack.EMPTY)
                                          .getItem()
                                       != ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()) {
                                    if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                : ItemStack.EMPTY)
                                             .getItem()
                                          != ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
                                       && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                : ItemStack.EMPTY)
                                             .getItem()
                                          != ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()) {
                                       if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                   : ItemStack.EMPTY)
                                                .getItem()
                                             != ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
                                          && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                   ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                   : ItemStack.EMPTY)
                                                .getItem()
                                             != ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()) {
                                          if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                      : ItemStack.EMPTY)
                                                   .getItem()
                                                != ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
                                             && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                      ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                      : ItemStack.EMPTY)
                                                   .getItem()
                                                != ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()) {
                                             if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                         : ItemStack.EMPTY)
                                                      .getItem()
                                                   != ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
                                                && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                         ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                         : ItemStack.EMPTY)
                                                      .getItem()
                                                   != ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()) {
                                                if ((entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                            : ItemStack.EMPTY)
                                                         .getItem()
                                                      != ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
                                                   && (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                            ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                            : ItemStack.EMPTY)
                                                         .getItem()
                                                      != ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()) {
                                                   if ((
                                                         (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                     ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                                                                     : ItemStack.EMPTY)
                                                                  .getItem()
                                                               == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
                                                            || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                                                     ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                                                                     : ItemStack.EMPTY)
                                                                  .getItem()
                                                               == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
                                                      )
                                                      && entity instanceof Player _player) {
                                                      ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.WHITE_CAT_CARCASS.get());
                                                      _player.getInventory()
                                                         .clearOrCountMatchingItems(
                                                            p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                         );
                                                   }
                                                } else if (entity instanceof Player _player) {
                                                   ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.TABBY_CAT_CARCASS.get());
                                                   _player.getInventory()
                                                      .clearOrCountMatchingItems(
                                                         p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                      );
                                                }
                                             } else if (entity instanceof Player _player) {
                                                ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get());
                                                _player.getInventory()
                                                   .clearOrCountMatchingItems(
                                                      p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                   );
                                             }
                                          } else if (entity instanceof Player _player) {
                                             ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.RED_CAT_CARCASS.get());
                                             _player.getInventory()
                                                .clearOrCountMatchingItems(
                                                   p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                                );
                                          }
                                       } else if (entity instanceof Player _player) {
                                          ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get());
                                          _player.getInventory()
                                             .clearOrCountMatchingItems(
                                                p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                             );
                                       }
                                    } else if (entity instanceof Player _player) {
                                       ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get());
                                       _player.getInventory()
                                          .clearOrCountMatchingItems(
                                             p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots()
                                          );
                                    }
                                 } else if (entity instanceof Player _player) {
                                    ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.JELLIE_CAT_CARCASS.get());
                                    _player.getInventory()
                                       .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                                 }
                              } else if (entity instanceof Player _player) {
                                 ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.CALICO_CAT_CARCASS.get());
                                 _player.getInventory()
                                    .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                              }
                           } else if (entity instanceof Player _player) {
                              ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get());
                              _player.getInventory()
                                 .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                           }
                        } else if (entity instanceof Player _player) {
                           ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.BLACK_CAT_CARCASS.get());
                           _player.getInventory()
                              .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                        }
                     } else if (entity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get());
                        _player.getInventory()
                           .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
                     }
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.ROPE.get()
            && (
               (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip474
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip474)
                           : -1
                     )
                     == 3
                  || (
                        world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip476
                           ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip476)
                           : -1
                     )
                     == 7
            )
            && (
               (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_ALL_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BLACK_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_BRITISH_SHORTHAIR_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_CALICO_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_JELLIE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_PERSIAN_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_SIAMESE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_TABBY_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.WHITE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_WHITE_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RAGDOLL_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.RED_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getMainHandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
                  || (entity instanceof LivingEntity _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                           ? _livEntxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getOffhandItem()
                           : ItemStack.EMPTY)
                        .getItem()
                     == ((Block)ButcheryModBlocks.DRAINED_RED_CAT_CARCASS.get()).asItem()
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
