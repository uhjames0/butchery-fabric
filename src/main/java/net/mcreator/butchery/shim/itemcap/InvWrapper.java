package net.mcreator.butchery.shim.itemcap;

import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

public class InvWrapper
implements IItemHandlerModifiable {
    protected final Container inv;

    public InvWrapper(Container inv) {
        this.inv = inv;
    }

    public Container getInv() {
        return this.inv;
    }

    @Override
    public int getSlots() {
        return this.inv.getContainerSize();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inv.getItem(slot);
    }

    @Override
    public void setStackInSlot(int slot, ItemStack stack) {
        this.inv.setItem(slot, stack);
        this.inv.setChanged();
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        boolean reachedLimit;
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack existing = this.inv.getItem(slot);
        int limit = Math.min(this.inv.getMaxStackSize(stack), this.inv.getMaxStackSize());
        if (!existing.isEmpty()) {
            if (!ItemStack.isSameItemSameComponents((ItemStack)stack, (ItemStack)existing)) {
                return stack;
            }
            limit -= existing.getCount();
        }
        if (limit <= 0) {
            return stack;
        }
        boolean bl = reachedLimit = stack.getCount() > limit;
        if (!simulate) {
            if (existing.isEmpty()) {
                this.inv.setItem(slot, reachedLimit ? stack.copyWithCount(limit) : stack.copy());
            } else {
                existing.grow(reachedLimit ? limit : stack.getCount());
            }
            this.inv.setChanged();
        }
        return reachedLimit ? stack.copyWithCount(stack.getCount() - limit) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (amount == 0) {
            return ItemStack.EMPTY;
        }
        ItemStack existing = this.inv.getItem(slot);
        if (existing.isEmpty()) {
            return ItemStack.EMPTY;
        }
        int toExtract = Math.min(amount, existing.getCount());
        if (!simulate) {
            this.inv.setItem(slot, toExtract == existing.getCount() ? ItemStack.EMPTY : existing.copyWithCount(existing.getCount() - toExtract));
            this.inv.setChanged();
        }
        return existing.copyWithCount(toExtract);
    }

    @Override
    public int getSlotLimit(int slot) {
        return this.inv.getMaxStackSize();
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return true;
    }
}

