package net.mcreator.butchery.shim.fluidcap;

import java.util.Optional;
import java.util.function.Predicate;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

/* JADX INFO: loaded from: FluidTank.class */
public class FluidTank implements IFluidHandler {
    protected FluidStack fluid;
    protected int capacity;
    protected final Predicate<FluidStack> validator;

    public FluidTank(int capacity) {
        this(capacity, (Predicate<FluidStack>) fs -> {
            return true;
        });
    }

    public FluidTank(int capacity, Predicate<FluidStack> validator) {
        this.fluid = FluidStack.EMPTY;
        this.capacity = capacity;
        this.validator = validator;
    }

    protected void onContentsChanged() {
    }

    public void serialize(ValueOutput out) {
        if (!this.fluid.isEmpty()) {
            out.putString("FluidName", BuiltInRegistries.FLUID.getKey(this.fluid.getFluid()).toString());
            out.putInt("Amount", this.fluid.getAmount());
        }
    }

    public void deserialize(ValueInput in) {
        Fluid f;
        Optional<String> name = in.getString("FluidName");
        Optional<Integer> amt = in.getInt("Amount");
        if (!name.isPresent() || (f = (Fluid) BuiltInRegistries.FLUID.getValue(Identifier.parse(name.get()))) == null) {
            return;
        }
        this.fluid = new FluidStack(f, amt.orElse(1000).intValue());
    }

    public FluidTank(FluidStack fluid, int capacity) {
        this.fluid = FluidStack.EMPTY;
        this.fluid = fluid;
        this.capacity = capacity;
        this.validator = fs -> {
            return true;
        };
    }

    public FluidTank setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public FluidTank setFluid(FluidStack stack) {
        this.fluid = stack;
        return this;
    }

    public FluidStack getFluid() {
        return this.fluid;
    }

    public int getFluidAmount() {
        return this.fluid.getAmount();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSpace() {
        return this.fluid.isEmpty() ? this.capacity : Math.max(0, this.capacity - this.fluid.getAmount());
    }

    public int getTanks() {
        return 1;
    }

    public FluidStack getFluidInTank(int tank) {
        return tank == 0 ? this.fluid : FluidStack.EMPTY;
    }

    public int getTankCapacity(int tank) {
        if (tank == 0) {
            return this.capacity;
        }
        return 0;
    }

    public boolean isFluidValid(int tank, FluidStack stack) {
        return this.validator == null || this.validator.test(stack);
    }

    public int fill(FluidStack resource, IFluidHandler.FluidAction action) {
        if (resource.isEmpty()) {
            return 0;
        }
        if (this.fluid.isEmpty()) {
            int filled = Math.min(this.capacity, resource.getAmount());
            if (action.execute()) {
                this.fluid = new FluidStack(resource.getFluid(), filled);
                onContentsChanged();
            }
            return filled;
        }
        if (!this.fluid.isFluidEqual(resource)) {
            return 0;
        }
        int filled2 = Math.min(getSpace(), resource.getAmount());
        if (action.execute() && filled2 > 0) {
            this.fluid.setAmount(this.fluid.getAmount() + filled2);
            onContentsChanged();
        }
        return filled2;
    }

    public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action) {
        return drain(resource.getAmount(), action);
    }

    public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) {
        int drained = Math.min(maxDrain, this.fluid.getAmount());
        FluidStack result = new FluidStack(this.fluid.getFluid(), drained);
        if (action.execute() && drained > 0) {
            this.fluid.setAmount(this.fluid.getAmount() - drained);
            if (this.fluid.getAmount() <= 0) {
                this.fluid = FluidStack.EMPTY;
            }
            onContentsChanged();
        }
        return result;
    }
}
