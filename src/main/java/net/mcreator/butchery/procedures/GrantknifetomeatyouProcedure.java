package net.mcreator.butchery.procedures;

import java.util.Iterator;
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

public class GrantknifetomeatyouProcedure {
    public static void onItemCrafted(ShimEvent.ItemCraftedShim event) {
        GrantknifetomeatyouProcedure.execute(event, (Entity)event.getEntity(), event.getCrafting());
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        GrantknifetomeatyouProcedure.execute(null, entity, itemstack);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, Entity entity, ItemStack itemstack) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        if (entity == null) return;
        if (itemstack.getItem() != ButcheryModItems.BONE_SKINNING_KNIFE.get() && itemstack.getItem() != ButcheryModItems.IRON_SKINNING_KNIFE.get() && itemstack.getItem() != ButcheryModItems.GOLD_SKINNING_KNIFE.get() && itemstack.getItem() != ButcheryModItems.DIAMOND_SKINNING_KNIFE.get()) {
            if (itemstack.getItem() != ButcheryModItems.NETHERITE_SKINNING_KNIFE.get()) return;
        }
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr10 = (ServerPlayer)entity;
        ServerLevel _plr11 = _plr10.level();
        if (!(_plr11 instanceof ServerLevel)) return;
        if (!_plr10.getAdvancements().getOrStartProgress(_plr11.getServer().getAdvancements().get(Identifier.parse((String)"butchery:cut_abovethe_rest"))).isDone()) return;
        boolean var10000 = true;
        if (!var10000) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr11;
            ServerLevel _player;
            ServerPlayer _plr112 = (ServerPlayer)entity;
            serverLevel = _plr112.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr11 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr112.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:knifeto_meet_you"))).isDone()) {
                return;
            }
        }
        var10000 = false;
        if (var10000) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _player = (ServerPlayer)entity;
        serverLevel = _player.level();
        ServerLevel _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
        if (!(_adv instanceof ServerLevel)) return;
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:knifeto_meet_you"));
        if (_advx == null) return;
        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_advx);
        if (_ap.isDone()) return;
        Iterator iterator = _ap.getRemainingCriteria().iterator();
        while (iterator.hasNext()) {
            String criteria = (String)iterator.next();
            _player.getAdvancements().award(_advx, criteria);
        }
    }
}

