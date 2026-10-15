package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedhorsemeatItem
extends Item {
    public CookedhorsemeatItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(11).saturationModifier(0.4f).build()));
    }
}

