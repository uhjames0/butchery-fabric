package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RawbeefminceItem
extends Item {
    public RawbeefminceItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build()));
    }
}

