package net.mcreator.butchery.procedures;

import net.mcreator.butchery.shim.ButcheryCaps;
import net.mcreator.butchery.shim.ILevelExtension;
import net.mcreator.butchery.shim.capabilities.ItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandler;
import net.mcreator.butchery.shim.itemcap.IItemHandlerModifiable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

/* JADX INFO: loaded from: TaxidermyTakenfromslotProcedure.class */
public class TaxidermyTakenfromslotProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        Object capability = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
        if (capability instanceof IItemHandlerModifiable) {
            IItemHandlerModifiable _itemHandlerModifiable = (IItemHandlerModifiable) capability;
            ItemStack _setstack = itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().copy();
            _setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy().getCount() - 1);
            _itemHandlerModifiable.setStackInSlot(0, _setstack);
        }
        Object capability2 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
        if (capability2 instanceof IItemHandlerModifiable) {
            IItemHandlerModifiable _itemHandlerModifiable2 = (IItemHandlerModifiable) capability2;
            ItemStack _setstack2 = itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().copy();
            _setstack2.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy().getCount() - 1);
            _itemHandlerModifiable2.setStackInSlot(1, _setstack2);
        }
        Object capability3 = ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{BlockPos.containing(x, y, z), null});
        if (capability3 instanceof IItemHandlerModifiable) {
            IItemHandlerModifiable _itemHandlerModifiable3 = (IItemHandlerModifiable) capability3;
            ItemStack _setstack3 = itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().copy();
            _setstack3.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy().getCount() - 1);
            _itemHandlerModifiable3.setStackInSlot(2, _setstack3);
        }
    }

    private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
        new ILevelExtension(world);
        IItemHandler itemHandler = (IItemHandler) ButcheryCaps.getCapability(world, ItemHandler.BLOCK, new Object[]{pos, null});
        if (itemHandler != null) {
            return itemHandler.getStackInSlot(slot);
        }
        return ItemStack.EMPTY;
    }
}
