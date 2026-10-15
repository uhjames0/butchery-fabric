package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickItemShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class BlowupballoonProcedure {
   public static void onRightClickItem(RightClickItemShim event) {
      if (event.getHand() == event.getEntity().getUsedItemHand()) {
         execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(null, world, x, y, z, entity);
   }

   private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.BAMBOO.asItem()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            boolean var80;
            label193: {
               if (entity instanceof ServerPlayer _plr4) {
                  ServerLevel var38 = _plr4.level();
                  if (var38 instanceof ServerLevel
                     && _plr4.getAdvancements()
                        .getOrStartProgress(var38.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets")))
                        .isDone()) {
                     var80 = true;
                     break label193;
                  }
               }

               var80 = false;
            }

            if (!var80) {
               if (entity instanceof ServerPlayer _player) {
                  ServerLevel var48 = _player.level();
                  if (var48 instanceof ServerLevel) {
                     AdvancementHolder _adv = var48.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets"));
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

               label175: {
                  if (entity instanceof ServerPlayer _plr6) {
                     ServerLevel var50 = _plr6.level();
                     if (var50 instanceof ServerLevel
                        && _plr6.getAdvancements()
                           .getOrStartProgress(var50.getServer().getAdvancements().get(Identifier.parse("butchery:breathless")))
                           .isDone()) {
                        var80 = true;
                        break label175;
                     }
                  }

                  var80 = false;
               }

               if (!var80 && entity instanceof ServerPlayer _playerx) {
                  ServerLevel var60 = _playerx.level();
                  if (var60 instanceof ServerLevel) {
                     AdvancementHolder _adv = var60.getServer().getAdvancements().get(Identifier.parse("butchery:breathless"));
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
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).asItem()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack11 = new ItemStack((ItemLike)ButcheryModItems.GREEN_FROG_BALLOON.get()).copy();
                     _setstack11.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
                     if (_entity instanceof Player _playerxx) {
                        _playerxx.getInventory().setChanged();
                     }
                  }
               }
            );
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.BAMBOO.asItem()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            boolean var78;
            label234: {
               if (entity instanceof ServerPlayer _plr17) {
                  ServerLevel var35 = _plr17.level();
                  if (var35 instanceof ServerLevel
                     && _plr17.getAdvancements()
                        .getOrStartProgress(var35.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets")))
                        .isDone()) {
                     var78 = true;
                     break label234;
                  }
               }

               var78 = false;
            }

            if (!var78) {
               if (entity instanceof ServerPlayer _playerxx) {
                  ServerLevel var44 = _playerxx.level();
                  if (var44 instanceof ServerLevel) {
                     AdvancementHolder _adv = var44.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets"));
                     if (_adv != null) {
                        AdvancementProgress _ap = _playerxx.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _playerxx.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }

               label216: {
                  if (entity instanceof ServerPlayer _plr19) {
                     ServerLevel var46 = _plr19.level();
                     if (var46 instanceof ServerLevel
                        && _plr19.getAdvancements()
                           .getOrStartProgress(var46.getServer().getAdvancements().get(Identifier.parse("butchery:breathless")))
                           .isDone()) {
                        var78 = true;
                        break label216;
                     }
                  }

                  var78 = false;
               }

               if (!var78 && entity instanceof ServerPlayer _playerxxx) {
                  ServerLevel var57 = _playerxxx.level();
                  if (var57 instanceof ServerLevel) {
                     AdvancementHolder _adv = var57.getServer().getAdvancements().get(Identifier.parse("butchery:breathless"));
                     if (_adv != null) {
                        AdvancementProgress _ap = _playerxxx.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _playerxxx.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).asItem()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack24 = new ItemStack((ItemLike)ButcheryModItems.ORANGE_FROG_BALLOON.get()).copy();
                     _setstack24.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack24);
                     if (_entity instanceof Player _playerxxxx) {
                        _playerxxxx.getInventory().setChanged();
                     }
                  }
               }
            );
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
            && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.BAMBOO.asItem()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            boolean var76;
            label277: {
               if (entity instanceof ServerPlayer _plr30) {
                  ServerLevel _plr32 = _plr30.level();
                  if (_plr32 instanceof ServerLevel
                     && _plr30.getAdvancements()
                        .getOrStartProgress(_plr32.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets")))
                        .isDone()) {
                     var76 = true;
                     break label277;
                  }
               }

               var76 = false;
            }

            if (!var76) {
               if (entity instanceof ServerPlayer _playerxxxx) {
                  ServerLevel _playerxxxxx = _playerxxxx.level();
                  if (_playerxxxxx instanceof ServerLevel) {
                     AdvancementHolder _adv = _playerxxxxx.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets"));
                     if (_adv != null) {
                        AdvancementProgress _ap = _playerxxxx.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _playerxxxx.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }

               label259: {
                  if (entity instanceof ServerPlayer _plr32) {
                     ServerLevel var57 = _plr32.level();
                     ServerLevel var42 = var57 instanceof ServerLevel ? var57 : null;
                     if (var42 instanceof ServerLevel
                        && _plr32.getAdvancements()
                           .getOrStartProgress(var42.getServer().getAdvancements().get(Identifier.parse("butchery:breathless")))
                           .isDone()) {
                        var76 = true;
                        break label259;
                     }
                  }

                  var76 = false;
               }

               if (!var76 && entity instanceof ServerPlayer _playerxxxxx) {
                  ServerLevel var58 = _playerxxxxx.level();
                  ServerLevel var54 = var58 instanceof ServerLevel ? var58 : null;
                  if (var54 instanceof ServerLevel) {
                     AdvancementHolder _adv = var54.getServer().getAdvancements().get(Identifier.parse("butchery:breathless"));
                     if (_adv != null) {
                        AdvancementProgress _ap = _playerxxxxx.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                           for (String criteria : _ap.getRemainingCriteria()) {
                              _playerxxxxx.getAdvancements().award(_adv, criteria);
                           }
                        }
                     }
                  }
               }
            }

            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:inflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntxx ? _livEntxx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ((Block)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).asItem()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack37 = new ItemStack((ItemLike)ButcheryModItems.GRAY_FROG_BALLOON.get()).copy();
                     _setstack37.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack37);
                     if (_entity instanceof Player _playerxxxxxx) {
                        _playerxxxxxx.getInventory().setChanged();
                     }
                  }
               }
            );
         }
      }
   }
}
