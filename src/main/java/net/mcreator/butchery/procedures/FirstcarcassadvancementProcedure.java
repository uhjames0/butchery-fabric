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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class FirstcarcassadvancementProcedure {
    public static void onEntityDeath(ShimEvent.LivingDeathShim event) {
        if (event.getEntity() != null) {
            FirstcarcassadvancementProcedure.execute(event, (Entity)event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceentity) {
        FirstcarcassadvancementProcedure.execute(null, entity, sourceentity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, Entity entity, Entity sourceentity) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        ItemStack itemStack;
        if (entity == null) return;
        if (sourceentity == null) return;
        ItemStack dropped_carcass = ItemStack.EMPTY;
        if (!(entity instanceof Animal)) {
            if (!(entity instanceof Monster)) return;
        }
        if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEntxxxx = (LivingEntity)sourceentity;
            itemStack = _livEntxxxx.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() != ButcheryModItems.BONE_CLEAVER.get()) {
            ItemStack itemStack2;
            if (sourceentity instanceof LivingEntity) {
                LivingEntity _livEntxxx = (LivingEntity)sourceentity;
                itemStack2 = _livEntxxx.getMainHandItem();
            } else {
                itemStack2 = ItemStack.EMPTY;
            }
            if (itemStack2.getItem() != ButcheryModItems.IRON_CLEAVER.get()) {
                ItemStack itemStack3;
                if (sourceentity instanceof LivingEntity) {
                    LivingEntity _livEntxx = (LivingEntity)sourceentity;
                    itemStack3 = _livEntxx.getMainHandItem();
                } else {
                    itemStack3 = ItemStack.EMPTY;
                }
                if (itemStack3.getItem() != ButcheryModItems.GOLD_CLEAVER.get()) {
                    ItemStack itemStack4;
                    if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEntx = (LivingEntity)sourceentity;
                        itemStack4 = _livEntx.getMainHandItem();
                    } else {
                        itemStack4 = ItemStack.EMPTY;
                    }
                    if (itemStack4.getItem() != ButcheryModItems.DIAMOND_CLEAVER.get()) {
                        ItemStack itemStack5;
                        if (sourceentity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)sourceentity;
                            itemStack5 = _livEnt.getMainHandItem();
                        } else {
                            itemStack5 = ItemStack.EMPTY;
                        }
                        if (itemStack5.getItem() != ButcheryModItems.NETHERITE_CLEAVER.get()) return;
                    }
                }
            }
        }
        if (!(sourceentity instanceof ServerPlayer)) return;
        ServerPlayer _plr12 = (ServerPlayer)sourceentity;
        ServerLevel _plr13 = _plr12.level();
        if (!(_plr13 instanceof ServerLevel)) return;
        if (!_plr12.getAdvancements().getOrStartProgress(_plr13.getServer().getAdvancements().get(Identifier.parse((String)"butchery:butcher"))).isDone()) return;
        boolean var26 = true;
        if (!var26) return;
        if (sourceentity instanceof ServerPlayer) {
            ServerLevel _sl_plr13;
            ServerLevel _player;
            ServerPlayer _plr132 = (ServerPlayer)sourceentity;
            serverLevel = _plr132.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr13 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr132.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:firstcarcass"))).isDone()) {
                return;
            }
        }
        var26 = false;
        if (var26) return;
        if (!(sourceentity instanceof ServerPlayer)) return;
        ServerPlayer _player = (ServerPlayer)sourceentity;
        serverLevel = _player.level();
        ServerLevel _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
        if (!(_adv instanceof ServerLevel)) return;
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:firstcarcass"));
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

