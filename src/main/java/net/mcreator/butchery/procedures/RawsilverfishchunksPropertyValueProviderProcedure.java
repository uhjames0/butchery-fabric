package net.mcreator.butchery.procedures;

import net.minecraft.world.item.ItemStack;

public class RawsilverfishchunksPropertyValueProviderProcedure {
    public static double execute(ItemStack itemstack) {
        return itemstack.getCount() > 1 ? 1.0 : 0.0;
    }
}

