package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent.PlayerTickShim;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

public class GrantheadsupProcedure {
   public static void onPlayerTick(PlayerTickShim event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute(null, entity);
   }

   private static void execute(@Nullable NeoEvent event, Entity entity) {
      if (entity != null
         && hasEntityInInventory(
            entity,
            new ItemStack(
               (ItemLike)BuiltInRegistries.ITEM
                  .getRandomElementOf(TagKey.create(Registries.ITEM, Identifier.parse("butchery:head_mount")), RandomSource.create())
                  .orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR))
                  .value()
            )
         )) {
         boolean var10000;
         label39: {
            if (entity instanceof ServerPlayer _plr2) {
               ServerLevel _player = _plr2.level();
               if (_player instanceof ServerLevel
                  && _plr2.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse("butchery:heads_up"))).isDone()) {
                  var10000 = true;
                  break label39;
               }
            }

            var10000 = false;
         }

         if (!var10000 && entity instanceof ServerPlayer _player) {
            ServerLevel _ap = _player.level();
            ServerLevel _adv = _ap instanceof ServerLevel ? _ap : null;
            if (_adv instanceof ServerLevel) {
               AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse("butchery:heads_up"));
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
   }

   private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
      return entity instanceof Player player ? player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack)) : false;
   }
}
