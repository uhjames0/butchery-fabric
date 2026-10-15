package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.LivingDamageShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

public class GrantPlayertickadvancementsProcedure {
   public static void onEntityTick(LivingDamageShim event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable NeoEvent event, Entity entity) {
      if (entity != null && entity instanceof Player) {
         if (hasEntityInInventory(entity, new ItemStack((ItemLike)ButcheryModItems.RAW_BEEF_MINCE.get()))) {
            boolean var10000;
            label212: {
               if (entity instanceof ServerPlayer _plr2) {
                  ServerLevel _plr17 = _plr2.level();
                  if (_plr17 instanceof ServerLevel
                     && _plr2.getAdvancements()
                        .getOrStartProgress(_plr17.getServer().getAdvancements().get(Identifier.parse("butchery:bloodandgears")))
                        .isDone()) {
                     var10000 = true;
                     break label212;
                  }
               }

               var10000 = false;
            }

            if (var10000) {
               label205: {
                  if (entity instanceof ServerPlayer _plr3) {
                     ServerLevel _player = _plr3.level();
                     if (_player instanceof ServerLevel
                        && _plr3.getAdvancements()
                           .getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse("butchery:groundbreaking")))
                           .isDone()) {
                        var10000 = true;
                        break label205;
                     }
                  }

                  var10000 = false;
               }

               if (!var10000 && entity instanceof ServerPlayer _player) {
                  ServerLevel _ap = _player.level();
                  ServerLevel _adv = _ap instanceof ServerLevel ? _ap : null;
                  if (_adv instanceof ServerLevel) {
                     AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse("butchery:groundbreaking"));
                     if (_advx != null) {
                        AdvancementProgress _apx = _player.getAdvancements().getOrStartProgress(_advx);
                        if (!_apx.isDone()) {
                           for (String criteria : _apx.getRemainingCriteria()) {
                              _player.getAdvancements().award(_advx, criteria);
                           }
                        }
                     }
                  }
               }
            }
         } else if (hasEntityInInventory(entity, new ItemStack((ItemLike)ButcheryModItems.RAW_LAMB_MINCE.get()))) {
            boolean var51;
            label187: {
               if (entity instanceof ServerPlayer _plr6) {
                  ServerLevel var17 = _plr6.level();
                  if (var17 instanceof ServerLevel
                     && _plr6.getAdvancements()
                        .getOrStartProgress(var17.getServer().getAdvancements().get(Identifier.parse("butchery:bloodandgears")))
                        .isDone()) {
                     var51 = true;
                     break label187;
                  }
               }

               var51 = false;
            }

            if (var51) {
               label180: {
                  if (entity instanceof ServerPlayer _plr7) {
                     ServerLevel var26 = _plr7.level();
                     if (var26 instanceof ServerLevel
                        && _plr7.getAdvancements()
                           .getOrStartProgress(var26.getServer().getAdvancements().get(Identifier.parse("butchery:groundbreaking")))
                           .isDone()) {
                        var51 = true;
                        break label180;
                     }
                  }

                  var51 = false;
               }

               if (!var51 && entity instanceof ServerPlayer _playerx) {
                  ServerLevel var36 = _playerx.level();
                  if (var36 instanceof ServerLevel) {
                     AdvancementHolder _adv = var36.getServer().getAdvancements().get(Identifier.parse("butchery:groundbreaking"));
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
         } else if (hasEntityInInventory(entity, new ItemStack((ItemLike)ButcheryModItems.RAW_SAUSAGE.get()))) {
            boolean var53;
            label163: {
               if (entity instanceof ServerPlayer _plr10) {
                  ServerLevel var19 = _plr10.level();
                  if (var19 instanceof ServerLevel
                     && _plr10.getAdvancements()
                        .getOrStartProgress(var19.getServer().getAdvancements().get(Identifier.parse("butchery:the_missing_link")))
                        .isDone()) {
                     var53 = true;
                     break label163;
                  }
               }

               var53 = false;
            }

            if (!var53 && entity instanceof ServerPlayer _playerxx) {
               ServerLevel var28 = _playerxx.level();
               if (var28 instanceof ServerLevel) {
                  AdvancementHolder _adv = var28.getServer().getAdvancements().get(Identifier.parse("butchery:the_missing_link"));
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
         } else if (hasEntityInInventory(entity, new ItemStack((ItemLike)ButcheryModItems.RAW_BLOOD_SAUSAGE.get()))) {
            boolean var54;
            label146: {
               if (entity instanceof ServerPlayer _plr13) {
                  ServerLevel var21 = _plr13.level();
                  if (var21 instanceof ServerLevel
                     && _plr13.getAdvancements()
                        .getOrStartProgress(var21.getServer().getAdvancements().get(Identifier.parse("butchery:the_dark_sausage")))
                        .isDone()) {
                     var54 = true;
                     break label146;
                  }
               }

               var54 = false;
            }

            if (!var54 && entity instanceof ServerPlayer _playerxxx) {
               ServerLevel var30 = _playerxxx.level();
               if (var30 instanceof ServerLevel) {
                  AdvancementHolder _adv = var30.getServer().getAdvancements().get(Identifier.parse("butchery:the_dark_sausage"));
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
         } else if (hasEntityInInventory(entity, new ItemStack((ItemLike)ButcheryModItems.MEAT_SCRAPS.get()))) {
            boolean var55;
            label129: {
               if (entity instanceof ServerPlayer _plr16) {
                  ServerLevel var23 = _plr16.level();
                  if (var23 instanceof ServerLevel
                     && _plr16.getAdvancements()
                        .getOrStartProgress(var23.getServer().getAdvancements().get(Identifier.parse("butchery:bloodandgears")))
                        .isDone()) {
                     var55 = true;
                     break label129;
                  }
               }

               var55 = false;
            }

            if (var55) {
               label122: {
                  if (entity instanceof ServerPlayer _plr17) {
                     ServerLevel var48 = _plr17.level();
                     ServerLevel var32 = var48 instanceof ServerLevel ? var48 : null;
                     if (var32 instanceof ServerLevel
                        && _plr17.getAdvancements()
                           .getOrStartProgress(var32.getServer().getAdvancements().get(Identifier.parse("butchery:a_ruff_meal")))
                           .isDone()) {
                        var55 = true;
                        break label122;
                     }
                  }

                  var55 = false;
               }

               if (!var55 && entity instanceof ServerPlayer _playerxxxx) {
                  ServerLevel var40 = _playerxxxx.level();
                  if (var40 instanceof ServerLevel) {
                     AdvancementHolder _adv = var40.getServer().getAdvancements().get(Identifier.parse("butchery:a_ruff_meal"));
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
            }
         }
      }
   }

   private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
      return entity instanceof Player player ? player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack)) : false;
   }
}
