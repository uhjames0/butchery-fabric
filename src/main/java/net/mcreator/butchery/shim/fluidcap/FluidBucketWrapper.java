package net.mcreator.butchery.shim.fluidcap;

import net.mcreator.butchery.shim.fluidcap.FluidStack;
import net.mcreator.butchery.shim.fluidcap.IFluidHandler;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;

public class FluidBucketWrapper
implements IFluidHandler {
    protected final ItemStack container;

    public FluidBucketWrapper(ItemStack container) {
        this.container = container;
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public FluidStack getFluidInTank(int tank) {
        Item item = this.container.getItem();
        if (item instanceof BucketItem) {
            BucketItem bucket = (BucketItem)item;
            FluidStack s = new FluidStack(bucket.getContent(), 1000);
            return s;
        }
        return FluidStack.EMPTY;
    }

    @Override
    public int getTankCapacity(int tank) {
        return 1000;
    }

    @Override
    public boolean isFluidValid(int tank, FluidStack stack) {
        return true;
    }

    @Override
    public int fill(FluidStack resource, IFluidHandler.FluidAction action) {
        return 0;
    }

    @Override
    public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action) {
        return this.drain(resource.getAmount(), action);
    }

    @Override
    public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) {
        BucketItem bucket;
        Item item = this.container.getItem();
        if (item instanceof BucketItem && (bucket = (BucketItem)item).getContent() != Fluids.EMPTY) {
            if (action.execute()) {
                this.container.shrink(1);
            }
            return new FluidStack(bucket.getContent(), 1000);
        }
        return FluidStack.EMPTY;
    }
}

