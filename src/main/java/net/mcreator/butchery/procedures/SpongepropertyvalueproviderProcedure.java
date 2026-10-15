package net.mcreator.butchery.procedures;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

public class SpongepropertyvalueproviderProcedure {
    public static double execute(ItemStack itemstack) {
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 1.0) {
            return 1.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 2.0) {
            return 2.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 3.0) {
            return 3.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 4.0) {
            return 4.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 5.0) {
            return 5.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 6.0) {
            return 6.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 7.0) {
            return 7.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 8.0) {
            return 8.0;
        }
        if (((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 9.0) {
            return 9.0;
        }
        return ((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDoubleOr("spongeWetness", 0.0) == 10.0 ? 10.0 : 0.0;
    }
}

