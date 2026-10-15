package net.mcreator.butchery.procedures;

import net.minecraft.world.item.ItemStack;

public class CoinpropertyvalueproviderProcedure {
    public static double execute(ItemStack itemstack) {
        if (itemstack.getCount() == 1) {
            return 1.0;
        }
        if (itemstack.getCount() == 2) {
            return 2.0;
        }
        if (itemstack.getCount() == 3) {
            return 3.0;
        }
        if (itemstack.getCount() == 4) {
            return 4.0;
        }
        if (itemstack.getCount() == 5) {
            return 5.0;
        }
        return itemstack.getCount() >= 6 ? 6.0 : 0.0;
    }
}

