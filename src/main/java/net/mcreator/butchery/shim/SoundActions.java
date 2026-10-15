package net.mcreator.butchery.shim;

import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class SoundActions {
    public static final Object FLUID_VAPORIZE = new Object();
    public static final Object FLUID_MOVE = new Object();
    public static final Object FLUID_PICKUP = new Object();
    public static final Object FLUID_PLACE = new Object();
    public static final Supplier<SoundEvent> BUCKET_FILL = () -> SoundEvents.BUCKET_FILL;
    public static final Supplier<SoundEvent> BUCKET_EMPTY = () -> SoundEvents.BUCKET_EMPTY;
}

