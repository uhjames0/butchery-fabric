package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookeddolphinmeatItem
extends Item {
    public CookeddolphinmeatItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.3f).build()));
    }
}

