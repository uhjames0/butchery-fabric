package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.network.ButcheryModVariables;
import net.mcreator.butchery.shim.events.NeoEvent;
import net.mcreator.butchery.shim.events.ShimEvent;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class FirstjoinguideProcedure {
    public static void onPlayerLoggedIn(ShimEvent.PlayerLoggedInShim event) {
        FirstjoinguideProcedure.execute(event, (Entity)event.getEntity());
    }

    public static void execute(Entity entity) {
        FirstjoinguideProcedure.execute(null, entity);
    }

    private static void execute(@Nullable NeoEvent event, Entity entity) {
        if (entity != null && ButcheryconfigConfiguration.FIRST_JOIN_BOOK.get().booleanValue() && ButcheryModVariables.getPlayerVariables((Player)((Player)entity)).first_join_guide == 0.0) {
            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/give @p patchouli:guide_book{\"patchouli:book\":\"butchery:butchers_guide\"}");
            }
            if (!entity.level().isClientSide() && entity.level().getServer() != null) {
                entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, PermissionSet.ALL_PERMISSIONS, entity.level().getServer(), entity), "/give @p patchouli:guide_book[patchouli:book=\"butchery:butchers_guide\"]");
            }
            ButcheryModVariables.PlayerVariables _vars = ButcheryModVariables.getPlayerVariables((Player)entity);
            _vars.first_join_guide = 1.0;
            _vars.markSyncDirty();
        }
    }
}

