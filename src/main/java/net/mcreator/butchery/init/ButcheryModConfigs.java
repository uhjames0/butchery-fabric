package net.mcreator.butchery.init;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.mcreator.butchery.shim.ModConfigSpec;

public class ButcheryModConfigs {
    public static final ModConfigSpec SPEC = ButcheryconfigConfiguration.SPEC;

    public static void register() {
        ButcheryMod.LOGGER.debug("[Butchery] configs available at config/butchery.json");
    }
}

