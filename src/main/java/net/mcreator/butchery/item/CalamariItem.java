package net.mcreator.butchery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CalamariItem
extends Item {
    public CalamariItem(Item.Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.3f).build()));
    }
}

