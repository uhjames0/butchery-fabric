package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.init.ButcheryVariants;
import net.mcreator.butchery.shim.ButcheryPersistentData;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickBlockShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class PlacecarcassonspitroastProcedure {
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
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip3)
                     : -1
               )
               == 0) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.DRAINED_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv1 ? _livEntv1.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv2 ? _livEntv2.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get()).asItem()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "mobCooking")) {
                  if (!world.isClientSide()) {
                     BlockPos _bp = BlockPos.containing(x, y, z);
                     BlockEntity _blockEntity = world.getBlockEntity(_bp);
                     BlockState _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        ButcheryPersistentData.of(_blockEntity).putBoolean("mobCooking", true);
                        ButcheryPersistentData.of(_blockEntity).putString("carcassVariant", ButcheryVariants.heldPigCarcassVariant(entity));
                     }

                     if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof Level _level) {
                     if (!_level.isClientSide()) {
                        _level.playSound(
                           null,
                           BlockPos.containing(x, y, z),
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.place")),
                           SoundSource.NEUTRAL,
                           1.0F,
                           1.0F
                        );
                     } else {
                        _level.playLocalSound(
                           x,
                           y,
                           z,
                           (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.place")),
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

                  int _value = 1;
                  BlockPos _pos = BlockPos.containing(x, y, z);
                  BlockState _bsx = world.getBlockState(_pos);
                  if (_bsx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                     && _integerProp.getPossibleValues().contains(_value)) {
                     world.setBlock(_pos, (BlockState)_bsx.setValue(_integerProp, _value), 3);
                  }

                  boolean var117;
                  label318: {
                     if (entity instanceof ServerPlayer _plr11) {
                        ServerLevel var96 = _plr11.level();
                        if (var96 instanceof ServerLevel
                           && _plr11.getAdvancements()
                              .getOrStartProgress(var96.getServer().getAdvancements().get(Identifier.parse("butchery:pigging_out")))
                              .isDone()) {
                           var117 = true;
                           break label318;
                        }
                     }

                     var117 = false;
                  }

                  if (!var117 && entity instanceof ServerPlayer _player) {
                     ServerLevel var105 = _player.level();
                     if (var105 instanceof ServerLevel) {
                        AdvancementHolder _adv = var105.getServer().getAdvancements().get(Identifier.parse("butchery:pigging_out"));
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

                  if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild) && entity instanceof Player _playerx) {
                     ItemStack _stktoremove;
                     ItemStack var113 = _stktoremove = entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY;
                     _playerx.getInventory()
                        .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _playerx.inventoryMenu.getCraftSlots());
                  }
               }
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv3 ? _livEntv3.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.COLD_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv4 ? _livEntv4.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.WARM_PIG_CARCASS.get()).asItem()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.sendOverlayMessage(Component.literal("You need to drain the carcass first.."));
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip23)
                     : -1
               )
               == 1) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv5 ? _livEntv5.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.COLD_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv6 ? _livEntv6.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_COLD_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv7 ? _livEntv7.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.WARM_PIG_CARCASS.get()).asItem()
               || (entity instanceof LivingEntity _livEntv8 ? _livEntv8.getMainHandItem() : ItemStack.EMPTY).getItem()
                  == ((Block)ButcheryModBlocks.DRAINED_WARM_PIG_CARCASS.get()).asItem()) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (entity instanceof Player _playerx && !_playerx.level().isClientSide()) {
                  _playerx.sendOverlayMessage(Component.literal("There's already a carcass on the rotisserie.."));
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip33)
                     : -1
               )
               == 2) {
            if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
               || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                  .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))) {
               if (event instanceof ICancellableEvent) {
                  event.setCanceled(true);
               }

               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               int _valuex = 0;
               BlockPos _posx = BlockPos.containing(x, y, z);
               BlockState _bsxx = world.getBlockState(_posx);
               if (_bsxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                  && _integerProp.getPossibleValues().contains(_valuex)) {
                  world.setBlock(_posx, (BlockState)_bsxx.setValue(_integerProp, _valuex), 3);
               }

               if (world instanceof Level _levelx) {
                  if (!_levelx.isClientSide()) {
                     _levelx.playSound(
                        null,
                        BlockPos.containing(x, y, z),
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                     );
                  } else {
                     _levelx.playLocalSound(
                        x,
                        y,
                        z,
                        (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.honey_block.place")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                     );
                  }
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_HAM.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_BELLY.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_LEG.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_LEG.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_LEG.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_LEG.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_LOIN.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.COOKED_PORK_SHOULDER.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.HOOF.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.HOOF.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.HOOF.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.HOOF.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.CRACKLING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.CRACKLING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel _levelxx) {
                  ItemEntity entityToSpawn = new ItemEntity(_levelxx, x, y, z, new ItemStack((ItemLike)ButcheryModItems.CRACKLING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _levelxx.addFreshEntity(entityToSpawn);
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == ButcheryModBlocks.WOODEN_SPIT_ROTISSERIE.get()
            && (
                  world.getBlockState(BlockPos.containing(x, y, z)).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip59
                     ? (Integer)world.getBlockState(BlockPos.containing(x, y, z)).getValue(_getip59)
                     : -1
               )
               == 3
            && (
               (entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                     .is(TagKey.create(Registries.ITEM, Identifier.parse("forge:cleaver")))
                  || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                     .is(TagKey.create(Registries.ITEM, Identifier.parse("c:cleaver")))
            )) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            int _valuexx = 0;
            BlockPos _posxx = BlockPos.containing(x, y, z);
            BlockState _bsxxx = world.getBlockState(_posxx);
            if (_bsxxx.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
               && _integerProp.getPossibleValues().contains(_valuexx)) {
               world.setBlock(_posxx, (BlockState)_bsxxx.setValue(_integerProp, _valuexx), 3);
            }

            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.break")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.sand.break")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            if (world instanceof ServerLevel _levelxxx) {
               ItemEntity entityToSpawn = new ItemEntity(_levelxxx, x, y, z, new ItemStack(Items.CHARCOAL));
               entityToSpawn.setPickUpDelay(10);
               _levelxxx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _levelxxx) {
               ItemEntity entityToSpawn = new ItemEntity(_levelxxx, x, y, z, new ItemStack(Items.CHARCOAL));
               entityToSpawn.setPickUpDelay(10);
               _levelxxx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _levelxxx) {
               ItemEntity entityToSpawn = new ItemEntity(_levelxxx, x, y, z, new ItemStack(Items.CHARCOAL));
               entityToSpawn.setPickUpDelay(10);
               _levelxxx.addFreshEntity(entityToSpawn);
            }
         }
      }
   }

   private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity != null ? ButcheryPersistentData.of(blockEntity).getBooleanOr(tag, false) : false;
   }
}
