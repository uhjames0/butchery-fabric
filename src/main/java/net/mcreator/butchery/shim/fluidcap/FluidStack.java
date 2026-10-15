package net.mcreator.butchery.shim.fluidcap;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: FluidStack.class */
public class FluidStack {
    private Fluid fluid;
    private int amount;
    public static FluidStack EMPTY = new FluidStack(Fluids.EMPTY, 0);

    public FluidStack(Fluid fluid, int amount) {
        this.fluid = fluid == null ? Fluids.EMPTY : fluid;
        this.amount = amount;
    }

    public FluidStack(Holder<Fluid> holder, int amount) {
        this((Fluid) holder.value(), amount);
    }

    public Fluid getFluid() {
        return this.fluid;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isEmpty() {
        return this.fluid == Fluids.EMPTY || this.amount <= 0;
    }

    public FluidStack copy() {
        return new FluidStack(this.fluid, this.amount);
    }

    public boolean isFluidEqual(FluidStack other) {
        return other != null && this.fluid == other.fluid;
    }

    public boolean is(Fluid f) {
        return this.fluid == f;
    }

    public boolean is(Identifier id) {
        return BuiltInRegistries.FLUID.getKey(this.fluid).equals(id);
    }

    public static boolean isSameFluidSameComponents(FluidStack a, FluidStack b) {
        return (a == null || b == null || a.fluid != b.fluid) ? false : true;
    }
}
