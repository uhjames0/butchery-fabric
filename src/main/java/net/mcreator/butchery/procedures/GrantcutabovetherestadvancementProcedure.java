package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class GrantcutabovetherestadvancementProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            GrantcutabovetherestadvancementProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        GrantcutabovetherestadvancementProcedure.execute(null, world, x, y, z, entity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        ItemStack itemStack;
        if (entity == null) return;
        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:drained_carcass")))) return;
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntx = (LivingEntity)entity;
            itemStack = _livEntx.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (!itemStack.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:cleaver")))) {
            ItemStack itemStack2;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                itemStack2 = _livEnt.getMainHandItem();
            } else {
                itemStack2 = ItemStack.EMPTY;
            }
            if (!itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:cleaver")))) return;
        }
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr6 = (ServerPlayer)entity;
        ServerLevel _plr7 = _plr6.level();
        if (!(_plr7 instanceof ServerLevel)) return;
        if (!_plr6.getAdvancements().getOrStartProgress(_plr7.getServer().getAdvancements().get(Identifier.parse((String)"butchery:first_blood"))).isDone()) return;
        boolean var25 = true;
        if (!var25) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr7;
            ServerLevel _player;
            ServerPlayer _plr72 = (ServerPlayer)entity;
            serverLevel = _plr72.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr7 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr72.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:cut_abovethe_rest"))).isDone()) {
                return;
            }
        }
        var25 = false;
        if (var25) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _player = (ServerPlayer)entity;
        serverLevel = _player.level();
        ServerLevel _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
        if (!(_adv instanceof ServerLevel)) return;
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:cut_abovethe_rest"));
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

