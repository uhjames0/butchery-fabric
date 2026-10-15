package net.mcreator.butchery.shim.itemcap;

import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SlotItemHandler
extends Slot {
    private final IItemHandler itemHandler;
    private final int index;

    public SlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super((Container)new SimpleContainer(1), index, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.index = index;
    }

    public IItemHandler getItemHandler() {
        return this.itemHandler;
    }

    public boolean mayPlace(ItemStack stack) {
        return stack.isEmpty() || this.itemHandler.isItemValid(this.index, stack);
    }

    public ItemStack getItem() {
        return this.itemHandler.getStackInSlot(this.index);
    }

    public void set(ItemStack stack) {
        this.itemHandler.setStackInSlot(this.index, stack);
        this.setChanged();
    }

    public boolean hasItem() {
        return !this.itemHandler.getStackInSlot(this.index).isEmpty();
    }

    public ItemStack remove(int amount) {
        return this.itemHandler.extractItem(this.index, amount, false);
    }

    public boolean mayPickup(Player player) {
        return true;
    }

    public void onTake(Player player, ItemStack stack) {
        this.checkTake(player, stack);
    }

    protected void checkTake(Player player, ItemStack stack) {
    }
}

