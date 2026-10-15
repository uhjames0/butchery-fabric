package net.mcreator.butchery.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;

public class Pillager_disguise_expiresProcedure {
    public static void execute(Entity entity) {
        if (entity != null && !entity.level().isClientSide() && entity.level().getServer() != null) {
            entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/team leave @p");
        }
    }
}

