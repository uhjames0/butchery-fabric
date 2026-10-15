package net.mcreator.butchery.fluid.types;

import net.mcreator.butchery.shim.FluidType;
import net.mcreator.butchery.shim.SoundActions;
import net.minecraft.sounds.SoundEvents;

public class BloodFluidType
extends FluidType {
    public BloodFluidType() {
        super(FluidType.Properties.create().fallDistanceModifier(0.0f).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007).density(8000).viscosity(80000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }
}

