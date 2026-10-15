package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public class WelcomemessageProcedure {
    public static void onPlayerLoggedIn(ShimEvent.PlayerLoggedInShim event) {
        WelcomemessageProcedure.execute(event, (Entity)event.getEntity());
    }

    public static void execute(Entity entity) {
        WelcomemessageProcedure.execute(null, entity);
    }

    private static void execute(@Nullable NeoEvent event, Entity entity) {
        ServerPlayer _plr1;
        ServerLevel _player;
        boolean var10000;
        if (entity != null && ButcheryconfigConfiguration.WELCOME_MESSAGE.get().booleanValue() && !(var10000 = entity instanceof ServerPlayer && (_player = (_plr1 = (ServerPlayer)entity).level()) instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_player.getServer().getAdvancements().get(Identifier.parse((String)"butchery:firstjoin"))).isDone())) {
            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "tellraw @p [\"\",{\"text\":\"Thanks for downloading \"},{\"text\":\"Butchery\",\"color\":\"red\"},{\"text\":\"! \"},{\"text\":\"Click here\",\"color\":\"blue\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.jmods.dev/butchery\"}},{\"text\":\" for the mods wiki.\"}]");
            }
            if (entity instanceof ServerPlayer) {
                AdvancementProgress _ap;
                AdvancementHolder _advx;
                ServerLevel _sl_player;
                ServerLevel _adv;
                ServerPlayer _player2 = (ServerPlayer)entity;
                ServerLevel serverLevel = _player2.level();
                ServerLevel serverLevel2 = _adv = serverLevel instanceof ServerLevel ? (_sl_player = serverLevel) : null;
                if (_adv instanceof ServerLevel && (_advx = _adv.getServer().getAdvancements().get(Identifier.parse((String)"butchery:firstjoin"))) != null && !(_ap = _player2.getAdvancements().getOrStartProgress(_advx)).isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player2.getAdvancements().award(_advx, criteria);
                    }
                }
            }
        }
    }
}

