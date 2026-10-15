package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class ConvertingskinProcedure {
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
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SKIN_RACK.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)
                     : -1
               )
               >= 1
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip5)
                     : -1
               )
               != 26
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip7)
                     : -1
               )
               != 27
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip9)
                     : -1
               )
               != 30) {
            if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.SALT.get()
               || (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:salt")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:salt")))) {
               if (world instanceof Level _level) {
                  if (!_level.isClientSide()) {
                     _level.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.place")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _level.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.place")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F,
                        false
                     );
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               (entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).shrink(1);
               int _value = 26;
               BlockPos _pos = BlockPos.containing(x, y, z);
               BlockState _bs = world.getBlockState(_pos);
               if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_value)) {
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, _value), 3);
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SKIN_RACK.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip24
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip24)
                     : -1
               )
               < 26) {
            if ((
                  (entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.SALT.get()
                     || (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:salt")))
                     || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .is(TagKey.create(Registries.ITEM, Identifier.parse("c:salt")))
               )
               && entity instanceof Player _player
               && !_player.level().isClientSide()) {
               _player.sendOverlayMessage(Component.literal("You've already applied salt to this skin."));
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.SKIN_RACK.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip35)
                     : -1
               )
               == 26) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.SPONGE.get()
               && ((CustomData)(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY))
                     .copyTag()
                     .getDoubleOr("spongeWetness", 0.0)
                  >= 1.0) {
               if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "skinWetted")) {
                  if (!world.isClientSide()) {
                     BlockPos _bp = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntity = world.getBlockEntity(_bp);
                     BlockState _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putBoolean("skinWetted", true);
                     }

                     if (world instanceof Level _levelx) {
                        _levelx.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof LivingEntity _entity) {
                     _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
                  }

                  if (world instanceof Level _levelx) {
                     if (!_levelx.isClientSide()) {
                        _levelx.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.fishing_bobber.splash")),
                           SoundSource.NEUTRAL,
                           0.3F,
                           1.0F
                        );
                     } else {
                        _levelx.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.fishing_bobber.splash")),
                           SoundSource.NEUTRAL,
                           0.3F,
                           1.0F,
                           false
                        );
                     }
                  }

                  int _value = 27;
                  BlockPos _pos = BlockPos.containing(x, y, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }

                  boolean var99;
                  label275: {
                     if (entity instanceof ServerPlayer _plr45) {
                        ServerLevel var68 = _plr45.level();
                        if (var68 instanceof ServerLevel
                           && _plr45.getAdvancements()
                              .getOrStartProgress(var68.getServer().getAdvancements().get(Identifier.parse("butchery:splish_splash")))
                              .isDone()) {
                           var99 = true;
                           break label275;
                        }
                     }

                     var99 = false;
                  }

                  if (!var99 && entity instanceof ServerPlayer _player) {
                     ServerLevel var81 = _player.level();
                     if (var81 instanceof ServerLevel) {
                        AdvancementHolder _adv = var81.getServer().getAdvancements().get(Identifier.parse("butchery:splish_splash"));
                        if (_adv != null) {
                           AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                           if (!_ap.isDone()) {
                              for (String criteria : _ap.getRemainingCriteria()) {
                                 _player.getAdvancements().award(_adv, criteria);
                              }
                           }
                        }
                     }
                  }

                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                     String _tagName = "spongeWetness";
                     double _tagValue = ((CustomData)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                              .getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY))
                           .copyTag()
                           .getDoubleOr("spongeWetness", 0.0)
                        - 1.0;
                     CustomData.update(
                        DataComponents.CUSTOM_DATA,
                        entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY,
                        tag -> tag.putDouble("spongeWetness", _tagValue)
                     );
                  }
               }
            } else if ((entity instanceof LivingEntity _livEntxxx ? _livEntxxx.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.RAG.get()
               && ((CustomData)(entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY)
                        .getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY))
                     .copyTag()
                     .getDoubleOr("ragWetness", 0.0)
                  >= 1.0
               && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "skinWetted")) {
               if (!world.isClientSide()) {
                  BlockPos _bpx = BlockPos.containing(x, y, z);
                  BlockEntity _blockEntityx = world.getBlockEntity(_bpx);
                  BlockState _bsxx = world.getBlockState(_bpx);
                  if (_blockEntityx != null) {
                     ButcheryPersistentData.of(_blockEntityx).putBoolean("skinWetted", true);
                  }

                  if (world instanceof Level _levelxx) {
                     _levelxx.sendBlockUpdated(_bpx, _bsxx, _bsxx, 3);
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (world instanceof Level _levelxx) {
                  if (!_levelxx.isClientSide()) {
                     _levelxx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.fishing_bobber.splash")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F
                     );
                  } else {
                     _levelxx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.fishing_bobber.splash")),
                        SoundSource.NEUTRAL,
                        0.3F,
                        1.0F,
                        false
                     );
                  }
               }

               int _valuex = 27;
               BlockPos _posx = BlockPos.containing(x, y, z);
               BlockState _bsxxx = world.getBlockState(_posx);
               if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuex)) {
                  world.setBlock(_posx, (BlockState)_bsxxx.setValue(_integerProp, _valuex), 3);
               }

               boolean var97;
               label238: {
                  if (entity instanceof ServerPlayer _plr61) {
                     ServerLevel var63 = _plr61.level();
                     if (var63 instanceof ServerLevel
                        && _plr61.getAdvancements()
                           .getOrStartProgress(var63.getServer().getAdvancements().get(Identifier.parse("butchery:splish_splash")))
                           .isDone()) {
                        var97 = true;
                        break label238;
                     }
                  }

                  var97 = false;
               }

               if (!var97 && entity instanceof ServerPlayer _playerx) {
                  ServerLevel var76 = _playerx.level();
                  if (var76 instanceof ServerLevel) {
                     AdvancementHolder _adv = var76.getServer().getAdvancements().get(Identifier.parse("butchery:splish_splash"));
                     if (_adv != null) {
                        AdvancementProgress _ap = _playerx.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _playerx.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }

               if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                  String _tagName = "ragWetness";
                  double _tagValue = ((CustomData)(entity instanceof LivingEntity _livEntxxxx ? _livEntxxxx.getMainHandItem() : ItemStack.EMPTY)
                           .getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY))
                        .copyTag()
                        .getDoubleOr("ragWetness", 0.0)
                     - 1.0;
                  CustomData.update(
                     DataComponents.CUSTOM_DATA,
                     entity instanceof LivingEntity _livEntxxxxx ? _livEntxxxxx.getMainHandItem() : ItemStack.EMPTY,
                     tag -> tag.putDouble("ragWetness", _tagValue)
                  );
               }
            }
         }
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }
}
