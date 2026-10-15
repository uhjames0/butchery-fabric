package net.mcreator.butchery.shim.fluidcap;

import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.FluidTank;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BlockEntityTankHandler
implements IFluidHandler {
    private final BlockEntity owner;
    private final FluidTank tank;

    public BlockEntityTankHandler(BlockEntity owner, FluidTank tank) {
        this.owner = owner;
        this.tank = tank;
    }

    @Override
    public int getTanks() {
        return this.tank.getTanks();
    }

    @Override
    public FluidStack getFluidInTank(int tankIdx) {
        FluidStack fs = this.tank.getFluidInTank(0);
        return fs.isEmpty() ? FluidStack.EMPTY : fs;
    }

    @Override
    public int getTankCapacity(int tankIdx) {
        return this.tank.getCapacity();
    }

    @Override
    public boolean isFluidValid(int tankIdx, FluidStack stack) {
        return this.tank.isFluidValid(0, stack);
    }

    @Override
    public int fill(FluidStack resource, IFluidHandler.FluidAction action) {
        int filled = this.tank.fill(resource, action);
        if (filled > 0 && action.execute()) {
            this.owner.setChanged();
        }
        return filled;
    }

    @Override
    public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action) {
        FluidStack drained = this.tank.drain(resource, action);
        if (!drained.isEmpty() && action.execute()) {
            this.owner.setChanged();
        }
        return drained;
    }

    @Override
    public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) {
        FluidStack drained = this.tank.drain(maxDrain, action);
        if (!drained.isEmpty() && action.execute()) {
            this.owner.setChanged();
        }
        return drained;
    }
}

