package net.mcreator.butchery.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.PlayerTeam;

public class Pillager_disguised_startedProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            PlayerTeam _pt;
            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/team add pillager_disguised");
            }
            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/team join pillager_disguised @e[type=pillager]");
            }
            if ((_pt = entity.level().getScoreboard().getPlayerTeam("pillager_disguised")) != null) {
                if (entity instanceof Player) {
                    Player _player = (Player)entity;
                    entity.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().name(), _pt);
                } else {
                    entity.level().getScoreboard().addPlayerToTeam(entity.getStringUUID(), _pt);
                }
            }
        }
    }
}

