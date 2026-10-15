package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RawlambminceItem
extends Item {
    public RawlambminceItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()));
    }
}

