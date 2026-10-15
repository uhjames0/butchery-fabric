package net.mcreator.butchery.init;

import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.configuration.ButcheryconfigConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class ButcheryModWorldgen {
    private ButcheryModWorldgen() {
    }

    public static void registerBiomeModifications() {
        boolean any = false;
        if (ButcheryconfigConfiguration.SULFUR_ORE.get().booleanValue()) {
            ButcheryModWorldgen.addFeature("sulfuroregeneration", GenerationStep.Decoration.UNDERGROUND_ORES);
            ButcheryModWorldgen.addFeature("deepslate_sulfur_ore", GenerationStep.Decoration.UNDERGROUND_ORES);
            any = true;
        }
        if (ButcheryconfigConfiguration.SALT_GENERATION.get().booleanValue()) {
            ButcheryModWorldgen.addFeature("saltdiscgeneration", GenerationStep.Decoration.SURFACE_STRUCTURES);
            any = true;
        }
        if (any) {
            ButcheryMod.LOGGER.info("[Butchery] biome modifications registered (sulfur ore / salt discs per config)");
        } else {
            ButcheryMod.LOGGER.info("[Butchery] ore/salt worldgen disabled by config");
        }
    }

    private static void addFeature(String name, GenerationStep.Decoration step) {
        ResourceKey key = ResourceKey.create((ResourceKey)Registries.PLACED_FEATURE, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)name));
        BiomeModifications.addFeature((Predicate)BiomeSelectors.all(), (GenerationStep.Decoration)step, (ResourceKey)key);
    }
}

