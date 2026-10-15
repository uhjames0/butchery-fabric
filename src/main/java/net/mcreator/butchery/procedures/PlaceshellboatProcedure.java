package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModEntities;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickItemShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult.Type;
import org.jetbrains.annotations.Nullable;

public class PlaceshellboatProcedure {
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
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()
            && entity.level()
                  .clip(
                     new ClipContext(
                        entity.getEyePosition(1.0F),
                        entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                        net.minecraft.world.level.ClipContext.Block.OUTLINE,
                        Fluid.SOURCE_ONLY,
                        entity
                     )
                  )
                  .getType()
               == Type.BLOCK) {
            if (world.getFluidState(
                     new BlockPos(
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.SOURCE_ONLY,
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
                                 Fluid.SOURCE_ONLY,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getY(),
                        entity.level()
                           .clip(
                              new ClipContext(
                                 entity.getEyePosition(1.0F),
                                 entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)),
                                 net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                 Fluid.SOURCE_ONLY,
                                 entity
                              )
                           )
                           .getBlockPos()
                           .getZ()
                     )
                  )
                  .createLegacyBlock()
                  .getBlock()
               == Blocks.WATER) {
               if (entity instanceof LivingEntity _entity) {
                  _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
               }

               if (entity instanceof Player _player) {
                  ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get());
                  _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _player.inventoryMenu.getCraftSlots());
               }

               if (world instanceof ServerLevel _level) {
                  Entity entityToSpawn = ((EntityType)ButcheryModEntities.TURTLESHELLBOAT.get())
                     .spawn(
                        _level,
                        new BlockPos(
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(15.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.SOURCE_ONLY,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getX(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(15.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.SOURCE_ONLY,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getY(),
                           entity.level()
                              .clip(
                                 new ClipContext(
                                    entity.getEyePosition(1.0F),
                                    entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(15.0)),
                                    net.minecraft.world.level.ClipContext.Block.OUTLINE,
                                    Fluid.SOURCE_ONLY,
                                    entity
                                 )
                              )
                              .getBlockPos()
                              .getZ()
                        ),
                        EntitySpawnReason.MOB_SUMMONED
                     );
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                  }
               }

               boolean var57;
               label178: {
                  if (entity instanceof ServerPlayer _plr14) {
                     ServerLevel var34 = _plr14.level();
                     if (var34 instanceof ServerLevel
                        && _plr14.getAdvancements()
                           .getOrStartProgress(var34.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets")))
                           .isDone()) {
                        var57 = true;
                        break label178;
                     }
                  }

                  var57 = false;
               }

               if (!var57 && entity instanceof ServerPlayer _player) {
                  ServerLevel var41 = _player.level();
                  if (var41 instanceof ServerLevel) {
                     AdvancementHolder _adv = var41.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets"));
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

               label156: {
                  if (entity instanceof ServerPlayer _plr16) {
                     ServerLevel var36 = _plr16.level();
                     if (var36 instanceof ServerLevel
                        && _plr16.getAdvancements()
                           .getOrStartProgress(var36.getServer().getAdvancements().get(Identifier.parse("butchery:itsafloater")))
                           .isDone()) {
                        var57 = true;
                        break label156;
                     }
                  }

                  var57 = false;
               }

               if (!var57 && entity instanceof ServerPlayer _playerx) {
                  ServerLevel var43 = _playerx.level();
                  if (var43 instanceof ServerLevel) {
                     AdvancementHolder _adv = var43.getServer().getAdvancements().get(Identifier.parse("butchery:itsafloater"));
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
         } else if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ((Block)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get()).asItem()
            && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.WATER) {
            if (entity instanceof LivingEntity _entity) {
               _entity.swing(InteractionHand.MAIN_HAND, SwingAnimation.DEFAULT, true);
            }

            if (entity instanceof Player _playerxx) {
               ItemStack _stktoremove = new ItemStack((ItemLike)ButcheryModBlocks.EMPTY_TURTLE_SHELL.get());
               _playerxx.getInventory()
                  .clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, 1, _playerxx.inventoryMenu.getCraftSlots());
            }

            if (world instanceof ServerLevel _levelx) {
               Entity entityToSpawn = ((EntityType)ButcheryModEntities.TURTLESHELLBOAT.get())
                  .spawn(_levelx, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
               }
            }

            boolean var55;
            label133: {
               if (entity instanceof ServerPlayer _plr25) {
                  ServerLevel _playerxx = _plr25.level();
                  if (_playerxx instanceof ServerLevel
                     && _plr25.getAdvancements()
                        .getOrStartProgress(_playerxx.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets")))
                        .isDone()) {
                     var55 = true;
                     break label133;
                  }
               }

               var55 = false;
            }

            if (!var55 && entity instanceof ServerPlayer _playerxx) {
               ServerLevel _ap = _playerxx.level();
               ServerLevel _adv = _ap instanceof ServerLevel ? _ap : null;
               if (_adv instanceof ServerLevel) {
                  AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse("butchery:butcherssecrets"));
                  if (_advx != null) {
                     AdvancementProgress _apx = _playerxx.getAdvancements().getOrStartProgress(_advx);
                     if (!_apx.isDone()) {
                        for (String criteria : _apx.getRemainingCriteria()) {
                           _playerxx.getAdvancements().award(_advx, criteria);
                        }
                     }
                  }
               }
            }

            label110: {
               if (entity instanceof ServerPlayer _plr27) {
                  ServerLevel var32 = _plr27.level();
                  if (var32 instanceof ServerLevel
                     && _plr27.getAdvancements().getOrStartProgress(var32.getServer().getAdvancements().get(Identifier.parse("butchery:itsafloater"))).isDone()
                     )
                   {
                     var55 = true;
                     break label110;
                  }
               }

               var55 = false;
            }

            if (!var55 && entity instanceof ServerPlayer _playerxxx) {
               ServerLevel var39 = _playerxxx.level();
               if (var39 instanceof ServerLevel) {
                  AdvancementHolder _adv = var39.getServer().getAdvancements().get(Identifier.parse("butchery:itsafloater"));
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
      }
   }
}
