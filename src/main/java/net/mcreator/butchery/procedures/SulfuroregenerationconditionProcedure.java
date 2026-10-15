package net.mcreator.butchery.procedures;

import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;

public class SulfuroregenerationconditionProcedure {
    public static boolean execute() {
        return ButcheryconfigConfiguration.SULFUR_ORE.get();
    }
}

