package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CookedwitchmeatItem
extends Item {
    public CookedwitchmeatItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(13).saturationModifier(0.3f).build()));
    }

    public boolean isFoil(ItemStack itemstack) {
        return true;
    }
}

