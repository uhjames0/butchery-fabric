package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedravagermeatItem
extends Item {
    public CookedravagermeatItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(14).saturationModifier(0.3f).build()));
    }
}

