package net.mcreator.butchery.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.mcreator.butchery.procedures.HealcommandProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;

public class HealCommand {
    public static void registerCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal((String)"heal").requires(s -> {
            ServerPlayer sp;
            Entity patt0$temp = s.getEntity();
            return patt0$temp instanceof ServerPlayer && (sp = (ServerPlayer)patt0$temp).permissions() == PermissionSet.ALL_PERMISSIONS;
        })).executes(arguments -> {
            ServerLevel world = ((CommandSourceStack)arguments.getSource()).getLevel();
            double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
            double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
            double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
            Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
            if (entity == null && world instanceof ServerLevel) {
                ServerLevel _servLevel = world;
                entity = null;
            }
            Direction direction = Direction.DOWN;
            if (entity != null) {
                direction = entity.getDirection();
            }
            HealcommandProcedure.execute(entity);
            return 0;
        }));
    }
}

