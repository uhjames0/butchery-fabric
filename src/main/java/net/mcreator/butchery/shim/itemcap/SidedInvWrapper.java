package net.mcreator.butchery.shim.itemcap;

import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.minecraft.core.Direction;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.ItemStack;

public class SidedInvWrapper
implements IItemHandlerModifiable {
    protected final WorldlyContainer inv;
    protected final Direction side;

    public SidedInvWrapper(WorldlyContainer inv, Direction side) {
        this.inv = inv;
        this.side = side;
    }

    @Override
    public int getSlots() {
        return this.inv.getSlotsForFace(this.side).length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inv.getItem(this.inv.getSlotsForFace(this.side)[slot]);
    }

    @Override
    public void setStackInSlot(int slot, ItemStack stack) {
        this.inv.setItem(this.inv.getSlotsForFace(this.side)[slot], stack);
        this.inv.setChanged();
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        boolean reachedLimit;
        int real = this.inv.getSlotsForFace(this.side)[slot];
        if (!this.inv.canPlaceItemThroughFace(real, stack, this.side)) {
            return stack;
        }
        ItemStack existing = this.inv.getItem(real);
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
                this.inv.setItem(real, reachedLimit ? stack.copyWithCount(limit) : stack.copy());
            } else {
                existing.grow(reachedLimit ? limit : stack.getCount());
            }
            this.inv.setChanged();
        }
        return reachedLimit ? stack.copyWithCount(stack.getCount() - limit) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        int real = this.inv.getSlotsForFace(this.side)[slot];
        ItemStack existing = this.inv.getItem(real);
        if (existing.isEmpty() || !this.inv.canTakeItemThroughFace(real, existing, this.side)) {
            return ItemStack.EMPTY;
        }
        int toExtract = Math.min(amount, existing.getCount());
        if (!simulate) {
            this.inv.setItem(real, toExtract == existing.getCount() ? ItemStack.EMPTY : existing.copyWithCount(existing.getCount() - toExtract));
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
        return this.inv.canPlaceItemThroughFace(this.inv.getSlotsForFace(this.side)[slot], stack, this.side);
    }
}

