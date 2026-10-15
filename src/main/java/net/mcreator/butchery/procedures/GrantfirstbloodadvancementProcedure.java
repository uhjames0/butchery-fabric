package net.mcreator.butchery.procedures;

import java.util.Iterator;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class GrantfirstbloodadvancementProcedure {
    public static void onRightClickBlock(ShimEvent.RightClickBlockShim event) {
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            GrantfirstbloodadvancementProcedure.execute(event, (LevelAccessor)event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        GrantfirstbloodadvancementProcedure.execute(null, world, x, y, z, entity);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void execute(@Nullable NeoEvent event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ServerLevel _sl_player;
        ServerLevel serverLevel;
        if (entity == null) return;
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() != new Object(){

            /*
             * Enabled aggressive block sorting
             */
            public BlockState with(BlockState _bs, String _property, int _newValue) {
                BlockState blockState;
                Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                if (_prop instanceof IntegerProperty) {
                    IntegerProperty _ip = (IntegerProperty)_prop;
                    if (_prop.getPossibleValues().contains(_newValue)) {
                        blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                        return blockState;
                    }
                }
                blockState = _bs;
                return blockState;
            }
        }.with(world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)), "blockstate", 1).getBlock()) return;
        if (!(entity instanceof ServerPlayer)) return;
        ServerPlayer _plr4 = (ServerPlayer)entity;
        ServerLevel _plr5 = _plr4.level();
        if (!(_plr5 instanceof ServerLevel)) return;
        if (!_plr4.getAdvancements().getOrStartProgress(_plr5.getServer().getAdvancements().get(Identifier.parse((String)"butchery:hangingaround"))).isDone()) return;
        boolean var10000 = true;
        if (!var10000) return;
        if (entity instanceof ServerPlayer) {
            ServerLevel _sl_plr5;
            ServerLevel _player;
            ServerPlayer _plr52 = (ServerPlayer)entity;
            serverLevel = _plr52.level();
            ServerLevel serverLevel2 = _player = serverLevel instanceof ServerLevel ? (_sl_plr5 = serverLevel) : null;
            if (_player instanceof ServerLevel && _plr52.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:first_blood"))).isDone()) {
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
        AdvancementHolder _advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:first_blood"));
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

