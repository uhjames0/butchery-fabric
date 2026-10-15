package net.mcreator.butchery.procedures;

import net.mcreator.butchery.init.ButcheryModItems;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GrantbutcheradvancementProcedure {
    public static void onItemCrafted(ShimEvent.ItemCraftedShim event) {
        GrantbutcheradvancementProcedure.execute(event, (Entity)event.getEntity(), event.getCrafting());
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        GrantbutcheradvancementProcedure.execute(null, entity, itemstack);
    }

    private static void execute(@Nullable NeoEvent event, Entity entity, ItemStack itemstack) {
        ServerPlayer _plr10;
        ServerLevel _player;
        boolean var10000;
        if (entity != null && (itemstack.getItem() == ButcheryModItems.BONE_CLEAVER.get() || itemstack.getItem() == ButcheryModItems.IRON_CLEAVER.get() || itemstack.getItem() == ButcheryModItems.GOLD_CLEAVER.get() || itemstack.getItem() == ButcheryModItems.DIAMOND_CLEAVER.get() || itemstack.getItem() == ButcheryModItems.NETHERITE_CLEAVER.get()) && !(var10000 = entity instanceof ServerPlayer && (_player = (_plr10 = (ServerPlayer)entity).level()) instanceof ServerLevel && _plr10.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcher"))).isDone()) && entity instanceof ServerPlayer) {
            AdvancementProgress _ap;
            AdvancementHolder _advx;
            ServerLevel _sl_player;
            ServerLevel _adv;
            ServerPlayer _player2 = (ServerPlayer)entity;
            ServerLevel serverLevel = _player2.level();
            ServerLevel serverLevel2 = _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
            if (_adv instanceof ServerLevel && (_advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcher"))) != null && !(_ap = _player2.getAdvancements().getOrStartProgress(_advx)).isDone()) {
                for (String criteria : _ap.getRemainingCriteria()) {
                    _player2.getAdvancements().award(_advx, criteria);
                }
            }
        }
    }
}

