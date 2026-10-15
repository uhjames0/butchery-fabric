package net.mcreator.butchery.shim;

import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Rarity;

public class FluidType {
    public static final Properties EMPTY = new Properties();

    public FluidType() {
        this(EMPTY);
    }

    public FluidType(Properties properties) {
    }

    public record Properties() {
        public static Properties create() {
            return new Properties();
        }

        public Properties descriptionId(String s) {
            return this;
        }

        public Properties canSwim(boolean b) {
            return this;
        }

        public Properties canHydrate(boolean b) {
            return this;
        }

        public Properties motionScale(double d) {
            return this;
        }

        public Properties lightLevel(int i) {
            return this;
        }

        public Properties density(int i) {
            return this;
        }

        public Properties temperature(int i) {
            return this;
        }

        public Properties viscosity(int i) {
            return this;
        }

        public Properties rarity(Rarity r) {
            return this;
        }

        public Properties sound(Object action, SoundEvent ev) {
            return this;
        }

        public Properties sound(Object action, Supplier<SoundEvent> ev) {
            return this;
        }

        public Properties canDrown(boolean b) {
            return this;
        }

        public Properties fallDistanceModifier(float f) {
            return this;
        }

        public Properties canExtinguish(boolean b) {
            return this;
        }

        public Properties supportsBoating(boolean b) {
            return this;
        }

        public Properties sound(Supplier<SoundEvent> s) {
            return this;
        }
    }
}

