package net.mcreator.butchery.shim.itemcap;

import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.minecraft.world.item.ItemStack;

public interface IItemHandlerModifiable
extends IItemHandler {
    @Override
    public void setStackInSlot(int var1, ItemStack var2);
}

