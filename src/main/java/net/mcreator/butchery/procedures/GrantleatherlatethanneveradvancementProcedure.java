package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

public class GrantleatherlatethanneveradvancementProcedure {
    public static void onPickup(ShimEvent.ItemPickupShim event) {
        GrantleatherlatethanneveradvancementProcedure.execute(event, (Entity)event.getPlayer(), event.getItemEntity().getItem());
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        GrantleatherlatethanneveradvancementProcedure.execute(null, entity, itemstack);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, Entity entity, ItemStack itemstack) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        if (entity == null) return;
        if (!(entity instanceof Player)) return;
        if (itemstack.getItem() != Items.LEATHER) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr3 = (ServerPlayer)entity;
        ServerLevel _plr4 = _plr3.level();
        if (!(_plr4 instanceof ServerLevel)) return;
        if (!_plr3.getAdvancements().getOrStartProgress(_plr4.getServer().getAdvancements().get(Identifier.parse((String)"butchery:splish_splash"))).isDone()) return;
        boolean var10000 = true;
        if (!var10000) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr4;
            ServerLevel _player;
            ServerPlayer _plr42 = (ServerPlayer)entity;
            serverLevel = _plr42.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr4 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr42.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:leather_late_than_never"))).isDone()) {
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
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:leather_late_than_never"));
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

