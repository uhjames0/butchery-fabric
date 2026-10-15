package net.mcreator.butchery.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;

public class BottlemodetooltipProcedure {
    public static void execute(ItemStack itemstack) {
        if (itemstack.getItem() == Items.GLASS_BOTTLE && ((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 1.0 || itemstack.getItem() == Items.GLASS_BOTTLE && ((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 2.0 || itemstack.getItem() != Items.GLASS_BOTTLE || ((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("bucketVersion", 0.0) == 3.0) {
            // empty if block
        }
    }
}

