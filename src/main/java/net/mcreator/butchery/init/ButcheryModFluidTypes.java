package net.mcreator.butchery.init;

import net.mcreator.butchery.fluid.types.BloodFluidType;
import net.mcreator.butchery.fluid.types.InfectedBloodFluidType;
import net.mcreator.butchery.shim.DeferredHolder;
import net.mcreator.butchery.shim.FluidType;
import net.minecraft.resources.Identifier;

public class ButcheryModFluidTypes {
    public static final DeferredHolder<FluidType, FluidType> BLOOD_TYPE = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"blood"), BloodFluidType::new);
    public static final DeferredHolder<FluidType, FluidType> INFECTED_BLOOD_TYPE = new DeferredHolder(Identifier.fromNamespaceAndPath((String)"butchery", (String)"infected_blood"), InfectedBloodFluidType::new);
}

