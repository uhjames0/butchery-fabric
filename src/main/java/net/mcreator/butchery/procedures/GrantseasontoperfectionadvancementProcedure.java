package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.init.ButcheryModBlocks;
import net.mcreator.butchery.init.ButcheryModItems;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class GrantseasontoperfectionadvancementProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            GrantseasontoperfectionadvancementProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        GrantseasontoperfectionadvancementProcedure.execute(null, world, x, y, z, entity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        ItemStack itemStack;
        int n;
        if (entity == null) return;
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != ButcheryModBlocks.SKIN_RACK.get()) return;
        Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty) {
            Property<?> _getip3 = (IntegerProperty)property;
            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
        } else {
            n = -1;
        }
        if (n == 0) {
            int n2;
            property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip5 = (IntegerProperty)property;
                n2 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip5);
            } else {
                n2 = -1;
            }
            if (n2 == 26) {
                int n3;
                property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (property instanceof IntegerProperty) {
                    IntegerProperty _getip7 = (IntegerProperty)property;
                    n3 = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip7);
                } else {
                    n3 = -1;
                }
                if (n3 == 27) return;
            }
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _livEntxx = (LivingEntity)entity;
            itemStack = _livEntxx.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() != ButcheryModItems.SALT.get()) {
            ItemStack itemStack2;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEntx = (LivingEntity)entity;
                itemStack2 = _livEntx.getMainHandItem();
            } else {
                itemStack2 = ItemStack.EMPTY;
            }
            if (!itemStack2.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"forge:salt")))) {
                ItemStack itemStack3;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    itemStack3 = _livEnt.getMainHandItem();
                } else {
                    itemStack3 = ItemStack.EMPTY;
                }
                if (!itemStack3.is(TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.parse((String)"c:salt")))) return;
            }
        }
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr14 = (ServerPlayer)entity;
        ServerLevel _plr15 = _plr14.level();
        if (!(_plr15 instanceof ServerLevel)) return;
        if (!_plr14.getAdvancements().getOrStartProgress(_plr15.getServer().getAdvancements().get(Identifier.parse((String)"butchery:step_toward_leather"))).isDone()) return;
        boolean var36 = true;
        if (!var36) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr15;
            ServerLevel _player;
            ServerPlayer _plr152 = (ServerPlayer)entity;
            serverLevel = _plr152.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr15 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr152.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:seasonedtoperfection"))).isDone()) {
                return;
            }
        }
        var36 = false;
        if (var36) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _player = (ServerPlayer)entity;
        serverLevel = _player.level();
        ServerLevel _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
        if (!(_adv instanceof ServerLevel)) return;
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:seasonedtoperfection"));
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

