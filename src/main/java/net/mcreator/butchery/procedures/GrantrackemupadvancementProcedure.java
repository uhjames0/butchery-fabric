package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class GrantrackemupadvancementProcedure {
    public static void onItemCrafted(ShimEvent.ItemCraftedShim event) {
        GrantrackemupadvancementProcedure.execute(event, (Entity)event.getEntity(), event.getCrafting());
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        GrantrackemupadvancementProcedure.execute(null, entity, itemstack);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, Entity entity, ItemStack itemstack) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        if (entity == null) return;
        if (itemstack.getItem() != ((Block)ButcheryModBlocks.SKIN_RACK.get()).asItem()) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr2 = (ServerPlayer)entity;
        ServerLevel _plr3 = _plr2.level();
        if (!(_plr3 instanceof ServerLevel)) return;
        if (!_plr2.getAdvancements().getOrStartProgress(_plr3.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcher"))).isDone()) return;
        boolean var10000 = true;
        if (!var10000) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr3;
            ServerLevel _player;
            ServerPlayer _plr32 = (ServerPlayer)entity;
            serverLevel = _plr32.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr3 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr32.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:rack_em_up"))).isDone()) {
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
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:rack_em_up"));
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

