package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;

public class SaltdiscgenerationconditionProcedure {
    public static boolean execute() {
        return ButcheryconfigConfiguration.SALT_GENERATION.get();
    }
}

