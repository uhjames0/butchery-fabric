package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class IntestinesItem
extends Item {
    public IntestinesItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f).build()));
    }
}

