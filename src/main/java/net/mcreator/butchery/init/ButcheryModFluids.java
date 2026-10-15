package net.mcreator.butchery.init;

import net.mcreator.butchery.fluid.BloodFluid;
import net.mcreator.butchery.fluid.InfectedBloodFluid;
import net.mcreator.butchery.shim.DeferredHolder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class ButcheryModFluids {
    public static final DeferredHolder<Fluid, FlowingFluid> BLOOD = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"blood"), () -> new BloodFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLOOD = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_blood"), () -> new BloodFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> INFECTED_BLOOD = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"infected_blood"), () -> new InfectedBloodFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_INFECTED_BLOOD = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_infected_blood"), () -> new InfectedBloodFluid.Flowing());

    public static void register() {
        Registry.register((Registry)BuiltInRegistries.FLUID, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"blood"), (Object)((Object)new BloodFluid.Source()));
        Registry.register((Registry)BuiltInRegistries.FLUID, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_blood"), (Object)((Object)new BloodFluid.Flowing()));
        Registry.register((Registry)BuiltInRegistries.FLUID, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"infected_blood"), (Object)((Object)new InfectedBloodFluid.Source()));
        Registry.register((Registry)BuiltInRegistries.FLUID, (Identifier)Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_infected_blood"), (Object)((Object)new InfectedBloodFluid.Flowing()));
        BLOOD.bind((FlowingFluid)BuiltInRegistries.FLUID.getValue(Identifier.fromNamespaceAndPath((String)"butchery", (String)"blood")));
        FLOWING_BLOOD.bind((FlowingFluid)BuiltInRegistries.FLUID.getValue(Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_blood")));
        INFECTED_BLOOD.bind((FlowingFluid)BuiltInRegistries.FLUID.getValue(Identifier.fromNamespaceAndPath((String)"butchery", (String)"infected_blood")));
        FLOWING_INFECTED_BLOOD.bind((FlowingFluid)BuiltInRegistries.FLUID.getValue(Identifier.fromNamespaceAndPath((String)"butchery", (String)"flowing_infected_blood")));
    }
}

