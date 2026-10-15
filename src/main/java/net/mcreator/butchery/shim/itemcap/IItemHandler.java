package net.mcreator.butchery.shim.itemcap;

import net.minecraft.world.item.ItemStack;

public interface IItemHandler {
    default public void setStackInSlot(int slot, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    public int getSlots();

    public ItemStack getStackInSlot(int var1);

    public ItemStack insertItem(int var1, ItemStack var2, boolean var3);

    public ItemStack extractItem(int var1, int var2, boolean var3);

    public int getSlotLimit(int var1);

    public boolean isItemValid(int var1, ItemStack var2);
}

