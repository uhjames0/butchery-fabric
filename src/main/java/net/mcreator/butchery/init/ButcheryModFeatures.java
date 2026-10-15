package net.mcreator.butchery.init;

import com.mojang.serialization.MapCodec;
import net.mcreator.butchery.shim.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ButcheryModFeatures {
    public static final DeferredRegister<MapCodec<? extends Feature>> REGISTRY = DeferredRegister.create(Registries.FEATURE_TYPE, "butchery");
}

