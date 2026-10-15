package net.mcreator.butchery.shim.itemcap;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

/* JADX INFO: loaded from: ItemStackHandler.class */
public class ItemStackHandler implements IItemHandlerModifiable {
    protected NonNullList<ItemStack> stacks;

    public ItemStackHandler() {
        this(1);
    }

    public ItemStackHandler(int size) {
        this.stacks = NonNullList.withSize(1, ItemStack.EMPTY);
        this.stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    public void setSize(int size) {
        this.stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    public void setStackInSlot(int slot, ItemStack stack) {
        validateSlotIndex(slot);
        this.stacks.set(slot, stack);
    }

    public int getSlots() {
        return this.stacks.size();
    }

    public ItemStack getStackInSlot(int slot) {
        validateSlotIndex(slot);
        return (ItemStack) this.stacks.get(slot);
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        validateSlotIndex(slot);
        ItemStack existing = (ItemStack) this.stacks.get(slot);
        int limit = getStackLimit(slot, stack);
        if (!existing.isEmpty()) {
            if (!ItemStack.isSameItemSameComponents(stack, existing)) {
                return stack;
            }
            limit -= existing.getCount();
        }
        if (limit <= 0) {
            return stack;
        }
        boolean reachedLimit = stack.getCount() > limit;
        if (!simulate) {
            if (existing.isEmpty()) {
                this.stacks.set(slot, reachedLimit ? stack.copyWithCount(limit) : stack.copy());
            } else {
                existing.grow(reachedLimit ? limit : stack.getCount());
            }
            onContentsChanged(slot);
        }
        return reachedLimit ? stack.copyWithCount(stack.getCount() - limit) : ItemStack.EMPTY;
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (amount == 0) {
            return ItemStack.EMPTY;
        }
        validateSlotIndex(slot);
        ItemStack existing = (ItemStack) this.stacks.get(slot);
        if (existing.isEmpty()) {
            return ItemStack.EMPTY;
        }
        int toExtract = Math.min(amount, existing.getCount());
        if (!simulate) {
            this.stacks.set(slot, toExtract == existing.getCount() ? ItemStack.EMPTY : existing.copyWithCount(existing.getCount() - toExtract));
            onContentsChanged(slot);
        }
        return existing.copyWithCount(toExtract);
    }

    public int getSlotLimit(int slot) {
        return 64;
    }

    protected int getStackLimit(int slot, ItemStack stack) {
        return 64;
    }

    public boolean isItemValid(int slot, ItemStack stack) {
        return true;
    }

    public void deserializeNBT(ValueInput input) {
        input.getInt("Size").ifPresent((v1) -> {
            setSize(v1);
        });
        for (ValueInput vi : input.childrenListOrEmpty("Items")) {
            int slot = ((Integer) vi.getInt("Slot").orElse(-1)).intValue();
            if (slot >= 0 && slot < this.stacks.size()) {
                this.stacks.set(slot, (ItemStack) vi.read("Item", ItemStack.CODEC).orElse(ItemStack.EMPTY));
            }
        }
    }

    public void serializeNBT(ValueOutput output) {
        ValueOutput.ValueOutputList list = output.childrenList("Items");
        for (int i = 0; i < this.stacks.size(); i++) {
            ItemStack s = (ItemStack) this.stacks.get(i);
            if (!s.isEmpty()) {
                ValueOutput e = list.addChild();
                e.putInt("Slot", i);
                e.store("Item", ItemStack.CODEC, s);
            }
        }
    }

    protected void onContentsChanged(int slot) {
    }

    private void validateSlotIndex(int slot) {
        if (slot < 0 || slot >= this.stacks.size()) {
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + this.stacks.size() + ")");
        }
    }
}
