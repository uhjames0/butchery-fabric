package net.mcreator.butchery.init;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.command.HealCommand;
import net.minecraft.commands.CommandSourceStack;

public class ButcheryModCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            try {
                HealCommand.registerCommand((CommandDispatcher<CommandSourceStack>)dispatcher);
            }
            catch (Exception e) {
                ButcheryMod.LOGGER.warn("[Butchery] command registration skipped", (Throwable)e);
            }
        });
    }
}

