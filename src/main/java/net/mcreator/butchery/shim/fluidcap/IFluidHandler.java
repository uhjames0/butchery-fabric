package net.mcreator.butchery.shim.fluidcap;

import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public interface IFluidHandler {
    public int getTanks();

    public FluidStack getFluidInTank(int var1);

    public int getTankCapacity(int var1);

    public boolean isFluidValid(int var1, FluidStack var2);

    public int fill(FluidStack var1, FluidAction var2);

    public FluidStack drain(FluidStack var1, FluidAction var2);

    public FluidStack drain(int var1, FluidAction var2);

    public static Fluid realFluid(Fluid f) {
        Fluid fluid;
        if (f instanceof FlowingFluid) {
            FlowingFluid ff = (FlowingFluid)f;
            fluid = ff.getSource();
        } else {
            fluid = f;
        }
        return fluid;
    }

    public static enum FluidAction {
        EXECUTE,
        SIMULATE;


        public boolean execute() {
            return this == EXECUTE;
        }
    }
}

