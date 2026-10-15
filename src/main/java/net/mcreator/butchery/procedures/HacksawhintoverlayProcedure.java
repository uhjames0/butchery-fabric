package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;

public class HacksawhintoverlayProcedure {
    public static boolean execute() {
        return ButcheryconfigConfiguration.SHOW_HINTS.get();
    }
}

