package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.ICancellableEvent;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.RightClickItemShim;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
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
import org.jetbrains.annotations.Nullable;

public class DeflateballoonProcedure {
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
         if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ButcheryModItems.GREEN_FROG_BALLOON.get()
            && entity.isShiftKeyDown()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            if (world instanceof Level _level) {
               if (!_level.isClientSide()) {
                  _level.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _level.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ButcheryModItems.GREEN_FROG_BALLOON.get()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack6 = new ItemStack((ItemLike)ButcheryModBlocks.GREEN_FROG_CARCASS.get()).copy();
                     _setstack6.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack6);
                     if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                     }
                  }
               }
            );
         } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ButcheryModItems.ORANGE_FROG_BALLOON.get()
            && entity.isShiftKeyDown()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            if (world instanceof Level _levelx) {
               if (!_levelx.isClientSide()) {
                  _levelx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ButcheryModItems.ORANGE_FROG_BALLOON.get()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack14 = new ItemStack((ItemLike)ButcheryModBlocks.ORANGE_FROG_CARCASS.get()).copy();
                     _setstack14.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack14);
                     if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                     }
                  }
               }
            );
         } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
               == ButcheryModItems.GRAY_FROG_BALLOON.get()
            && entity.isShiftKeyDown()) {
            if (event instanceof ICancellableEvent) {
               event.setCanceled(true);
            }

            if (world instanceof Level _levelxx) {
               if (!_levelxx.isClientSide()) {
                  _levelxx.playSound(
                     null,
                     BlockPos.containing(x, y, z),
                     (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")),
                     SoundSource.NEUTRAL,
                     1.0F,
                     1.0F
                  );
               } else {
                  _levelxx.playLocalSound(
                     x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("butchery:deflate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                  );
               }
            }

            ButcheryMod.queueServerWork(
               40,
               () -> {
                  if ((entity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == ButcheryModItems.GRAY_FROG_BALLOON.get()
                     && entity instanceof LivingEntity _entity) {
                     ItemStack _setstack22 = new ItemStack((ItemLike)ButcheryModBlocks.GRAY_FROG_CARCASS.get()).copy();
                     _setstack22.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack22);
                     if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                     }
                  }
               }
            );
         }
      }
   }
}
